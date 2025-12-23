package C02MethodClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C08AccountMain {
    public static void main(String[] args) {
//        계좌개설(객체생성)
//        List 계좌객체를 담는 자료구조어 사용

//        계좌1("12345")에서 계좌2("54321")로 송금(50000) : 잔고 변경 메서드 필요
//        내 객체를 찾아서 50000원을 차감하고 상대방 객체를 찾아서 50000원을 가산한다.
//        List<Account> myList = new ArrayList<>();
//        Account acKim = new Account("김정훈","12345",100000);
//        Account acLee = new Account("이양반","54321", 100000);
//        myList.add(acKim);
//        myList.add(acLee);
//        myList.add(new Account("김정훈","12345",100000));
//        myList.add(new Account("이양반","54321", 100000));
//
//        Account from = null;
//        Account to = null;
//        for(Account a : myList){
//            if(a.getAccountNumber().equals("12345")) from = a;
//            if(a.getAccountNumber().equals("54321")) to = a;
//        }
//        if(from!=null && to!=null){
//            if(from.getBalance()>=50000){
//                to.setBalance(to.getBalance()+50000);
//                from.setBalance(from.getBalance()-50000);
//            }else{
//                System.out.println("잔액이 부족합니다.");
//            }
//        }else{
//            System.out.println("계좌번호 오류입니다.");
//        }
////        System.out.println(from);
////        System.out.println(to);
//        System.out.println(myList);


//        Map을 계좌객체를 담는 자료구조로 사용
        Map<String,Account> accountMap = new HashMap<>();
        accountMap.put("12345",new Account("hong1","12345",1000000));
        accountMap.put("54321",new Account("hong2","54321",0));

        Account from = accountMap.get("12345");
        Account to = accountMap.get("54321");
        from.transfer(to,50000);
        System.out.println(accountMap);
    }
}


// Account 클래스 - 계좌주명(name), 계좌번호(accountNumber-String); 잔고(balance-long)
// toString 까지 넣기