public class CheckInt {


////////////////////////  A METHOD  TO CHECK THAT THE ENTERED VALUE IS AN INTEGER \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    public boolean checkInt(String input) {
        try {
           /* int money = Integer.parseInt(amount.getText())
            message.setText(+ money+" is withdrawn from the current balance ");
           */
            return true;
        } catch (NumberFormatException e) {
            /* message.setText(+ entered +" is not an integer");
             */
            return false;
        }

    }
}


