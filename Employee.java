public class Employee {
    static String company;
    String name;
    int age;
    double salary;
    static {
        company = "Zognicant";
    }
    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    static void print(Employee e) {
        System.out.println("Company: " + company);
        System.out.println("Name: " + e.name);
        System.out.println("Age: " + e.age);
        System.out.println("Salary: " + e.salary);
        System.out.println();   
    }
    public static void main(String[] args) {
        Employee e1 = new Employee("Piyush", 20, 70);
        Employee e2 = new Employee("Arnab", 19, 69);
        Employee e3 = new Employee("xxx", 27, 7000);
        Employee e4 = new Employee("yyy", 66, 55);
        Employee e5 = new Employee("zzz", 77, 8800);
        print(e1);
        print(e2);
        print(e3);
        print(e4);
        print(e5);
    }
} 
