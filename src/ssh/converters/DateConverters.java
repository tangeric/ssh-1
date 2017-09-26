package ssh.converters;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverters extends StrutsTypeConverter {

	private DateFormat datef=new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		if(arg2==Date.class){
			try {
				return datef.parse(arg1[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1 instanceof Date){
			return datef.format((Date)arg1);
		}
		return null;
	}

}
