package murach.business;

import java.io.Serializable;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String hearAboutUs;
    private String[] announcements;
    private String contactBy;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        dateOfBirth = "";
        hearAboutUs = "";
        announcements = new String[0];
        contactBy = "";
    }

    // Giữ constructor cũ để code cũ vẫn chạy
    public User(String firstName, String lastName, String email) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String firstName, String lastName, String email,
                String dateOfBirth, String hearAboutUs,
                String[] announcements, String contactBy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.hearAboutUs = hearAboutUs;
        setAnnouncements(announcements);
        this.contactBy = contactBy;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

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