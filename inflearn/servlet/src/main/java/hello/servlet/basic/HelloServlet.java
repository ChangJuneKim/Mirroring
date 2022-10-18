package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
// localhost:8080/hello 로 진입하면
public class HelloServlet extends HttpServlet {

  // 서블릿이 호출(8080/hello 진입)되면 service 메서드가 호출이 된다 (Ctrl + O 로 메서드 생성)
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("HelloServlet.service"); // soutm
    // HttpServletRequset나 Response는 인터페이스다. 톰캣같은 WAS가 구현 그 구현체가 아래에서 console에 찍힘
    System.out.println("request = " + request); // soutv
    System.out.println("response = " + response);

    // 쿼리 파라미터를 한번 가져와서 찍어보자~ requset.getParameter
    String username = request.getParameter("username"); // Ctrl + Alt + V 하면 assign 할수 있음
    System.out.println("username = " + username);

    // 응답 메세지를 한번 보내보자~ response
    response.setContentType("text/plain"); // text/plain 기본 문자열으로 보낼거고
    response.setCharacterEncoding("utf-8"); // 캐릭터 인코딩 utf-8으로 보낼거야
    // getWriter().write() 로 보내면 http message body에 들어감
    response.getWriter()
            .write("hello " + username);
  }
}
