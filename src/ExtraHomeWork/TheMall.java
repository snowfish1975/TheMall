package ExtraHomeWork;

// Имплементация схематической работы супермаркета с использованием ООП

import java.util.*;

// Базовый класс "TheMall"
public class TheMall {

    private static HR hr = new HR(); // Создается экземпляр класса "Отдел кадров"
    private static float totalProfit=0;

    static String[] departmentNames = {"Мясной", "Молочный", "Бакалея", "Напитки"};
    static List<Department> departments = new ArrayList<>();  // список отделов магазина
    private static String[] cashierNames = {"Касса 1", "Касса 2"};
    static List<CashRegister> cashiers = new ArrayList<>();   // список работающих касс
    private static List<Buyer> buyers = new ArrayList<>();    // перечень покупателей текущего месяца
    private static Map<String, CashRegister> cashRegisterForDepartment = new HashMap<>();

    private static int maxBuyersCount = 3000; // предположим, что магазин может обслужить до 3000 покупателей в месяц
    private static final float ADS_COST = 1000;
    private static final float TRAIN_COST = 1000;
    private static final float CHANGE_SUPPLYERS_COST = 3000;
    private static final float CHANGE_STAFF_COST = 500;
    private static final float ADD_CASH_REGISTER_COST = 10000;

    public static void main(String[] args) {
        // Создаем структуру магазина - отделы и кассы
        buildMall();
        // Связываем отделы с обслуживающими их кассами
        setCashToDepDependency();

        // На каждом шагу цикла магазин отрабатывает условный месяц. Подсчитываются доходы от посетителей и расходы на персонал
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        do {
            letBuyersIn();      // формируется случайный поток покупателей
            for (CashRegister cr: cashiers) cr.thisMonthBuyers=0; // обнуляем счетчики прошедших через каждую кассу клиентов
            printStatistics();  // генерируется и печатается месячный результат

            do {
                System.out.println("Выберите дальнейшее действие:");
                System.out.println("0. Выход");
                System.out.println("1. Список сотрудников");
                System.out.println("2. Запуск рекламы (стоимость $1 000, возможный эффект - увеличение количества покупателей)");
                System.out.println("3. Запустить серию треннингов с персоналом (стоимость $1 000, возможный эффект - увеличение эффективности каждого сотрудника)");
                System.out.println("4. Сменить поставщиков (стоимость $3 000, возможный эффект - увеличение среднего чека покупателя)");
                System.out.println("5. Уволить и заменить новым сотрудника (стоимость $500)");
                if (cashiers.size()<4) System.out.println("6. Добавить 1 кассу (стоимость $10 000)");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------");

                System.out.println("9. Следующий месяц");
                userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 0: { // выбран выход из приложения
                        break;
                    }
                    case 1: { // выбран показ списка сотрудников
                        hr.printStaffList();
                        break;
                    }
                    case 2: { // запуск рекламы
                        if (totalProfit >= ADS_COST) {
                            totalProfit -= ADS_COST;
                            doAds();
                            System.out.println("Остаток прибыли магазина = $"+totalProfit);
                        }
                        else System.out.println("ВНИМАНИЕ!!! Не хватает средств на проведение рекламной компании!");
                        break;
                    }
                    case 3: {
                        if (totalProfit >= TRAIN_COST) {
                            totalProfit -= TRAIN_COST;
                            hr.trainStaff();
                            System.out.println("Остаток прибыли магазина = $"+totalProfit);
                        }
                        else System.out.println("ВНИМАНИЕ!!! Не хватает средств на проведение тренингов!");
                        break;
                    }
                    case 4: {
                        if (totalProfit >= CHANGE_SUPPLYERS_COST) {
                            totalProfit -= CHANGE_SUPPLYERS_COST;
                            changeSuppliers();
                            System.out.println("Остаток прибыли магазина = $"+totalProfit);
                        }
                        else System.out.println("ВНИМАНИЕ!!! Не хватает средств для поиска новых поставщиков");
                        break;
                    }
                    case 5: { // сменить сотрудника
                        if(totalProfit >= CHANGE_STAFF_COST) {
                            totalProfit -= CHANGE_STAFF_COST;
                            hr.printStaffList();
                            System.out.println("Введите ID сотрудника, которого нужно заменить: ");
                            hr.changeStaff(scanner.nextInt());
                            System.out.println("Остаток прибыли магазина = $"+totalProfit);
                        }
                        else System.out.println("Недостаточно средств для поиска нового сотрудника.");
                        break;
                    }
                    case 6: { // добавить кассу
                        if(cashiers.size()<4) {
                            if(totalProfit >= ADD_CASH_REGISTER_COST) {
                                totalProfit -= ADD_CASH_REGISTER_COST;
                                cashiers.add(new CashRegister("Касса " + cashiers.size() + 1, hr.hire(25, 50, 1200)));
                                setCashToDepDependency();
                                System.out.println("Касса добавлена. Сотрудник нанят.");
                                System.out.println("Остаток прибыли магазина = $" + totalProfit);
                            }
                            else System.out.println("Недостаточно средств для добавления кассы.");
                        }
                        else System.out.println("ВНИМАНИЕ!!! Достигнут предел количества касс, равный количеству отделов магазина.");
                        break;
                    }
                }
            }while(userChoice != 0 && userChoice != 9);
        } while(userChoice != 0);
    }

    private static void setCashToDepDependency() {
        int j=0;
        int depsToCash = departments.size() / cashiers.size();
        int depsLeft = departments.size() % cashiers.size();

        cashRegisterForDepartment.clear();
        for (CashRegister cr: cashiers){
            for (int i = 0; i < depsToCash; i++)
                cashRegisterForDepartment.put(departmentNames[j*depsToCash+i], cr);
            j++;
        }
        for (CashRegister cr: cashiers)
            if (depsLeft>0){
                cashRegisterForDepartment.put(departmentNames[j*(depsToCash)+depsLeft-1], cr);
                depsLeft--;
            }
    }

    private static void changeSuppliers() {
        for (Buyer b: buyers)
            b.setCheckValue(b.getCheckValue()*1.1f);
        System.out.println("Смена поставщиков привела к увеличению среднего чека примерно на 10%");
    }

    private static void doAds() {
        maxBuyersCount *= 1.1;
        System.out.println("В результате рекламной компании, потенциальный поток клиентов увеличился на 10%");
    }

    // Расчет и вывод результатов работы за месяц
    private static void printStatistics() {
        float totalIncome = 0;
        float totalMonthResult;
        int totalMonthBuyers =0, i =1;
        StringBuilder s = new StringBuilder();
        for(Buyer buyer: buyers)
            totalIncome += cashRegisterForDepartment.get(buyer.getDepartment()).process(buyer);
        for (CashRegister cash: cashiers) {
            totalMonthBuyers += cash.thisMonthBuyers;
            s.append(" Касса ")
                    .append(i).append(": ")
                    .append(cash.thisMonthBuyers)
                    .append(" из возможных ")
                    .append(cash.getMaxBuyers());
            i++;
        }
        // доля прибыли магазина в общем чеке покупателей
        int profitShare = 8;
        totalMonthResult = totalIncome / 100 * profitShare - hr.getTotalMonthSalary();
        totalProfit += totalMonthResult;
        System.out.println("РЕЗУЛЬТАТЫ РАБОТЫ ЗА МЕСЯЦ:");
        System.out.println("Магазин посетило " + buyers.size() + " покупателей. Из них обслужено " + totalMonthBuyers+" ("+s+")");
        System.out.println("Общая выручка составила $" + totalIncome +", прибыль равна $" + totalIncome/100* profitShare +"("+ profitShare +"% от выручки)");
        System.out.println("На зарплату сотрудников потрачено $"+hr.getTotalMonthSalary());
        System.out.println("Месячный результат работы = $" + totalMonthResult+ " Общая прибыль/убыток = $"+totalProfit);
    }

    // Создание отделов и касс
    private static void buildMall(){
        for(String name: departmentNames)
            departments.add(new Department(name, hr.hire(18,50, 1000)) );
        for(String name: cashierNames)
            cashiers.add(new CashRegister(name, hr.hire(25,50,1200)) );
    }

    // Метод создания потока посетителей
    private static void letBuyersIn(){
        buyers.clear();
        Random rnd = new Random();
        int buyersCount = rnd.nextInt(maxBuyersCount)/2+maxBuyersCount/2;
        for (int i = 0; i < buyersCount; i++)
            buyers.add(new Buyer());
    }
}