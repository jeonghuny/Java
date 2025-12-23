package C02MethodClass;

import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
        <계좌개설 및 입출금 서비스>
        1.계좌객체 : id(auto_increment Long), name(String), accountNumber(String), balance(long)
        2.자료구조 :  계좌객체를 담아둘 자료구조는 Map
        3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요.
            3-1)계좌개설 : "이름"과 사용하실 "계좌번호"와 현재 "가지고있는돈"을 입력하세요. -> 자동으로 id값 증가되어 객체 생성
            3-2)계좌조회 : 계좌조회서비스입니다. 조회하실 계좌의 계좌번호를 입력해주세요. -> 계좌주명, 계좌번호번호, 잔고를 보기좋게 출력
            3-3)입금 : 계좌입금서비스입니다. 입금하실 계좌번호와 입금금액을 입력해주세요. -> 입금전 잔액, 입금후 잔액 출력
            3-4)출금 : 계좌출금서비스입니다. 출금하실 계좌번호와 출금금액을 입력해주세요. -> 잔액검증 -> "출금 후 남은 금액은 얼마입니다" 또는 "잔액이 부족합니다" 출력
            3-5)송금 : 송금서비스입니다. 본인의 계좌번호, 상대방의 계좌번호, 송금금액을 입력해 주세요. -> 잔액검증 -> "송금 후 남은 금액은 얼마입니다" 또는 "잔액이 부족합니다" 출력.
        4.주의사항
            4-1)프로그램은 상시적 실행될수 있도록 전체코드를 while(true)처리
            4-2)main메서드에서 입출력 처리를 하고, 입금(deposit), 출금(withdraw), 송금(transfer)기능에 대한 핵심 메서드는 BankAccount클래스에 생성.
         */
        //
public class C09BankService {
    static Map<String, BankAccount> customer = new HashMap<>();

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("사용하실 서비스 번호를 입력해주세요.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int number = Integer.parseInt(br.readLine());
            if (number == 1) {
//                계좌개설
                System.out.println("계좌개설서비스입니다.");
                System.out.println("이름과 사용하실 계좌번호와 현재 가지고 있는 돈을 입력하세요");
                String name = br.readLine();
                String account = br.readLine();
                long balance = Long.parseLong(br.readLine());
                customer.put(account, new BankAccount(name, account, balance));
                System.out.println("계좌가 생성되었습니다.");
            } else if (number == 2) {
                System.out.println("계좌조회서비스입니다. 조회하실 계좌의 계좌번호를 입력해주세요.");
                String account = br.readLine();
                if (customer.containsKey(account)) {
                    BankAccount c = customer.get(account);
                    System.out.println("계좌주명 : " + c.getName() + ", 계좌번호 : " + c.getAccountNumber() + ", 잔고 : " + c.getBalance());
                } else {
                    System.out.println("계좌번호가 존재하지 않습니다.");
                }
            } else if (number == 3) {
                System.out.println("계좌입금서비스입니다. 입금하실 계좌번호와 입금금액을 입력해주세요.");
                String account = br.readLine();
                long money = Long.parseLong(br.readLine());
                if (customer.containsKey(account)) {
                    BankAccount to = customer.get(account);
                    System.out.println("입금전 잔액입니다. " + to.balance);
                    to.deposit(money);
                    System.out.println("입금후 잔액입니다. " + to.balance);
                } else {
                    System.out.println("계좌번호가 존재하지 않습니다.");
                }
            } else if (number == 4) {
                System.out.println("계좌출금서비스입니다. 출금하실 계좌번호와 출금금액을 입력해주세요.");
                String account = br.readLine();
                long money = Long.parseLong(br.readLine());
                if (customer.containsKey(account)) {
                    BankAccount from = customer.get(account);
                    if(!from.checkBalance(money)){
                        System.out.println("잔액부족입니다.");
                    }else{
                        System.out.println("출금전 잔액입니다. " + from.balance);
                        from.withdraw(money);
                        System.out.println("출금후 잔액입니다. " + from.balance);
                    }
                } else {
                    System.out.println("계좌번호가 존재하지 않습니다.");
                }
            } else if (number == 5){
                System.out.println("송금서비스입니다. 본인의 계좌번호를 입력해 주세요");
                String fromAccount = br.readLine();
                System.out.println("상대방의 계좌번호를 입력해 주세요");
                String toAccount = br.readLine();
                System.out.println("송금금액을 입력해 주세요");
                long money = Long.parseLong(br.readLine());

                BankAccount from = customer.get(fromAccount);
                BankAccount to = customer.get(toAccount);
                if (!from.checkBalance(money)) {
                    System.out.println("잔액부족입니다.");
                } else {
                    if (to != null) {
                        from.transfer(to,money);
                        System.out.println("송금전 잔액입니다. " + from.balance);
                        System.out.println("송금후 잔액입니다. " + from.balance);
                    }
                }
            }
        }
    }

    static class BankAccount {
        private Long id;
        private String name;
        private String accountNumber;
        private long balance;
        private static long staticId = 0;

        public String getName() {
            return name;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public long getBalance() {
            return balance;
        }

        public boolean checkBalance(long money){
            if(this.balance <money){
                 return false;
            }else {
                return true;
            }
        }

        public BankAccount(String name, String accountNumber, long balance) {
            staticId++;
            this.id = staticId;
            this.name = name;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public void deposit(long money) {
            this.balance += money;
        }

        public void withdraw(long money) {
            this.balance -= money;
        }

        public void transfer(BankAccount to, long money) {
            this.balance -= money;
            to.balance += money;
        }

        @Override
        public String toString() {
            return "BankAccount{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", accountNumber='" + accountNumber + '\'' +
                    ", balance=" + balance +
                    '}';
        }
    }
}