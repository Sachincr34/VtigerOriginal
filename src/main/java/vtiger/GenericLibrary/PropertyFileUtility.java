package vtiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public String GetPropertyData(String element) throws IOException
	{
	FileInputStream fis=new FileInputStream(AutoconstantUtility.PropertyFilePath);
	Properties pdata= new Properties();
	pdata.load(fis);
	return pdata.getProperty(element);
	
	
	}

}
