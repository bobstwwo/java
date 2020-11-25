package sample_interface_impls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

/**
 *  TODO: Now we use local inner class (see named class TimerEventsListener).
 *  TODO: comment/uncomment beep = !beep below and explain - why it fails to compile...
 *  TODO: to see the reason try to use reflection API and analyse the local inner class fields...
 *  TODO: note that the local inner class is not reflected by <class>.getDeclaredClasses()-method...(why?)
 *  TODO: note also that method local inner class has no declaring class...
 */

public class TalkingClock_v5 {

    public void start(int interval, boolean beep) { //todo: now inner class is inside the method:
        //todo: see that there are no access specifiers before the class:
        class TimerEventsListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
//                System.out.println(this.getClass().getName());
                System.out.println("At the tone, the time is " + new Date());
                if (beep) //TODO: comment out this line and reflect all the local class fields (is there val$beep or not ?)
                    Toolkit.getDefaultToolkit().beep();
//                beep = !beep; // todo: what's happening? now it must be final (JDK7) or effectively final (JDK8)...Why?
            }
        }
        ActionListener listener = new TimerEventsListener();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public static void main(String[] args) {
        new TalkingClock_v5().start(1000, true);
        JOptionPane.showMessageDialog(null, "Quit program?");

        try {
            Class<?> c = Class.forName("sample_interface_impls.TalkingClock_v5$1TimerEventsListener");
            System.out.println("c.getDeclaringClass() = " + c.getDeclaringClass());
            System.out.println("declared_fields: " + Arrays.toString(c.getDeclaredFields()));
        } catch (Exception ex){
            System.out.println("got exception: " + ex);
        }
        System.exit(0);
    }
}
