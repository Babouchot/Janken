/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.ejb.Stateful;
import javax.ejb.SessionContext;
import javax.persistence.*;
import javax.ejb.*;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import persistence.Gamer;

/**
 *
 * @author maureill
 */
@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class GamerSession implements GamerSessionLocal, GamerSessionRemote{
    
    @javax.persistence.PersistenceContext(unitName="persistence_sample")
    private EntityManager em ; 
    
    
    
    //This is the default; here as an example of @TransactionAttribute
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Object obj){
        Object mergedObj = em.merge(obj);
        em.remove(mergedObj);
    }
    
    public void persist(Object obj){
        em.persist(obj);
    }
    
 
    
   
    @Override
    public Gamer searchForGamer(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findAllConnected() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findGamerByFirstName(String firstName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findAllGamers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
