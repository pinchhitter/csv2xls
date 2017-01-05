package  util.convert;

import java.io.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import com.opencsv.CSVReader;

public class CSV2XLS{

	public static void ConvertCSVToXLS(String file) throws IOException {

		try{
 			SXSSFWorkbook wb = new SXSSFWorkbook(100); 
			Sheet sh = wb.createSheet();
			CSVReader reader = new CSVReader(new FileReader( file ) );
			String []line;
			int rowNum = 0;
			while ((line = reader.readNext() ) != null) {

				Row row = sh.createRow( rowNum++ );
				for(int cellnum = 0; cellnum < line.length; cellnum++){
					Cell cell = row.createCell(cellnum);
					cell.setCellValue( line[ cellnum ].trim()  );
				}

				if(rowNum % 100 == 0) {
                			((SXSSFSheet)sh).flushRows(100); 
					System.out.println( rowNum );

           			}
			}

			FileOutputStream fileOut = new FileOutputStream( file.substring(0, file.indexOf(".csv"))+".xls" );
			wb.write(fileOut);
			fileOut.close();
			wb.dispose();

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {

		CSV2XLS cx = new CSV2XLS();
		cx.ConvertCSVToXLS( args[0].trim() );

	}	
}

