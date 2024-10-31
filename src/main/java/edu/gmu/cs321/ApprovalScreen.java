package edu.gmu.cs321;

public class ApprovalScreen {
    /**
     * The data which needs to be checked for approval.
     */
    private ImmReqForm userData;
    /**
     * Additional information necessary for a reviewer
     * to fix the data if rejected.
     */
    private String reviewContext;
    /**
     * A flag representing whether the data has been
     * approved or rejected.
     */
    private boolean approvalDecision;
    /**
     * The object necessary to send emails.
     */
    private EmailHandler emailHandler;
    /**
     * The object which connects work between data entry,
     * review, and approval.
     */
    private Workflow workflow;

    /**
     * Create the ApprovalScreen object and set up all
     * necessary objects.
     */
    public ApprovalScreen(ImmReqForm userData, Workflow workflow) {
        this.userData = userData;
        this.workflow = workflow;
        this.emailHandler = createEmailHandler(userData.getEmail());
    }

    /**
     * Create the email handler.
     */
    private EmailHandler createEmailHandler(String email) {
        return new EmailHandler(email);
    }

    public void startScreen() {
        /**
         * This is where UI code will go.
         */
        approvalDecision = false; // Just for testing.
        reviewContext = "TEST"; // Just for testing.
    }

    // Getter for userData
    public ImmReqForm getUserData() {
        return userData;
    }

    // Getter for reviewContext
    public String getReviewContext() {
        return reviewContext;
    }

    // Getter for approvalDecision
    public boolean getApprovalDecision() {
        return approvalDecision;
    }

    // Getter for workflow
    public Workflow getWorkflow() {
        return workflow;
    }

    // Prove emailHandler exists
    public boolean hasEmailHandler() {
        return (emailHandler != null);
    }
}
