package C05AnonymousLambda;

import javax.lang.model.element.AnnotationMirror;

// 익명 내부클래스
// 이름 없는 클래스를 선언함과 동시에
// 그 클래스의 객체를 바로 생성하는 것
public class C02AnonymousClass {
    public static void main(String[] args) {
//        AbstractAnimal을 상속한 클래스가 별도로 존재하지 않고,
//        내부에서 익명클래스가 만들어짐과 동시에 익명객체가 생성.(컴파일러에 의해 생성)


//이름이 없는 내부 클래스
//→ 클래스 선언 + 객체 생성을 동시에
//→ 딱 한 번만 사용

//        AbstractAnimal aa = new AbstractAnimal() {
//            @Override
//            void makeSound() {
//                System.out.println("멍멍");
//            }
//        };
//        aa.makeSound();
//        aa.eat();
//
////        구현체가 없는 추상클래스 또는 인터페이스는 익명객체로 생성.
        // a1 은 이름없는 클래스의 객체 -> 익명객체이다.
//        Animal1 a1 = new Animal1() {
//            @Override
//            public void makeSound() {
//            }
//            @Override
//            public void eat() {
//            }
//        };
        

//        인터페이스의 익명객체에 구현해야할 메서드가 1개밖에 없을때에는 람다표현식(화살표함수) 사용가능
        Animal2 a2 = () -> {
            System.out.println("hello world1");
            System.out.println("hello world2");
        };
        a2.makeSound();

//        실행문이 1줄 밖에 없을때에는 {} 생략 가능
        Animal2 a2_2 = () -> System.out.println("hello world1");
        a2_2.makeSound();

//        매개변수가 있는 익명객체의 람다함수 생성
        Animal3 a3_1 = (a,b,c) -> {
            return a + ", " + b + ", " + c;
        };

//         return이 하나 일 경우  {} 생략 가능 return도 생략
        Animal3 a3_2 = (a,b,c) -> a + ", " + b + ", " + c;

        System.out.println(a3_1.makeSound("java","python","C++"));

//        실습)
//        Animal4인터페이스 생성 및 makeSound메서드 선언 : 매개변수는 String, String, int. 리턴타입은 String
//        익명객체 생성시 메서드의 기능 : 매개변수의 숫자값이 10이상이면 a+b 를 리턴. 10미만이면 a를 리턴,

        Animal4 a4_1 = (String a, String b, int c) -> {
            if(c>=10){
                return a+b;
            }else{
                return a;
            }
        };
        System.out.println(a4_1.makeSound("abc","bcd",20));

    }
}

abstract class AbstractAnimal{
    abstract void makeSound();

    void eat(){
        System.out.println("동물이 먹이를 먹습니다.");
    }
}

interface Animal1{
    void makeSound();
    void eat();
}

interface Animal2{
    void makeSound();
}

interface Animal3{
    String makeSound(String a, String b, String c);
}

interface Animal4{
    String makeSound(String a, String b, int c);
}