package ExtraHomeWork;

// Имплементация схематической работы супермаркета с использованием ООП

import java.util.*;

// Базовый класс "TheMall"
public class TheMall {

    private static HR hr = new HR();

    public static String[] departmentNames = {"Мясной", "Молочный", "Бакалея", "Напитки"};
    private static List<Department> departments = new ArrayList();  // список отделов магазина
    public static String[] cashierNames = {"Касса 1", "Касса 2"};
    private static List<CashRegister> cashiers = new ArrayList();   // список работающих касс
    private static List<Buyer> buyers = new ArrayList();            // перечень покупателей текущего месяца
    private static Map<String, CashRegister> cashRegisterForDepartment = new HashMap<>();

    private static boolean toBeContinued;
    private static int maxBuyersCount = 3000; // предположим, что магазин может обслужить до 3000 покупателей в месяц
    private static int profitShare = 10; // доля прибыли магазина в общем чеке покупателей

    public static void main(String[] args) {
        // Создаем структуру магазина - отделы и кассы
        buildMall();
        // Связываем отделы с обслуживающими их кассами
        int j=0;
        for (CashRegister cr: cashiers){
            for (int i = 0; i < departmentNames.length / cashierNames.length; i++) {
                // Создается массив ключей=значений, где ключи - отделы магазина, а значения - кассы, которые их обслуживают
                cashRegisterForDepartment.put(departmentNames[j*(departmentNames.length / cashierNames.length)+i], cr);
            }
            j++;
        }

        // На каждом шагу цикла магазин отрабатывает условный месяц. Подсчитываются доходы от посетителей и расходы на персонал
        Scanner scanner = new Scanner(System.in);
        do {
            letBuyersIn();      // формируется случайный поток покупателей
            for (CashRegister cr: cashiers) cr.thisMonthBuyers=0; // обнуляем счетчики прошедших через каждую кассу клиентов
            printStatistics();  // генерируется и печатается месячный результат

            System.out.println("Выберите дальнейшее действие:" );
            System.out.println("0. Выход");
            switch(scanner.nextInt()){
                case 0: {
                    toBeContinued = false;
                    break;
                }
            }

        } while(toBeContinued == true);
    }

    // Расчет и вывод результатов работы за месяц
    private static void printStatistics() {
        float totalIncome = 0;
        float totalFinancialResult = 0;
        for(Buyer buyer: buyers)
            totalIncome += cashRegisterForDepartment.get(buyer.getDepartment()).process(buyer);
        totalFinancialResult = totalIncome / 100 * profitShare - HR.getTotalMonthSalary();
        System.out.println("РЕЗУЛЬТАТЫ РАБОТЫ ЗА МЕСЯЦ:");
        System.out.println("Магазин посетило " + buyers.size() + " покупателей.");
        System.out.println("Общая выручка составила $" + totalIncome +", прибыль равна $" + totalIncome/100*profitShare);
        System.out.println("На зарплату сотрудников потрачено $"+HR.getTotalMonthSalary());
        System.out.println("Общий месячный результат работы магазина = $" + totalFinancialResult);
    }

    // Создание отделов и касс
    private static void buildMall(){
        for (int i = 0; i < departmentNames.length; i++)
            departments.add(new Department(departmentNames[i], hr.hire(18,50, 1000)) );
        for (int i = 0; i < cashierNames.length ; i++)
            cashiers.add(new CashRegister(cashierNames[i], hr.hire(25,50,1200)) );
    }

    // Метод создания потока посетителей
    private static void letBuyersIn(){
        buyers.clear();
        Random rnd = new Random();
        int buyersCount = rnd.nextInt(maxBuyersCount);
        for (int i = 0; i < buyersCount; i++)
            buyers.add(new Buyer());
    }

}
