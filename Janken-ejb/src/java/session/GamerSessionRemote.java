/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Remote;
import persistence.Gamer;

/**
 *
 * @author maureill
 */
@Remote
public interface GamerSessionRemote {
    public Gamer searchForGamer(String id);
    
    public void persist(Object obj);
    
    public List findAllConnected();
    
    public List findGamerByFirstName(String firstName);
    
    public List findAllGamers();
    
    public void remove(Object obj);
}
