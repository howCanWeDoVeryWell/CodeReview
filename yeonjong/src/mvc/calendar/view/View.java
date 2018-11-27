package mvc.calendar.view;

import mvc.calendar.model.Model;
import mvc.calendar.util.FilterRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

public class View extends JFrame {
    public static final String PREV_BTN_TEXT = "<";
    public static final String NEXT_BTN_TEXT = ">";
    private final List<String> DAY_OF_THE_WEEK = new ArrayList<>(Arrays.asList("Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"));
    private final int WEEK = 6;
    private Model model;
    private JPanel panel;
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

        this.panel = new JPanel();
        this.panel.setLayout(new BorderLayout());
        this.calendarTitle = new JLabel();
        this.calendarTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.preBtn = new JButton(PREV_BTN_TEXT);
        this.nextBtn = new JButton(NEXT_BTN_TEXT);
        this.defaultTableModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.defaultTableModel.setColumnIdentifiers(this.DAY_OF_THE_WEEK.toArray());
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
        this.calendarTitle.setText(calendar.get(Calendar.YEAR) + "년 " + (calendar.get(Calendar.MONTH) + 1) + "월");

        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        int startWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int lastDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        this.defaultTableModel.setRowCount(0);
        IntStream.range(0, this.WEEK).forEach(i -> {
            List<Integer> list = new ArrayList<>();
            IntStream.range(0, this.DAY_OF_THE_WEEK.size()).forEach(j -> {
                int date = i * this.DAY_OF_THE_WEEK.size() + j - startWeek + 1;
                if (i == 0 && j < startWeek || date > lastDate) {
                    list.add(null);
                } else {
                    this.model.schedules.entrySet().forEach(item -> {
                        Map<Integer, String> schedule = new HashMap<>();
                        int year = calendar.get(Calendar.YEAR);
                        int month = calendar.get(Calendar.MONTH) + 1;
                        if (this.model.schedules.get(year) != null && this.model.schedules.get(year).get(month) != null) {
                            this.model.schedules.get(year).get(month).keySet().forEach(key -> {
                                schedule.put(key, this.model.schedules.get(year).get(month).get(key));
                            });
                        }
                        IntStream.range(0, this.table.getColumnModel().getColumnCount()).forEach(column -> {
                            this.table.getColumnModel().getColumn(column).setCellRenderer(new FilterRenderer(schedule));
                        });
                    });
                    list.add(date);
                }
            });
            this.defaultTableModel.addRow(list.toArray());
        });

        this.add(this.pane, BorderLayout.CENTER);
    }
}
