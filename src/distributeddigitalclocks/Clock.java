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
    private String timeGiven = "6000";// only to define a value so that null pointer exception doesnt happen
        
    public Clock(JLabel label, JButton button)
    {
        this.label = label;
        this.button = button;
    }
    
    public void implement()
    {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Calendar gregorian = new GregorianCalendar(2013,1,1,0,0,2);
        setAlarm(this.button);        

        for (int i=0; i < 10000; i++) {
            gregorian.add(Calendar.SECOND, 1);
            String time = format.format(gregorian.getTime());

            try {
                TimeUnit.SECONDS.sleep(1);
                this.label.setText(time);               
                this.label.setHorizontalAlignment(SwingConstants.CENTER);
                verifyTime(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setAlarm(JButton button)
    {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               timeGiven = JOptionPane.showInputDialog("Set time to alarm clock (00:00:00): ");
            }
        } );
    }
    
    public void verifyTime(String timeSet)
    {
        if (timeGiven.equals(timeSet)) {
           JOptionPane.showMessageDialog(null, "Alarm Alarm Alarm !!!");
        }
    }
}