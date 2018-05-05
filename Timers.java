import java.util.*;
import java.time.*;

public class Timers{
    static Scanner sc=new Scanner(System.in);
    public static void main(final String args[]) {
        if (args.length != 1) {
            System.err.println("Usage: java Countdown <time in secs>");
            System.exit(1);
        }
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = Integer.parseInt(args[0]);
            public void run() 
            {

                System.out.println("Ring Ring |press enter to answer");
                String input= sc.nextLine();
                if (input!=null)
                    timer.cancel();i--;
            }
        }, 0, 1000);
    }
}
