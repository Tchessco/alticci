package org.acme.service;

import io.quarkus.cache.CacheResult;
import org.acme.utils.CalculationUtils;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigInteger;

@ApplicationScoped
public class AlticciService {

    @Inject
    private CalculationUtils calculationUtils;

    private static final Logger LOGGER = Logger.getLogger(AlticciService.class);

    @CacheResult(cacheName = "calculation-sequence")
    public long calculateSequence(long number) {
        LOGGER.info("Caching " + number);
        return calculationUtils.calculateSequence(number);
    }
}
