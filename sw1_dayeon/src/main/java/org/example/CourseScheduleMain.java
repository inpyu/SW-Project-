package org.example;

import org.example.Entity.CourseSchedule;
import org.example.controller.CourseButtonController;

import javax.swing.*;
import java.net.InetAddress;
import java.time.LocalDateTime;
import org.example.view.ButtonPanel;
import org.example.view.CourseScheduleSection;

public class CourseScheduleMain {
    public static void main(String[] args) throws Exception {
        System.out.println("");
        System.out.println("At " + LocalDateTime.now());
        System.out.println("By " + System.getProperty("user.name") + " at " + InetAddress.getLocalHost().getHostName());
        System.out.println("");

        JFrame frame = new JFrame("Planning Course Schedule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 1200);

        ButtonPanel buttonPanel = new ButtonPanel();
        CourseSchedule schedule = new CourseSchedule("myschedule-dump.data");
        CourseScheduleSection courseSection = new CourseScheduleSection(schedule, buttonPanel);

        frame.add(courseSection); // CENTER로 자동 배치
        new CourseButtonController(frame, courseSection, buttonPanel);

        frame.setVisible(true);
    }
}
