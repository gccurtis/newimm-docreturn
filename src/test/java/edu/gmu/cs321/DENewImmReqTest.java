package edu.gmu.cs321;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.time.LocalDate;

public class DENewImmReqTest {
    /**
     * Checks that the firstName field is validated with validateWord
     */
    @Test
    public void checkValidateFirstName() {
        ImmReqForm testForm = new ImmReqForm("first", null, null, null, 0, null, null, null, null);
        assertTrue(DENewImmReq.validateWord(testForm.getFirstName()));
    }

    /**
     * Checks that the middleName field is validated with validateWord
     */
    @Test
    public void checkValidateMiddleName() {
        ImmReqForm testForm = new ImmReqForm(null, "middle", null, null, 0, null, null, null, null);
        assertTrue(DENewImmReq.validateWord(testForm.getMiddleName()));
    }

    /**
     * Checks that the lastName field is validated with validateWord
     */
    @Test
    public void checkValidateLastName() {
        ImmReqForm testForm = new ImmReqForm(null, null, "last", null, 0, null, null, null, null);
        assertTrue(DENewImmReq.validateWord(testForm.getLastName()));
    }

    /**
     * Checks that the dateOfBirth field is validated with validateDOB
     */
    @Test
    public void checkValidateDOB() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, LocalDate.of(2000, 1, 1), 0, null, null, null, null);
        assertTrue(DENewImmReq.validateDOB(testForm.getDateOfBirth()));
    }

    /**
     * Checks that the ID field is validated with validateID
     */
    @Test
    public void checkValidateID() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 1, null, null, null, null);
        assertTrue(DENewImmReq.validateID(testForm.getID()));
    }

    /**
     * Checks that the email field is validated with validateEmail
     */
    @Test
    public void checkValidateEmail() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, "test@email.com", null, null, null);
        assertTrue(DENewImmReq.validateEmail(testForm.getEmail()));
    }

    /**
     * Checks that the race field is validated with validateWord
     */
    @Test
    public void checkValidateRace() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, null, "race", null, null);
        assertTrue(DENewImmReq.validateWord(testForm.getRace()));
    }

    /**
     * Checks that the gender field is validated with validateWord
     */
    @Test
    public void checkValidateGender() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, null, null, "gender", null);
        assertTrue(DENewImmReq.validateWord(testForm.getGender()));
    }

    /**
     * Checks that the requestedDoc field is validated with validateWord
     */
    @Test
    public void checkValidateDocument() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, null, null, null, "document");
        assertTrue(DENewImmReq.validateWord(testForm.getRequestedDoc()));
    }
}
