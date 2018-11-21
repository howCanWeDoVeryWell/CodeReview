package mvc.calendar.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Map;

public class FilterRenderer extends DefaultTableCellRenderer {
    private Map<Integer, String> selected;

    public FilterRenderer(Map<Integer, String> selected) {
        this.selected = selected;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (table.getValueAt(row, column) != null) {
            System.out.println("?" + this.selected.size());
            int columnValue = (int) table.getValueAt(row, column);
            for (int i = 0; i < this.selected.size(); i++) {
                if (this.selected.containsKey(columnValue)) {
                    c.setBackground(Color.RED);
                    setOpaque(true);
                    return c;
                } else {
                    setOpaque(false);
                    return c;
                }
            }
        }
        return  c;
    }
}
