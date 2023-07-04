package bitcamp.myapp.handler;

import java.util.List;
import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;

public class MemberAddListener extends AbstractMemberListener {

  public MemberAddListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    Member m = new Member();

    m.setNo(Member.userId++);
    m.setName(prompt.inputString("이름? "));
    m.setAge(prompt.inputString("나이? "));
    m.setWeight(prompt.inputString("몸무게? "));
    m.setGender(inputGender((char) 0, prompt));

    this.list.add(m);
  }
}
