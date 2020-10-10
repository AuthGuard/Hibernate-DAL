package com.authguard.dal.hibernate;

import com.authguard.dal.OtpRepository;
import com.authguard.dal.model.OneTimePasswordDO;

public class HibernateOtpRepository extends AbstractHibernateRepository<OneTimePasswordDO>
        implements OtpRepository {

    public HibernateOtpRepository() {
        super(OneTimePasswordDO.class);
    }
}
