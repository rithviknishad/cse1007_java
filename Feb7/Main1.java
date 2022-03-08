package Feb7;

import java.util.Scanner;

class Employee {
    int empId;
    String name;
    String designation;

    Employee(int empId, String name, String designation) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
    }

    void display() {
        System.out.println("Employee ID:  " + empId);
        System.out.println("Name:         " + name);
        System.out.println("Designation:  " + designation);
    }
}

class PermanentEmployee extends Employee {

    static int empIdCounter = 50000;

    int basicPay;
    int hra = 8000;
    double dailyAllowance;
    double bonus;
    double grossPay;
    double netPay;

    PermanentEmployee(String name, String designation, int basicPay) {
        super(empIdCounter++, name, designation);
        this.basicPay = basicPay;

        this.dailyAllowance = basicPay * 0.15;
        this.bonus = dailyAllowance * 0.05;

        this.grossPay = basicPay + dailyAllowance + hra + bonus;
        this.netPay = grossPay * 0.98 - 1250;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Type:         Permanent");
        System.out.println("Basic Pay:    " + basicPay);
        System.out.println("Gross Pay:    " + grossPay);
        System.out.println("Net Pay:      " + netPay);
    }
}

class TemporaryEmployee extends Employee {

    static int empIdCounter = 10000;

    int salaryPerHour;
    int totalHours;

    int totalSalary;

    TemporaryEmployee(String name, String designation, int salaryPerHour, int totalHours) {
        super(empIdCounter++, name, designation);
        this.salaryPerHour = salaryPerHour;
        this.totalHours = totalHours;

        this.totalSalary = salaryPerHour * totalHours;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Type:         Permanent");
        System.out.println("Salary / hr:  " + salaryPerHour);
        System.out.println("Total Hours:  " + totalHours);
        System.out.println("Total Salary: " + totalSalary);
    }
}

public class Main1 {

    static void employeesInIdRange(Employee[] employees) {

        Scanner in = new Scanner(System.in);

        System.out.print("Employee ID (lower): ");
        int lowerEmpId = Integer.parseInt(in.nextLine().trim());

        System.out.print("Employee ID (upper): ");
        int upperEmpId = Integer.parseInt(in.nextLine().trim());

        in.close();

        for (Employee e : employees) {
            if (lowerEmpId > e.empId || e.empId > upperEmpId)
                continue;
            if (!(e instanceof PermanentEmployee))
                continue;

            System.out.println();
            e.display();
            System.out.println();
        }
    }

    static void employeesSalaryAbove20000(Employee[] employees) {
        for (Employee e : employees) {
            if (!(e instanceof TemporaryEmployee))
                continue;
            if (((TemporaryEmployee) e).totalSalary < 20000)
                continue;
            System.out.println(e.name);
        }
    }

    static void managersNetPayAndId(Employee[] employees) {
        for (Employee e : employees) {
            if (!(e instanceof PermanentEmployee))
                continue;
            if (!e.designation.toLowerCase().equals("manager"))
                continue;

            System.out.println("NP: " + ((PermanentEmployee) e).netPay + ", EmpId: " + e.empId);
        }
    }

    public static void main(String[] args) {

        Employee employees[] = {
                new PermanentEmployee("Aravind", "Manager", 98000),
                new PermanentEmployee("Vignesh", "Clerk", 70000),
                new PermanentEmployee("Gigin", "Accountant", 80000),
                new TemporaryEmployee("Syam", "DevOps", 10000, 10),
                new TemporaryEmployee("Aparna", "Manager", 8000, 100),
        };

        System.out.println("Permanent Employees in ID range...");
        employeesInIdRange(employees);

        System.out.println();
        System.out.println("Temperory Employees whose salary above 20000...");
        employeesSalaryAbove20000(employees);

        System.out.println();
        System.out.println("Managers net pay and ID...");
        managersNetPayAndId(employees);

    }
}
