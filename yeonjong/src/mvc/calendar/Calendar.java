package mvc.calendar;

import mvc.calendar.controller.Controller;
import mvc.calendar.model.Model;
import mvc.calendar.view.View;

public class Calendar {
    private View view;
    private Model model;

    public Calendar() {
        this.model = new Model();
        this.view = new View(this.model);
        new Controller(this.model, this.view);
    }
    public static void main(String [] args) {
        new Calendar();
    }
}
