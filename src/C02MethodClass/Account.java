package C02MethodClass;

public class Account {
//    참조자료형은 초기값 null Wrapper클래스 씀.
//    private long id;  생성자 없이 setter로 객체생성된다면 모두 0으로 생성되기에 맞지 않는다.
    private Long id;
    private String name;
    private String accountNumber;
//    원시자료형은 각 자료형에 맞는 초기값 , 계좌금액은 초기값 0일 것이기 때문에
    private long balance;
    private static long staticId;

    public Account(String name, String accountNumber, long balance) {
        staticId++;
        this.id = staticId;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    //      setBalance보다는 의도를 명확히한 메서드명을 사용하기를 권장
    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void transfer(Account targetAccount, long money){
        if(this.balance >= money){
//        송금할객체에서 돈을 차감
            this.balance -= money;
//        송금받을 객체에 돈을 가산
            targetAccount.balance += money;
        }else{
            return;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
