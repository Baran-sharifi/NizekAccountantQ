package nizekAccountant.logic.ConverterHelper;

import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.DocModels.NormalDoc;
import nizekAccountant.logic.ModelManager.Manager;

public class Converter {
    public static Double convertToDouble(String text) {
        return Double.parseDouble(text);
    }

    public static void convertToNormalDocument(CheckDoc checkDoc) {
        Manager.addNormalDocument(new NormalDoc(
                checkDoc.getCost(),
                checkDoc.getDescription(),
                true,
                checkDoc.getDate(),
                checkDoc.getTime(),
                checkDoc.getUser()
        ));
        Manager.removeFromList(checkDoc);
    }
    public static boolean setBooleanCashed(String text) {
        if (text.equals("وصول شده")) {
            return true;
        }else{
        return false;
      }
    }
    public static boolean setBooleanCreditor(String text) {
        if (text.equals("بستانکار")) {
            return true;
        }
        return false;
    }
}
