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
import nizekAccountant.logic.UserRepository.UserRepository;

/**
 *
 * @author Lenovo
 */
public class FilterChecks implements TableModel {
    DateNizek after;
    DateNizek before;
    double beforeCost;
    double afterCost;
    String selectedFilter;
    UserRepository userRepository = new UserRepository();

    public FilterChecks(DateNizek after, DateNizek before, double beforeCost, double afterCost, String selectedFilter) {
        this.after = after;
        this.before = before;
        this.beforeCost = beforeCost;
        this.afterCost = afterCost;
        this.selectedFilter = selectedFilter;
    }

    

    

    public List<CheckDoc> getFilter() {
        List<CheckDoc> filteredList = new ArrayList<>();

        switch (selectedFilter) {

            case "payee" -> {
              return  userRepository.findCheckBasedOnName(selectedFilter);
            }
            case "cost" -> {
              return  userRepository.readFilterBasedOnCostCheck(beforeCost,afterCost);
                
            }
            case "time" -> {
              return  userRepository.filteredChecksBasedOnDateRange(before, after);
                
            }
        }

        return filteredList;

    }

    @Override
    public int getRowCount() {
//return filteredlist.Size()ک

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
                  return getFilter().get(rowIndex).getUser().getName();
            }
            case 1 -> {
                  return getFilter().get(rowIndex).getCost();
            }
            case 2 -> {
                   return getFilter().get(rowIndex).convertCashed(getFilter().get(rowIndex).isCashedd());
            }
            case 3 -> {
                 return getFilter().get(rowIndex).getDate();
            }
            case 4 -> {
                return getFilter().get(rowIndex).getTime();
            }
            case 5 -> {
                return getFilter().get(rowIndex).getDescription();
            }
            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                  getFilter().get(rowIndex).getUser().setName((String) aValue);
            }
            case 1 -> {
                   getFilter().get(rowIndex).setCost((String) aValue);
            }
            case 2 -> {
                   getFilter().get(rowIndex).setIsCashed((boolean) aValue);
            }
            case 3 -> {
                   getFilter().get(rowIndex).setDateNizek((DateNizek) aValue);
            }
            case 4 -> {
                   getFilter().get(rowIndex).setTimeNizek((TimeNizek) aValue);
            }
            case 5 -> {
                   getFilter().get(rowIndex).setDescription((String) aValue);
            }

            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
