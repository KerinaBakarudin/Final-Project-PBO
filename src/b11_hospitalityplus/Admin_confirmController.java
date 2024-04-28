/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package b11_hospitalityplus;

import db.DBHelper;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class Admin_confirmController implements Initializable {

    @FXML
    private Button btnkonfirmasi;

    @FXML
    private TableColumn<Pemesanan, Date> colCheckin;

    @FXML
    private TableColumn<Pemesanan, Date> colCheckout;

    @FXML
    private TableColumn<Pemesanan, String> colEmail;

    @FXML
    private TableColumn<Pemesanan, String> colNama;
    
    @FXML
    private TableColumn<Pemesanan, Integer> colidpesan;

    @FXML
    private TableColumn<Pemesanan, Integer> colTamu;

    @FXML
    private TableColumn<Pemesanan, String> colTelepon;
    
    @FXML
    private TableColumn<Pemesanan, String> colBooking_id;

    @FXML
    private TableView<Pemesanan> tblPemesanan;
    
    
    @Override
    public void initialize (URL url, ResourceBundle rb){
        showPemesanan();
    }
    
    public ObservableList<Pemesanan> getDataPemesanan(){
        ObservableList<Pemesanan> pesan = FXCollections.observableArrayList();
        Connection conn = DBHelper.getConnection();
        String query = "SELECT * FROM `pemesanan`";
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Pemesanan temp;
            while(rs.next()){
                temp = new Pemesanan(
                       // rs.getInt("id_pemesanan"),
                        rs.getString("nama"),
                        rs.getString("no_telepon"),
                        rs.getString("email"),
                        rs.getInt("jumlah_tamu"),
                        rs.getDate("check_in"), 
                        rs.getDate("check_out")
                );
                pesan.add(temp);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return pesan;
    }
    
    public void showPemesanan(){
        ObservableList<Pemesanan> list = getDataPemesanan();
        colidpesan.setCellValueFactory(new PropertyValueFactory<>("id_pemesanan"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colTelepon.setCellValueFactory(new PropertyValueFactory<>("no_telepon"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTamu.setCellValueFactory(new PropertyValueFactory<>("jumlah_tamu"));
        colCheckin.setCellValueFactory(new PropertyValueFactory<>("check_in"));
        colCheckout.setCellValueFactory(new PropertyValueFactory<>("check_out"));
        colBooking_id.setCellValueFactory(new PropertyValueFactory<>("booking_id"));
        tblPemesanan.setItems(list);
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
    
    private Date convertToDate(LocalDate localDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = localDate.toString();

        try {
            return (Date) sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    


    
}
