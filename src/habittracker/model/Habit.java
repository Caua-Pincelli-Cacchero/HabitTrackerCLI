package habittracker.model;

public class Habit {
    private int id;
    private int UserId;
    private String socialMedia;
    private int totalTimeSpentInSocialMedia;
    private int dayTimeSpentInSocialMedia;

    public Habit(String socialMedia, int dayTimeSpentInSocialMedia, int UserId) {
        this.socialMedia = socialMedia;
        this.dayTimeSpentInSocialMedia = dayTimeSpentInSocialMedia;
        this.UserId = UserId;
    }
    public int getTotalTimeSpentInSocialMedia() {
        return totalTimeSpentInSocialMedia;
    }

    public void setTotalTimeSpentInSocialMedia(int totalTimeSpentInSocialMedia) {
        this.totalTimeSpentInSocialMedia = totalTimeSpentInSocialMedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }

    public int getDayTimeSpentInSocialMedia() {
        return dayTimeSpentInSocialMedia;
    }

    public void setDayTimeSpentInSocialMedia(int dayTimeSpentInSocialMedia) {
        this.dayTimeSpentInSocialMedia = dayTimeSpentInSocialMedia;
    }
}
