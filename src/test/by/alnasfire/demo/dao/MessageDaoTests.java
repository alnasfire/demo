package by.alnasfire.demo.dao;

import by.alnasfire.demo.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by alnasfire on 13.07.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class MessageDaoTests {

    @Autowired
    private MessageDao messageDao;

    @Before
    public void setup(){}

    @Test
    @Rollback(true)
    public void saveMessage(){
        String testValue = "test message";
        Message message = new Message(testValue);
        messageDao.addMessage(message);

        assert !messageDao.getMessagesByValue(testValue).isEmpty();
    }

    @Test
    @Rollback(true)
    public void listMessages(){
        messageDao.addMessage(new Message("value1"));

        assert messageDao.listMessages().size() >= 1;
    }
}
