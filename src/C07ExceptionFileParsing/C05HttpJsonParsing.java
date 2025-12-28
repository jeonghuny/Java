package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class C05HttpJsonParsing {
    public static void main(String[] args) throws IOException, InterruptedException {
//        외부에서 데이터를 받아 java의 객체로 변환
//        외부 api요청을 하기 위한 라이브러리 : HttpClient, RestTemplate, RestClient
//        HttpClient는 java내장클래스
//        RestTemplate, RestClient는 스프링에서 가장 많이 사용하는 클래스.  (외부서버에 요청하는 라이브러리)
        // 외부 API 호출 (HttpClient)
        HttpClient client2 = HttpClient.newHttpClient();
        // 요청 정보 (URL, GET/POST 등)
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/posts/1")).GET().build();
        // HttpResponse<String> → 응답 결과
        HttpResponse<String> response = client2.send(request, HttpResponse.BodyHandlers.ofString());
        String data = response.body();
//        System.out.println(data);

//          객체로 파싱
//        ObjectMapper o1 = new ObjectMapper();
//        Post p1 = o1.readValue(data, Post.class);
//        System.out.println(p1);


//          리스트형식의 객체로 파싱
        ObjectMapper o1 = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/posts")).GET().build();
        HttpResponse<String> response1 = client.send(request2,HttpResponse.BodyHandlers.ofString());
        String data1 = response1.body();

//        JsonNode j1 = o1.readTree(data1);
//        List<Post> postList = new ArrayList<>();
//        // JsonNode → Post 변환 과정
//        for(JsonNode j : j1){
//            Post pp = o1.readValue(j.toString(),Post.class);
//            postList.add(pp);
//        }
//        System.out.println(postList);

    }
}
class Post {
    private long userId;
    private long id;
    private String title;
    private String body;

    public Post(long userId, long id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(){

    }

    public long getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
