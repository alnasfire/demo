package by.alnasfire.demo.dao;

import by.alnasfire.demo.model.Message;

import java.util.List;

/**
 * Created by alnasfire on 7/12/16.
 */
public interface MessageDao {
    public void addMessage(Message message);

    public List<Message> listMessages();

    public List<Message> getMessagesByValue(String value);
}
