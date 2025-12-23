package C07ExceptionFileParsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class C02ExceptionAdvance {
    public static void main(String[] args) {
//
////        의도된 예외 강제 발생*** : 특정 시점에 프로그램을 강제 중지시키기 위한 목적
//        Scanner sc = new Scanner(System.in);
//        System.out.println("이메일을 입력해주세요.");
//        String email = sc.nextLine();
//        System.out.println("비밀번호를 입력해주세요.");
//        String password = sc.nextLine();
//        register(email,password);
//        System.out.println("DB에 저장되는 코드");



//        checked exception의 처리방법
////        방법1. throws를 통해 checked예외처리를 위임받고, (시스템에 위임하는 것)
        // main에서도 throws -> 시스템에 위임하는 것 (실전에서 x)
//        String text = fileRead("src/C07ExceptionFileParsing/test.txt");
//        System.out.println(text);
////        방법2. throws를 통해 checked예외처리를 위임받고, 호출하는 쪽(Controller)에서 예외처리.
//        try {
//            String text = fileRead("src/C07ExceptionFileParsing/test.txt");
//            System.out.println(text);
//        }catch (IOException e){
////            사용자에게 메시지 전달(가정)
//            System.out.println("파일 처리 과정에서 에러가 발생했습니다.");
//            e.printStackTrace();
//        }

        // Service는 IOException을 비즈니스 실패(RuntimeException)로 선언한다.


////        방법3. checked예외를 try/catch하여 unchecked 예외 강제발생.(DB롤백을 목적)
        //       (DB 롤백을 목적으로 이렇게 처리함)
        try {
            String text = fileRead("src/C07ExceptionFileParsing/test.txt");
            System.out.println(text);
        }catch (RuntimeException e){
//            사용자에게 메시지 전달(가정)
            System.out.println("파일 처리 과정에서 에러가 발생했습니다.");
            e.printStackTrace();
        }
    }


    //    static String fileRead(String path) throws IOException {
    static String fileRead(String path) {
        Path filePath = Paths.get(path);
        String text = null;
        try {
            text = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }

    static boolean register(String email, String password){
        if(password.length()>=10){
            return true;
        }else{
//            예외를 강제 발생시킴으로서 이 시점에서 해당 메서드 강제 종료
//            예외는 기본적으로 메서드를 호출한 쪽으로 전파
            throw new IllegalArgumentException("비밀번호가 너무 짧습니다.");
        }
    }
    public static void test(){

    }

//    C07ExceptionFileParsing.MemberException : Member - 객체,
//    MemberController(main) - 사용자와 인터페이싱 계층
//    MemberService - 핵심로직처리계층
//    MemberRepository - 저장소계층(List)

//  [Controller]
//    - try / catch
//    - 사용자 메시지 출력

//  [Service]
//    - 검증
//    - RuntimeException 던짐

//  [Repository]
//    - DB / File / 외부 자원 접근

//    checked 예외는 Service에서 RuntimeException으로 바꿔서 던지고
//    Controller에서 잡아서 사용자에게 알린다

/*  3번째 방법은
1️⃣ 파일 읽기 시도
2️⃣ IOException 발생
3️⃣ Service에서 RuntimeException으로 변환
4️⃣ 예외가 호출 스택을 타고 Controller로 전파
5️⃣ Controller에서 catch
6️⃣ 사용자에게 "파일 처리 실패" 출력

📌 Service는 실패를 ‘결정’
📌 Controller는 실패를 ‘표현’

❌ Service에서 처리해버리면
catch (IOException e) {
    System.out.println("파일 에러");
}

- Controller는 실패 여부를 모름
- 흐름 계속 진행됨
- 사용자 메시지 통제 불가
 */

}