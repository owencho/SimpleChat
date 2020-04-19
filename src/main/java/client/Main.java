/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import gui.ChatFrame;
import mediator.ChatData;
import mediator.Observer;
import mediator.Publishable;
import mediator.Publisher;

/**
 *
 * @author Tze-Ven Poh
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpyingPublisher publisher = new SpyingPublisher();
        
        // Create ChatFrames and associate it with the SpyingPublisher
        // mediator object
        ChatFrame matt = ChatFrame.createFrame("Matthew", publisher);
        ChatFrame gina = ChatFrame.createFrame("Gina", publisher);
        ChatFrame bambi = ChatFrame.createFrame("Bambi", publisher);
        // The ChatFrames can create/join a channel by code (or by GUI)        
        matt.createChannel("lounge");
        gina.createChannel("lounge");
        bambi.createChannel("lounge");        
        gina.createChannel("public");
        bambi.createChannel("public");
        matt.createChannel("public");
        // The ChatFrame can leave/close a channel by code (or by GUI)
        matt.closeChannel("public");
        // The ChatFrame can send message by code (or by GUI)
        matt.sendMessage("Hello everyone!", "lounge");
    }    
}

/**
 * This is a simple mediator class that implements the Publishable interface
 * to demonstrate how the GUI ChatFrames that are associated to it can 
 * generate joinChannel, leaveChannel, sendObject events. It only dumps
 * the activities done by the ChatFrames.
 */
class SpyingPublisher implements Publishable<ChatData> {

    @Override
    public void joinChannel(String channelName, Observer<ChatData> observer) {
        System.out.println(observer.getObserverName() + " requests to join " +
                            channelName + " channel.");
    }
    
    @Override
    public void leaveChannel(String channelName, Observer<ChatData> observer) {
        System.out.println(observer.getObserverName() + " requests to leave " +
                            channelName + " channel.");
    }

    @Override
    public void sendObject(ChatData chat, Observer<ChatData> sendingObserver) {
        System.out.println(chat.getSenderName() + " sends \"" + 
                            chat.getMessage() + "\" to " + chat.getChannel() +
                            " channel.");        
    }
}
