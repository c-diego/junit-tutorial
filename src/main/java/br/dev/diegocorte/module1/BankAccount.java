package br.dev.diegocorte.module1;

/**
 * Classe para objetos do tipo BankAccount.
 *
 * @author Diego costa
 */
public class BankAccount {

    private double balance;
    private double minimumBalance;
    private boolean active;
    private String holderName;

    /**
     * Constrói um objeto BankAccount com saldo inicial especificado e saldo
     * mínimo permitido especificado;
     *
     * @param balance saldo inicial
     * @param minimumBalance saldo mínimo permitido
     */
    public BankAccount(double balance, double minimumBalance) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
        this.active = true;
    }

    /**
     * Retorna o saldo.
     *
     * @return double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Retorna o valor mínimo permitido do saldo.
     *
     * @return double
     */
    public double getMinimumBalance() {
        return minimumBalance;
    }

    /**
     * Verifica se a conta está ativa.
     *
     * @return boolean
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Esse método define o estado de ativação da conta.
     *
     * @param active false para desativar, true para ativar
     *
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Retorna o nome do proprietário da conta.
     *
     * @return String
     */
    public String getHolderName() {
        return holderName;
    }

    /**
     * Altera o nome do proprietário da conta.
     *
     * @param holderName nome do proprietário da conta
     */
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    /**
     * Decrementa o valor do saldo. Valor a ser decrementado deve ser positivo e
     * balance - amount deve ser maior que minimumBalance. Retorna true em caso
     * de sucesso, retorna falso em caso de fracasso.
     *
     * @param amount valor a ser subtraído do saldo.
     * @return boolean
     */
    public boolean withdraw(double amount) {
        if ((amount > 0) && (this.balance - amount > this.minimumBalance)) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    /**
     * Incrementa o valor de saldo. Valor a ser incrementado deve ser positivo.
     * Retorna true em caso de sucesso, retorna false em caso de fracasso.
     *
     * @param amount valor a ser incrementado ao saldo.
     * @return boolean
     */
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }
;
}
