package mvc.home.controller;

import mvc.home.model.Model;
import mvc.home.view.MainComponent;
import mvc.home.view.TopComponent;

import java.awt.*;

public class Controller {
    private Model model;
    private TopComponent topComponent;
    private MainComponent mainComponent;

    public Controller(Model model, TopComponent topComponent, MainComponent mainComponent) {
        this.model = model;
        this.topComponent = topComponent;
        this.mainComponent = mainComponent;

        this.addEventListener();
    }

    private void addEventListener () {
        // Add some events.
        // 유저가 이벤트를 발생시키면 eventListener 호출하도록 구현.
    }

    private void eventListener (Event event) {
        if (event.target.equals(this.mainComponent)) {
            this.model.mainDataUpdate("update data for mainComponent.");
            this.render();
        } else if (event.target.equals(this.topComponent)) {
            this.model.topDataUpdate("update data for topComponent.");
            this.render();
        }
    }

    private void render () {
        Model model = this.model.getData();
        this.mainComponent.render(model);
        this.topComponent.render(model);
    }
}
