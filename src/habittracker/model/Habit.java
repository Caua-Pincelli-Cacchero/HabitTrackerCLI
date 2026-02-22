package habittracker.model;

import java.time.LocalDate;

public class Habit {
    private int id;
    private int userId;
    private String socialMedia;
    private int totalTimeSpentInEspecificSocialMedia;
    private int dayTimeSpentInSocialMedia;
    private LocalDate dayOfHabit;

    public Habit(String socialMedia, int dayTimeSpentInSocialMedia, int  totalTimeSpentInSocialMedia, LocalDate dayOfHabit, int UserId) {
        this.socialMedia = socialMedia;
        this.dayTimeSpentInSocialMedia = dayTimeSpentInSocialMedia;
        this.totalTimeSpentInEspecificSocialMedia = totalTimeSpentInSocialMedia;
        this.dayOfHabit = dayOfHabit;
        this.userId = UserId;
    }
        public int getTotalTimeSpentInEspecificSocialMedia() {
        return totalTimeSpentInEspecificSocialMedia;
    }

    public void setTotalTimeSpentInEspecificSocialMedia(int totalTimeSpentInEspecificSocialMedia) {
        this.totalTimeSpentInEspecificSocialMedia = totalTimeSpentInEspecificSocialMedia;
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

    public LocalDate getDayOfHabit() {
        return dayOfHabit;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDayOfHabit(LocalDate dayOfHabit) {
        this.dayOfHabit = dayOfHabit;
    }

    public void setDayTimeSpentInSocialMedia(int dayTimeSpentInSocialMedia) {
        this.dayTimeSpentInSocialMedia = dayTimeSpentInSocialMedia;
    }
}
