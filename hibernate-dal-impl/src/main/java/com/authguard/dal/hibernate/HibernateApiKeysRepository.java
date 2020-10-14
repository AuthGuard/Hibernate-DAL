package com.authguard.dal.hibernate;

import com.authguard.dal.ApiKeysRepository;
import com.authguard.dal.hibernate.util.QueryExecutor;
import com.authguard.dal.model.ApiKeyDO;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class HibernateApiKeysRepository extends AbstractHibernateRepository<ApiKeyDO>
        implements ApiKeysRepository {
    private static final String GET_BY_APP_ID = "api_keys.getByAppId";
    private static final String GET_BY_KEY = "api_keys.getByKey";

    private static final String APP_ID_FIELD = "appId";
    private static final String KEY_FIELD = "key";

    public HibernateApiKeysRepository() {
        super(ApiKeyDO.class);
    }

    @Override
    public CompletableFuture<Collection<ApiKeyDO>> getByAppId(final String appId) {
        return QueryExecutor.getAList(session -> session.createNamedQuery(GET_BY_APP_ID, ApiKeyDO.class)
                .setParameter(APP_ID_FIELD, appId))
                .thenApply(Function.identity());
    }

    @Override
    public CompletableFuture<Optional<ApiKeyDO>> getByKey(final String key) {
        return QueryExecutor.getSingleResult(session -> session.createNamedQuery(GET_BY_KEY, ApiKeyDO.class)
                .setParameter(KEY_FIELD, key)).thenApply(Function.identity());
    }
}
