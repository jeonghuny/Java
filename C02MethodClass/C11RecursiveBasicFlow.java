package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

// 재귀함수 기본 호출 원리와 과정
public class C11RecursiveBasicFlow {
    public static void main(String[] args) {
//        recur0(0,3);
//        recur1(0 ,3);

//        recur2(new ArrayList<>(),0,3);
        // 이거랑 같음
        List<Integer> myList = new ArrayList<>();
        recur2(myList,0,3);
        System.out.println(myList);
    }

//    기본자료형 변수의 재귀함수내 변화과정(맥변수로 넘기는 시점에 값 변경)
    public static void recur0(int count, int target){
        if(count == target){
            return;
        }
        System.out.println("재귀 호출전 count : " + count); // 0(첫번째) -> 1(두번째) -> 2(세번째)
        recur0(count+1, target);
        System.out.println("재귀 호출후 count : " + count); // 2(네번째) -> 1(다섯번째) -> 0(여섯번째)
    }
//    기본자료형 변수의 재귀함수내 변화과정(함수내에서 값 변경)
    public static void recur1(int count, int target) {
        if (count == target) {
            return;
        }
        System.out.println("재귀 호출전 count : " + count); // 0(첫번째) -> 1(두번째) -> 2(세번째)
        count += 1;
        recur1(count, target);
        System.out.println("재귀 호출후 count : " + count); // 3(네번째) -> 2(다섯번째) -> 1(여섯번째)
    }
//    객체를 매개변수로 활용한 재귀함수내 변화과정 : 객체는 힙메로리를 통해 원본객체가 변경되므로, 재귀함수간에도 값의 변화를 공유.
    public static void recur2(List<Integer> myList, int count, int target) {
        if (myList.size() == target) {
            return;
        }
        myList.add(count);
        // 원본의 주소값을 참고 하고 있기때문에 그냥 원본을 변경하게 된것
        recur2(myList, count+1, target);
        System.out.println(myList);
        myList.remove(myList.size()-1);
    }
}
