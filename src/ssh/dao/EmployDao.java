package ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ssh.entity.Department;
import ssh.entity.Employee;

public class EmployDao {
	
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	public Session getSession(){
		return sf.getCurrentSession();
	}
	
	public List<Employee> getAll(){
		
		String hql="from Employee e LEFT OUTER JOIN FETCH e.department";
		Query query=getSession().createQuery(hql);
		List<Employee> list=query.getResultList();
	    
 		return list;
	}
	public void delete(Integer id){
		String hql="DELETE from Employee e where e.id=:id";
		
		getSession().createQuery(hql).setParameter("id", id).executeUpdate();
		
	}
	public List<Department> getDepartment(){
		String hql="from Department";
		return getSession().createQuery(hql).list();
	}
	public void saveOrUp(Employee em){
		getSession().saveOrUpdate(em);
	}
	public Employee getEmployLastName(String lastName){
		String hql="from Employee e where e.lastName=:lastName";
		Query query=getSession().createQuery(hql).setParameter("lastName", lastName);
		return (Employee) query.uniqueResult();
	}
	public Employee get(Integer id){
		return getSession().get(Employee.class, id);
	}
}
    
