package xeus.com.vgdb.backend.services.response;

import xeus.com.vgdb.backend.services.response.messages.MessageList;

/**
 * The abstract class for all the web responses.
 *
 * @author Artur Matracki
 */
public abstract class AbstractWebResponse {

    private MessageList messageList;

    public MessageList getMessageList() {
        if (messageList == null) {
            messageList = new MessageList();
        }
        return messageList;
    }

    public void setMessageList(MessageList messageList) {
        this.messageList = messageList;
    }

    public ResponseStatus getStatus() {
        if (messageList.containsErrors()) {
            return ResponseStatus.ERROR;
        }

        if (messageList.containsWarnings()) {
            return ResponseStatus.SUCCESS_WITH_WARNINGS;
        }

        return ResponseStatus.SUCCESS;
    }

}
