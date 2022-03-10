package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getTestDetails(String sheetName) {
		Map<String, String> map = null;
		List<Map<String, String>> list = new ArrayList<>();
		FileInputStream fs = null;
		XSSFWorkbook wb = null;
		try {
			fs = new FileInputStream(FrameworkConstants.getExcelPath());
			wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheet(sheetName);
			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();

			for (int i = 1; i < rows; i++) {
				map = new HashMap<>();
				for (int j = 0; j < cols; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);

				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(fs)) {
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (Objects.nonNull(wb)) {
					try {
						wb.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return list;

	}

}
