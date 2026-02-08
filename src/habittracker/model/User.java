package habittracker.model;

public class User {
    int id;
    private String username;
    private String password;
    private int limitTimeSpentInSocialMediaPerDay;

    public int getLimitTimeSpentInSocialMediaPerDay() {
        return limitTimeSpentInSocialMediaPerDay;
    }

    public void setLimitTimeSpentInSocialMediaPerDay(int limitTimeSpentInSocialMediaPerDay) {
        this.limitTimeSpentInSocialMediaPerDay = limitTimeSpentInSocialMediaPerDay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
