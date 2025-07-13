package org.example.view;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    public JTextField subjectField = new JTextField();
    public JTextField creditField = new JTextField();
    public JComboBox<String> dayComboBox = new JComboBox<>(new String[]{"Mon", "Tue", "Wed", "Thu", "Fri"});
    public JTextField startField = new JTextField();
    public JTextField timeField = new JTextField();

    public InputPanel() {
        setLayout(new GridLayout(2, 5, 5, 5));

        add(new JTextField("과목명"));
        add(new JTextField("학점"));
        add(new JTextField("요일"));
        add(new JTextField("시작 교시"));
        add(new JTextField("시간"));

        add(subjectField);
        add(creditField);
        add(dayComboBox);
        add(startField);
        add(timeField);

        setReadOnly(true);
    }

    // 필요하면 선택된 요일 가져오기
    public String getSelectedDay() {
        return (String) dayComboBox.getSelectedItem();
    }

    public void setInputFields(String subject, String credit, String day, String start, String time) {
        subjectField.setText(subject);
        creditField.setText(credit);
        dayComboBox.setSelectedItem(day);
        startField.setText(start);
        timeField.setText(time);
    }

    public void setReadOnly(boolean readonly) {
        subjectField.setEditable(!readonly);
        creditField.setEditable(!readonly);
        startField.setEditable(!readonly);
        timeField.setEditable(!readonly);
        dayComboBox.setEnabled(!readonly);
    }

}
