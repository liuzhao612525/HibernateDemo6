package cn.itcast.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.entity.Contact;
import cn.itcast.entity.Customer;
import cn.itcast.uitls.HibernateUtils;

public class HibernateOneToMany {
	
	
	@Test
	public void testUpDateDemo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, 8);
			Contact contact =  session.get(Contact.class, 8);
			contact.setCngender("dddd");
			customer.getContacts().add(contact);
			contact.setCustomer(customer);

			
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	
	@Test
	public void testDeleteDemo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			
			Customer customer = session.get(Customer.class, 5);
			session.delete(customer);
			
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	
	@Test
	public void testAddDemo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			
			Customer customer = new Customer();
			customer.setCustName("百度");
			customer.setCustLevel("vip");  
			customer.setCustMobile("222");
			customer.setCustPhone("3333");
			customer.setCustSource("网络");
			
			Contact contact = new Contact();
			contact.setCngender("女");
			contact.setCnname("里三");
			contact.setCnphone("34444");
			
			//在客户里表示所有联系人，在联系人里表示客户
			//建立客户和联系人之间的关系
			//把联系人对象放到set集合中
			customer.getContacts().add(contact);
			
			//把客户对象放到联系人里面
			contact.setCustomer(customer);
			
			//保存
			session.save(customer);
			session.save(contact);
			
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
