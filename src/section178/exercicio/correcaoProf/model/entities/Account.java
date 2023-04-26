package section178.exercicio.correcaoProf.model.entities;

import section178.exercicio.correcaoProf.model.exceptions.BusinessException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit; //limite de saque

    public Account() {
    }
    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }


    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit (double amount) {
        balance += amount;
    }
   public void withdraw(double amount) {
        validateWithdraw(amount); //antes de efetuar o saque, eu chamo minha função para validar
        balance -= amount; //se passar, ele realiza o saque, se der erro, lança uma das excessões
   }
   private void validateWithdraw(double amount) {//não vai estar disponível para as outras classes
        if (amount > getWithdrawLimit()) {
            throw new BusinessException("Erro de saque: A quantia excede o limite de saque");//esta String foi armazenada dentro do objeto da excessão (BusinessException)
        }
        if (amount > getBalance()) {
            throw new BusinessException("Erro de saque: Saldo insuficiente");
        }
   }
}
