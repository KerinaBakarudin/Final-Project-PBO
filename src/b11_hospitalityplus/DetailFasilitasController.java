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

public class DetailFasilitasController {

    @FXML
    private Button btnpesanresto;

    @FXML
    void gotopesanan(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pesanan.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) btnpesanresto.getScene().getWindow();
        stage.setScene(new Scene(root));     
    }

}

