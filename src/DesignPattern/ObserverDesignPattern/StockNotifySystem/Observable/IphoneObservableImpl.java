package DesignPattern.ObserverDesignPattern.StockNotifySystem.Observable;

import DesignPattern.ObserverDesignPattern.StockNotifySystem.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount=0;
    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        observerList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        observerList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver notificationAlertObserver:observerList){
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(stockCount==0){
            stockCount+=newStockAdded;
            notifySubscribers();
        }
        //stockCount=0;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
