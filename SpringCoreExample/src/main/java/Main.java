import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("context.xml"); - работаем с context.xml
//      Работаем с AppContext.class:
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        Message ms = (Message) context.getBean("message");
        MessageRenderer renderer = (MessageRenderer) context.getBean("renderer");
        renderer.render();
    }
}
