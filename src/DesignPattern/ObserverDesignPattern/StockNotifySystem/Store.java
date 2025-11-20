package DesignPattern.ObserverDesignPattern.StockNotifySystem;

import DesignPattern.ObserverDesignPattern.StockNotifySystem.Observable.IphoneObservableImpl;
import DesignPattern.ObserverDesignPattern.StockNotifySystem.Observable.StockObservable;
import DesignPattern.ObserverDesignPattern.StockNotifySystem.Observer.EmailAlertObserverImpl;
import DesignPattern.ObserverDesignPattern.StockNotifySystem.Observer.MobileAlertObserverImpl;
import DesignPattern.ObserverDesignPattern.StockNotifySystem.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StockObservable stockObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("vinay1@gmail.com", stockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("aditya@gmail.com", stockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("pawan.kr", stockObservable);

        //stockObservable.add(observer1);
        //stockObservable.add(observer2);
        //stockObservable.add(observer3);

        stockObservable.setStockCount(10);
        //stockObservable.setStockCount(5);
    }
}
