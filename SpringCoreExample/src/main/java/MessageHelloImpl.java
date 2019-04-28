public class MessageHelloImpl implements Message {
    private String text;

    public MessageHelloImpl(String text, String smile) {
        this.text = "Hello, " + text + " " + smile;
    }

    public MessageHelloImpl(String text) {
        this.text = "Hello, " + text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setSuffix(String suffix) {
        this.text = text + " " + suffix;
    }
}
