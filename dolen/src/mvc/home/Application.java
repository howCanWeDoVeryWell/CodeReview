package mvc.home;

import mvc.home.controller.Controller;
import mvc.home.model.Model;
import mvc.home.view.View;

public class Application {
    private View view;
    private Model model;
    private Controller controller;
    
    public Application () {
        this.model = new Model();
        this.view = new View(this.model.getData());
        this.controller = new Controller(model, view);
    }
    
    public static void main(String[] args) {
        new Application();
    }
}
