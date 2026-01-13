package C05AnonymousLambda;

import java.util.*;

public class C03ComparatorComparable {
    public static void main(String[] args) {
//        java에서는 비교를 위한 인터페이스 대표적으로 2개 제공
//        1.Comparator인터페이스 : 인터페이스내 compare()메서드만 존재
//        2.Comparable인터페이스 : 인터페이스내 compareTo()메서드만 존재 // 진짜 1개
////        -> Comparator에서 정렬 기준을 정의하는 유일한 추상 메서드는 compare이다
////        -> Comparable에서 정렬 기준을 정의하는 유일한 메서드는 compareTo이다

//        List<Integer> myList = new ArrayList<>();
//        myList.add(20);
//        myList.add(10);
//        myList.add(30);
//        java의 대부분의 정렬함수는 매개변수로 Comparator객체 요구.
//        myList.sort(Comparator.naturalOrder());
//        -> sort()의 매개변수 타입은 Comparator 하나뿐이다.(Comparator객체)
//        o1과 o2의 숫자값을 마이너스 형식으로 코딩을 하되,
////    이말은 -> 두 값을 서로 빼서(compare 결과를) 음수 / 0 / 양수로 만든다
////          -> 두 값을 빼서 결과의 부호로 순서를 정한다
//        o1이 먼저 있으면 오름차순. o2가 먼저 있으면 내림차순.
//        myList.sort((o1, o2) -> o1-o2);
////        -> sort()의 매개변수 타입은 Comparator 하나뿐이기 때문에 가능
//        myList.sort(Comparator.naturalOrder());



//        <나의 정리>
//        ✔ Integer가 Comparable 구현
//        ✔ 오름차순 기본 정렬
//        1️⃣ Collections.sort()는 “옛날 방식” (JDK 1.2)
//        Collections.sort(List<T> list)
//        <특징>
//        List 외부 유틸리티 클래스
//        Comparable 기반 기본 정렬
//        Java 초창기 방식
//        Collections.sort(myList); // compareTo 사용

//        List.sort()는 “요즘 방식” (JDK 8)
//        default void sort(Comparator<? super E> c)
//        <특징>
//        List 인터페이스의 default 메서드
//        Comparator 기반
//        람다, 체이닝 친화적
//        myList.sort(Comparator.naturalOrder());

//        static <T extends Comparable<? super T>> Comparator<T> naturalOrder()
//        -> 문법은 모르지만, T는 반드시 Comparable을 구현한 타입이어야 한다

//        Integer implements Comparable
//        ↓
//        Comparator.naturalOrder() -> 자바 8 이후부터는 인터페이스도 ‘구현 코드’를 가질 수 있다
//        ↓
//        (o1, o2) -> o1.compareTo(o2) [Comparable의 compareTo를 그대로 사용]
//        ↓
//        list.sort(Comparator)



//        List<String> myList2 = new ArrayList<>();
//        myList2.add("java");
//        myList2.add("python");
//        myList2.add("c++");
//        myList2.add("d++");
//        myList2.add("a++");
//
//        String a = "hello";
//        String b = "java";
//        a.compareTo(b); // 음수




/*       <나의정리>
//        Comparable (자기 자신이 기준을 가짐)
class Person implements Comparable<Person> {
    int age;
    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}
//        ✔ 클래스 자체 정렬 기준 1개
//        ✔ Collections.sort(list) 가능
//        ✔ 대표 예: String, Integer

//        Comparator (외부에서 기준을 주입)
//          Comparator<Integer> comp = (a, b) -> a - b;
//        ✔ 정렬 기준 여러 개 가능
//        ✔ 그때그때 기준 바꿀 수 있음
//        ✔ 익명 클래스 / 람다 주 사용처
*/



//        기본적인 문자열 정렬일때에는 Comparator커스텀을 하지 않고,
//        복잡한 자신만의 정렬기준을 가지고 정렬해야 할때 Comparator 익명객체 생성.
//        ex)문자열의 길이를 기준으로 정렬하되, 문자열의 길이 같은 경우에는 알파벳순으로 정렬
//        Collections.sort(myList2, new Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1.length()==o2.length()){
//                    return o1.compareTo(o2);
//                }
//                return o1.length() - o2.length();
//            }
//        });
////     Collections.sort는 비교 방법을 Comparator에게 위임하고,
////     Comparator 안에서는 필요하면 Comparable의 compareTo를 직접 호출해서 재사용한다.
        // 동작 완전히 동일   (코드는 이코드와 완전 동일)
//        Collections.sort(myList2, (o1, o2) -> {
//            if (o1.length() == o2.length()) {
//                return o1.compareTo(o2);
//            }
//            return o1.length() - o2.length();
//        });


//        System.out.println(myList2);

//        백준 : 단어정렬 - 확인


//        배열, 리스트 정렬외에 java의 그외 정렬자료구조
//        Queue<String> pq = new PriorityQueue<>((o1, o2) -> o1.length()- o2.length());


//        백준 : 최대힙 - 확인
//        백준 : 절대값힙 - 확인
        
//        백준 : 선긋기
        
//        리스트 안의 배열 정렬
//        [{4,5},{1,2},{5,0},{3,1}]

//        리스트안의 배열에 1번째 index를 기준으로 오름차순 정렬

//        List<int[]> list = new ArrayList<>();
//        list.add(new int[]{4,5});
//        list.add(new int[]{1,2});
//        list.add(new int[]{5,0});
//        list.add(new int[]{3,1});
//
//        list.sort((o1, o2) -> o1[1]-o2[1]);
//        for(int[] arr : list){
//            System.out.print(Arrays.toString(arr) +" ");
//        }

//        직접 만든 객체 정렬
//        방법1. Comparator를 구현한 익명객체 방식
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("kim",30));
        studentList.add(new Student("lee",34));
        studentList.add(new Student("park",25));
        studentList.add(new Student("ju",28));
        studentList.sort(Comparator.naturalOrder());
//        // 나이정렬
//        studentList.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.getAge() - s2.getAge();
//            }
//        });
//        System.out.println(studentList);
//        // 이름정렬
//        Collections.sort(studentList, new Comparator<Student>(){
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

//        방법2. Comparable을 구현한 방식
//        Student객체 안에 Comparable을 implements하는 방식
//        sort실행시 자동으로 Student안의 compareTo 메서드 호출
        Collections.sort(studentList);
        System.out.println(studentList);
    }
}


//  Comparable의 compareTo에서는 this와 매개변수로 주어지는 객체와 비교
//  this가 앞에 있으면 오름차순, 매개변수객체가 앞에 있으면 내림차순
class Student implements Comparable<Student>{
//class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}

