package First;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelData {

	    public static String getData(int row, int col) throws Exception {

	        FileInputStream fis = new FileInputStream("C:\\Users\\skquo\\Downloads\\TestData.xlsx");

	        Workbook wb = new XSSFWorkbook(fis);

	        Sheet sheet = wb.getSheet("Login");

	        Row r = sheet.getRow(row);

	        Cell c = r.getCell(col);

	        wb.close();

	        return c.getStringCellValue();
	    }
	}


