package Jan17;

class Date {
    int day, month, year;
    int dayOfWeek;

    void init(int day, int month, int year, int dayOfWeek) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.dayOfWeek = dayOfWeek;
    }

    String nameOfDay() {
        return daysOfWeek[dayOfWeek % 7];
    }

    double difference(Date other) {
        int dy = year - other.year;
        int dm = month - other.month;
        int dd = day - other.day;

        return dy * 365.25 + dm * 30 + dd;
    }

    void display() {
        System.out.println(day + "/" + month + "/" + year);
    }

    static String[] daysOfWeek = {
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
    };
}

public class Main1 {
    public static void main(String[] args) {

        Date date1 = new Date();
        Date date2 = new Date();

        date1.init(12, 12, 2012, 3);
        date2.init(14, 12, 2012, 5);

        System.out.println(Date.daysOfWeek[(date1.dayOfWeek + 3) % 7]);
        System.out.println(Date.daysOfWeek[(date2.dayOfWeek + 3) % 7]);

        System.out.println("Days difference: " + date1.difference(date2));

        date1.display();
        date2.display();

    }
}
