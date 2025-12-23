package C06EtcClass;

public class C03EnumMain {
    public static void main(String[] args) {
//        classGrade를 일반 문자열로 설계했을 경우 -> 데이터종류에 대한 통제 불가
//        Student s1 = new Student("h1","FIRST_GRADE");
//        Student s2 = new Student("h2", "SECOND_GRADE");
//        Student s3 = new Student("h3", "THIRD_GRADE");

//      static final 변수로 설계했을 경우
//        Student s1 = new Student("h1", ClassGrade.c1);
//        Student s2 = new Student("h2", ClassGrade.c2);
//        Student s3 = new Student("h3", "1학년");

        Student s1 = new Student("h1", ClassGrade.FIRST_GRADE);
        Student s2 = new Student("h2", ClassGrade.THIRD_GRADE);
        Student s3 = new Student("h3", ClassGrade.SECOND_GRADE);
        System.out.println(s1);
//        classGrade를 Enum클래스로 설계했을 경우
    }
}

//class ClassGrade{
        // static final로 선언하더라고 String이기에 다른값이 들어갈 수 있다.
//    static final String c1 = "FIRST_GRADE";
//    static final String c2 = "SECOND_GRADE";
//    static final String c3 = "THIRD_GRADE";
//}

//enum 클래스는 데이터의 종류를 하나의 enum명 아래 묶는것
enum ClassGrade{
    // enum의 변수값은 static final 변수처럼 사용
    FIRST_GRADE, SECOND_GRADE, THIRD_GRADE;
}

class Student{ // default라 충돌안남 (중복이지만)
    private String name;
//    private String classGrade; // 학년 : FIRST_GRADE , SECOND_GRADE, THIRD_GRADE
    private ClassGrade classGrade;

    public Student(String name, ClassGrade classGrade) {
        this.name = name;
        this.classGrade = classGrade;
    }

//    public Student(String name, String classGrade) {
//        this.name = name;
//        this.classGrade = classGrade;
//    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", classGrade='" + classGrade + '\'' +
                '}';
    }
}