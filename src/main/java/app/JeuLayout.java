package app;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

class JeuLayout extends VBox{
    private Label score_lab;
    private Label props_lab;
    private TextField tf;
    private Button btn_finish;
    private boolean hasTried=false;
    private int comptEssais=0;
    private int comptSucces=0;
    private PropertyChangeSupport support;
    private int resultat;
    private String resourcesFolder="./";

    private Random rand=new Random();
    JeuLayout(){
        
        super(20);
        this.getStylesheets().add(resourcesFolder+"venom.css");
        support=new PropertyChangeSupport(this);
		this.setAlignment(Pos.BASELINE_CENTER);
		this.score_lab=new Label("0/0");
		this.props_lab=new Label();
		this.tf=new TextField();
		this.tf.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {
                this.hasTried=true;
                this.comptEssais++;
				System.out.println(this.resultat+" "+tf.getText());
				if(tf.getText().equals(String.valueOf(this.resultat))) {
					this.comptSucces++;
					
                }
                this.proposition();
                tf.clear();
			}
		});
		this.btn_finish=new Button("Terminer");
		
		btn_finish.setOnAction(e->{
			this.finSession();
        });
        
		this.proposition();
		this.getChildren().addAll(score_lab,props_lab,tf,btn_finish);
    }
    
	
    private void finSession() {
        support.firePropertyChange(
            "resultatSession", null, 
            new ResultatSession(this.hasTried,this.comptEssais, this.comptSucces)
            );
    }

    private void proposition() {
        this.score_lab.setText(this.comptSucces+"/"+this.comptEssais);
		int a=rand.nextInt(100);
		int b=rand.nextInt(100);
		this.resultat=a+b;
		this.props_lab.setText("Combien font "+String.valueOf(a)+" + "+String.valueOf(b)+ " ?");
		
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

    
    
    
}