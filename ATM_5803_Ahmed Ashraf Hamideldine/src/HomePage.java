import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class HomePage {

    Stage stage;
    Scene scene;
    LoginForm loginForm;
    WithdrawalPage withdrawalPage;
    DepositPage depositPage;


    public  String[] history = new String[5];
    int j =-1;
    double myBalance = 0;

    //int historyTest=0;


    public HomePage(Stage stage){
        this.stage= stage;
    }


    public void prepareScene(){

        // Button Initiation start----------------------------------------------------
        Label welcome =new Label("Welcome to your Bank Account");
        Button logout = new Button("Logout");

        Button currentBalance = new Button("Current Balance");
        Label currBalance= new Label();

        Label transMessage= new Label();
        Button withdraw = new Button("Withdraw");
        Button deposit = new Button("Deposit");

        Label transHistory= new Label();
        Button previous = new Button("Previous");
        Button next = new Button("Next");
        // Button Initiation end----------------------------------------------------



        //Drawing Start--------------------------------------------------------------
        GridPane grid =new GridPane();
        grid.add(currentBalance,0,1);
        grid.add(currBalance,1,1);
        grid.add(transMessage,1,3);
        grid.add(withdraw,0,4);
        grid.add(deposit,1,4);
        grid.add(transHistory,0,6);
        grid.add(previous,0,7);
        grid.add(next,1,7);
        grid.add(logout,0,9);

        scene = new Scene(grid,400,200);
        //Drawing end--------------------------------------------------------------



       //---------------------------{{Button logic Start}}--------------------------------------------------------------
       //---------------------------------------------------------------------------------------------------------------

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(loginForm.getScene());
            }
        });


        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(withdrawalPage.getScene());

            }
        });


        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(depositPage.getScene());


            }
        });


//         historyTest=history.size();


        currentBalance.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String  stringBalance = String.valueOf(myBalance);
                currBalance.setText(""+stringBalance);
            }
        });


        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(j<1){
                    transHistory.setText("NO PREVIOUS TRANSACTIONS IN THE HISTORY ");
                }
                else transHistory.setText(String.valueOf(history[--j]));
                }


                /* if(historyTest>0){
                    historyTest=historyTest-1;}
                                               */

        });


        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

               if(j>4){
                   transHistory.setText("NO NEXT TRANSACTIONS IN THE HISTORY ");
               }
               else {transHistory.setText(String.valueOf(history[++j]));
               }

               /*  if(historyTest<history.size()){
                historyTest=historyTest+1;}
                */
            }
        });

        //--------------------------------------------------------------------------------------------------------------
        //------------------------------{{{-Button logic End-}}---------------------------------------------------------


    }



    public Scene getScene() {
        return scene;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    public void setWithdrawalPage(WithdrawalPage withdrawalPage) {
        this.withdrawalPage = withdrawalPage;
    }


    public void setDepositPage(DepositPage depositPage) {
        this.depositPage=depositPage;
    }
}

