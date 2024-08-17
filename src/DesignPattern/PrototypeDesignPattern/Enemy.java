package DesignPattern.PrototypeDesignPattern;

public interface Enemy extends Cloneable{
    Enemy clone();
    void attack();
    void defend();
}
