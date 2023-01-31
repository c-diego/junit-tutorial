package br.dev.diegocorte.module2;

import br.dev.diegocorte.module1.BankAccount;
import java.time.DayOfWeek;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author diego
 */
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 300, 400, 120})
    @DisplayName("Depositando valores com sucesso")
    public void testDeposit(int amount, BankAccount account) {
        account.deposit(amount);
        assertEquals(amount, account.getBalance());
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
    @DisplayName("Testando se TUESDAY E THURSDAY começam com T")
    public void testDayOfWeek(DayOfWeek day) {
        assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
    //@CsvSource({"100, Jane Doe", "500, John Doe", "700, Joe Dane"})
    @CsvFileSource(resources = "/details.csv")
    @DisplayName("Depositando valores com sucesso")
    public void testDepositAndName(int amount, String name, BankAccount account) {
        account.deposit(amount);
        account.setHolderName(name);
        assertEquals(amount, account.getBalance());
        assertEquals(name, account.getHolderName());
    }

}
