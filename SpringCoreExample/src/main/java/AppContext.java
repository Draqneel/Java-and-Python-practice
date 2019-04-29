import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
    @Bean
    public Message message(){
        Message message = new MessageByeImpl("Антон", ":c");
        return message;
    }

    @Bean
    public MessageRenderer renderer() {
        MessageRenderer renderer = new MessageRendererErrImpl(message());
        return renderer;
    }
}
