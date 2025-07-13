package org.example.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.example.Entity.Course;
import org.example.Entity.CourseSchedule;

public class CourseListPanel extends JPanel {

    private JTable table;
    private final String[] columns = {"과목명", "학점", "요일", "시작교시", "시간"};

    public CourseListPanel(Object[][] data) {
        setLayout(new BorderLayout());

        table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static Object[][] getTableData(CourseSchedule courseSchedule) {
        Object[][] data = new Object[courseSchedule.getCourses().size()][5];
        for (int i = 0; i < courseSchedule.getCourses().size(); i++) {
            Course course = courseSchedule.getCourses().get(i);
            data[i][0] = course.getName();
            data[i][1] = course.getCredit();
            data[i][2] = course.getDay();
            data[i][3] = course.getStart();
            data[i][4] = course.getTime();
        }
        return data;
    }

    public JTable getTable() {
        return table;
    }
}
