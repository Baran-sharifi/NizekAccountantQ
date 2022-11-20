package nizekAccountant;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class AddUserLogic {

    public AddUserLogic() {
        
        
        
    }
    
    
    
    
boolean existInDataBase(String nationalId){

//check already exists in data base

return false;
}    
    
    
 
//=========pass user to data base===================================    
   //public User passUserTodataBase(String id ,String name,String phone,String address,String type){
   //User user= new(id,name,phone,address,type);
   //here initialize a new User with the given params and passes it to writefile;
   
   
  // }
 // return null;
//   }
 //================================================================   
    
//    public boolean canEnterUser(String emailfield, String password) { //name and password are getting from input field.folan.getText()
//        boolean areFieldsCorrect=false;
//
//
//      
//        System.out.println("email has validated"+Validator.emailIsValid(emailfield));
//        //fields match data base 
//        if ((emailfield.equals()) && (password.equals(passwordDatabase))) {
//            areFieldsCorrect = true;
//            System.out.println( "fields are correct"+areFieldsCorrect);
//        }
//        System.out.println(Validator.emailIsValid(emailfield) && areFieldsCorrect);
//         return (Validator.emailIsValid(emailfield) && areFieldsCorrect);
    
public boolean canSubmitPeople(String payeeName, String phone, String nationallId,String address,String email) { //name and password are getting from input field.folan.getText()
//
//==========regex check================
        //  boolean emailHasValidate = (Validator.emailIsValid(emailfield));
        boolean emailValid=Validator.emailIsValid(email);
        boolean nameValid = Validator.nameIsValid(payeeName);
        boolean phoneValid = Validator.phoneIsValid(phone);
        boolean addressValid=Validator.addressIsValid(address);
        boolean idValid=Validator.IdIsValid(nationallId);
        return((!existInDataBase( nationallId))&&nameValid&&phoneValid&&addressValid&&idValid&&emailValid);




        
        
    }









}
    
    
    
    
    
    

