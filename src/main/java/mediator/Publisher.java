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
public class Publisher implements Publishable<ChatData> {
    // Create a collection object that keeps the channel names and their
    // list of observers/subcribers. [Suggestion: Use ArrayList to keep the
    // list of observers. Use TreeMap to map channel name (String type) to the
    // ArrayList of observers/subcribers.

    
    @Override
    public void joinChannel(String channelName, Observer<ChatData> observer) {
        // Handle channel join request by the observer/subcriber.
        // Requirements:
        //   1) Check if channel name already existed in the collection.
        //   2) If not yet, create the channel and create its respective
        //      ArrayList of observers and store them as <key, value> pairs
        //      in the collection.
        //   3) Check if the observer/subcriber has already joined.
        //   4) If no, then add the observer into the Array of observers.
        //      Otherwise do nothing.
        //   5) Update all observers about their status. E.g., who is already
        //      in the channel or who has just joined the channel. 
    }

    @Override
    public void leaveChannel(String channelName, Observer<ChatData> observer) {
        // Handle channel leave request by the observer/subcriber.
        // Requirements:
        //   1) Get the ArrayList of observers/subcribers from the collection
        //      using channel name as the key.
        //   2) If the observer/subscriber was in the list, remove it. 
        //      Otherwise just ignore and return immediately.
        //   3) If the ArrayList of observers/subcribers is empty, then
        //      remove the <key, value> pairs from the collection.
        //   4) Announce to all the other observers/subcribers that the
        //      observers has left the channel.
    }

    @Override
    public void sendObject(ChatData object, Observer<ChatData> sendingObserver) {
        // Handle the broadcasting of the chat message to all the other
        // observers/subcribers in the channel. The chat object contains, the
        // message, the channel to send to, and the sender's name, which you
        // can use to informatively decorate the message.
        // Requirements:
        //   1) Get the ArrayList of observers/subcribers from the collection
        //      using the channel name as the key.
        //   2) If available, iterate through the list of observers and send
        //      the chat message to each one of them. Otherwise, just ignore.
        //      [Note: you might want to decorate the message with informative
        //       info like who sent the message.]
    }

}
