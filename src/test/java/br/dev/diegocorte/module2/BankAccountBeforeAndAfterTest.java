package br.dev.diegocorte.module2;

import br.dev.diegocorte.module1.BankAccount;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 *
 * @author diego
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountBeforeAndAfterTest {

    private BankAccount account;

    @BeforeAll
    public void beforeAll() {
        System.out.println("Hi!");
    }

    @AfterAll
    public void afterAll() {
        System.out.println("Bye!");
    }

    @BeforeEach
    public void prepTest() {
        account = new BankAccount(500, 0);
    }

    @AfterEach
    public void endTest() {
        System.out.println("Teste passou aqui");
    }

    @Test
    @DisplayName("Sacando 300 com sucesso")
    public void testWithdraw() {
        account.withdraw(300);
        assertEquals(200, account.getBalance());
    }

    @Test
    @DisplayName("Depositando 500 com sucesso")
    public void testDeposit() {
        account.deposit(500);
        assertEquals(1000, account.getBalance());
    }

}
