package sample;

import com.Database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import weka.knowledgeflow.Data;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableViewController implements Initializable  {
    @FXML
    public TableView<ModelTable> table;
    @FXML
    public TableColumn<ModelTable, String> col_id;
    @FXML
    public TableColumn<ModelTable, String> col_fname;
    @FXML
    public TableColumn<ModelTable, String> col_mname;
    @FXML
    public TableColumn<ModelTable, String> col_lname;
    @FXML
    public TableColumn<ModelTable, String> col_date;
    @FXML
    public TableColumn<ModelTable, String> col_gender;
    @FXML
    public TableColumn<ModelTable, Integer> col_age;
    @FXML
    public TableColumn<ModelTable, String> col_contact;
    @FXML
    public TableColumn<ModelTable, String> col_address;
    @FXML
    public TableColumn<ModelTable, Integer> col_cp;
    @FXML
    public TableColumn<ModelTable, Integer> col_trestbps;
    @FXML
    public TableColumn<ModelTable, Integer> col_chol;
    @FXML
    public TableColumn<ModelTable, Integer> col_fbs;
    @FXML
    public TableColumn<ModelTable, Integer> col_restecg;
    @FXML
    public TableColumn<ModelTable, Integer> col_thalach;
    @FXML
    public TableColumn<ModelTable, Integer> col_exang;
    @FXML
    public TableColumn<ModelTable, Double> col_oldpeak;
    @FXML
    public TableColumn<ModelTable, Integer> col_slop;
    @FXML
    public TableColumn<ModelTable, Integer> col_ca;
    @FXML
    public TableColumn<ModelTable, Integer> col_thal;

    @FXML
    public ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    @FXML
    public Button edit;


    @FXML
    public void Logout(ActionEvent event) throws IOException {
        Stage s = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Fxml/Login.fxml"));
        Pane p = fxmlLoader.load();
//        s.initStyle(StageStyle.TRANSPARENT)
        s.setTitle("Login");
        s.setScene(new Scene(p, 1500, 750));
        ((Node) event.getSource()).getScene().getWindow().hide();
        s.show();
    }

    @FXML
    public void edit1() {
        Database update = new Database();
        update.update();
    }

    @FXML
    public void deleteRowFromTable() {
        ModelTable personselected = table.getSelectionModel().getSelectedItem();
        Database d = new Database();
        d.delete(personselected);

    }




    @FXML
    public void pridict(ActionEvent event) throws Exception {
        Controller pridict = new Controller();
        pridict.pridict(event);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database d = new Database();


    } xFTGYUIOP
}