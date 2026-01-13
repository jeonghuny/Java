package C07ExceptionFileParsing.MemberException;

//객체 - 엔티티
public class Member {
    private static long staticId = 0L;
    private Long id;
    private String name;
    private String email;
    private String password;

    public Member(String name, String email, String password) {
        staticId++;
        this.id = staticId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

/*
1. 코드의 책임 : Controller , Service, Repository

  Controller - 사용자와 인터페이스
  Service - 핵심로직, 비즈니스로직
  Repository - 저장소에 CRUD하는 코드, Entity(클래스,객체)

2. 예외처리 : Service에서 에러를 터트린다. Controller에서 예외처리를 하여, 사용자에게 메시지전달.

3. Optional객체의 효용 -> null처리의 실수방지.

<각 클래스의 관심사>
Repository	DB, 파일, 네트워크
Service	비즈니스 규칙
Controller	사용자 응답

서비스가 IOException을 던진다? ❌
서비스가 기술 세부사항(DB/파일)을 컨트롤러에게 노출




 */