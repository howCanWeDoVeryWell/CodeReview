package mvc.calendar.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Map;

public class FilterRenderer extends DefaultTableCellRenderer {
    private Map<Integer, String> schedules;

    public FilterRenderer(Map<Integer, String> schedules) {
        this.schedules = schedules;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Integer date = (Integer) table.getValueAt(row, column);

        if (date != null) {
            setOpaque(false);
            this.schedules.entrySet().stream().filter(schedule -> (this.schedules.containsKey(date))).forEach(schedule -> {
                component.setBackground(Color.RED);
                setOpaque(true);
            });
        } else {
            setOpaque(false);
        }
        return component;
    }
}
