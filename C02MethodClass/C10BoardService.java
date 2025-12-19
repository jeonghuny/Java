package C02MethodClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
        <게시판서비스>
        1.계좌객체 : Author, Post
        2.자료구조 : List(authorList, postList)
        3.서비스 기능 : 사용하실 서비스 번호를 입력해주세요
            3-1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
            3-2.회원 전체 목록 조회 : id, email
            3-3.회원 상세 조회(id로 조회) : id, email, name, password, 작성글수(postList에서 조회하거나, author객체에서 postList목록을 변수로 갖는것도 가능)
            3-4.게시글 작성 : id, title, contents, 작성자Email(직접 Author 객체를 변수로 갖는것도 가능)
            3-5.게시물 목록 조회 : id(post), title
            3-6.게시물 상세 조회(게시글 id로 조회) : id, title, contents, 작성자이름
     */
public class C10BoardService {
    public static void main(String[] args) {
        List<Author> authorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();

        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("사용하실 서비스 번호를 입력해주세요");
            int number = Integer.parseInt(sc.nextLine());

            if(number == 1){
                System.out.println("회원가입서비스 입니다.");
                System.out.println("이름 입력해주세요");
                String name = sc.nextLine();
                System.out.println("이메일 입력해주세요");
                String email = sc.nextLine();
                System.out.println("비밀번호 입력해주세요");
                String password = sc.nextLine();
                authorList.add(new Author(name,email,password));
                System.out.println("회원가입 완료");
            }else if(number == 2){
                System.out.println("회원목록조회서비스 입니다.");
                for(Author authorInfo : authorList){
                    System.out.println("회원아이디 : " + authorInfo.getId());
                    System.out.println("회원이메일 : " + authorInfo.getEmail());
                }
            }else if(number == 3){
                System.out.println("회원 상세 조회서비스 입니다.");
                System.out.println("아이디를 입력해주세요.");
                Long id = Long.valueOf(sc.nextLine());
                for(Author authorInfo : authorList){
                    if(id == authorInfo.getId()){
                        System.out.println("아이디 : " + authorInfo.getId());
                        System.out.println("이메일 : " + authorInfo.getEmail());
                        System.out.println("이름 : " + authorInfo.getName());
                        System.out.println("비밀번호 : " + authorInfo.getPassword());
                        int count = 0;
//                        // 작성글 수 구하기1
//                        for(Post postInfo : postList){
//                            if(postInfo.getAuthorEmail().equals(authorInfo.getEmail())){
//                                count++;
//                            }
//                        }
                        // 작성글 수 구하기2
                        System.out.println("작성글 수 : " + authorInfo.getPostList().size());
                    }
                }
            }else if(number == 4){
                System.out.println("게시글 작성서비스 입니다.");
                System.out.println("제목을 입력해주세요");
                String title = sc.nextLine();
                System.out.println("내용을 입력해주세요");
                String contents = sc.nextLine();
                System.out.println("이메일 입력해주세요");
                String email = sc.nextLine();
                // 회원검색
                Author author = null;
                for(Author a: authorList){
                    if(a.getEmail().equals(email)){
                        author = a;
                        break;
                    }
                }
                Post post = new Post(title,contents,author);
                postList.add(post);
                System.out.println("글이 작성되었습니다.");
            }else if(number == 5){
                System.out.println("게시글 목록 입니다.");
                for(Post postInfo : postList){
                        System.out.println("아이디 : " + postInfo.getId());
                        System.out.println("제목 : " + postInfo.getTitle());
                    }
            }else if(number == 6) {
                System.out.println("게시글 상세 조회서비스 입니다.");
                System.out.println("게시글 아이디를 입력해주세요.");
                Long id = Long.valueOf(sc.nextLine());
                for(Post postInfo : postList) {
                    if (id == postInfo.getId()) {
                        Post post = postInfo;
                        System.out.println("아이디 : " + post.getId());
                        System.out.println("제목 : " + post.getTitle());
                        System.out.println("내용 : " + post.getContents());
                        // 작성자 이름 구하기1
//                        Author author = null;
//                        for(Author authorInfo : authorList){
//                            if(authorInfo.getEmail().equals(post.getAuthorEmail())){
//                                author = authorInfo;
//                                break;
//                            }
//                        }
//                        System.out.println("작성자 이름 : " + author.getName());
                        // 작성자 이름 구하기2
                        System.out.println(post.getAuthor().getName());
                    }
                }
            }
        }
    }
}

class Author{
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Post> postList;
    private static long staticId;

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

    public List<Post> getPostList() {
        return postList;
    }

    public Author(String name, String email, String password) {
        staticId++;
        this.id = staticId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.postList = new ArrayList<>();
    }


}
class Post{
    private Long id;
    private String title;
    private String contents;
//    private String authorEmail;
    // Author
    private Author author;
    private static long staticId;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

//    public String getAuthorEmail() {
//        return authorEmail;
//    }

    public Author getAuthor() {
        return author;
    }

    public Post(String title, String contents, Author author) {
        staticId++;
        this.id = staticId;
        this.title = title;
        this.contents = contents;
//        this.authorEmail = email;
        this.author = author;
        // 여기서 this는 지금 만들고자 하는 post객체를 의미
        author.getPostList().add(this);
    }

//    public Post(String title, String contents, String email, Author author) {
//        staticId++;
//        this.id = staticId;
//        this.title = title;
//        this.contents = contents;
//       this.authorEmail = email;
//    }
}