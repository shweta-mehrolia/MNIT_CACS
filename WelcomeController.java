package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
import com.sun.javafx.scene.accessibility.Action;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.stage.Stage;

public class WelcomeController implements Initializable {
	
	private Stage dialogStage;
	private Scene scene;

	@Override
	public void initialize(URL url,ResourceBundle rb)
	{
		
	}
	
	@FXML
	public void redirectToLogin(MouseEvent event) throws IOException
	{
		infoBox("Login Successfull",null,"Success" );
        Node node = (Node)event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource("Sample.fxml")));
    	dialogStage.setScene(scene);
    	dialogStage.show();
	}

	@FXML
	public void redirectToSignup(MouseEvent event) throws IOException
	{
		System.out.println("hello");
		infoBox("Login Successfull",null,"Success" );
        Node node = (Node)event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        scene = new Scene(FXMLLoader.load(getClass().getResource("signup.fxml")));
    	dialogStage.setScene(scene);
    	dialogStage.show();
	}
	private void infoBox(String string, Object object, String string2) {
		// TODO Auto-generated method stub
		
	}

}
