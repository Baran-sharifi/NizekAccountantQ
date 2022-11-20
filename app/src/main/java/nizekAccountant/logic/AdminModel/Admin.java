package nizekAccountant.logic.AdminModel;

public class Admin {
    private String name;
    private String email;
    private String password;
    private final String filePath = "C:\\csvProject\\admin.csv";

    public Admin(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFilePath() {
        return filePath;
    }
}
