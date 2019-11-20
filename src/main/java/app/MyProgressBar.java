package app;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;

public class MyProgressBar extends ProgressBar{

    private int nbSeconds=0;
    private MyTimer myTimer;
    double progres=0.0F;
    private PropertyChangeSupport support;
    MyProgressBar(){
        this.support=new PropertyChangeSupport(this);
        this.myTimer=new MyTimer();
        setProgress(progres);
        
                
        myTimer.schedule(()->{
            this.increment();
        }, 1000L,1000L);
    
    }

    private void increment(){
        nbSeconds++;
        progres+=0.1F;
        Platform.runLater( new Runnable(){
        
            @Override
            public void run() {
                setProgress(progres);
                if(getProgress()>=1){
                    support.firePropertyChange("timeUp", false, true);
                }
            }
        });

        
    }

    public int getTime(){
        return this.nbSeconds;
    }

	public void reInitialize() {
        progres=0.0F;
    }
    

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
    
}