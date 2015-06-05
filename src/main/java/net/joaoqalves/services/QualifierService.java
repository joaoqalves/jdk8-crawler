package net.joaoqalves.services;

import net.joaoqalves.domain.DownloadResult;
import net.joaoqalves.domain.qualifiers.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualifierService {

    @Autowired
    List<Qualifier> qualifiers;

    public boolean isMarfeelizable(final DownloadResult downloadResult) {
        return qualifiers.parallelStream()
                .map(cataloger -> cataloger.isProspect(downloadResult.getContent()))
                .allMatch(result -> result.booleanValue());
    }

}
