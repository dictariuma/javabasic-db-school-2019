package real_spring.quoters.bpp;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import real_spring.quoters.DeprecatedClass;

/**
 * @author Evgeny Borisov
 */
//@Component
public class DeprecatedHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            Class<?> beanClass = Class.forName(beanDefinition.getBeanClassName());
            DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
            if (annotation!=null) {
                Class<?> newClass = annotation.newClass();
                beanDefinition.setBeanClassName(newClass.getName());
            }
        }
    }
}



