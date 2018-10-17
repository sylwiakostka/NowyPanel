package Employee;

class Manager extends Employee {

    private double bonus;

    public void setBonus(double b) {
        bonus = b;
    }
//manager ma pensje + bonus. trzeba wiec skorzystac z metody pobierania pensji z nadklasy (slowo super) i dodac bonus
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
//konstruktor - instrukcja super mówi: „wywołaj konstruktor nadklasy Employee z parametrami n, s, year, month i day”.
    public Manager (String n, double s, int year, int month, int day){
        super(n, s, year, month, day);
        bonus = 0;
    }
}
