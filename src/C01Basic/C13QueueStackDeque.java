package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C13QueueStackDeque {
    public static void main(String[] args) throws IOException {
//        List : 뒤에다가 더하고, 앞에껄 빼기에는 성능 저하
//        Queue : 선입선출, 뒤에서 더하고 앞에껄 뺀다
//        stack : 후입선출, 뒤에서 더하고 뒤에걸 뺀다
//        ArrayList == List -> add 최적화, 앞에서 remove(성능저하)
//        LinkedList == 큐 -> add 최적화, 앞에서 remove 최적화
//        완벽한 자료구조는 없다 트레이드오프가 있기마련..

//        ArrayList vs LinkedList
//        ex) 0번째를 뺀다.
//        ArrayList : 제거하고, 1~n번째의 인덱스를 바꿔야됨 O(n)
//        LinkedList : 제거하고, 연결부분만 끊어주면 됨 O(1),
//                   (단, 중간값을 삭제하면 조회하는데 성능저하)

//        ArrayList
//        장점 : 조회성능 빠름
//        단점 : 중간값 삭제 remove O(n)
//        LinkedList(큐)
//        장점 : 맨앞의 값 삭제 성능 빠름
//        단점 : 조회성능저하
//        Queue인터페이스를 Linkedlist를 구현한 아래와 같은 방식으로 가장 많이 사용
//        Queue<Integer> myQue = new LinkedList<>();
//        myQue.add(10);
//        myQue.add(20);
//        myQue.add(30);
////        poll은 큐에서 가장 앞의 데이터를 삭제하면서 동시에 return하는 메소드
//        int value = myQue.poll();
//        System.out.println(value); // 10
//        System.out.println(myQue); // [20, 30]
////        peek은 큐에서 데이터를 삭제하지 않고, 가장 앞의 데이터를 return 하는 메소드
//        int value2 = myQue.peek();
//        System.out.println(value2); // 20
//        System.out.println(myQue); // [20, 30]
//
////        while문을 통한 queue출력 방식
//        Queue<String> printerQueue = new LinkedList<>();
//        printerQueue.add("문서1");
//        printerQueue.add("문서2");
//        printerQueue.add("문서3");
//        printerQueue.add("문서4");
////        큐는 일반적으로 while문을 통해 요소를 소모
//        int size = printerQueue.size();
//        for(int i=0; i<printerQueue.size(); i++){
//            System.out.println();
//        }
//        while(!printerQueue.isEmpty()){
//            System.out.println(printerQueue.poll());
//        }

//        LinkedList와 ArrayList 성능차이 비교
//        ArrayList 장점 : 조회성능 빠름. 단점 : 중간 삽입/삭제 성능 저하
//        LinkedList 장점 : 중간 삽입/삭제 성능 빠름, 단점 : 조회성능 저하

//        LinkedList<Integer> myLinkedList = new LinkedList<>();
//        long stratTime = System.currentTimeMillis();
//        for(int i=0; i<1000000; i++){
//            myLinkedList.add(0,i);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("LinkedList에 중간에 값 add 시에 소요시간 : " + (endTime-stratTime));
//        ArrayList<Integer> myArrayList = new ArrayList<>();
//        long stratTime2 = System.currentTimeMillis();
//        for(int i=0; i<1000000; i++){
//            myArrayList.add(0,i);
//        }
//        long endTime2 = System.currentTimeMillis();
//        System.out.println("ArrayList에 중간에 값 add 시에 소요시간 : " + (endTime2-stratTime2));

//        관련문제 : 카드2, 요세푸스 문제 0

//        길이제한 큐 (잘쓰이는것 같지 않다고 하심)
//        Queue<String> blockingQueue = new ArrayBlockingQueue<>(3); // 숫자 넣어줘야됨
//        blockingQueue.add("문서1");
//        blockingQueue.add("문서2");
//        blockingQueue.add("문서3");
// ★       blockingQueue.add("문서4"); // 에러남, 길이 초과시 에러 발생
//        에러가 나면 그 자리에서 stop
//        blockingQueue.offer("문서1");
//        blockingQueue.offer("문서2");
//        blockingQueue.offer("문서3");
//        blockingQueue.offer("문서4"); // 제한된 길이까지만 insert. 에러발생 X
//        System.out.println(blockingQueue);

// ★       우선순위 큐 : 데이터를 poll할때 정렬된 데이터결과값(최소값/최대값) 보장
//        지속적으로 데이터가 추가/제거되면서 전체데이터가 실시간으로 변경되는 상황에 사용.
//        pq에서 데이터 하나를 poll : lon(n)
//        pq에서 전체데이터를 모두 poll : nlog(n)
//        1) add하고 poll(log(n))
//        2) add하고 poll(log(n))
//        list에서 전체데이터를 정렬 : nlog(n)

//        Queue<Integer> pq = new PriorityQueue<>();
//        pq.add(30);
//        pq.add(20);
//        pq.add(10);
//        pq.add(40);
//        pq.add(50);
//        while(!pq.isEmpty()){
//// ★           poll할때마다 최소값을 추출하게 되고 복잡도 log(n), peek은 최소값을 확인만하고 추출은 X, 복잡도 log(n)
////            최소값 출력하고 새로운 최소값을 root로 올리는데 log(n)
////            전체 데이터를 모두 poll하면 복잡도 nlog(n)
////            우선순위큐는 힙자료구조로 구현
////            모든 부모노드가 자식노드보다 작은것
//            System.out.println(pq.poll());
//        }
//                백준 : 최소힙 - 확인

//              프로그래머스 : 더 맵게 - 확인

//            최대힙 : poll 할때마다 최대값 추출 - 확인
        
//        Queue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
//        stack : 후입선출의 자료구조
//        Stack<Integer> myStack = new Stack<>();
//        myStack.push(10);
//        myStack.push(20);
//        myStack.push(30);
//        System.out.println(myStack.pop()); // 30 // 가장 마지막에 입력한 값을 꺼내는면서 제거
//        System.out.println(myStack.peek()); // 마지막에 입력한 값을 확인만
//        System.out.println(myStack.size());
//        System.out.println(myStack.isEmpty());

//        프로그래머스 : 올바른 괄호 - 확인

//        프로그래머스 : 같은 숫자는 싫어 - 확인

// ★       deque : addFirst, addLast, pollFirst, pollLast, peekFirst, peekLast
//        Deque<Integer> myDeque = new ArrayDeque<>();
//          성능이 좋다 =
//        myDeque.addLast(10);
//        myDeque.addLast(20);
//        myDeque.addFirst(30); // 30 10 20
//        System.out.println(myDeque.pollLast()); // 20
//        System.out.println(myDeque.pollFirst()); // 30
//        System.out.println(myDeque.pollFirst()); // 10

        // Queue
        // 1)LinkedList(선입선출) - 앞에꺼 꺼내서 뒤로 둘때
        // 2)PQ - 힙자료구조
        // Stack - 마지막값과 지금 집어넣으려고 하는 값 비교
        // Deque - 양방향 스택,큐 가능 (특별한 특징은 없음)

    }
}
