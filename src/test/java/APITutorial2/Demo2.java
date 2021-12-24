package APITutorial2;

import com.UtilsLayer.ExcelReader;

public class Demo2 {

	public static void main(String[] args) {
		ExcelReader excel=new ExcelReader("/Users/prafulpawar/Nov Script /RestAssuredNovBatch/src/main/java/com/testData/TestData.xlsx");
		
		
		String fn=excel.getData(0, 2, 2);
		System.out.println(fn);
	}

}
