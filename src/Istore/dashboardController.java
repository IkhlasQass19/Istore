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

import com.mysql.cj.log.NullLogger;
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
public class dashboardController implements Initializable {

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
    private Button addEmployer_btn;

    @FXML
    private Button addEmail_btn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField EditFirstName;

    @FXML
    private TextField EditLastName;

    @FXML
    private TextField EditPseudo;

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
    private Button addStore_btn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalEnrolled;

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
    private TextField addStudents_search;
@FXML
private Button ShowViewers_btn;
    @FXML
    private TableView<studentData> addStudents_tableView;

    @FXML
    private TableColumn<studentData, String> addStudents_col_EmployeeNum;

    @FXML
    private TableColumn<studentData, String> addStudents_col_email;

    @FXML
    private TableColumn<studentData, String> addStudents_col_pseudo;

    @FXML
    private TableColumn<studentData, String> addStudents_col_firstName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_lastName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_gender;

    @FXML
    private TableColumn<studentData, String> addStudents_col_storeName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_password;

    @FXML
    private TextField addStudents_EmployeeNum;

    @FXML
    private TextField addStudents_email;

    @FXML
    private ComboBox<?> addStudents_course;

    @FXML
    private TableView<Item> addItemInventory_tableView;
    @FXML
    private TableColumn<Item, Integer> addItemInventory_col_Id;
    @FXML
    private TableColumn<Item, String> addItemInventory_col_name;
    @FXML
    private TableColumn<Item, BigDecimal> addItemInventory_col_price;
    @FXML
    private TableColumn<Item, Integer> addItemInventory_col_stock;
    @FXML
    private TableColumn<Item, String> addItemInventory_col_description;
    @FXML
    private TableColumn<Item, Integer> addItemInventory_col_idInvontory;
    @FXML
    private TableColumn<Item, String> addItemInventory_col_storeName;

    @FXML
    private ComboBox<?>addItemInventory_idInvontory;

    @FXML
    private TextField addStudents_firstName;

    @FXML
    private TextField addStudents_lastName;

    @FXML
    private TextField addStudents_Email;

    @FXML
    private TextField addStudents_pseudo;

    @FXML
    private ComboBox<?> addStudents_gender;

    @FXML
    private TextField itemIdaddItemInventory_Id;

    @FXML
    private ImageView addStudents_imageView;

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
    private Button addInventory_btn;

    @FXML
    private AnchorPane availableEmail_form;

    @FXML
    private AnchorPane addInvontoryItem_form;
    @FXML
    private AnchorPane addInventory_form;
    @FXML
    private AnchorPane addStore_form;
    
    @FXML
    private TextField addItemInventory_Id;
    @FXML
    private TextField availableEmail;

    @FXML
    private TextField Inventory;

    @FXML
    private TextField Inventory_description;

    @FXML
    private TextField Inventory_degree;

    @FXML
    private Button Inventory_addBtn;

    @FXML
    private Button Inventory_updateBtn;
    @FXML
    private Button addInventoryItem_btn;
    @FXML
    private Button Inventory_clearBtn;

    @FXML
    private Button Inventory_deleteBtn;

    @FXML
    private TextField availableEmail_description;
    @FXML
    private TextField Store;

    @FXML
    private TextField Store_description;

    @FXML
    private TextField Store_degree;

    @FXML
    private Button Store_addBtn;

    @FXML
    private Button Store_updateBtn;

    @FXML
    private Button Store_clearBtn;

    @FXML
    private Button Store_deleteBtn;

    @FXML
    private TextField availableEmail_degree;

    @FXML
    private Button availableEmail_addBtn;

    @FXML
    private Button availableEmail_updateBtn;

    @FXML
    private Button availableEmail_clearBtn;

    @FXML
    private Button availableEmail_deleteBtn;

    @FXML
    private TableView<courseData> availableEmail_tableView;

    @FXML
    private TableColumn<courseData, String> availableEmail_col_course;

    @FXML
    private TableColumn<courseData, String> availableEmail_col_description;

    @FXML
    private TableColumn<courseData, String> availableEmail_col_degree;

    @FXML
    private TableView<courseData> Store_tableView;

    @FXML
    private TableColumn<courseData, String> Store_col_course;

    @FXML
    private TableColumn<courseData, String> Store_col_description;

    @FXML
    private TableColumn<courseData, String> Store_col_degree;

    @FXML
    private TableView<courseData> Inventory_tableView;

    @FXML
    private TableColumn<courseData, String> Inventory_col_course;

    @FXML
    private TableColumn<courseData, String> Inventory_col_description;

    @FXML
    private TableColumn<courseData, String> Inventory_col_degree;

    @FXML
    private AnchorPane ShowViewers_form;

    @FXML
    private AnchorPane addItemInventory_form;

    @FXML
    private TextField studentGrade_EmployeeNum;

    @FXML
    private TextField addItemInventory_search;
    @FXML
    private Label studentGrade_email;

    @FXML
    private Label studentGrade_course;

    @FXML
    private TextField studentGrade_firstSem;

    @FXML
    private TextField Price;

    @FXML
    private TextField studentGrade_secondSem;

    @FXML
    private TextField addItemInventory_description;

    @FXML
    private TextField addItemInventory_stock;

    @FXML
    private TextField addItemInventory_name;

    @FXML
    private Button studentGrade_updateBtn;

    @FXML
    private Button studentGrade_clearBtn;

    @FXML
    private TableView<studentData> studentGrade_tableView;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_EmployeeNum;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_email;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_course;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_firstSem;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_secondSem;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_final;

    @FXML
    private TextField studentGrade_search;
    @FXML
    private ImageView addItemInventory_imageView;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private Image image;

    public void homeDisplayTotalEnrolledStudents() throws SQLException {

        String sql = "SELECT COUNT(*) AS total_visits\n" +
                "FROM access_log";

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

        String sql = " SELECT u.store_id, COUNT(*) AS female_visits  FROM access_log al JOIN users u ON al.user_id = u.id        WHERE u.gender = 'female'";



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




    public void addStudentsAdd() throws SQLException {


        String insertData = "INSERT INTO users (email, password_hash, pseudo, role, store_id, first_name, last_name, gender, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        connect = connectDb();

        try {
            Alert alert;

            if ( addStudents_Email.getText().isEmpty()
                    || addStudents_firstName.getText().isEmpty()
                    || addStudents_lastName.getText().isEmpty()
                    || addStudents_gender.getSelectionModel().getSelectedItem() == null
                    || addStudents_Email.getText().isEmpty()
                    || addStudents_pseudo.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String checkData = "SELECT id FROM stores WHERE name = '" + addStudents_course.getSelectionModel().getSelectedItem() + "'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);
                int storeId=0;
                // Process the result
                if (result.next()) {
                    storeId = result.getInt("id");
                    System.out.println("The ID for store '" + addStudents_course.getSelectionModel().getSelectedItem() + "' is: " + storeId);
                } else {
                    System.out.println("Store not found.");
                }
                // CHECK IF THE EmployeeNumBER IS ALREADY EXIST
                checkData = "SELECT email FROM whitelistedemails WHERE Email = '"
                        + addStudents_Email.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Email #" + addStudents_EmployeeNum.getText() + " was already use it !");
                    alert.showAndWait();
                } else {

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, (String)addStudents_Email.getText());
                    String hashedPassword=SecurePassword.hashPassword(password.getText());
                    prepare.setString(2, (String) hashedPassword);
                    prepare.setString(3, (String) addStudents_pseudo.getText());
                    prepare.setString(4, (String) "employee");
                    if(storeId==0)
                        prepare.setInt(5,java.sql.Types.INTEGER);
                    else
                        prepare.setInt(5, storeId);
                    prepare.setString(6, addStudents_firstName.getText());
                    prepare.setString(7, addStudents_lastName.getText());
                    prepare.setString(8, (String) addStudents_gender.getSelectionModel().getSelectedItem());


                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(9, uri);

                    prepare.executeUpdate();

                    String insertStudentGrade = "INSERT INTO whitelistedemails "
                            + "(email) "
                            + "VALUES(?)";

                    prepare = connect.prepareStatement(insertStudentGrade);
                    prepare.setString(1, (String) addStudents_Email.getText());
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                    // TO CLEAR THE FIELDS
                    addStudentsClear();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudentsUpdate() throws SQLException {
        String updateData = "UPDATE users SET password_hash = ?, pseudo = ?, role = ?, store_id = ?, first_name = ?, last_name = ?, gender = ?, image = ? WHERE email = ?";

        connect = connectDb(); // Assumes connectDb() returns a valid Connection object

        try {
            Alert alert;

            String selectedStoreName = (String) addStudents_course.getSelectionModel().getSelectedItem();
            String checkStore = "SELECT id FROM stores WHERE name = '" + selectedStoreName + "'";
            statement = connect.createStatement();
            result = statement.executeQuery(checkStore);
            int storeId = 0;
            if (result.next()) {
                storeId = result.getInt("id");
            } else {
                System.out.println("Store not found.");
                // Handle "store not found" case appropriately
                return;
            }

            // Assuming email is the unique identifier to find which user to update
            String userEmail = addStudents_Email.getText();

            prepare = connect.prepareStatement(updateData);
            String hashedPassword = SecurePassword.hashPassword(password.getText());
            prepare.setString(1, hashedPassword);
            prepare.setString(2, addStudents_pseudo.getText());
            prepare.setString(3, "employee"); // Assuming the role doesn't change, or you get it from a UI element like addStudents_role.getSelectionModel().getSelectedItem()
            prepare.setInt(4, storeId);
            prepare.setString(5, addStudents_firstName.getText());
            prepare.setString(6, addStudents_lastName.getText());
            prepare.setString(7, (String) addStudents_gender.getSelectionModel().getSelectedItem());

            String uri = getData.path;
            uri = uri.replace("\\", "\\\\");
            prepare.setString(8, uri);
            prepare.setString(9, userEmail);

            int affectedRows = prepare.executeUpdate();
            if (affectedRows > 0) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();

                // TO UPDATE THE TABLEVIEW
                addStudentsShowListData();
                // TO CLEAR THE FIELDS
                addStudentsClear();
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
            // Close your resources
            if (result != null) result.close();
            if (statement != null) statement.close();
            if (prepare != null) prepare.close();
            if (connect != null) connect.close();
        }
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


    public void addStudentsDelete() throws SQLException {

        String deleteData = "DELETE FROM users WHERE id = '"
                + addStudents_EmployeeNum.getText() + "'";

        connect = connectDb();

        try {
            Alert alert;

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Employee #" + addStudents_EmployeeNum.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    String checkData = "SELECT Email FROM whitelistedemails "
                            + "WHERE email = '" + addStudents_Email.getText() + "'";

                    prepare = connect.prepareStatement(checkData);
                    result = prepare.executeQuery();


                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addStudentsShowListData();
                    // TO CLEAR THE FIELDS
                    addStudentsClear();

                } else {
                    return;
                }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addStudentsClear() throws SQLException {
        addStudents_EmployeeNum.setText("");
        addStudents_Email.setText("");
        addStudents_course.getSelectionModel().clearSelection();
        addStudents_firstName.setText("");
        addStudents_lastName.setText("");
        addStudents_gender.getSelectionModel().clearSelection();
        addStudents_Email.setText("");
        addStudents_pseudo.setText("");
        addStudents_imageView.setImage(null);

        getData.path = "";
    }

    public void  addItemInventoryInsertImage ()throws SQLException {
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {

            image = new Image(file.toURI().toString(), 120, 149, false, true);
            addItemInventory_imageView.setImage(image);

            getData.path = file.getAbsolutePath();

        }
    }

    public void addStudentsInsertImage() throws SQLException {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {

            image = new Image(file.toURI().toString(), 120, 149, false, true);
            addStudents_imageView.setImage(image);

            getData.path = file.getAbsolutePath();

        }
    } //WHILE WE INSERT THE DATA ON STUDENT, WE SHOULD INSERT ALSO THE DATA TO STUDENT_GRADE


        public void addStudentsSearch() {
            // Assuming addStudentsListD is an ObservableList<studentData> already populated with your data
       /*     FilteredList<studentData> filteredData = new FilteredList<>(addStudentsListD, p -> true);

            addStudents_search.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(student -> {
                    if (newValue == null || newValue.trim().isEmpty()) {
                        return true; // Display all data if search field is empty.
                    }
                    String lowerCaseFilter = newValue.toLowerCase();

                    // Example predicate condition
                    if (student.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }
                    // Add more conditions here as needed.
                else if (student.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (student.getPassword().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (student.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (student.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (student.getGender().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (student.getStoreName().toString().contains(lowerCaseFilter)) {
                    return true;
                } else if (student.getPseudo().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

            SortedList<studentData> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(addStudents_tableView.comparatorProperty());
            addStudents_tableView.setItems(sortedData);*/
    }


    public void addStudentsCourseList() throws SQLException {

        String listCourse = "SELECT * FROM stores";

        connect = connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("name"));
            }
            addStudents_course.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addItemInventoryidInvontoryList() throws SQLException {

        String listCourse = "SELECT *   FROM inventories ,stores as s WHERE s.id=inventories.store_id";

        connect = connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("name"));
            }
            addItemInventory_idInvontory.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private String[] genderList = {"Male", "Female", "Others"};

    public void addStudentsGenderList() throws SQLException {
        List<String> genderL = new ArrayList<>();

        for (String data : genderList) {
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);
        addStudents_gender.setItems(ObList);
    }


    public ObservableList<studentData> addStudentsListData() throws SQLException {

        ObservableList<studentData> listStudents = FXCollections.observableArrayList();

        String sql = "SELECT users.*, s.name AS store_name\n" +
                "FROM users\n" +
                "LEFT JOIN stores AS s ON users.store_id = s.id;\n";

        connect = connectDb();

        try {
            studentData studentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                studentD = new studentData(result.getInt("id"),
                        result.getString("email"),
                        result.getString("pseudo"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("gender"),
                        result.getString("role"),
                        result.getString("password_hash"),
                        result.getString("store_name") ,
                        result.getString("image"));
                listStudents.add(studentD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }

    private ObservableList<studentData> addStudentsListD;

    public void addStudentsShowListData() throws SQLException {
        addStudentsListD = addStudentsListData();

        addStudents_col_EmployeeNum.setCellValueFactory(new PropertyValueFactory<>("EmployeeNum"));
        addStudents_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        addStudents_col_pseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
        addStudents_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addStudents_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addStudents_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addStudents_col_storeName.setCellValueFactory(new PropertyValueFactory<>("storeName"));
        addStudents_col_password.setCellValueFactory(new PropertyValueFactory<>("password"));

        addStudents_tableView.setItems(addStudentsListD);

    }

    public void addStudentsSelect()  {

        studentData studentD = addStudents_tableView.getSelectionModel().getSelectedItem();
        int num = addStudents_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addStudents_EmployeeNum.setText(String.valueOf(studentD.getEmployeeNum()));
        addStudents_firstName.setText(studentD.getFirstName());
        addStudents_lastName.setText(studentD.getLastName());
        addStudents_Email.setText(studentD.getEmail());
        addStudents_pseudo.setText(studentD.getPseudo());
        password.setText(studentD.getPassword());
        String uri = "file:" + studentD.getImage();

        image = new Image(uri, 120, 149, false, true);
        addStudents_imageView.setImage(image);

        getData.path = studentD.getImage();

    }
    private ObservableList<studentData> masterStudentData = FXCollections.observableArrayList();

    // Method to populate the TableView with initial data (to be called, for example, in an @FXML initialize method)
    public void initializeStudentData() {
        masterStudentData.addAll(/* Fetch your student data */);
        addStudents_tableView.setItems(masterStudentData);

        setupStudentSearchFilter();
    }

    public void setupStudentSearchFilter() {
        FilteredList<studentData> filteredData = new FilteredList<>(masterStudentData, p -> true);

        addStudents_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(student -> {
                // If filter text is empty, display all students.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (student.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches email.
                } else if (student.getPseudo().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches pseudo.
                } else if (student.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (student.getLastName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (student.getStoreName() != null && student.getStoreName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches store name.
                }
                return false; // Does not match.
            });
        });

        SortedList<studentData> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(addStudents_tableView.comparatorProperty());
        addStudents_tableView.setItems(sortedData);
    }
    public void StoreAdd() throws SQLException {

        String insertData = "INSERT INTO stores (name) VALUES(?)";

        connect = connectDb();

        try {
            Alert alert;

            if (Store.getText().isEmpty() ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank field");
                alert.showAndWait();
            } else {
//            CHECK IF THE COURSE YOU WANT TO INSERT IS ALREADY EXIST!
                String checkData = "SELECT name FROM stores WHERE name = '"
                        + Store.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Store : " + Store.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, Store.getText());


                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    StoreShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    StoreClear();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void StoreUpdate() throws SQLException {

        String updateData = "UPDATE stores SET name = '"
                + Store.getText() + " ' WHERE id = '"
                + Store_description.getText() + "'";

        connect = connectDb();

        try {
            Alert alert;

            if (Store.getText().isEmpty()
            ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank field");
                alert.showAndWait();
            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Course: " + Store.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    StoreShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    StoreClear();

                } else {
                    return;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void StoreDelete() throws SQLException {

        String deleteData = "DELETE FROM stores WHERE name = '"
                + Store.getText() + "'";

        connect = connectDb();

        try {
            Alert alert;

            if (Store.getText().isEmpty()
            ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank field");
                alert.showAndWait();
            } else {
//                ALL GOOD GUYS! NOW LETS PROCEED TO ADD STUDENTS FORM
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Stores: " + Store.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    StoreShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    StoreClear();

                } else {
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void StoreClear()  {
        Store.setText("");
        Store_description.setText("");

    }
    public ObservableList<courseData> StoreListData() throws SQLException {

        ObservableList<courseData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM stores";

        connect = connectDb();

        try {
            courseData courseD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                courseD = new courseData(result.getInt("id"),
                        result.getString("name"));

                listData.add(courseD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<courseData> StoreList;

    public void StoreShowListData() throws SQLException {
        StoreList = StoreListData();
        Store_col_course.setCellValueFactory(new PropertyValueFactory<>("id"));

        Store_col_description.setCellValueFactory(new PropertyValueFactory<>("email"));

        Store_tableView.setItems(StoreList);

    }

    public void StoreSelect()  {
        courseData courseD = Store_tableView.getSelectionModel().getSelectedItem();
        int num = Store_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        Store_description.setText(String.valueOf(courseD.getId()));
        Store.setText(courseD.getEmail());

    }


    public void InventoryAdd() throws SQLException {

        String insertData = "INSERT INTO inventories (store_id) VALUES(?)";

        connect = connectDb();

        try {
            Alert alert;

            if (addStudents_course.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank field");
                alert.showAndWait();
            } else {
//            CHECK IF THE COURSE YOU WANT TO INSERT IS ALREADY EXIST!
                String checkData = "SELECT id FROM stores WHERE name = '" + addStudents_course.getSelectionModel().getSelectedItem() + "'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);
                int idstore=0;
// Correctly check if the store exists by moving result.next() up
                if (result.next()) {
                    idstore = result.getInt("id");
                    // Show error alert if the store (course) already exists

                    String chekData = "SELECT store_id FROM inventories WHERE store_id = '" + idstore+ "'";
                    statement = connect.createStatement();
                    result = statement.executeQuery(chekData);

// Correctly check if the store exists by moving result.next() up
                    if (result.next()) {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Inventory : " + addStudents_course.getSelectionModel().getSelectedItem() + " already exists!");
                        alert.showAndWait();
                    }
                    else {
                        prepare = connect.prepareStatement(insertData);
                        prepare.setString(1, String.valueOf(idstore));


                        prepare.executeUpdate();

                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Added!");
                        alert.showAndWait();

                        // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                        InventoryShowListData();
                        // TO CLEAR THE TEXT FIELDS
                        InventoryClear();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InventoryUpdate() throws SQLException {


        connect = connectDb();

        try {
            Alert alert;

            if (addStudents_course.getSelectionModel().getSelectedItem() == null
            ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank field");
                alert.showAndWait();
            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Inventory: " + Inventory.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    String checkData = "SELECT id FROM stores WHERE name = '" + addStudents_course.getSelectionModel().getSelectedItem() + "'";
                    statement = connect.createStatement();
                    result = statement.executeQuery(checkData);
                    int idstore = 0;
// Correctly check if the store exists by moving result.next() up
                    if (result.next()) {
                        idstore = result.getInt("id");
                        // Show error alert if the store (course) already exists

                        String chekData = "SELECT store_id FROM inventories WHERE store_id = '" + idstore + "'";
                        statement = connect.createStatement();
                        result = statement.executeQuery(chekData);

// Correctly check if the store exists by moving result.next() up
                        if (result.next()) {
                            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error Message");
                            alert.setHeaderText(null);
                            alert.setContentText("Inventory : " + addStudents_course.getSelectionModel().getSelectedItem() + " already exists!");
                            alert.showAndWait();
                        } else {

                            String updateData = "UPDATE inventories SET store_id = '"
                                    + idstore + " ' WHERE id = '"
                                    + Inventory.getText() + "'";

                            statement = connect.createStatement();
                            statement.executeUpdate(updateData);

                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Information Message");
                            alert.setHeaderText(null);
                            alert.setContentText("Successfully Updated!");
                            alert.showAndWait();

                            // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                            InventoryShowListData();
                            // TO CLEAR THE TEXT FIELDS
                            InventoryClear();
                        }
                    }
                }

                else {
                    return;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void InventoryDelete() throws SQLException {

        String deleteData = "DELETE FROM inventories WHERE id = '"
                + Inventory.getText() + "'";

        connect = connectDb();

        try {
            Alert alert;

            if (Inventory.getText().isEmpty()
            ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank field");
                alert.showAndWait();
            } else {
//                ALL GOOD GUYS! NOW LETS PROCEED TO ADD STUDENTS FORM
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Inventory: " + Inventory.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    InventoryShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    InventoryClear();

                } else {
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void InventoryClear()  {
        Inventory.setText("");
        addStudents_course.getSelectionModel().clearSelection();

    }
    public ObservableList<courseData> InventoryListData() throws SQLException {

        ObservableList<courseData> listData = FXCollections.observableArrayList();

        String sql = "SELECT *   FROM inventories ,stores as s WHERE s.id=inventories.store_id ";

        connect = connectDb();

        try {
            courseData courseD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                courseD = new courseData(result.getInt("id"),
                        result.getString("name"));

                listData.add(courseD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<courseData> InventoryList;

    public void InventoryShowListData() throws SQLException {
        InventoryList = InventoryListData();
        Inventory_col_course.setCellValueFactory(new PropertyValueFactory<>("id"));

        Inventory_col_description.setCellValueFactory(new PropertyValueFactory<>("email"));

        Inventory_tableView.setItems(InventoryList);

    }

    public void InventorySelect()  {
        courseData courseD = Inventory_tableView.getSelectionModel().getSelectedItem();
        int num = Inventory_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        Inventory.setText(String.valueOf(courseD.getId()));

    }

    public void availableEmailAdd() throws SQLException {

        String insertData = "INSERT INTO whitelistedemails (email) VALUES(?)";

        connect = connectDb();

        try {
            Alert alert;

            if (availableEmail.getText().isEmpty() ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank field");
                alert.showAndWait();
            } else {
//            CHECK IF THE COURSE YOU WANT TO INSERT IS ALREADY EXIST!
                String checkData = "SELECT email FROM whitelistedemails WHERE email = '"
                        + availableEmail.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Email: " + availableEmail.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, availableEmail.getText());


                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    availableEmailShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    availableEmailClear();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void availableEmailUpdate() throws SQLException {

        String updateData = "UPDATE whitelistedemails SET email = '"
                + availableEmail.getText() + " ' WHERE id = '"
                + availableEmail_description.getText() + "'";

        connect = connectDb();

        try {
            Alert alert;

            if (availableEmail.getText().isEmpty()
                 ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank field");
                alert.showAndWait();
            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Course: " + availableEmail.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    availableEmailShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    availableEmailClear();

                } else {
                    return;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void availableEmailDelete() throws SQLException {

        String deleteData = "DELETE FROM whitelistedemails WHERE email = '"
                + availableEmail.getText() + "'";

        connect = connectDb();

        try {
            Alert alert;

            if (availableEmail.getText().isEmpty()
                    ) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank field");
                alert.showAndWait();
            } else {
//                ALL GOOD GUYS! NOW LETS PROCEED TO ADD STUDENTS FORM
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Email: " + availableEmail.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    // TO BECOME UPDATED OUR TABLEVIEW ONCE THE DATA WE GAVE SUCCESSFUL
                    availableEmailShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    availableEmailClear();

                } else {
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void availableEmailClear()  {
        availableEmail.setText("");
        availableEmail_description.setText("");

    }

    public ObservableList<courseData> availableEmailListData() throws SQLException {

        ObservableList<courseData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM whitelistedemails";

        connect = connectDb();

        try {
            courseData courseD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                courseD = new courseData(result.getInt("id"),
                        result.getString("email"));

                listData.add(courseD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<courseData> availableEmailList;


    public void availableEmailShowListData() throws SQLException {
        availableEmailList = availableEmailListData();
        availableEmail_col_course.setCellValueFactory(new PropertyValueFactory<>("id"));

        availableEmail_col_description.setCellValueFactory(new PropertyValueFactory<>("email"));

        availableEmail_tableView.setItems(availableEmailList);

    }

    public void availableEmailSelect()  {
        courseData courseD = availableEmail_tableView.getSelectionModel().getSelectedItem();
        int num = availableEmail_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        availableEmail_description.setText(String.valueOf(courseD.getId()));
        availableEmail.setText(courseD.getEmail());

    }

    public void addItemInventoryAdd() throws SQLException {
        String insertData = "INSERT INTO items (inventory_id, name, price, stock, description, image_url) VALUES (?, ?, ?, ?, ?, ?)";

        connect = connectDb(); // Method to establish a database connection

        try {
            Alert alert;

            // Assuming these are TextField and ComboBox inputs from your UI
            if (addItemInventory_name.getText().isEmpty() ||Price.getText().isEmpty() || addItemInventory_stock.getText().isEmpty()
                    || addItemInventory_description.getText().isEmpty() || addItemInventory_idInvontory.getSelectionModel().getSelectedItem() == null
                     || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String checkData = "SELECT inventories.id AS inventory_id FROM inventories JOIN stores ON stores.id = inventories.store_id WHERE stores.name = '"
                        + addItemInventory_idInvontory.getSelectionModel().getSelectedItem()+ "'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {

                    int inventoryIdValue =result.getInt("inventory_id");
                    BigDecimal price = new BigDecimal(Price.getText());
                    int stock = Integer.parseInt(addItemInventory_stock.getText());
                    String description = addItemInventory_description.getText();

                    PreparedStatement prepare = connect.prepareStatement(insertData);
                    prepare.setInt(1, inventoryIdValue);
                    prepare.setString(2, addItemInventory_name.getText());
                    prepare.setBigDecimal(3, price);
                    prepare.setInt(4, stock);
                    prepare.setString(5, description);


                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(6, uri);

                    prepare.executeUpdate();


                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Item successfully added!");
                    alert.showAndWait();

                    // Refresh your UI here
                    addItemInventoryShowListData();
                    // TO CLEAR THE FIELDS
                    addItemInventoryClear();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions or errors here
        }
    }

    public void addItemInventoryUpdate()  throws SQLException {
        String updateData = "UPDATE items SET inventory_id = ?, name = ?, price = ?, stock = ?, description = ?, image_url = ? WHERE id = ?";

        connect = connectDb(); // Method to establish a database connection

        try {
            Alert alert;

            // Check if the necessary fields are filled
            if (addItemInventory_name.getText().isEmpty() || Price.getText().isEmpty() || addItemInventory_stock.getText().isEmpty()
                    || addItemInventory_description.getText().isEmpty() || addItemInventory_idInvontory.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path.equals("")) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                // Assuming you retrieve the inventory ID as you did in the add method
                String selectedStoreName = addItemInventory_idInvontory.getSelectionModel().getSelectedItem().toString();
                String getInventoryIdQuery = "SELECT inventories.id AS inventory_id FROM inventories JOIN stores ON stores.id = inventories.store_id WHERE stores.name = '"
                        + selectedStoreName + "'";
                statement = connect.createStatement();
                result = statement.executeQuery(getInventoryIdQuery);

                if (result.next()) {
                    int inventoryIdValue = result.getInt("inventory_id");
                    BigDecimal price = new BigDecimal(Price.getText());
                    int stock = Integer.parseInt(addItemInventory_stock.getText());
                    String description = addItemInventory_description.getText();
                    String imageUri = getData.path.replace("\\", "\\\\");

                    PreparedStatement prepare = connect.prepareStatement(updateData);
                    prepare.setInt(1, inventoryIdValue);
                    prepare.setString(2, addItemInventory_name.getText());
                    prepare.setBigDecimal(3, price);
                    prepare.setInt(4, stock);
                    prepare.setString(5, description);
                    prepare.setString(6, imageUri);
                    prepare.setInt(7, Integer.parseInt(addItemInventory_Id.getText())); // Set the ID of the item to update

                    int affectedRows = prepare.executeUpdate();

                    if (affectedRows > 0) {
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Item successfully updated!");
                        alert.showAndWait();

                        // Refresh your UI here
                        // Refresh your UI here
                        addItemInventoryShowListData();
                        // TO CLEAR THE FIELDS
                        addItemInventoryClear();
                    } else {
                        alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Update failed. No item was found with ID: " + itemIdaddItemInventory_Id.getText());
                        alert.showAndWait();
                    }
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("No inventory found for the selected store: " + selectedStoreName);
                    alert.showAndWait();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions or errors here
        }
    }
    public void addItemInventoryDelete() throws SQLException {
        // Assuming addItemInventory_EmployeeNum.getText() actually contains the ID of the item to delete
        String itemIdToDelete = addItemInventory_Id.getText();

        if (itemIdToDelete.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Item ID is empty, cannot proceed with delete.");
            alert.showAndWait();
            return;
        }

        String deleteData = "DELETE FROM items WHERE id = ?"; // Use parameterized query to prevent SQL injection

        connect = connectDb(); // Assumes connectDb() returns a valid Connection object

        try {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmation Message");
            confirmationAlert.setHeaderText(null);
            confirmationAlert.setContentText("Are you sure you want to DELETE Item #" + itemIdToDelete + "?");

            Optional<ButtonType> option = confirmationAlert.showAndWait();

            if (option.isPresent() && option.get() == ButtonType.OK) {
                PreparedStatement prepare = connect.prepareStatement(deleteData);
                prepare.setInt(1, Integer.parseInt(itemIdToDelete)); // Convert itemIdToDelete to integer
                int affectedRows = prepare.executeUpdate();

                if (affectedRows > 0) {
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Information Message");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Successfully Deleted Item ID #" + itemIdToDelete + "!");
                    successAlert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    addItemInventoryShowListData();
                    // TO CLEAR THE FIELDS
                    addItemInventoryClear();
                } else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Error Message");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Failed to delete Item ID #" + itemIdToDelete + ". Item may not exist.");
                    errorAlert.showAndWait();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions or errors here
        } finally {
            // Optionally, close your resources here
        }
    }
    private ObservableList<Item> itemList;
    public ObservableList<Item> ItemIventoryListData() throws SQLException {
            ObservableList<Item> listData = FXCollections.observableArrayList();

            // Assuming the SQL query fetches item data including the store name
            String sql = "SELECT items.id, items.name, items.price, items.stock, items.description, items.inventory_id,  items.image_url ,stores.name AS storeName " +
                    "FROM items " +
                    "JOIN inventories ON items.inventory_id = inventories.id " +
                    "JOIN stores ON inventories.store_id = stores.id";

            connect = connectDb();

            try {
                PreparedStatement prepare = connect.prepareStatement(sql);
                ResultSet result = prepare.executeQuery();

                while (result.next()) {
                    Item item = new Item(
                            result.getInt("id"),
                            result.getString("name"),
                            result.getBigDecimal("price"),
                            result.getInt("stock"),
                            result.getString("description"),
                            result.getInt("inventory_id"),
                            result.getString("storeName"),
                            result.getString("image_url")
                    );

                    listData.add(item);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return listData;

    }
    public void addItemInventoryShowListData() throws SQLException {

        itemList=ItemIventoryListData();
        // Example to set up the cell value factories
        addItemInventory_col_Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        addItemInventory_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        addItemInventory_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        addItemInventory_col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addItemInventory_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        addItemInventory_col_idInvontory.setCellValueFactory(new PropertyValueFactory<>("inventoryId"));
        addItemInventory_col_storeName.setCellValueFactory(new PropertyValueFactory<>("storeName"));

        addItemInventory_tableView.setItems(itemList);

    }
    public void addItemInventoryClear() {
        // Clear the fields related to item details
        addItemInventory_Id.setText("");
        addItemInventory_name.setText("");
        Price.setText(""); // Assuming Price is a TextField for the item's price
        addItemInventory_stock.setText("");
        addItemInventory_description.setText("");
        addItemInventory_idInvontory.getSelectionModel().clearSelection(); // Assuming this ComboBox selects the inventory or store

        // Assuming getData is a class with a static field 'path' that holds the path to the selected image
        getData.path = "";

        // If using an ImageView to display the selected item image
        addItemInventory_imageView.setImage(null);
    }

    public void addItemInventorySelect(){
        Item selectedItem = addItemInventory_tableView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            return; // No item selected
        }

        // Populate form fields with the selected item's details
        addItemInventory_Id.setText(String.valueOf(selectedItem.getId()));
        addItemInventory_name.setText(selectedItem.getName());
        Price.setText(selectedItem.getPrice().toString());
        addItemInventory_stock.setText(selectedItem.getStock().toString());
        addItemInventory_description.setText(selectedItem.getDescription());

        // Assuming you have a way to set inventory ID to ComboBox, you might need to find the inventory name or ID in the ComboBox list
        // addItemInventory_idInvontory.getSelectionModel().select(...);

        // Load and display the image
        String uri = selectedItem.getImagePath();
        if (uri != null && !uri.isEmpty()) {
            Image image = new Image("file:" + uri, 120, 149, false, true);
            addItemInventory_imageView.setImage(image);
        } else {
            addItemInventory_imageView.setImage(null); // Clear the image view if there's no image
        }

        // Assuming getData is a class where you store the path of the image for further use
        getData.path = uri;


    }

    // ObservableList to hold your items data
    private ObservableList<Item> masterData = FXCollections.observableArrayList();

    // This method should be called to initially populate the TableView with items
    public void initializeTableData() {
        masterData.addAll(/* Fetch your items data from the database or any data source */);
        addItemInventory_tableView.setItems(masterData);

        // Call this method to set up the search functionality
        //setupSearchFilter();
    }


    public void studentGradesUpdate() throws SQLException {
        double finalCheck1 = 0;
        double finalCheck2 = 0;

        String checkData = "SELECT * FROM student_grade WHERE EmployeeNum = '"
                + studentGrade_EmployeeNum.getText() + "'";

        connect = connectDb();

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
                    + " email = '" + studentGrade_email.getText()
                    + "', course = '" + studentGrade_course.getText()
                    + "', first_sem = '" + studentGrade_firstSem.getText()
                    + "', second_sem = '" + studentGrade_secondSem.getText()
                    + "', final = '" + finalResult + "' WHERE EmployeeNum = '"
                    + studentGrade_EmployeeNum.getText() + "'";

            Alert alert;

            if (studentGrade_EmployeeNum.getText().isEmpty()
                    || studentGrade_email.getText().isEmpty()
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
                alert.setContentText("Are you sure you want to UPDATE Student #" + studentGrade_EmployeeNum.getText() + "?");
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
        studentGrade_EmployeeNum.setText("");
        studentGrade_email.setText("");
        studentGrade_course.setText("");
        studentGrade_firstSem.setText("");
        studentGrade_secondSem.setText("");
    }

    public ObservableList<studentData> studentGradesListData() throws SQLException {

        ObservableList<studentData> listData = FXCollections.observableArrayList();

        String sql = "SELECT a.id,\n" +
                "    u.first_name, \n" +
                "    u.last_name, \n" +
                "    a.timestamp, \n" +
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

    private ObservableList<studentData> studentGradesList;

    public void studentGradesShowListData() throws SQLException {
        studentGradesList = studentGradesListData();
        studentGrade_col_EmployeeNum.setCellValueFactory(new PropertyValueFactory<>("EmployeeNum"));
        studentGrade_col_email.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        studentGrade_col_course.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        studentGrade_col_firstSem.setCellValueFactory(new PropertyValueFactory<>("storeName"));
        studentGrade_col_secondSem.setCellValueFactory(new PropertyValueFactory<>("status"));
//        WE NEED TO FIX THE DELETE ON ADD STUDENT FORM
        studentGrade_tableView.setItems(studentGradesList);
    }

    public void studentGradesSelect() throws SQLException {

        studentData studentD = studentGrade_tableView.getSelectionModel().getSelectedItem();
        int num = studentGrade_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        studentGrade_EmployeeNum.setText(String.valueOf(studentD.getEmployeeNum()));
        studentGrade_email.setText(studentD.getEmail());
        studentGrade_course.setText(studentD.getCourse());
        studentGrade_firstSem.setText(String.valueOf(studentD.getFirstSem()));
        studentGrade_secondSem.setText(String.valueOf(studentD.getSecondSem()));
    }

    public void studentGradesSearch()  {

        FilteredList<studentData> filter = new FilteredList<>(studentGradesList, e -> true);

        studentGrade_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateStudentData -> {

                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();

                if (predicateStudentData.getEmployeeNum().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getEmail().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getCourse().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getFirstSem().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getSecondSem().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getFinals().toString().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<studentData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(studentGrade_tableView.comparatorProperty());
        studentGrade_tableView.setItems(sortList);

    }

    private double x = 0;
    private double y = 0;

    public void logout() throws SQLException {

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
            addStudents_form.setVisible(false);
            availableEmail_form.setVisible(false);
            ShowViewers_form.setVisible(false);
            addStore_form.setVisible(false);
            addInventory_form.setVisible(false);
            availableEmail_form.setVisible(false);
            addStore_form.setVisible(false);
            addItemInventory_form.setVisible(false);
            home_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            addEmployer_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            addStore_btn.setStyle("-fx-background-color:transparent");
            addInventory_btn.setStyle("-fx-background-color:transparent");
            addInventoryItem_btn.setStyle("-fx-background-color:transparent");

            ShowViewers_form.setVisible(false);
            ShowViewers_btn.setStyle("-fx-background-color:transparent");
            homeDisplayTotalEnrolledStudents();
            homeDisplayMaleEnrolled();
            homeDisplayFemaleEnrolled();
         showInf();

        } else if (event.getSource() == addEmployer_btn) {
            addStudents_form.setVisible(true);
            home_form.setVisible(false);
            availableEmail_form.setVisible(false);
            ShowViewers_form.setVisible(false);
            home_form.setVisible(false);
            addInventory_form.setVisible(false);
            availableEmail_form.setVisible(false);
            addStore_form.setVisible(false);
            addItemInventory_form.setVisible(false);

            ShowViewers_form.setVisible(false);

            addEmployer_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            home_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            addStore_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            addStore_btn.setStyle("-fx-background-color:transparent");
            ShowViewers_btn.setStyle("-fx-background-color:transparent");
            addInventory_btn.setStyle("-fx-background-color:transparent");
            addInventoryItem_btn.setStyle("-fx-background-color:transparent");
//            TO BECOME UPDATED ONCE YOU CLICK THE ADD STUDENTS BUTTON ON NAV
            addStudentsShowListData();
           // addStudentsemailList();
            addStudentsGenderList();
      //      addStudentsStatusList();
            addStudentsCourseList();
            addStudentsSearch();
          //  setupStudentSearchFilter();

        } else if (event.getSource() == addEmail_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableEmail_form.setVisible(true);
            ShowViewers_form.setVisible(false);
            home_form.setVisible(false);
            addInventory_form.setVisible(false);
            addStore_form.setVisible(false);
            addItemInventory_form.setVisible(false);
            addStudents_form.setVisible(false);
            ShowViewers_form.setVisible(false);
            ShowViewers_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            addEmployer_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            addStore_btn.setStyle("-fx-background-color:transparent");
            addStore_btn.setStyle("-fx-background-color:transparent");
            addInventory_btn.setStyle("-fx-background-color:transparent");
            addInventoryItem_btn.setStyle("-fx-background-color:transparent");
            availableEmailShowListData();


        } else if (event.getSource() == addInventory_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableEmail_form.setVisible(false);
            addStore_form.setVisible(false);
            ShowViewers_form.setVisible(false);
            home_form.setVisible(false);
            addInventory_form.setVisible(true);
            availableEmail_form.setVisible(false);
            addItemInventory_form.setVisible(false);
            addStudents_form.setVisible(false);

            ShowViewers_form.setVisible(false);
            addInventory_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            ShowViewers_btn.setStyle("-fx-background-color:transparent");
            addEmployer_btn.setStyle("-fx-background-color:transparent");
            addStore_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            addEmployer_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            addStore_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            addStore_btn.setStyle("-fx-background-color:transparent");
            addInventoryItem_btn.setStyle("-fx-background-color:transparent");
            InventoryShowListData();

        } else if (event.getSource() == addInventoryItem_btn) {
            home_form.setVisible(false);
            addInventory_form.setVisible(false);
            availableEmail_form.setVisible(false);
            addStore_form.setVisible(false);
            addStudents_form.setVisible(false);
            addItemInventory_form.setVisible(true);

            ShowViewers_form.setVisible(false);
            addInventoryItem_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");

            ShowViewers_btn.setStyle("-fx-background-color:transparent");
            addEmployer_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            addStore_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            addStore_btn.setStyle("-fx-background-color:transparent");
            addInventory_btn.setStyle("-fx-background-color:transparent");
            InventoryShowListData();
         //   setupSearchFilter();
            addItemInventoryidInvontoryList();
            // Refresh your UI here
            addItemInventoryShowListData();

        } else if (event.getSource() == addStore_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableEmail_form.setVisible(false);
            addStore_form.setVisible(true);
            ShowViewers_form.setVisible(false);
            home_form.setVisible(false);
            addInventory_form.setVisible(false);
            availableEmail_form.setVisible(false);
            addItemInventory_form.setVisible(false);
            addStudents_form.setVisible(false);
            addStore_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            addEmployer_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            addInventory_btn.setStyle("-fx-background-color:transparent");
            addInventoryItem_btn.setStyle("-fx-background-color:transparent");

            ShowViewers_form.setVisible(false);
            ShowViewers_btn.setStyle("-fx-background-color:transparent");

           StoreShowListData();

        } else if (event.getSource() ==ShowViewers_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableEmail_form.setVisible(false);
            addStore_form.setVisible(false);
            ShowViewers_form.setVisible(false);
            home_form.setVisible(false);
            addInventory_form.setVisible(false);
            availableEmail_form.setVisible(false);
            addItemInventory_form.setVisible(false);
            addStudents_form.setVisible(false);
            ShowViewers_form.setVisible(true);
            ShowViewers_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3f82ae, #26bf7d);");
            addStore_btn.setStyle("-fx-background-color:transparent");
            addEmployer_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            addEmail_btn.setStyle("-fx-background-color:transparent");
            addStore_btn.setStyle("-fx-background-color:transparent");
            addInventory_btn.setStyle("-fx-background-color:transparent");
            addInventoryItem_btn.setStyle("-fx-background-color:transparent");
        }
    }

    public void close() throws SQLException {
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
            showInf();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            addStudentsShowListData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     //   addStudentsSearch();

     /*   try {
            homeDisplayTotalEnrolledStudents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            homeDisplayMaleEnrolled();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            homeDisplayFemaleEnrolled();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            homeDisplayEnrolledMaleChart();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            homeDisplayFemaleEnrolledChart();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            homeDisplayTotalEnrolledChart();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/
        // TO SHOW IMMIDIATELY WHEN WE PROCEED TO DASHBOARD APPLICATION FORM
        try {
            addStudentsShowListData();
            showInf();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        try {
            addStudentsGenderList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            addStudentsCourseList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            availableEmailShowListData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            studentGradesShowListData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
