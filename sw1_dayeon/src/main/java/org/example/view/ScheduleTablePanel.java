package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ScheduleTablePanel extends JPanel {
    public ScheduleTablePanel(Object[][] courseData) {
        setLayout(new BorderLayout());

        String[] days = {"Mon", "Tue", "Wed", "Thr", "Fri"};
        Object[][] schedule = toScheduleTable(courseData);
        JTable table = new JTable(new DefaultTableModel(schedule, days));

        JTable rowHeader = new JTable(new DefaultTableModel(
                new Object[][]{
                        {"1"}, {"2"}, {"3"}, {"4"}, {"5"}, {"6"}, {"7"}, {"8"}, {"9"}
                }, new String[]{""}
        ));
        rowHeader.setEnabled(false);
        rowHeader.setPreferredScrollableViewportSize(new Dimension(30, 0));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setRowHeaderView(rowHeader);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static Object[][] toScheduleTable(Object[][] courseData) {
        Object[][] table = new Object[9][5]; // 9교시 × 5요일

        for (Object[] course : courseData) {
            String name = (String) course[0];
            String day = (String) course[2];
            int start = Integer.parseInt(course[3].toString()) - 1;
            int time = Integer.parseInt(course[4].toString());

            int dayIdx = switch (day) {
                case "Mon" -> 0;
                case "Tue" -> 1;
                case "Wed" -> 2;
                case "Thu" -> 3;
                case "Fri" -> 4;
                default -> -1;
            };

            if (dayIdx == -1 || start < 0 || start + time > 9) continue;

            for (int i = 0; i < time; i++) {
                table[start + i][dayIdx] = name;
            }
        }
        return table;
    }

}
