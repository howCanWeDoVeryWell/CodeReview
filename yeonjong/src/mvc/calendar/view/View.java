package mvc.calendar.view;

import mvc.calendar.model.Model;
import mvc.calendar.util.FilterRenderer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

public class View extends JFrame {
    private enum DayOfTheWeek {SUN, MON, TUE, WED, THUR, FRI, SAT};
    public enum Buttons {PREV,  NEXT};
    private final int WEEK = 6;
    private Model model;
    private JLabel calendarTitle;
    private JButton preBtn;
    private JButton nextBtn;
    private DefaultTableModel defaultTableModel;
    private JTable table;
    private JScrollPane pane;

    public View(Model model) {
        this.model = model;
        this.setFrame();
        this.render();
    }

    private void setFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        this.calendarTitle = new JLabel();
        this.calendarTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.preBtn = new JButton(Buttons.PREV.toString());
        this.nextBtn = new JButton(Buttons.NEXT.toString());
        this.defaultTableModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.defaultTableModel.setColumnIdentifiers(DayOfTheWeek.values());
        this.table = new JTable(this.defaultTableModel);
        this.table.setRowHeight(50);
        this.pane = new JScrollPane(this.table);

        panel.add(this.calendarTitle, BorderLayout.CENTER);
        panel.add(this.preBtn, BorderLayout.WEST);
        panel.add(this.nextBtn, BorderLayout.EAST);
        this.add(panel, BorderLayout.NORTH);
        this.add(this.pane, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void bindButtonEvents(MouseAdapter listener) {
        this.preBtn.addMouseListener(listener);
        this.nextBtn.addMouseListener(listener);
        this.table.addMouseListener(listener);
    }

    public void render() {
        Calendar calendar = this.model.getCalendar();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        calendar.set(year, month, 1);
        this.calendarTitle.setText(year + "년 " + month + "월");
        this.defaultTableModel.setRowCount(0);

        IntStream.range(0, this.WEEK).forEach(i -> {
            List<Integer> list = new ArrayList<>();
            int startWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            int lastDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            int dayOfTheWeek = DayOfTheWeek.values().length;

            IntStream.range(0, dayOfTheWeek).forEach(j -> {
                int date = i * dayOfTheWeek + j - startWeek + 1;
                if (i == 0 && j < startWeek || date > lastDate) {
                    list.add(null);
                } else {
                    this.setSchedules(this.model.schedules.get(year), month);
                    list.add(date);
                }
            });
            this.defaultTableModel.addRow(list.toArray());
        });
        this.add(this.pane, BorderLayout.CENTER);
    }

    private void setSchedules(Map<Integer, Map<Integer, String>> monthMap, int month) {
        this.model.schedules.entrySet().forEach(item -> {
            Map<Integer, String> schedule = new HashMap<>();
            if (monthMap != null && monthMap.get(month) != null) {
                monthMap.get(month).keySet().forEach(key -> {
                    schedule.put(key, monthMap.get(month).get(key));
                });
            }
            this.setCellFilter(schedule);
        });
    }

    private void setCellFilter(Map<Integer, String> schedule) {
        TableColumnModel tableColumnModel = this.table.getColumnModel();
        IntStream.range(0, tableColumnModel.getColumnCount()).forEach(column -> {
            tableColumnModel.getColumn(column).setCellRenderer(new FilterRenderer(schedule));
        });
    }
}
