package Feb22;

class MotorVehicle {
    String modelName, modelNumber;
    float modelPrice;

    MotorVehicle(String modelName, String modelNumber, float modelPrice) {
        this.modelName = modelName;
        this.modelNumber = modelNumber;
        this.modelPrice = modelPrice;
    }

    void display() {
        System.out.println("Model Name: " + modelName);
        System.out.println("Model Number: " + modelNumber);
        System.out.println("Model Price: " + modelPrice);
    }
}

class Car extends MotorVehicle {

    double discountRate;

    Car(String modelName, String modelNumber, float modelPrice, double discountRate) {
        super(modelName, modelNumber, modelPrice);
        this.discountRate = discountRate;
    }

    double discount() {
        return modelPrice * discountRate;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Discount ");
    }
}