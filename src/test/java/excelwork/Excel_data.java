package excelwork;

//public class Excel_data {

//}


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Excel_data {
    
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        String filePath = "C:\\Users\\User\\eclipse-workspace\\RLL_check\\datafile.xlsx";
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][2];

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            data[i - 1][0] = row.getCell(0).getStringCellValue(); // Username
            data[i - 1][1] = row.getCell(1).getStringCellValue(); // Password
        }

        workbook.close();
        fis.close();

        return data;
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        // Your test logic to perform login with username and password
        System.out.println("Logging in with username: " + username + " and password: " + password);
        // Example: Perform login and assertions
    }
}

