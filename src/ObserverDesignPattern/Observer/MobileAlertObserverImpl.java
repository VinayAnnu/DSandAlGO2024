package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    String userName;
    StockObservable stockObservable;

    public MobileAlertObserverImpl(String userName, StockObservable stockObservable) {
        this.userName = userName;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName, "Product is in stock.. Hurry up. Current stock is "+stockObservable.getStockCount());
    }

    private void sendMsgOnMobile(String userName, String s) {
        System.out.println("msg sent to "+userName+" Message : "+s);
    }
}
