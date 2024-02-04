package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    String emailId;
    StockObservable stockObservable;
    public EmailAlertObserverImpl(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendEmail(emailId,"Product is in stock.. Hurry up. Current stock is "+stockObservable.getStockCount());
    }

    private void sendEmail(String emailId, String s) {
        System.out.println(s+". "+"mail sent to : "+emailId);
    }
}
