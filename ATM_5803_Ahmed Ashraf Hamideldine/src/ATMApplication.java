import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ATMApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ATM Application");


//----------------{{ Assigning the primary stage to all of the classes }}-----------------------------------------------
        LoginForm loginForm = new LoginForm(primaryStage);
        HomePage homePage=new HomePage(primaryStage);
        WithdrawalPage withdrawalPage=new WithdrawalPage(primaryStage);
        DepositPage depositPage=new DepositPage(primaryStage);


//------------------{{ Telling the different  classes to prepare their buttons and scenes to be ready when called}}-----
        loginForm.prepareScene();
        homePage.prepareScene();
        withdrawalPage.prepareScene();
        depositPage.prepareScene();

//----------------{{ Linking the Realted classes to each other}}--------------------------------------------------------
        loginForm.setHomePage(homePage);
        homePage.setLoginForm(loginForm);

        homePage.setWithdrawalPage(withdrawalPage);
        homePage.setDepositPage(depositPage);

        withdrawalPage.setHomePage(homePage);
        depositPage.setHomePage(homePage);


//----------------{{ Assigning the Loginform as the starting   Scene of the app}}---------------------------------------
        primaryStage.setScene(loginForm.getScene());
        primaryStage.show();
    }
}
