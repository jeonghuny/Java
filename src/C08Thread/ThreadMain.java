package C08Thread;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TransferQueue;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
////        단일스레드 실행
//        for(int i=0; i<1000; i++){
//            Library.borrow();
//        }
//        System.out.println(Library.getBookCount());

//        스레드 생성
//        방법1.스레드 클레스를 상속받는 방식
//        Thread t1 = new MyThread();
//        Thread t2 = new MyThread();
//        Thread t3 = new MyThread();
//        Thread t4 = new MyThread();
//        Thread t5 = new MyThread();
////        각 스레드는 코드의 실행순서가 보장되지 않는 비동기적 실행(main에 할당된 thread포함)
//        t1.start(); // start하면 run메소드 실행됨
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        System.out.println("hello world"); // 이거는 메인메서드에 할당된 스레드가 실행한 것.

//        방법2. Runnable 객체구현한 객체를 Thread클래스 생성자에 주입하는 방식
//        구현객체의 run메서드를 Thread객체가 가져다 사용
//        new Thread(Runnable 객체구현한 객체)
//        new Thread(() -> System.out.println("스레드 실행1")).start();
//        Thread t2 = new Thread(() -> System.out.println("스레드 실행2"));
//        Thread t3 = new Thread(() -> System.out.println("스레드 실행3"));
//        Thread t4 = new Thread(() -> System.out.println("스레드 실행4"));
//        System.out.println("hello world");
//        t2.start();
//        t3.start();
//        t4.start();

//        멀티스레드 동시성 이슈 테스트
//        for(int i=0; i<1000; i++){
//            new Thread(() -> Library.borrow()).start(); // 1. 똑같은 방법
//            Thread t1 = new Thread(() -> Library.borrow()); // 2. 똑같은 방법
//            t1.start();
////            join : 한스레드의 작업이 모두 완료될때까지, 다른 스레드를 생성하지 않는것. -> 사실상 단일 스레드처럼 동작하므로, 성능저하.
//            t1.join();
//            new Thread(new Runnable() { // 3. 똑같은 방법
//                @Override
//                public void run() {
//                    Library.borrow();
//                }
//            });
//        }
//        Thread.sleep(30000);
//        System.out.println(Library.getBookCount());

//        synchronized를 통한 동시성 제어 예시 (특정 메서드를 보호한다???)
        StringBuffer sb1 = new StringBuffer();
        sb1.append("hello"); // synchronized 메서드 -> 동시성 제어
        StringBuilder sb2 = new StringBuilder();
        sb2.append("hello"); // 일반 메서드 -> 동시성 문제 발생 가능성 있음.
        
        Map<String,String> myMap1 = new ConcurrentHashMap<>();
        myMap1.put("java","자바"); // synchronized 메서드
        Map<String,String> myMap2 = new HashMap<>();
        myMap2.put("java","자바"); // 일반 메서드
    }
}

// 1) 동시에 수행 : t1 -> t2 -> t3 -> t1 -> t2 -> t3 : 비용이 많이 발생(어디까지 작업했는지 저장도 필요, 저장, 복원)
// 2) t1 -> t2 -> t3 : 사용자 편의

// synchronized 쓰면
// 사용자 -> Spring(서버) -> db