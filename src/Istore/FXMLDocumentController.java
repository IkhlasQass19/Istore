/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static studentmanagementsystem.SecurePassword.verifyPassword;

/**
 *
 * @author WINDOWS 10
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField Email;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginBtn;

    @FXML
    private Button close;
    
//    DATABASE TOOls
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
//    NOW LETS CREATE OUR DATABASE : ) 
    
    private double x= 0 ;
    private double y= 0;
    
    public void loginAdmin() throws SQLException {
        
        String sql = "SELECT * FROM users WHERE email = ? ";
        
        connect = database.connectDb();
        
        try{ // IT WORKS GOOD : ) NOW LETS DESIGN THE DASHBOARD FORM : ) 
            Alert alert;
            
            prepare = connect.prepareStatement(sql);

            prepare.setString(1, Email.getText());
            
            result = prepare.executeQuery();
//            CHECK IF FIELDS ARE EMPTTY
            if(Email.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                if(result.next ()){
//                    THEN PROCEED TO DASHBOARD FORM

                    if(verifyPassword(password.getText(),result.getString("password_hash"))) {
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Login!");
                        alert.showAndWait();

//                    TO HIDE THE LOGIN FORM
                        loginBtn.getScene().getWindow().hide();
                        Parent root=null;
                        String  role=result.getString("role");
                        System.out.println(role);
                        getData.username = result.getString("first_name")+" "+result.getString("last_name");

                        if(role.equalsIgnoreCase("admin")) {
                            //LINK YOUR DASHBOARD
                            getData.id_user=result.getInt("id");
                            root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                        }
                        else if(role.equalsIgnoreCase("employee")){
                            getData.idstore=result.getInt("store_id");
                            getData.id_user=result.getInt("id");
                            //LINK YOUR DASHBOARD
                            root = FXMLLoader.load(getClass().getResource("dashboardE.fxml"));

                        }
                        else {
                            //LINK YOUR DASHBOARD
                            getData.id_user=result.getInt("id");
                            root = FXMLLoader.load(getClass().getResource("dashboardC.fxml"));

                        }

                        Stage stage = new Stage();
                        Scene scene = new Scene(root);

                        root.setOnMousePressed((MouseEvent event) -> {
                            x = event.getSceneX();
                            y = event.getSceneY();
                        });

                        root.setOnMouseDragged((MouseEvent event) -> {
                            stage.setX(event.getScreenX() - x);
                            stage.setY(event.getScreenY() - y);
                        });

                        stage.initStyle(StageStyle.TRANSPARENT);

                        stage.setScene(scene);
                        stage.show();
                    }else{
                        alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Wrong Username/Password");
                        alert.showAndWait();
                    }
                    
                }else{
                    // THEN ERROR MESSAGE WILL APPEAR
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                }
            }
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void close(){
        System.exit(0);
    }
    
    //LETS NAME THE COMPONENTS ON LOGIN FORM : )
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void handleRegistration(MouseEvent mouseEvent) throws IOException {
        loginBtn.getScene().getWindow().hide();
        //LINK YOUR DASHBOARD
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        root.setOnMousePressed((MouseEvent event) ->{
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) ->{
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setScene(scene);
        stage.show();

    }
}
