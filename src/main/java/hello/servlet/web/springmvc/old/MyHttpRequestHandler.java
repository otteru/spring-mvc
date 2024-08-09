package hello.servlet.web.springmvc.old;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import java.io.IOException;

@Component("/springmvc/request-handler") // 빈이름으로  핸들러 찾고
public class MyHttpRequestHandler implements HttpRequestHandler {//1 = HttpRequestHandlerAdapter : HttpRequestHandler 처리

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}

/**
 * 1. 빈 이름으로 MyHttpRequestHandler 찾음
 * 2. HttpRequestHandler -> HttpRequestHandlerAdapter 이용 (support 메소드로 check)
 * 3. DispatcherServlet에서 Adapter의 handle 메소드 사용
 * 4. handle에서 handleRequest 호출 -> sysm 출력
 */