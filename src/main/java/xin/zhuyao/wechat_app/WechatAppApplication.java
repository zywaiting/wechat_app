package xin.zhuyao.wechat_app;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@SpringBootApplication
public class WechatAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatAppApplication.class, args);
    }

}
