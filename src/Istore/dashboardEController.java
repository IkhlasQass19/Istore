/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static studentmanagementsystem.database.connectDb;

/**
 *
 * SUBSCRIBE OUR YOUTUBE CHANNEL -> https://www.youtube.com/channel/UCPgcmw0LXToDn49akUEJBkQ
 * THANKS FOR YOUR SUPPORT : ) 
 */
public class dashboardEController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Label username;

    @FXML
    private Button home_btn;

    @FXML
    private Button addStudents_btn;

    @FXML
    private Button showViewers_btn;


    @FXML
    private Button availableCourse_btn;

    @FXML
    private Button updateBtn;

    @FXML
    private Button clearBtn;

    @FXML
    private Button studentGrade_btn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalEnrolled;

    @FXML
    private Label Email;


    @FXML
    private Label UserName;


    @FXML
    private Label LastName;

    @FXML
    private Label Pseudo;

    @FXML
    private Label Gender;

    @FXML
    private Label home_totalFemale;

    @FXML
    private Label home_totalMale;

    @FXML
    private BarChart<?, ?> home_totalEnrolledChart;

    @FXML
    private AreaChart<?, ?> home_totalFemaleChart;

    @FXML
    private LineChart<?, ?> home_totalMaleChart;

    @FXML
    private AnchorPane addStudents_form;
    @FXML
    private AnchorPane ShowViewers_form;

    @FXML
    private TextField addStudents_search;

    @FXML
    private TableView<studentData> addStudents_tableView;

    @FXML
    private TableColumn<studentData, String> addStudents_col_EmployeeNum;

    @FXML
    private TableColumn<studentData, String> addStudents_col_year;

    @FXML
    private TableColumn<studentData, String> addStudents_col_course;

    @FXML
    private TableColumn<studentData, String> addStudents_col_firstName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_lastName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_gender;

    @FXML
    private TableColumn<studentData, String> addStudents_col_birth;

    @FXML
    private TableColumn<studentData, String> addStudents_col_status;

    @FXML
    private TextField addStudents_EmployeeNum;

    @FXML
    private ComboBox<?> addStudents_year;

    @FXML
    private ComboBox<?> addStudents_course;

    @FXML
    private TextField addStudents_firstName;

    @FXML
    private TextField addStudents_lastName;

    @FXML
    private TextField EditFirstName;

    @FXML
    private TextField EditLastName;

    @FXML
    private TextField EditPseudo;

    @FXML
    private DatePicker addStudents_birth;

    @FXML
    private ComboBox<?> addStudents_status;

    @FXML
    private ComboBox<?> addStudents_gender;

    @FXML
    private ImageView addItemInventory_imageView;

    @FXML
    private Button addStudents_insertBtn;

    @FXML
    private Button addStudents_addBtn;

    @FXML
    private Button addStudents_updateBtn;

    @FXML
    private Button addStudents_deleteBtn;

    @FXML
    private Button addStudents_clearBtn;

    @FXML
    private AnchorPane availableCourse_form;

    @FXML
    private TextField availableCourse_course;

    @FXML
    private TextField availableCourse_description;

    @FXML
    private TextField availableCourse_degree;

    @FXML
    private Button availableCourse_addBtn;

    @FXML
    private Button availableCourse_updateBtn;

    @FXML
    private Button availableCourse_clearBtn;

    @FXML
    private Button availableCourse_deleteBtn;

    @FXML
    private TableView<courseData> availableCourse_tableView;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_course;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_description;

    @FXML
    private TableColumn<courseData, String> availableCourse_col_degree;

    @FXML
    private AnchorPane studentGrade_form;

    @FXML
    private TextField studentGrade_studentNum;

    @FXML
    private Label studentGrade_year;

    @FXML
    private Label studentGrade_course;

    @FXML
    private TextField studentGrade_firstSem;

    @FXML
    private TextField studentGrade_secondSem;

    @FXML
    private Button studentGrade_updateBtn;

    @FXML
    private Button studentGrade_clearBtn;

    @FXML
    private TableView<studentData> studentGrade_tableView;
    @FXML
    private TableView<studentData>    studentGrade_tablView;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_EmployeeNum;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_year;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_course;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_firstSem;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_secondSem;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_final;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_econdSem;
    @FXML
    private TableColumn<studentData, String> studentGrade_col_irstSem;
    @FXML
    private TableColumn<studentData, String> studentGrade_col_ourse;
    @FXML
    private TableColumn<studentData, String> studentGrade_col_mail;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_mployeeNum;
    @FXML
    private TextField studentGrade_search;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private Image image;

    public void homeDisplayTotalEnrolledStudents() throws SQLException {

        String sql = "SELECT COUNT(*) AS total_visits\n" +
                "FROM access_log WHERE access_log.store_id='"+getData.idstore+"'";

        connect = database.connectDb();

        int countEnrolled = 0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countEnrolled = result.getInt("total_visits");
            }

            home_totalEnrolled.setText(String.valueOf(countEnrolled));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeDisplayFemaleEnrolled() throws SQLException {

        String sql = " SELECT u.store_id, COUNT(*) AS female_visits  FROM access_log al JOIN users u ON al.user_id = u.id        WHERE u.gender = 'female' AND u.store_id ='"    +getData.idstore+"'\n"
        +"GROUP BY u.store_id";


        connect = database.connectDb();

        try {
            int countFemale = 0;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countFemale = result.getInt("female_visits");
            }

            home_totalFemale.setText(String.valueOf(countFemale));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void homeDisplayMaleEnrolled() throws SQLException {

        String sql = "SELECT u.store_id, COUNT(*) AS male_visits \n"+
        "FROM access_log al JOIN users u ON al.user_id = u.id  WHERE u.gender = 'male' AND u.store_id = '"+getData.idstore+"' GROUP BY u.store_id";


        connect = database.connectDb();

        try {
            int countMale = 0;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                countMale = result.getInt("male_visits");
            }
            home_totalMale.setText(String.valueOf(countMale));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void studentGradesUpdate() throws SQLException {
        double finalCheck1 = 0;
        double finalCheck2 = 0;

        String checkData = "SELECT * FROM student_grade WHERE EmployeeNum = '"
                + studentGrade_studentNum.getText() + "'";

        connect = database.connectDb();

        double finalResult = 0;

        try {

            prepare = connect.prepareStatement(checkData);
            result = prepare.executeQuery();

            if (result.next()) {
                finalCheck1 = result.getDouble("first_sem");
                finalCheck2 = result.getDouble("second_sem");
            }

            if (finalCheck1 == 0 || finalCheck2 == 0) {
                finalResult = 0;
            } else { //LIKE (X+Y)/2 AVE WE NEED TO FIND FOR FINALS
                finalResult = (Double.parseDouble(studentGrade_firstSem.getText())
                        + Double.parseDouble(studentGrade_secondSem.getText()) / 2);
            }

            String updateData = "UPDATE student_grade SET "
                    + " year = '" + studentGrade_year.getText()
                    + "', course = '" + studentGrade_course.getText()
                    + "', first_sem = '" + studentGrade_firstSem.getText()
                    + "', second_sem = '" + studentGrade_secondSem.getText()
                    + "', final = '" + finalResult + "' WHERE EmployeeNum = '"
                    + studentGrade_studentNum.getText() + "'";

            Alert alert;

            if (studentGrade_studentNum.getText().isEmpty()
                    || studentGrade_year.getText().isEmpty()
                    || studentGrade_course.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Student #" + studentGrade_studentNum.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    studentGradesShowListData();
                } else {
                    return;
                }

            }// NOT WE ARE CLOSER TO THE ENDING PART  :) LETS PROCEED TO DASHBOARD FORM 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void studentGradesClear() {
        studentGrade_studentNum.setText("");
        studentGrade_year.setText("");
        studentGrade_course.setText("");
        studentGrade_firstSem.setText("");
        studentGrade_secondSem.setText("");

        // Assuming getData is a class with a static field 'path' that holds the path to the selected image
        getData.path = "";

        // If using an ImageView to display the selected item image
        addItemInventory_imageView.setImage(null);
    }

    public ObservableList<studentData> studentGradesListData() throws SQLException {

        ObservableList<studentData> listData = FXCollections.observableArrayList();

        String sql = "SELECT i.*,s.name as storename\n" +
                "FROM items i\n" +
                "JOIN inventories inv ON i.inventory_id = inv.id\n" +
                "JOIN stores s ON inv.store_id = s.id -- Assuming `inventories` has a `store_id` column\n" +
                "WHERE s.id = '"+ getData.idstore+"'";

        connect = database.connectDb();

        try {
            studentData studentD;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
               
                studentD = new studentData(result.getInt("i.id"),
                        result.getInt("i.stock"),

                        result.getString("i.price"),

                        result.getString("i.description"),
                         result.getString("i.name"),
                         result.getString("storename"),
                         result.getString("i.image_url"));

                listData.add(studentD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<studentData> studentGradesList;



    public void studentGradesShowListData() throws SQLException {
        studentGradesList = studentGradesListData();
        System.out.println(studentGradesList.size());
        System.out.println(studentGradesList.get(0).getDescription());
        studentGrade_col_EmployeeNum.setCellValueFactory(new PropertyValueFactory<>("EmployeeNum"));
        studentGrade_col_year.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentGrade_col_final.setCellValueFactory(new PropertyValueFactory<>("stock"));
        studentGrade_col_firstSem.setCellValueFactory(new PropertyValueFactory<>("price"));
        studentGrade_col_secondSem.setCellValueFactory(new PropertyValueFactory<>("storeName"));
        studentGrade_col_course.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Set the items in the TableView
        studentGrade_tableView.setItems(studentGradesList);
    }

    public void studentGradesSelect() {

        studentData studentD = studentGrade_tableView.getSelectionModel().getSelectedItem();
        int num = studentGrade_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        studentGrade_studentNum.setText(String.valueOf(studentD.getEmployeeNum()));
        studentGrade_year.setText(studentD.getName());
        studentGrade_course.setText(studentD.getDescription());
        studentGrade_firstSem.setText(String.valueOf(studentD.getPrice()));
        studentGrade_secondSem.setText(String.valueOf(studentD.getStock()));
        String uri = "file:" + studentD.getImage_url();

        image = new Image(uri, 120, 149, false, true);
        addItemInventory_imageView.setImage(image);

        getData.path = studentD.getImage_url();
        

    }
  


    private double x = 0;
    private double y = 0;

    public void logout() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                //HIDE YOUR DASHBOARD FORM
                logout.getScene().getWindow().hide();

                //LINK YOUR LOGIN FORM 
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

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addItemInventoryUpdate()  throws SQLException {
        String updateData = "UPDATE items SET stock = ? WHERE id = '" + studentGrade_studentNum.getText() + "'";

        connect = connectDb(); // Method to establish a database connection

        try {
            Alert alert;

            // Check if the necessary fields are filled
            if (studentGrade_secondSem.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank field");
                alert.showAndWait();
            } else {

                PreparedStatement prepare = connect.prepareStatement(updateData);
                prepare.setInt(1, Integer.parseInt(studentGrade_secondSem.getText()));

                int affectedRows = prepare.executeUpdate();

                if (affectedRows > 0) {
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Item successfully updated!");
                    alert.showAndWait();

                    // Refresh your UI here
                    // Refresh your UI here
                    studentGradesShowListData();
                    // TO CLEAR THE FIELDS
                    studentGradesClear();
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Update failed. ");
                    alert.showAndWait();
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
    public ObservableList<studentData> studentGradesLisData() throws SQLException {

        ObservableList<studentData> listData = FXCollections.observableArrayList();

        String sql = "SELECT a.id,\n" +
                "    u.first_name, \n" +
                "    u.last_name, \n" +
                "    a.timestamp , \n" +
                "    s.name AS store_name\n" +
                "FROM access_log a\n" +
                "JOIN users u ON a.user_id = u.id\n" +
                "JOIN stores s ON a.store_id = s.id\n" +
                "ORDER BY a.timestamp DESC;\n";

        connect = connectDb();

        try {
            studentData studentD;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                studentD = new studentData(result.getInt("a.id"),
                        result.getString("u.first_name"),
                        result.getString("u.last_name"),
                        result.getString("store_name"),
                        result.getString("timestamp"));

                listData.add(studentD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<studentData> studentGradeList;

    public void studentGradesShowLisData() throws SQLException {
        studentGradeList = studentGradesLisData();
        studentGrade_col_mployeeNum.setCellValueFactory(new PropertyValueFactory<>("EmployeeNum"));
        studentGrade_col_mail.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        studentGrade_col_ourse.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        studentGrade_col_irstSem.setCellValueFactory(new PropertyValueFactory<>("storeName"));
        studentGrade_col_econdSem.setCellValueFactory(new PropertyValueFactory<>("status"));
//        WE NEED TO FIX THE DELETE ON ADD STUDENT FORM
        studentGrade_tablView.setItems(studentGradeList);
    }

    public void showInf() throws SQLException {

        String sql = " SELECT * FROM users where  id='"+getData.id_user+"'";

        connect = connectDb();

        try {
            studentData studentD;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {

                UserName.setText(result.getString("first_name"));
                LastName.setText(result.getString("last_name"));
                Gender.setText( result.getString("gender"));
                Email.setText(result.getString("email"));
                Pseudo.setText(result.getString("pseudo"));
                EditFirstName.setText(result.getString("first_name"));
                EditLastName.setText(result.getString("last_name"));
                EditPseudo.setText(result.getString("pseudo"));
               // listData.add(studentD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Update(ActionEvent actionEvent) throws SQLException {
        String updateData = "UPDATE users SET pseudo = ?, first_name = ?, last_name = ? WHERE id = ?";

        try {
            connect = connectDb(); // Assumes connectDb() returns a valid Connection object

            PreparedStatement prepare = connect.prepareStatement(updateData);

            // Assuming EditPseudo, EditFirstName, and EditLastName are TextField objects
            prepare.setString(1, EditPseudo.getText());
            prepare.setString(2, EditFirstName.getText());
            prepare.setString(3, EditLastName.getText());
            prepare.setInt(4, getData.id_user);
            Alert alert;
            int affectedRows = prepare.executeUpdate();
            if (affectedRows > 0) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();
                // TO UPDATE THE TABLEVIEW
                showInf();

            } else {
                // Handle case where user is not found or update fails
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Update failed!");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public void displayUsername(){
        username.setText(getData.username);
    }
    // THATS IT FOR THESE VIDEOS, THANKS FOR WATCHING!! SUBSCRIBE AND TURN ON NOTIFICATION 
//    TO NOTIF YOU FOR MORE UPCOMING VIDEOS THANKS FOR THE SUPPORT! : )
    public void defaultNav(){
        home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
    }
    
    public void switchForm(ActionEvent event) throws SQLException {
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            studentGrade_form.setVisible(false);
            studentGrade_form.setVisible(false);
            ShowViewers_form.setVisible(false);
            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            //addStudents_btn.setStyle("-fx-background-color:transparent");
            showViewers_btn.setStyle("-fx-background-color:transparent");
            studentGrade_btn.setStyle("-fx-background-color:transparent");

            homeDisplayTotalEnrolledStudents();
            homeDisplayMaleEnrolled();
            homeDisplayFemaleEnrolled();
            showInf();

        }  else if (event.getSource() == studentGrade_btn) {
            home_form.setVisible(false);
            //addStudents_form.setVisible(false);
            home_form.setVisible(false);
            //addStudents_form.setVisible(false);
            //availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(true);
            ShowViewers_form.setVisible(false);
            studentGrade_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
             showViewers_btn.setStyle("-fx-background-color:transparent");
           // availableCourse_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");

            studentGradesShowListData();
            //studentGradesSearch();

        }
        else if (event.getSource() ==  showViewers_btn) {
            home_form.setVisible(false);
            //addStudents_form.setVisible(false);
            //availableCourse_form.setVisible(false);
            studentGrade_form.setVisible(false);
            ShowViewers_form.setVisible(true);
            showViewers_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            //  addStudents_btn.setStyle("-fx-background-color:transparent");
            // availableCourse_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            studentGrade_btn.setStyle("-fx-background-color:transparent");
            studentGradesShowLisData();
            //studentGradesSearch();

        }
    }








    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    // SORRY ABOUT THAT, I JUST NAMED THE DIFFERENT COMPONENTS WITH THE SAME NAME 
    // MAKE SURE THAT THE NAME YOU GAVE TO THEM ARE DIFFERENT TO THE OTHER OKAY?
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        defaultNav();

        try {
            homeDisplayTotalEnrolledStudents();
            homeDisplayMaleEnrolled();
            homeDisplayFemaleEnrolled();
            showInf();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // TO SHOW IMMIDIATELY WHEN WE PROCEED TO DASHBOARD APPLICATION FORM

        try {
            studentGradesShowListData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
