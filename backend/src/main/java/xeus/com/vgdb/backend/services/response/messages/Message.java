package xeus.com.vgdb.backend.services.response.messages;

/**
 * The message for a web response.
 *
 * @author Artur Matracki
 */
public class Message {

    private MessageType type;
    private String text;

    /**
     * The method that creates a new message.
     *
     * @param messageType message type
     * @param text        message text
     * @return new message
     */
    public static Message createMessage(MessageType messageType, String text) {
        Message message = new Message();
        message.setType(messageType);
        message.setText(text);
        return message;
    }

    /**
     * The method that creates a new info.
     *
     * @param text message text
     * @return new info message
     */
    public static Message createInfo(String text) {
        return createMessage(MessageType.INFO, text);
    }

    /**
     * The method that creates a new warning.
     *
     * @param text message text
     * @return new warning message
     */
    public static Message createWarning(String text) {
        return createMessage(MessageType.WARNING, text);
    }

    /**
     * The method that creates a new error.
     *
     * @param text message text
     * @return new error message
     */
    public static Message createError(String text) {
        return createMessage(MessageType.ERROR, text);
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
