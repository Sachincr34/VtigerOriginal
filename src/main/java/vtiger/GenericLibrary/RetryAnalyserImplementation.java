package vtiger.GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer {
/**
 * This is the implementation methode of Iretryanayser, it will rerun the failed inconsistant test cases 3 times  
 */
	public boolean retry(ITestResult result) {
	
		int count= 0;
		int retrycount=3;
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
		
	}

}
