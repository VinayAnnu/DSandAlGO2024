package DesignPattern.StateDesignPattern.DocumentWorkflowSystems;

public class Document {
    private DocumentState state;
    public Document() {
        // Initial state is Draft
        this.state = new DraftState();
    }
    public void setState(DocumentState state) {
        this.state = state;
    }
    public void submit() {
        state.submit(this);
    }

    public void review() {
        state.review(this);
    }

    public void approve() {
        state.approve(this);
    }

    public void reject() {
        state.reject(this);
    }

    public String getStateName() {
        return state.getStateName();
    }
}
