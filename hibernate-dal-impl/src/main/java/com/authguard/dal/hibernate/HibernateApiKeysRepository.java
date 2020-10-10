package com.authguard.dal.hibernate;

import com.authguard.dal.ApiKeysRepository;
import com.authguard.dal.hibernate.util.QueryExecutor;
import com.authguard.dal.model.ApiKeyDO;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class HibernateApiKeysRepository extends AbstractHibernateRepository<ApiKeyDO>
        implements ApiKeysRepository {
    private static final String GET_BY_APP_ID = "api_keys.getByAppId";

    private static final String APP_ID_FIELD = "appId";

    public HibernateApiKeysRepository() {
        super(ApiKeyDO.class);
    }

    @Override
    public CompletableFuture<Collection<ApiKeyDO>> getByAppId(final String appId) {
        return QueryExecutor.getAList(session -> session.createNamedQuery(GET_BY_APP_ID, ApiKeyDO.class)
                .setParameter(APP_ID_FIELD, appId))
                .thenApply(Function.identity());
    }
}
