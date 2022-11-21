/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nizekAccountant.logic.Date.DateNizek;
import nizekAccountant.logic.Date.TimeNizek;
import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.DocModels.NormalDoc;
import nizekAccountant.logic.UserRepository.UserRepository;

/**
 *
 * @author Lenovo
 */
public class FilterDocs implements TableModel {
    UserRepository userRepository = new UserRepository();
    String payeeNameDoc;
    String selectedFilter;   
    DateNizek after;
    DateNizek before;
    int beforeCost;
    int afterCost;

    public FilterDocs(String payeeNameDoc,DateNizek after, DateNizek before, int beforeCost, int afterCost,String selectedFilter) {
        this.payeeNameDoc = payeeNameDoc;
        this.after = after;
        this.before = before;
        this.beforeCost = beforeCost;
        this.afterCost = afterCost;
        this.selectedFilter = selectedFilter;
    }

   

  

    

    public List<NormalDoc> getDocFilter() {
        List<NormalDoc> filteredList = new ArrayList<>();

        switch (selectedFilter) {

            case "payee" -> {
              return  userRepository.findNormalDocBasedOnName(payeeNameDoc);
            }
            case "cost" -> {
              return  userRepository.readFilterBasedOnCostNormal(beforeCost,afterCost);
                
            }
            case "time" -> {
              return  userRepository.filteredNormalDocsBasedOnDateRange(before, after);
                
            }
        }

        return filteredList;

    }

    
    
    
    @Override
    public int getRowCount() {
return getDocFilter().size();
        
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
                 return getDocFilter().get(rowIndex).getUser().getName();
            }
            case 1 -> {
                 return getDocFilter().get(rowIndex).getCost();
            }
            case 2 -> {
                return getDocFilter().get(rowIndex).convertCreditor(getDocFilter().get(rowIndex).isCreditor());
            }
            case 3 -> {
                return getDocFilter().get(rowIndex).getDate();
            }
            case 4 -> {
                
             return getDocFilter().get(rowIndex).getTime();
            }
           
            case 5 ->{
            return getDocFilter().get(rowIndex).getDescription();
            }            
            default -> throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }






    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         switch (columnIndex) {
            case 0 -> {
               getDocFilter().get(rowIndex).getUser().setName((String) aValue);
            }
            case 1 -> {
                getDocFilter().get(rowIndex).setCost((String) aValue);
            }
            case 2 -> {
               getDocFilter().get(rowIndex).setCreditor((boolean) aValue);
            }
            case 3 -> {
                getDocFilter().get(rowIndex).setDate((DateNizek) aValue);
            }
            case 4 -> {
                getDocFilter().get(rowIndex).setTime((TimeNizek) aValue);
            }
            case 5 -> {
               getDocFilter().get(rowIndex).setDescription((String) aValue);
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
