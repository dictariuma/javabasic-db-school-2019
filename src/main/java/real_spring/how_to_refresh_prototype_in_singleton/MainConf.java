package real_spring.how_to_refresh_prototype_in_singleton;

import lombok.SneakyThrows;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.*;

import java.awt.*;

import static design_patterns.strategy.heroes.RandomUtil.getRandomInRange;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
//@ImportResource("classpath:color_context.xml")
public class MainConf {


    @Bean
    @Scope(value = "twoSeconds", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Color color() {
        return new Color(getRandomInRange(0, 255), getRandomInRange(0, 255), getRandomInRange(0, 255));
    }


    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConf.class);
        while (true) {
            context.getBean(ColorFrame.class).moveToRandomLocation();
            Thread.sleep(80);
        }
    }
}
