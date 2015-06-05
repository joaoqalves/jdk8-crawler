package net.joaoqalves.controllers;

import net.joaoqalves.domain.CrawledUrl;
import net.joaoqalves.domain.UploadUrl;
import net.joaoqalves.services.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping({"/crawler"})
public class CrawlerController {

    @Autowired
    private CrawlerService crawlerService;

    @RequestMapping(method= RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    DeferredResult<List<CrawledUrl>> crawl(@RequestBody final List<UploadUrl> urls) throws InterruptedException, ExecutionException {
        DeferredResult<List<CrawledUrl>> deferred = new DeferredResult<>();
        crawlerService.crawl(urls).whenCompleteAsync((crawledUrls, throwable) -> deferred.setResult(crawledUrls));
        return deferred;
    }

}
