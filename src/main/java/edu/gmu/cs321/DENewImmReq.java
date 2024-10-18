package edu.gmu.cs321;

import java.time.LocalDate;

public class DENewImmReq {
    public ImmReqForm newImmReqForm(String firstName, String middleName, String lastName, LocalDate dateOfBirth, int ID,
            String email, String race, String gender, String requestedForm) {
        return new ImmReqForm(firstName, middleName, lastName, dateOfBirth, ID, email, race, gender, requestedForm);
    }
}
