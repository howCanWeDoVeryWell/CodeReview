package mvc.home.model;

import mvc.home.dto.Member;
import mvc.home.vo.Vo;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class Model {
    private List<Member> members;
    
    public Model () {
        this.members = this.fetchMembers();
    }
    
    // DB에서 members 데이터를 조회해서 가지고 온다.
    private List<Member> fetchMembers () {
        return Arrays.asList(
                new Member(1, "최태산"), 
                new Member(2, "지은정")
        );
    }
    
    public void removeMember (String name) {
        this.members = this.members
                .stream()
                .filter(member -> !member.getName().equals(name))
                .collect(Collectors.toList());
    }
    
    public Vo getData () {
        // 모델의 this.members를 파싱하여 테이블용 데이터를 만든다.
        Vector listData = new Vector();
        this.members.forEach(member -> listData.addElement(member.getName()));

        Vo vo = new Vo(listData);
        return vo;
    }
}
