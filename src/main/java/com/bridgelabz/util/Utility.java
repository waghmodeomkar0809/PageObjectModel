package com.bridgelabz.util;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Utility {
     static String testsheetPath = "src/main/resources/FacebookLoginTestData.xlsx";
     static Workbook workbook;
     static Sheet sheet;


    public static Object[][] getTestData(String sheetName) {

        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(testsheetPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet = workbook.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {

            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {

                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }

        return data;
    }

}

