package org.example.view;

import javax.swing.*;
import java.awt.*;
import org.example.Entity.CourseSchedule;
import org.example.controller.CourseTableController;

public class CourseScheduleSection extends JPanel {
    private CourseSchedule schedule;
    private InputPanel inputPanel;
    private JTextField myCoursesField;
    private CourseListPanel listPanel;
    private ScheduleTablePanel tablePanel;
    private ButtonPanel buttonPanel;

    public CourseScheduleSection(CourseSchedule schedule, ButtonPanel buttonPanel) {
        this.schedule = schedule;
        this.buttonPanel = buttonPanel;

        setLayout(new BorderLayout());

        initializeTopPanel();
        updatePanels();
    }

    private void initializeTopPanel() {
        inputPanel = new InputPanel();
        myCoursesField = new JTextField("My Courses");
        myCoursesField.setEditable(false);
    }

    public void updatePanels() {
        removeAll();

        Object[][] data = CourseListPanel.getTableData(schedule);
        listPanel = new CourseListPanel(data);
        tablePanel = new ScheduleTablePanel(data);

        // 입력 + 리스트를 왼쪽에 묶기
        JPanel inputAndListPanel = new JPanel();
        inputAndListPanel.setLayout(new BoxLayout(inputAndListPanel, BoxLayout.Y_AXIS));
        inputAndListPanel.add(inputPanel);
        inputAndListPanel.add(myCoursesField);
        inputAndListPanel.add(listPanel);

        // 위쪽 전체 묶기: 입력+리스트 + 버튼
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputAndListPanel, BorderLayout.CENTER); // 왼쪽 입력
        topPanel.add(buttonPanel, BorderLayout.EAST);         // 오른쪽 버튼

        // 상단 패널 (입력 + 버튼), 하단 시간표
        add(topPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);

        new CourseTableController(listPanel, inputPanel);

        revalidate();
        repaint();
    }

    public void setSchedule(CourseSchedule schedule) {
        this.schedule = schedule;
        updatePanels();
    }

    public CourseSchedule getSchedule() {
        return schedule;
    }

    public InputPanel getInputPanel() {
        return inputPanel;
    }

    public CourseListPanel getListPanel() {
        return listPanel;
    }
}
