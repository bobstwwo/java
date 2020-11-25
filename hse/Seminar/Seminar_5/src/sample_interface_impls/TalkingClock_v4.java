package sample_interface_impls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

/**
 *  TODO: note - now we use [non-static] inner class, that can access outer class data fields...
 */

public class TalkingClock_v4 {

    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     * @param interval the interval between messages (in milliseconds)
     * @param beep     true if the clock should beep
     */
    private TalkingClock_v4(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    private void start() {
        TimerEventsListener timerEventsListener = new TimerEventsListener();
        Timer t = new Timer(interval, timerEventsListener);
        t.start();
    }

    private class TimerEventsListener implements ActionListener {
        TimerEventsListener(){} //TODO: note - now no extra parameters needed... why? We can just omit it...
        /**
         * Invoked when an action occurs.
         * @param e - the event to react ...
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) //TODO: how can we read beep here?
//            if (TalkingClock_v4.this.beep) // or just if (beep)...
                Toolkit.getDefaultToolkit().beep();
        }
    }

    public static void main(String[] args) {
        new TalkingClock_v4(1000, true).start();
        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");

        try {
            Class<?> c = Class.forName("sample_interface_impls.TalkingClock_v4$TimerEventsListener");
            System.out.println("c.getDeclaringClass() = " + c.getDeclaringClass());
            System.out.println("declared_fields: " + Arrays.toString(c.getDeclaredFields()));
        } catch (Exception ex){
            System.out.println("got exception: " + ex);
        }

        System.exit(0);
    }
}
