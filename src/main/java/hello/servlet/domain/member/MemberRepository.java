package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    // 싱글톤으로
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() { // 생성자 막기
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store에 있는 value 값을 건들이고 싶지 않기에 ArrayList로 반환
    }

    public void clearStore() {
        store.clear();
    }
}
