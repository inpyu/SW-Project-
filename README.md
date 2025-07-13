# 중앙대학교 25-1 소프트웨어 프로젝트

**작성자:** 20213509 정다연  
**과목:** 소프트웨어 프로젝트  
**언어:** Java  
**환경:** IntelliJ / Ubuntu / Swing 기반 GUI

---

## 📁 디렉토리 구조

```
SoftwareProject/
│
├── src/
│   └── org/
│       └── example/
│           ├── view/
│           │   ├── ButtonPanel.java
│           │   ├── InputPanel.java
│           │   ├── CourseListPanel.java
│           │   ├── ScheduleTablePanel.java
│           │   ├── CourseScheduleSection.java
│           │   └── CourseScheduleView\.java
│           │
│           ├── Course.java
│           ├── CourseSchedule.java
│           ├── CourseScheduleMain.java
│           ├── CourseButtonController.java
│           └── CourseTableController.java
│
├── data/
│   ├── myschedule-norm.data   # 수강신청 가능한 과목 리스트
│   └── myschedule-dump.data   # 저장된 수강 신청 과목 리스트
│
├── ArrayListAssignment/
│   ├── ObjectArrayListLimitedCapacity.java
│   ├── ObjectArrayList.java
│   ├── ParaStack.java
│   └── TestArray.java
│
├── NumArray/
│   └── numarray.java
│
├── MeasureExecTime/
│   └── MeasureExecTime.java
│
└── README.md
```

---

## ✅ 과제별 설명

### 📌 과제 1 – 실행 시간 측정
- **파일:** `MeasureExecTime.java`
- **기능:** 특정 연산(`productDivisors`)을 반복하여 평균 실행 시간 측정.
- **실행환경:** Ubuntu 터미널 및 IntelliJ

### 📌 과제 2 – 배열 클래스 구현
- **파일:** `numarray.java`
- **기능:** 
  - 최대값, 평균값 계산
  - 배열 병합 (`mergeArrays`)
  - `printArr()` 로 배열 출력
- **특징:** Java와 C의 배열 처리 방식 비교 포함

### 📌 과제 3 – Course & CourseSchedule 클래스
- **파일:** `Course.java`, `CourseSchedule.java`
- **기능:** 
  - 과목 정보 모델링 (과목명, 요일, 시간 등)
  - 시간표 충돌 검사 및 유효성 체크
  - 파일 로드 및 저장 기능 구현

### 📌 과제 4 – 커스텀 ArrayList & 제네릭 Stack
- **파일:** 
  - `ObjectArrayListLimitedCapacity.java`
  - `ObjectArrayList.java`
  - `ParaStack<T>.java`
- **기능:**
  - 고정/확장형 배열 리스트
  - 다양한 타입 저장 가능
  - 제네릭 스택 구현 및 테스트

### 📌 과제 5 – GUI 컴포넌트 View 구현
- **패키지:** `org.example.view`
- **주요 클래스:**
  - `ButtonPanel`: 기능 버튼 집합
  - `InputPanel`: 과목 입력 필드
  - `CourseListPanel`: 테이블 기반 과목 리스트
  - `ScheduleTablePanel`: 시간표 출력 패널
  - `CourseScheduleSection`: 전체 UI 통합

### 📌 과제 6 – GUI 통합 구현 및 MVC 설계
- **기능 요약:**
  - 수강 과목 로드 / 저장 (파일 기반)
  - 시간표 시각화 및 충돌 검사
  - `ADD / DELETE / SHOW / LOAD / SAVE` 기능 구현
- **설계 구조:** MVC 패턴
  - `Model`: `Course`, `CourseSchedule`
  - `View`: `CourseScheduleSection` 및 View 패키지
  - `Controller`: `CourseButtonController`, `CourseTableController`

---

## 📸 주요 동작 예시

- 과목 리스트 불러오기 (`Show List`)
- 과목 선택 후 입력창 자동 채움
- 과목 추가 / 삭제
- 시간표 자동 갱신
- 충돌 시 경고 메시지 표시
- 파일 저장/불러오기 기능 정상 작동

---

## 🧠 설계 특징

- MVC 구조 명확 분리 (유지보수성 강화)
- 예외 발생 시 사용자 피드백 제공
- Static 메서드는 데이터 변환 전용으로 최소화
- 내부 멤버는 캡슐화를 통해 안정성 확보
- ArrayList → Array 기반 구현 후 확장 지원

---

## 📌 실행 방법

```bash
# IntelliJ 또는 CLI 환경에서 실행
javac -d out src/org/example/CourseScheduleMain.java
java -cp out org.example.CourseScheduleMain
```


---

## 📮 참고

* `myschedule-norm.data`: 과목 리스트 예시 파일
* `myschedule-dump.data`: 수강 과목 저장 파일
* GUI 실행 후 과목 리스트를 선택하고 `ADD` 버튼을 눌러 시간표를 구성

