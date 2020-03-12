package com.test.CucumberProject.excelReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static String s = "sheet1";
	private static String s1 = "D:\\Selenium_Workspace\\CucumberProjectTest\\src\\test\\resources\\testdata.xls";
	private static Map<String, String> map = new HashMap<String, String>();

	public String get(String testcasename, String columnname) throws IOException {
		FileInputStream fis;
		int k = 0;
		try {
			fis = new FileInputStream(s1);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			Sheet ws = wb.getSheet(s);
			fis.close();
			
			
			
			
			int rows = ws.getPhysicalNumberOfRows();
			for (int i = 0; i < rows; i++) {
				int cols = ws.getRow(0).getPhysicalNumberOfCells();
				for (int j = 0; j < cols; j++) {
					if (ws.getRow(i).getCell(j, Row.CREATE_NULL_AS_BLANK).toString().replace(".0", "")
							.equalsIgnoreCase(columnname)) {
						k = j;
					}
					map.put(ws.getRow(i).getCell(0, Row.CREATE_NULL_AS_BLANK).toString().replace(".0", ""),
							ws.getRow(i).getCell(k, Row.CREATE_NULL_AS_BLANK).toString().replace(".0", ""));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map.get(testcasename);
	}
}