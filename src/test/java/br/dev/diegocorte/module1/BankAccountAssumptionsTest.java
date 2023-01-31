package br.dev.diegocorte.module1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author diego
 */
public class BankAccountAssumptionsTest {

    @Test
    @DisplayName("Verifica se conta está ativa")
    public void testActive() {
        BankAccount account = new BankAccount(500, -1000);
        assumeTrue(account != null);
        assertTrue(account.isActive());
    }

    @Test
    @DisplayName("Sacando 300 com sucesso")
    public void testWithdraw() {
        BankAccount account = new BankAccount(500, -1000);
        account.withdraw(300);
        assumingThat( account != null, () -> assertEquals(200, account.getBalance()));
    }

}
