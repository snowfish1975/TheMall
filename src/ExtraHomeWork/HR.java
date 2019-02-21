package ExtraHomeWork;

// Класс, реализующий работу с персоналом

import java.util.ArrayList;
import java.util.List;

import static ExtraHomeWork.TheMall.cashiers;
import static ExtraHomeWork.TheMall.departments;

class HR {

    static List<People> staffList = new ArrayList<>();
    static int currentID=0;

    // Метод "подбора" нового сотрудника
    // Создает, заполняет и возвращает объект класса People на основании переданного дипазона возрастов и оклада
    People hire(int minAge, int maxAge, float salary){
        People theMan;
        do {
            theMan = new People();
        } while (theMan.getAge()<minAge || theMan.getAge()>maxAge);
        theMan.setSalary(salary);
        staffList.add(theMan);
        return theMan;
    }

    // метод "увольнения" сотрудника
    void changeStaff(int id){
        // добавить удаление сотрудника из staffList
        int pos=-1;
        float salary=0, eff = 0;

        for (People p: staffList)
            if (p.getID()==id) {
                pos = staffList.indexOf(p);
                eff = p.getSkill();
                salary = p.getSalary();
            }
        if (pos>=0) {
            staffList.set(pos, hire(18, 63, salary));
            staffList.remove(staffList.size() - 1);
            for (CashRegister c: cashiers){
                if (c.getCashier().getID() == id) c.setCashier(staffList.get(pos));
            }
            for (Department d: departments){
                if (d.getSeller().getID() == id) d.setSeller(staffList.get(pos));
            }
            System.out.println("Сотрудник заменён.");
            System.out.println("Эффективность старого сотрудника " + eff + ", эффективность нового сотрудника " + staffList.get(pos).getSkill());
        }
        else System.out.println("Сотрудник с указанным ID не найден. Может уже уволили давно?");
    }

    float getTotalMonthSalary() {
        float totalMonthSalary=0;
        for (People p: staffList){
            totalMonthSalary += p.getSalary();
        }
        return totalMonthSalary;
    }

    void trainStaff() {
        for (People p: staffList){
            p.setSkill(Math.min(p.getSkill()*1.1f, 1.3f));
        }
        System.out.println("Проведенные тренинги повысили эффективность персонала примерно на 10%");
    }

    void printStaffList(){
        System.out.println("Кассиры:");
        for (CashRegister cash : cashiers) cash.getCashier().printInfo();
        System.out.println("\nПродавцы отделов:");
        for (Department dep : departments) dep.getSeller().printInfo();
    }
}
