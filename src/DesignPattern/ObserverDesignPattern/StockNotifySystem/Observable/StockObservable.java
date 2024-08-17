package DesignPattern.ObserverDesignPattern.StockNotifySystem.Observable;

import DesignPattern.ObserverDesignPattern.StockNotifySystem.Observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver notificationAlertObserver);
    public void remove(NotificationAlertObserver notificationAlertObserver);
    public void notifySubscribers();
    public void setStockCount(int newStockAdded);
    public int getStockCount();
}
