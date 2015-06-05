package net.joaoqalves.util;

public class UrlUtils {

    public static String formatUrl(final String url) {
        if(!url.startsWith("http://") && !url.startsWith("https://")) {
            return "http://" + url;
        }
        return url;
    }

}
