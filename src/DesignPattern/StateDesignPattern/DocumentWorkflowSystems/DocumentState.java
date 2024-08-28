package DesignPattern.StateDesignPattern.DocumentWorkflowSystems;

public interface DocumentState {
    void review(Document document);
    void approve(Document document);
    void reject(Document document);
    void submit(Document document);
    String getStateName();
}
