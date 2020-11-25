package sample_interface_impls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * TODO: show Code -> Implement methods ... (in IDEA)
 * TODO: explain ideology (JDK 1.0 - like...). Note, that nested/inner classes were introduced in JDK 1.1...
 *  1. This sample illustrates interface usage and implementation without any additional classes.
 *  What isn't good here?
 *     This class has been overloaded with functionality: no separation of concerns...
 *     Imagine, we need to react on many different action events (e.g. from many timers)...
 *     It's better to have a dedicated listener instance for a given event source...
 *     How to implement that? See TalkingClock_v2...
 */

public class TalkingClock_v1 implements ActionListener {

    private int interval;
    private boolean beep;
    /**
     * Constructs a talking clock
     * @param interval the interval between messages (in milliseconds)
     * @param beep true if the clock should beep
     */
    private TalkingClock_v1(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    private void start() {
        Timer t = new Timer(interval, this);
        t.start();
    }

     /**
     * Invoked when an action occurs.
     * @param e - the event to react ...
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is " + new Date());
        if (beep) // it can be just if (beep) ...
            Toolkit.getDefaultToolkit().beep();
    }


    public static void main(String[] args) {
        TalkingClock_v1 clock = new TalkingClock_v1(1000, true);
        clock.start();
        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

}


