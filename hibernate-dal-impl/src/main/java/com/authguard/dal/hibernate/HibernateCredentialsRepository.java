package com.authguard.dal.hibernate;

import com.authguard.dal.CredentialsRepository;
import com.authguard.dal.hibernate.util.QueryExecutor;
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
