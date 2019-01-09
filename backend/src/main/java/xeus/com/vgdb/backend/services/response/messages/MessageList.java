package xeus.com.vgdb.backend.services.response.messages;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.List;

/**
 * The list of messages for a web response.
 *
 * @author Artur Matracki
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MessageList {

    private List<Message> messageList;

    /**
     * Constructor.
     */
    public MessageList() {
        messageList = new ArrayList<>();
    }

    /**
     * The method adds a message to the message list.
     *
     * @param message message
     */
    public void add(Message message) {
        if (message != null) {
            messageList.add(message);
        }
    }

    /**
     * The method returns the message under the given index.
     *
     * @param index index of the message
     * @return message
     */
    public Message get(int index) {
        return messageList.get(index);
    }

    /**
     * The method removes the message under the given index.
     *
     * @param index index of the message
     */
    public void remove(int index) {
        messageList.remove(index);
    }

    /**
     * The method removes the given message from the list.
     *
     * @param message message
     */
    public void remove(Message message) {
        messageList.remove(message);
    }

    /**
     * The method that returns the size of the list.
     *
     * @return size of the list
     */
    public int size() {
        return messageList.size();
    }

    /**
     * The method returns <code>true</code> when the list contains errors, <code>false</code> otherwise.
     *
     * @return does the list contain errors?
     */
    public boolean containsErrors() {
        for (Message message : messageList) {
            if (message.getType() == MessageType.ERROR) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method returns <code>true</code> when the list contains warnings, <code>false</code> otherwise.
     *
     * @return does the list contain warnings?
     */
    public boolean containsWarnings() {
        for (Message message : messageList) {
            if (message.getType() == MessageType.WARNING) {
                return true;
            }
        }
        return false;
    }
}
