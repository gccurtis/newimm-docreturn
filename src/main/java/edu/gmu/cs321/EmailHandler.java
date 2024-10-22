package edu.gmu.cs321;

public class EmailHandler {
    // Representation of email object.
    private String email;

    /**
     * Create the EmailHandler object
     * and testing email setup.
     */
    public EmailHandler(String email) {
        this.email = email;
    }

    // Getter for email
    public String getEmail() {
        return this.email;
    }
}
