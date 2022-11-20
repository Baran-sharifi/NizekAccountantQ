/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lenovo
 */
public class Validator {

    // String emailInput = "havij@folan.com";
    //  String nameInput = "havij";
    //  String Id = "havij3q34";
    //  String Phone = "021havij";
    //  String address = "havijalley647839jfkflskdjflas";
//^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"
    static boolean emailIsValid(String emailInput) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailInput);
        //   System.out.println("emailvalid"+(matcher.find()));
        return matcher.find();
    }

    static boolean nameIsValid(String nameInput) {
        String regex = "^[\\u0600-\\u06FF\\s]+${1,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameInput);
        return matcher.matches();
    }

    static boolean costIsValid(String Id) {
        String regex = "^[1-9]+[0-9]{1,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Id);
        return matcher.find();
    }

    static boolean phoneIsValid(String phone) {
        String regex = "^\\d{11}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);

        return matcher.matches();
    }

    static boolean addressIsValid(String address) {
        String regex = "^[\\u0600-\\u06FF\\s]+${1,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);

        return matcher.find();
    }

    static boolean passwordIsvalid(String password) {
        String regex = "\\w";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return (matcher.find());
    }

    static boolean CategoryIsValid(String nameInput) {
        String regex = "^[a-zA-Zhالف-یا]{1}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameInput);

        return matcher.find();
    }

    static boolean DateisValid(String date) {
        String regex = "\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return (matcher.matches());

    }
    
    
    static boolean IdIsValid(String id){
    
    String regex = "^\\d{10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        return (matcher.matches());
    
    }
    
    
    

    // static boolean isReadyToAdd(){} 
}
