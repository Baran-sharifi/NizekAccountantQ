package nizekAccountant.logic.Login;

import nizekAccountant.logic.ModelManager.Manager;

public class Costumer {

    //ID variable to enable searching through Users!
    private String name;
    private String nationalID;
    private GroupType groupType; //needs to be overridden! we need to declare a type!
    private String address;
    private String phone;
    private String email;
    private int ID;
    private final String filePath = "C:\\csvProject\\costumerFile.csv";

    public Costumer(String name, String nationalID, GroupType groupType, String address, String phone, String email) {
        this.name = name;
        this.nationalID = nationalID;
        this.groupType = groupType;
        this.address = address;
        this.phone = phone;
        this.email = email;
        ID = Manager.costumerList.size();
    }

    public int getID() {
        return this.ID;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getName() {
        return name;
    }

    public String getNationalID() {
        return nationalID;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationalID(String id) {
        this.nationalID = id;
    }

    public void setgroupType(GroupType groupType) {
        this.groupType = groupType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Costumer{"
                + "name='" + name + '\''
                + ", nationalID='" + nationalID + '\''
                + ", groupType=" + groupType
                + ", address='" + address + '\''
                + ", phone='" + phone + '\''
                + ", email='" + email + '\''
                + ", ID=" + ID
                + ", filePath='" + filePath + '\''
                + '}';
    }
}
