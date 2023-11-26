package Infra;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.IOException;

public class DataProviders
{
    private Object[][] getDataFromSheet(String fileName, int sheetIndex) throws IOException {

        String filePath = "../A21_ReportAutomation/src/main/resources/" + fileName;
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }

        workbook.close();
        fis.close();

        return data;
    }

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginData() throws IOException {
        return getDataFromSheet("Configuration.xlsm", 1);
    }

    @DataProvider(name = "reportData")
    public Object[][] getReportData() throws IOException {
        return getDataFromSheet("Configuration.xlsm", 2);
    }
}