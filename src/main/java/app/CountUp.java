package app;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * @author ANAGONOU Patrick
 */
public class CountUp extends Label {
    private int nbSeconds=0;
    private MyTimer myTimer;
    CountUp(){
        this.myTimer=new MyTimer();
        setText(""+nbSeconds);
        setFont(Font.loadFont(
            getClass().getResource(
                ResourcesInfos.FONT+"DSEG14ModernMini-RegularItalic.ttf").toExternalForm(), 25));
        
                
        myTimer.schedule(()->{
            this.increment();
        }, 1000L,1000L);
    
    }

    private void increment(){
        nbSeconds++;
        Platform.runLater( new Runnable(){
        
            @Override
            public void run() {
                setText(""+nbSeconds);
                
            }
        }); 
    }

    public int getTime(){
        return this.nbSeconds;
    }
    
}