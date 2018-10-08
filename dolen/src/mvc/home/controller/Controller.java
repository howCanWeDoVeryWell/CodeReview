package mvc.home.controller;

import mvc.home.model.Model;
import mvc.home.view.View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller implements ListSelectionListener {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.bindEvents();
    }
    
    private void bindEvents () {
        this.view.addEventListener(this);
    } 
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object source = e.getSource();
        if (source instanceof JList) {
            this.removeMember((JList) source);
        }
    }
    
    private void removeMember (JList source) {
        String selectedValue = (String) source.getSelectedValue();
        if (selectedValue == null) {
            return;
        }
        /**
         * 여기에 옵저버 패턴을 적용하면 컨트롤러가 뷰를 갱신시키지 않아도 된다. 
         */
        this.model.removeMember(selectedValue);
        this.view.render();
    }
}
