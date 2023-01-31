package br.dev.diegocorte.module3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author diego
 */

@ExtendWith(MockitoExtension.class)
public class CalculateMethodsMockitoTest {
    
    @Mock
    CalculateMethods calculate;
    
    @BeforeEach
    public void setupMocks() {
        Mockito.when(calculate.divide(6,3)).thenReturn(2.0);
    }
    
    @Test
    public void testDivide() {
        assertEquals(2.0, calculate.divide(6, 3));
    }
    
}
