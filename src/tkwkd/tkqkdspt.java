package tkwkd;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class tkqkdspt {
	public static String Length(String string) {
		String num="";
	      System.out.println("문자 수 : " + string.getBytes().length);
	      num=string.getBytes().length+"";
	      return num;
	}
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
	public static void vhfej(String rudfh)throws Exception{	
	File f4 = new File(rudfh);
		if( f4.mkdirs()){
			System.out.println("폴더를 생성하였습니다.");
		}
	}
	public static void Down(String imageURL, String fileName){
		  try
		  {
			  URL url = new URL(imageURL);
			  URLConnection ucon = url.openConnection();
			  InputStream is = ucon.getInputStream();
		   
			  FileOutputStream fos = new FileOutputStream(fileName);
		   
			  BufferedInputStream bis = new BufferedInputStream(is);
			  BufferedOutputStream bos = new BufferedOutputStream(fos);
		   
			  int len=0;
			  byte[]buf = new byte[1024];
			  while((len=bis.read(buf,0,1024))!=-1){
				  bos.write(buf,0,len);
			  }
		   
		   bos.close();
		   bis.close();
		   fos.close();
		   is.close();
		   
		  }
		  catch(Exception e)
		  {
		   System.out.print(e);
		  }
	}
	public static void Fimage(String wnth,String Filepatch) throws Exception {
		String wnthr=wnth.replace("product.php?", "image_zoom.php?");
		Document doc = Jsoup.connect(wnthr).timeout(60*10000).userAgent("Mozilla").get();					
		Elements link=doc.select("body > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td:nth-child(1) > table > tbody > tr > td > img");
		int k=0;
		for(Element e:link){
			Down("http://www.teacoffee.co.kr/"+e.attr("src"), Filepatch+"\\0-"+k+".jpg");
			k++;
		}
	}
	public static ArrayList<String> Simage(String wnth,String Filepatch) throws Exception {
		ArrayList<String> Sdata=new ArrayList();
		Document doc = Jsoup.connect(wnth).timeout(60*10000).userAgent("Mozilla").get();					
		Elements name=doc.select("tbody tr td font b font");
		String Name="";
		for(Element e:name){
			if(!e.text().equals("")){
				Name=e.text();	
			}
		}
		Sdata.add(Name);
		
		Elements from=doc.select("body > table > tbody > tr > td:nth-child(2) > table:nth-child(2) > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody > tr:nth-child(8) > td > table > tbody > tr > td:nth-child(2) > form > table > tbody > tr:nth-child(8) > td:nth-child(4) > font");
		String Form="";	
		for(Element e: from){
			if(!e.text().equals("")){
				Form=e.text();	
			}
		}
		Sdata.add(Form);
		
		Elements imglinks=doc.select("img[src]");
		int k=0;
		for(Element e: imglinks){
			try{
				URL url = new URL(e.attr("src"));
				Image image = ImageIO.read(url);
				int width = image.getWidth(null);
				int height = image.getHeight(null);
			//	System.out.println("width :"+width+" height :"+height);
				if(width>600&&height>400&& width!=height&&e.attr("src").contains("http://link.webhard.co.kr/img/")){
					Down(e.attr("src"), Filepatch+"\\2-"+k+".jpg");
					k++;
				} 
			}catch (Exception e1){
				//System.out.println("파일이 없습니다.");
			}
		}
		return Sdata;
	}
	public static void main(String[] args) throws Exception {
		String[][] getexl=null;
		getexl=getNum("C:\\32.xls");
		String[] bytenum=new String[getexl.length];
		String[] filepath=new String[getexl.length];
		String[] name=new String[getexl.length];
		String[] from=new String[getexl.length];
/*		
		for(int k=0;k<getexl.length;k++){
			String wpahrqjswl=getexl[k][2].replaceAll("^\\s", "").replaceAll("\\s$", "").replace("?", "").replace("#", "").replace("\\", "").replace("|", "").replace("/", "").replace("*", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "");
			String wpahrqjswl1=wpahrqjswl.replace(" ", "").replaceAll("^\\s", "").replaceAll("\\s$", "").replace("?", "").replace("#", "").replace("\\", "").replace("|", "").replace("/", "").replace("*", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "");
			String wpahrqjswl2=wpahrqjswl1.replace(" ", "").replaceAll("\\s$", "").replace("?", "").replace("#", "").replace("\\", "").replace("|", "").replace("/", "").replace("*", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "");
			
			
			filepath[k]="C:\\"+getexl[k][1]+"\\"+wpahrqjswl2;	
			vhfej(filepath[k]);
		}*/
		for(int k=0;k<getexl.length;k++){
			System.out.println("실행중 번호="+k);
			
		//	bytenum[k]=Length(getexl[k][2]);
			bytenum[k]=Length(getexl[k][1]);
				
			
		//	Fimage(getexl[k][0],filepath[k]);
	//		ArrayList<String> sdata=Simage(getexl[k][0],filepath[k]);
	//		name[k]=sdata.get(0).toString();
	//		from[k]=sdata.get(1).toString();
			
			try{	  
		//		RandomAccessFile raf2 = new RandomAccessFile("C:\\1.txt", "rw"); //이어쓰기용
				RandomAccessFile raf2 = new RandomAccessFile("C:\\2.txt", "rw");
				raf2.seek(raf2.length());//맨마지막 위치로 커서 이동
				//String str6 = "\r\n"+"홈페이지 주소|"+getexl[k][0]+"|기본폴더|"+filepath[k]+"|기존제목|"+getexl[k][1]+"|기존제목byte|"+bytenum[k]+"|홈페이지제목|"+name[k]+"|홈페이지제목byte|"+name[k].getBytes().length+"|원산지|"+from[k]; //기록할 글
				String str6 = "\r\n"+bytenum[k]; //기록할 글
			
				String r_str6 = new String(str6.getBytes("KSC5601"),"8859_1");//그냥 str을 사용하게되면 
				raf2.writeBytes(r_str6);
				raf2.close();							    
			}catch (Exception e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
			System.out.println("----------------------");
			 
		}

	}

}
