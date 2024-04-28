/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package b11_hospitalityplus;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdmmainController {

    @FXML
    private Button btndetailad;

    @FXML
    private Button btnfacilitiesad;

    @FXML
    private Button btninvoicead;

    @FXML
    private Button btnroomad;


    @FXML
    void gotodetail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_detail.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btndetailad.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

    @FXML
    void gotofacilities(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("input_fasilitas.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnfacilitiesad.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

    @FXML
    void gotoinvoice(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_confirm.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btninvoicead.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

    @FXML
    void gotomain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("input_jeniskamar.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnroomad.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

}

