package nizekAccountant.logic.ModelManager;

import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.DocModels.NormalDoc;
import nizekAccountant.logic.Login.Costumer;
import nizekAccountant.logic.UserRepository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import nizekAccountant.logic.AdminModel.Admin;

public class Manager {

    public static List<NormalDoc> normalDocList = new ArrayList<>();
    public static List<CheckDoc> checkDocList = new ArrayList<>();
    public static List<Costumer> costumerList = new ArrayList<>();
    public static List<Admin> adminList = new ArrayList<>();
    public static List<String> dateListCheck = new ArrayList<>();
    public static UserRepository userRepository = new UserRepository();

    public static void addNormalDocument(NormalDoc normalDoc) {
        normalDocList.add(normalDoc);
        userRepository.writeToFileNormalDoc();
    }

    public static void addCheckDocument(CheckDoc checkDoc) {
        checkDocList.add(checkDoc);
        userRepository.writeToFileCheckDoc();
    }

    public static void addCostumer(Costumer costumer) {
        if (!costumerList.isEmpty()) {
            for (int i = 0; i < costumerList.size(); i++) {
                if (!(costumer.getNationalID().equals(costumerList.get(i).getNationalID()))) {
                    costumerList.add(costumer);
                    userRepository.writeToFileCostumer();
                } else {
                    System.out.println("Already Exists!");
                }
            }
        } else {
            costumerList.add(costumer);
            userRepository.writeToFileCostumer();
        }

    }

    public static void addAdmin(Admin admin) {
        adminList.add(admin);
        userRepository.writeToFileAdmin();
    }

    public static void removeFromList(NormalDoc normalDoc) {
        normalDocList.remove(normalDoc);
         userRepository.writeToFileNormalDoc();
    }

    public static void removeFromList(CheckDoc checkDoc) {
        checkDocList.remove(checkDoc);
         userRepository.writeToFileCheckDoc();
    }

    public static void removeFromList(Costumer costumer) {
        costumerList.remove(costumer);
        userRepository.writeToFileCostumer();
    }
}
