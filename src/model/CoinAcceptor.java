package model;

public class CoinAcceptor implements PaymentAcceptor {
    private int amount;

    public CoinAcceptor(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public void addMoney(int amount) {
        this.amount += amount;
    }

    @Override
    public boolean canPay(int price) {
        return amount >= price;
    }

    @Override
    public void pay(int price) {
        amount -= price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
