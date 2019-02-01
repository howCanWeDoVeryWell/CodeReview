package observer;

public class View3 implements Observer {
    @Override
    public void update(String message) {
        System.out.println("View3: " + message);
    }

    @Override
    public void update(String event, String message) {

    }
}
