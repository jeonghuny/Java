package C09NetWorking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C01WebServerGet {
    public static void main(String[] args) throws IOException {
//        사용자 : 크롬을 통해 http://서버url get 요청 (http요청문서조립필요)
//        서버 : "hello world java" 문자열을 응답 (http응답문서조립필요)
        //웹 통신은 “그냥 문자열 주고받기”인데
        //그 문자열을 반드시 HTTP 형식으로 조립해야 한다는 뜻
        // 가정 : 크롬 - 웹 브라우저 (사용자)
        // 자바 - 인텔리제이 (판교, 서버)

//        소켓이란 서버와 사용자가 통신을 하기 위한 네트워크통신의 끝점을 나타내는 개념. (논리적인 가상개념)
        ServerSocket serverSocket = new ServerSocket(8080);
        // 8080 포트에서 클라이언트 접속을 기다림
        System.out.println("서버시작");
        // 사용자에게 전달하려면 http문서로 전달해야됨
        while(true){
//            accept : 사용자의 연결 요청을 수락
// ★★★      socket객체 안에는 사용자가 보내온 http요청문서 및 사용자정보(ip등)
            Socket socket = serverSocket.accept();
            //브라우저가 http://localhost:8080 요청
            //TCP 연결 수립
            //이 사용자 전용 통신 통로(Socket) 생성됨
            // HTTP스펙 이랑 상태코드(200)
//            사용자에게 서버의 응답메세지를 전송
            String response = "HTTP/1.1 200 OK\r\n\r\n" + "hello world java";
            //HTTP/1.1 200 OK   ← 상태라인
            //                   ← (빈 줄, 헤더 끝)
            //hello world java  ← 응답 바디
            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
            //출력 버퍼에 데이터 작성
//            flush란 일반적으로 변경사항을 확정하는 것을 의미
            socket.getOutputStream().flush();
            //“지금까지 쓴 거 실제로 전송해”
            socket.close();
            //TCP 연결 종료
            
        }
    }
}


// http://localhost:8080?id=2
// 웹브라우저가 만들어서 조립해줌 (브라우저가 자동으로 HTTP 요청 문서 조립), 서버는 문자열로 받음

//http요청문서조립필요
//사용자는 그냥 주소만 입력함 -> http://localhost:8080
//(하지만 실제로 네트워크로 날아가는 데이터는 이게 아님)
//크롬(브라우저)이 몰래 만드는 HTTP 요청 문서
/*
    GET / HTTP/1.1
    Host: localhost:8080
    User-Agent: Chrome/...
    Accept: text/html
📌 이걸 HTTP 요청 문서라고 부름
 */
// “조립” = 이 규칙에 맞게 문자열을 만들어서 보낸다는 뜻
// post는 데이터를 사용자가 넘겨야되니까 화면이 있어야됨??

// ex) id=2 사용자의 요청이 동적으로 들어오는게 일반적 (특정 게시글 등)