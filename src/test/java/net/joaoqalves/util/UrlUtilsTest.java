package net.joaoqalves.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UrlUtilsTest {

    @Test
    public void addHttpToUrl() {
        String toFormat = "ara.cat";
        String expected = "http://ara.cat";

        assertEquals(expected, UrlUtils.formatUrl(toFormat));
    }

}
