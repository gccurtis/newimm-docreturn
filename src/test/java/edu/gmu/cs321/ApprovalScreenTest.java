package edu.gmu.cs321;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import edu.gmu.cs321.ImmReqForm;


public class ApprovalScreenTest {
    /**
     * Checks that email handler was created.
     */
    @Test
    public void validateEmailHandlerCreated() {
        Workflow wf = new Workflow();
        ImmReqForm userData = new ImmReqForm("first", "middle", "last", LocalDate.of(2000, 1, 1), 1, "test@email.com",
                "race", "gender", "document");

        ApprovalScreen testAScreen = new ApprovalScreen(userData, wf);
        assertTrue(testAScreen.hasEmailHandler());
    }

    /**
     * Checks that user data is accessible
     */
    @Test
    public void validateUserDataAccessible() {
        Workflow wf = new Workflow();
        ImmReqForm userData = new ImmReqForm("first", "middle", "last", LocalDate.of(2000, 1, 1), 1, "test@email.com",
                "race", "gender", "document");

        ApprovalScreen testAScreen = new ApprovalScreen(userData, wf);
        assertTrue(testAScreen.getUserData() != null);
    }

    /**
     * Checks that workflow is accessible
     */
    @Test
    public void validateWorkflowAccessible() {
        Workflow wf = new Workflow();
        ImmReqForm userData = new ImmReqForm("first", "middle", "last", LocalDate.of(2000, 1, 1), 1, "test@email.com",
                "race", "gender", "document");

        ApprovalScreen testAScreen = new ApprovalScreen(userData, wf);
        assertTrue(testAScreen.getWorkflow() != null);
    }

    /**
     * Checks that start screen creates review context
     */
    @Test
    public void validateReviewContext() {
        Workflow wf = new Workflow();
        ImmReqForm userData = new ImmReqForm("first", "middle", "last", LocalDate.of(2000, 1, 1), 1, "test@email.com",
                "race", "gender", "document");

        ApprovalScreen testAScreen = new ApprovalScreen(userData, wf);
        testAScreen.startScreen();
        assertTrue(testAScreen.getReviewContext().equals("Test"));
    }

    /**
     * Checks that start screen creates approval decision
     */
    @Test
    public void validateApprovalDecision() {
        Workflow wf = new Workflow();
        ImmReqForm userData = new ImmReqForm("first", "middle", "last", LocalDate.of(2000, 1, 1), 1, "test@email.com",
                "race", "gender", "document");

        ApprovalScreen testAScreen = new ApprovalScreen(userData, wf);
        testAScreen.startScreen();
        assertTrue(!testAScreen.getApprovalDecision());
    }
}