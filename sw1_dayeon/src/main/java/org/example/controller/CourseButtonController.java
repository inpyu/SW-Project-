package org.example.controller;

import org.example.view.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import org.example.Entity.CourseSchedule;

public class CourseButtonController {
    private final CourseScheduleSection courseSection;
    private final ButtonPanel buttonPanel;
    private final JFrame frame;

    public CourseButtonController(JFrame frame, CourseScheduleSection courseSection, ButtonPanel buttonPanel) {
        this.frame = frame;
        this.courseSection = courseSection;
        this.buttonPanel = buttonPanel;

        addListeners();
    }

    private void addListeners() {
        buttonPanel.showListButton.addActionListener(e -> showCourseList());
        buttonPanel.addButton.addActionListener(e -> addCourse());
        buttonPanel.deleteButton.addActionListener(e -> deleteCourse());
        buttonPanel.loadButton.addActionListener(e -> loadCourses());
        buttonPanel.saveButton.addActionListener(e -> saveCourses());
    }

    private void showCourseList() {
        try {
            CourseSchedule schedule = new CourseSchedule("myschedule-norm.data");
            JFrame frame2 = new JFrame("Course List");
            frame2.setSize(500, 300);
            frame2.setLayout(new BorderLayout());

            InputPanel inputPanel = courseSection.getInputPanel();
            CourseListPanel listPanel = new CourseListPanel(
                    CourseListPanel.getTableData(schedule)
            );

            new CourseTableController(listPanel, inputPanel);

            frame2.add(new JTextField("List of Courses - Click to Select"), BorderLayout.NORTH);
            frame2.add(listPanel, BorderLayout.CENTER);
            frame2.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error loading schedule: " + ex.getMessage());
        }
    }

    private void addCourse() {
        try {
            InputPanel inputPanel = courseSection.getInputPanel();
            String name = inputPanel.subjectField.getText().trim();
            String creditText = inputPanel.creditField.getText().trim();
            String day = inputPanel.getSelectedDay();
            String startText = inputPanel.startField.getText().trim();
            String timeText = inputPanel.timeField.getText().trim();

            if (name.isEmpty() || creditText.isEmpty() || startText.isEmpty() || timeText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "모든 필드를 입력해주세요.");
                return;
            }

            float credit = Float.parseFloat(creditText);
            int start = Integer.parseInt(startText);
            int time = Integer.parseInt(timeText);

            courseSection.getSchedule().addCourse(name, credit, day, start, time);
            courseSection.updatePanels();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "학점, 시작 교시, 시간은 숫자여야 합니다.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, "과목 추가 실패");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "과목 추가 중 오류 발생: " + ex.getMessage());
        }
    }

    private void deleteCourse() {
        try {
            CourseListPanel listPanel = courseSection.getListPanel();
            JTable table = listPanel.getTable();
            int selectedRow = table.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "삭제할 과목을 먼저 선택하세요.");
                return;
            }

            String courseName = table.getValueAt(selectedRow, 0).toString();
            courseSection.getSchedule().deleteCourse(courseName);
            courseSection.updatePanels();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "과목 삭제 중 오류 발생: " + ex.getMessage());
        }
    }

    private void loadCourses() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                CourseSchedule newSchedule = new CourseSchedule(selectedFile.getAbsolutePath());
                courseSection.setSchedule(newSchedule);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "파일 불러오기 중 오류 발생: " + ex.getMessage());
        }
    }

    private void saveCourses() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                courseSection.getSchedule().saveToFile(selectedFile);
                JOptionPane.showMessageDialog(frame, "성공적으로 저장되었습니다.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "파일 저장 중 오류 발생: " + ex.getMessage());
        }
    }
}
