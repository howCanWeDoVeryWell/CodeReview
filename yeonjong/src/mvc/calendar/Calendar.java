package mvc.calendar;

import mvc.calendar.model.Model;
import mvc.calendar.view.View;

public class Calendar {
    private View view;
    private Model model;

    public Calendar() {
        this.model = new Model();
        this.view = new View(this.model);
    }

    public static void main(String [] args) {
        new Calendar();
    }
}
