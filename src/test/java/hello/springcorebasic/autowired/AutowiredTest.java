package hello.springcorebasic.autowired;

import hello.springcorebasic.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    /*
    스프링 빈이 없어도 동작해야 할 때가 있다.
     */
    static class TestBean{
        // 호출 안됨
        @Autowired(required = false)// 의존 주입을 하지 않으므로 호출이 안된다.
        public void setNoBean1(Member member){
            System.out.println("setNoBean1 = " + member);
        }

        // null 호출
        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("setNoBean2 = " + member);
        }

        // Optional.empty 호출
        @Autowired
        public void setNoBean3(Optional<Member> member){
            System.out.println("setNoBean3 = " + member);
        }
    }


}
