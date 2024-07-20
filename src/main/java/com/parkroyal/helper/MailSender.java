/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkroyal.helper;

import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author HIEU HIEU
 */
public class MailSender extends Thread{
    static {
        MailSender sender = new MailSender();
        sender.start();
    }
    
    static final List<MimeMessage> queue = new ArrayList<>();
    
    public static void queue (MimeMessage mail) {
        synchronized (queue) {
            queue.add(mail);
            queue.notify();
        }
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (queue) {
                    if (queue.size() > 0) {
                        try {
                            MimeMessage mail = queue.remove(0);
                            Transport.send(mail);
                            System.out.println("Mail sent successfully");
                        } catch (MessagingException e) {
                            System.out.println("Unable to send mail!");
                        }
                    } else {
                        queue.wait();
                    }
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
