package DesignPattern.StateDesignPattern.DocumentWorkflowSystems;

public class ReviewedState implements DocumentState {
    @Override
    public void review(Document document) {
        System.out.println("Document is already reviewed.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Document is approved.");
        document.setState(new ApprovedState());
    }

    @Override
    public void reject(Document document) {
        System.out.println("Document is rejected.");
        document.setState(new RejectedState());
    }

    @Override
    public void submit(Document document) {
        System.out.println("Cannot submit. Document is already reviewed.");
    }

    @Override
    public String getStateName() {
        return "Reviewed";
    }
}
