/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

/**
 *
 * @author Lenovo
 */
public class AddCategoryLogic {
     boolean doesExist;
    String[] types = {"کارمند", "مشتری", "شریک"};

    public AddCategoryLogic() {
    }
    //adds String of label.getText(); to TYPES, 
   
//===================================================================
    boolean isRegisterable(String cat) { //if its registerable then add string to data base and get back to main menu

        boolean fieldIsFilledCorrect = Validator.CategoryIsValid(cat);

        for (String type : types) {
            if (type.equals(cat)) {
                doesExist = true;
            }
        }
        return (fieldIsFilledCorrect && !doesExist);
    }
 // ====================================================================
    boolean PossibleToAdd(String name,String id, String phone,String address,String  email){
    return(Validator.phoneIsValid(phone)&&Validator.emailIsValid(email)&&Validator.costIsValid(id)&&Validator.nameIsValid(name));
    
    }
    
    //============================================================================

}
