package com.authguard.dal.hibernate;

import com.authguard.dal.model.AccountDO;
import com.authguard.dal.model.EmailDO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HibernateAccountsRepositoryTest {
    private HibernateAccountsRepository repository;

    @BeforeAll
    void setup() {
        repository = new HibernateAccountsRepository();
    }

    @Test
    void saveAndGetById() {
        final String id = UUID.randomUUID().toString();
        final Set<EmailDO> emails = Collections.singleton(EmailDO.builder()
                .email("saveAndGetById@test.com")
                .build());

        final AccountDO account = AccountDO.builder()
                .id(id)
                .emails(emails)
                .scopes(Collections.emptySet())
                .roles(Collections.emptySet())
                .permissions(Collections.emptySet())
                .build();

        final AccountDO persisted = repository.save(account).join();
        final Optional<AccountDO> retrieved = repository.getById(id).join();

        assertThat(retrieved).contains(persisted);
    }

    @Test
    void getByExternalId() {
        final String id = UUID.randomUUID().toString();
        final String externalId = UUID.randomUUID().toString();

        final Set<EmailDO> emails = Collections.singleton(EmailDO.builder()
                .email("getByExternalId@test.com")
                .build());

        final AccountDO account = AccountDO.builder()
                .id(id)
                .externalId(externalId)
                .emails(emails)
                .scopes(Collections.emptySet())
                .roles(Collections.emptySet())
                .permissions(Collections.emptySet())
                .build();

        final AccountDO persisted = repository.save(account).join();
        final Optional<AccountDO> retrieved = repository.getByExternalId(externalId).join();

        assertThat(retrieved).contains(persisted);
    }

    @Test
    void getByRole() {
        final String id = UUID.randomUUID().toString();
        final String role = "test-role";

        final Set<EmailDO> emails = Collections.singleton(EmailDO.builder()
                .email("getByRole@test.com")
                .build());

        final AccountDO account = AccountDO.builder()
                .id(id)
                .emails(emails)
                .scopes(Collections.emptySet())
                .roles(Collections.singleton(role))
                .permissions(Collections.emptySet())
                .build();

        final AccountDO persisted = repository.save(account).join();
        final List<AccountDO> retrieved = repository.getByRole(role).join();

        assertThat(retrieved).containsOnly(persisted);
    }
}