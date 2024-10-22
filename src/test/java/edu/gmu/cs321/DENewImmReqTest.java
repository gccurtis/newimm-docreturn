package edu.gmu.cs321;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.time.LocalDate;

public class DENewImmReqTest {
    /**
     * Checks that newImmReqForm creates an ImmReqForm
     */
    @Test
    public void checkNewImmReqForm() {
        DENewImmReq testDE = new DENewImmReq();
        ImmReqForm testForm = testDE.newImmReqForm(null, null, null, null, 0, null, null, null, null);
        assertTrue(testForm != null);
    }
}
