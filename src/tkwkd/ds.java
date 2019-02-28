package tkwkd;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ds {
	public static String[][] getNum(String file) throws Exception{//2. 업데이트 하기 읽기
		String[][] data=null;
		Workbook workbook = null;
        Sheet sheet = null;
 
        try{
        	workbook = Workbook.getWorkbook(new File(file));        //엑셀파일 경로를 지정
        	sheet = workbook.getSheet(0);                                   //첫번째 시트를 지정
 
            int rowCount = sheet.getRows();                                 //총 행의 수를 가져옴
            int colCount = sheet.getColumns();                              //총 열의 수를 가져옴
 
            if(rowCount <= 0){
                throw new Exception("Read 할 데이터가 엑셀에 존재하지 않습니다.");
            }
 
          data = new String[rowCount][colCount];

    		for(int i = 0; i < rowCount; i++){
                for(int k = 0 ; k < colCount ; k++){
                    data[i][k] = "";                        //가져온 데이터 입력
                }
            }
            //엑셀데이터를 배열에 저장
    			for(int i = 0; i < rowCount; i++){
    				for(int k = 0 ; k < colCount ; k++){
    					Cell cell =sheet.getCell(k, i);                         //해당 위치의 셀을 가져옴
    					if(cell == null) continue;
    					data[i][k] = cell.getContents();                        //가져온 데이터 입력
    				}
    			}
    		//데이터 검증
    		for(int r = 0; r < data.length; r++){
                for(int c = 0; c < data[0].length; c++){
                    System.out.print("["+r+"]["+c+"]"+data[r][c]+" ");
                }
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally{
        	try {
        		if(workbook != null)    workbook.close();
        	}catch (Exception e){
                 
        	}
        }
        return data;
	}
	public static int htmlchek(String htmllink){
		int num1=0;
		try{
			Document doc = Jsoup.connect(htmllink).timeout(60*1000).userAgent("Mozilla").get();					
			Elements imagechexk= doc.select("img");
			for(Element e:imagechexk){
				System.out.println(e.toString());
			}
			String imageurl=URLEncoder.encode(htmllink,"UTF-8");
			String imageurl1=imageurl.replace("%3A",":").replace("%2F","/").replace("%7E","~").replace("%21","!").replace("%40","@").replace("%23","#").replace("%24","$").replace("%26","&").replace("%28","(").replace("%29",")").replace("%3D","=").replace("%2C",",").replace("%3B",";").replace("%3F","?").replace("%2B","+").replace("%27","'").replace("%22","\"").replace("%25","%");			
			URL url = new URL(imageurl1);
		
			URLConnection ucon = url.openConnection();
			InputStream is = ucon.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			bis.close();
			is.close();
			num1=1;
			
		}catch(Exception e){
			System.out.println(e);
		}
		//System.out.println("html 작업="+num1);
		return num1;	
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String[][] getexl=getNum("C:\\111.xls");
		for(int k=0;k<getexl.length;k++){
//			File file1 = new File(getexl[k][0]);
			int k1=k+1;
//		    File file2 = new File("C://12//"+k1);
//		    if (!file1.renameTo(file2)) {
//			      System.err.println(k1+" 이름 변경 에러 : " + file1);
//			    }
			int d=0;
			d=htmlchek(getexl[k][2]);
			System.out.println(k1+"|"+d);
			
		}
	}

}
