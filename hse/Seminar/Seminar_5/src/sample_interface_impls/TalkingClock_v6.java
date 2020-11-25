package sample_interface_impls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

/**
 *  TODO: now we use anonymous inner class in start()-method: no sense to name it (it is not used elsewhere...)
 */
class TalkingClock_v6 {

    private String myObject = "ququ";
    /**
     * Starts the clock.
     * @param interval the interval between messages (in milliseconds)
     * @param beep true if the clock should beep
     */
    private void start(int interval, boolean beep){
        myObject = "ogogo";//myObject.toUpperCase();
//         beep = !beep; //todo: uncomment & explain it...
//           interval++; //todo: uncomment with its' usage in println() method below... & explain (show reflected fields)
        //TODO: show automated change into lambda by IntelliJ Idea...
         ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println(
                        //myObject +
                        "At the tone, the time is " + new Date()
//                        + " interval = " + interval
                );
                if (beep)
                    Toolkit.getDefaultToolkit().beep();
            }
         };
         Timer t = new Timer(interval, listener);
         t.start();
    }

    public static void main(String[] args) {
        TalkingClock_v6 clock_v6 = new TalkingClock_v6();
        boolean b = args.length == 0;
        int interval = (args.length == 0)? 1000 : 2000;
        clock_v6.start(interval, b);
        JOptionPane.showMessageDialog(null, "Quit program?");

        try {
            Class<?> c = Class.forName("sample_interface_impls.TalkingClock_v6$1");
            System.out.println("c.getDeclaringClass() = " + c.getDeclaringClass());
            System.out.println("declared_fields: " + Arrays.toString(c.getDeclaredFields()));
        } catch (Exception ex){
            System.out.println("got exception: " + ex);
        }

        System.exit(0);
    }
}
