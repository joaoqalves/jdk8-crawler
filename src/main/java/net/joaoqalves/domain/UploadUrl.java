package net.joaoqalves.domain;

public class UploadUrl {

    private String url;
    private int rank;

    public UploadUrl() {
    }

    public UploadUrl(String url, int rank) {
        this.url = url;
        this.rank = rank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "UploadUrl{" +
                "url='" + url + '\'' +
                ", rank=" + rank +
                '}';
    }
}
