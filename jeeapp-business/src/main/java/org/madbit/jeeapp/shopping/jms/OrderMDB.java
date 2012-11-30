package org.madbit.jeeapp.shopping.jms;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName="jms/jeeapp/CheckoutQueue")
public class OrderMDB implements MessageListener {

	public void onMessage(Message message) {
		TextMessage msg = (TextMessage)message; 
		try {
			System.out.println("Message received: " + msg.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
