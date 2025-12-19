package C02MethodClass;

public class C04Person {
//    객체변수는 일반적으로 변수의 안정성을 위해 private(클래스내에서만 접근 가능한 접근제어자)으로 설정
//    default면 같은 패키지내의 클래스에서 접근 가능함.
    private String name;
    private String email;
    private int age;
//    setter와 getter를 통해 외부에서 객체변수에 접근가능하도록 설정
//    setter, getter는 외부 접근이 가능하도록 일반적으로 public하게 설정
//    setter는 피치못하면 쓰고, 그렇지 않다면 생성자를 활용하자는 느낌으로 발전함.
    public void setName(String name){
        this.name = name;
    }
    // setter에 값을 넘기면 내가 세팅해줄게 -> 이렇게 해석
    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
    // 값을 접근할수 있는 메서드
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String returnPersonInfo(){
        return "이름은 "+ this.name + ", 이메일은 " + this.email + ", 나이는 " + this.age +"입니다.";
    }
//    객체 메서들간의 호출은 문제없이 호출 가능
    public void testMethod1(){
        // this는 없어도 되지만, 객체가 호출할거기에 써줌
        String temp = this.returnPersonInfo();
    }
//        클래스 메서드는 기본적으로 객체생성을 가정하지 않으므로, 클래스메서드내에서 객체메서드를 호출하는 것은 불가능.
//        객체 메서드도 아니고, 객체가 없는다는 가정하에 만든 메서드이다.
//        객체 메서드는 객체메서드 끼리 선언할 수 있다.
    public static void testMethod2(){
//        String temp = this.returnPersonInfo();
    }
}
