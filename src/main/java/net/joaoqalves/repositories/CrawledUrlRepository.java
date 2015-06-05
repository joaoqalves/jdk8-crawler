package net.joaoqalves.repositories;

import net.joaoqalves.domain.CrawledUrl;
import org.springframework.data.repository.CrudRepository;

public interface CrawledUrlRepository extends CrudRepository<CrawledUrl, String> {
}
