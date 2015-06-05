package net.joaoqalves.domain.qualifiers;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TitleQualifier implements Qualifier {

    public boolean isProspect(final Optional<Document> document) {
        return document.map(d -> d.title().contains("news") || d.title().contains("noticias")).orElse(false);
    }

}
