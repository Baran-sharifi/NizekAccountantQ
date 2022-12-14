package nizekAccountant.logic.UserRepository;

import nizekAccountant.logic.AdminModel.Admin;
import nizekAccountant.logic.ConverterHelper.Converter;
import nizekAccountant.logic.ConverterHelper.ConverterTime;
import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.DocModels.NormalDoc;
import nizekAccountant.logic.Login.Costumer;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import nizekAccountant.logic.Date.TimeNizek;
import nizekAccountant.logic.Date.DateNizek;
import nizekAccountant.logic.Login.GroupType;
import nizekAccountant.logic.ModelManager.Manager;

public class UserRepository implements Storeable {

    public List<CheckDoc> findCheckBasedOnName(String name) {
        List<CheckDoc> filteredList = new ArrayList<>();
        for (CheckDoc checkDoc : Manager.checkDocList) {
            if (name.equals(checkDoc.getUser().getName())) {
                filteredList.add(checkDoc);
            }
        }
        return filteredList;
    }

    public List<NormalDoc> findNormalDocBasedOnName(String name) {
        List<NormalDoc> filteredList = new ArrayList<>();
        for (NormalDoc NormalDoc : Manager.normalDocList) {
            if (name.equals(NormalDoc.getUser().getName())) {
                filteredList.add(NormalDoc);
            }
        }
        return filteredList;
    }

    public Costumer findCostumerBasedOnIndex(int index) {
        return Manager.costumerList.get(index);
    }

    public List<NormalDoc> readFilterBasedOnCostNormal(double beforeCost, double afterCost) {
        List<NormalDoc> filteredList = new ArrayList<>();
        for (NormalDoc object : Manager.normalDocList) {
            if (Integer.parseInt(object.getCost()) >= beforeCost && Integer.parseInt(object.getCost()) <= afterCost) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }

    public List<CheckDoc> readFilterBasedOnCostCheck(int beforeCost, int afterCost) {
        List<CheckDoc> filteredList = new ArrayList<>();
        for (CheckDoc object : Manager.checkDocList) {
            if (Integer.parseInt(object.getCost()) >= beforeCost && Integer.parseInt(object.getCost()) <= afterCost) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }

    public List<CheckDoc> filteredChecksBasedOnDateRange(DateNizek beforeDate, DateNizek afterDate) {
        List<CheckDoc> filteredList = new ArrayList<>();
        for (CheckDoc checkDoc : Manager.checkDocList) {
            if ((Integer.parseInt(checkDoc.getDate().forDateFormat()) >= Integer.parseInt(beforeDate.forDateFormat()))
                    && (Integer.parseInt(checkDoc.getDate().forDateFormat()) <= Integer.parseInt(afterDate.forDateFormat()))) {
                filteredList.add(checkDoc);
            }
        }

        return filteredList;
    }

    // Filters Documents Based On the Provided ID!
    public List<CheckDoc> filterCheckDocumentsByIdUser(int id) {
        List<CheckDoc> filteredList = new ArrayList<>();
        for (CheckDoc checkDoc : Manager.checkDocList) {
            if (id == checkDoc.getUserID()) {
                filteredList.add(checkDoc);
            }
        }
        return filteredList;
    }

    public List<NormalDoc> filterNormalDocumentsByIdUser(int id) {
        List<NormalDoc> filteredList = new ArrayList<>();
        for (NormalDoc normalDoc : Manager.normalDocList) {
            if (id == normalDoc.getUserID()) {
                filteredList.add(normalDoc);
            }
        }
        return filteredList;
    }

    // Get the Max cost Value of Documents!
    public double getMaxCheckDoc() {
        List<Double> costList = new ArrayList<>();
        double max = 0;
        for (CheckDoc checkDoc : Manager.checkDocList) {
            costList.add(Double.valueOf(checkDoc.getCost()));
        }
//        for (int i = 0; i < costList.size() - 1; i++) {
//            if (costList.get(i) > costList.get(i + 1)) {
//                max = costList.get(i);
//            }
//            if (costList.get(i) < costList.get(i + 1)) {
//                max = costList.get(i + 1);
//            }
//        }
        for (Double cost : costList) {
            if (cost > max) {
                max = cost;
            }
        }
        return max;
    }

    public double getMaxNormalDoc() {
        double max = 0;
        List<Double> costList = new ArrayList<>();
        if (Manager.normalDocList.isEmpty()) {
            max = 0;
        }
        if (Manager.normalDocList.size() == 1) {
            max = Double.parseDouble(Manager.normalDocList.get(0).getCost());
        }
        for (NormalDoc normalDoc : Manager.normalDocList) {
            costList.add(Double.valueOf(normalDoc.getCost()));
        }
//        for (int i = 0; i < costList.size() - 1; i++) {
//            if (costList.get(i) > costList.get(i + 1)) {
//               max = costList.get(i);
//            }
//            if (costList.get(i) < costList.get(i + 1)) {
//                max = costList.get(i + 1);
//            }
//        }
        for (Double cost : costList) {
            if (cost > max) {
                max = cost;
            }
        }
        return max;
    }

    public List<NormalDoc> filteredNormalDocsBasedOnDateRange(DateNizek beforeDate, DateNizek afterDate) {
        List<NormalDoc> filteredList = new ArrayList<>();
        for (NormalDoc normalDoc : Manager.normalDocList) {
            if ((Integer.parseInt(normalDoc.getDate().forDateFormat()) >= Integer.parseInt(beforeDate.forDateFormat()))
                    && (Integer.parseInt(normalDoc.getDate().forDateFormat()) <= Integer.parseInt(afterDate.forDateFormat()))) {
                filteredList.add(normalDoc);
            }
        }

        return filteredList;
    }

    // *************** WRITE METHODS
    @Override
    public void writeToFileCostumer() {
        try {
            FileWriter fileWriter = new FileWriter("costumerFile.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            for (Costumer object : Manager.costumerList) {
                printWriter.printf("%s, %s, %s, %s, %s, %s\n",
                        object.getName(),
                        object.getNationalID(),
                        object.getGroupType(),
                        object.getAddress(),
                        object.getPhone(),
                        object.getEmail());
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeToFileCheckDoc() {
        try {
            FileWriter fileWriter = new FileWriter("checkFile.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            for (CheckDoc object : Manager.checkDocList) {
                printWriter.printf("%s, %s, %s, %s, %s, %s, %d, %d\n",
                        object.getUser().getName(),
                        object.getCost(),
                        object.getDescription(),
                        object.convertCashed(object.isCashedd()),
                        ConverterTime.convertToGregorian(object.getDate()),
                        object.getTime(),
                        object.getUserID(),
                        object.getIdentifier());
            }
            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
        }
    }

    @Override
    public void writeToFileNormalDoc() {
        try {

            FileWriter fileWriter = new FileWriter("normalFile.csv");

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            for (NormalDoc object : Manager.normalDocList) {
                printWriter.printf("%s, %s, %s, %s, %s, %s, %d, %d\n",
                        object.getUser().getName(),
                        object.getCost(),
                        object.getDescription(),
                        object.convertCreditor(object.isCreditor()),
                        ConverterTime.convertToGregorian(object.getDate()),
                        object.getTime(),
                        object.getUserID(),
                        object.getIdentifier());
            }
            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
        }
    }

    @Override
    public void writeToFileAdmin() {
        try {
            FileWriter fileWriter = new FileWriter("adminFile.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            for (Admin object : Manager.adminList) {
                printWriter.printf("%s, %s, %s \n",
                        object.getName(),
                        object.getEmail(),
                        object.getPassword());
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
        }
    }

    // &&&&&&&&&&&&& READ ALL Method &&&&&&&&&&&&&&&
    @Override
    public List<String> readWholeFile(File file) {
        List<String> arraylist = new ArrayList<>();
        try {
            InputStream ips = new FileInputStream(file.getPath());
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] emp = line.split(",");
                String a = Arrays.toString(emp);
                arraylist.add(a);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        return arraylist;
    }

    // Read And PARSE TO MODELS! 
    @Override
    public void readAndAddCostumer(File file) {
        if (file.exists()) {
            List<String> gottenFile = readWholeFile(file);
            for (String model : gottenFile) {
                String[] temp = model.split(", ");
                Manager.addCostumer(new Costumer(
                        temp[0].substring(1),
                        temp[1].trim(),
                        new GroupType(temp[2].trim()),
                        temp[3].trim(),
                        temp[4].trim(),
                        temp[5].trim().substring(0, temp[5].trim().indexOf("]"))
                ));
            }
        }
    }

    @Override
    public void readAndAddCheckDoc(File file) {   // requires Edit in Date!
        if (file.exists()) {
            List<String> gottenFile = readWholeFile(file);
            for (String model : gottenFile) {
                String[] temp = model.split(",  ");
                System.out.println(Arrays.toString(temp));
                String[] time = temp[5].trim().split(":");

                Manager.addCheckDocument(new CheckDoc(
                        temp[1].trim(),
                        temp[2],
                        ConverterTime.convertDate(ConverterTime.convertToPersian(temp[4].trim())),
                        //                         new DateNizek(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0])),
                        new TimeNizek(Integer.parseInt(time[0]), Integer.parseInt(time[1])),
                        Converter.setBooleanCashed(temp[3].trim()),
                        Manager.costumerList.get(Integer.parseInt(temp[6].trim().substring(0, 1)))));
            }
        }
    }

    @Override
    public void readAndAddNormalDoc(File file) {
        if (file.exists()) {
            List<String> gottenFile = readWholeFile(file);
            for (String model : gottenFile) {
                String[] temp = model.split(",  ");
                String[] time = temp[5].trim().split(":");
                Manager.addNormalDocument(new NormalDoc(
                        temp[1].trim(),
                        temp[2].trim(),
                        Converter.setBooleanCreditor(temp[3].trim()),
                        ConverterTime.convertDate(ConverterTime.convertToPersian(temp[4].trim())),
                        //                    new DateNizek(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0])),
                        new TimeNizek(Integer.parseInt(time[0]), Integer.parseInt(time[1])),
                        Manager.costumerList.get(Integer.parseInt(temp[6].trim().substring(0, 1)))));
            }
        }
    }

    @Override
    public void readAndAddAdmin(File file) {
        if (file.exists()) {
            List<String> gottenFile = readWholeFile(file);
            for (String model : gottenFile) {
                String[] temp = model.trim().split(", ");
                Manager.addAdmin(new Admin(
                        temp[0].trim().substring(1),
                        temp[1].trim(),
                        temp[2].trim().substring(0, temp[2].trim().indexOf("]"))
                ));
            }
        } else {
            System.out.println("file not found! admin!");
        }
    }

    // VALIDATE ADMIN
    public boolean validateAdmin(String inputEmail, String inputPassword) {
        for (Admin admin : Manager.adminList) {
            if (inputEmail.equals(admin.getEmail()) && inputPassword.equals(admin.getPassword())) {
                return true;
            }
        }
        return false;
    }

    // Remove Methods!
    public void removeFromNormalDocList(int deleteLine) {
        if (deleteLine > Manager.normalDocList.size()) {
            return;
        }
        for (NormalDoc normalDoc : Manager.normalDocList) {
            if (deleteLine == normalDoc.getIdentifier()) {
                Manager.removeFromList(normalDoc);
            }
        }
    }

    public void removeFromCheckDocList(int deleteLine) {
        if (deleteLine > Manager.checkDocList.size()) {
            return;
        }
        for (CheckDoc checkDoc : Manager.checkDocList) {
            if (deleteLine == checkDoc.getIdentifier()) {
                Manager.removeFromList(checkDoc);
            }
        }
    }

    public void removeFromCostumerList(int deleteLine) {
        if (deleteLine > Manager.costumerList.size()) {
            return;
        }
        for (Costumer costumer : Manager.costumerList) {
            if (deleteLine == costumer.getID()) {
                Manager.removeFromList(costumer);
            }
        }
    }

    public List<String> readColumnWholeFile(int column, File file) {
        String[] data;
        String currentLine;
        List<String> listColumn = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file.getPath());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((currentLine = bufferedReader.readLine()) != null) {
                data = currentLine.split(", ");
                listColumn.add(data[column]);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return listColumn;
    }

    // Method to Read Date from CHECKDOC
    public List<String> readDateFromCheck() {
        List<String> arrayDate = new ArrayList<>();
        for (CheckDoc checkDoc : Manager.checkDocList) {
            if (!(checkDoc.isCashedd())) {
                arrayDate.add(ConverterTime.convertToGregorian(checkDoc.getDate()));
            }
        }
        return arrayDate;
    }

    public List<Double> readCostFromCheck() {

        List<Double> arrayCost = new ArrayList<>();
        for (CheckDoc checkDoc : Manager.checkDocList) {
            if (!(checkDoc.isCashedd())) {
                arrayCost.add(Converter.convertToDouble(checkDoc.getCost()));
            }
        }
        return arrayCost;
    }

    public CheckDoc filterCheckDocumentsById(int id) {
        List<CheckDoc> filteredList = new ArrayList<>();
        for (CheckDoc checkDoc : Manager.checkDocList) {
            if (id == checkDoc.getIdentifier()) {
                filteredList.add(checkDoc);
            }
        }
        return filteredList.get(0);
    }

    public NormalDoc filterNormalDocumentsById(int id) {
        List<NormalDoc> filteredList = new ArrayList<>();
        for (NormalDoc normalDoc : Manager.normalDocList) {
            if (id == normalDoc.getIdentifier()) {
                filteredList.add(normalDoc);
            }
        }
        return filteredList.get(0);
    }

    public List<String> getDatesFormCheckDoc() {
        List<String> dateList = new ArrayList<>();
        for (CheckDoc checkDoc : Manager.checkDocList) {
            dateList.add(ConverterTime.convertToGregorian(checkDoc.getDate()));
        }
        return dateList;
    }

    public List<String> getDatesFormNormalDoc() {
        List<String> dateList = new ArrayList<>();
        for (NormalDoc normalDoc : Manager.normalDocList) {
            dateList.add(ConverterTime.convertToGregorian(normalDoc.getDate()));
        }
        return dateList;
    }

    public String findName(String email, String password) {
        String name = "";
        for (Admin admin : Manager.adminList) {
            if (validateAdmin(email, password)) {
                name = admin.getName();
            }
        }
        return name;
    }

    public List<DateNizek> getDatesFormNormalDoc(List<NormalDoc> normalDocList) {
        List<DateNizek> dateList = new ArrayList<>();
        for (NormalDoc normalDoc : normalDocList) {
            dateList.add(normalDoc.getDate());
        }
        return dateList;
    }

    public List<String> getTimeFromNormalDoc(List<NormalDoc> normalDocList) {
        List<String> dateList = new ArrayList<>();
        for (NormalDoc normalDoc : normalDocList) {
            dateList.add(normalDoc.getTime().toString());
        }
        return dateList;
    }

    public List<DateNizek> getDatesFormCheckDoc(List<CheckDoc> checkDoclist) {
        List<DateNizek> dateList = new ArrayList<>();
        for (CheckDoc checkDoc : checkDoclist) {
            dateList.add(checkDoc.getDate());
        }
        return dateList;
    }

    public List<String> getTimeFromCheckDoc(List<CheckDoc> checkDoclist) {
        List<String> dateList = new ArrayList<>();
        for (CheckDoc checkDoc : checkDoclist) {
            dateList.add(checkDoc.getTime().toString());
        }
        return dateList;
    }

    public int getToday() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        String iranDate = ConverterTime.convertToPersian(time);
        String[] array = iranDate.trim().split("-");
        int day = Integer.parseInt(array[2]);

        return day;
    }

    public int getMonth() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);

        String iranDate = ConverterTime.convertToPersian(time);

        String[] array = iranDate.trim().split("-");
        int month = Integer.parseInt(array[1]);

        return month;
    }

    public int getYear() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(System.currentTimeMillis());
        String time = formatter.format(date);
        String iranDate = ConverterTime.convertToPersian(time);

        String[] array = iranDate.trim().split("-");
        int year = Integer.parseInt(array[0]);

        return year;
    }
}
