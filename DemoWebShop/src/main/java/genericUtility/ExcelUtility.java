package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public Workbook workbook;

	public ExcelUtility() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testData/TestScriptData.xlsx");
		workbook = WorkbookFactory.create(fis);
	}

	public String getDataFromExcel(String sheetName, int rowNum, int colNum) throws FileNotFoundException {

		return workbook.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();

	}

	public boolean getBooleanData(String sheetName, int rowNum, int colNum) throws FileNotFoundException {
		{
			return workbook.getSheet(sheetName).getRow(rowNum).getCell(colNum).getBooleanCellValue();

		}
	}

}
