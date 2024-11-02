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
    private int iD;
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
    public ImmReqForm(String firstName, String middleName, String lastName, LocalDate dateOfBirth, int iD, String email,
            String race, String gender, String requestedDoc) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.iD = iD;
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
        return iD;
    }

    /**
     * @param iD sets the stored ID of the immigrant request form to ID
     */
    public void setID(int iD) {
        this.iD = iD;
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
     * @return returns true if the immigrant request form has been successfully
     *         saved to the database, false otherwise
     * 
     *         (DATABASE NOT YET IMPLEMENTED)
     */
    public boolean saveImmReqForm() {
        return true;
    }

    /**
     * @return returns true if the immigrant request form has been successfully
     *         added to the workflow, false otherwise
     * 
     *         (WORKFLOW NOT YET IMPLEMENTED)
     */
    public boolean addWFItem() {
        return true;
    }
}
