package prova;

import javax.swing.*;
import java.awt.*;

public class Oficina extends Win {
    public Oficina() {
        super("Oficina", 500, 500, JFrame.EXIT_ON_CLOSE);
    }
    @Override
    protected void setupComponents() {
        setLayout(new GridLayout(2, 3, 2, 2));
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("dois");
        JButton b3 = new JButton("3333333");
        JButton b4 = new JButton("44");
        JButton b5 = new JButton("cinco");
        JButton b6 = new JButton("6666");
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
    }
}
