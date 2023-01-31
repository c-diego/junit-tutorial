package br.dev.diegocorte.module1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 *
 * @author diego
 */
@DisplayName("Testando conta com saldo inicial 100")
public class BankAccountNestedTest {

    @Test
    @DisplayName("Sacando 20 com sucesso")
    public void testWithdraw() {
        BankAccount account = new BankAccount(100, -100);
        account.withdraw(20);
        assertEquals(80, account.getBalance());
    }

    @Test
    @DisplayName("Depositando 200 com sucesso")
    public void testDeposit() {
        BankAccount account = new BankAccount(100, -100);
        account.deposit(200);
        assertEquals(300, account.getBalance());
    }

    @Nested
    @DisplayName("Saldo igual 0")
    class WhenBalanceEqualsZero {

        @Test
        @DisplayName("Sacando 100 em conta com saldo minimo 0: Sem mudanças no saldo")
        public void testWithdrawMinimumBalanceIsZero() {
            BankAccount account = new BankAccount(0, 0);
            account.withdraw(100);
            assertEquals(0, account.getBalance());
        }

        @Test
        @DisplayName("Sacando 500 em conta com saldo minimo -1000: Saldo = -500")
        public void testWithdrawMinimumBalanceNegativeOneThousand() {
            BankAccount account = new BankAccount(0, -1000);
            account.withdraw(500);
            assertEquals(-500, account.getBalance());
        }

    }

}
