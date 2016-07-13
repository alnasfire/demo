package by.alnasfire.demo.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

/**
 * Created by alnasfire on 13.07.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class MessageServiceTests {

    @Test
    public void getMessageJSON(){
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet getMethod = new HttpGet("http://jsonplaceholder.typicode.com/posts/1");
        HttpResponse response = null;
        try {
            response = httpClient.execute(getMethod);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert response.getStatusLine().getStatusCode() == 200;
    }
}
