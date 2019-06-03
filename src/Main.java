import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.image.*;

public class Main extends Application{

	Stage win;
	Scene sc1;
	Scene sc2;
	Scene sc3;
	int resultat;
	int compteur=0;
	int essai=0;
	Label props_lab;
	Label score_lab;
	Label remark_lab;
	TextField tf;
	Image excel_im=new Image("./excellent.png",80, 120, false, false);
	Image goodjob_im=new Image("./bon_travail.png",80, 120, false, false);
	Image still_im=new Image("./angry.png",80, 120, false, false);
	Image good_im=new Image("./smile.png",80, 120, false, false);
	Image verygood_im=new Image("./ok_smiley.jpg",80, 120, false, false);
	Image noeffort_im=new Image("./blue_smiley.png",80, 120, false, false);//aucun essai
	Image nul_im=new Image("./sad_smiley.jpg",80, 120, false, false);
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		win=stage;
		sc1=this.construireSceneMenu();
		sc2=this.construireSceneJeu();
		sc3=this.construireSceneBilan();
		win.setScene(sc1);
		
		sc1.getStylesheets().add("./menu.css");
		sc2.getStylesheets().add("./venom.css");
		sc3.getStylesheets().add("./bilan.css");
		
		win.setTitle("Jeu Calcul");
		win.show();
		
	}
	
	public Scene construireSceneBilan() {
		VBox vlay=new VBox(50);
		vlay.setAlignment(Pos.BASELINE_CENTER);
		
		remark_lab=new Label();
		
		remark_lab.setTextOverrun(OverrunStyle.LEADING_WORD_ELLIPSIS);
		remark_lab.setWrapText(true);
		Button ok_btn=new Button("OK");
		ok_btn.setOnAction(e->{
			win.setScene(sc1);
		});
		
		Scene tmpsc=new Scene(vlay,350,250);
		vlay.getChildren().addAll(remark_lab,ok_btn);
		return tmpsc;
	}
	
	public Scene construireSceneMenu() {
		VBox vboite=new VBox(20);
		Scene tmpsc=new Scene(vboite,350,250);
		
		vboite.setAlignment(Pos.BASELINE_CENTER);
		
		Label titre=new Label("Jeu de calcul");
		titre.setStyle("-fx-text-fill:orange;-fx-font-family: \"Lucida Handwriting\";");
		
		Button btn_quit=new Button("Quitter");
		btn_quit.getStyleClass().add("btn-quit");
		btn_quit.setOnAction(e->{
			win.close();
		});
		Button btn_begin=new Button("Commencer");
		btn_begin.getStyleClass().add("btn-begin");
		btn_begin.setOnAction(e->{
			this.reinitialiser();
			win.setScene(sc2);
			this.proposition();
		});
		
		vboite.getChildren().addAll(titre,btn_begin,btn_quit);
		
		return tmpsc;
	}
	
	public void reinitialiser() {
		this.essai=-1;
		this.compteur=0;
		
	}
	
	public void proposition() {
		this.essai++;
		score_lab.setText(String.valueOf(this.compteur)+"/"+String.valueOf(this.essai));
		int a=(int)(Math.random()*100);
		int b=(int)(Math.random()*100);
		this.resultat=a+b;
		props_lab.setText("Combien font "+String.valueOf(a)+" + "+String.valueOf(b)+ " ?");
		
	}
	
	public void faireBilan() {
		
		if (essai==0) {
			remark_lab.setText("Vous n'avez rien essayé c'est trop dur pour vous?");
			remark_lab.setGraphic(new ImageView(noeffort_im));
		}
		else {
			double tmp=(double)compteur/essai;
			System.out.println(tmp);
			
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
		
		
		win.setScene(sc3);
		
		
	}
	
	public Scene construireSceneJeu() {
		VBox vboite=new VBox(20);
		vboite.setAlignment(Pos.BASELINE_CENTER);
		Scene sc=new Scene(vboite,350,250);
		score_lab=new Label("0/0");
		props_lab=new Label();
		this.tf=new TextField();
		this.tf.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.ENTER) {
				System.out.println(this.resultat+" "+tf.getText());
				if(tf.getText().equals(String.valueOf(this.resultat))) {
					this.compteur++;
					
				}
				tf.clear();
				
				this.proposition();
			}
		});
		Button btn_finish=new Button("Terminer");
		
		btn_finish.setOnAction(e->{
			this.faireBilan();
		});
		
		vboite.getChildren().addAll(score_lab,props_lab,tf,btn_finish);
		
		return sc;
	}
	

}
