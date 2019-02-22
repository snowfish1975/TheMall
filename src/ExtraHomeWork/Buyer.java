package ExtraHomeWork;

import java.util.Random;

import static ExtraHomeWork.TheMall.departmentNames;

// Класс, представляющий покупателя магазина
class Buyer {

    private String department;  // отдел, в который пришел покупатель

    private float checkValue;   // сумма покупок покупателя

    Buyer() {
        Random rnd = new Random();
        this.department = departmentNames[rnd.nextInt(departmentNames.length)];
        float maxCheckValue = 150f;
        this.checkValue = rnd.nextFloat()* maxCheckValue;
    }

    String getDepartment() { return department; }

    float getCheckValue(){ return this.checkValue; }

   void setCheckValue(float checkValue) { this.checkValue = checkValue; }
}
