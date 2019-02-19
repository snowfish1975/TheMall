package ExtraHomeWork;

// Класс, представляющий отдел в магазине
public class Department {

    private String name;    // Название отдела
    private People seller;  // Продавец отдела

    public Department(String name, People seller) {
        this.name = name;
        this.seller = seller;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSeller(People seller){
        this.seller = seller;
    }

}
