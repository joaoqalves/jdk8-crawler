package net.joaoqalves.services;

import net.joaoqalves.TestContext;
import net.joaoqalves.config.AppConfig;
import net.joaoqalves.config.MvcConfig;
import net.joaoqalves.domain.CrawledUrl;
import net.joaoqalves.domain.DownloadResult;
import net.joaoqalves.domain.UploadUrl;
import net.joaoqalves.repositories.CrawledUrlRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MvcConfig.class, AppConfig.class})
@WebAppConfiguration
public class CrawlerServiceTest extends TestContext {
    
    @Mock
    private DownloaderService downloaderService;
    @Mock
    private CrawledUrlRepository crawledUrlRepository;
    @Mock
    private QualifierService qualifierService;

    @Autowired
    private CrawlerService crawlerService;

    @Before
    public void before() {
        super.before();
        when(downloaderService.download(any(UploadUrl.class)))
                .thenReturn(CompletableFuture.supplyAsync(() -> downloadResult1));
        when(qualifierService.isMarfeelizable(any(DownloadResult.class))).thenReturn(true);
        when(crawledUrlRepository.save(crawledUrl1)).thenReturn(crawledUrl1);
    }

    @Test
    public void crawlerService() throws InterruptedException, ExecutionException {
        List<CrawledUrl> crawledUrls = crawlerService.crawl(Arrays.asList(uploadUrl1)).get();
        assertEquals(TEST_URL, crawledUrls.get(0).getUrl());
    }

}
