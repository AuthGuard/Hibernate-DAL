package com.authguard.dal.hibernate.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionProvider {
    private static SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();

    static Session newSession() {
        return factory.openSession();
    }
}
