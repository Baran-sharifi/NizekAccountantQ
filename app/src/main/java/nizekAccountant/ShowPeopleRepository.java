/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

import java.io.File;
import java.util.List;
import nizekAccountant.logic.ModelManager.Manager;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nizekAccountant.logic.Login.GroupType;
import nizekAccountant.logic.UserRepository.UserRepository;

/**
 *
 * @author Lenovo
 */
public class ShowPeopleRepository implements TableModel {

    UserRepository userRepository = new UserRepository();

    public ShowPeopleRepository() {

    }

    public void showPeopleOncombo() {

//         for(String person:PeopleDoc){
//          peopleDocList.addItem(person);
//          }
    }

    @Override
    public int getRowCount() {
        //         return 100;

        return Manager.costumerList.size();
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
                return "کد ملی";
            }
            case 2 -> {
                return "گروه مشتری";
            }
            case 3 -> {
                return "آدرس";
            }
            case 4 -> {
                return "تلفن";
            }
            case 5 -> {

                return "ایمیل";

            }
            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        return String.class;
    }                                                  // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0 -> {
                return true;
            }
            case 1 -> {
                return true;
            }
            case 2 -> {
                return true;
            }
            case 3 -> {
                return true;
            }
            case 4 -> {
                return true;
            }
            case 5 -> {
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
                return Manager.costumerList.get(rowIndex).getName();
            }
            case 1 -> {
                return Manager.costumerList.get(rowIndex).getNationalID();   
            }
            case 2 -> {
                return Manager.costumerList.get(rowIndex).getGroupType();
            }
            case 3 -> {
               return Manager.costumerList.get(rowIndex).getAddress();
            }
            case 4 -> {
                return Manager.costumerList.get(rowIndex).getPhone();
            }
            case 5 -> {
                return Manager.costumerList.get(rowIndex).getEmail();
            }

            default ->
                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
    }

    //edit table
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex
    ) {

        switch (columnIndex) {
            case 0 -> {
                Manager.costumerList.get(rowIndex).setName((String) aValue);
            }
            case 1 -> {
                Manager.costumerList.get(rowIndex).setNationalID((String) aValue);
            }
            case 2 -> {
                Manager.costumerList.get(rowIndex).setgroupType((GroupType) aValue);
            }
            case 3 -> {
                Manager.costumerList.get(rowIndex).setAddress((String) aValue);
            }
            case 4 -> {
                Manager.costumerList.get(rowIndex).setPhone((String) aValue);
            }
            case 5 -> {
                Manager.costumerList.get(rowIndex).setEmail((String) aValue);
            }
            default ->
                System.out.println("no more");
//                throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l
    ) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeTableModelListener(TableModelListener l
    ) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String toString() {
        return "ShowDocLogicRepository{" + "PeopleDoc=" + '}';
        //return list.toString();

    }

}
