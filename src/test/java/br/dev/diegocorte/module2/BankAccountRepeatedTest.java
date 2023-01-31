package br.dev.diegocorte.module2;

import br.dev.diegocorte.module1.BankAccount;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author diego
 */
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTest {

    @RepeatedTest(5)
    @DisplayName("Depositando 1000 com sucesso")
    public void testDeposit(BankAccount account) {
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @RepeatedTest(5)
    @DisplayName("Depositando 1000 com sucesso")
    public void testDepositRepetitionInfo(BankAccount account, RepetitionInfo rInfo) {
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
        System.out.println("Nr: " + rInfo.getCurrentRepetition());
    }
}
