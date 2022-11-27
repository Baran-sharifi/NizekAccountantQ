package nizekAccountant.logic.UserRepository;

import nizekAccountant.logic.AdminModel.Admin;
import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.DocModels.NormalDoc;
import nizekAccountant.logic.Login.Costumer;

import java.io.File;
import java.util.List;

public interface Storeable {

    // Write Implementations!
    void writeToFileAdmin();

    void writeToFileCostumer();

    void writeToFileCheckDoc();

    void writeToFileNormalDoc();

    // Read ALL IMPLEMENTATION
    List<String> readWholeFile(File file);

    void readAndAddCostumer(File file);

    void readAndAddCheckDoc(File file);

    void readAndAddNormalDoc(File file);

    void readAndAddAdmin(File file);

}
