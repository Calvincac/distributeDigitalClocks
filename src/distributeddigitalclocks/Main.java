/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributeddigitalclocks;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author 631510487
 */
public class Main {
    
    private static JLabel label1 = new JLabel();
    private static JLabel label2 = new JLabel();
    private static JLabel label3 = new JLabel();
    private static JButton button1 = new JButton();
    private static JButton button2 = new JButton();
    private static JButton button3 = new JButton();
    private static  JFrame frame = new JFrame("Digital Clocks");
    
    public static void main(String[] args) throws InterruptedException
    {        
        clock1();
        clock2();
        clock3();
        button1.setText("Novo Alarme");
        button2.setText("Novo Alarme");
        button3.setText("Novo Alarme");
        
        frame.setLayout(new GridLayout(2, 3));
        frame.setSize(400, 100);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.pack();
    
    }

    public static void clock1()
    {
        Thread clock1 = new Thread(){
            
           public void run() {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                Calendar gregorian = new GregorianCalendar(2013,1,1,0,0,2);
                
                for (int i=0; i < 10000; i++) {
                    gregorian.add(Calendar.SECOND, 1);
                    String time = format.format(gregorian.getTime());
                    
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        label1.setText(time);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
           }        
        };
        clock1.start();
    }
    
    public static void clock2()
    {
        Thread clock2 = new Thread(){        
           public void run() {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                Calendar gregorian = new GregorianCalendar(2013,1,1,0,0,1);
                
                for (int i=0; i < 10000; i++) {
                    gregorian.add(Calendar.SECOND, 1);
                    String time = format.format(gregorian.getTime());
                    
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        label2.setText(time);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
           }        
        };
        clock2.start();        
    }
    
    public static void clock3()
    {     
        Thread clock3 = new Thread(){        
           public void run() {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                Calendar gregorian = new GregorianCalendar(2013,1,1,0,0,3);
                
                for (int i=0; i < 10000; i++) {
                    gregorian.add(Calendar.SECOND, 1);
                    String time = format.format(gregorian.getTime());
                    
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        label3.setText(time);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
           }        
        };
        clock3.start();        
    }
}
