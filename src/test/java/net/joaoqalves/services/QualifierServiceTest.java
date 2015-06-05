package net.joaoqalves.services;

import net.joaoqalves.TestContext;
import net.joaoqalves.config.AppConfig;
import net.joaoqalves.config.MvcConfig;
import net.joaoqalves.domain.DownloadResult;
import net.joaoqalves.services.QualifierService;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MvcConfig.class, AppConfig.class})
@WebAppConfiguration
public class QualifierServiceTest extends TestContext {

    @Autowired
    private QualifierService qualifierService;

    @Before
    public void before() {
        super.before();
    }

    @Test
    public void isMarfeelizable() {
        assertTrue(qualifierService.isMarfeelizable(downloadResult1));
        assertTrue(qualifierService.isMarfeelizable(downloadResult2));
        assertFalse(qualifierService.isMarfeelizable(downloadResult3));
    }

}
