package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping(value = "/new-form", method = RequestMethod.GET)//이렇게 하면 get인 경우에만 호출됨
    @GetMapping("/new-form")
    public String newForm() {// 메소드 이름은 자유
        return "new-form";
        //return new ModelAndView("new-form");
    }// 애노테이션 기반은 ModelAndView를 반환해도 되고 String을 반환해도 된다.

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model
    ) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";

//        ModelAndView mv = new ModelAndView("save-result");
//        //mv.getModel().put("member", member); - 밑의 코드가 더 간편
//        mv.addObject("member", member);
//        return mv;
    }

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
//        ModelAndView mv = new ModelAndView("members");
//        //mv.getModel().put("members", members)
//        mv.addObject("members", members);
//
//        return mv;
    }

}
