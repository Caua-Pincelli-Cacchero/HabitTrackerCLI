package habittracker.user;

public class User {

    private String username;
    private String password;
    private int totalTimeSpentiInSocialMedia;
    private int dayTimeSpentInSocialMedia;
    private int limitTimeSpentInSocialMedia;

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

    public int getTotalTimeSpentiInSocialMedia() {
        return totalTimeSpentiInSocialMedia;
    }

    public void setTotalTimeSpentiInSocialMedia(int totalTimeSpentiInSocialMedia) {
        this.totalTimeSpentiInSocialMedia = totalTimeSpentiInSocialMedia;
    }

    public int getDayTimeSpentInSocialMedia() {
        return dayTimeSpentInSocialMedia;
    }

    public void setDayTimeSpentInSocialMedia(int dayTimeSpentInSocialMedia) {
        this.dayTimeSpentInSocialMedia = dayTimeSpentInSocialMedia;
    }

    public int getLimitTimeSpentInSocialMedia() {
        return limitTimeSpentInSocialMedia;
    }

    public void setLimitTimeSpentInSocialMedia(int limitTimeSpentInSocialMedia) {
        this.limitTimeSpentInSocialMedia = limitTimeSpentInSocialMedia;
    }

    public User(String username, String password, int limitTimeSpentInSocialMedia) {
        this.username = username;
        this.password = password;
        this.limitTimeSpentInSocialMedia = limitTimeSpentInSocialMedia;
    }




}
