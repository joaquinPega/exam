package org.simple.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 * Hibernate default builder
 * @author joaquin.pega ; Artiom Amerhanov (artiom.amerhanov@globant.com)
 *
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex.getMessage());
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
