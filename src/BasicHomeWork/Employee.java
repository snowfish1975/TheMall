package BasicHomeWork;

public class Employee {

    private String name;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private int age;

    public Employee(String employeeName, String employeePosition, String employeeEmail, String employeePhoneNumber, float employeeMonthSalary, int employeeAge) {
        name = employeeName;
        position = employeePosition;
        email = employeeEmail;
        phone = employeePhoneNumber;
        salary = employeeMonthSalary;
        age = employeeAge;

    }

    public void printInfo(){
        System.out.println("--------------------------------------------------------");
        System.out.println("BasicHomeWork.Employee name:         " + name);
        System.out.println("BasicHomeWork.Employee position:     " + position);
        System.out.println("BasicHomeWork.Employee email:        " + email);
        System.out.println("BasicHomeWork.Employee phone number: " + phone);
        System.out.println("BasicHomeWork.Employee month salary: " + salary);
        System.out.println("BasicHomeWork.Employee age:          " + age);
    }

    public int getAge() {
        return age;
    }
}



