package murach.business;

import java.io.Serializable;

public class Survey implements Serializable {

    private User user;              // khảo sát này của ai
    private String hearAboutUs;
    private String[] announcements;
    private String contactBy;

    public Survey() {
        user = new User();
        hearAboutUs = "";
        announcements = new String[0];
        contactBy = "";
    }

    public Survey(User user, String hearAboutUs,
                  String[] announcements, String contactBy) {
        this.user = user;
        this.hearAboutUs = hearAboutUs;
        setAnnouncements(announcements);
        this.contactBy = contactBy;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getHearAboutUs() { return hearAboutUs; }
    public void setHearAboutUs(String hearAboutUs) { this.hearAboutUs = hearAboutUs; }

    public String[] getAnnouncements() { return announcements; }
    public void setAnnouncements(String[] announcements) {
        // getParameterValues trả null nếu không tick ô nào
        this.announcements = (announcements == null) ? new String[0] : announcements;
    }

    public String getContactBy() { return contactBy; }
    public void setContactBy(String contactBy) { this.contactBy = contactBy; }
}