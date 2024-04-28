/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package b11_hospitalityplus;

import db.DBHelper;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Input_fasilitasController implements Initializable{

    @FXML
    private Button btnDeletefasilitas;

    @FXML
    private Button btnInsertfasilitas;

    @FXML
    private Button btnUpdatefasilitas;

    @FXML
    private TableColumn<FasilitasInput, String> colDesk;

    @FXML
    private TableColumn<FasilitasInput, Integer> colHargafasilitas;

    @FXML
    private TableColumn<FasilitasInput, Integer> colid_fasilitas;

    @FXML
    private TableColumn<FasilitasInput, String> colnama_fasilitas;

    @FXML
    private TextField fieldDeskripsif;

    @FXML
    private TextField fieldHargaFasilitas;

    @FXML
    private TextField fieldIDfasilitas;

    @FXML
    private TextField fieldNamaFasilitas;

    @FXML
    private TableView<FasilitasInput> tblFasilitas;

    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnInsertfasilitas){
            insertRecord();
        }
        else if(event.getSource() == btnUpdatefasilitas){
            updateRecord();
        }else if(event.getSource() == btnDeletefasilitas){
            deleteRecord();
        }
    }
    
    @Override
    public void initialize (URL url, ResourceBundle rb){
        showFasilitas();
    }
    
    public ObservableList<FasilitasInput> getDataFasilitas(){
        ObservableList<FasilitasInput> fasilitas = FXCollections.observableArrayList();
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM `fasilitas_hotel`";
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            FasilitasInput temp;
            while(rs.next()){
                temp = new FasilitasInput(rs.getInt("id_fasilitas"), rs.getString("nama_fasilitas"), 
                        rs.getInt("harga"), rs.getString("deskripsi"));
                fasilitas.add(temp);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return fasilitas;
    }
    
    public void showFasilitas(){
        ObservableList<FasilitasInput> list = getDataFasilitas();
        
        colid_fasilitas.setCellValueFactory(new PropertyValueFactory<>("id_fasilitas"));
        colnama_fasilitas.setCellValueFactory(new PropertyValueFactory<>("nama_fasilitas"));
        colHargafasilitas.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colDesk.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        tblFasilitas.setItems(list);
    }
    
    private void update(String query){
        Connection conn = DBHelper.getConnection();
        Statement st;
        
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private void insertRecord() {
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO `fasilitas_hotel`(`id_fasilitas`, `nama_fasilitas`, `harga`, `deskripsi`) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setInt(1, Integer.parseInt (fieldIDfasilitas.getText()));
            preparedStatement.setString(2, fieldNamaFasilitas.getText());
            preparedStatement.setInt(3, Integer.parseInt (fieldHargaFasilitas.getText()));
            preparedStatement.setString(4, fieldDeskripsif.getText());


            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Data inserted successfully!");
                showFasilitas();
                fieldIDfasilitas.clear();
                fieldNamaFasilitas.clear();
                fieldHargaFasilitas.clear();
                fieldDeskripsif.clear();

            } else {
                System.out.println("Failed to insert data.");
            }

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }


    }
    
    private void updateRecord() {
    try (Connection connection = DBHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "UPDATE `fasilitas_hotel` SET `nama_fasilitas`=?, `harga`=?, `deskripsi`=? WHERE `id_fasilitas`=?")) {

        preparedStatement.setString(1, fieldNamaFasilitas.getText());
        preparedStatement.setInt(2, Integer.parseInt(fieldHargaFasilitas.getText()));
        preparedStatement.setString(3, fieldDeskripsif.getText());
        preparedStatement.setInt(4, Integer.parseInt(fieldIDfasilitas.getText()));

        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Data updated successfully!");
            showFasilitas();
                fieldIDfasilitas.clear();
                fieldNamaFasilitas.clear();
                fieldHargaFasilitas.clear();
                fieldDeskripsif.clear();
        } else {
            System.out.println("Failed to update data.");
        }

    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
    }
}
    
    private void deleteRecord() {
    try (Connection connection = DBHelper.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "DELETE FROM `fasilitas_hotel` WHERE `id_fasilitas`=?")) {

        preparedStatement.setInt(1, Integer.parseInt(fieldIDfasilitas.getText()));

        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Data deleted successfully!");
            showFasilitas();
                fieldIDfasilitas.clear();
                fieldNamaFasilitas.clear();
                fieldHargaFasilitas.clear();
                fieldDeskripsif.clear();
        } else {
            System.out.println("Failed to delete data.");
        }

    } catch (SQLException | NumberFormatException e) {
        e.printStackTrace();
    }
}

    
}
