package b11_hospitalityplus;

import db.DBHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLogController {

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Button btnlogg;

    @FXML
    void gotomain(ActionEvent event) throws IOException {
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();

        if (validateLogin(enteredUsername, enteredPassword)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Admmain.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // Close the current login stage
            ((Stage) btnlogg.getScene().getWindow()).close();
        } else {
            // Display an error message or handle unsuccessful login
            System.out.println("Invalid login credentials");
        }
    }

    // Validate login credentials against the database
    private boolean validateLogin(String username, String password) {
        Connection conn = DBHelper.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM pegawai WHERE username = ? AND password = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            return resultSet.next(); // If there is a match, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
