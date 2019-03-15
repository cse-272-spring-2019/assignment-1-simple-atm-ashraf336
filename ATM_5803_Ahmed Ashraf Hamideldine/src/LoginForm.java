import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginForm {

    LoginValidation authentication;
    Scene scene;
    HomePage homePage;
    Stage stage;
    WithdrawalPage withdrawalPage;


    public LoginForm(Stage stage){
        this.stage =stage;
    }

    public void prepareScene() {

        authentication = new LoginValidation();

    //------------------------{{ Drawing and locating the Buttons}}-------START----------------------------------------------
        Label usernameLabel = new Label("Card Number");
        Label passwordLabel = new Label("PIN");
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button submit = new Button("Login");
        Label validationLabel = new Label();

        GridPane grid = new GridPane();
        grid.add(usernameLabel, 1, 0);
        grid.add(passwordLabel, 1, 3);
        grid.add(usernameField, 1, 1);
        grid.add(passwordField, 1, 4);
        grid.add(submit, 1, 6);
        grid.add(validationLabel, 1, 7);
//------------------------{{ Drawing and locating the Buttons}}--------END---------------------------------------------



//------------------------{{ Assigning actions to buttons}}-------------START----------------------------------------
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                boolean valid = authentication.validate(username, password);
                if (valid) {
                   // validationLabel.setText(" Welcome MR." + username);
                    //validationLabel.setFont(new Font("Verdana", 20));
                    stage.setScene(homePage.getScene());
                } else {
                    validationLabel.setText(" Wrong username or Password");
                    validationLabel.setFont(new Font("Verdana", 16));
                }
            }
        });
//------------------------{{ Assigning actions to Buttons}}-------------END----------------------------------------


        scene = new Scene(grid, 300, 200);

    }

    public Scene getScene() {
        return this.scene;
    }


    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    /*public void setWithdrawalPage(WithdrawalPage withdrawalPage) {
        this.withdrawalPage =  withdrawalPage;
    }*/
}