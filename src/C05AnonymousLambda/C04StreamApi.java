package C05AnonymousLambda;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C04StreamApi {
    public static void main(String[] args) {
        int[] arr = {20,10,4,12};
////        전통적인 방식의 데이터 접근방법 : 메모리주소접근
//        for(int i=0; i<arr.length; i++){
//            System.out.println(arr[i]);
//        }

//        함수형 프로그래밍 방식 : 데이터와 객체 중심이 아닌 입력에 따른 출력(연산작업포함)만 존재하는 코딩스타일
//        streamApi : java에서 함수형프로그래밍을 지원하는 라이브러리
        // 함수형프로그램 ? :
        // StreamApi :
/*


 */
        Arrays.stream(arr).forEach(a -> System.out.println(a));
        // stream이라는 객체가 만들어짐
        // 그 객체는 forEach라는 함수가 있음
        // foreach는 스트림의 각 요소를 하나씩 소모하면서 동작을 수행

//        스트림의 생성 : .stream()
        List<String> myList = new ArrayList<>();
        myList.add("java");
        myList.add("python");
        myList.add("c++");
        Stream<String> stream1 = myList.stream();
        String[] myArr = {"java","python","c++"};
        Stream<String> stream2 = Arrays.stream(myArr);

//        원시 자료형을 위한 stream객체가 별도로 존재
//        int[] intArr = {10,20,30,40,50};
//        IntStream stream3 = Arrays.stream(intArr);
        // (IntStream도 있다. 원시자료형을 위한)

//        stream의 중개연산(변환) : filter, map, sorted, distinct, mapToInt
//        int[] intArr = {10,10,30,40,50};
//        int sum = 0;
//        for(int i=0; i<intArr.length; i++){
//            sum+=intArr[i];
//        }
//        filter : 특정기준으로 대상을 필터링하여 새로운 그스트림을 반환하는 중개연산
//        sum : 스트림의 요소를 하나씩 소모하여 총합을 구하는 메서드
//        int total = Arrays.stream(intArr).filter(a->a>=30).sum();
//        System.out.println(total);

        // Arrays.stream(intArr).filter(a->a>=30) <- 여기까지는 intStream 타입

//        map :  기존의 스트림을 조작하여 새로운 스트림을 반환
//        int total2 = Arrays.stream(intArr).map(a-> a*a).sum();
//        System.out.println(total2); // 5200

////        distinct : 중복제거
//        int total3 = Arrays.stream(intArr).distinct().sum();
//        System.out.println(total3); // 130

//        sorted : 정렬
//        int[] sortedArr = Arrays.stream(intArr).sorted().toArray();
//        System.out.println(Arrays.toString(sortedArr)); // [10, 10, 30, 40, 50]

//        mapToInt : intStream형태로 변환해주는 map
//        String[] strArr = {"java","python","c++"};
//        // a->a.length() 하면서 Stream<String> 이 Stream<Integer>가 필요하게됨
//        int totalLength = Arrays.stream(strArr).mapToInt(a->a.length()).sum();
          // mapToInt를 통해서 IntStream이 됨
//        System.out.println(totalLength); // 13

//        int[] arr = {1,2,3,4,5,6};
////        실습 1) arr에서 홀수만 담은 배열을 생성 후 배열 출력
//        int[] answer = Arrays.stream(arr).filter(a->a%2!=0).toArray();
//        System.out.println(Arrays.toString(answer));

////        실습 2) arr에서 홀수만 걸러서 해당 홀수의 제곱값을 담은 배열을 출력
//        int[] answer2 = Arrays.stream(arr).filter(a->a%2!=0).map(a->a*a).toArray();
//        System.out.println(Arrays.toString(answer2));

////        실습 3) arr에서 홀수만 걸러 제곱값을 구하고, 해당숫자값을 오름차순한 순서로 배열을 출력
//        int[] answer3 = Arrays.stream(arr).filter(a->a%2!=0).map(a->a*a).sorted().toArray();
//        System.out.println(Arrays.toString(answer3));

////   stream의 소모 : foreach(출력), sum(합계), count, max, min, reduce(누적연산), findFirst(스트림의 첫번째값 리턴)
//        int[] intArr = {10,20,30,40};
//        Arrays.stream(intArr).forEach(a-> System.out.println(a));
//        int total = Arrays.stream(intArr).sum(); 
//        long count = Arrays.stream(intArr).count(); // count는 long
//        System.out.println(total + " " + count);
        
//       optional객체 : 값을 있을수도 있고, 없을수도 있음을 명시한 객체
//        int max = Arrays.stream(intArr).max().getAsInt();
//        System.out.println(max);
      // Arrays.stream(intArr)은 OptionalInt 이다. 실전은 getAsInt를 바로 쓰는것 아니고
      // orElseThrow를 쓴다.
      // -> int max = Arrays.stream(intArr).max().orElseThrow(()-> new NoSuchElementException());
//       int min = Arrays.stream(intArr).min().getAsInt();


////        reduce : 누적연산 -> reduce(초기값, 연산식)
//        int[] intArr = {10,20,30,40};
//        int accSum = Arrays.stream(intArr).reduce(0, (a,b)-> a+b);
//        System.out.println(accSum);
//        int accMultiply = Arrays.stream(intArr).reduce(1, (a,b)-> a*b);
//        System.out.println(accMultiply);
//        String[] strArr = {"java", "python", "c++"};
//        String result = Arrays.stream(strArr).reduce("",(a,b)->a+b);
//        System.out.println(result);
////        findFirst : 첫번째 요소 반환
//        String firstValue = Arrays.stream(strArr).filter(a->a.length()>5).findFirst().get();
//        System.out.println(firstValue);
//        Map<String,Integer> myMap = new TreeMap<>();
//        myMap.put("hello",10);
//        myMap.put("java",20);
//        String firstKeyValue = myMap.keySet().stream().findFirst().get();
//        System.out.println(firstKeyValue);
//
//        배열로 변환시 주의사항 : 제네릭의 타입소거를 주의
//        자바의 런타임시점에 <String>과 같은 제네릭의 타입이 제거된다!
//        제네릭의 타입소거로 인해, toArray를 통해 새로운 String배열을 곧바로 만들어내는 것은 불가하다.
//        String[] stArr = {"hello", "java","world"};
//        String[] answer = Arrays.stream(stArr). filter(a->a.length()>=5).toArray(a->new String[a]); // a안에는 배열의 길이가 담김
//        System.out.println(Arrays.toString(answer));

//        <나의 정리>
//        toArray()는
//        제네릭 타입이 런타임에 사라지기 때문에(Object만 남아서)
//        기본적으로 Object[]만 만들 수 있다.
//        그래서 “String 배열은 이렇게 만들어라” 라고 (배열은 런타임에 타입을 정확히 알아야 생성 가능)
//        생성자를 직접 넘겨줘야 한다. (new String[n]은 런타임 타입 정보 필요)

////        메소드 참조 : 하나의 메소드만을 호출하는 경우에 매개변수를 제거한 형식
////        형식-"클래스명::메서드명", 조건-하나의 메서드만(실행문)을 호출하는 경우
//        Arrays.stream(stArr).forEach(a-> System.out.println(a));
//        Arrays.stream(stArr).forEach(System.out::println);
        
//        String[] answer2 = Arrays.stream(stArr). filter(a->a.length()>=5).toArray(String[] :: new);
//        String[] answer2 = Arrays.stream(stArr). filter(a->a.length()>=5).toArray(a->String(a));        
//
//        List<Student> myList = new ArrayList<>();
//        myList.add(new Student("kim",20));
//        myList.add(new Student("choi",30));
//        myList.add(new Student("lee",35));
//        myList.add(new Student("park",22));
////        1)모든 객체의 평균나이(average함수)
//        double avg = myList.stream().mapToInt(a->a.getAge()).average().getAsDouble();
//        System.out.println(avg);
////        2)정렬을 통한 가장 나이 어린 사람 찾기(sorted + findFirst)
//        Student s1 = myList.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).findFirst().get();
//        System.out.println(s1);
////        3)30대인 사람들만의 이름만 모아서 새로운 String배열에 담기(map활용)
//        String[] arr = myList.stream().filter(a->a.getAge()>=30).map(a->a.getName()).toArray(a->new String[a]);
//        System.out.println("--------------------------------------");

        
//        Optional객체 : 특정객체에 값이 없을지도(null) 모른다는 것을 명시적으로 표현한 객체
//        Spring에서는 매우 빈번함
//        String st1 = null;
//        if(st1==null){
//            System.out.println("값이 없습니다.");
//        }else{
//            System.out.println(st1.length());
//        }
//        Optional<String> opt1 = Optional.ofNullable(null);
//        if(opt1.isPresent()){
//            System.out.println(opt1.get().length());
//        }else{
//            System.out.println("값이 없습니다.");
//        }

//        Optional객체 생성 방법 3가지.
        Optional<String> opt1 = Optional.empty(); // 비어있는 optional객체 생성
        // Optional.empty() vs Optional.ofNullable(null) ↓
        // 처음부터 값이 없음을 명시.(empty)
        Optional<String> opt2_1 = Optional.ofNullable(null); // 비어있는 optional객체 생성
        // opt2_2처럼 값이 있을 수도 없을 수도 있었음. ofNullable()
        Optional<String> opt2_2 = Optional.ofNullable("hello"); // 값이 있는 optional객체 생성
        Optional<String> opt3 = Optional.of("hello"); // 값이 있는 optional객체 생성
        
        // 예외(에러) : 코드 중단
        // 1.예외 강제 발생 : 더이상 진행되며 안되기 때문
        // 2.예외 처리 : 사용자에게 적절한 메세지
        
//        Optional객체 처리 방법 4가지
//        방법1. isPresent()로 확인후에 get() - 2번째로 많이 사용
//        if(opt2_2.isPresent()){
//            System.out.println(opt2_2.get());
//        }else{
//            System.out.println(opt1.get()); // 에러발생
//            System.out.println("값이 없습니다.");
//        }
//        방법2. orElse() : 값이 있으면 있는 값 return, 없으면 지정한 값 return
//        System.out.println(opt2_1.orElse("값이 없습니다."));
//        System.out.println(opt2_2.orElse("값이 없습니다."));
//
////        방법3. orElseGet() : 값이 있으면 있는 값 return, 없으면 람다함수 실행
//        System.out.println(opt2_1.orElseGet(()->new String("값이 없습니다..")));

//        방법4. orElseThrow() - 가장많이사용, 값이 있으면 있는 값 return, 없으면 지정한 예외(에러) 강제발생.
//        웹개발에서 값을 입력하는 사용자에게 적절한 메시지 전달 목적과 의도된 코드중단을 목표로 강제로 예외에러 발생시키는 경우는 매우 일반적.
//        System.out.println(opt2_1.orElseThrow(()->new RuntimeException("값이 없습니다.")));
//        System.out.println(opt2_1.get()); // 의도치않은 에러발생.(지양해야할 에러)

//        optional객체 처리 실습1)
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(new Student("kim",20));
//        studentList.add(new Student("choi",30));
//        studentList.add(new Student("lee",35));
//        studentList.add(new Student("park",22));

//        optional객체 처리 방법1)
//        OptionalDouble optionalAvg = studentList.stream().mapToInt(a->a.getAge()).average();
//        double value1 = 0;
//        if(optionalAvg.isPresent()){
//            value1 = optionalAvg.getAsDouble();
//            System.out.println(value1);
//        }else{
//            System.out.println("값이 없습니다.");
//        }

//        optional객체 처리 방법2)
//        double value2 = studentList.stream().mapToInt(a->a.getAge()).average().orElseThrow(()-> new NoSuchElementException("값이 없습니다."));
//        System.out.println(value2);

//        optional객체 처리 실습2)
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(new Student("kim",20));
//        studentList.add(new Student("choi",30));
//        studentList.add(new Student("lee",35));
//        studentList.add(new Student("park",22));
//        System.out.println("조회하고자 하는 student의 index번호를 입력해주세요");
//        Scanner sc = new Scanner(System.in);
//        int number = Integer.parseInt(sc.nextLine());
//        Optional<Student> s1;
//        if(studentList.size() <= number || number < 0){
//            s1 = Optional.empty(); // 값이 없을땐 empty 사용
//        }else{
//            s1 = Optional.of(studentList.get(number)); // 있을땐 of 로 세팅
//        }
//        System.out.println(s1.orElseThrow(()-> new NoSuchElementException("없는 회원입니다.")));
    }
}

// 서버에서는 사용자가 보낸 내용 파싱 -> 객체로 바꿈
// 파싱 자체가 사용자 request를 처리 (Controller) -> Service에서 핵심로직 수행 , 검증, 예외강제 발생
// Controller 에서 try Catch를 해서 response 처리 -> 사용자에게 예외처리 응답
