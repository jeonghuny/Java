package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// 외부 JSON 파일을 읽어서 → 문자열로 만든 뒤 → Jackson(ObjectMapper)으로 → Java 객체(Student)로 변환
public class C04Json {
    public static void main(String[] args) throws IOException {
//        외부의 json 파일을 java의 클래스(객체) 변환 : json 파싱(역직렬화)
//        Path filePath = Paths.get("src/C07ExceptionFileParsing/myjson1.json");
        // Files.readString()
        //👉 파일 전체를 문자열로 한 번에 읽음
        //👉 Jackson은 문자열(JSON) 을 입력으로 받기 때문에 이 과정이 필요
        // 파싱(역직렬화) : readValue : json -> 객체
        // 직렬화 : writeValueAsString : 객체 -> json

////        readString : 문자열 전체를 통째로 read
//        String st1 = Files.readString(filePath);
//        System.out.println(st1);
        
//      JackSon 라이브러리(Spring에는 기본적으로 탑재. java에서는 별도로 추가)의 ObjectMapper클래스를 통한 객체로의 파싱
        // JackSon 관련 자료 다운로드 받아서 썼음.

//        ObjectMapper o1 = new ObjectMapper();
////        Map으로 일괄적으로  String, String으로 파싱 (하지만 일반적으로 이렇게 사용 안함)
////        Map<String,String> myMap = o1.readValue(st1, Map.class);
////        System.out.println(myMap);
////        System.out.println(myMap.get("name"));
////        내가 직접 만든 객체로 파싱
//        Student myStudent = o1.readValue(st1, Student.class); // private라서 직접 접근 불가
//        System.out.println(myStudent);
        
//        List형식으로 주어지는 json파싱 : 트리구조의 JsonNode로 변환
        Path filePath = Paths.get("src/C07ExceptionFileParsing/myjson2.json");
        String st1 = Files.readString(filePath);
        ObjectMapper o1 = new ObjectMapper();
        // JSON을 트리 구조로 파싱 -> 노드로 이어지는 트리 구조임.
        JsonNode jsonNodes = o1.readTree(st1);
        List<Student> studentList = new ArrayList<>();
        for(JsonNode j : jsonNodes){ // 트리구조의 JsonNode
            Student s1 = o1.readValue(j.toString(), Student.class);
            studentList.add(s1);
        }
        System.out.println(studentList);

//        json직렬화 : 객체 -> json.
//        ObjectMapper o1 = new ObjectMapper(); // ObjectMapper를 통해서 json으로 만듬.
//        Student s1 = new Student(1,"h1","1","seoul");
//        String result = o1.writeValueAsString(s1);

        // 👉 객체 → JSON 문자열
//        System.out.println(s1);
//        System.out.println(result);
    }
}
// 실제 값의 setting은 private 변수이므로 직접 접근 불가.
// java의 reflection 기술을 통해 런타임시점에 private 변수도 직접 접근 가능.
// 다만, 필드값을 유추할수 있도록 (getter 메서드 + 기본생성자)를 생성해야함. // 기본생성자는 있음 (따로 안만들면)
class Student{
    private long id;
    private String name;
    private String classNumber;
    private String city;

    public Student(long id, String name, String classNumber, String city) {
        this.id = id;
        this.name = name;
        this.classNumber = classNumber;
        this.city = city;
    }

    public Student(){

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classNumber='" + classNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}


/*
1)파싱
 1-1 readValue ->객체
 1-2 readTree->JsonNode

2) 직렬화
: writeValueAsString
 */