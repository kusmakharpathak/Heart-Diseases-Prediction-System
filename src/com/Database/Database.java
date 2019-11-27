package com.Database;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import org.bson.Document;
import sample.ModelTable;
import sample.TableViewController;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Database extends TableViewController{
    private String host = "Localhost";
    private int port = 27017;
    private String DB = "HDPS";
    private String Collection = "Patients";


    private final MongoClient connection = new MongoClient(host, port);
    private final MongoDatabase database = connection.getDatabase(DB);
    public final MongoCollection collection = database.getCollection(Collection);


    public void insert(String fName, String mName, String lName, String date, int age, String gender, String contact, String address,
                       int cp, int tresebps, int chol, int fbs, int ecg, int thalach, int exang, Double oldpeak, int slop, int ca, int thal) throws IOException {
        Document Insert = new Document();
        Random rand = new Random();
        String id = "SIBS" +(rand.nextInt(999999) + 123456);
        Insert.append("_id", id);
        Insert.append("first_Name", fName);
        Insert.append("middle_Name", mName);
        Insert.append("last_Name", lName);
        Insert.append("date_of_Birth",date);
        Insert.append("gender", gender);
        Insert.append("age", age);
        Insert.append("contact",contact);
        Insert.append("address",address);
        Insert.append("cp", cp);
        Insert.append("trestbps",tresebps);
        Insert.append("chol", chol);
        Insert.append("fbs", fbs);
        Insert.append("restecg",ecg);
        Insert.append("thalach",thalach);
        Insert.append("exang", exang);
        Insert.append("oldpeak", oldpeak);
        Insert.append("slop", slop);
        Insert.append("ca", ca);
        Insert.append("thal", thal);

        try {
            collection.insertOne(Insert);
            System.out.println("Successfully inserted documents. \n");
        } catch (MongoWriteException mwe) {
            if (mwe.getError().getCategory().equals(ErrorCategory.DUPLICATE_KEY)) {
                System.out.println("Document with that id already exists");
            }
        }

    }

    public void update() {
//        ModelTable select = table.getSelectionModel().getSelectedItem();
////        col_name.setText(select.getName());
//        col_age.setText(String.valueOf(select.getAge()));
//        col_gender.setText(select.getGender());
//        col_address.setText(select.getAddress());
////        col_bp.setText(select.getAddress());
//        col_cp.setText(select.getAddress());
////        col_exc.setText(select.getAddress());
//        col_thalach.setText(select.getAddress());
//        col_oldpeak.setText(select.getAddress());
//        col_ca.setText(select.getAddress());
//        col_thal.setText(select.getAddress());

    }

    public void delete(ModelTable personselected) {
        MongoCollection a = database.getCollection("Patients");
        String Id = personselected.getId();
        System.out.println(Id);
        Document found = (Document) a.find(new Document("_id", Id)).first();
        if (found != null) {
            System.out.println("Found User");
            System.out.println(found.toJson());
            a.deleteMany(found);
            table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        } else {
            System.out.println("Document not found");
        }

    }

   public void display(URL a, ResourceBundle b){
       List<Document> documents = (List<Document>) collection.find().into(new ArrayList<Document>());
       for (Document show : documents) {
           oblist.add(new ModelTable(
                   show.getString("_id"), show.getString("first_Name"),
                   show.getString("middle_Name"),show.getString("last_Name"),
                   show.getString("date_of_Birth"), show.getInteger("age"),
                   show.getString("gender"), show.getString("contact"),
                   show.getString("address"),show.getInteger("cp"),
                   show.getInteger("trestbps"),show.getInteger("chol"),
                   show.getInteger("fbs"), show.getInteger("restecg"),
                   show.getInteger("thalach"), show.getInteger("exang"),
                   show.getDouble("oldpeak"),show.getInteger("slop"),
                   show.getInteger("ca"), show.getInteger("thal")));
       }
       col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
       col_fname.setCellValueFactory(new PropertyValueFactory<>("fName"));
       col_mname.setCellValueFactory(new PropertyValueFactory<>("mName"));
       col_lname.setCellValueFactory(new PropertyValueFactory<>("lName"));
       col_date.setCellValueFactory(new PropertyValueFactory<>("DateOfBirth"));
       col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
       col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
       col_contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
       col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
       col_cp.setCellValueFactory(new PropertyValueFactory<>("cp"));
       col_trestbps.setCellValueFactory(new PropertyValueFactory<>("trestbps"));
       col_chol.setCellValueFactory(new PropertyValueFactory<>("chol"));
       col_fbs.setCellValueFactory(new PropertyValueFactory<>("fbs"));
       col_restecg.setCellValueFactory(new PropertyValueFactory<>("restecg"));
       col_thalach.setCellValueFactory(new PropertyValueFactory<>("thalach"));
       col_exang.setCellValueFactory(new PropertyValueFactory<>("exang"));
       col_oldpeak.setCellValueFactory(new PropertyValueFactory<>("oldpeak"));
       col_slop.setCellValueFactory(new PropertyValueFactory<>("slop"));
       col_ca.setCellValueFactory(new PropertyValueFactory<>("ca"));
       col_thal.setCellValueFactory(new PropertyValueFactory<>("thal"));
       table.setItems(oblist);
   }

}
