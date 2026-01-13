package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

public class C07Constructor {
    public static void main(String[] args) {
//        캘린더 객체 생성
        Calendar c1 = new Calendar("2025","12","16");

//        c1.setA(); // setter를 쓸거면 의도를 명확하게 지어서 써라.

//        캘린더 객체 출력
        System.out.println(c1);
        
//        java자료구조내에 직접 만든 객체를 담아 관리
        List<Calendar> myList = new ArrayList<>();
        // < > 는 제네릭이고 기본형은 안됨.
        myList.add(c1);
        myList.add(new Calendar("2025","01","3"));
        System.out.println(myList);
    }
}

//클래스명 : Calender , 변수 : year, month, day 모두 String