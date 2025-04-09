package org.example;

public class Course {

    private String name; // 과목명
    private float credit; // 학점
    private String day ; // 요일
    private int start; // 시작시간
    private int time ; // 강의시간

    Course(String name, float credit, String day, int start, int time) {
        this.name = name;
        this.credit = credit;
        this.day = day;
        this.start = start;
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public float getCredit() {
        return credit;
    }

    public String getDay() {
        return day;
    }

    public int getStart() {
        return start;
    }

    public int getTime() {
        return time;
    }

    public void print(){

    }
}
