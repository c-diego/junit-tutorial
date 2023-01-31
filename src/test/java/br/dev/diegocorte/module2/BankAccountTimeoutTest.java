package br.dev.diegocorte.module2;

import br.dev.diegocorte.module1.BankAccount;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Timeout;

/**
 *
 * @author diego
 */
// para todos os testes na classe
//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
@DisplayName("Testando tempo de execução")
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Depositando 300 em menos que 500 millis")
    public void testDepositTimeoutAnnotation(BankAccount account) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        account.deposit(300);
        assertEquals(300, account.getBalance());
    }

    @Test
    @DisplayName("Depositando 1000 em menos que 500 millis")
    public void testDepositTimeoutAsserion(BankAccount account) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        account.deposit(1000);
        assertTimeout(Duration.ofMillis(500), () -> {
            Thread.sleep(200);
        });
    }

}
