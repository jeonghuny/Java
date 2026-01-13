package C02MethodClass;

import java.util.ArrayList;
import java.util.List;

// java에서 같은 이름의 메서드선언은 불가
// 메서드 오버로딩 : 메서드명은 같은데 매개변수의 타입 또는 개수가 달라지게 선언하는것
// 오버라이딩 : 상속관계, 자식클래스에 재정의
// 다만, 같은 이름의 메서드명을 사용하되, 매개변수의 개수 또는 매개변수의 타입이 달라지는 경우는 메서드 오버로딩은 허용.
public class C06MethodOverloading {
    public static void main(String[] args) {
//        메서드 오버로딩 후 해당 메서드 호출
        System.out.println(sum(10,20));
        System.out.println(sum(10.5,20.5));
        System.out.println(sum(10.5,20.5));

//        또다른 메서드 오버로딩 사례
        System.out.println("hello");
        System.out.println(10);
        System.out.println(10.5);
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(0,20);
    }
    public static int sum(int a, int b){
        return a+b;
    }
    public static int sum(int a, int b, int c){
        return a+b+c;
    }
    public static double sum(double a, double b){
        return a+b;
    }
}
