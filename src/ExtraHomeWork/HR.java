package ExtraHomeWork;

// Класс, имплементирующий работу с персоналом

public class HR {

    public People hire(int minAge, int maxAge){
        People theMan;
        do {
            theMan = new People();
        } while (theMan.getAge()<minAge || theMan.getAge()>maxAge);

        return theMan;
    }

}
