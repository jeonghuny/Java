package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C09Array {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// !! 면접 : 배열 vs 리스트  -> 리스트는 동적으로 길이 변화 가능
////        배열표현식 1. 배열 선언 후 값 할당 방식
//        java의 배열은 반드시 사전에 길이가 결정되어야 함.
//        int[] arr1 = new int[]; // 허용안됨. 길이 없음.
        
//        int[] arr1 = new int[5];
//        arr1[0]=10;
//        arr1[1]=20;
////        int배열의 경우 선언시 기본적으로 0으로 초기화. boolean은 초기화, 참조자료형은 null로 초기화.
//        arr1[3]=40;
//        arr1[4]=50;
////        arr1[5]=60; // index out of bounds 예외 발생.
////        배열표현식 2. 리터럴방식
//        int[] arr2 = {10,20,30,40,50};

////        배열표현식 3. 명시적 배열 생성 방식
//★        int[] arr3 = new int[]{10,20,30,40,50};
//
////        배열표현식 3.활용예시 : 배열을 다른 메서드의 매개변수로 사용할 경우.
//        List<int[]> myList = new ArrayList<>();
//        int[] myArr = new int[3];
//        myList.add(new int[5]);
//        myList.add(new int[]{10,20,30,40,50});
////        myList.add({10,20,30,40,50});  //사용불가. 배열인지 아닌지 확인불가
//
//        List<int[]> list = new ArrayList<>();
//        int[] arr = new int[3];
//        list.add(arr);
//        list.add(new int[3]);
//        list.add(new int[3]{1,2,3});
//        <위 코드와 같이 안되는 이유>
//        1. 크기만 지정해야됨. 2. 초기값을 직접지정(크기는 자동으로 지정됨)
        // 아래와 같이 문법적으로 허용된다면, 모호함이 생김
//        new int[3]{1,2,3,4}  // ❓ 크기 초과?
//        new int[3]{1,2}      // ❓ 나머지는?



//        85,65,90 으로 구성된 int배열을 선언하고, 총합과 평균을 구하시오

//        int[] arr = new int[]{85,60,90};
//        int sum = 0;
//        double avg = 0;
//        for(int i=0; i<arr.length;i ++){
//            sum += arr[i];
//        }
//        avg = (double)sum / arr.length;
//        System.out.println("총합 : "+ sum + "\n평균 : " + avg);

//        배열의 최대값, 최소값
//        int[] arr = {10,20,30,12,8,17};
////        최대값을 구할때는 가장 작은 값을 설정.
//        int max = Integer.MIN_VALUE;
//
//        int min = Integer.MAX_VALUE;
//
//        for(int i=0; i<arr.length; i++){
//            if(arr[i] > max){
//                max = arr[i];
//            }
//            if(arr[i] < min){
//                min = arr[i];
//            }
//        }
//        System.out.println(max + " " + min);

//        배열의 자리 바꾸기
//        int[] arr = {20,10,30};
//        int temp = arr[0];
//        arr[0] = arr[1];
//        arr[1] = temp;

//        배열 뒤집기
//        int[] arr = {10,20,30,40,50};
//        int[] newArr = new int[arr.length];
//        for(int i=0; i < arr.length; i++){
//            newArr[i] = arr[arr.length-i-1];
//        }
//        System.out.println(Arrays.toString(newArr));
//
//        for (int i = arr.length-1; i>=0; i--){
//            newArr[(arr.length-1)-i] = arr[i];
//        }

//        배열의 정렬
//        String[] stArr = {"abc","aaa","acb","abb"};
//        Arrays.sort(stArr); // 오름차순 정렬 -> 클래스 메서드
////        stArr.length -> 객체 메서드
//        System.out.println(Arrays.toString(stArr));
//★        Arrays.sort(stArr, Comparator.reverseOrder()); // 내림차순 정렬
//        System.out.println(Arrays.toString(stArr));
//        int[] arr = {17,12,20,10,15};
//        Integer[] arr2 = {17,12,20,10,15};
//        Arrays.sort(arr); // 오름차순 정렬
//        Arrays.sort(arr2, Comparator.reverseOrder());
//        System.out.println(Arrays.toString(arr2));
//★        Arrays.sort(arr, Comparator.reverseOrder()); // 원시자료형은 Comparator 사용 불가능
//        첫번째 for문 자리결정, 두번째 for문

//        선택정렬 알고리즘 구현 (자리는 선택하는 것)
//        구현로직 : 1) 2중for문을 사용하여 index마다 최소값 찾기 2) 현재위치와 자리 change
//        int[] arr = {17,12,20,10,15};
//        내장메서드 시간복잡도 : n*long(n)


//        방법1.
//        for(int i=0; i<arr.length; i++){
//            int min = arr[i];
//            int minIndex = i;
//            for(int j=i+1; j<arr.length; j++){
//                if(arr[j]<min){
//                    min = arr[j];
//                    minIndex = j;
//                }
//            }
////            자리바꾸기 : i와 index 자리 change
//            int temp = arr[i];
//            arr[i] = arr[minIndex];
//            arr[minIndex] = temp;
//        }
//        System.out.println(Arrays.toString(arr));


//        방법2.
//        for(int i=0; i<arr.length; i++){
//            for(int j=i; j<arr.length; j++){
//                if(arr[i] > arr[j]){
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));

//        선택정렬의 복잡도는 O(n^2). java 기본 내장 정렬함수의 복잡도 : O(n*log(n))

//        조합문제 : 모두 각기 다른 숫자의 배열이 있을때, 만들어질 수 있는 두 숫자의 조합을 출력
//        int[] arr = {10,20,30,40,50};
////      ex) (10,20),(10,30),(10,40),(10,50),(20,30),(20,40) ....
//        int count = 0;
//        for(int i=0; i<arr.length; i++){
//            for(int j=i+1; j<arr.length; j++){
//                sb.append("{"+arr[i]+", "+arr[j]+"}, ");
//                count++;
//            }
//        }
//        System.out.println(sb);
//        System.out.println(count);

//        배열의 중복제거 : set자료구조(중복x, 순서x)활용
//        ex) 10,20,30,40만 남도록.

//★        Set<Integer> mySet = new HashSet<>();
//        for(int a: arr){
//            mySet.add(a);
//        }
//        int[] answer = new int[mySet.size()];
//        int index = 0;
//        for(int a : mySet){
//            answer[index] = a;
//            index++;
//        }
//        Arrays.sort(answer);
//        System.out.println(mySet);
//        System.out.println(Arrays.toString(answer));


//★        배열의 검색 : 복잡도 O(n)
//        int[] arr = {1,3,6,8,8,9,11,15};
//        int target = 11;
////        target이 몇번째 index에 있는지 출력
//        int index = -1;
//        for(int i=0; i<arr.length; i++){
//            if(arr[i]==target){
//                index=i;
//                break;
//            }
//        }
//        System.out.println(index);
//★        이분탐색(이진검색) - brinary search, 복잡도 log(n) :  log(n)은 (log2(n) 인거임)
//★        사전에 데이터가 오름차순정렬되어 있는 경우만, 이분탐색 가능
//        int[] arr = {1,3,6,8,8,9,11,15};
//        int target = 11;
////        찾고자 하는 값이 있으면 해당 index리턴
////        찾고자 하는 값이 없으면 음수값 리턴
////        중복값있으면 정확한 인덱스를 찾지는 못함
//★        int index = Arrays.binarySearch(arr,target);
//        int index2 = Arrays.binarySearch(arr,8);
//        System.out.println(index);
//        System.out.println(index2);

//        1. 그냥 풀어서 시간초과
//        2. 이분탐색 써서 통과
//
//        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] A = new int[N];
//
//        for(int i=0; i<N; i++){
//            A[i]= Integer.parseInt(st.nextToken());
//        }
//
//        int M = Integer.parseInt(br.readLine());
//        int[] B = new int[M];
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<M; i++){
//            B[i]= Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(A);
//        for(int i=0; i<M; i++){
//            int index = Arrays.binarySearch(A,B[i]);
//            if(index>=0){
//                sb.append("1\n");
//            }else{
//                sb.append("0\n");
//            }
//        }
//        System.out.println(sb);

//        배열값 비교
//        int[] arr1 = {10,20,30};
//        int[] arr2 = {10,20,30};
//        System.out.println(arr1==arr2); // false
//        System.out.println(Arrays.equals(arr1,arr2)); // true

//        배열복사
//★        Arrays.copyOf(배열명, length), Arrays.copyOfRange(배열명, start, end)
//        int[] arr = {1,4,6,7,8,1,2,4,6};
//★       int[] arr1 = Arrays.copyOf(arr,4); // [1, 4, 6, 7]
//        System.out.println(Arrays.toString(arr1));
//★       int[] arr2 = Arrays.copyOfRange(arr,3,6); // [7, 8, 1]
//        System.out.println(Arrays.toString(arr2));

//        Arrays.fill : 배열에 모든값을 변경(채우기)
//        String[] arr = new String[5];
//        for(int i=0; i<arr.length; i++){
//            arr[i]="";
//        }
//        Arrays.fill(arr,"");
//
////        2차원배열의 선언과 값할당
////        {{1,2},{1,2},{1,2}}
////        방법1.선언 후 할당 방식
//        int[][] arr1 = new int[3][2];
//        arr1[0][0]=1;
//        arr1[0][1]=2;
//        arr1[1][0]=1;
//        arr1[1][1]=2;
//        arr1[2][0]=1;
//        arr1[2][1]=2;
////        방법2.리터럴방식
//        int[][] arr2 = {{1,2},{1,2},{1,2}};

//        [3][4]사이즈의 2차원 배열을 선언하고, 1~12까지 숫자값을 각 배열에 순차적으로 할당
//        {1,2,3,4},{5,6,7,8},{9,10,11,12}
//        int[][] arr = new int[3][4];
//        int num = 1;
//        for(int i=0; i<arr.length; i++){
//            for(int j=0; j<arr[i].length; j++){
//                arr[i][j] = num;
//                num++;
//                System.out.print(arr[i][j]+ " ");
//            }
//            System.out.println();
//        }
//
////        2차원 배열의 출력
//        System.out.println(arr); // 2차원 배열의 heap 주소값
//        System.out.println(Arrays.toString(arr)); // 각 1차원 배열의 heap 주소값
//        System.out.println(Arrays.deepToString(arr)); // 각 1차원 배열의 값을 출력

//        프로그래머스 - 행렬의 덧셈

//        프로그래머스 - K번째 수

//        가변배열 : 2차원 배열에서 각 1차원의 배열의 길이가 서로 다를 수 있는 배열의 구조
//        int[][] arr1 = {{1,2},{1,2,3},{1,2,3,4}};

//★        배열 전체길이는 반드시 사전할당되어야하지만, 1차원배열의 길이는 추후 할당 가능
//        int[][] arr2 = new int[3][];
//        arr2[0] = new int[2];
//        arr2[1] = new int[3];
//        arr2[2] = new int[4];

////        <나의 정리>
//        int[][] arr = new int[3][];
//        이 상태는 👇
//        arr[0] → null
//        arr[1] → null
//        arr[2] → null
//        그래서 반드시 안쪽 배열을 따로 만들어야 해 👇
//        arr[0] = new int[2];
//        arr[1] = new int[4];
//        arr[2] = new int[3];

        // 두번째 정리
//        int[][] arr;
//      👉 실제로는 arr → int[]의 배열
//        arr
//          ├── arr[0] → int[] → [ ?, ?, ? ]
//          ├── arr[1] → int[] → [ ?, ?, ? ]
//          └── arr[2] → int[] → [ ?, ?, ? ]
//        arr : 바깥 배열
//        arr[i] : 안쪽 배열 (1차원 배열)
        
    }
}
