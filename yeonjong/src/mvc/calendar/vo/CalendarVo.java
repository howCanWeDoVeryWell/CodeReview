package mvc.calendar.vo;

import chapter04.StringParser;

public class CalendarVo {
    private int year;
    private int month;
    private String [] week;

    public CalendarVo(int year, int month, String [] week) {
        this.year = year;
        this.month = month;
        this.week = week;
    }

    public int getYear() {
        return this.year;
    }

}
