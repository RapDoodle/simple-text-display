/**
 * The renderer for colorComboBox in the panel PanelPreference
 *
 * @author Bohui WU
 * @since 12/22/2019
 */

package ink.repo.textdisplay.util;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class ColorfulListRenderer extends DefaultListCellRenderer {

    // The color table
    Hashtable<Integer, Color> table;

    public ColorfulListRenderer(Hashtable<Integer, Color> table) {
        this.table = table;
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList jc, Object val, int idx, boolean isSelected,
                                                  boolean cellHasFocus) {
        setText(val.toString());
        Color color = table.get(idx);
        if(color != null) {
            // Calculate the inverse of the given color
            setForeground(new Color(Math.abs(255 - color.getRed()),
                    Math.abs(255 - color.getGreen()),
                    Math.abs(255 - color.getBlue())
                    )
            );
        }
        setBackground(color);
        return this;
    }

}
