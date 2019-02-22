package ExtraHomeWork;

// Класс "Место кссира

class CashRegister {

    private People cashier; // сотрудник-кассир
    private int maxBuyers;  // максимальное количество покупателей, которое может обслужить этот кассир в месяц
    int thisMonthBuyers;    // счетчик покупателей в этом месяце

    CashRegister(String name, People cashier) {
        // Поля класса "Касса"
        // наименование (Касса 1, Касса 2)
        String name1 = name;
        this.cashier = cashier;
        this.setMaxBuyers((int) (1000*cashier.getSkill()));
        this.thisMonthBuyers = 0;
    }

    People getCashier() { return cashier; }

    void setCashier(People cashier) { this.cashier = cashier; }

    int getMaxBuyers() { return maxBuyers; }

    private void setMaxBuyers(int maxBuyers) { this.maxBuyers = maxBuyers; }

    float process(Buyer buyer) {
        this.setMaxBuyers ((int) (1000*cashier.getSkill()));
        if (thisMonthBuyers < maxBuyers){
            this.thisMonthBuyers++;
            return buyer.getCheckValue();
        }
        return 0f;
    }
}
