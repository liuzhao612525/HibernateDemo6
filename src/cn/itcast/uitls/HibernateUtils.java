package cn.itcast.uitls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	static Configuration configuration = null;
	static SessionFactory sessionFactory = null;
	
	//静态代码块实现
	static {
		//加载核心配置文件
		configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	//提供方法返回sessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSessionObject() {
		return sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args)  {
		
	}
}
