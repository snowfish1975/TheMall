package ExtraHomeWork;

// Класс, имплементирующий работу с персоналом

public class HR {

    private static float totalMonthSalary = 0;

    // Метод "подбора" нового сотрудника
    // Создает, заполняет и возвращает объект класса People на основании переданного дипазона возрастов и оклада
    public People hire(int minAge, int maxAge, float salary){
        People theMan;
        do {
            theMan = new People();
        } while (theMan.getAge()<minAge || theMan.getAge()>maxAge);
        theMan.setSalary(salary);
        totalMonthSalary += salary;
        return theMan;
    }

    // метод "увольнения" сотрудника
    public void fire(People theWorker){
        totalMonthSalary -= theWorker.getSalary();
        theWorker = null;
    }

    public static float getTotalMonthSalary() {
        return totalMonthSalary;
    }
}
