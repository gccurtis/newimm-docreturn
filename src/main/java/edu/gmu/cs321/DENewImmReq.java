package edu.gmu.cs321;

import java.time.LocalDate;

public class DENewImmReq {

    /**
     * @param firstName    firstName will be the stored first name
     * @param middleName   middleName will be the stored middle name
     * @param lastName     lastName will be the stored last name
     * @param dateOfBirth  dateOfBirth will be the stored date of birth
     * @param ID           ID will be the stored ID
     * @param email        email will be the stored email
     * @param race         race will be the stored race
     * @param gender       gender will be the stored race
     * @param requestedDoc requestedDoc will be the stored requested document
     * @return returns a new ImmReqForm created using the passed parameters
     * 
     *         (User input needs to be collected from the UI)
     */
    public ImmReqForm newImmReqForm(String firstName, String middleName, String lastName, LocalDate dateOfBirth, int ID,
            String email, String race, String gender, String requestedDoc) {
        return new ImmReqForm(firstName, middleName, lastName, dateOfBirth, ID, email, race, gender, requestedDoc);
    }
}
