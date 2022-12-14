/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nizekAccountant;

import java.io.File;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nizekAccountant.logic.ModelManager.Manager;
import nizekAccountant.logic.ConverterHelper.ConverterTime;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nizekAccountant.logic.Date.DateNizek;
import nizekAccountant.logic.Date.TimeNizek;
import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.UserRepository.UserRepository;

/**
 * @author Lenovo
 */
public class ShowCheckRepository implements TableModel {
    private boolean status;

    UserRepository userRepository = new UserRepository();
    

    public ShowCheckRepository(boolean status) {
        this.status = status;
    }
    public void setTimeZone(boolean status) {
       this.status = status;
    }

    @Override
    public int getRowCount() {
        return Manager.checkDocList.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
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
            case 6 -> {
                return "شناسه سند";
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
            case 0,6 -> {
                return false;
            }
            case 1, 3, 2, 4, 5 -> {
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
                return Manager.checkDocList.get(rowIndex).getUser().getName();
            }
            case 1 -> {
               return Manager.checkDocList.get(rowIndex).getCost();
            }
            case 2 -> {
                return Manager.checkDocList.get(rowIndex).convertCashed(Manager.checkDocList.get(rowIndex).isCashedd());
            }
            case 3 -> {
                if (status == true) {
                return Manager.checkDocList.get(rowIndex).getDate();
               
                } else {
                    List<String> gregorianList = userRepository.getDatesFormCheckDoc();
                       return gregorianList.get(rowIndex);
          
                }
            }
            case 4 -> {
                if (status == true) {
                    try {
                        return ConverterTime.convertToIran(Manager.checkDocList.get(rowIndex).getTime().toString());
                    } catch (ParseException ex) {
                        Logger.getLogger(ShowCheckRepository.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    return Manager.checkDocList.get(rowIndex).getTime();
                }
            }
            case 5 -> {
                return Manager.checkDocList.get(rowIndex).getDescription();
            }
            case 6 -> {
                return Manager.checkDocList.get(rowIndex).getIdentifier();
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
               Manager.costumerList.get(rowIndex).setName((String) aValue);
            }
            case 1 -> {
                 Manager.checkDocList.get(rowIndex).setCost((String) aValue);
            }
            case 2 -> {
                Manager.checkDocList.get(rowIndex).setIsCashed((boolean) aValue);
            }
            case 3 -> {
                
                Manager.checkDocList.get(rowIndex).setDateNizek((DateNizek) aValue);
            }
            case 4 -> {
                Manager.checkDocList.get(rowIndex).setTimeNizek((TimeNizek) aValue);
            }
            case 5 -> {
                Manager.checkDocList.get(rowIndex).setDescription((String) aValue);
            }
             case 6 -> {
                Manager.checkDocList.get(rowIndex).setIdentifier((int) aValue);
            }

            default -> throw new IndexOutOfBoundsException(String.format("Column index not exist. (%d)", columnIndex));
        } 
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
