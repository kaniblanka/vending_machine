package model;

public interface PaymentAcceptor {

    int getAmount();

    void addMoney(int amount);

    boolean canPay(int price);

    void pay(int price);
}
