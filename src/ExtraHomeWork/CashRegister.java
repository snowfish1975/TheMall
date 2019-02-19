package ExtraHomeWork;

// Класс "Место кссира

public class CashRegister {

    private String name;
    private People cashier;
    private int maxBuyers;
    public int thisMonthBuyers;


    public CashRegister(String name, People cashier) {
        this.name = name;
        this.cashier = cashier;
        this.maxBuyers = (int) (1000*cashier.getSkill());
        this.thisMonthBuyers = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People getCashier() {
        return cashier;
    }

    public void setCashier(People cashier) {
        this.cashier = cashier;
    }

    public int getMaxBuyers() {
        return maxBuyers;
    }

    public void setMaxBuyers(int maxBuyers) {
        this.maxBuyers = maxBuyers;
    }

    public float process(Buyer buyer) {
        if (thisMonthBuyers < maxBuyers){
            this.thisMonthBuyers++;
            return buyer.getCheckValue();
        }
        return 0f;
    }
}
