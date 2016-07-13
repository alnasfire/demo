package by.alnasfire.demo.service;

import by.alnasfire.demo.dao.MessageDao;
import by.alnasfire.demo.model.Message;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.*;
import java.util.List;

/**
 * Created by alnasfire on 7/12/16.
 */
@Service
public class MessageServiceImpl implements by.alnasfire.demo.service.MessageService {
    private MessageDao messageDao;

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Transactional
    public void addMessage(Message message) {
        this.messageDao.addMessage(message);
    }

    @Transactional
    public List<Message> listMessages() {
        return this.messageDao.listMessages();
    }

    public Message getMessage(String messageId){
        final String url = "http://jsonplaceholder.typicode.com/posts/" + messageId;
        Message message = null;

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet getMethod = new HttpGet(url);
        HttpResponse response = null;
        try {
            response = httpClient.execute(getMethod);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            InputStream is = response.getEntity().getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            JSONObject json = new JSONObject(sb.toString());
            if (!"".equals(sb.toString())) {
                message = new Message((String) json.get("body"));
            }
        } catch (NullPointerException e) {
//            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        } catch (JSONException e) {
//            e.printStackTrace();
        }

        return message;
    }
}
