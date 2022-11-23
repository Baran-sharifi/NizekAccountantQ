package nizekAccountant.logic.UserRepository;

import nizekAccountant.logic.AdminModel.Admin;
import nizekAccountant.logic.ConverterHelper.Converter;
import nizekAccountant.logic.ConverterHelper.ConverterTime;
import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.DocModels.NormalDoc;
import nizekAccountant.logic.Login.Costumer;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;
import nizekAccountant.logic.Date.TimeNizek;
import nizekAccountant.logic.Date.DateNizek;
import nizekAccountant.logic.Login.GroupType;
import nizekAccountant.logic.ModelManager.Manager;

public class UserRepository implements Storeable {

    static String tempNORMAL;
    static String tempCHECk;
    static String tempAdmin;

    @Override
    public String readFile(CheckDoc checkDoc, int id) {
        String name;
        String cost;
        String description;
        String date;
        String time;
        String userID;
        try {
            Scanner x = new Scanner(new File(checkDoc.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                name = x.next();
                cost = x.next();
                description = x.next();
                date = x.next();
                time = x.next();
                userID = x.next();
                if (id == checkDoc.getUserID()) {
                    tempCHECk = String.format("%s, %s, %s, %s,  %s, %s", name, cost, description, ConverterTime.convertToPersian(date), time, userID);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempCHECk;
    }

    //$$$$$$$$$$$$$$$$$---------$$$$$$$$$$ FINAL $$$$$$$$$$---------$$$$$$$$$$$$$$$$$
    @Override
    public String readFile(NormalDoc normalDoc, int id) {
        String name;
        String cost;
        String description;
        String isCreditor;
        String date;
        String time;
        String userID;
        try {
            Scanner x = new Scanner(new File(normalDoc.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                name = x.next();
                cost = x.next();
                description = x.next();
                isCreditor = x.next();
                date = x.next();
                time = x.next();
                userID = x.next();
                if (id == normalDoc.getUserID()) {
                    tempNORMAL = String.format("%s, %s, %s, %s, %s, %s, %s", name, cost, description, isCreditor, ConverterTime.convertToPersian(date), time, userID);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempNORMAL;
    }

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

    public String readCostumerBasedOnName(String name) {
        for (Costumer costumer : Manager.costumerList) {
            if (name.equals(costumer.getName())) {
                return String.format("%s, %s, %s, %s, %s, %s",
                        costumer.getName(),
                        costumer.getNationalID(),
                        costumer.getGroupType(),
                        costumer.getEmail(),
                        costumer.getAddress(),
                        costumer.getPhone());
            }
        }
        return "Not Found";
    }

    public List<NormalDoc> readBasedOnDay() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String formatted = dtf.format(now);
        String[] formattedArray = formatted.split("/");
        StringBuilder sb = new StringBuilder();
        sb.append(formattedArray[0]);
        sb.append("-");
        sb.append(formattedArray[1]);
        sb.append("-");
        sb.append(formattedArray[2]);
        String convertedTime = ConverterTime.convertToPersian(sb.toString());
        String[] array = convertedTime.split("-");
        int convertedDay = Integer.parseInt(array[2]);
        int convertedMonth = Integer.parseInt(array[1]);
        int convertedYear = Integer.parseInt(array[0]);
//
        List<NormalDoc> filteredList = new ArrayList<>();
        for (NormalDoc object : Manager.normalDocList) {
            if (convertedDay == object.getDate().getDay() && convertedMonth == object.getDate().getMonth() && convertedYear == object.getDate().getYear()) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }

    public List<NormalDoc> readBasedOnMonth() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String formatted = dtf.format(now);
        String[] formattedArray = formatted.split("/");
        StringBuilder sb = new StringBuilder();
        sb.append(formattedArray[0]);
        sb.append("-");
        sb.append(formattedArray[1]);
        sb.append("-");
        sb.append(formattedArray[2]);
        String convertedTime = ConverterTime.convertToPersian(sb.toString());
        String[] array = convertedTime.split("-");
        int convertedMonth = Integer.parseInt(array[1]);
        int convertedYear = Integer.parseInt(array[0]);
        List<NormalDoc> filteredList = new ArrayList<>();
        for (NormalDoc object : Manager.normalDocList) {
            if (convertedMonth == object.getDate().getMonth() && convertedYear == object.getDate().getYear()) {
                filteredList.add(object);
            }
        }
        return filteredList;
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

    public List<CheckDoc> readBasedOnDayCheck() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String formatted = dtf.format(now);
        String[] formattedArray = formatted.split("/");
        StringBuilder sb = new StringBuilder();
        sb.append(formattedArray[0]);
        sb.append("-");
        sb.append(formattedArray[1]);
        sb.append("-");
        sb.append(formattedArray[2]);
        String convertedTime = ConverterTime.convertToPersian(sb.toString());
        String[] array = convertedTime.split("-");
        int convertedDay = Integer.parseInt(array[2]);
        int convertedMonth = Integer.parseInt(array[1]);
        int convertedYear = Integer.parseInt(array[0]);
        List<CheckDoc> filteredList = new ArrayList<>();
        for (CheckDoc object : Manager.checkDocList) {
            if (convertedDay == object.getDate().getDay() && convertedMonth == object.getDate().getMonth() && convertedYear == object.getDate().getYear()) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }

    public List<CheckDoc> readBasedOnMonthCheck() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String formatted = dtf.format(now);
        String[] formattedArray = formatted.split("/");
        StringBuilder sb = new StringBuilder();
        sb.append(formattedArray[0]);
        sb.append("-");
        sb.append(formattedArray[1]);
        sb.append("-");
        sb.append(formattedArray[2]);
        String convertedTime = ConverterTime.convertToPersian(sb.toString());
        String[] array = convertedTime.split("-");
        int convertedMonth = Integer.parseInt(array[1]);
        int convertedYear = Integer.parseInt(array[0]);
        List<CheckDoc> filteredList = new ArrayList<>();
        for (CheckDoc object : Manager.checkDocList) {
            if (convertedMonth == object.getDate().getMonth() && convertedYear == object.getDate().getYear()) {
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
        for (int i = 0; i < costList.size() - 1; i++) {
            if (costList.get(i) < costList.get(i + 1)) {
                max = costList.get(i + 1);
            }
        }
        return max;
    }

    public double getMaxNormalDoc() {
        List<Double> costList = new ArrayList<>();
        double max = 0;
        for (NormalDoc normalDoc : Manager.normalDocList) {
            costList.add(Double.valueOf(normalDoc.getCost()));
        }
        for (int i = 0; i < costList.size() - 1; i++) {
            if (costList.get(i) < costList.get(i + 1)) {
                max = costList.get(i + 1);
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

    @Override
    public String readFile(Costumer costumer, String inputNationalID) {
        return "Unused!";
    }

    @Override
    public String readAdmin(Admin admin) {
        String name;
        String email;
        String password;
        try {
            Scanner x = new Scanner(new File(admin.getFilePath()));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                name = x.next();
                email = x.next();
                password = x.next();
                tempAdmin = String.format("%s , %s, %s", name, email, password);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tempAdmin;
    }

    // *************** WRITE METHODS
    @Override
    public void writeToFileCostumer() {
        try {
            FileWriter fileWriter = new FileWriter("/Users/persuara/Desktop/repository/costumerFile.csv");
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
            FileWriter fileWriter = new FileWriter("/Users/persuara/Desktop/repository/checkFile.csv");
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
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFileNormalDoc() {
        try {

            FileWriter fileWriter = new FileWriter("/Users/persuara/Desktop/repository/normalFile.csv");

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
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFileAdmin() {
        try {
            FileWriter fileWriter = new FileWriter("/Users/persuara/Desktop/repository/adminFile.csv");
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
            e.printStackTrace();
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
        } catch (Exception e) {
            e.printStackTrace();
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
                        temp[5].trim()
                ));
            }
        }
    }

    @Override
    public void readAndAddCheckDoc(File file) {   // requires Edit in Date!
        if (file.exists()) {
            List<String> gottenFile = readWholeFile(file);
            for (String model : gottenFile) {
                String[] temp = model.split(", ");
                System.out.println(Arrays.toString(temp));
            String[] date = temp[4].trim().split("-");
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
            String[] temp = model.split(", ");
            System.out.println(Arrays.toString(temp));
           
            
            
            String[] date = temp[4].trim().split("-");
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
                        temp[2].trim().substring(0, 5)
                ));
            }
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
        for (NormalDoc normalDoc : Manager.normalDocList) {
            if (deleteLine == normalDoc.getIdentifier()) {
                Manager.removeFromList(normalDoc);
                Manager.saveNormal();
            }
        }
    }

    public void removeFromCheckDocList(int deleteLine) {
        for (CheckDoc checkDoc : Manager.checkDocList) {
            if (deleteLine == checkDoc.getIdentifier()) {
                Manager.removeFromList(checkDoc);
                Manager.saveCheck();
            }
        }
    }

    public void removeFromCostumerList(int deleteLine) {
        for (Costumer costumer : Manager.costumerList) {
            if (deleteLine == costumer.getID()) {
                Manager.removeFromList(costumer);
                Manager.saveCostumer();
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
            e.printStackTrace();
        }
        return listColumn;
    }

    // Method to Read Date from CHECKDOC
    public List<String> readDateFromCheck(List<CheckDoc> checkDocList) {
        List<String> arrayDate = new ArrayList<>();
        for (CheckDoc checkDoc : checkDocList) {
            if (!(checkDoc.isCashedd())) {
                arrayDate.add(ConverterTime.convertToGregorian(checkDoc.getDate()));
            }
        }
        return arrayDate;
    }

    public List<Double> readCostFromCheck(List<CheckDoc> checkDocList) {

        List<Double> arrayCost = new ArrayList<>();
        for (CheckDoc checkDoc : checkDocList) {
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
}
