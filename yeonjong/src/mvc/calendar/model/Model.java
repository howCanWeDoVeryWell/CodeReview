package mvc.calendar.model;

import java.util.*;

public class Model {
    private Calendar calendar = Calendar.getInstance();
    public Map<Integer, Map<Integer, Map<Integer, String>>> schedules = new HashMap<>();

    public Calendar getCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.set(this.calendar.get(Calendar.YEAR), this.calendar.get(Calendar.MONTH), this.calendar.get(Calendar.DATE));
        return cal;
    }

    public void nextMonth() {
        this.calendar.add(Calendar.MONTH, 1);
    }

    public void previousMonth() {
        this.calendar.add(Calendar.MONTH, -1);
    }

    public void addSchedules(int selectedDay, String contents) {
        int year = this.calendar.get(Calendar.YEAR);
        int month = this.calendar.get(Calendar.MONTH) + 1;
        Map<Integer, Map<Integer, String>> yearMap = this.schedules.get(year);
        if (yearMap == null) {
            this.schedules.put(year, new HashMap<>());
        }

        Map<Integer, String> monthMap = this.schedules.get(year).get(month);
        if (monthMap == null) {
            this.schedules.get(year).put(month, new HashMap<>());
        }
        this.schedules.get(year).get(month).put(selectedDay, contents);
    }
}