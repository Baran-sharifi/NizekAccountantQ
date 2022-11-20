/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nizekAccountant.logic.Login.Costumer;
import nizekAccountant.logic.ModelManager.Manager;

/**
 *
 * @author Lenovo
 */
public class AddCheckLogic  {
    

    public AddCheckLogic() {
    }





    
   
    
    String[] passCheckToDatabase(String payee, String cost, String discription){
    
    return null;
    }
    
    public boolean canSubmitCheck(String payeeName, String cost, String discription) { //name and password are getting from input field.folan.getText()
    //    boolean areFieldsCorrect = false;

//==========regex check================
        //  boolean emailHasValidate = (Validator.emailIsValid(emailfield));
        boolean nameValid = Validator.nameIsValid(payeeName);
        boolean numberValid = Validator.costIsValid(cost);
        return (numberValid && nameValid);

    }

   
    
    
    
    
}
