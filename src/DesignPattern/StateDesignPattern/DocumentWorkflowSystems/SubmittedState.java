package DesignPattern.StateDesignPattern.DocumentWorkflowSystems;

public class SubmittedState implements DocumentState {
    @Override
    public void review(Document document) {
        System.out.println("Document is being reviewed.");
        document.setState(new ReviewedState());
    }

    @Override
    public void approve(Document document) {
        System.out.println("Cannot approve. Document is not reviewed yet.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject. Document is not reviewed yet.");
    }

    @Override
    public void submit(Document document) {
        System.out.println("Document is already submitted.");
    }

    @Override
    public String getStateName() {
        return "Submitted";
    }
}
