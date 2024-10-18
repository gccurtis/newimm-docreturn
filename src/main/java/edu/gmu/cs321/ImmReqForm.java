package edu.gmu.cs321;

import java.time.LocalDate;

public class ImmReqForm {
    /**
     * The first name of the immigrant
     */
    private String firstName;
    /**
     * The middle name of the immigrant
     */
    private String middleName;
    /**
     * The last name of the immigrant
     */
    private String lastName;
    /**
     * The date of birth of the immigrant
     */
    private LocalDate dateOfBirth;
    /**
     * The ID of the immigrant
     */
    private int ID;
    /**
     * The email of the immigrant
     */
    private String email;
    /**
     * The race of the immigrant
     */
    private String race;
    /**
     * The gender of the immigrant
     */
    private String gender;
    /**
     * The document which the immigrant is requested being returned
     */
    private String requestedDoc;

    /**
     * The constructor for the immigrant request form
     */
    public ImmReqForm(String firstName, String middleName, String lastName, LocalDate dateOfBirth, int ID, String email,
            String race, String gender, String requestedDoc) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.ID = ID;
        this.email = email;
        this.race = race;
        this.gender = gender;
        this.requestedDoc = requestedDoc;
    }

    /**
     * @return returns the stored first name of the immigrant request form
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName sets the stored first name of the immigrant request form to
     *                  firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return returns the stored middle name of the immigrant request form
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName sets the stored middle name of the immigrant request form
     *                   to middleName
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return returns the stored last name of the immigrant request form
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName sets the stored last name of the immigrant request form to
     *                 lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return returns the stored date of birth of the immigrant request form
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth sets the stored date of birth of the immigrant request
     *                    form to dateOfBirth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return returns the stored ID of the immigrant request form
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID sets the stored ID of the immigrant request form to ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return returns the stored email of the immigrant request form
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email sets the stored email of the immigrant request form to email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return returns the stored race of the immigrant request form
     */
    public String getRace() {
        return race;
    }

    /**
     * @param race sets the stored race of the immigrant request form to race
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * @return returns the stored gender of the immigrant request form
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender sets the stored gender of the immigrant request form to gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return returns the stored requested document of the immigrant request form
     */
    public String getRequestedDoc() {
        return requestedDoc;
    }

    /**
     * @param requestedDoc sets the stored requested document of the immigrant
     *                     request form to requestedDoc
     */
    public void setRequestedDoc(String requestedDoc) {
        this.requestedDoc = requestedDoc;
    }

    /**
     * @return returns true if all the fields of the immigrant request form pass
     *         basic validation checks, false otherwise
     */
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

        if (!ImmReqValidator.validateWord(requestedDoc)) {
            return false;
        }

        return true;
    }

    /**
     * @return returns true if the immigrant request form has been successfully
     *         saved to the database, false otherwise
     * 
     *         (DATABASE NOT YET IMPLEMENTED)
     */
    public boolean saveImmReqForm() {
        return true;
    }

    public static class ImmReqValidator {
        /**
         * @param word word is the word being validated
         * @return returns true if word isn't null or an empty string, false
         *         otherwise
         */
        public static boolean validateWord(String word) {
            if ((word == null) || (word.length() < 1))
                return false;
            return true;
        }

        /**
         * @param dateOfBirth dateOfBirth is the date of birth being validated
         * @return returns true if dateOfBirth isn't null, false otherwise
         */
        public static boolean validateDOB(LocalDate dateOfBirth) {
            if (dateOfBirth == null)
                return false;
            return true;
        }

        /**
         * @param ID ID is the ID being validated
         * @return returns true if ID exists and is greater than 0, false otherwise
         */
        public static boolean validateID(int ID) {
            if (ID < 0)
                return false;
            return true;
        }

        /**
         * @param email email is the email being validated
         * @return returns true if email isn't null and contains the "@" and "."
         *         characters, false otherwise
         */
        public static boolean validateEmail(String email) {
            if ((email == null) || (!email.contains("@")) || (!email.contains(".")))
                return false;
            return true;
        }
    }
}
