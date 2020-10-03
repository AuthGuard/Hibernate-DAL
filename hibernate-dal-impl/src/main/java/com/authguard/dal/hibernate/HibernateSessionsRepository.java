package com.authguard.dal.hibernate;

import com.authguard.dal.SessionsRepository;
import com.authguard.dal.model.SessionDO;

public class HibernateSessionsRepository extends AbstractHibernateRepository<SessionDO>
        implements SessionsRepository {

    public HibernateSessionsRepository() {
        super(SessionDO.class);
    }
}
