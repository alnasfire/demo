package by.alnasfire.demo.model;

import javax.persistence.*;

/**
 * Created by alnasfire on 7/12/16.
 */

@Entity
@Table(name = "MESSAGE")
public class Message {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "VALUE")
    private String value;

    public Message(String value) {
        this.value = value;
    }

    public Message() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
