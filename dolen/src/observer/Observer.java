package observer;

public interface Observer {
    public void update(String message);
    public void update(String event, String message);
}
