package ssh.service;

import java.util.List;

import ssh.dao.EmployDao;
import ssh.entity.Department;
import ssh.entity.Employee;

public class EmployService {

	private EmployDao ed;
	
	public void setEd(EmployDao ed) {
		this.ed = ed;
	}
	public List<Employee> getAll(){
		return ed.getAll();
	}
	public void delete(Integer id){
		ed.delete(id);
	}
	public List<Department> getDepartment(){
		return ed.getDepartment();
	}
	public void saveOrUpdate(Employee em){
		ed.saveOrUp(em);
	}
	public boolean isLastNamevalid(String lastName){
		return ed.getEmployLastName(lastName)==null;
	}
	public Employee get(Integer id) {
		// TODO Auto-generated method stub
		return ed.get(id);
	}
}

