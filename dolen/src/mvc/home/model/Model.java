package mvc.home.model;

public class Model {
    private String data;

    public Model(String data) {
        this.data = data;
    }

    public void mainDataUpdate (String data) {
        this.setData(data);
    }

    public void topDataUpdate (String data) {
        this.setData(data);
    }

    public Model getData () {
        return new Model(this.data);
    }

    private void setData (String data) {
        if (!this.data.equals(data)) {
            this.data = data;
        }
    }
}
