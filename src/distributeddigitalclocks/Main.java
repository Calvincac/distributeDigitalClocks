/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributeddigitalclocks;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
        Clock firstClock = new Clock(label1, button1);
        Clock secondClock = new Clock(label2, button2);
        Clock thirdClock = new Clock(label3, button3);
        
        setClockThread(firstClock, 1000);
        setClockThread(secondClock, 3000);
        setClockThread(thirdClock, 2000);
        
        buildFrame();    
    }

    public static void setClockThread(Clock clock, int miliseconds) throws InterruptedException
    {
       Thread thread= new Thread(){        
           public void run() {               
               clock.implement();
           }        
        };       
        thread.start();
        thread.sleep(miliseconds);          
    }
    
    public static void buildFrame()
    {
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
    }
}