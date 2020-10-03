package com.authguard.dal.hibernate;

import com.authguard.dal.hibernate.util.QueryExecutor;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public abstract class AbstractHibernateRepository<T> {
    private final Class<T> entityType;

    protected AbstractHibernateRepository(final Class<T> entityType) {
        this.entityType = entityType;
    }

    public CompletableFuture<T> save(final T credentialsDO) {
        return QueryExecutor.persistAndReturn(credentialsDO);
    }
    
    public CompletableFuture<Optional<T>> getById(final String id) {
        return QueryExecutor.getById(id, entityType);
    }

    public CompletableFuture<Optional<T>> update(final T credentialsDO) {
        return QueryExecutor.updateAndReturn(credentialsDO);
    }

    public CompletableFuture<Optional<T>> delete(final String id) {
        return QueryExecutor.deleteById(id, entityType);
    }
}
