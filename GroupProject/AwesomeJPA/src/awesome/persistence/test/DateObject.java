package awesome.persistence.test;

import java.util.Date;

import awesome.persistence.annotations.Basic;
import awesome.persistence.annotations.ID;

/**
 * 
 * Test object use in the TestManager class, used to test the persisting of objects
 * of type java.util.Date
 *
 */
public class DateObject {

	@Basic
	private int someInteger;
	
	@ID
	private Date date;
	
	public DateObject(){}
	
	public int getSomeInteger(){
		return this.someInteger;
	}
	
	public void setSomeInteger(int someIntger){
		this.someInteger = someIntger;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
}
