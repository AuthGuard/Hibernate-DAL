package com.authguard.dal.hibernate.cache;

import com.authguard.dal.cache.SessionsRepository;
import com.authguard.dal.hibernate.common.AbstractHibernateRepository;
import com.authguard.dal.hibernate.common.QueryExecutor;
import com.authguard.dal.model.SessionDO;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class HibernateSessionsRepository extends AbstractHibernateRepository<SessionDO>
        implements SessionsRepository {
    private static final String GET_BY_TOKEN = "sessions.getByToken";
    private static final String TOKEN_FIELD = "token";

    public HibernateSessionsRepository() {
        super(SessionDO.class);
    }

    @Override
    public CompletableFuture<Optional<SessionDO>> getByToken(final String token) {
        return QueryExecutor.getSingleResult(session -> session.createNamedQuery(GET_BY_TOKEN, SessionDO.class)
                .setParameter(TOKEN_FIELD, token));
    }
}