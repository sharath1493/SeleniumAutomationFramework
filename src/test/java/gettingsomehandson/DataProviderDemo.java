package gettingsomehandson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@Test(dataProvider = "mydata")
	public void test1(HashMap<String, String> m) {
		System.out.println(m);
	}

	@DataProvider
	public Object[] mydata() {
		
		Object[] data=null;
		try {
			FileInputStream fs = new FileInputStream("C:\\Users\\shara\\Desktop\\TestData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheet("Sheet2");
			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();
			
			System.out.println(rows +" "+cols);

			data = new Object[rows];
			Map<String, String> map;

			for (int i = 1; i < rows; i++) {
				map = new HashMap<>();
				for (int j = 0; j < cols; j++) {

					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
					data[i - 1] = map;

				}
			}
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		

	}

}
