package DesignPattern.StateDesignPattern.DocumentWorkflowSystems;

public class ApprovedState implements DocumentState {
    @Override
    public void review(Document document) {
        System.out.println("Cannot review. Document is already approved.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Document is already approved.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject. Document is already approved.");
    }

    @Override
    public void submit(Document document) {
        System.out.println("Cannot submit. Document is already approved.");
    }

    @Override
    public String getStateName() {
        return "Approved";
    }
}
