package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
import java.time.LocalDate;

import com.sun.javafx.scene.accessibility.Action;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class createEventController implements Initializable {

	Connection conn=null;
	String ses="";
	
	@FXML
	private TextField ename;
	
	@FXML
	private DatePicker date;
	
	@FXML
	private TextArea desc;
	
	private Stage dialogStage;

	private Stage primaryStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	
	}
	
	@FXML
	public void back(MouseEvent event) throws IOException
	{
		/*infoBox("Login Successfull",null,"Success" );
        Node node = (Node)event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("fwelcome.fxml")));
    	dialogStage.setScene(scene);
    	dialogStage.show();*/
		FXMLLoader loader=new FXMLLoader(getClass().getResource("fwelcome.fxml"));
    	Parent root=(Parent)loader.load();
    	fwelcomeController set=loader.getController();
    	set.myfunc(ses);
        Node node = (Node)event.getSource();
        dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
       // scene = new Scene(FXMLLoader.load(getClass().getResource("fwelcome.fxml")));
    	dialogStage.setScene(new Scene(root));
    	dialogStage.show();
	}
	
	public void myfunc(String str)
	{
		ses=str;
	}
	
	@FXML
	public void create(MouseEvent event) throws IOException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=	DriverManager.getConnection("jdbc:mysql://localhost/dbms?user=root&password=pucchi143");
			PreparedStatement st1=conn.prepareStatement("insert into event(ename,edate,socid,description) values(?,?,?,?)");
			st1.setString(1,ename.getText().toString());
			
	        LocalDate value = date.getValue();
			//String date=request.getParameter("year")+request.getParameter("month")+request.getParameter("date");
			st1.setString(2,value.toString());
			//String email=session.getAttribute("email").toString();
			PreparedStatement st2=conn.prepareStatement("select socid from users where email=?");
			st2.setString(1,ses);
			ResultSet rs1=st2.executeQuery();
			rs1.next();
			String socid=rs1.getString(1);
			System.out.println("set socid");
			st1.setString(3,socid);
			st1.setString(4,desc.getText().toString());
			st1.executeUpdate();
			System.out.println("set query");
			conn.close();
			//response.sendRedirect("fwelcome.jsp");
			infoBox("Login Successfull",null,"Success" );
	        Node node = (Node)event.getSource();
	        dialogStage = (Stage) node.getScene().getWindow();
	        dialogStage.close();
	        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("fwelcome.fxml")));
	    	dialogStage.setScene(scene);
	    	dialogStage.show();
		}
		catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	private void infoBox(String string, Object object, String string2) {
		// TODO Auto-generated method stub
		
	}
}
