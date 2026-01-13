package C10Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C02Validation {
    public static void main(String[] args) throws IllegalAccessException {
        List<Member> memberList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("회원가입 서비스입니다.");
            System.out.println("이름을 입력해주세요.");
            String name = sc.nextLine();
            System.out.println("이메일을 입력해주세요.");
            String email = sc.nextLine();
            Member member = new Member(name,email);
//            추후 스프링에서는 아래와 같은 "validate메서드 + 직접만든어노테이션"이 모두 합해져 있는 이미 만들어진 어노테이션을 사용.
            validate(member); // ← 리플렉션으로 검사
            memberList.add(member);
        }
    }
    //    특정 변수에 NotEmpty 어노테이션 설정이 있을경우, 값이 비어있는지를 검사하는 메서드.
    static void validate(Object object) throws IllegalAccessException { // 제네릭은 실전에서 잘 사용 안함
//        리플렉션 기술을 통해 런타임시점에 private변수라 할지라도 객체 안의 필드값을 꺼내 확인할 수 있음.
        Field[] fieldList = object.getClass().getDeclaredFields();
        for (Field f : fieldList){
            if(f.isAnnotationPresent(NotEmpty.class)){
                f.setAccessible(true);
                String value = (String)f.get(object);
                if(value==null || value.isEmpty()){
                    NotEmpty n1 = f.getAnnotation(NotEmpty.class);
                    throw new IllegalArgumentException(n1.message());
                }
            }
        }
    }

}
class Member{
    private String name;
    @NotEmpty
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

// 활용할일은 거의 없음 (리플렉션을 이해하기 위한 것)
//어노테이션은 선언적 표시이고, 어떤 기능도 수행하지 않음.
//아래 NotEmpty어노테이션 클래스는 어떤 기능도 없지만, 특정 필드값이 비어있으면 안된다는 선언적 표시.
//리플렉션은 기본적으로 런타임에 동작하므로, 어노테이션을 사용할때에 기본적으로 런타임 동작을 설정한다.
@Retention(RetentionPolicy.RUNTIME)
@interface NotEmpty{
    //    어노테이션 클래스의 속성은 일반적으로 메서드 형태로 정의
    String message() default "this field cannot be empty!!";
}