package org.example;

import java.io.File;
import java.util.Scanner;

public class CourseSchedule {

    Course[] courses = new Course[10]; // 과목 배열
    int count = 0 ; // 과목 개수

    CourseSchedule(String filename) throws Exception {
        File file = new File(filename);

        if(!isFileExist(filename)) { // 파일 존재 여부 체크
            System.out.println("Unknwon File " + filename);
            return; // 파일이 없으면 종료
        }

        Scanner input = new Scanner(file);
        while(input.hasNext()){
            String line = input.nextLine();
            if(line.startsWith("//") || line.trim().isEmpty()) continue; // 주석 무시
            String[] tokens = modifyFormat(line); // 형식 수정
            Course course = new Course(tokens);
            if (!course.isValid()) continue; // 유효하지 않으면 건너뜀

            if (isConflict(course)) { // 시간 충돌 체크
                continue; // 충돌이 있으면 다음 줄로 넘어감
            }

            courses[count] = course; // 과목 배열에 추가
            count++; // 과목 개수 증가
        }
    }

    private String[] modifyFormat(String string){
        String removeSpace = string.replaceAll(" ", ""); // 공백 제거
        String[] line = removeSpace.split(":");
        if (line.length != 5) {
            System.out.println("Irregular schedule line -- " + string);
            String newLine = removeSpace.replaceAll("::", ":");
            return newLine.split(":");
        }
        return line;
    }

    private boolean isFileExist(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    private boolean isConflict(Course course) {
        for (int i = 0; i < count; i++) {
            Course c = courses[i];
            if (c.getDay().equals(course.getDay())) { // 요일이 같으면
                if (c.getStart() < course.getStart() + course.getTime() && c.getStart() + c.getTime() > course.getStart()) {
                    System.out.println("Conflict hour -- " + course.getDay() + " " + course.getStart());
                    return true; // 충돌이 있으면 true
                }
            }
        }
        return false; // 충돌이 없으면 false
    }

    public Course getCourse(int i){
        return courses[i];
    }

    public void print() {
        printDays(); // 요일 출력
        printTable(); // 시간표 출력
    }

    private String[][] getTable(){
        String[][] table = new String[9][5]; // 9교시 x 5일

        // 과목들을 시간표에 채워 넣기
        for (int i = 0; i < count; i++) {
            Course c = courses[i];
            int dayIndex = getDayIndex(c.getDay()); // 요일 인덱스 (Mon=0, Tue=1,...)
            int start = c.getStart() - 1; // 시간대 인덱스 (1교시는 0번 인덱스)

            for (int t = 0; t < c.getTime(); t++) {
                table[start + t][dayIndex] = c.getName(); // 교시 위치에 과목명 입력
            }
        }
        return table;
    }

    private void printDays(){
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};
        // 헤더 출력
        System.out.printf("%-5s", "");
        for (String d : days) {
            System.out.printf("%-7s", d);
        }
        System.out.println();
        // 구분선 출력
        System.out.println("----------------------------------");
    }

    private void printTable(){

        String[][] table = getTable(); // 시간표 배열
        // 시간표 출력
        for (int i = 0; i < 9; i++) {
            System.out.printf("%-5d", i + 1);
            for (int j = 0; j < 5; j++) {
                String subject = table[i][j];
                if (subject != null) {
                    System.out.printf("%-7s", subject);
                } else {
                    System.out.printf("%-7s", "");
                }
            }
            System.out.println();
        }
    }

    private int getDayIndex(String day) {
        switch (day) {
            case "Mon": return 0;
            case "Tue": return 1;
            case "Wed": return 2;
            case "Thu": return 3;
            case "Fri": return 4;
            default: return -1;
        }
    }

}
