package com;

public class Main {
    public static void main(String[] args) {
       Factory carFactory=new AbstractFactory().createFactory("Car");
        Factory tankFactory=new AbstractFactory().createFactory("Tank");

        Car audi=carFactory.createCar("Audi");
        Car toyota=carFactory.createCar("Toyota");
        toyota.drive();
        audi.drive();

        Tank armata=tankFactory.createTank("Armata");
        Tank tiger=tankFactory.createTank("Tiger");

        armata.drive();
        tiger.drive();
    }
}

interface Car{
    void drive();
}
class Toyota implements Car{
    @Override
    public void drive() {
        System.out.println("Toyota drive");
    }
}
class Audi implements Car{
    @Override
    public void drive() {
        System.out.println("Audi drive");
    }
}

class CarFactory implements Factory{
    public Car createCar(String typeOfCar){
        switch(typeOfCar){
            case "Toyota": return new Toyota();
            case "Audi": return new Audi();
            default:  return  null;
        }
    }

    @Override
    public Tank createTank(String typeOfTank) {
        return null;
    }
}



interface Tank{
    void drive();
}
class Armata implements Tank{
    @Override
    public void drive() {
        System.out.println("Armata drive");
    }
}
class Tiger implements Tank{
    @Override
    public void drive() {
        System.out.println("Tiger drive");
    }
}

class TankFactory implements Factory{
    public Tank createTank(String typeOfTank){
        switch(typeOfTank){
            case "Armata": return new Armata();
            case "Tiger": return new Tiger();
            default:  return  null;
        }
    }

    @Override
    public Car createCar(String typeOfCar) {
        return null;
    }
}


interface Factory{
    Car createCar(String typeOfCar);
    Tank createTank(String typeOfTank);
}

class AbstractFactory{
    public Factory createFactory(String typeOfFactory){
        switch(typeOfFactory){
            case "Tank":return  new TankFactory();
            case "Car":return  new CarFactory();
            default:return null;
        }
    }
}
