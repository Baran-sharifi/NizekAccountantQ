package nizekAccountant.logic.Login;

public class GroupType {
    // a string
    // set string
    private String categoryName;

    public GroupType(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}