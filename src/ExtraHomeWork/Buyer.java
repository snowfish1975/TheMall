package ExtraHomeWork;

import java.util.Random;

import static ExtraHomeWork.TheMall.departmentNames;

// Класс, представляющий покупателя магазина
public class Buyer {


    private String department;  // отдел, в который пришел покупатель
    private float checkValue;   // сумма покупок покупателя
    public static float maxCheckValue = 150f;

    public Buyer() {
        Random rnd = new Random();
        this.department = departmentNames[rnd.nextInt(departmentNames.length)];
        this.checkValue = (float) rnd.nextFloat()*maxCheckValue;
    }

    public String getDepartment() {
        return department;
    }

    public float getCheckValue(){
        return this.checkValue;
    }
}
