package edu.gmu.cs321;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import edu.gmu.cs321.ImmReqForm.ImmReqValidator;

import java.time.LocalDate;

public class ImmReqFormTest {
    @Test
    public void checkValidateNewImmReq() {
        ImmReqForm testForm = new ImmReqForm("first", "middle", "last", LocalDate.of(2000, 1, 1), 1, "test@email.com",
                "race", "gender", "document");
        assertTrue(testForm.validateNewImmReq());
    }

    @Test
    public void checkSaveImmReqForm() {
        ImmReqForm testForm = new ImmReqForm("first", "middle", "last", LocalDate.of(2000, 1, 1), 1, "test@email.com",
                "race", "gender", "document");
        assertTrue(testForm.saveImmReqForm());
    }

    @Test
    public void checkAddWFItem() {
        ImmReqForm testForm = new ImmReqForm("first", "middle", "last", LocalDate.of(2000, 1, 1), 1, "test@email.com",
                "race", "gender", "document");
        assertTrue(testForm.addWFItem());
    }

    @Test
    public void checkValidateFirstName() {
        ImmReqForm testForm = new ImmReqForm("first", null, null, null, 0, null, null, null, null);
        assertTrue(ImmReqValidator.validateWord(testForm.getFirstName()));
    }

    @Test
    public void checkValidateMiddleName() {
        ImmReqForm testForm = new ImmReqForm(null, "middle", null, null, 0, null, null, null, null);
        assertTrue(ImmReqValidator.validateWord(testForm.getMiddleName()));
    }

    @Test
    public void checkValidateLastName() {
        ImmReqForm testForm = new ImmReqForm(null, null, "last", null, 0, null, null, null, null);
        assertTrue(ImmReqValidator.validateWord(testForm.getLastName()));
    }

    @Test
    public void checkValidateDOB() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, LocalDate.of(2000, 1, 1), 0, null, null, null, null);
        assertTrue(ImmReqValidator.validateDOB(testForm.getDateOfBirth()));
    }

    @Test
    public void checkValidateID() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 1, null, null, null, null);
        assertTrue(ImmReqValidator.validateID(testForm.getID()));
    }

    @Test
    public void checkValidateEmail() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, "test@email.com", null, null, null);
        assertTrue(ImmReqValidator.validateEmail(testForm.getEmail()));
    }

    @Test
    public void checkValidateRace() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, null, "race", null, null);
        assertTrue(ImmReqValidator.validateWord(testForm.getRace()));
    }

    @Test
    public void checkValidateGender() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, null, null, "gender", null);
        assertTrue(ImmReqValidator.validateWord(testForm.getGender()));
    }

    @Test
    public void checkValidateDocument() {
        ImmReqForm testForm = new ImmReqForm(null, null, null, null, 0, null, null, null, "document");
        assertTrue(ImmReqValidator.validateWord(testForm.getRequestedDoc()));
    }
}
