package project.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	

	public static int SetCellDataXlsm(String sFeaturename , String sTcName, String sTcStatus,String sReasonCode,String sReason,String sPath) throws Exception {

		int rowcount;
		int rowNum = 0;
		try {
			
			int iTcNum = 0;
			int iFeatureName = 1;
			int iTcName = 2;
			int iTcStatus = 3;
			int iTcTime = 4;
			int iTcReasonCode= 5;
			int iTcReason=6;
			String path = sPath;
			
		 	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    	Date date = new Date();
	    	String sDate = dateFormat.format(date).toString();
	    	
	    	File src = new File(path);
			FileInputStream finput = new FileInputStream(src);
			XSSFWorkbook workbook = new XSSFWorkbook(finput);
			XSSFSheet sheet = workbook.getSheetAt(0);			
			rowcount = sheet.getPhysicalNumberOfRows();
			
			int iRowCount = rowcount;
			rowNum = iRowCount+1;
			String sTcNo = "TC_"+(iRowCount-9);

			XSSFRow row = sheet.getRow(0);		
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);
			
			sheet.autoSizeColumn(iTcNum);
			XSSFCell sTcNumCell = row.getCell(iTcNum);
			if (sTcNumCell == null)
				sTcNumCell = row.createCell(iTcNum);
			sTcNumCell.setCellValue(sTcNo);
			
			sheet.autoSizeColumn(iFeatureName);
			XSSFCell sFeatureCell = row.getCell(iFeatureName);
			if (sFeatureCell == null)
				sFeatureCell = row.createCell(iFeatureName);
			sFeatureCell.setCellValue(sFeaturename);
			
			sheet.autoSizeColumn(iTcName);
			XSSFCell sTsNamecell = row.getCell(iTcName);
			if (sTsNamecell == null)
				sTsNamecell = row.createCell(iTcName);
			sTsNamecell.setCellValue(sTcName);

			sheet.autoSizeColumn(iTcStatus);
			XSSFCell sTcStatusCell = row.getCell(iTcStatus);
			if (sTcStatusCell == null)
				sTcStatusCell = row.createCell(iTcStatus);
			sTcStatusCell.setCellValue(sTcStatus);
		
			sheet.autoSizeColumn(iTcTime);
			XSSFCell sTcDateCell = row.getCell(iTcTime);
			if (sTcDateCell == null)
				sTcDateCell = row.createCell(iTcTime);
			sTcDateCell.setCellValue(sDate);
			
			sheet.autoSizeColumn(iTcReasonCode);
			XSSFCell sTcReasonCodeCell = row.getCell(iTcReasonCode);
			if (sTcReasonCodeCell == null)
				sTcReasonCodeCell = row.createCell(iTcReasonCode);
			sTcReasonCodeCell.setCellValue(sReasonCode);
			
			sheet.autoSizeColumn(iTcReason);
			XSSFCell sTcReasonCell = row.getCell(iTcReason);
			if (sTcReasonCell == null)
				sTcReasonCell = row.createCell(iTcReason);
			sTcReasonCell.setCellValue(sReason);
			
			FileOutputStream fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			
			fileOut.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return rowNum;
		
	}
	
              


public static boolean SetPath(int rowNum, int colName, String data, String sPath) {

    try {

           String path = sPath;
           FileInputStream fis = new FileInputStream(path);
           XSSFWorkbook workbook = new XSSFWorkbook(fis);
           if (rowNum <= 0)
                 return false;
           XSSFSheet sheet = workbook.getSheetAt(0);
           XSSFRow row = sheet.getRow(0);
           int colNum = colName;
           sheet.autoSizeColumn(colNum);
           row = sheet.getRow(rowNum - 1);
           if (row == null)
                 row = sheet.createRow(rowNum - 1);
           XSSFCell cell = row.getCell(colNum);
           if (cell == null)
                 cell = row.createCell(colNum);
           cell.setCellValue(data);
           FileOutputStream fileOut = new FileOutputStream(path);
           workbook.write(fileOut);
           fileOut.close();

    } catch (Exception e) {
           e.printStackTrace();
           return false;
    }
    return true;
}

public static int SetCellDataXlsm(String sFeaturename , String sTcName, String sTcStatus, String sPath) throws Exception {

    int rowcount;
    int rowNum = 0;
    try {
           
           int iTcNum = 0;
           int iFeatureName = 1;
           int iTcName = 2;
           int iTcStatus = 3;
           int iTcTime = 4;                                                           
           String path = sPath;
           
          DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    String sDate = dateFormat.format(date).toString();
    
    File src = new File(path);
           FileInputStream finput = new FileInputStream(src);
           XSSFWorkbook workbook = new XSSFWorkbook(finput);
           XSSFSheet sheet = workbook.getSheetAt(0);                   
           rowcount = sheet.getPhysicalNumberOfRows();
           
           int iRowCount = rowcount;
           rowNum = iRowCount+1;
           String sTcNo = "TC_"+(iRowCount-9);

           XSSFRow row = sheet.getRow(0);          
           row = sheet.getRow(rowNum - 1);
           if (row == null)
                 row = sheet.createRow(rowNum - 1);
           
           sheet.autoSizeColumn(iTcNum);
           XSSFCell sTcNumCell = row.getCell(iTcNum);
           if (sTcNumCell == null)
                 sTcNumCell = row.createCell(iTcNum);
           sTcNumCell.setCellValue(sTcNo);
           
           sheet.autoSizeColumn(iFeatureName);
           XSSFCell sFeatureCell = row.getCell(iFeatureName);
           if (sFeatureCell == null)
                 sFeatureCell = row.createCell(iFeatureName);
           sFeatureCell.setCellValue(sFeaturename);
           
           sheet.autoSizeColumn(iTcName);
           XSSFCell sTsNamecell = row.getCell(iTcName);
           if (sTsNamecell == null)
                 sTsNamecell = row.createCell(iTcName);
           sTsNamecell.setCellValue(sTcName);

           sheet.autoSizeColumn(iTcStatus);
           XSSFCell sTcStatusCell = row.getCell(iTcStatus);
           if (sTcStatusCell == null)
                 sTcStatusCell = row.createCell(iTcStatus);
           sTcStatusCell.setCellValue(sTcStatus);
    
           sheet.autoSizeColumn(iTcTime);
           XSSFCell sTcDateCell = row.getCell(iTcTime);
           if (sTcDateCell == null)
                 sTcDateCell = row.createCell(iTcTime);
           sTcDateCell.setCellValue(sDate);
           
           FileOutputStream fileOut = new FileOutputStream(path);
           workbook.write(fileOut);
           
           fileOut.close();
           
    } catch (Exception e) {
           e.printStackTrace();
    }
    
    return rowNum;
    
}

}
