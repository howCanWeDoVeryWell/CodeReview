package mvc.home;

import mvc.home.controller.Controller;
import mvc.home.model.Model;
import mvc.home.view.MainComponent;
import mvc.home.view.TopComponent;

public class Application {
    public static void main(String[] args) {
        Model model = new Model("initialize data but this data don't have to be String. The type of the object is much better.");
        TopComponent topComponent = new TopComponent();
        MainComponent mainComponent = new MainComponent();
        new Controller(model, topComponent, mainComponent);
    }
}