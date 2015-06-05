package net.joaoqalves.domain.qualifiers;

import org.jsoup.nodes.Document;

import java.util.Optional;

public interface Qualifier {

    boolean isProspect(final Optional<Document> document);

}
