import java.util.HashMap;

public class LoginValidation {
    HashMap users;
    public LoginValidation(){
        users=new HashMap();
        users.put("1","1");

    }

//--------------{{ Using A HAshmap to check for the username and password}}---------------------------------------------

    public boolean validate( String  username, String password ){
        boolean validation= false;
        String fetchedPassword=(String) users.get(username);
        if (fetchedPassword!=null){
            validation = fetchedPassword.equals(password);
        }
        return  validation;
    }
}
