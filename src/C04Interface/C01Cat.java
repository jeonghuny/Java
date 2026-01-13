package C04Interface;

//인터페이스 상속(구현)시 implements 키워드 사용
//인터페이스의 다중상속은 허용 -> 어차피 오버라이딩해서 내가 쓰는 거기 때문에 (상속받는 메소드가 겹친다 해도)
// 클래스 관계의 다중상속은 안됨.
public class C01Cat implements C01AnimalInterface1, C01AnimalInterface2{

    @Override
    public void makeSound() {
        System.out.println("야옹야옹");        
    }

    @Override
    public void eat(String food) {
        System.out.println(food + "츄르를 먹습니다.");
    }
}
