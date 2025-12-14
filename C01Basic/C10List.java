package C01Basic;

import java.util.*;

public class C10List {
    public static void main(String[] args) {
//        List선언방법1
//        ArrayList<String> myList1 = new ArrayList<String>();
//        ArrayList<String> myList2 = new ArrayList<>();

//        List선언방법2 : 가장 일반적인 방법
//        List<String> myList3 = new ArrayList<>(); // ArrayList 객체
//        클래스명 변수명 = new 클래스명();
//        초기값 세팅방법1. 개별data add
//        myList3.add("java");
//        myList3.add("python");
//        myList3.add("C++");
//        System.out.println(myList3);

//        초기값 세팅방법2. 배열을 리스트로 변환
//        String[] arr = {"java","ptyhon","C++"};
//        List<String> myList4 = new ArrayList<>(Arrays.asList(arr));

//        List의 출력 
//        List등(Map,Set)의 컬렉션프레임워크 안에는 toString메서드가 구현되어있고, 자동호출
//        (참조자료형 : 클래스 기반의 객체 -> 힙메모리에 저장)
//        System.out.println(myList4);
        // 배열안의 값을 리스트에 통째로 집어넣음

//        List의 안의 자료타입으로는 기본형타입은 쓸 수 없음
//        int[] intArr = {10,20,30};
//        List<Integer> myList5 = new ArrayList<>(); // 오토박싱이라서 가능 int형
//        for(int i : intArr){
//            myList5.add(i);
//        }
//        add : 리스트에 값을 하나씩 추가하는 메서드
//        List<Integer> myList = new ArrayList<>();
//        myList.add(10);
//        myList.add(20);
//        myList.add(0,30); ;// list는 중간위치에 데이터를 삽입/삭제 작업은 비효율적
//        System.out.println(myList); // [30, 10, 20]
//
////        get(index) : 특정 index의 요소 반환
//        System.out.println(myList.get(2)); // 20
//

////        size() : 리스트의 개수(길이)를 반환
//        System.out.println(myList.size()); // 3
//

////        리스트의 값 출력 방법1. 일반 for문
//        for(int i=0;i<myList.size();i++){
//            System.out.print(myList.get(i) + " ");
//        }
//        System.out.println();

////        리스트의 값 출력 방법2. 향상된 for문
//        for(int i : myList){
//            System.out.print(i +" ");
//        }

////       remove : 값 삭제, index 지정하여 삭제함

//        List<Integer> myList = new ArrayList<>();
//        myList.add(10);
//        myList.add(20);
//        myList.add(30);
//        myList.remove(myList.size()-1); // 뒤에서 삭제함, 앞에서 삭제하면 인덱싱 다시해야되서 성능 저하

////        indexOf : 특정값을 찾아 index return(가장 먼저나오는 값)
//        List<Integer> myList = new ArrayList<>();
//        myList.add(10);
//        myList.add(20);
//        myList.add(30);
//        myList.add(30);
//        System.out.println(myList.indexOf(30)); // 2

////        contains : 값이 있는지 없는지 여부를 리턴
//        System.out.println(myList.contains(20)); // true

//        프로그래머스 : n의 배수 고르기

//        정렬 : 방법 2가지(Collections클래스의 sort메서드 사용, 객체의 sort메서드 사용)
//        List<Integer> myList = new ArrayList<>();
//        myList.add(5);
//        myList.add(3);
//        myList.add(2);
//        myList.add(1);
//        myList.add(4);
//
//★        Collections.sort(myList); // 오름차순
//        Collections.sort(myList, Comparator.reverseOrder()); // 내림차순
//        System.out.println(myList);
//        // 둘의 차이 없음 nlong(n)
//        myList.sort(Comparator.naturalOrder()); // 오름차순
//        myList.sort(Comparator.reverseOrder()); // 내림차순
//        System.out.println(myList);

//        이중리스트 : 리스트안의 리스트
//        List<List<Integer>> myList = new ArrayList<>();
//        List<Integer> m1 = new ArrayList<>();
//        myList.add(m1);
//        myList.add(new ArrayList<>());
////        myList.get(0).add(1);
//        m1.add(1);
//        m1.add(2);
//        m1.add(3);

//        [[1,2,3],[4,5,6]]
//        List<List<Integer>> myList = new ArrayList<>();
//        List<Integer> m1 = new ArrayList<>();
//        myList.add(m1);
//★        myList.add(new ArrayList<>()); // 다른 공간이 생긴거임 ex) m2
//        m1.add(1);
//        m1.add(2);
//        m1.add(3);
//        myList.get(1).add(4);
//        myList.get(1).add(5);
//        myList.get(1).add(6);
//        System.out.println(myList);

//        [[1,2,3],[4,5,6],[7,8,9], ... , [58,59,60]] 형태의 이중 리스트 생성

//        List<List<Integer>> myList = new ArrayList<>();
//        for(int i=0; i<20; i++){
//            myList.add(new ArrayList<>());
//        }
//        for(int i=0; i<myList.size(); i++){
//            for(int j=(i*3)+1; j<(i*3)+4; j++){
//                myList.get(i).add(j);
//            }
//        }
//        System.out.println(myList);

//        리스트안의 배열
//      [{10,20}, {1,2,3}, {4,3,2,1}]

        List<int[]> myList = new ArrayList<>();

        int[] arr = new int[2];
        arr[0]=10;
        arr[1]=20;
        myList.add(arr);
        myList.add(new int[3]);
        myList.get(1)[0]=1;
        myList.get(1)[1]=2;
        myList.get(1)[2]=3;
        myList.add(new int[]{4,3,2,1});
        System.out.println(myList); // 배열 주소값이 출력. [x1배열주소, x2배열주소, x3배열주소]
        for(int i=0; i<myList.size(); i++){
            System.out.println(Arrays.toString(myList.get(i)));
        }

    }
}
