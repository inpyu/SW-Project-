package org.example.ArrayListAssignment;

/**
 * 고정 용량(10)의 배열 기반 ArrayList 구현.
 * 다양한 타입의 Object를 저장할 수 있음.
 */
public class ObjectArrayListLimitedCapacity {

    // 내부 저장용 배열
    protected Object[] array;

    // 현재 저장된 요소 수
    protected int size;

    // 기본 배열 크기 (고정)
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 생성자: 크기 10의 배열을 초기화하고, size는 0으로 설정
     */
    public ObjectArrayListLimitedCapacity() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * 현재 요소 수를 반환
     */
    public int size() {
        return this.size;
    }

    /**
     * 리스트가 비어있는지 여부 확인
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 주어진 인덱스에 있는 요소를 반환
     */
    public Object get(int index) {
        return this.array[index];
    }

    /**
     * 주어진 인덱스에 요소 삽입.
     * 기존 요소들은 오른쪽으로 한 칸씩 이동.
     */
    public void add(int index, Object o) {
        // 뒤에서부터 한 칸씩 밀기
        for (int i = this.size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = o;
        this.size++;
    }

    /**
     * 리스트 끝에 요소 추가
     */
    public void add(Object o) {
        array[this.size] = o;
        this.size++;
    }

    /**
     * 주어진 인덱스에 있는 요소를 제거하고 반환
     * 이후 요소들은 왼쪽으로 한 칸씩 이동
     */
    public Object remove(int index) {
        Object removedObject = this.array[index];
        // 요소들을 앞으로 한 칸씩 당김
        for (int i = index; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[this.size - 1] = null;  // 마지막 위치 null 처리
        this.size--;
        return removedObject;
    }
}
