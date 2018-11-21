package mvc.calendar.view;

import mvc.calendar.model.Model;
import mvc.calendar.util.FilterRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.IntStream;

public class View extends JFrame {
    private Model model;
    private JPanel panel;
    private JLabel calendarTitle;
    private JButton preBtn;
    private JButton nextBtn;
    private DefaultTableModel defaultTableModel;
    private JTable table;
    private JScrollPane pane;

    public static final String PREV_BTN_TEXT = "<";
    public static final String NEXT_BTN_TEXT = ">";

    // 배열쓰지말곳
    private final String [] DAY_OF_THE_WEEK = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"}; //요일
    private final int WEEK = 6;

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
        this.defaultTableModel.setColumnIdentifiers(this.DAY_OF_THE_WEEK);
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
        /**
         * 1. 그림을 그릴때 모델에서 Calendar를 get 한다.   OK
         *  - 달력을 그릴 수 있음. 1일도 말일도 알고 있음.
         *  - 년도도 알고, Month도 알 수 있음.
         *  - 이걸로 View는 달력을 그리기만 하면 돼.
         *  - 자기가 아는 방식으로.
         *
         * 2. 이번달 스케줄은 모델이 알고 있음.
         *  - model.getAppointments();
         *  - 이번달 스케쥴이 나옴.
         *  - 달력을 루프돌면서 그리면서 저 스케줄에 해당 날짜가 있으면 빨갛게 칠하면 됌.
         */

        Calendar calendar = this.model.getCalendar();
        this.calendarTitle.setText(calendar.get(Calendar.YEAR) + "년 " + (calendar.get(Calendar.MONTH) + 1) + "월");

        // Model
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        int startWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int lastDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        this.defaultTableModel.setRowCount(0);
        IntStream.range(0, this.WEEK).forEach(i -> {
            List<Integer> list = new ArrayList<>();
            IntStream.range(0, this.DAY_OF_THE_WEEK.length).forEach(j -> {
                int date = i * this.DAY_OF_THE_WEEK.length + j - startWeek + 1;
                if (i == 0 && j < startWeek || date > lastDate) {
                    list.add(null);
                } else {
                    if (this.model.schedules.get(calendar.get(Calendar.YEAR)) != null
                        && this.model.schedules.get(calendar.get(Calendar.YEAR)).get(calendar.get(Calendar.MONTH) + 1) != null) {
                        this.model.schedules.entrySet().forEach(item -> {
                            IntStream.range(0, this.table.getColumnModel().getColumnCount()).forEach(column -> {
                                this.table.getColumnModel().getColumn(column)
                                        .setCellRenderer(new FilterRenderer(this.model.schedules.get(calendar.get(Calendar.YEAR))
                                            .get(calendar.get(Calendar.MONTH) + 1)));
                                }
                            );
                        });

                    }
                    list.add(date);
                }
            });
            this.defaultTableModel.addRow(list.toArray());
        });

        this.model.schedules.entrySet().forEach(System.out::println);

        // set Red
        //this.model.schedules.entrySet().forEach(System.out::println);





//        List<Integer> scheduledDate = new ArrayList<>();
//        vo.getSchedules().forEach(map -> {
//            map.entrySet().stream().forEach(k -> {
//                String [] dates = k. getKey().split("/");
//                if (vo.getYear() == Integer.parseInt(dates[0]) &&
//                    vo.getMonth() == Integer.parseInt(dates[1])) {
//                    scheduledDate.add(Integer.parseInt(dates[2]));
//                }
//            });
//        });
//
//        IntStream.range(0, this.table.getColumnModel().getColumnCount())
//                .forEach(i ->
//                    this.table.getColumnModel().getColumn(i).setCellRenderer(new FilterRenderer(scheduledDate))
//                );
//
        this.add(this.pane, BorderLayout.CENTER);
    }


}
