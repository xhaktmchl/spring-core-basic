package hello.springcorebasic.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {
    /*
    실글톤 스코프로 테스트
     */

    @Test
    public void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);

        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);

        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);

        ac.close(); // 프프링 컨테이너 종료
    }

    @Scope("singleton")
    static class SingletonBean{

        @PostConstruct // 의존주입 후 빈 초기화
        public void init(){
            System.out.println("SingletonBean.init");
        }

        @PreDestroy // 소멸 전 빈 소멸 몰백
        public void close(){
            System.out.println("SingletonBean.destroy");
        }
    }
}
