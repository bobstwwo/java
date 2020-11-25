package sample_interface_impls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 *  TODO: The same as v2, but with private static nested class... (as of JDK 1.1)
 */
public class TalkingClock_v3 {

    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     * @param interval the interval between messages (in milliseconds)
     * @param beep     true if the clock should beep
     */
    private TalkingClock_v3(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    private void start() {
        TimerEventsListener timerEventsListener = new TimerEventsListener(beep);
        Timer t = new Timer(interval, timerEventsListener);
        t.start();
    }

    private static class TimerEventsListener implements ActionListener {
        private final boolean beep;
        TimerEventsListener(boolean beep){ // extra parameter passing, etc...
            this.beep = beep;
        }
        /**
         * Invoked when an action occurs.
         * @param e - the event to react ...
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if (beep)
                Toolkit.getDefaultToolkit().beep();
        }
    }

    public static void main(String[] args) {
        TalkingClock_v3 clock = new TalkingClock_v3(1000, true);
        clock.start();
        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
