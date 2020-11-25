package sample_interface_impls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * TODO: explain the difference: now we have separate listener class to react on events...
 * TODO: note - that is still JDK 1.0 style (with no nested classes...)
 */

public class TalkingClock_v2 {

    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     *
     * @param interval the interval between messages (in milliseconds)
     * @param beep     true if the clock should beep
     */
    private TalkingClock_v2(int interval, boolean beep) {
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

    public static void main(String[] args) {
        TalkingClock_v2 clock = new TalkingClock_v2(1000, true);
        clock.start();
        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * TODO:
 *   1. Note that now we need to pass a parameter to the constructor (beep);
 *   2. Note that we could have it declared inside the TalkingClock class as static nested class...
 *    The only profit we could earn - an ability to have it private (hide from the package located "friends")...
 */
class TimerEventsListener implements ActionListener {
    private final boolean beep;

    TimerEventsListener(boolean beep){
        this.beep = beep;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e - the event to react ...
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is " + new Date());
        if (beep)
            Toolkit.getDefaultToolkit().beep();
    }
}