package ssh.action;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import ssh.entity.Employee;
import ssh.service.EmployService;

public class EmployeeAction extends ActionSupport implements RequestAware,ModelDriven<Employee>,Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployService es;
    private Map<String,Object> request;
    private Integer id;
    private InputStream inputStream;
    private Employee model;
    private String lastName;
    
  
    	
    public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public InputStream getInputStream(){
    	return inputStream;
    }
    
    public void setId(Integer id) {
		this.id = id;
	}
	
	public void setEs(EmployService es) {
		this.es = es;
	}
	
	public String delete(){
		try {
			es.delete(id);
			inputStream=new ByteArrayInputStream("1".getBytes("utf-8"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			try {
				inputStream=new ByteArrayInputStream("0".getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		return "ajax-success";
	}
	
   public String list(){
       request.put("employees",es.getAll() );       
	   return "list";
	   }
   
   public String input(){
	   request.put("departments", es.getDepartment());
	   return INPUT;
	   
   }
   
   public String save(){
	   if(id==null){
		   model.setCreateTime(new Date()); 
	   }
	  
	   es.saveOrUpdate(model);
	   return SUCCESS;
   }
   
   public void prepareInput(){
	   System.out.println(id);
	   if(id!=null){
		   model=es.get(id);
	   }
   }
   
   public String checkName() {
	   
	   if(es.isLastNamevalid(lastName)){
		   try {
			inputStream=new ByteArrayInputStream("1".getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }else{
		   try {
			inputStream=new ByteArrayInputStream("0".getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
	   return "ajax-success";  
			   
   }
   
   public void prepareSave(){
	   model=new Employee();
   }

@Override
public void setRequest(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	   request=arg0;
}

@Override
public void prepare() throws Exception {
	// TODO Auto-generated method stub
	
}

@Override
public Employee getModel() {
	// TODO Auto-generated method stub
	return model;
}

}
