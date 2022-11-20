package nizekAccountant.logic.DocModels;

import nizekAccountant.logic.Date.DateNizek;
import nizekAccountant.logic.Date.TimeNizek;
import nizekAccountant.logic.Login.Costumer;

public class NormalDoc {
    private Costumer costumer;
    private String cost;
    private String description;
    private boolean isCreditor;
    private DateNizek dateNizek;
    private TimeNizek timeNizek;
    private String payee;

    private int userID;
    private final String filePath = "C:\\csvProject\\normalDoc.csv";
    private final String isCreditorFilePath = "C:\\csvProject\\creditor.csv";
    private final String notCreditorFilePath = "C:\\csvProject\\notCreditor.csv";

    public NormalDoc(String cost, String description, boolean isCreditor, DateNizek dateNizek, TimeNizek timeNizek, Costumer costumer) {
        this.cost = cost;
        this.description = description;
        this.isCreditor  = isCreditor;
        this.dateNizek   = dateNizek;
        this.timeNizek   = timeNizek;
        this.costumer    = costumer;
        userID = costumer.getID();
        payee = costumer.getName();

    }

    public Costumer getUser() {
        return costumer;
    }
//public NormalDoc() {}


    public String getPayee() {
      return this.payee;
    }
   
    public void setUser(Costumer costumer) {
        this.costumer = costumer;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreditor(boolean creditor) {
        isCreditor = creditor;
    }

    public void setDate(DateNizek dateNizek) {
        this.dateNizek = dateNizek;
    }

    public void setTime(TimeNizek timeNizek) {
        this.timeNizek = timeNizek;
    }


    public int getUserID() {
        return userID;
    }
    public String getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public static String statusIsCreditor(boolean docStatus) {
        if (docStatus == false) {
            return "بدهکار";
        }
       return "بدهکار";
    }
    public boolean isCreditor() {
        return this.isCreditor;
    }
    public DateNizek getDate() {
        return dateNizek;
    }
    public TimeNizek getTime() {
        return timeNizek;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getNotCreditorFilePath() {
        return notCreditorFilePath;
    }
    public String getIsCreditorFilePath() {
        return isCreditorFilePath;
    }
    public String convertCreditor(boolean isCreditor) {
        String result = "Undefined!";
        if (isCreditor) {
            result = "بستانکار";
        } else {
            result = "بدهکار";
        }
        return  result;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s",
                getUser().getName(),
                getCost(),
                getDescription(),
                convertCreditor(isCreditor()),
                getDate().toString(),
                getTime().toString()
        );
    }
}
