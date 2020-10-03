package com.authguard.dal.hibernate;

import com.authguard.dal.CredentialsAuditRepository;
import com.authguard.dal.hibernate.util.QueryExecutor;
import com.authguard.dal.model.CredentialsAuditDO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class HibernateCredentialsAuditRepository extends AbstractHibernateRepository<CredentialsAuditDO>
        implements CredentialsAuditRepository {
    private static final String GET_BY_CREDENTIALS_ID = "credentials_audit.getByCredentialsId";

    private static final String CREDENTIALS_ID_FIELD = "credentialsId";

    public HibernateCredentialsAuditRepository() {
        super(CredentialsAuditDO.class);
    }

    @Override
    public CompletableFuture<List<CredentialsAuditDO>> findByCredentialsId(final String credentialsId) {
        return QueryExecutor.getAList(session -> session.createNamedQuery(GET_BY_CREDENTIALS_ID, CredentialsAuditDO.class)
                .setParameter(CREDENTIALS_ID_FIELD, credentialsId));
    }
}
