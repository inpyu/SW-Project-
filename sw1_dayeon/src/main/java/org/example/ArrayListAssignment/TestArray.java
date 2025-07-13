package org.example.ArrayListAssignment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

public class TestArray {

    public static void main(String[] args) throws Exception {

        System.out.println("");
        System.out.println("At " + LocalDateTime.now().toString());
        System.out.println("By " + System.getProperty("user.name") + " at " + InetAddress.getLocalHost().getHostName());
        System.out.println("");

        System.out.println("======== [1] ObjectArrayListLimitedCapacity 테스트 ========");
        ObjectArrayListLimitedCapacity limitedList = new ObjectArrayListLimitedCapacity();
        System.out.println("초기 isEmpty(): " + limitedList.isEmpty());
        limitedList.add("A");
        limitedList.add(123);
        limitedList.add(3.14);
        limitedList.add(1, "Inserted");
        printList(limitedList);
        System.out.println("remove(1): " + limitedList.remove(1));
        printList(limitedList);

        // 10개 초과 입력 테스트 (초기 용량 확인용)
        try {
            for (int i = 0; i < 11; i++) {
                limitedList.add("Item" + i);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("용량 초과 시 예외 발생 확인됨 (OK)");
        }

        System.out.println("\n======== [2] ObjectArrayList (확장형) 테스트 ========");
        ObjectArrayList expandableList = new ObjectArrayList();
        for (int i = 0; i < 15; i++) {
            expandableList.add(i);
        }
        System.out.println("확장 후 size: " + expandableList.size());
        System.out.println("contains(5): " + expandableList.contains(5));
        System.out.println("contains(100): " + expandableList.contains(100));
        expandableList.add(5, "InsertedValue");
        printList(expandableList);

        System.out.println("\n======== [3] 다양한 타입 저장 테스트 ========");
        ObjectArrayList typeTestList = new ObjectArrayList();
        typeTestList.add("StringType");
        typeTestList.add(42);         // Integer
        typeTestList.add(3.1415);     // Double
        typeTestList.add(true);       // Boolean
        printList(typeTestList);

        System.out.println("\n======== [4] ParaStack<String> 제네릭 테스트 ========");
        ParaStack<String> stringStack = new ParaStack<String>();
        stringStack.push("One");
        stringStack.push("Two");
        System.out.println("pop(): " + stringStack.pop()); // Two
        System.out.println("isEmpty(): " + stringStack.isEmpty());
        System.out.println("pop(): " + stringStack.pop()); // One
        System.out.println("isEmpty(): " + stringStack.isEmpty());

        System.out.println("\n======== [5] ParaStack<Integer> 제네릭 테스트 ========");
        ParaStack<Integer> intStack = new ParaStack<>();
        intStack.push(10);
        intStack.push(20);
        System.out.println("pop(): " + intStack.pop());
        System.out.println("pop(): " + intStack.pop());
        System.out.println("isEmpty(): " + intStack.isEmpty());

        System.out.println("\n======== [6] 타입 지정 없이 ParaStack 테스트 (비타입 안전 실험) ========");
        ParaStack rawStack = new ParaStack();  // 타입 미지정 → raw type
        rawStack.push("raw_string");
        rawStack.push(100);  // 타입 다르게 넣음

        // 꺼내서 잘못된 타입으로 캐스팅 시도
        Object value1 = rawStack.pop();  // → 안전함
        Object value2 = rawStack.pop();  // → 안전함
        System.out.println("정상 출력: " + value1 + ", " + value2);

        // 비정상적인 캐스팅 시도 (컴파일 가능하지만 런타임 오류)
        String wrongCast = (String) value2;  // → Integer를 String으로 캐스팅
        System.out.println("캐스팅된 문자열: " + wrongCast);

    }

    // 출력 헬퍼 함수
    private static void printList(ObjectArrayListLimitedCapacity list) {
        System.out.print("List contents: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
