package net.joaoqalves.services;

import net.joaoqalves.domain.CrawledUrl;
import net.joaoqalves.domain.UploadUrl;
import net.joaoqalves.repositories.CrawledUrlRepository;
import net.joaoqalves.util.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class CrawlerService {

    @Autowired
    private QualifierService qualifierService;
    @Autowired
    private DownloaderService downloaderService;
    @Autowired
    private CrawledUrlRepository crawledUrlRepository;


    public CompletableFuture<List<CrawledUrl>> crawl(final List<UploadUrl> uploadUrls) {
        return Future.sequence(
                uploadUrls.parallelStream()
                        .map(toDownload -> downloaderService.download(toDownload).thenApplyAsync(downloaded ->
                                        new CrawledUrl(downloaded.getUrl(),
                                                downloaded.getStatusCode(),
                                                downloaded.getError(),
                                                qualifierService.isMarfeelizable(downloaded))
                        ).thenApplyAsync(prospect -> crawledUrlRepository.save(prospect)))
                        .collect(Collectors.toList()));
    }
}
