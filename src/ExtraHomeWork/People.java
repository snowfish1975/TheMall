package ExtraHomeWork;

import java.util.Random;

import static ExtraHomeWork.HR.currentID;

class People {

    private static final String GENDER_MALE = "Мужчина";
    private static final String GENDER_FEMALE = "Женщина";

    // Основные поля класса "People"
    private int id;             // уникальный табельный номер
    private String name;        // имя сотрудника
    private String phoneNumber; // номер телефона сотрудника
    private String gender;      // пол сотрудника
    private int birthYear;      // год рождения сотрудника
    private float skill;        // эффективность сотрудника, у нового сотрудника - от 0.5 до 1.0
    private float salary;       // текущая зарплата сотрудника

    People (){

        String[] firstMaleNames = {"Алексей","Александр","Андрей","Борис","Владимир","Виктор","Валерий","Герман","Глеб","Григорий",
                "Дмитрий","Даниил","Денис","Евгений","Иван","Илья","Кирилл","Константин","Леонид","Матвей","Николай","Олег",
                "Петр","Павел","Роман","Сергей","Семен","Тимофей","Федор","Юрий","Яков"};
        String[] lastMaleNames = {"Иванов","Петров","Сидоров","Алексеев","Зимин","Туманов","Лемехов","Тихомиров","Тихонов",
                "Еремин","Пушкин","Лермонтов","Блок","Толстой","Соловьев","Репин","Путин","Медведев","Чубайс","Навальный",
                "Семенов","Ложкин","Мамин-Сибиряк","Папин"};
        String[] firstFemaleNames = {"Алла","Анна","Алена","Алина","Арина","Влада","Вероника","Виктория","Галина","Диана",
                "Елена","Екатерина","Жанна","Зинаида","Зоя","Илона","Ирина","Кристина","Клавдия","Ксения","Лидия","Леся","Людмила",
                "Марина","Мария","Маргарита","Наталья","Нина","Ольга","Оксана","Полина","София","Светлана","Татьяна","Тамара","Ульяна",
                "Фаина","Юлия","Яна"};
        String[] lastFemaleNames = {"Иванова","Петрова","Сидорова","Алексеева","Зимина","Туманова","Лемехова","Тихомирова","Тихонова",
                "Еремина","Пушкина","Лермонтова","Блок","Толстая","Соловьева","Репина","Путина","Медведева","Чубайс","Навальная",
                "Семенова","Ложкина","Мамина","Папина"};
        String[] phoneCodes = {"900","902","905","909","910","911","912","914","915","920","924","930","999"};

        this.id = currentID++;
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
    }

    int getAge() { return 2019-this.birthYear; }

    int getID() { return this.id; }

    void setSalary(float salary) { this.salary = salary; }

    float getSalary() { return this.salary; }

    float getSkill() { return this.skill; }

    void setSkill(float skill){ this.skill = skill; }

    void printInfo(){
        System.out.println("-------------------------------------------------");
        System.out.println("Сотрудник:              id#"+this.id+" "+this.name);
        System.out.println("Данные:                 "+this.gender+", "+(2019-this.birthYear)+" лет.");
        System.out.println("Номер телефона:         "+this.phoneNumber);
        System.out.println("Эффективность:          "+this.skill);
    }
}
