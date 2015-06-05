package net.joaoqalves.domain;

import net.joaoqalves.TestContext;
import net.joaoqalves.domain.qualifiers.TitleQualifier;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TitleQualifierTest extends TestContext {

    @Test
    public void isProspect() {
        TitleQualifier t = new TitleQualifier();

        assertTrue(t.isProspect(Optional.ofNullable(mockDocument1)));
        assertTrue(t.isProspect(Optional.ofNullable(mockDocument2)));
        assertFalse(t.isProspect(Optional.ofNullable(mockDocument3)));
    }

}
