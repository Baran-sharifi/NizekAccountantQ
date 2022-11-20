package nizekAccountant.logic.AccountingCalculations;

import nizekAccountant.logic.ConverterHelper.Converter;
import nizekAccountant.logic.ConverterHelper.ConverterTime;
import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.DocModels.NormalDoc;
import nizekAccountant.logic.ModelManager.Manager;
import nizekAccountant.logic.UserRepository.UserRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Accounting {
    static UserRepository userRepository = new UserRepository();

    public static double calculateMoneyFromFile(File file) {
        double result = 0;
        List<String> cost;
        cost = userRepository.readColumnWholeFile(1, file);
        for (int i = 0; i < cost.size(); i++) {
            result += Converter.convertToDouble(cost.get(i));
        }
        return result;
    }
    //Calculates the sum of NormalDocs if only and only isCreditor is true
    public static double calculateMoneyFromModelNormalCreditor(List<NormalDoc> normalDocList) {
        List<Double> moneyList = new ArrayList<>();
        double result = 0;
        for (NormalDoc normalDoc: normalDocList) {
            if (normalDoc.isCreditor()) {
                moneyList.add(Converter.convertToDouble(normalDoc.getCost()));
            }
        }
        for (int i = 0; i < moneyList.size(); i++) {
            result += moneyList.get(i);
        }
        return result;
    }
    //Calculates the sum of NormalDocs if only and only isCreditor is false
    public static double calculateMoneyFromModelNormalNotCreditor(List<NormalDoc> normalDocList) {
        List<Double> moneyList = new ArrayList<>();
        double result = 0;
        for (NormalDoc normalDoc: normalDocList) {
            if (!normalDoc.isCreditor()) {
                moneyList.add(Converter.convertToDouble(normalDoc.getCost()));
            }
        }
        for (int i = 0; i < moneyList.size(); i++) {
            result += moneyList.get(i);
        }
        return result;
    }
    public static double calculateTheResultOfNormalDoc() {
        return calculateMoneyFromModelNormalCreditor(Manager.normalDocList) - calculateMoneyFromModelNormalNotCreditor(Manager.normalDocList);
    }
    public static String getTheStatusOfNormalDoc() {
        String status = "";
        if (calculateTheResultOfNormalDoc() > 0) {
            status = "بستانکار";
        } else if (calculateTheResultOfNormalDoc() < 0){
            status = "بدهکار";
        } else {
            status = "سر به سر";
        }
        return status;
    }
    //Calculates the sum of Checks if only and only isCashed is true
    public static double calculateMoneyFromModelCheckCashed(List<CheckDoc> checkDocList) {
        List<Double> moneyList = new ArrayList<>();
        double result = 0;
        for (CheckDoc checkDoc: checkDocList) {
            if (checkDoc.isCashedd()) {
                moneyList.add(Converter.convertToDouble(checkDoc.getCost()));
            }
        }
        for (int i = 0; i < moneyList.size(); i++) {
            result += moneyList.get(i);
        }
        return result;
    }
    //Calculates the sum of CheckDoc if only and only isCashed is false
    public static double calculateMoneyFromModelCheckNotCashed(List<CheckDoc> checkDocList) {
        List<Double> moneyList = new ArrayList<>();
        double result = 0;
        for (CheckDoc checkDoc : checkDocList) {
            if (!checkDoc.isCashedd()) {
                moneyList.add(Converter.convertToDouble(checkDoc.getCost()));
            }
        }
        for (int i = 0; i < moneyList.size(); i++) {
            result += moneyList.get(i);
        }
        return result;
    }
    public static double reportAllTransactionNORMAL(List<NormalDoc> normalDocList) {
        double creditorSum = calculateMoneyFromFile(new File(normalDocList.get(0).getIsCreditorFilePath()));
        double notCreditorSum = calculateMoneyFromFile(new File(normalDocList.get(0).getNotCreditorFilePath()));
        return creditorSum + notCreditorSum;
    }

    public static double reportAllTransactionCHECK(List<CheckDoc> checkDocList) {
        double cashedSum = calculateMoneyFromFile(new File(checkDocList.get(0).getCashedFilePath()));
        double notCashedSum = calculateMoneyFromFile(new File(checkDocList.get(0).getNotCashedFilePath()));
        return cashedSum + notCashedSum;
    }

    public static String determineStatusNormal(List<NormalDoc> normalDocList) {
        String result = " ";
        double creditorSum = calculateMoneyFromFile(new File(normalDocList.get(0).getIsCreditorFilePath()));
        double notCreditorSum = calculateMoneyFromFile(new File(normalDocList.get(0).getNotCreditorFilePath()));
        if (creditorSum - notCreditorSum > 0) {
            result = "بستانکر";
        } else if (creditorSum - notCreditorSum < 0) {
            result = "بدهکار";
        } else {
            result = "سر به سر";
        }
        return result;
    }

    //Calculate Check time-bill!
    public static double calculateWeight() {
        List<String> stringList;
        double result = 0;
        int sum = 0;

        stringList = userRepository.readDateFromCheck(Manager.checkDocList);
        List<Integer> integerList = new ArrayList<>();
        for (String stringDate : stringList) {
            integerList.add((int) ConverterTime.findDifferencesInDays(stringDate));
        }

        List<Double> doubleList;
        doubleList = userRepository.readCostFromCheck(Manager.checkDocList);
        for (int i = 0; i < doubleList.size(); i++) {
            result += (doubleList.get(i) * integerList.get(i));
            sum += doubleList.get(i);
        }
        return  (result/sum);
    }
}
