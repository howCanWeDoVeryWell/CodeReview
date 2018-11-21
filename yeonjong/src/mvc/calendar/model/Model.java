package mvc.calendar.model;

import sun.awt.geom.AreaOp;

import java.util.*;
import java.util.stream.Collectors;

public class Model {
    private Calendar calendar = Calendar.getInstance();
    public Map<Integer, Map<Integer, Map<Integer, String>>> schedules = new HashMap<>();

    // TODO?
    private List<List<Integer>> dates;

    public Model() {
        this.setDates();
    }

    // TODO  calendar를 반환할 것
    public Calendar getCalendar() {
        return this.calendar;
    }

    public void nextMonth() {
        this.calendar.add(Calendar.MONTH, 1);
    }

    public void previousMonth() {
        this.calendar.add(Calendar.MONTH, -1);
    }


    // TODO 사용 여부
    public void setDates() {
        Calendar cal = Calendar.getInstance();
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

    // TODO test DAta -----------------------------------------
    public List<Integer> getAppointmentDates () {
        List<Integer> dates = new ArrayList<>();
//        this.schedules.forEach(schedules -> {
//            schedules.keySet().forEach(key -> {
//                dates.add(Integer.parseInt(key));
//            });
//        });

        List<Integer> list = dates.stream().map(v -> v + 1).collect(Collectors.toList());
        return dates;
    }


    public void test() {
        List<Integer> a = new ArrayList<Integer>() {{
            this.add(1);
            this.add(2);
            this.add(3);
        }};

        List<Integer> b = new ArrayList<Integer>() {{
            this.add(1);
            this.add(2);
        }};

        a.forEach(integer -> {
            a.add(3);
        });
    }
}

/*

Map<Integer, Map<Integer, Map<Inger, List<String>>>>


{
   2018: {
    1 : {
        17: 'asd',
        20: 'asd',
    },
    2 : {
        17: 'asd',
        20: 'asd',
    }
   },
   2017: {
    1 : {
        17: 'asd',
        20: 'asd',
    },
    2 : {
        17: 'asd',
        20: 'asd',
    }
   }
}







 */