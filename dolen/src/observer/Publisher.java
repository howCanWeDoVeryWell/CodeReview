package observer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publisher {
    public static String ADD = "ADD";
    public static String REMOVE = "REMOVE";

    Map<String, List<Observer>> observer;

    public Publisher() {
        this.observer = new HashMap<String, List<Observer>>();
    }

    public void setAdd (String message) {
        // 데이터를 변경한다.
        // 데이터 변경이 완료되면 전파한다.
        this.publish(Publisher.ADD, message);
    }

    public void setREMOVE (String message) {
        // 데이터를 변경한다.
        // 데이터 변경이 완료되면 전파한다.

        // DB를 다녀왔다.

        this.publish(Publisher.REMOVE, message);
    }

    private void publish (String event, String message) {
        if (event == null || message == null) {
            return;
        }
        this.observer.get(event).stream().forEach(observer -> {
            observer.update(message);
        });
    }

    public void add (String event, Observer observer) {
        if (event == null || observer == null) {
            return;
        }
        List<Observer> observers = this.observer.get(event);

        if (observers == null) {
            observers = new ArrayList<Observer>();
            this.observer.put(event, observers);
        }
        if (observers.contains(observer)) {
            return;
        }
        observers.add(observer);
    }

    public void remove (String event, Observer observer) {
        if (event == null || observer == null) {
            return;
        }

        List<Observer> observers = this.observer.get(event);
        if (observers == null) {
            return;
        }
        observers.remove(observer);
    }

    public static void main(String[] args) {
        Publisher newspaper = new Publisher();

        View1 view1 = new View1();
        View2 view2 = new View2();
        View3 view3 = new View3();

        newspaper.add(Publisher.ADD, view1);
        newspaper.add(Publisher.ADD, view2);
        newspaper.add(Publisher.ADD, view3);

        newspaper.add(Publisher.REMOVE, view3);

        newspaper.setAdd("새로운 신문 A가 발행 되었습니다.");
        newspaper.setREMOVE("새로운 신문 B가 발행 되었습니다.");
    }
}

class Model extends Publisher {}

class TopView implements Observer {
    Model model;

    public TopView(Model model) {
        this.model = model;
        this.bindModel();
        this.render();
    }

    private void bindModel () {
        this.model.add(Publisher.ADD, this);
    }

    private void renderLogin () {

    }

    private void render () {
        System.out.println("나는 탑을 그릴거야.");
    }

    @Override
    public void update(String message) {
        this.render();
    }

    @Override
    public void update(String event, String message) {
        if (event.equals(Publisher.ADD)) {
            this.render();
        }
    }
}

class ContentView implements Observer {
    Model model;

    public ContentView(Model model) {
        this.model = model;
        this.bindModel();
        this.render();
    }

    private void bindModel () {
        this.model.add(Publisher.ADD, this);
    }

    private void render () {
        System.out.println("나는 컨텐츠를 그릴거야.");
    }

    @Override
    public void update(String message) {
        this.render();
    }

    @Override
    public void update(String event, String message) {
        if (event.equals(Publisher.ADD)) {
            this.render();
        }
    }
}

class MainView extends JFrame {
    TopView topView;
    ContentView contentView;

    public MainView (Model model) {
        this.topView = new TopView(model);
        this.contentView = new ContentView(model);
    }
}
