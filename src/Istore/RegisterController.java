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
import java.util.function.Predicate;

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

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 *
 * @author WINDOWS 10
 */
public class RegisterController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField FirstName;

    @FXML
    private TextField LastName;

    @FXML
    private TextField Email;


    @FXML
    private PasswordField password;

    @FXML
    private Button loginBtn;

    @FXML
    private Button close;
    @FXML
    private Label errorLabel;

    private Predicate<String> emailValidator = email -> {
        // Replace with your actual email validation logic (e.g., regex)
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    };
    //    DATABASE TOOls
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

//    NOW LETS CREATE OUR DATABASE : )

    private double x= 0 ;
    private double y= 0;

    public void Register() throws SQLException {
        if (Email.getText().isEmpty() || !emailValidator.test(Email.getText())) {

            errorLabel.setText("Please enter a valid email address.");
            errorLabel.setVisible(true);
            return; // Prevent processing
        }

        String sql = "SELECT * FROM WhitelistedEmails WHERE email = ? ";

        connect = database.connectDb();

        try{ // IT WORKS GOOD : ) NOW LETS DESIGN THE DASHBOARD FORM : )
            Alert alert;

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, Email.getText());

            result = prepare.executeQuery();
//            CHECK IF FIELDS ARE EMPTTY
            if(Email.getText().isEmpty() || password.getText().isEmpty()||FirstName.getText().isEmpty()||LastName.getText().isEmpty()){
                errorLabel.setText("Please fill all blank fields.");
                errorLabel.setVisible(true);
            }else{
                if(result.next()){

                    String sqlInsert = "INSERT INTO users (email, password_hash, role, first_name, last_name) "
                            + "VALUES (?, ?,?, ?, ?)";
                    prepare = connect.prepareStatement(sqlInsert);
// ... connection logic and prepared statement setup
                    prepare.setString(1, Email.getText());
                    String hashedPassword=SecurePassword.hashPassword(password.getText());
                    prepare.setString(2, hashedPassword); // Replace with securely hashed password
                    prepare.setString(3, "normal");
                    prepare.setString(4, FirstName.getText()); // Replace with validated and sanitized first_name
                    prepare.setString(5, LastName.getText()); // Replace with validated and sanitized last_name
                    getData.username = FirstName.getText()+" "+LastName.getText();

// ... execute statement and handle results
                    int insertedRows = prepare.executeUpdate();
                    if (insertedRows > 0) {
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Your account is Successfully Created!");
                        alert.showAndWait();

//                    TO HIDE THE LOGIN FORM
                        loginBtn.getScene().getWindow().hide();
                        //LINK YOUR DASHBOARD
                        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

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
                    }
                    else {
                        alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Try again");
                        alert.showAndWait();
                    }

                }else{
                    // THEN ERROR MESSAGE WILL APPEAR
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("The email not in WhitelistedEmails");
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


}
