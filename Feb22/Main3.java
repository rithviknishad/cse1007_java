package Feb22;

interface Exam {
    float percent_cal();
}

class Student {
    String name;
    int rollNo;
    float marks1, marks2;

    void show() {
        System.out.print("(" + rollNo + ") " + name + " ");
    }
}

class Result extends Student implements Exam {
    Result(String name, int rollNo, float marks1, float marks2) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks1 = marks1;
        this.marks2 = marks2;
    }

    @Override
    public float percent_cal() {
        return marks1 * 100 / marks2;
    }

    void display() {
        show();
        System.out.println(percent_cal() + "%");
    }
}

public class Main3 {
    public static void main(String[] args) {
        Result results[] = {
                new Result("John", 12, 91, 100),
                new Result("Juhn", 13, 92, 100),
                new Result("Jahn", 14, 93, 100),
                new Result("Jihn", 15, 94, 100),
        };
        Result highest = results[0];
        for (Result result : results)
            if (result.percent_cal() < highest.percent_cal())
                highest = result;

    }
}
