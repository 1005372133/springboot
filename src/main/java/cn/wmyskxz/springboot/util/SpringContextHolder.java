package cn.wmyskxz.springboot.util;


import org.apache.commons.lang3.Validate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext context;

    public SpringContextHolder() {
    }

    public static <T> T getBean(Class<T> clazz) {
        try {
            return getApplicationContext().getBean(clazz);
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    /*public static <T> T getBean(String name) {
        return getApplicationContext().getBean(name);
    }*/

    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        Validate.validState(context != null, "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.", new Object[0]);
        return context;
    }
}
