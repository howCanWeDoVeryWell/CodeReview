package mvc.calendar.model;

import java.util.*;

public class Model {
    private Calendar calendar = Calendar.getInstance();
    public Map<Integer, Map<Integer, Map<Integer, String>>> schedules = new HashMap<>();

    public Calendar getCalendar() {
        return this.calendar;
    }

    public void nextMonth() {
        this.calendar.add(Calendar.MONTH, 1);
    }

    public void previousMonth() {
        this.calendar.add(Calendar.MONTH, -1);
    }


    public void addSchedules(int selectedDay, String contents) {

        if (this.schedules.get(this.calendar.get(Calendar.YEAR)) == null) {
            this.schedules.put(this.calendar.get(Calendar.YEAR), new HashMap<>());
        }

        if (this.schedules.get(this.calendar.get(Calendar.YEAR))
                .get(this.calendar.get(Calendar.MONTH) + 1) == null) {
            this.schedules.get(this.calendar.get(Calendar.YEAR))
                    .put(this.calendar.get(Calendar.MONTH) + 1, new HashMap<>());
        }

        this.schedules.get(this.calendar.get(Calendar.YEAR))
                .get(this.calendar.get(Calendar.MONTH) + 1)
                .put(selectedDay, contents);
    }
}