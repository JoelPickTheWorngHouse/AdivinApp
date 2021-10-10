package AdivinApp;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import netscape.javascript.JSException;

public class App extends Application {

	TextField numeroUsuario;
	Button comprobar;
	Label mensage1;
	int numeroAd;
	int contador=0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		mensage1= new Label();
		mensage1.setText("Introduce un número del 1 al 100");
		mensage1.setAlignment(Pos.BASELINE_CENTER);
		
		numeroUsuario= new TextField();
		numeroUsuario.setMaxSize(100, 10);
		numeroAd=(int)(Math.random()*100+1);
		
		comprobar=new Button();
		comprobar.setText("Comprobar");
		comprobar.setOnAction(e -> onComprobacionAction(e));
		
		VBox cajaH=new VBox(mensage1,numeroUsuario,comprobar);
		cajaH.setAlignment(Pos.CENTER);
		Scene Stage=new Scene(cajaH,400,400);
		
		primaryStage.setScene(Stage);
		primaryStage.show();
	}
	
	private void onComprobacionAction(ActionEvent e) {
		
		try {
		int i=Integer.parseInt(numeroUsuario.getText());
		
		if(numeroAd==i) {
			Alert alert1=new Alert(AlertType.INFORMATION);
			alert1.setTitle("AdivinApp");
			alert1.setHeaderText("¡Has ganado!");
			alert1.setContentText("Solo has necesitado "+contador+" intentos");
			alert1.show();
		}if(numeroAd!=i) {
			contador++;
			Alert alert2=new Alert(AlertType.WARNING);
			alert2.setTitle("AdivinApp");
			alert2.setHeaderText("¡Has fallado!");
			if(i>numeroAd) {
				alert2.setContentText("El número a adivinar es menor a "+i);
			}else {
				alert2.setContentText("El número a adivinar es mayor a "+i);
			}
			alert2.show();
		}
		}catch (Exception e1){
			Alert alert3=new Alert(AlertType.INFORMATION);
			alert3.setTitle("AdivinApp");
			alert3.setHeaderText("Error *>-<*");
			alert3.setContentText("el número introducido ");
			alert3.show();
		}
		
		
		
		
	}

	public static void main(String [] args) {
		launch(args);
	}

}
