package br.dev.diegocorte.application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author diego
 */
public class GreetingsTest {

    @Test
    public void testSayHello() {
        assertEquals("Hello World!", Greetings.sayHello());
    }

}
