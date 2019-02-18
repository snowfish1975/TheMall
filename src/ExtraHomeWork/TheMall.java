package ExtraHomeWork;

// Имплементация схематической работы супермаркета с использованием ООП

// Базовый класс "TheMall"
public class TheMall {

    private static HR hr = new HR();

    public static void main(String[] args) {
        People man = hr.hire(18,63); // нам нужны совершеннолетние сотрудники с минимум 2 годами до пенсии
        System.out.println(man.getName());
        System.out.println(man.getPhone());
        System.out.println(man.getAge());

    }

}
