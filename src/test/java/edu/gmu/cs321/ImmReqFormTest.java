package edu.gmu.cs321;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import edu.gmu.cs321.ImmReqForm.ImmReqValidator;

import java.time.LocalDate;

public class ImmReqFormTest {
    /**
     * Checks that all fields are validated with validateNewImmReq
     */
    @Test
    public void checkValidateNewImmReq() {
        ImmReqForm testForm = new ImmReqForm("first", "middle", "last", LocalDate.of(2000, 1, 1), 1, "test@email.com",
                "race", "gender", "document");
        assertTrue(testForm.validateNewImmReq());
    }

    /**
     * Checks that saveImmReqForm saves the ImmReqForm to the database
     */
    @Test
    public void checkSaveImmReqForm() {
        ImmReqForm testForm = new ImmReqForm("first", "middle", "last", LocalDate.of(2000, 1, 1), 1, "test@email.com",
                "race", "gender", "document");
        assertTrue(testForm.saveImmReqForm());
    }

    /**
     * Checks that addWFItem adds the ImmReqForm to the Workflow
     */
    @Test
    public void checkAddWFItem() {
        ImmReqForm testForm = new ImmReqForm("first", "middle", "last", LocalDate.of(2000, 1, 1), 1, "test@email.com",
                "race", "gender", "document");
        assertTrue(testForm.addWFItem());
    }

    /**
     * Checks that the firstName field is validated with validateWord
     */
    @Test
    public void checkValidateFirstName() {
        ImmReqForm testForm = new ImmReqForm("first", null, null, null, 0, null, null, null, null);
        assertTrue(ImmReqValidator.validateWord(testForm.getFirstName()));
    }

    /**
     * Checks that the middleName field is validated with validateWord
     */
    @Test
    public void checkValidateMiddleName() {
        ImmReqForm testForm = new ImmReqForm(null, "middle", null, null, 0, null, null, null, null);
        assertTrue(ImmReqValidator.validateWord(testForm.getMiddleName()));
    }

    /**
     * Checks that the lastName field is validated with validateWord
     */
    @Test
    public void checkValidateLastName() {
        ImmReqForm testForm = new ImmReqForm(null, null, "last", null, 0, null, null, null, null);
        assertTrue(ImmReqValidator.validateWord(testForm.getLastName()));
    }

    /**
     * Checks that the dateOfBirth field is validated with validateDOB
     */
    @Test
    public void checkValidateDOB() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, LocalDate.of(2000, 1, 1), 0, null, null, null, null);
        assertTrue(ImmReqValidator.validateDOB(testForm.getDateOfBirth()));
    }

    /**
     * Checks that the ID field is validated with validateID
     */
    @Test
    public void checkValidateID() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 1, null, null, null, null);
        assertTrue(ImmReqValidator.validateID(testForm.getID()));
    }

    /**
     * Checks that the email field is validated with validateEmail
     */
    @Test
    public void checkValidateEmail() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, "test@email.com", null, null, null);
        assertTrue(ImmReqValidator.validateEmail(testForm.getEmail()));
    }

    /**
     * Checks that the race field is validated with validateWord
     */
    @Test
    public void checkValidateRace() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, null, "race", null, null);
        assertTrue(ImmReqValidator.validateWord(testForm.getRace()));
    }

    /**
     * Checks that the gender field is validated with validateWord
     */
    @Test
    public void checkValidateGender() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, null, null, "gender", null);
        assertTrue(ImmReqValidator.validateWord(testForm.getGender()));
    }

    /**
     * Checks that the requestedDoc field is validated with validateWord
     */
    @Test
    public void checkValidateDocument() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, null, null, null, "document");
        assertTrue(ImmReqValidator.validateWord(testForm.getRequestedDoc()));
    }
}
