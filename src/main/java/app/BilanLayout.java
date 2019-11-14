package app;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * @author ANAGONOU Patrick
 */
class BilanLayout extends VBox{
    Label remark_lab;
    Button ok_btn;
    ResultatSession resultatSession;
    
    String state;
    Image excel_im=new Image(
        BilanLayout.class.getResource(ResourcesInfos.EXCELLENT_IMAGE).toExternalForm()
        ,80, 120, false, false);
    Image goodjob_im=new Image(
        BilanLayout.class.getResource(ResourcesInfos.GOOD_IMAGE).toExternalForm(),
        80, 120, false, false);
    Image still_im=new Image(
        BilanLayout.class.getResource(ResourcesInfos.MORE_EFFORT_IMAGE).toExternalForm(),
        80, 120, false, false);
    Image verygood_im=new Image(
        BilanLayout.class.getResource(ResourcesInfos.VERY_GOOD_IMAGE).toExternalForm(),
        80, 120, false, false);
    Image noeffort_im=new Image(
        BilanLayout.class.getResource(ResourcesInfos.NO_EFFORT_IMAGE).toExternalForm(),
        80, 120, false, false);//aucun essai
    Image nul_im=new Image(
        BilanLayout.class.getResource(ResourcesInfos.NULL_IMAGE).toExternalForm(),
        80, 120, false, false);
    private PropertyChangeSupport support;
    BilanLayout(ResultatSession resultat){
        super(50);
        this.getStylesheets().add(
            this.getClass().getResource(ResourcesInfos.CSS+"bilan.css").toExternalForm()
        );
        support=new PropertyChangeSupport(this);
        this.resultatSession=resultat;
		this.setAlignment(Pos.BASELINE_CENTER);
        this.remark_lab=new Label();
		this.remark_lab.setTextOverrun(OverrunStyle.LEADING_WORD_ELLIPSIS);
		this.remark_lab.setWrapText(true);
		this.ok_btn=new Button("OK");
		this.ok_btn.setOnAction(e->{
			support.firePropertyChange("stage", "open", "close");
		});
		
		
        this.getChildren().addAll(remark_lab,ok_btn);
        this.faireBilan();
    }

    private void faireBilan() {
        if (!resultatSession.isHasTried()) {
			remark_lab.setText("Vous n'avez rien essayé c'est trop dur pour vous?");
			remark_lab.setGraphic(new ImageView(noeffort_im));
		}
		else {
			double tmp=resultatSession.getScore();
			
			if (tmp<0.3) {
				
				remark_lab.setText("Ca c'est plutot nul.");
				remark_lab.setGraphic(new ImageView(nul_im));
			}
			else if(tmp <0.5) {
				remark_lab.setText("Allez encore un peu d'effort");
				remark_lab.setGraphic(new ImageView(still_im));
			}
			
			else if(tmp <0.7) {
				remark_lab.setGraphic(new ImageView(goodjob_im));
				remark_lab.setText("Bon travail vous pouvez faire mieux la prochaine fois.");
			}
			else if(tmp<0.9) {
				remark_lab.setGraphic(new ImageView(verygood_im));
				remark_lab.setText("Super travail vous etes proches de l'excellence");
			}
			else {
				remark_lab.setGraphic(new ImageView(excel_im));
				remark_lab.setText("Excellent vous etes une calculatrice ambulante");
            }
        }

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
 
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    @Override
    public String toString() {
        return "Bilan";
    }
}