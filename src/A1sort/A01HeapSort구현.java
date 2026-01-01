package A1sort;

// "트리탐색 + 재귀적 호출" 을 통한 힙정렬

//1.heap 자료구조로 만들기 : n * log(n)
// 1)최초힙구성
//         2)하나씩 add하여 n개 값을 add : n*log(n)
//        2. 하나씩 꺼내서 정렬 수행 (n개 값을 꺼내기) : n*log(n)
//        3. 최종적인 정렬 : 2n*log(n)
//        add 할때 상향식 Heapify , 꺼낼때 하향식

//        1.heap 자료구조로 만들기 : n * log(n)
//         1)최초힙구성
//          1-1) 부모와 자식노드 분리 : 전체길이/2
//          1-2) 부모 * 2 + 1 = 왼쪽자식, 부모 * 2 + 2 = 오른쪽자식
//          1-3) 재귀호출
//        2. 하나씩 꺼내서 정렬 수행 : n*log(n)

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class A01HeapSort구현 {
    public static void main(String[] args) {
//        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
////        1.최소힙 구성
////        1-1)부모노드(n/2)와 자식노드 분리(n/2) 분리하여 부모노드를 대상으로 heapify
////        1-2)자식노드의 왼쪽노드 : 부모노드x2 + 1, 자식노드의 오른쪽 노드 : 부모노드x2 + 2
////        1-3)heapify의 과정이 재귀호출로 이루어짐
//        for(int i=arr.length/2-1; i>=0; i--){
//            heapify(arr, i, arr.length);
//        }
//
////      최초힙 결과 : arr[] = {1, 3, 5, 6, 7, 5, 9, 8, 6};
//        System.out.println(Arrays.toString(arr));
//
////        2.루트노드와 최하위노드를 자리change해가면서 재heapify
////        2-1)자리change한 마지막노드는 heapify대상에서 제외
////        2-2)최소힙 -> 내림차순정렬, 최대힙 -> 오름차순정렬
//        for(int i=arr.length-1; i>=0; i--){
//            int temp = arr[0];
//            arr[0] = arr[i] ; // 마지막자리값 감소
//            arr[i] = temp;
//            heapify(arr,0, i); // 전체길이 감소
//        }
//
//        System.out.println(Arrays.toString(arr));
//    }
//    static void heapify(int[] arr, int parentIndex, int length){
////        자식노드와의 비교. 자식노드가 더 작으면 자리 change
//        // 자식노드 표현 종종 나온다.
//        int leftIndex = parentIndex * 2 + 1;
//        int rightIndex = parentIndex * 2 + 2;
//        int smallestIndex = parentIndex;
////        가장 작은 index값 찾기
//        // 3개의 수를 비교할때 아래와 같은 방법
//        if(leftIndex < length && arr[leftIndex] < arr[smallestIndex]){
//            smallestIndex = leftIndex;
//        }
//        if(rightIndex < length && arr[rightIndex] < arr[smallestIndex]){
//            smallestIndex = rightIndex;
//        }
////        가장 작은 index가 부모노드가 아니라면 자리 change 및 heapify
//        if(parentIndex != smallestIndex){
//            int temp = arr[parentIndex];
//            arr[parentIndex] = arr[smallestIndex];
//            arr[smallestIndex] = temp;
//            heapify(arr, smallestIndex, length);
//        }


//        자리가 change된다면, 재귀호출

//        heapify(arr, 자식노드의index);


//        pq를 통한 정렬방법
//        pq를 가지고 직접 정렬을 수행하기보다는 지속적으로 값을 add하고 poll해 나가는 상황에서 사용
//        최초힙구성 : n * log(n)
//        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(7, 6, 5, 8, 3, 5, 9, 1, 6));
//        System.out.println(pq);
//        System.out.println(pq.poll()); // poll의 복잡도 log(n)
//        pq.add(2); // add의 복잡도 log(n)

        int[] arr = new int[]{10, 100, 20, 150, 1, 100, 200};
        int k = 3;
        int[] answer =  new int[arr.length];
        Queue<Integer> pq_score = new PriorityQueue<>();



    }
}