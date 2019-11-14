package app;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author ANAGONOU Patrick
 */
public class MyTimer {
    private final Timer t = new Timer();
  
    public TimerTask schedule(final Runnable r, long delay,long period) {
       final TimerTask task = new TimerTask() { public void run() { r.run(); }};
       t.schedule(task, delay,period);
       return task;
    }
  }