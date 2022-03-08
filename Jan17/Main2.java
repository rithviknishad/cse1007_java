package Jan17;

class Flat {
    int flatNumber, floorNumber;
    double length, breadth;

    void init(int flatNumber, int floorNumber, double length, double breadth) {
        this.flatNumber = flatNumber;
        this.floorNumber = floorNumber;
        this.length = length;
        this.breadth = breadth;
    }

    double square_feet() {
        return length * breadth;
    }

    double maintenanceCharges() {
        return square_feet() * 1.25;
    }

    double commonCharges() {
        return maintenanceCharges() * 0.1;
    }

    void showDetails() {
        System.out.println(flatNumber + "(Floor#" + floorNumber + ") " + length + "x" + breadth + " ft");
    }

}

public class Main2 {
    public static void main(String[] args) {

        Flat[] flats = new Flat[3];

        flats[0] = new Flat();
        flats[0].init(101, 1, 10, 20);

        flats[1] = new Flat();
        flats[1].init(801, 8, 8, 9);

        flats[2] = new Flat();
        flats[2].init(1201, 12, 13, 14);

        double totalMaintenanceCharges = 0;
        Flat maxMaintenanceAmountFlat = flats[0];

        for (int i = 0; i < 3; ++i) {

            double mc = flats[i].maintenanceCharges();

            System.out.println("Flat " + flats[i].flatNumber + ", maintenance charges = INR " + mc);

            if (mc <= maxMaintenanceAmountFlat.maintenanceCharges()) {
                maxMaintenanceAmountFlat = flats[i];
            }

            totalMaintenanceCharges += mc + flats[i].commonCharges();
        }

        System.out.println("Final maintenance charges = INR " + totalMaintenanceCharges);

        System.out.print("Maximum maintenance amount paid by: ");
        maxMaintenanceAmountFlat.showDetails();

    }
}
