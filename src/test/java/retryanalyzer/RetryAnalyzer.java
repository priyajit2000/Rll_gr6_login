package retryanalyzer;

//public class RetryAnalyzer {

//}

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 3; // Maximum number of retries

    @Override
    public boolean retry(ITestResult result) {
        // Check if the test method failed and the retry count is less than the maximum
        if (!result.isSuccess() && retryCount < maxRetryCount) {
            retryCount++;
            return true; // Retry the test
        }
        return false; // Do not retry the test
    }
}

