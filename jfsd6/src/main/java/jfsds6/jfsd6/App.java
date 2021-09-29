package jfsds6.jfsd6;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public  void insert(bean b )
    {
    	 configgen cn=new configgen();
    	 cn.session.save(b);
         cn.t.commit();
         cn.session.close();
         cn.factory.close();
    }
    public void update(bean b)
	  {
		 configgen cn=new configgen();

	
		 Query query = cn.session.createQuery("select avg(salary) from bean");
		 List<Integer> list=query.list();  
		
		 Query q=cn.session.createQuery("update bean set salary=:n where id=:i");  
		 q.setParameter("n",list.get(0));  
		 q.setParameter("i",b.getEid());  
		   
		 int status=q.executeUpdate();  
		 System.out.println(status);  
	
	cn.t.commit();
	System.out.println("Object Updated");
	cn.session.close();
	cn.factory.close();
	  }
    public  void delete()
	  { 
		 configgen cn=new configgen();
	
		 Query query = cn.session.createQuery("select min(salary) from bean");
		 List<Integer> list=query.list();  
		 Query query1=cn.session.createQuery("delete from bean where salary=:j"); 
		 query1.setParameter("j",list.get(0));  
		
		 query1.executeUpdate();  
	cn.t.commit();
	System.out.println("Object Deleted");
	cn.session.close();
	cn.factory.close();
	  }
    
    
    public  void display(bean b) {
    	
		configgen cn=new configgen();
		

		
		System.out.println(b.getEid()+","+b.getEname()+","+b.getSalary()+","+b.getAge()+","+b.getDept());
		cn.t.commit();
		
		cn.session.close();
		cn.factory.close();
	}
	
}
