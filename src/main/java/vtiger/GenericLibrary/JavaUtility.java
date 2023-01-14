package vtiger.GenericLibrary;


import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Sachin R
 *
 */
public class JavaUtility {
	/**
	 * This method will generate infinite random numbers
	 * @return
	 */
	public int GetRandomNum()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
	/**
	 * This methode will return the 
	 * @return
	 */
	public String GetSystemDate()
	{
        Date d =new Date();
		
	return	d.toString();
	
	}

}
