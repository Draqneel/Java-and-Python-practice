public class MessageRendererSoutImpl implements MessageRenderer {
    private Message message;

    public MessageRendererSoutImpl(Message message) {
        this.message = message;
    }

    public void render() {
        System.out.println(message.getText());
    }
}
