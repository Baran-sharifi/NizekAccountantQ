/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;


 
public class LoginLogic {

    //  String emailFieldInputValue;
    //  String passwordFieldInputValue;
    String passwordDatabase = "baran";
  
    String emailDatabase = "test@gmail.com";

    //*emailfieldLogin and passwordField are txtfield vars dont get confused :)
    public LoginLogic() {

    }

    public boolean canEnter(String emailfield, String password) { //name and password are getting from input field.folan.getText()
        boolean areFieldsCorrect=false;

//==========regex check================
      //  boolean emailHasValidate = (Validator.emailIsValid(emailfield));
        System.out.println("email has validated"+Validator.emailIsValid(emailfield));
//=========database Check===============
        //fields match data base 
        if ((emailfield.equals(emailDatabase)) && (password.equals(passwordDatabase))) {
            areFieldsCorrect = true;
            System.out.println( "fields are correct"+areFieldsCorrect);
        }
        System.out.println(Validator.emailIsValid(emailfield) && areFieldsCorrect);
         return (Validator.emailIsValid(emailfield) && areFieldsCorrect);
    }
}