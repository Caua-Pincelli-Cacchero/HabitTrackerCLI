package habittracker.model;

public class Habit {
    private int id;
    private String socialMedia;
    private int totalTimeSpentInSocialMedia;
    private int dayTimeSpentInSocialMedia;

    public int getTotalTimeSpentInSocialMedia() {
        return totalTimeSpentInSocialMedia;
    }

    public void setTotalTimeSpentInSocialMedia(int totalTimeSpentInSocialMedia) {
        this.totalTimeSpentInSocialMedia = totalTimeSpentInSocialMedia;
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
