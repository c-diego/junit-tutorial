package br.dev.diegocorte.module2;

import br.dev.diegocorte.module1.BankAccount;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

/**
 *
 * @author diego
 */

@DisplayName("Testando BankAccount class em paralelo")
@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

    @Test
    @DisplayName("Depositando 500")
    public void testDeposit1(BankAccount account) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        account.deposit(500);
        assertEquals(500, account.getBalance());
        System.out.println("Primeiro");
    }

    @Test
    @DisplayName("Depositando 500")
    public void testDeposit2(BankAccount account) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        account.deposit(500);
        assertEquals(500, account.getBalance());
        System.out.println("Segundo");
    }

    @Test
    @DisplayName("Depositando 500")
    public void testDeposit3(BankAccount account) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        account.deposit(500);
        assertEquals(500, account.getBalance());
        System.out.println("Terceiro");
    }

}
