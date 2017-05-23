/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributeddigitalclocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class Clock {
    
    private JLabel label;
    private JButton button;
        
    public Clock(JLabel label, JButton button)
    {
        this.label = label;
        this.button = button;
    }
    
    public void implement()
    {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Calendar gregorian = new GregorianCalendar(2013,1,1,0,0,2);

        for (int i=0; i < 10000; i++) {
            gregorian.add(Calendar.SECOND, 1);
            String time = format.format(gregorian.getTime());

            try {
                TimeUnit.SECONDS.sleep(1);
                this.label.setText(time);
                setAlarm(this.button, time);                
                this.label.setHorizontalAlignment(SwingConstants.CENTER);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setAlarm(JButton button, String timeSet)
    {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String time = JOptionPane.showInputDialog("Set time to alarm clock (00:00:00): ");
               if (time.equals(timeSet)) {
                   System.out.println("hieeeeeeeeee");
               }
            }
        } );
    }
}