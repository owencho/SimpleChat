/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediator;

/**
 *
 * @author Tze-Ven Poh
 */
public class ChatData {
    private String message;
    private final String channel;
    private final String senderName;
    
    public ChatData(String message, String channel, String senderName) {
        this.message = message;
        this.channel = channel;
        this.senderName = senderName;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getChannel() {
        return channel;
    }

    public String getSenderName() {
        return senderName;
    }    
}
