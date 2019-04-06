package util;

import java.io.FileInputStream;

import javax.imageio.IIOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader 
{

public String path;//is to declare the excel path
public FileInputStream fis=null; //reading excel file
private XSSFWorkbook workbook=null; //connecting with the excel
private XSSFSheet sheet=null; // connecting with the excel sheet
private XSSFRow row=null; // connecting with the row
private XSSFCell cell=null; // connecting with the cell (column)

//purpose of this constructor is , When the Xls_Reader function gets called 
//it will declare the excel path, workbook location, get sheet information and close the workbook


public Xls_Reader(String path){
	
this.path=path;

try
{

fis= new FileInputStream(path);
workbook=new XSSFWorkbook(fis);
sheet= workbook.getSheetAt(0);
fis.close();
}catch (Exception e){
	e.printStackTrace();
}

}

public String getCellData(String sheetName,String colName,int rowNum){
	
//for sheet
	
int index= workbook.getSheetIndex(sheetName); //call sheetname by name of the sheet
int col_Num=0;// starting point from the first sheet column
sheet=workbook.getSheetAt(index); // make sure to connect sheetname with proper index number

//for row

row=sheet.getRow(0); // starting of row 
for(int i=0;i<row.getLastCellNum();i++){   //for loop for getting all the information from existing rows
	
if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))  //equaling cell row name with proper indexing
col_Num=i;
	
}

//for column

row= sheet.getRow(rowNum-1); //get column information from all rows, and start after the heading of the row
cell=row.getCell(col_Num);  // get number from row and column.
return cell.getStringCellValue(); //get the data from the column

}
}
