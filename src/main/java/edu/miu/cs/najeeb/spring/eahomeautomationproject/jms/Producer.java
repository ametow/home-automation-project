package edu.miu.cs.najeeb.spring.eahomeautomationproject.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private JmsTemplate jmsTemplate;

    public Producer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String destination, String message) {
        jmsTemplate.send(destination, session -> session.createTextMessage(message));
    }
}
