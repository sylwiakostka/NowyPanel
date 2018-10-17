package Employee;

import java.util.ArrayList;

public class ConstructorTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Hubert", 400000, 1987, 12, 15);
        staff[1] = new Employee("Tomasz", 35000, 1980, 11, 02);
        staff[2] = new Employee("Kazio", 25000, 1990, 10, 23);
//wydruk info o wszystkich obiektach e - kazdy element tablicy. klasa dot tej tablicy to Emploee
        for (Employee e : staff)
            System.out.println("name: " + e.getName() + " id: " + e.getId() + " salary: " + e.getSalary() + "  data zatrudnienia: " + e.getHireDay());

//zwiekszenie pensji wszystkim o 10%
        for (Employee e : staff) {
            e.raiseSalary(10);
            System.out.println("name: " + e.getName() + " salary: " + e.getSalary());
        }

    }
}


// to samo ale z ArrayList

class ArrayListTest {
    public static void main(String[] args) {
        //wstawianie do listy staff 3 obiektów klasy Employee
        ArrayList<Employee> staff = new ArrayList<Employee>();
        staff.add(new Employee("Julian", 44000, 1997, 5, 3));
        staff.add(new Employee("Marek", 48000, 1988, 11, 18));
        staff.add(new Employee("Wojtek", 49000, 1994, 3, 3));

        //zwiększenie pensji o 15%
        for (Employee e : staff)
            e.raiseSalary(15);

        //Drukowanie info o wszystkich obiektach Employee
        for (Employee e : staff)
            System.out.println("name: " + e.getName() + " salary: " + e.getSalary() + " data zatrudnienia: " + e.getHireDay());

        


    }


}
