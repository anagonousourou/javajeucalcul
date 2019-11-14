package app;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * @author ANAGONOU Patrick
 */
public class App extends Application implements PropertyChangeListener {
    private Stage win;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.win = primaryStage;
        MainMenuLayout mml = new MainMenuLayout();
        mml.addPropertyChangeListener(this);
        primaryStage.setScene(new Scene(mml, 350, 350));
        primaryStage.show();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getSource().toString().equals("Jeu")) {
            BilanLayout bl = new BilanLayout((ResultatSession) evt.getNewValue());
            bl.addPropertyChangeListener(this);
            this.win.setScene(new Scene(bl, 350, 350));
        } else if (evt.getSource().toString().equals("Bilan")) {
            MainMenuLayout mml = new MainMenuLayout();
            mml.addPropertyChangeListener(this);
            this.win.setScene(new Scene(mml, 350, 350));
            this.win.show();
        }

        else if (evt.getSource().toString().equals("MainMenu")) {
            String newValue=(String) evt.getNewValue();
            if (newValue.equals("start")) {
                JeuLayout jl = new JeuLayout();
                jl.addPropertyChangeListener(this);
                win.setScene(new Scene(jl, 350, 350));
            } else if (newValue.equals("quitter")) {
                try {
                    Platform.exit();
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            }
        }

    }
    
}