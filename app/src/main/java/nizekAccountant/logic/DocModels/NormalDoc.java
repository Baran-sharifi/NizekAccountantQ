package nizekAccountant.logic.DocModels;

import nizekAccountant.logic.Date.DateNizek;
import nizekAccountant.logic.Date.TimeNizek;
import nizekAccountant.logic.Login.Costumer;
import nizekAccountant.logic.ModelManager.Manager;

public class NormalDoc {

    private Costumer costumer;
    private String cost;
    private String description;
    private boolean isCreditor;
    private DateNizek dateNizek;
    private TimeNizek timeNizek;
    private String payee;
    int identifier = 0;
//a list of days
//    static List<DayModel> listOfDays = new ArrayList<DayModel>();
    private int userID;
    private final String filePath = "C:\\csvProject\\normalDoc.csv";
    private final String isCreditorFilePath = "C:\\csvProject\\creditor.csv";
    private final String notCreditorFilePath = "C:\\csvProject\\notCreditor.csv";

    public NormalDoc(String cost, String description, boolean isCreditor, DateNizek dateNizek, TimeNizek timeNizek, Costumer costumer) {
        this.cost = cost;
        this.description = description;
        this.isCreditor = isCreditor;
        this.dateNizek = dateNizek;
        this.timeNizek = timeNizek;
        this.costumer = costumer;
        userID = costumer.getID();
        payee = costumer.getName();
        identifier = Manager.normalDocList.size();
    }

    public int getIdentifier() {
        return this.identifier;
    }
     public int setIdentifier(int id) {
        return this.identifier = id;
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
        return result;
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

//    static class DayModel {
//
//        public double costDayModel;
//        public double debt;
//        public double credit;
//        public DateNizek dateForChart;
//
//        public DayModel(DateNizek dateForChart) {
//            this.dateForChart = dateForChart;
//        }
//
//
//// adds to list if its not added before
//        public void addDayModel(DateNizek dateNz) {
//            for (DayModel days : listOfDays) {
//                if (days.dateForChart != dateNz) {
//                    listOfDays.add(new DayModel(dateNz));
//                }else{
//                
//                
//                
//                }
//            }
//
//        }
//
//     public  DayModel dayReturner(DateNizek selectedDate) {
//
//            for (DayModel day : listOfDays) {
//
//                if (day.dateForChart.equals(selectedDate)) {
//                    return day;
//                }
//            }
//            return null;
//        }
//
//    }
}
