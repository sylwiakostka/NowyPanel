package Employee;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
    private static int nextId;
    private int id;
    private String name;
    private double salary;
    private Date hireDay;

    //ustawianie id po kolei od 0
    {
        id = nextId;
        nextId++;
    }

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        // -1 bo kalendarz geogo ma ak ze styczen to 0
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary = salary + raise;
    }


}


