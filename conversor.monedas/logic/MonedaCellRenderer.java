package logic;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import logic.*;

public class MonedaCellRenderer extends BasicComboBoxRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value != null) {
            if (value instanceof Moneda) {
                Moneda moneda = (Moneda) value;
                setText(moneda.getClass().getSimpleName()); // Muestra el nombre de la clase
            }
        }

        return this;
    }
}
