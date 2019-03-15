import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class WithdrawalPage {
    Stage stage;
    Scene scene;
    HomePage homePage;
   // CheckInt check;


    public WithdrawalPage(Stage stage){
        this.stage= stage;

    }

    public  void  prepareScene(){
        
       // check= new CheckInt();

        Label enterTheAmount =new Label("Please enter the amount");
        Button submit = new Button("submit");
        Button back = new Button("back");
        Label transMessage= new Label();
        TextField transMoney= new TextField();

        GridPane grid = new GridPane();
        grid.add(enterTheAmount, 0, 0);
        grid.add(transMoney,0,1);
        grid.add(submit,0,2);
        grid.add(transMessage,0,5);
        grid.add(back,1,2);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double withdrawn=Double.valueOf(transMoney.getText());
                if(homePage.myBalance>=withdrawn){
                    homePage.myBalance = homePage.myBalance-withdrawn;
                    transMessage.setText("Successfull withdrawal of { "+withdrawn+" }  dollars");

                    for (int i=4;i>0;i--){
                        homePage.history[i]=homePage.history[i-1];
                    }
                    homePage.history[0]=("Withdraw "+withdrawn);


///-------------{{  Down here is another way to store and call the Transaction history using Arraylist}}----------------

                  /*  if(homePage.history.size()<5){
                        homePage.history.add("withdraw  "+withdrawn);
                    }else{
                        homePage.history.remove(0);
                        homePage.history.trimToSize();
                        homePage.history.add("withdraw  "+withdrawn);
                    }
*/
                }
                else {
                    transMessage.setText("Error:Your current balance is less than   { "+withdrawn+" }  dollars");
                }
            }
        });



        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(homePage.getScene());
            }
        });



//--------{{{{  Down here a code to check that the user entered an integer (unfortunately, i didn't get it work )-----//
/////////----------------------------------------------------------------------------------------------------///////////

       /* submit.setOnAction(new EventHandler<ActionEvent>() {
            String withdrawnAmount = amount.getText();
            @Override
            public void handle(ActionEvent event) {
                String withdrawnAmount = amount.getText();
                boolean valid = check.checkInt(withdrawnAmount);
                if (valid) {
                    int withdrawn= Integer.parseInt(amount.getText());
                    stage.setScene(homePage.getScene());
           currentBalance= currenrBalance - withdrawn;
                    stage.setScene(homePage.getScene());
                } else {
                   message.setText(" The value entered is not an integer");
                }
                checkInt (amount, amount.getText());
  }
        });  */



        scene = new Scene(grid, 500, 150);
  
                
        }


    public Scene getScene() {
        return scene;
    }


    ///----{{ down here another way to get user entry using buttons instead of textfields to avoid wrong data type }}-------
/////////----------------------------------------------------------------------------------------------------///////////

    /*  Button one = new Button("1");
        Button  two= new Button("2");
        Button three = new Button("3");
        Button  four= new Button("4");
        Button  five = new Button("5");
        Button  six = new Button("6");
        Button  seven = new Button("7");
        Button  eight = new Button("8");
        Button  nine = new Button("9");
        Button  ten = new Button("0");  */



    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }
}
