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
public interface Observer<T> {
    String getObserverName();
    void update(T obj);
}
