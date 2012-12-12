package org.madbit.jeeapp.shopping.ejb;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
@LocalBean
public class CheckoutBean{
	
	@Resource(mappedName = "jms/jeeapp/ConnectionFactory")
	private ConnectionFactory connectionFactory; 
	
	@Resource(mappedName = "jms/jeeapp/CheckoutQueue")
	private Queue queue; 

	public void checkout(int count){		
		try {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Creates the needed artifacts to connect to the queue 
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 
			MessageProducer producer = session.createProducer(queue);
			
			// Sends a text message to the topic 
			TextMessage message = session.createTextMessage(); 
			message.setText("Number of count is " + count); 
			producer.send(message);
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
