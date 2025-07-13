package org.example.controller;

import org.example.view.CourseListPanel;
import org.example.view.InputPanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CourseTableController {

    private final CourseListPanel listPanel;
    private final InputPanel inputPanel;

    public CourseTableController(CourseListPanel listPanel, InputPanel inputPanel) {
        this.listPanel = listPanel;
        this.inputPanel = inputPanel;

        attachMouseListener();
    }

    private void attachMouseListener() {
        JTable table = listPanel.getTable();
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    String subject = table.getValueAt(row, 0).toString();
                    String credit = table.getValueAt(row, 1).toString();
                    String day = table.getValueAt(row, 2).toString();
                    String start = table.getValueAt(row, 3).toString();
                    String time = table.getValueAt(row, 4).toString();

                    inputPanel.setInputFields(subject, credit, day, start, time);
                }
            }
        });
    }
}
