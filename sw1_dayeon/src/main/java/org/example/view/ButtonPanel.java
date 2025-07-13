package org.example.view;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    public JButton showListButton = new JButton("Show List");
    public JButton addButton = new JButton("Add");
    public JButton deleteButton = new JButton("Delete");
    public JButton loadButton = new JButton("Load");
    public JButton saveButton = new JButton("Save");

    public ButtonPanel() {
        setLayout(new GridLayout(5, 1, 5, 5));
        add(showListButton);
        add(addButton);
        add(deleteButton);
        add(loadButton);
        add(saveButton);
    }
}

