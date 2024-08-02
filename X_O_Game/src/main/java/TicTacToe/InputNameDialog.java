package TicTacToe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InputNameDialog implements Initializable {

    @FXML Label label;
    @FXML Button ok,clean;
    @FXML TextField text;
    private boolean fistp = true;

    @FXML
    public void PressedOk(Event event) {
        Players usr = new Players();

        if (fistp) {
            usr.setFplayer(text.getText());
            fistp = false;
            text.setText("");
            label.setText("Enter the 2nd player's Name:");
        } else {
            try {
                usr.setSplayer(text.getText());
                openNewScene();
                ok.getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(InputNameDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    public void PressedClear() {    //Clear the text field
        text.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setText("Enter the Name of the 1st player:");
    }

    private void openNewScene() throws IOException { //Calls the Trilliza scene
        Stage pstage = new Stage();
        BorderPane root = FXMLLoader.load(getClass().getResource("Trilliza.fxml"));
        pstage.setTitle("Tic-tac-toe");
        Scene scene = new Scene(root,300,385);
        pstage.setScene(scene);
        pstage.setResizable(false);
        pstage.show();
    }

}