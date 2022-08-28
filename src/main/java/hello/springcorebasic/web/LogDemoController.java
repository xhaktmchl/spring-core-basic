package hello.springcorebasic.web;


import hello.springcorebasic.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor // 생성자 의존주입 실행
public class LogDemoController {

    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider; // 빈 생명주기 직접 조절하기 위해
    private final MyLogger myLogger; // 빈 생명주기 직접 조절하기 위해


    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();

        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testUUId");
        return "OK";
    }
}
