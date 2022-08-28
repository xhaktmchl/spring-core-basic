package hello.springcorebasic.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
   }

   public void setUrl(String url){
       this.url = url;
   }

    //서비스 시작시 호출
   public void connect(){
       System.out.println("connect: " + url);
   }

   // 서비스 콜에 호출
    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    // 의존주입 후 초기화 메서즈
    public void init(){
        connect();
        call("초기화 연결 메시지");
    }

    //스프링 종료 전 빈 소멸 지원 메서드
    public void close(){
        disconnect();
    }
}
