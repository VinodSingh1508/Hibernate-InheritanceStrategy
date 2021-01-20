package org.javafreak.tablePerClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DBUtil {
	/*
	 1. Create SeesionFactory
	 2. Use SeesionFactory to create Session
	 3. Use session to perform DB operations
	 */
	public static SessionFactory sessionFactory;
	public static Session createSessionAndOpenTransaction() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("org/javafreak/tablePerClass/tablePerClass.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        sessionFactory=meta.getSessionFactoryBuilder().build();
        
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}
	public static String commitCloseTransactionCloseSession(Session session) {
		session.getTransaction().commit();
		session.close();
		return "Commit Successful";
	}
}
