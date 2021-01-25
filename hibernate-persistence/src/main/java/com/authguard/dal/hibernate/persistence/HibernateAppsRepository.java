package com.authguard.dal.hibernate.persistence;

import com.authguard.dal.hibernate.common.AbstractHibernateRepository;
import com.authguard.dal.persistence.ApplicationsRepository;
import com.authguard.dal.hibernate.common.QueryExecutor;
import com.authguard.dal.model.AppDO;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class HibernateAppsRepository extends AbstractHibernateRepository<AppDO>
        implements ApplicationsRepository {
    private static final String GET_BY_EXTERNAL_ID = "apps.getByExternalId";
    private static final String GET_BY_ACCOUNT_ID = "apps.getByAccountId";

    private static final String EXTERNAL_ID_FIELD = "externalId";
    private static final String ACCOUNT_ID_FIELD = "parentAccountId";

    public HibernateAppsRepository() {
        super(AppDO.class);
    }

    @Override
    public CompletableFuture<Optional<AppDO>> getByExternalId(final String externalId) {
        return QueryExecutor.getSingleResult(session -> session.createNamedQuery(GET_BY_EXTERNAL_ID, AppDO.class)
                .setParameter(EXTERNAL_ID_FIELD, externalId));
    }

    @Override
    public CompletableFuture<List<AppDO>> getAllForAccount(final String accountId) {
        return QueryExecutor.getAList(session -> session.createNamedQuery(GET_BY_ACCOUNT_ID, AppDO.class)
                .setParameter(ACCOUNT_ID_FIELD, accountId));
    }
}
