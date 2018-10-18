package mvc.calendar.view;

import mvc.calendar.model.Model;
import mvc.calendar.vo.CalendarVo;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Model model;
    private JLabel jLabel;
    private int year;
    private Container container;

    public View(Model model) {
        this.model = model;
        this.jLabel = new JLabel();

        this.setBounds(200, 200, 400,300);
        this.jLabel.setBounds(250, 250, 100, 100);
        this.add(this.jLabel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.render();
        this.setVisible(true);
    }

    public void render() {
        CalendarVo vo = this.model.getCalendar();
        this.jLabel.setText(String.valueOf(vo.getYear()));
    }
}
