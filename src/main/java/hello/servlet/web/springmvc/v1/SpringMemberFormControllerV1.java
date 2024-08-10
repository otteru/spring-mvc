package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@Controller안에 @Component 있어서 자동으로 스캔 대상 및 빈으로 등록 됨
// 스프링 mvc에서 애노테이션 기반 컨트롤러로 인식 =>
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {// 메소드 이름은 자유
        return new ModelAndView("new-form");
    }
    /**
     * ServletApplication에
     * @Bean
     * SpringMemberFormControllerV1 springMemberFormControllerV1() {
     *     return new SpringMemberFormControllerV1
     * }
     * 이런 식으로 등록해도 same
     */
}