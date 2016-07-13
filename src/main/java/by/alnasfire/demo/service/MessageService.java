package by.alnasfire.demo.service;

import by.alnasfire.demo.model.Message;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alnasfire on 7/12/16.
 */
public interface MessageService {

    public void addMessage(Message message);

    public List<Message> listMessages();

    public Message getMessage(String messageId);
}
