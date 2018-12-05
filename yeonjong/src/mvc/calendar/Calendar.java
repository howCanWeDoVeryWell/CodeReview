package mvc.calendar;

import mvc.calendar.controller.Controller;
import mvc.calendar.model.Model;
import mvc.calendar.view.View;

public class Calendar {
    public Calendar() {
        Model model = new Model();
        new Controller(model, new View(model));
    }
    public static void main(String [] args) {
        new Calendar();
    }
}
