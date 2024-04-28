package b11_hospitalityplus;

import db.DBHelper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button btnlogin;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void gotopage(ActionEvent event) throws IOException {
        if (authenticateUser(username.getText(), password.getText())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnlogin.getScene().getWindow();
            stage.setScene(new Scene(root));
        } else {
            showAlert("Username atau Password Salah!");
        }
    }

    private boolean authenticateUser(String enteredUsername, String enteredPassword) {
        // Connect to the database
        try (Connection conn = DBHelper.getConnection()) {
            // Prepare the SQL query
            String query = "SELECT * FROM pelanggan WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, enteredUsername);
                preparedStatement.setString(2, enteredPassword);

                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Check if the result set has any rows
                    return resultSet.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
