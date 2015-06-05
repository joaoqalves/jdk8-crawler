package net.joaoqalves.domain;

import org.eclipse.jetty.http.HttpStatus;
import org.jsoup.nodes.Document;

import java.util.Optional;

public class DownloadResult {

    private String url;
    private Optional<HttpStatus.Code> statusCode;
    private Optional<String> error;
    private Optional<Document> content;

    public DownloadResult() {
    }

    public DownloadResult(String url, Optional<HttpStatus.Code> httpStatus, Optional<String> error, Optional<Document> content) {
        this.url = url;
        this.statusCode = httpStatus;
        this.error = error;
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Optional<HttpStatus.Code> getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Optional<HttpStatus.Code> statusCode) {
        this.statusCode = statusCode;
    }

    public Optional<String> getError() {
        return error;
    }

    public void setError(Optional<String> error) {
        this.error = error;
    }

    public Optional<Document> getContent() {
        return content;
    }

    public void setContent(Optional<Document> content) {
        this.content = content;
    }
}
