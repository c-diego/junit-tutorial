package br.dev.diegocorte.module1;

import org.junit.jupiter.api.MethodOrderer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author diego
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountOrderedExecutionTest {
    static BankAccount account = new BankAccount(0, 0);

    @Test
    @Order(2)
    @DisplayName("Sacando 300 com sucesso")
    public void testWithdraw() {
        account.withdraw(300);
        assertEquals(200, account.getBalance());
    }

    @Test
    @Order(1)
    @DisplayName("Depositando 500 com sucesso")
    public void testDeposit() {
        account.deposit(500);
        assertEquals(500, account.getBalance());
    }


}
