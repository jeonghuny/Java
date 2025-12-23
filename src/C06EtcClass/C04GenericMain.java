package C06EtcClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class C04GenericMain {
    public static void main(String[] args) {
//        String[] stArr = {"java","python","c++"};
//        allChange(stArr,0,1);
//        System.out.println(Arrays.toString(stArr));
//
//        Integer[] intArr = {10,20,30};
//        allChange(intArr,0,1);
//        System.out.println(Arrays.toString(intArr));

//        제네릭을 사용한 객체 생성 (이게 원래 허용되면 안됨)
//        GenericPerson p1 = new GenericPerson("hongildong");
//        GenericPerson p2 = new GenericPerson(20);
//        System.out.println(p1.getValue());
//        System.out.println(p2.getValue());

//        제네릭을 사용한 객체 생성
        GenericPerson<String> p1 = new GenericPerson<>("hongildong");
        GenericPerson<Integer> p2 = new GenericPerson<>(20);
        System.out.println(p1.getValue());
        System.out.println(p2.getValue());

//        제네릭의 사용 예시
        List<String> myList = new ArrayList<>();
        Stream<String> myStream;
        Optional<Student> myStudent;
    }

    static void stChange(String[] stArr, int start, int end){
        String tmp = stArr[start];
        stArr[start] = stArr[end];
        stArr[end] = tmp;
    }

    //    제네릭메서드는 반환타입 왼쪽에 <T>라고 선언
//    이때 T는 참조형변수인 객체타입만을 허용 (int는 안된다)
    static <T> void allChange(T[] arr, int start, int end){
        T temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}

class GenericPerson <T>{
    private T value;

    public GenericPerson(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
    // 클래스 차원에 <T> 있으면 메서드에 <T> 안 넣어도 됨
    public void setValue(T value) {
        this.value = value;
    }
}
