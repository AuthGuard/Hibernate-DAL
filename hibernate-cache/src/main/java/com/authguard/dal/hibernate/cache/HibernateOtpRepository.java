package com.authguard.dal.hibernate.cache;

import com.authguard.dal.cache.OtpRepository;
import com.authguard.dal.hibernate.common.AbstractHibernateRepository;
import com.authguard.dal.model.OneTimePasswordDO;

public class HibernateOtpRepository extends AbstractHibernateRepository<OneTimePasswordDO>
        implements OtpRepository {

    public HibernateOtpRepository() {
        super(OneTimePasswordDO.class);
    }
}
