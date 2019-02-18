package BasicHomeWork;

public class HRSystem {

    private static Employee[] worker = new Employee[5];

    public static void main(String[] args) {

        worker[0] = new Employee("Alexey Zimin","Java junior developer","snowfish@mail.ru","+7(920)140-55-09", 3000, 43);
        worker[1] = new Employee("John Petroff","CFO","petroff.j@thecompany.com","+7(910)418-52-21", 5000, 48);
        worker[2] = new Employee("Richard Nickson","shit cleaner","noname@thecompany.com","8(800)100-00-00, ext. 3577486665475547+78555446", 180, 94);
        worker[3] = new Employee("Rebeca Nicelooking","Secretary","babyface@thecompany.com","+7(900)DATINGS", 3000, 22);
        worker[4] = new Employee("Jeff Ironman","Security officer","nobrainshugefists@thecompany.com","Paper letters only", 500, 30);

        for (Employee theWorker : worker) {
            if (theWorker.getAge()>40) theWorker.printInfo();
        }

    }
}
