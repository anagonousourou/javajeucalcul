package app;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

import app.expression.Opera;
import app.expression.Question;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

/**
 * @author ANAGONOU Patrick
 */
class JeuLayout extends VBox implements PropertyChangeListener {
    private Label props_lab;
    private MyProgressBar timer;
    private TextField tf;
    private Button btn_finish;
    private boolean hasTried = false;
    private int comptEssais = 0;
    private int comptSucces = 0;
    private PropertyChangeSupport support;
    private int resultat;

    private Question question = new Question(new Random());

    JeuLayout() {

        super(20);
        this.getStylesheets().add(this.getClass().getResource(ResourcesInfos.CSS + "venom.css").toExternalForm());
        support = new PropertyChangeSupport(this);
        this.setAlignment(Pos.BASELINE_CENTER);
        this.props_lab = new Label();
        this.timer = new MyProgressBar();
        this.timer.addPropertyChangeListener(this);
        this.props_lab.getStyleClass().add("props_lab");
        this.tf = new TextField();
        this.tf.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                this.onEnterOrTimeUpEvt();
            }
        });
        this.btn_finish = new Button("Terminer");

        btn_finish.setOnAction(e -> {
            this.finSession();
        });

        this.proposition();
        this.getChildren().addAll(timer, props_lab, tf, btn_finish);
    }

    private void onEnterOrTimeUpEvt() {
        this.hasTried = true;
        timer.reInitialize();
        this.comptEssais++;
        if (tf.getText().equals(String.valueOf(this.resultat))) {
            this.comptSucces++;

        }
        this.proposition();
        tf.clear();
    }

    private void finSession() {
        support.firePropertyChange("resultatSession", null,
                new ResultatSession(this.hasTried, this.comptEssais, this.comptSucces, this.timer.getTime()));
    }

    private void proposition() {
        Opera n = question.newRandomExpression(20);
        this.resultat = n.apply();
        this.props_lab.setText("Combien font " + n.toString() + " ?");

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public String toString() {
        return "Jeu";
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.onEnterOrTimeUpEvt();
    }

    
    
    
}