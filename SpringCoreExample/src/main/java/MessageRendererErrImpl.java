public class MessageRendererErrImpl implements MessageRenderer {
    private Message message;

    public MessageRendererErrImpl(Message message) {
        this.message = message;
    }

    public void render() {
        System.err.println(message.getText());
    }
}
