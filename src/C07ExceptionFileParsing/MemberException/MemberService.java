package C07ExceptionFileParsing.MemberException;

import java.util.List;
import java.util.Optional;

//핵심로직을 구현하는 계층
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        memberRepository = new MemberRepository();
    }

    public void register(String name, String email, String password) {
//        List(DB)에 이메일이 중복일경우 예외발생
//        if (member != null) {
//            throw new IllegalArgumentException("이미 가입된 이메일입니다. 다른 이메일을 입력해주세요.");
//        }
        // Optional 활용
        Optional<Member> optionalMember = Optional.ofNullable(memberRepository.findByEmail(email));
        if(optionalMember.isPresent()){
            throw new IllegalArgumentException("이미 가입된 이메일입니다. 다른 이메일을 입력해주세요.");
        }
//        객체 조립 후 repository를 통해 저장
        Member newMember = new Member(name, email, password);
        memberRepository.register(newMember);
    }

    public Member findById(long id) {
        Member member = Optional.ofNullable(memberRepository.findById(id))
                .orElseThrow(()-> new IllegalArgumentException("아이디가 존재하지 않습니다."));
//        if (member == null) {
//            throw new IllegalArgumentException("아이디가 존재하지 않습니다.");
//        }
        return member;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public void login(String email, String password) {
        Member member = Optional.ofNullable(memberRepository.findByEmail(email))
                .orElseThrow(()->new IllegalArgumentException("존재하지않는 이메일입니다."));
//        email이 있는지 확인 후 없으면 예외발생
//        if(member == null){
//            throw new IllegalArgumentException("존재하지않는 이메일입니다. 다시입력해주세요.");
//        }
//        password가 일치한지 확인 후 일치하지 않으면 예외 발생
        if(!member.getPassword().equals(password)){
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
    }
}
