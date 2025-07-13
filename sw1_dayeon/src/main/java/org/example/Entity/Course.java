package org.example.Entity;

public class Course {

    private String name; // 과목명
    private float credit; // 학점
    private String day ; // 요일
    private int start; // 시작시간
    private int time ; // 강의시간
    private boolean valid = true; // 유효한 과목인지 저장


    Course(String[] tokens) {
        this.name = getName(tokens);
        this.credit = getCredit(tokens);

        this.day = getDay(tokens);
        if (isDayError(day)) {
            valid = false;
            return;
        }

        this.start = getStart(tokens);
        if (isStartError(start)) {
            valid = false;
            return;
        }

        this.time = getTime(tokens);
    }

    Course(String name, float credit, String day, int start, int time) {
        this.name = name;
        this.credit = credit;
        this.day = day;
        this.start = start;
        this.time = time;
    }

    public boolean isValid() {
        return valid;
    }

    private boolean isStartError(int start) {
        if (start < 1 || start > 9) {
            System.out.println("Unresolved hour -- " + start);
            return true;
        }
        return false;
    }

    private boolean isDayError(String day) {
        switch (day) {
            case "Mon":
            case "Tue":
            case "Wed":
            case "Thu":
            case "Fri":
                return false;
            default:
                System.out.println("Unknown date -- " + day);
                return true;
        }
    }

    private String getName(String[] tokens){
        return tokens[0].trim();
    }

    private Float getCredit(String[] tokens){
        return Float.parseFloat(tokens[1].trim());
    }

    private String getDay(String[] tokens){
        return tokens[2].trim();
    }

    private Integer getTime(String[] tokens){
        return Integer.parseInt(tokens[4].trim());
    }

    private Integer getStart(String[] tokens){
        return Integer.parseInt(tokens[3].trim());
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
        System.out.println("Course Name: " + name);
        System.out.println("Credit: " + credit);
        System.out.println("Day: " + day);
        System.out.println("Start: " + start);
        System.out.println("Time: " + time);
    }
}
