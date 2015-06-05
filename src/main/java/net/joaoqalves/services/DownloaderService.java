package net.joaoqalves.services;

import net.joaoqalves.domain.DownloadResult;
import net.joaoqalves.domain.UploadUrl;
import net.joaoqalves.util.UrlUtils;
import org.eclipse.jetty.http.HttpStatus;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class DownloaderService {

    public CompletableFuture<DownloadResult> download(final UploadUrl uploadUrl) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Connection.Response response = Jsoup.connect(UrlUtils.formatUrl(uploadUrl.getUrl())).execute();
                return new DownloadResult(uploadUrl.getUrl(),
                        Optional.of(HttpStatus.getCode(response.statusCode())),
                        Optional.empty(),
                        Optional.ofNullable(response.parse()));
            } catch (IOException ex) {
                return new DownloadResult(uploadUrl.getUrl(),
                        Optional.empty(),
                        Optional.ofNullable(ex.toString()),
                        Optional.empty());
            }
        });
    }

}
