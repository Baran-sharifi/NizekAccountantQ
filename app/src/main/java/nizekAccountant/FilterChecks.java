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

//    public FilterChecks(String payeeName, DateNizek after, DateNizek before, int beforeCost, int afterCost, String selectedFilter) {
//        this.payeeName = payeeName;
//        this.after = after;
//        this.before = before;
//        this.beforeCost = beforeCost;
//        this.afterCost = afterCost;
//        this.selectedFilter = selectedFilter;
//    }
    
    public FilterChecks(String selectedFilter,int beforeCost, int afterCost){
    
    this.selectedFilter=selectedFilter;
     this.beforeCost = beforeCost;
        this.afterCost = afterCost;
    }
    
    
    public FilterChecks(String selectedFilter,DateNizek after, DateNizek before){
     this.selectedFilter=selectedFilter;
    this.after = after;
        this.before = before;
    }
    
    
    
    public FilterChecks(String selectedFilter,String payeeName){
      this.payeeName = payeeName;
       this.selectedFilter = selectedFilter;
    
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
                return "نام";
            }
            case 1 -> {
                return "مبلغ چک";
            }
            case 2 -> {
                return "وضعیت";
            }
            case 3 -> {
                return "تاریخ پاس";
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
                return getChecksFilter().get(rowIndex).getDate();

            }
            case 4 -> {
                return getChecksFilter().get(rowIndex).getTime();
            }
            case 5 -> {
                return getChecksFilter().get(rowIndex).getDescription();
            }
            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }

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
