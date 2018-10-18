package observer;

public class View1 implements Observer {
    @Override
    public void update(String message) {
        System.out.println("View1: " + message);
    }
}
