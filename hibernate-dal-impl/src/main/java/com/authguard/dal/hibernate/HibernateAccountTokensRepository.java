package com.authguard.dal.hibernate;

import com.authguard.dal.AccountTokensRepository;
import com.authguard.dal.hibernate.util.QueryExecutor;
import com.authguard.dal.model.AccountTokenDO;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class HibernateAccountTokensRepository extends AbstractHibernateRepository<AccountTokenDO>
        implements AccountTokensRepository {
    private static final String GET_BY_TOKEN = "account_tokens.getByToken";

    private static final String TOKEN_FIELD = "token";

    public HibernateAccountTokensRepository() {
        super(AccountTokenDO.class);
    }

    @Override
    public CompletableFuture<Optional<AccountTokenDO>> getByToken(final String token) {
        return QueryExecutor.getSingleResult(session -> session.createNamedQuery(GET_BY_TOKEN, AccountTokenDO.class)
                .setParameter(TOKEN_FIELD, token));
    }
}
