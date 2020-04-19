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
public interface Publishable<T> {
    void joinChannel(String channelName, Observer<T> observer);
    void leaveChannel(String channelName, Observer<T> observer);
    void sendObject(T object, Observer<T> sendingObserver);
}
