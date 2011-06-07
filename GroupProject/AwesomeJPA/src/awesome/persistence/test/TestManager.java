package awesome.persistence.test;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import awesome.persistence.annotations.Basic;
import awesome.persistence.manager.Manager;
import awesome.persistence.manager.NotAEntity;
import awesome.persistence.manager.PropertiesException;

/**
 * 
 * Test class for Manager
 *
 */
public class TestManager {

	private String propertiesPath = "C:/Users/Ferg/Desktop/OO/GroupProject/AwesomeJPA/src/awesome/persistence/test/awesome.properties";
	private String invalidPropertiesPath = "C:/Users/Ferg/Desktop/OO/GroupProject/AwesomeJPA/src/awesome/persistence/test/awesomeInvalid.properties";

	public class Primatives{
		@Basic
		private String pString;
		@Basic
		private int pInt;
		@Basic
		private boolean pBool;
		@Basic
		private double pDouble;
		@Basic
		private float pFloat;
		@Basic
		private char pChar;
		
		public Primatives(){}
		
		public void setPString(String pString){
			this.pString = pString;
		}
		
		public String getPString(){
			return this.pString;
		}
		
		public void setPInt(int pInt){
			this.pInt = pInt;
		}
		
		public int getPInt(){
			return this.pInt;
		}
		
		public void setPBool(boolean pBool){
			this.pBool = pBool;
		}
		
		public boolean getPBool(){
			return this.pBool;
		}
		
		public void setPDouble(double pDouble){
			this.pDouble = pDouble;
		}
		
		public double getPDouble(){
			return this.pDouble;
		}
		
		public void setPFloat(float pFloat){
			this.pFloat = pFloat;
		}
		
		public float getPFloat(){
			return this.pFloat;
		}
		
		public void setPChar(char pChar){
			this.pChar = pChar;
		}
		
		public char getPChar(){
			return this.pChar;
		}
	}
	
	@Test
	public void testConstructor(){
		try {
			Manager.setProperties(propertiesPath);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		} catch (PropertiesException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test(expected=IOException.class)
	public void testConstructorNoFile() throws IOException, PropertiesException{
		Manager.setProperties("awesome.propertiesNOFILE");
		
	}
	
	@Test(expected=PropertiesException.class)
	public void testConstructorEmptyFile()throws IOException, PropertiesException{
		Manager.setProperties(invalidPropertiesPath);
	}
	
	@Test
	public void testPersist() throws NotAEntity, IOException, PropertiesException, SQLException{
		Manager.setProperties(propertiesPath);
		Primatives p = new Primatives();
		p.setPBool(true);
		p.setPChar('c');
		p.setPDouble(100.110);
		p.setPFloat(new Float(0.1));
		p.setPInt(100);
		p.setPString("HELLO WORLD");
		
		Manager.persist(p);
	}
}
