/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

/**
 *
 * @author Lenovo
 */

import javax.swing.*;
import java.awt.*;
//import javax.swing.JFrame;

public class GraphicsManager {

    public int r;
    public int g;
    public int b;
    Color color;
    Dimension btnConfirmDimension;

    public GraphicsManager(int r, int g, int b, Dimension btnConfirmDimension) {//to change color
        this.r = r;
        this.g = g;
        this.b = b;
        this.btnConfirmDimension = btnConfirmDimension;
        color = new Color(r, g, b);

    }

    void btnChangeColor(JButton btn) {
        btn.setBackground(color);
        btn.setForeground(Color.white);
    }

    void toggleChangeColor(JToggleButton togglebtn) {

        togglebtn.setBackground(color);
    }

    void btnSize(JButton btn) {
//for ثبت
      //  btn.setSize(btnConfirmDimension);
         btn.setSize(10,10);

    }
 void btnLableColor(){
 
 
 
 }
 
 void panelChangeColor(JPanel panel){
        panel.setBackground(color.white);
 }
 
 void backButtonSize(JButton btn){   //doesnt work
  //btn.setForeground(color);
 btn.setSize(131, 35);
 
 }
 
 

//void labelColorchange(JLabel label){}
//label.setForeground(r,g,b);



}
