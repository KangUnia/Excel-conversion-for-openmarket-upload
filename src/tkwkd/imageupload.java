package tkwkd;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class imageupload {
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
	public static void main(String[] args) throws Exception {
		Document doc = Jsoup.connect("http://www.teacoffee.co.kr/front/php/product.php?product_no=740&main_cate_no=69&display_group=1").timeout(60*1000).userAgent("Mozilla").get();					
		//Elements name=doc.select("body > table > tbody > tr > td:nth-child(2) > table:nth-child(2) > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody > tr:nth-child(9) > td > table > tbody > tr:nth-child(4) > td:nth-child(2) > p:nth-child(2) > img:nth-child(2)");
		Elements name=doc.select("img[src]");
		
		String Name="";
		for(Element e:name){
		//	if(!e.text().equals("")){
			//	System.out.println(e.attr("src"));	
		//	}
		//		Down(e.attr("src"), "C:\\1.jpg");
				try{
					URL url = new URL(e.attr("src"));
					Image image = ImageIO.read(url);
					int width = image.getWidth(null);
					int height = image.getHeight(null);
					System.out.println("width :"+width+" height :"+height);
					if(width>600&&height>700&& width!=height&&e.attr("src").contains("http://link.webhard.co.kr/img/")){
						System.out.println(e.attr("src"));
						//		Down(e.attr("src"), Filepatch+"\\2-"+k+".jpg");
				//		k++;
					} 
				}catch (Exception e1){
					System.out.println("파일이 없습니다.");
				}
		}
	}
}
