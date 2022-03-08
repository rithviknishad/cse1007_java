package Feb22;

abstract class Shape {
    abstract public double getArea();

    abstract public double getPerimeter();
}

class Rectangle extends Shape {
    public double length, breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double getArea() {
        return length * breadth;
    }

    @Override
    public double getPerimeter() {
        return 2 * length * breadth;
    }
}

class Triangle extends Shape {
    public double s0, s1, s2;

    Triangle(double s0, double s1, double s2) {
        this.s0 = s0;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public double getPerimeter() {
        return s0 + s1 + s2;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - s0) * (s - s1) * (s - s2));
    }
}

public class Main1 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(23, 22);
        Triangle tria = new Triangle(15, 13, 13);
        System.out.println("Rectangle perimeter=" + rect.getPerimeter() + ", area=" + rect.getArea());
        System.out.println("Triangle perimeter=" + tria.getPerimeter() + ", area=" + tria.getArea());
    }
}
