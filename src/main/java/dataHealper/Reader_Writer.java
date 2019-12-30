package dataHealper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import jxl.write.WritableCell;
import output.Logs;
import running_TestNG_Scripts.Sterams_UCC;
import udf.UDF;

public class Reader_Writer {
	
	public static HSSFWorkbook Workbook;
	public static HSSFSheet Sheet;
	public static HSSFRow Row;
	public static HSSFCell cell;
	
	public static int TestDec_RowNumber;
	
	/** Open Excel file and go to required Sheet **/
	public static void SetInputFIlePath(String strFilePath,String strSheetName) throws Exception{
		Logs.info("[Reader_Writer][SetInputFIlePath] File apth-->"+strFilePath+" SheetName-->"+strSheetName);
		FileInputStream fis=new FileInputStream(strFilePath);
		Workbook=new HSSFWorkbook(fis);
		Sheet=Workbook.getSheet(strSheetName);
	}
	
	/** To get Cell data **/
	public static String GetCellData(String strFilepath,String strSheetName,int ColumNumber,int RowNumber) throws Exception{
		SetInputFIlePath(strFilepath, strSheetName);
		cell=Sheet.getRow(RowNumber).getCell(ColumNumber);
		String getCellData=cell.getStringCellValue().toString();
		return getCellData;
	}
	
	/** To Check test case name and Get test case name and Iterate Test case total count **/
	public static String getTestCasename(String strSheetName,String strTestcaseName) throws Exception{
		
		SetInputFIlePath(Constants.strTestCasesDeestnationPath, strSheetName);
		for(int i=1;i<=Sheet.getLastRowNum();i++){
			cell=Sheet.getRow(i).getCell(1);
			String getCellData=cell.getStringCellValue().toString();
			if(getCellData.equalsIgnoreCase(strTestcaseName)){	
				cell=Sheet.getRow(i).getCell(3);
				String strTestCaseName=cell.getStringCellValue().toString();
				TestDec_RowNumber=i;
				UDF.TotalTC_Sub++;
				return strTestCaseName;
			}
		}
		return null;
	}
	
	/** Get required Property value from property File 
	 * @throws IOException 
	 * @throws FileNotFoundException ***/
	public static String getPropValue(String strKey) throws Exception{	
		try {
			Properties pop=new Properties();
			pop.load(new FileInputStream(Constants.strPropertyFileath));
			String strvalue=pop.getProperty(strKey).toLowerCase().trim();
					System.out.println(strvalue);
			return strvalue;
			} catch (Exception e) {
			System.out.println("Can't read Property for strFilepath: "+Constants.strPropertyFileath+" strKey: "+strKey+"\n"+e);
			return null;
			}
		}
	
	
	/** Write data in Excel Cell **/
	public static void setResult_TestCase_Sheet(String strResult,int rowNum,int columNumb) throws Exception
	{
		FileInputStream fis=new FileInputStream(Constants.strTestCasesDeestnationPath);
		Workbook=new HSSFWorkbook(fis);
		Sheet=Workbook.getSheet(Constants.strCaseSheetName);
		Row=Sheet.getRow(rowNum);
		cell=Row.getCell(columNumb);
		if(cell==null){
			cell=Row.createCell(columNumb);
		}
		cell.setCellValue(strResult);
		FileOutputStream fos=new FileOutputStream(Constants.strTestCasesDeestnationPath);
		Workbook.write(fos);
		fos.flush();
		fos.close();
	}
	
	

}
