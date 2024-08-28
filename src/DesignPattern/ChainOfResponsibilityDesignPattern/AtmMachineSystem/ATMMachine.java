package DesignPattern.ChainOfResponsibilityDesignPattern.AtmMachineSystem;

public class ATMMachine {
    public static void main(String[] args) {
        // Create handlers
        ATMHandler cashWithdrawal = new CashWithdrawalHandler();
        ATMHandler balanceInquiry = new BalanceInquiryHandler();
        ATMHandler pinChange = new PINChangeHandler();
        ATMHandler depositMoney = new DepositMoneyHandler();
        ATMHandler invalidRequest = new InvalidRequestHandler();

        // Set up the chain
        cashWithdrawal.setNextHandler(balanceInquiry);
        balanceInquiry.setNextHandler(pinChange);
        pinChange.setNextHandler(depositMoney);
        depositMoney.setNextHandler(invalidRequest);

        // Create requests
        ATMRequest request1 = new ATMRequest("withdraw", 100.0);
        cashWithdrawal.handleRequest(request1);

        ATMRequest request2 = new ATMRequest("balance", 0);
        cashWithdrawal.handleRequest(request2);

        ATMRequest request3 = new ATMRequest("pinchange", 0);
        cashWithdrawal.handleRequest(request3);

        ATMRequest request4 = new ATMRequest("deposit", 200.0);
        cashWithdrawal.handleRequest(request4);

        ATMRequest request5 = new ATMRequest("transfer", 500.0);  // Invalid request
        cashWithdrawal.handleRequest(request5);
    }
}
