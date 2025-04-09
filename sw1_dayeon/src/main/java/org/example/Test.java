package org.example;

import java.net.InetAddress;
import java.time.LocalDateTime;

public class Test {
    public Test() {
    }

    public static void main(String[] args) throws Exception {
        System.out.println("");
        System.out.println("** Course Schedule Required Tests **");
        System.out.println("");
        System.out.println("At " + LocalDateTime.now().toString());
        System.out.println("By " + System.getProperty("user.name") + " at " + InetAddress.getLocalHost().getHostName());
        System.out.println("");
        System.out.println("Case1: Normal Input  ");
        CourseSchedule case1 = new CourseSchedule("myschedule-norm.data");
        System.out.print("2nd Course Information :: ");
        case1.getCourse(1).print();
        case1.print();
        System.out.println("End of Case1");
        System.out.println("");
        System.out.println("Case2: Check Trimming  ");
        CourseSchedule case2 = new CourseSchedule("myschedule-trim.data");
        case2.print();
        System.out.println("End of Case2");
        System.out.println("");
        System.out.println("");
        System.out.println("*** Test Reactions on Abnormal Inputs ***");
        System.out.println("Your Answer (your program's reaction) should be similar to the Correct Answer");
        System.out.println("");
        System.out.println("Case3: Check Hour Conflicts ");
        System.out.println("  Correct Answer: Conflict hour -- Tue 3 ");
        System.out.print("   Your  Answer : ");
        CourseSchedule case3 = new CourseSchedule("myschedule-hourconflict.data");
        case3.print();
        System.out.println("End of Case3");
        System.out.println("");
        System.out.println("Case4-1: Check Format Error  ->");
        System.out.println("  Correct Answer: Irregular schedule line -- Java:: 3: Mon: 1: 3 ");
        System.out.print("   Your  Answer : ");
        CourseSchedule case4 = new CourseSchedule("myschedule-formaterror1.data");
        case4.print();
        System.out.println("Case4-2: Check Format Error  -> ");
        System.out.println("  Correct Answer: Unknown date -- 1 ");
        System.out.print("   Your  Answer : ");
        CourseSchedule case5 = new CourseSchedule("myschedule-formaterror2.data");
        case5.print();
        System.out.println("Case4-3: Check Format Error  -> ");
        System.out.println("  Correct Answer: Unresolved hour -- Tue10 ");
        System.out.print("   Your  Answer : ");
        CourseSchedule case6 = new CourseSchedule("myschedule-formaterror3.data");
        case6.print();
        System.out.println("End of Case4");
        System.out.println("");
        System.out.println("Case5: Unknwon Schedule File ");
        System.out.println("  Correct Answer: Unknwon File ");
        System.out.print("   Your  Answer : ");
        CourseSchedule case7 = new CourseSchedule("myschedule-unknown.data");
        case7.print();
        System.out.println("End of Case5");
        System.out.println("");
    }
}
