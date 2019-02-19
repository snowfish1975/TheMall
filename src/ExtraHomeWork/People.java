package ExtraHomeWork;

import java.util.Arrays;
import java.util.Random;

public class People {

    private String[] firstMaleNames = {"Алексей","Александр","Андрей","Борис","Владимир","Виктор","Валерий","Герман","Глеб","Григорий",
            "Дмитрий","Даниил","Денис","Евгений","Иван","Илья","Кирилл","Константин","Леонид","Матвей","Николай","Олег",
            "Петр","Павел","Роман","Сергей","Семен","Тимофей","Федор","Юрий","Яков"};
    private String[] lastMaleNames = {"Иванов","Петров","Сидоров","Алексеев","Зимин","Туманов","Лемехов","Тихомиров","Тихонов",
            "Еремин","Пушкин","Лермонтов","Блок","Толстой","Соловьев","Репин","Путин","Медведев","Чубайс","Навальный",
            "Семенов","Ложкин","Мамин","Папин"};

    private String[] firstFemaleNames = {"Алла","Анна","Алена","Алина","Арина","Влада","Вероника","Виктория","Галина","Диана",
            "Елена","Екатерина","Жанна","Зинаида","Зоя","Илона","Ирина","Кристина","Клавдия","Ксения","Лидия","Леся","Людмила",
            "Марина","Мария","Маргарита","Наталья","Нина","Ольга","Оксана","Полина","София","Светлана","Татьяна","Тамара","Ульяна",
            "Фаина","Юлия","Яна"};
    private String[] lastFemaleNames = {"Иванова","Петрова","Сидорова","Алексеева","Зимина","Туманова","Лемехова","Тихомирова","Тихонова",
            "Еремина","Пушкина","Лермонтова","Блок","Толстая","Соловьева","Репина","Путина","Медведева","Чубайс","Навальная",
            "Семенова","Ложкина","Мамина","Папина"};

    private String[] phoneCodes = {"900","902","905","909","910","911","912","914","915","920","924","930","999"};

    public static final String GENDER_MALE = "Мужчина";
    public static final String GENDER_FEMALE = "Женщина";

    private String name;
    private String phoneNumber;
    private String gender;
    private int birthYear;
    private float skill;


    private float salary;

    public People (){
        Random rnd = new Random();
        this.gender = rnd.nextInt(10) > 5 ? GENDER_MALE : GENDER_FEMALE;
        if (this.gender.equals(GENDER_MALE)) {
            this.name = firstMaleNames[rnd.nextInt(firstMaleNames.length)] + " " + lastMaleNames[rnd.nextInt(lastMaleNames.length)];
        }
        else {
            this.name = firstFemaleNames[rnd.nextInt(firstFemaleNames.length)] + " " + lastFemaleNames[rnd.nextInt(lastFemaleNames.length)];
        }
        this.birthYear = 2019-(rnd.nextInt(100));
        this.phoneNumber = "+7(" +phoneCodes[rnd.nextInt(phoneCodes.length)]+ ")" + rnd.nextInt(10) +
                rnd.nextInt(10) + rnd.nextInt(10) + "-" + rnd.nextInt(10) + rnd.nextInt(10) +
                "-" + rnd.nextInt(10) + rnd.nextInt(10);
        this.skill = rnd.nextFloat() / 2 + 0.5f;
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

    public String getGender() {
        return this.gender;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return this.salary;
    }

    public float getSkill() {
        return this.skill;
    }

    public void printInfo(){
        System.out.println("-------------------------------------------------");
        System.out.println("Имя сотрудника:         "+this.name);
        System.out.println("Данные:                 "+this.gender+", "+(2019-this.birthYear)+" лет.");
        System.out.println("Номер телефона:         "+this.phoneNumber);
        System.out.println("Эффективность:          "+this.skill);
    }
}
