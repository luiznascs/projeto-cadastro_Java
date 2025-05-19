package prova;

import javax.swing.*;

public abstract class Win extends JFrame {
    public Win(String title, int x, int y, int width, int height, int closing) {
        setupFrame(title, x, y, width, height, closing);
        setupComponents();
        setVisible(true);
    }
    public Win(String title, int width, int height, int closing) {

        this(title, -1, -1, width, height, closing);
    }
    private void setupFrame(String title, int x, int y, int width, int height, int closing) {
        setTitle(title);
        setDefaultCloseOperation(closing);
        setSize(width, height);
        if (x == -1 & y == -1) {
            setLocationByPlatform(true);
        } else {
            setLocation(x, y);
        }
    }
    protected abstract void setupComponents();
}
