package net.joaoqalves.domain;

import org.eclipse.jetty.http.HttpStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

@Document(collection = "crawledurls")
public class CrawledUrl {

    @Id
    private String id;
    private String url;
    private Optional<HttpStatus.Code> statusCode;
    private Optional<String> error;
    private boolean prospect;

    public CrawledUrl(String url, Optional<HttpStatus.Code> statusCode, Optional<String> error, boolean prospect) {
        this.url = url;
        this.prospect = prospect;
        this.statusCode = statusCode;
        this.error = error;
    }

    public CrawledUrl() {
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isProspect() {
        return prospect;
    }

    public void setProspect(boolean marfeable) {
        this.prospect = marfeable;
    }
}
