package C07ExceptionFileParsing.MemberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//저장소역할을 하는 계층
//DB에 CRUD를 수행하는 계층
public class MemberRepository {
    private List<Member> memberList;

    public MemberRepository(){
        this.memberList = new ArrayList<>();
    }

    public void register(Member member){
        this.memberList.add(member);
    }

//    public Optional<Member> findByEmail(String email){
//        Member member = null;
//        for(Member m : memberList){
//            if(m.getEmail().equals(email)){
//                member = m;
//                break;
//            }
//        }
//        return Optional.ofNullable(member);
//    }

    public Optional<Member> findByEmail(String email){
        // 이렇게도 깔끔하게 코딩 가능.
        return this.memberList.stream().filter(a->a.getEmail().equals(email)).findFirst();
    }

    public Optional<Member> findById(long id){
        Member member = null;
        for(Member m : memberList){
            if(m.getId()==id){
                member = m;
                break;
            }
        }
        return Optional.ofNullable(member);
    }

    public List<Member> findAll(){
        return this.memberList;
    }
}