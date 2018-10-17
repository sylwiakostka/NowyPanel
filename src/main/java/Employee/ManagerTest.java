package Employee;

public class ManagerTest {
    public static void main(String[] args) {
        //Twozenie obiektu klasy Manager
        Manager boss = new Manager("Julian Waś", 80000, 1986, 9, 12);
        boss.setBonus(5000);

        //tworze tablice staff
        Employee[] staff = new Employee[3];

        //wstawienie obiektow klasy manager y employee do tablicy staff
        staff[0] = boss;
        staff[1] = new Employee("Adam Wąski", 40000, 1991, 12, 1);
        staff[2] = new Employee("Jan Stary", 35000, 1977, 7, 3);

        //wyswietlanie info o wszystkich obiektach
        for (Employee e : staff) {
            System.out.println("name: " + e.getName() + " salary: " + e.getSalary() + " data zatrudnienia: " + e.getHireDay());
        }
    }
}