/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

import javax.swing.*;

/**
 *
 * @author Lenovo
 */
public class AddDocLogic {

    public AddDocLogic() {
    }

    public void passDocToDatabase(String payee, String cost, String discripton) {
        //gets this from logic
     
    }

    void groupedSubmit(JButton btn) {
        JPanel addingDocPanel = new JPanel();

    }

    public boolean canSubmitDoc(String payeeName, String cost, String discription) { //name and password are getting from input field.folan.getText()
//        boolean areFieldsCorrect = false;

//==========regex check================
        //  boolean emailHasValidate = (Validator.emailIsValid(emailfield));
        boolean nameValid = Validator.nameIsValid(payeeName);
        boolean numberValid = Validator.costIsValid(cost);
        return (numberValid && nameValid);

    }

}
