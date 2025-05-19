package prova;

import javax.swing.*;

public class RowPanel extends JPanel {
    private int x, y, gap;
    public RowPanel(int gap) {
        setLayout(null);
        this.x = this.y = this.gap = gap;
    }
    protected void addRow(JComponent... components) {
        int h = 0;
        for (JComponent component : components) {
            component.setSize(component.getPreferredSize());
            if (component.getSize().height > h) {
                h = component.getSize().height;
            }
        }
        for (JComponent component : components) {
            component.setLocation(x, y + (h - component.getSize().height) / 2);
            add(component);
            x += component.getSize().width + gap;
        }
        x = gap;
        y += h + gap;
    }
}
