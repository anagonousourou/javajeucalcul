package app;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

class MainMenuLayout extends VBox {
	private PropertyChangeSupport support;
	
    MainMenuLayout(){
		super(20);
		;
		this.getStylesheets().add(
			this.getClass().getResource(ResourcesInfos.CSS+"menu.css").toExternalForm()
		);
		support=new PropertyChangeSupport(this);
		this.setAlignment(Pos.BASELINE_CENTER);
		
		Label titre=new Label("Jeu de calcul");
		titre.setStyle("-fx-text-fill:orange;-fx-font-family: \"Lucida Handwriting\";");
		
		Button btn_quit=new Button("Quitter");
		btn_quit.getStyleClass().add("btn-quit");
		btn_quit.setOnAction(e->{
			support.firePropertyChange("action", "", "quitter");
		});
		Button btn_begin=new Button("Commencer");
		btn_begin.getStyleClass().add("btn-begin");
		btn_begin.setOnAction(e->{
			support.firePropertyChange("action", "", "start");
		});
		
		this.getChildren().addAll(titre,btn_begin,btn_quit);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
 
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
	}
	
	@Override
	public String toString() {
		return "MainMenu";
	}
}