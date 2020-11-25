package sample_interface_impls;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * TODO: replacing anonymous class with lambda - will be discussed later (in the coming lectures)...
 */
public class TalkingClock_v7 {

    public static void main(String[] args) {
        boolean beep = (args.length == 0);
//        beep = !beep; //todo: uncomment and explain the issue about [effectively] final...
        new Timer(1000, event -> {
            System.out.println("The time is " + new Date());
            if (beep)
                Toolkit.getDefaultToolkit().beep();
        }).start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
