package DesignPattern.StateDesignPattern.DocumentWorkflowSystems;

public class RejectedState implements DocumentState {
    @Override
    public void review(Document document) {
        System.out.println("Cannot review. Document is rejected.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Cannot approve. Document is rejected.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Document is already rejected.");
    }

    @Override
    public void submit(Document document) {
        System.out.println("Cannot submit. Document is rejected.");
    }

    @Override
    public String getStateName() {
        return "Rejected";
    }
}
