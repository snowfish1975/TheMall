package ExtraHomeWork;

import java.util.Arrays;
import java.util.Random;

public class People {

    private String[] firstNames = {"Алексей","Александр","Андрей","Борис","Владимир","Виктор","Валерий","Герман","Глеб","Григорий",
            "Дмитрий","Даниил","Денис","Евгений","Иван","Илья","Кирилл","Константин","Леонид","Матвей","Николай","Олег",
            "Петр","Павел","Роман","Сергей","Семен","Тимофей","Федор","Юрий","Яков"};
    private String[] lastNames = {"Иванов","Петров","Сидоров","Алексеев","Зимин","Туманов","Лемехов","Тихомиров","Тихонов",
            "Еремин","Пушкин","Лермонтов","Блок","Толстой","Соловьев","Репин","Путин","Медведев","Чубайс","Навальный",
            "Семенов","Ложкин","Мамин","Папин"};
    private String[] phoneCodes = {"900","902","905","909","910","911","912","914","915","920","924","930","999"};


    private String name;
    private String phoneNumber;
    private int birthYear;

    public People (){
        Random rnd = new Random();
        this.name = firstNames[rnd.nextInt(firstNames.length)] + " " + lastNames[rnd.nextInt(lastNames.length)];
        this.birthYear = 2019-(rnd.nextInt(100));
        this.phoneNumber = "+7(" +phoneCodes[rnd.nextInt(phoneCodes.length)]+ ")" + rnd.nextInt(10) +
                rnd.nextInt(10) + rnd.nextInt(10) + "-" + rnd.nextInt(10) + rnd.nextInt(10) +
                "-" + rnd.nextInt(10) + rnd.nextInt(10);
    };

    public String getName(){
        return this.name;
    }

    public String getPhone() {
        return this.phoneNumber;
    }

    public int getAge() {
        return 2019-this.birthYear;
    }
}
