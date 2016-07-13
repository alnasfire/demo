package by.alnasfire.demo.dao;

import by.alnasfire.demo.model.Message;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alnasfire on 7/12/16.
 */

@Repository
public class MessageDaoImpl implements MessageDao{

    private static final Logger logger = LoggerFactory.getLogger(MessageDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void addMessage (Message message) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(message);
        logger.info("Message successfully saved. Message value: " + message.getValue());
    }

    @Transactional
    public List<Message> getMessagesByValue(String value){
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Message where VALUE = :testValue");
        query.setParameter("testValue", value);
        return query.list();
    }

    @Transactional
    public List<Message> listMessages() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Message> messagelist = session.createQuery("from Message").list();

        for(Message message: messagelist){
            logger.info("Message : " + message);
        }

        return messagelist;
    }
}
