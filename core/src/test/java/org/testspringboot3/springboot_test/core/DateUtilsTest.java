package org.testspringboot3.springboot_test.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

class DateUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtilsTest.class);

    @AfterEach
    void tearDown() {
        MDC.clear();
    }

    @Test
    void getDate() {
        LOGGER.info("getDate");
        var getDate = DateUtils.getDate();
        assertNotNull(getDate);
    }

    @Test
    void test2() {
        LOGGER.info("test2");
        MDC.put("cle1", "valeur1");
        LOGGER.info("suite");
    }

    @Test
    void test3() {
        LOGGER.info("test3");
        MDC.put("cle2", "valeur2");
        LOGGER.atInfo().addKeyValue("test", "test3").log("suite3");
        try {
            int i = 1 / 0;
            LOGGER.info("i={}", i);
        } catch (Exception e) {
            LOGGER.error("erreur pour diviser par 0", e);
        }
    }

    @Test
    void test4() {
        LOGGER.info("test4");
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsExceptionTestTestTestetressimple = null;
        MaClasse<ArrayIndexOutOfBoundsException> maClasse =
                new MaClasse<>(arrayIndexOutOfBoundsExceptionTestTestTestetressimple);
    }
}
