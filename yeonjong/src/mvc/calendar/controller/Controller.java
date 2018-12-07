package mvc.calendar.controller;

import mvc.calendar.model.Model;
import mvc.calendar.view.View;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.event.*;

public class Controller extends MouseAdapter {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.bindButtonEvents(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object o = e.getComponent();
        if (o instanceof JTable) {
            this.onClickJTable(e);
        } else if (o instanceof JButton) {
            this.onClickJButton(e);
        }
    }

    private void onClickJTable (MouseEvent e) {
        JTable table = (JTable) e.getSource();
        int selectedDay = (int) table.getValueAt(table.rowAtPoint(e.getPoint()), table.columnAtPoint(e.getPoint()));
        if (selectedDay == 0) {
            return;
        }

        String contents = JOptionPane.showInputDialog(selectedDay + "일의 일정을 입력해주세요 :p");
        if (contents.trim().isEmpty()) {
            return;
        }
        this.model.addSchedules(selectedDay, contents);
        this.view.render();
    }

    private void onClickJButton(MouseEvent e) {
        switch (View.Buttons.valueOf(((JButton) e.getComponent()).getText())) {
            case NEXT:
                this.model.nextMonth();
                break;
            case PREV:
                this.model.previousMonth();
                break;
        }
        this.view.render();
    }
}
