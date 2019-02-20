package ExtraHomeWork;

// Класс, представляющий отдел в магазине
class Department {

    private String name;    // Название отдела
    private People seller;  // Продавец отдела

    // Конструктор, устанавливаяющий название отдела и назначающий продавца
    Department(String name, People seller) {
        this.name = name;
        this.seller = seller;
    }

    void setSeller(People seller){ this.seller = seller; }

    People getSeller() { return this.seller; }
}
