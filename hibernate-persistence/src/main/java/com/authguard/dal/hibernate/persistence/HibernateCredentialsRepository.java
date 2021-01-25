package com.authguard.dal.hibernate.persistence;

import com.authguard.dal.hibernate.common.AbstractHibernateRepository;
import com.authguard.dal.persistence.CredentialsRepository;
import com.authguard.dal.hibernate.common.QueryExecutor;
import com.authguard.dal.model.CredentialsDO;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class HibernateCredentialsRepository extends AbstractHibernateRepository<CredentialsDO>
        implements CredentialsRepository {
    private static final String GET_BY_IDENTIFIER = "credentials.getByIdentifier";
    private static final String IDENTIFIER_FIELD = "identifier";

    public HibernateCredentialsRepository() {
        super(CredentialsDO.class);
    }

    @Override
    public CompletableFuture<Optional<CredentialsDO>> findByIdentifier(final String identifier) {
        return QueryExecutor.getSingleResult(session -> session.createNamedQuery(GET_BY_IDENTIFIER, CredentialsDO.class)
                .setParameter(IDENTIFIER_FIELD, identifier));
    }
}
