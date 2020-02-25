package com.example.customercontrols.springJms;

import com.example.customercontrols.User.User;
import com.example.customercontrols.User.UserTransactions;
import com.example.customercontrols.service.CustomerControlsService;
import com.example.customercontrols.service.JdbcCustomerControlsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class Listener {

        @Autowired
        private Producer producer;

        @Autowired
        CustomerControlsService customerControlsService;

        @JmsListener(destination = "generatedTranId.queue")
        public void receiveMessage(final String receivedmessage) throws ParseException {
            UserTransactions user = new UserTransactions();
            System.out.println(receivedmessage);
           String uname[] = receivedmessage.split(" , ");
           for(int i=0; i<= uname.length-1; i++){
               if(i == 0){
                   user.setTransactionId(uname[i]);
               }
               if(i==1){

                  user.setCardNo(uname[i]);
               }
               if(i==2)
               {
                  user.setAmount(uname[i]);
               }
               else{
                   user.setTransactionTS();
               }
           }
            String cardno = user.getCardNo();

            String msg = customerControlsService.isCardEnabled(cardno);
            if(msg.contains("enabled")){
                producer.sendMessage("fraudDetect.queue", receivedmessage);
            }
            else{

                producer.sendMessage("loginOut.queue", "Transaction not processing");
            }
        }


    }
