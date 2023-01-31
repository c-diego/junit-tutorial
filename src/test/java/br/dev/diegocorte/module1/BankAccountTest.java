package br.dev.diegocorte.module1;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author diego
 */

@DisplayName("Test BankAccount class")
public class BankAccountTest {
    
    public BankAccountTest() {
    }

    @Test
    @DisplayName("Sacando 300 com sucesso")
    public void testWithdraw() {
        BankAccount account = new BankAccount(500, -1000);
        account.withdraw(300);
        assertEquals(200, account.getBalance());
    }
    
    @Test
    @DisplayName("Depositando 900 com sucesso")
    public void testDeposit() {
        BankAccount account = new BankAccount(100, -1000);
        account.deposit(900);
        assertEquals(1000, account.getBalance());
    }
    
    @Test
    @DisplayName("Saldo ficará negativo")
    public void testNegativeBalance() {
        BankAccount account = new BankAccount(100, -1000);
        account.withdraw(1000);
        assertNotEquals(0, account.getBalance());
    }
    
    @Test
    @DisplayName("Verifica se conta está ativa")
    public void testActive() {
        BankAccount account = new BankAccount(500, -1000);
        assertTrue(account.isActive());
    }

    @Test
    @DisplayName("Verifica se holderName não é nulo")
    public void testSetHolderName() {
        BankAccount account = new BankAccount(100, -1000);
        account.setHolderName("Jane Doe");
        assertNotNull(account.getHolderName());
    }

    @Test
    @DisplayName("Verifica velocidade de depósito")
    public void testDepositTimeOut() {
        BankAccount account = new BankAccount(0, -1000);
        assertTimeout(Duration.ofNanos(10), () -> account.deposit(100));
    }
    
    @Test
    @Disabled
    @DisplayName("Verifica se conta está desativada")
    public void testAccountDeactivation() {
        BankAccount account = new BankAccount(0, -1000);
        account.setActive(false);
        assertFalse(account.isActive(), "Conta ativa");
    }
}
