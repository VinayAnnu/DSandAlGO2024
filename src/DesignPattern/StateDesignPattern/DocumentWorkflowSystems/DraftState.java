package DesignPattern.StateDesignPattern.DocumentWorkflowSystems;

public class DraftState implements DocumentState {
    @Override
    public void review(Document document) {
        System.out.println("Cannot review. Document is still in draft.");
    }

    @Override
    public void approve(Document document) {
        System.out.println("Cannot approve. Document is still in draft.");
    }

    @Override
    public void reject(Document document) {
        System.out.println("Cannot reject. Document is still in draft.");
    }

    @Override
    public void submit(Document document) {
        System.out.println("Document submitted for review.");
        document.setState(new SubmittedState());
    }

    @Override
    public String getStateName() {
        return "Draft";
    }
}
