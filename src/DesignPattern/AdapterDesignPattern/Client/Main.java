package DesignPattern.AdapterDesignPattern.Client;

import DesignPattern.AdapterDesignPattern.Adaptee.WeightMachineForBabies;
import DesignPattern.AdapterDesignPattern.Adapter.WeightMachineAdapter;
import DesignPattern.AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String args[]){

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }

}
