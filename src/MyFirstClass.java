interface Fan {
    void turnOn();
    void turnOff();
    void increaseMode(int increment);
    void decreaseMode(int decrement);
    void printStates();
}


class MondialFan implements Fan {
    private boolean isOn = false;
    private int gear = 0;
    private int rpm = 0;

    public void turnOn(){
        if(isOn){
            System.out.println("Fan is already on\n");
            return;
        }
        isOn = true;
        gear = 1;
        rpm = 3200;
        System.out.println("Turned on\n");
    }

    public void turnOff(){
        if(!isOn){
            System.out.println("Fan is already off\n");
            return;
        }
        isOn = false;
        gear = 0;
        rpm = 0;
        System.out.println("Turned off\n");
    }

    public void increaseMode(int increment){
        if(increment + gear < 3 && increment > 0){
            gear += increment;
            rpm += increment * 3200;
            System.out.println("Fan incremented by " + increment);
            return;
        }
        System.out.println("Invalid increment\n");
    }
    public void decreaseMode(int decrement){if(decrement + gear >= 0 && decrement < 0){
            gear += decrement;
            rpm -= decrement * 3200;
            System.out.println("Fan decrement by " + decrement);
            return;
        }
        System.out.println("Invalid decrement\n");
    }

    public void printStates(){
        System.out.println("Is on: " + isOn + "gear: " + gear + "rpm: " + rpm);
    }
}

class CeilingFan extends MondialFan {
    boolean lampOn = false;

    public void turnLampOn(){
        if(lampOn){
            System.out.println("The lamp is already on\n");
            return;
        }
        lampOn = true;
    }
    public void turnLampOff(){
        if(!lampOn){
            System.out.println("The lamp is already off\n");
            return;
        }
        lampOn = false;
    }

    public void printStates(){
        super.printStates();
        System.out.println(" Lamp is on: " + lampOn);
    }
}

class MyFirstClass {
    public static void main(String[] args) {
        Fan ventilador = new MondialFan();
        CeilingFan ventiladorTeto = new CeilingFan();

        ventiladorTeto.turnOn();
        ventiladorTeto.turnLampOn();
        ventiladorTeto.increaseMode(1);
        ventiladorTeto.printStates();
        ventiladorTeto.turnOff();
        ventiladorTeto.turnLampOff();
        ventiladorTeto.printStates();


        ventilador.turnOn();
        ventilador.increaseMode(1);
        ventilador.increaseMode(3);
        ventilador.printStates();
        ventilador.turnOff();
        ventilador.printStates();
    }
}