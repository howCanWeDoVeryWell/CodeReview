package observer;

public class View2 implements Observer {
    @Override
    public void update(String message) {
        System.out.println("View2: " + message);
    }

    @Override
    public void update(String event, String message) {

    }
}
