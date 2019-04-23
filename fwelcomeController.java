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

public class fwelcomeController implements Initializable {
	private Stage dialogStage;
	Connection conn=null;
	@FXML
	private Label session;
	String ses="";
	//private Stage dialogStage;
	//private Scene scene;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	public void myfunc(String str)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=pucchi143");
			String socid="";
			PreparedStatement st1=conn.prepareStatement("select name from users where email=?");
			st1.setString(1,str);
			ResultSet rs1=st1.executeQuery();
			rs1.next();
			ses=str;
			session.setText("WELCOME "+rs1.getString(1).toUpperCase());
			socid=rs1.getString(4);
			conn.close();
			
		}
		catch(Exception e)
		{
			
		}
	}
	@FXML
	public void logout(MouseEvent event) throws IOException
	{
		infoBox("Login Successfull",null,"Success" );
        Node node = (Node)event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Welcome.fxml")));
    	dialogStage.setScene(scene);
    	dialogStage.show();
	}
	
	@FXML
	public void createEvent(MouseEvent event) throws IOException
	{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("createEvent.fxml"));
    	Parent root=(Parent)loader.load();
    	createEventController set=loader.getController();
    	set.myfunc(ses);
        Node node = (Node)event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
       // scene = new Scene(FXMLLoader.load(getClass().getResource("fwelcome.fxml")));
    	dialogStage.setScene(new Scene(root));
    	dialogStage.show();
	}

	private void infoBox(String string, Object object, String string2) {
		// TODO Auto-generated method stub
		
	}
	
}
