package br.dev.diegocorte.module2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

/**
 *
 * @author diego
 */
public class ConditionalTest {

    @Test
    @EnabledOnOs({OS.LINUX})
    public void testLinux() {

    }

    @Test
    @EnabledOnOs({OS.WINDOWS}) // not working. why?
    public void testWindows() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_17})
    public void testJRE17() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_17})
    public void testNoJRE17() {

    }
}
