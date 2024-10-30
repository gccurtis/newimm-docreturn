package edu.gmu.cs321;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.time.LocalDate;

public class ImmReqFormTest {
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
}
