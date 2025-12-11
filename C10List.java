package C01Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C10List {
    public static void main(String[] args) {
//        List선언방법1
        ArrayList<String> myList1 = new ArrayList<String>();
        ArrayList<String> myList2 = new ArrayList<>();

//        List선언방법2 : 가장 일반적인 방법
        List<String> myList3 = new ArrayList<>(); // ArrayList 객체
//        클래스명 변수명 = new 클래스명();
//        초기값 세팅방법1. 개별data add
        myList3.add("java");
        myList3.add("python");
        myList3.add("C++");
        System.out.println(myList3);

//        초기값 세팅방법2. 배열을 리스트로 변환
        String[] arr = {"java","ptyhon","C++"};
        List<String> myList4 =new ArrayList<>(Arrays.asList(arr));
        // 배열안의 값을 리스트에 통째로 집어넣음

//        List의 안의 자료타입으로는 기본형타입은 쓸 수 없음
        int[] intArr = {10,20,30};
        List<Integer> myList5 = new ArrayList<>(); // 오토박싱이라서 가능 int형
        for(int i : intArr){
            myList5.add(i);
        }

    }
}
