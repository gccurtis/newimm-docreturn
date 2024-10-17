package edu.gmu.cs321;

import java.time.LocalDate;

public class ImmReqForm {
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int ID;
    private String email;
    private String race;
    private String gender;
    private String requestedForm;

    public ImmReqForm(String firstName, String middleName, String lastName, LocalDate dateOfBirth, int ID, String email,
            String race, String gender, String requestedForm) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.ID = ID;
        this.email = email;
        this.race = race;
        this.gender = gender;
        this.requestedForm = requestedForm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRequestedForm() {
        return requestedForm;
    }

    public void setRequestedForm(String requestedForm) {
        this.requestedForm = requestedForm;
    }

    public boolean validateNewImmReq() {
        if (!ImmReqValidator.validateWord(firstName)) {
            return false;
        }

        if (!ImmReqValidator.validateWord(middleName)) {
            return false;
        }

        if (!ImmReqValidator.validateWord(lastName)) {
            return false;
        }

        if (!ImmReqValidator.validateDOB(dateOfBirth)) {
            return false;
        }

        if (!ImmReqValidator.validateID(ID)) {
            return false;
        }

        if (!ImmReqValidator.validateEmail(email)) {
            return false;
        }

        if (!ImmReqValidator.validateWord(race)) {
            return false;
        }

        if (!ImmReqValidator.validateWord(gender)) {
            return false;
        }

        if (!ImmReqValidator.validateWord(requestedForm)) {
            return false;
        }

        return true;
    }

    public boolean saveImmReqForm() {
        return true;
    }

    private static class ImmReqValidator {
        private static boolean validateWord(String name) {
            if ((name == null) || (name.length() < 1))
                return false;
            return true;
        }

        private static boolean validateDOB(LocalDate dateOfBirth) {
            if (dateOfBirth == null)
                return false;
            return true;
        }

        private static boolean validateID(int ID) {
            if (ID < 0)
                return false;
            return true;
        }

        private static boolean validateEmail(String email) {
            if ((email == null) || (!email.contains("@")) || (!email.contains(".")))
                return false;
            return true;
        }
    }
}
