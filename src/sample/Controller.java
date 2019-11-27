package sample;

import com.Database.Database;
import com.HeartDPS.Patients;
import com.mongodb.client.MongoCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller extends Database  implements Initializable{
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField fName;
    @FXML
    private TextField mName;
    @FXML
    private TextField lName;
    @FXML
    private DatePicker date;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private TextField contact;
    @FXML
    private TextField address;
    @FXML
    private ComboBox<String> cp;
    @FXML
    private TextField trestbps;
    @FXML
    private TextField chol;
    @FXML
    private ComboBox<String> fbs;
    @FXML
    private ComboBox<String> ecg;
    @FXML
    private TextField thalach;
    @FXML
    private ComboBox<String> exang;
    @FXML
    private TextField oldpeak;
    @FXML
    private ComboBox<String> slop;
    @FXML
    private ComboBox<String> ca;
    @FXML
    private ComboBox<String> thal;
    @FXML
    private ToggleButton submit;
    @FXML
    private ToggleButton back;




    @FXML
    public void Main(ActionEvent event) throws IOException {
        if(username.getText().equals("admin")&&password.getText().equals("admin")){
        Stage s = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Fxml/Main.fxml"));
        Pane p =fxmlLoader.load();
        String n = username.getText();
        System.out.println("User name"+n);
        System.out.println(password.getText());
//        s.initStyle(StageStyle.TRANSPARENT)
        s.setTitle("Main");
        s.setScene(new Scene(p, 1500, 750));
        ((Node)event.getSource()).getScene().getWindow().hide();
        s.show();
        }else {
            System.out.println("Sorry invalid login");
        }
    }

    @FXML
    public void Back(ActionEvent event) throws IOException {
            Stage s = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Fxml/Main.fxml"));
            Pane p =fxmlLoader.load();
            String n = username.getText();
            System.out.println("User name"+n);
            System.out.println(password.getText());
//        s.initStyle(StageStyle.TRANSPARENT)
            s.setTitle("Main");
            s.setScene(new Scene(p, 1500, 750));
            ((Node)event.getSource()).getScene().getWindow().hide();
            s.show();
    }

    @FXML
    public void NewPatients(ActionEvent event) throws IOException {
        Stage s = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Fxml/Patients.fxml"));
        Pane p =fxmlLoader.load();
//        s.initStyle(StageStyle.TRANSPARENT)
        s.setTitle("Patients Details");
        s.setScene(new Scene(p, 1500, 750));
        ((Node)event.getSource()).getScene().getWindow().hide();
        s.show();
    }

    @FXML
    public void ListPatients(ActionEvent event) throws IOException {
        Stage s = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Fxml/ListPatients.fxml"));
        Pane p =fxmlLoader.load();
//        s.initStyle(StageStyle.TRANSPARENT)
        s.setTitle("ListPatients");
        s.setScene(new Scene(p, 1500, 750));
        ((Node)event.getSource()).getScene().getWindow().hide();
        s.show();
    }

    @FXML
    public void Logout(ActionEvent event) throws IOException {
        Stage s = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Fxml/Login.fxml"));
        Pane p =fxmlLoader.load();
//        s.initStyle(StageStyle.TRANSPARENT)
        s.setTitle("Login");
        s.setScene(new Scene(p, 1500, 750));
        ((Node)event.getSource()).getScene().getWindow().hide();
        s.show();
    }

    @FXML
    public void input()throws IOException{
        Database ins = new Database();
        Patients p1 = new Patients();
        p1.setfName(fName.getText());
        p1.setmName(mName.getText());
        p1.setlName(lName.getText());
        p1.setDateOfBirth(date.getValue().toString());
        p1.setAge(LocalDateTime.now().getYear()-date.getValue().getYear());
        if(male.isSelected()){
            p1.setGender("Male");
        }else if(female.isSelected()){
            p1.setGender("Female");
        }
        p1.setContact(contact.getText());
        p1.setAddress(address.getText());

        if(cp.getSelectionModel().getSelectedItem().equals("0")){
            p1.setCp(0);
        }else if(cp.getSelectionModel().getSelectedItem().equals("1")){
            p1.setCp(1);
        }else if(cp.getSelectionModel().getSelectedItem().equals("2")){
            p1.setCp(2);
        }else if(cp.getValue().equals("3")){
            p1.setCp(3);
        }
        p1.setTrestbps(Integer.parseInt(trestbps.getText()));
        p1.setChol(Integer.parseInt(chol.getText()));
        if(fbs.getValue().equals("0")){
            p1.setFbs(0);
        }else if(fbs.getValue().equals("1")){
            p1.setFbs(1);
        }
        if(ecg.getValue().equals("0")){
            p1.setRestecg(0);
        }else if(ecg.getValue().equals("1")){
            p1.setRestecg(1);
        }
        p1.setThalach(Integer.parseInt(thalach.getText()));
        if(exang.getValue().equals("0")){
            p1.setExang(0);
        }else if(exang.getValue().equals("1")){
            p1.setExang(1);
        }
        p1.setOldpeak(Double.parseDouble(oldpeak.getText()));
        if(slop.getValue().equals("0")){
            p1.setSlop(0);
        }else if(slop.getValue().equals("1")){
            p1.setSlop(1);
        }else if(slop.getValue().equals("2")){
            p1.setSlop(2);
        }
        if(ca.getValue().equals("0")){
            p1.setCa(0);
        }else if(ca.getValue().equals("1")){
            p1.setCa(1);
        }else if(ca.getValue().equals("2")){
            p1.setCa(2);
        }else if(ca.getValue().equals("3")){
            p1.setCa(3);
        }
        if(thal.getValue().equals("0")){
            p1.setThal(0);
        }else if(thal.getValue().equals("1")){
            p1.setThal(1);
        }else if(thal.getValue().equals("2")){
            p1.setThal(2);
        }else if(thal.getValue().equals("3")){
            p1.setThal(3);
        }

        ins.insert(p1.getfName(),p1.getmName(),p1.getlName(),p1.getDateOfBirth(),p1.getAge(),p1.getGender(),p1.getContact(),p1.getAddress(),p1.getCp(),
                p1.getTrestbps(),p1.getChol(),p1.getFbs(),p1.getRestecg(),p1.getThalach(),p1.getExang(),p1.getOldpeak(),p1.getSlop(),p1.getCa(),p1.getThal());


        System.out.println("FName: "+p1.getfName()+"\nMName: "+p1.getmName()+"\nLName: "+p1.getlName()+"\nDate: "+p1.getDateOfBirth()+"\nGender: "+p1.getGender()
                +"\nContact: "+p1.getContact()+"\nAddress: "+p1.getAddress()+"\nCp: "+p1.getCp()+"\nTrestbps: "+p1.getTrestbps()+"\nchol: "+p1.getChol()+"\nfbs: "+p1.getFbs()+
                "\nEcg: "+p1.getRestecg()+"\nThalach: "+p1.getThalach()+"\nExang: "+p1.getExang()+"\nOldPeak: "+p1.getOldpeak()+"\nSlop: "+p1.getSlop()+"\nCA: "+p1.getCa()+"\nThal: "+p1.getThal()+
                "\nage: "+p1.getAge());

    }

//    @FXML
//    public void Insert() throws IOException {
//        input();
//    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void pridict(ActionEvent event) throws Exception {
//        MongoCollection a = database.getCollection("Patients");
//        Patients personselected = table.getSelectionModel().getSelectedItem();
//        int cp = personselected.getCp();
//        int thal = personselected.getThal();
//        int thalach = personselected.getThalach();
//        int ex = personselected.getExang();
//        double peak = personselected.getOldpeak();
//        int age = personselected.getAge();
//        try {
//            FileWriter fw = new FileWriter("E:\\HDPSGUI\\src\\com\\classifier\\heart2.arff");
//            fw.write("@relation 'heart-weka.filters.supervised.attribute.AttributeSelection-Eweka.attributeSelection.CfsSubsetEval -P 1 -E 1-Sweka.attributeSelection.GreedyStepwise -B -T -1.7976931348623157E308 -N -1 -num-slots 1-weka.filters.unsupervised.instance.NonSparseToSparse'\n" +
//                    "\n" +
//                    "@attribute sex numeric\n" +
//                    "@attribute cp numeric\n" +
//                    "@attribute restecg numeric\n" +
//                    "@attribute thalach numeric\n" +
//                    "@attribute exang numeric\n" +
//                    "@attribute oldpeak numeric\n" +
//                    "@attribute slope numeric\n" +
//                    "@attribute ca numeric\n" +
//                    "@attribute thal numeric\n" +
//                    "@attribute target numeric\n" +
//                    "\n" +
//                    "@data\n");
//            fw.write(age+","+cp + "," + thal + "," + thalach + "," + ex + "," + (int) peak);
//            fw.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

}
