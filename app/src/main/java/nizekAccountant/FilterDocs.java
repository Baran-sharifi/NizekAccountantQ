/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.DocModels.NormalDoc;
import nizekAccountant.logic.UserRepository.UserRepository;

/**
 *
 * @author Lenovo
 */
public class FilterDocs implements TableModel {
    UserRepository userRepository = new UserRepository();
 String selectedFilter;
    
    
    public FilterDocs(String selectedFilter) {
        this.selectedFilter=selectedFilter;
        
    }
    
    
    
    
    
    

    //declaring a new list the new list points to the list we pass to it
    
    
    public List<NormalDoc> filteredListPassing(){
    List<NormalDoc> filteredList= new ArrayList<>();
    
    switch(selectedIFilter){
    
    
    
    
    }
    
    
    
        
        
        
        return filteredList;
    
    }
    
    
    
    
    
    @Override
    public int getRowCount() {
//return filtredDoclists.size();
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0 -> {
                return "نام";
            }
            case 1 -> {
                return "ارزش معامله";
            }
            case 2 -> {
                return "وضعیت";
            }
            case 3 -> {
                return " تاریخ ثبت";
            }
            case 4 -> {
                return "زمان ثبت";
            }
            case 5 -> {
                return "توضیحات";
            }

            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

            switch (columnIndex) {
            case 0 -> {
                return false;
            }
            case 1, 2, 3, 4, 5 -> {
                return true;
            }
            default -> throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }






    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

         switch (columnIndex) {
            case 0 -> {
               //  return Manager.normalDocList.get(rowIndex).getUser().getName();
            }
            case 1 -> {
               //  return Manager.normalDocList.get(rowIndex).getCost();
            }
            case 2 -> {
              //  return Manager.normalDocList.get(rowIndex).convertCreditor(Manager.normalDocList.get(rowIndex).isCreditor());
            }
            case 3 -> {
              //    return Manager.normalDocList.get(rowIndex).getDate();
            }
            case 4 -> {
                
            //  return Manager.normalDocList.get(rowIndex).getTime();
            }
           
            case 5 ->{
            // return Manager.normalDocList.get(rowIndex).getDescription();
            }            
            default -> throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }



return null;



    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         switch (columnIndex) {
            case 0 -> {
//               Manager.costumerList.get(rowIndex).setName((String) aValue);
            }
            case 1 -> {
//                 Manager.normalDocList.get(rowIndex).setCost((String) aValue);
            }
            case 2 -> {
//                Manager.normalDocList.get(rowIndex).setCreditor((boolean) aValue);
            }
            case 3 -> {
//                Manager.normalDocList.get(rowIndex).setDate((DateNizek) aValue);
            }
            case 4 -> {
//                Manager.normalDocList.get(rowIndex).setTime((TimeNizek) aValue);
            }
            case 5 -> {
//                Manager.normalDocList.get(rowIndex).setDescription((String) aValue);
            }

            default -> throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

}
