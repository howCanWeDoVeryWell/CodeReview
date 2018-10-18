package mvc.calendar.model;

import mvc.calendar.vo.CalendarVo;

public class Model {
    private int year;
    private int month;
    private String [] week;

    public Model() {
        this.year = this.fetchThisYear();
        this.month = this.fetchThisMonth();
        this.week = this.fetchWeek();
    }

    public int fetchThisYear() {
        return 2018;
    }

    public int fetchThisMonth() {
        return 10;
    }

    public String [] fetchWeek() {
        String [] arr = {"Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun"};
        return arr;
    }

    public CalendarVo getCalendar() {
        return new CalendarVo(this.year, this.month, this.week);
    }
}
