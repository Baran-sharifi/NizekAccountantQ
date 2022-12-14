/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nizekAccountant.logic.ConverterHelper.ConverterTime;
import nizekAccountant.logic.Date.DateNizek;
import nizekAccountant.logic.Date.TimeNizek;
import nizekAccountant.logic.DocModels.CheckDoc;
import static nizekAccountant.logic.ModelManager.Manager.userRepository;
import nizekAccountant.logic.UserRepository.UserRepository;

/**
 *
 * @author Lenovo
 */
public class FilterChecks implements TableModel {
    String payeeName;
    DateNizek after;
    DateNizek before;
    int beforeCost;
    int afterCost;
    String selectedFilter;
    UserRepository userRepository1 = new UserRepository();
    boolean status;
    
    public FilterChecks(String selectedFilter,int beforeCost, int afterCost,boolean status ){
    
    this.selectedFilter=selectedFilter;
     this.beforeCost = beforeCost;
        this.afterCost = afterCost;
        this.status = status;
    }
    
    
    public FilterChecks(String selectedFilter,DateNizek after, DateNizek before, boolean status){
     this.selectedFilter=selectedFilter;
    this.after = after;
        this.before = before;
        this.status = status;
    }
    
    
    
    public FilterChecks(String selectedFilter,String payeeName, boolean status){
      this.payeeName = payeeName;
       this.selectedFilter = selectedFilter;
       this.status = status;
    
    }
    
    
    
    
    
    
    
    
public void setStatus(boolean status) {
      this.status = status;
    }
  
    public List<CheckDoc> getChecksFilter() {
        List<CheckDoc> filteredList;

        switch (selectedFilter) {

            case "payee" -> {
              filteredList=   userRepository1.findCheckBasedOnName(payeeName);
                return filteredList;
            }
            case "cost" -> {
               filteredList=  userRepository1.readFilterBasedOnCostCheck(beforeCost, afterCost);
            return filteredList;
            }
            case "time" -> {
                filteredList= userRepository1.filteredChecksBasedOnDateRange(before, after);
      return filteredList;
            }

        }

        return null;


    }

    @Override
    public int getRowCount() {
        return getChecksFilter().size();


    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {

        switch (columnIndex) {
            case 0 -> {
                return "??????";
            }
            case 1 -> {
                return "???????? ????";
            }
            case 2 -> {
                return "??????????";
            }
            case 3 -> {
                return "?????????? ??????";
            }
            case 4 -> {
                return "???????? ??????";
            }
            case 5 -> {
                return "??????????????";
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
            case 4 -> {
                return false;
            }
            case 1, 3, 2,  5 -> {
                return true;
            }
            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {

                return getChecksFilter().get(rowIndex).getUser().getName();
            }
            case 1 -> {
                return getChecksFilter().get(rowIndex).getCost();
            }
            case 2 -> {
                return getChecksFilter().get(rowIndex).convertCashed(getChecksFilter().get(rowIndex).isCashedd());
            }
            case 3 -> {
                if (status == true) {
                return getChecksFilter().get(rowIndex).getDate();
                } else {
                  List<DateNizek> list = userRepository.getDatesFormCheckDoc(getChecksFilter());
                  return ConverterTime.convertToGregorian(list.get(rowIndex));
                }

            }
            case 4 -> {
                if (status == true) {
                    List<String> list = userRepository.getTimeFromCheckDoc(getChecksFilter());
                    try {
                        return ConverterTime.convertToIran(list.get(rowIndex));
                    } catch (ParseException ex) {
                        Logger.getLogger(FilterChecks.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                return getChecksFilter().get(rowIndex).getTime();
                }
            }
            case 5 -> {
                return getChecksFilter().get(rowIndex).getDescription();
            }
            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {

                getChecksFilter().get(rowIndex).getUser().setName((String) aValue);
            }
            case 1 -> {
                getChecksFilter().get(rowIndex).setCost((String) aValue);
            }
            case 2 -> {
                getChecksFilter().get(rowIndex).setIsCashed((boolean) aValue);
            }
            case 3 -> {
                getChecksFilter().get(rowIndex).setDateNizek((DateNizek) aValue);
            }
            case 4 -> {
                getChecksFilter().get(rowIndex).setTimeNizek((TimeNizek) aValue);
            }
            case 5 -> {
                getChecksFilter().get(rowIndex).setDescription((String) aValue);
            }

            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
     
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
      
    }

}
