package DesignPattern.CommandDesignPattern;

public class AirConditioner {
    boolean isOn;
    int temperature;
    public void turnOnAc(){
        this.isOn = true;
        System.out.println("AC is ON");
    }
    public void turnOffAc(){
        this.isOn = false;
        System.out.println("AC is OFF");
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
        System.out.println("Temperature changed to : "+temperature);
    }
}
