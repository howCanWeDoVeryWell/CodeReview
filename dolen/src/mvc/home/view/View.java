package mvc.home.view;

import mvc.home.model.Model;
import mvc.home.vo.Vo;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class View extends JFrame {
    private Model model;
    private JList list; 
    
    public View (Model model) {
        this.model = model;
        setSize(600, 300);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.list = new JList();
        this.add(new JScrollPane(this.list), "Center");
        this.setVisible(true);
    }
    
    public void addEventListener (ListSelectionListener listener) {
        this.list.addListSelectionListener(listener);
    }
    
    public void render () {
        Vo vo = this.model.getData();
        this.list.setListData(vo.getMembers());
    }
}
