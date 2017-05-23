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
    }

    public static void clock1() throws InterruptedException
    {
        Thread clock1 = new Thread(){
            
           public void run() {
               Clock clock = new Clock(label1, button1);
               clock.implement();
           }        
        };
        clock1.start();
        clock1.sleep(1000);
    }
    
    public static void clock2() throws InterruptedException
    {
        Thread clock2 = new Thread(){        
           public void run() {
               Clock clock = new Clock(label2, button2);
               clock.implement();
           }        
        };
        clock2.start();
        clock2.sleep(3000);        
    }
    
    public static void clock3() throws InterruptedException
    {     
        Thread clock3 = new Thread(){        
           public void run() {
               Clock clock = new Clock(label3, button3);
               clock.implement();
           }        
        };
        clock3.start();
        clock3.sleep(2000);        
    }
}