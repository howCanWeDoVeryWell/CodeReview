package mvc.calendar.controller;

import mvc.calendar.model.Model;
import mvc.calendar.view.View;

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
            this.onClickJButton(((JButton) o).getText());
        }

        this.view.render();
    }

    private void onClickJTable (MouseEvent e) {
        JTable table = (JTable) e.getSource();
        int row = table.rowAtPoint(e.getPoint());
        int column = table.columnAtPoint(e.getPoint());
        int selectedDay = (int) table.getValueAt(row, column);
        System.out.println("[selectedDay]" + selectedDay);
        if (selectedDay != 0) {
            String contents = JOptionPane.showInputDialog(selectedDay + "일의 일정을 입력해주세요 :p");
            if (contents != null) {
                this.model.addSchedules(selectedDay, contents);
            }
        }

//        if (selectedDay != null) {
//            if (!this.model.isStoredSchedule(selectedDay)) {
//                String contents = JOptionPane.showInputDialog(selectedDay + "일의 일정을 입력해주세요 :p");
//                System.out.println(contents);
//                if (contents != null) {
//                    this.model.addSchedules(selectedDay, contents);
//                }
//            } else {
//                this.model.removeSchedule(selectedDay);
//            }
//        }
    }

    private void onClickJButton(String buttonText) {
        if (View.NEXT_BTN_TEXT.equals(buttonText)) {
            this.model.nextMonth();
            this.model.setDates();
        } else if (View.PREV_BTN_TEXT.equals(buttonText)) {
            this.model.previousMonth();
            this.model.setDates();
        }
    }

    private void showAppointment () {}
    private void showAddingAppointment () {}
}
