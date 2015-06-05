package net.joaoqalves;

import jdk.nashorn.internal.ir.annotations.Ignore;
import net.joaoqalves.domain.CrawledUrl;
import net.joaoqalves.domain.DownloadResult;
import net.joaoqalves.domain.UploadUrl;
import org.eclipse.jetty.http.HttpStatus;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.when;

@Ignore
public class TestContext {

    @Mock
    protected Document mockDocument1;
    @Mock
    protected Document mockDocument2;
    @Mock
    protected Document mockDocument3;

    protected String TEST_URL = "http://ara.cat";
    protected int TEST_RANK = 123;
    protected String DOCUMENT_TITLE_1 = "news";
    protected String DOCUMENT_TITLE_2 = "las noticias";
    protected String DOCUMENT_TITLE_3 = "not today";

    protected UploadUrl uploadUrl1;

    protected DownloadResult downloadResult1;
    protected DownloadResult downloadResult2;
    protected DownloadResult downloadResult3;

    protected CrawledUrl crawledUrl1;
    protected CrawledUrl crawledUrl2;
    protected CrawledUrl crawledUrl3;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        when(mockDocument1.title())
                .thenReturn(DOCUMENT_TITLE_1);
        when(mockDocument2.title())
                .thenReturn(DOCUMENT_TITLE_2);
        when(mockDocument3.title())
                .thenReturn(DOCUMENT_TITLE_3);

        uploadUrl1 = new UploadUrl(TEST_URL, TEST_RANK);

        downloadResult1 = new DownloadResult(TEST_URL,
                Optional.of(HttpStatus.Code.OK),
                Optional.empty(),
                Optional.ofNullable(mockDocument1));
        downloadResult2 = new DownloadResult(TEST_URL,
                Optional.of(HttpStatus.Code.OK),
                Optional.empty(),
                Optional.ofNullable(mockDocument2));
        downloadResult3 = new DownloadResult(TEST_URL,
                Optional.of(HttpStatus.Code.OK),
                Optional.empty(),
                Optional.ofNullable(mockDocument3));

        crawledUrl1 = new CrawledUrl(downloadResult1.getUrl(),
                downloadResult1.getStatusCode(),
                downloadResult1.getError(),
                true);

        crawledUrl2 = new CrawledUrl(downloadResult2.getUrl(),
                downloadResult2.getStatusCode(),
                downloadResult2.getError(),
                true);

        crawledUrl3 = new CrawledUrl(downloadResult3.getUrl(),
                downloadResult3.getStatusCode(),
                downloadResult3.getError(),
                false);
    }

}
