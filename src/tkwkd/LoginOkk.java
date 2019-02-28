package tkwkd;
import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.awt.im.InputContext;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Border;
import jxl.write.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class LoginOkk extends JFrame{

	LoginOkk(){
		setTitle("프레임 제목");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);

		JLabel la = new JLabel("파일 경로 :");
		la.setLocation(10,10);
		la.setSize(200,20);
		add(la);
 

		JButton la2 = new JButton("파일 찾기");
		la2.setLocation(300,10);
		la2.setSize(100,20);
		add(la2);
		
		final JTextField la1 = new JTextField("");
		la1.setLocation(90,10);
		la1.setSize(200,20);
		add(la1);
	
	
		
		JLabel la3 = new JLabel("1. html :");
		la3.setLocation(27,40);
		la3.setSize(100,20);
		add(la3);
		
		final JTextField la31 = new JTextField(line1);
		la31.setLocation(90,40);
		la31.setSize(200,20);
		add(la31);

	
		
		JLabel la4 = new JLabel("3. html :");
		la4.setLocation(27,70);
		la4.setSize(100,20);
		add(la4);
		
		final JTextField la41 = new JTextField(line2);
		la41.setLocation(90,70);
		la41.setSize(200,20);
		add(la41);

		
		JButton lao = new JButton("2.엑셀 생성");
		lao.setLocation(10,100);
		lao.setSize(125,50);
		add(lao); 

		JButton lao1 = new JButton("3.업데이트");
		lao1.setLocation(140,100);
		lao1.setSize(125,50);
		add(lao1);
		
		JButton lao2 = new JButton("4.최종 결과");
		lao2.setLocation(270,100);
		lao2.setSize(125,50);
		add(lao2);

		JButton lao0 = new JButton("0.카테고리");
		lao0.setLocation(300,40);
		lao0.setSize(100,23);
		add(lao0);
		
		JButton lao6 = new JButton("1.계산완료");
		lao6.setLocation(300,66);
		lao6.setSize(100,23);
		add(lao6);
		
		setSize(430,220);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-215, dim.height/2-110);
		setVisible(true);
		setResizable(true);

		la2.addActionListener(new ActionListener(){
			JFileChooser chooser= new JFileChooser();
			
			public void actionPerformed(ActionEvent e){
				FileNameExtensionFilter filter = new FileNameExtensionFilter("엑셀파일.xls","xls");
				chooser.setFileFilter(filter);

				int ret = chooser.showOpenDialog(null);
				if (ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일를 선택하지않았습니다.","경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				String filePath = chooser.getSelectedFile().getPath();  //파일경로를 가져옴
				if(filePath!=null){ la1.setText(filePath);}
					
			}
		});
		
		lao0.addActionListener(new ActionListener(){
			JFileChooser chooser= new JFileChooser();
			public void actionPerformed(ActionEvent e){
				String exlefile=la1.getText();
				try {
					getNum4(exlefile);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {//옥션
					getNum10("C:\\tk작업파일\\카테고리.xls");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//옥션
				int ndusd=31;
				for(int m=1;m<data.length;m++){
					for(int j=1;j<5;j++){
						for(int k=0;k<data10.length;k++){
							if(data[m][1].contains(data10[k][0])&&data[m][2].contains(data10[k][0])&&j==1){
								data[m][ndusd]=data10[k][0];
								ndusd++;
							}
							if(data[m][1].contains(data10[k][5])&&data[m][2].contains(data10[k][5])&&j==2){
								if(k==0){
									ndusd++;
								}
								data[m][ndusd]=data10[k][5];
								ndusd++;
							}
							if(data[m][1].contains(data10[k][10])&&data[m][2].contains(data10[k][10])&&j==3){
								if(k==0){
									ndusd++;
								}
								data[m][ndusd]=data10[k][10];
								ndusd++;
							}
							if(data[m][1].contains(data10[k][15])&&data[m][2].contains(data10[k][15])&&j==4){
								if(k==0){
									ndusd++;
								}
								data[m][ndusd]=data10[k][15];
								ndusd++;
							}
						}	
					}
				}
				try {
					simpleExcelWrite(new File(exlefile) , data);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lao6.addActionListener(new ActionListener(){
			JFileChooser chooser= new JFileChooser();
			public void actionPerformed(ActionEvent e){
				String exlefile=la1.getText();
				try {
					getNum2(exlefile);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {//옥션
					getNum10("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//옥션
				
				for(int m=1;m<data.length;m++){
					for(int j=1;j<5;j++){
						for(int k=0;k<data10.length;k++){
							if(data[m][31].equals(data10[k][0])&&j==1){
								String rufrhk="";
								if(data10[k][2].equals("")){
									rufrhk=data10[k][2]+"만원 이상:"+data10[k][3]+"%"+" 이하:"+data10[k][4]+"%";
								}else{
									rufrhk=data10[k][3]+"%";
								}
								data[m][8]=rufrhk;
								data[m][33]=data10[k][1];
								
							}
							if(data[m][32].equals(data10[k][5])&&j==2){
								String rufrhk="";
								if(data10[k][7].equals("")){
									rufrhk=data10[k][7]+"만원 이상:"+data10[k][8]+"%"+" 이하:"+data10[k][9]+"%";
								}else{
									rufrhk=data10[k][8]+"%";
								}
								data[m][10]=rufrhk;
								data[m][34]=data10[k][6];
							}
							if(data[m][33].equals(data10[k][10])&&j==3){
								String rufrhk="";
								if(data10[k][12].equals("")){
									rufrhk=data10[k][12]+"만원 이상:"+data10[k][13]+"%"+" 이하:"+data10[k][14]+"%";
								}else{
									rufrhk=data10[k][13]+"%";
								}
								data[m][12]=rufrhk;
								data[m][35]=data10[k][11];
							}
							if(data[m][34].equals(data10[k][15])&&j==4){
								String rufrhk="";
								if(data10[k][17].equals("")){
									rufrhk=data10[k][17]+"만원 이상:"+data10[k][18]+"%"+" 이하:"+data10[k][19]+"%";
								}else{
									rufrhk=data10[k][18]+"%";
								}
								data[m][14]=rufrhk;
								data[m][36]=data10[k][16];
							}
						}	
					}
				}
				try {
					simpleExcelWrite(new File(exlefile) , data);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		lao.addActionListener(new ActionListener(){//업데이트 버튼
			String wpahrqjswl="";
			public void actionPerformed(ActionEvent e){
				String exlefilename = la1.getText();
				String html1 = la31.getText();
				String html3 = la41.getText();
				System.out.println(exlefilename);
//				System.out.println(html1);
//				System.out.println(html3);
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter("C:\\tk작업파일\\html.txt"));
					out.write(html1+"\r\n"+html3);
					out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}							
				try {//엑셀파일 읽어 오기
					getNum(exlefilename);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				///////////////////////엑셀 불러 오기 끝///////////////////
				for(int k=1;k<data.length;k++){//폴더 제작
					wpahrqjswl=data[k][82].replaceAll("^\\s", "").replaceAll("\\s$", "").replace("?", "").replace("#", "").replace("\\", "").replace("|", "").replace("/", "").replace("*", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "");
					String wpahrqjsw2=data[k][83].replaceAll("^\\s", "").replaceAll("\\s$", "").replace("?", "").replace("#", "").replace("\\", "").replace("|", "").replace("/", "").replace("*", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "");
					String wpahrqjsw3=data[k][84].replaceAll("^\\s", "").replaceAll("\\s$", "").replace("?", "").replace("#", "").replace("\\", "").replace("|", "").replace("/", "").replace("*", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "");
					String wpahrqjsw4=data[k][85].replaceAll("^\\s", "").replaceAll("\\s$", "").replace("?", "").replace("#", "").replace("\\", "").replace("|", "").replace("/", "").replace("*", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "");		
					String wnthcro="C:\\"+wpahrqjswl+"\\"+wpahrqjsw2+"\\"+wpahrqjsw3+"\\"+wpahrqjsw4;
					File rudfh= new File(wnthcro);
					if(!rudfh.exists()){//파일 경로 존재 하는지 확인
						try {
							vhfej(wnthcro);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							try {//실패시 다시
								vhfej(wnthcro);
							} catch (Exception e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}	
					}
					data[k][81]=wnthcro;
					data[k][79]=wnthcro+"\\1.jpg";//프로필 파일 경로 저장
					data[k][80]=wnthcro+"\\2.jpg";//상세페이지 경로 저장
						
//					firstfile0="C:\\"+wpahrqjswl+"\\"+wpahrqjswl+"(작업파일)0.xls";
//					firstfile1="C:\\"+wpahrqjswl+"\\"+wpahrqjswl+"(작업파일).xls";
//					firstfile2="C:\\"+wpahrqjswl+"\\"+wpahrqjswl+"(결과파일).xls";
				}
				for(int qjsghrow=1;qjsghrow<data.length;qjsghrow++){//기본 채우기
//					String qjsgh=getNu(qjsghrow);//숫자역순 001
					String ghltn="";
					String wpahr="";
					String wpahr1="";
					String wpahr2="";
					String wpahr4="";
					String wpahrd="";
					wpahrd=data[qjsghrow][82]+" / "+data[qjsghrow][83]+" / "+data[qjsghrow][84]+" / "+data[qjsghrow][85]+" / "+data[qjsghrow][87]+" / "+data[qjsghrow][86];
					wpahr=wpahrd.replaceAll("\\s\\s+", " ").replaceAll("//+", "/").replaceAll("\\s+$", "").replaceAll("/$", "").replaceAll("\\s/\\s$", "");
					data[qjsghrow][2]=wpahr; //data[qjsghrow][3]=wpahr; data[qjsghrow][4]=wpahr; data[qjsghrow][5]=wpahr; data[qjsghrow][6]=wpahr; data[qjsghrow][8]=wpahr;//상품명 
					data[qjsghrow][9]="12070107";//샵 세부카테고리코드
					
					data[qjsghrow][19]=data[qjsghrow][89];
					data[qjsghrow][20]=data[qjsghrow][91];
					data[qjsghrow][21]=data[qjsghrow][93];
					data[qjsghrow][22]=data[qjsghrow][95];
					
					data[qjsghrow][15]="im7925";
					data[qjsghrow][18]=data[qjsghrow][88]; data[qjsghrow][24]=data[qjsghrow][88];//판매가
					
					data[qjsghrow][25]="1000";data[qjsghrow][26]="10000";data[qjsghrow][33]="9999";//경매시작가//경매 즉시 구매가//판매가능수량
					data[qjsghrow][37]=data[qjsghrow][82]; data[qjsghrow][38]=data[qjsghrow][82]; data[qjsghrow][40]=data[qjsghrow][82];//제조사
					data[qjsghrow][46]=data[qjsghrow][85];//모델명
					data[qjsghrow][48]="A";data[qjsghrow][49]="N";//과세//물품 상태
					try {
						data[qjsghrow][51]=dnjstkswl(data[qjsghrow][87]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					data[qjsghrow][52]=data[qjsghrow][87];// 원산지
					data[qjsghrow][57]="M";data[qjsghrow][58]="http://ai.esmplus.com/im7925/JH2/%EB%8F%99%EC%9A%B0%EC%82%B0%EC%97%85/main/자동개폐식/DWV-25DRA/1.jpg";//상품 이미지//상품 이미지 초기 경로
					String html1rkrhd="<img src=\""+line1+"\" /><br />";
					String html2rkrhd="<img src=\"http://ai.esmplus.com/im7925/JH2/"+data[qjsghrow][80].replace("C:\\", "")+"\" /><br />";
					String html3rkrhd="<img src=\""+line2+"\" /><br />";					
					data[qjsghrow][64]=html1rkrhd.replace("\\", "/")+html2rkrhd.replace("\\", "/")+html3rkrhd.replace("\\", "/");//상세설명	
					String result="";
					int cheking=htmlchek(html2rkrhd.replace("<img src=\"", "").replace("\" /><br />", ""));
					if(cheking==0){
						result="X";
					}else if(cheking==1){
						result="O";
					}
					
					String html1232="http://ai.esmplus.com/im7925/JH2/"+data[qjsghrow][80].replace("C:\\", "").replace("\\", "/");
					String html12312="";
					String html123124="";
					try {
						html12312 = URLEncoder.encode(html1232,"UTF-8").replace("+","%20");
						html123124=html12312.replace("%3A",":").replace("%2F","/").replace("%7E","~").replace("%21","!").replace("%40","@").replace("%23","#").replace("%24","$").replace("%26","&").replace("%28","(").replace("%29",")").replace("%3D","=").replace("%2C",",").replace("%3B",";").replace("%3F","?").replace("%2B","+").replace("%27","'").replace("%22","\"").replace("%25","%");			
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					data[qjsghrow][61]=html1232.replace(" ", "%20");
					data[qjsghrow][107]=html123124;
					data[qjsghrow][62]=html123124;
					data[qjsghrow][63]=result;//상세페이지 검수
					data[qjsghrow][65]="2";data[qjsghrow][66]="배송비(전화상담필수)";data[qjsghrow][67]="";data[qjsghrow][68]="배송지역상담(1600-3176)";data[qjsghrow][69]="";data[qjsghrow][70]="0";data[qjsghrow][71]="9999";//옥션 형태//옥션1이름//옥션1
					String[] array=null;
					array = data[qjsghrow][85].split(":");
					dumpArray(array);
					for(int d=0;d<array.length;d++){
						//추가 금액 및 카탈로그 퍼센트로 다시 계산하여 집어 넣기
					}
					if(!data[qjsghrow][105].equals("")){data[qjsghrow][73]="Y"; data[qjsghrow][74]=data[qjsghrow][105];}else{data[qjsghrow][73]="N";}//추가구성
					data[qjsghrow][108]=data[qjsghrow][82];data[qjsghrow][109]=data[qjsghrow][83];data[qjsghrow][110]=data[qjsghrow][84];data[qjsghrow][111]=data[qjsghrow][85];data[qjsghrow][112]=data[qjsghrow][86];data[qjsghrow][113]=data[qjsghrow][87];//검색어
					data[qjsghrow][77]="빠른배송/전국최저가/1년 무상A/S";//홍보문구	
				}

			for(int d=0;d<data.length;d++){
				for(int i=0;i<data[1].length;i++){
					System.out.print("["+d+"]["+i+"]"+data[d][i] );
				}	
				System.out.println("");
			}
			
			try{
				simpleExcelWrite(new File("C:\\"+wpahrqjswl+"\\임시 작업 파일.xls") , data);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {	
				BufferedWriter out = new BufferedWriter(new FileWriter("C:\\tk작업파일\\rlfhr.txt"));
				out.write("C:\\"+wpahrqjswl+"\\임시 작업 파일.xls");
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//					simpleExcelWrite1(new File(firstfile2) , data);//사장한테 줄 결과물
			//		
		}
///////////////////////////////////////////////////////////				
	});
		lao1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dufrl1("C:\\tk작업파일\\rlfhr.txt");
				String exlefieew=la1.getText();
				if(exlefieew.equals("")){
					if(line3.equals("")){//다이얼로그 출력
						
					}else{//파일 읽어서 시작
						try {
							getNum2(line3);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						for(int k=1;k<data.length;k++){
							//data[k][88]=data[k][18];//판매가 ->초기도매가로 업데이트
							//data[k][88]=data[k][18];//
							data[k][82]=data[k][37];//제조사
							data[k][85]=data[k][46];//모델명
							data[k][87]=data[k][52];//원산지
							
							try {
								String htmlrest1 = URLEncoder.encode(data[k][61],"UTF-8").replace("+","%20");
								data[k][107]=htmlrest1.replace("%3A",":").replace("%2F","/").replace("%7E","~").replace("%21","!").replace("%40","@").replace("%23","#").replace("%24","$").replace("%26","&").replace("%28","(").replace("%29",")").replace("%3D","=").replace("%2C",",").replace("%3B",";").replace("%3F","?").replace("%2B","+").replace("%27","'").replace("%22","\"").replace("%25","%");			
							} catch (UnsupportedEncodingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							dufrl("C:\\tk작업파일\\html.txt");
							String html1rkrhd="<img src=\""+line1+"\" /><br />";
							String html2rkrhd="<img src=\""+data[k][107]+"\" /><br />";
							String html3rkrhd="<img src=\""+line2+"\" /><br />";
							data[k][64]=html1rkrhd+html2rkrhd+html3rkrhd;//상세페이지 업데이트
							String result="";
							int cheking=htmlchek(data[k][107]);
							System.out.println("cheking="+cheking);
							if(cheking==0){
								result="X";
							}else if(cheking==1){
								result="O";
							}
							data[k][63]=result;
							data[k][62]=data[k][107];
							
							////옵션 업데이트 
							
							data[k][105]=data[k][74];//추가구성
							data[k][76]=data[k][108]+";"+data[k][109]+";"+data[k][110]+";"+data[k][111]+";"+data[k][112];//키워드
							
					//		if(!data[k][89].equals("") ||!data[k][90].equals("")){data[k][97]=(Math.round((Integer.parseInt(data[k][89])*(100-Integer.parseInt(data[k][90]))*0.01)*0.1))*10+"";}
					//		if(!data[k][91].equals("") ||!data[k][92].equals("")){data[k][98]=(Math.round((Integer.parseInt(data[k][91])*(100-Integer.parseInt(data[k][92]))*0.01)*0.1))*10+"";}
					//		if(!data[k][93].equals("") ||!data[k][94].equals("")){data[k][99]=(Math.round((Integer.parseInt(data[k][93])*(100-Integer.parseInt(data[k][94]))*0.01)*0.1))*10+"";}
					//		if(!data[k][95].equals("") ||!data[k][96].equals("")){data[k][100]=(Math.round((Integer.parseInt(data[k][95])*(100-Integer.parseInt(data[k][96]))*0.01)*0.1))*10+"";}
							
					//		if(!data[k][97].equals("") ||!data[k][88].equals("")){data[k][101]=Integer.parseInt(data[k][97])-Integer.parseInt(data[k][88])+"";}
					//		if(!data[k][98].equals("") ||!data[k][88].equals("")){data[k][102]=Integer.parseInt(data[k][98])-Integer.parseInt(data[k][88])+"";}
					//		if(!data[k][99].equals("") ||!data[k][88].equals("")){data[k][103]=Integer.parseInt(data[k][99])-Integer.parseInt(data[k][88])+"";}
					//		if(!data[k][100].equals("") ||!data[k][88].equals("")){data[k][104]=Integer.parseInt(data[k][100])-Integer.parseInt(data[k][88])+"";}
							
							
						}//for end
						try{
							File f1 = new File(line3);
							f1.renameTo(new File(line3.replace("임시 작업 파일", "임시 작업 파일(0)")));//파일 이름 변경
							simpleExcelWrite(new File(line3) , data);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							BufferedWriter out = new BufferedWriter(new FileWriter("C:\\tk작업파일\\rlfhr.txt"));
							out.write(line3);
							out.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}else{
					
					try {
						getNum2(exlefieew);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for(int k=1;k<data.length;k++){
						//data[k][88]=data[k][18];//판매가 ->초기도매가로 업데이트
						//data[k][88]=data[k][18];//
						data[k][82]=data[k][37];//제조사
						data[k][85]=data[k][46];//모델명
						data[k][87]=data[k][52];//원산지
						
						dufrl("C:\\tk작업파일\\html.txt");
						String html1rkrhd="<img src=\""+line1+"\" /><br />";
						String html2rkrhd="<img src=\""+data[k][107]+"\" /><br />";
						String html3rkrhd="<img src=\""+line2+"\" /><br />";
						data[k][64]=html1rkrhd+html2rkrhd+html3rkrhd;//상세페이지 업데이트
						String result="";
							
						int cheking=htmlchek(data[k][107]);
						if(cheking==0){
							result="X";
						}else if(cheking==1){
							result="O";
						}
						data[k][63]=result;
							
						////옵션 업데이트 
							
						data[k][105]=data[k][74];//추가구성
						data[k][76]=data[k][108]+";"+data[k][109]+";"+data[k][110]+";"+data[k][111]+";"+data[k][112];//키워드
							
						//		if(!data[k][89].equals("") ||!data[k][90].equals("")){data[k][97]=(Math.round((Integer.parseInt(data[k][89])*(100-Integer.parseInt(data[k][90]))*0.01)*0.1))*10+"";}
						//		if(!data[k][91].equals("") ||!data[k][92].equals("")){data[k][98]=(Math.round((Integer.parseInt(data[k][91])*(100-Integer.parseInt(data[k][92]))*0.01)*0.1))*10+"";}
					//		if(!data[k][93].equals("") ||!data[k][94].equals("")){data[k][99]=(Math.round((Integer.parseInt(data[k][93])*(100-Integer.parseInt(data[k][94]))*0.01)*0.1))*10+"";}
					//		if(!data[k][95].equals("") ||!data[k][96].equals("")){data[k][100]=(Math.round((Integer.parseInt(data[k][95])*(100-Integer.parseInt(data[k][96]))*0.01)*0.1))*10+"";}
							
					//		if(!data[k][97].equals("") ||!data[k][88].equals("")){data[k][101]=Integer.parseInt(data[k][97])-Integer.parseInt(data[k][88])+"";}
					//		if(!data[k][98].equals("") ||!data[k][88].equals("")){data[k][102]=Integer.parseInt(data[k][98])-Integer.parseInt(data[k][88])+"";}
					//		if(!data[k][99].equals("") ||!data[k][88].equals("")){data[k][103]=Integer.parseInt(data[k][99])-Integer.parseInt(data[k][88])+"";}
					//		if(!data[k][100].equals("") ||!data[k][88].equals("")){data[k][104]=Integer.parseInt(data[k][100])-Integer.parseInt(data[k][88])+"";}
							
							
					}//for end
					try{
						File f1 = new File(exlefieew);
						f1.renameTo(new File(exlefieew.replace("임시 작업 파일", "임시 작업 파일(0)")));//파일 이름 변경
						simpleExcelWrite(new File(exlefieew) , data);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {	
						BufferedWriter out = new BufferedWriter(new FileWriter("C:\\tk작업파일\\rlfhr.txt"));
						out.write(exlefieew);
						out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//if end
				////////////////////////
				
				
			}
		});//2 업데이트 이벤트

		lao2.addActionListener(new ActionListener(){//3. 최종버튼
			public void actionPerformed(ActionEvent e){
				dufrl1("C:\\tk작업파일\\rlfhr.txt");
				try {
					getNum3(line3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int k=1;k<data.length;k++){//필요 없는거 지우기
					data[k][7]=""; data[k][14]=""; data[k][23]=""; data[k][27]=""; data[k][28]=""; data[k][29]=""; data[k][30]=""; data[k][31]=""; data[k][32]=""; data[k][34]=""; data[k][35]=""; data[k][36]=""; data[k][47]=""; data[k][50]=""; data[k][53]=""; data[k][54]=""; data[k][55]=""; data[k][56]=""; data[k][59]=""; data[k][60]=""; data[k][61]=""; data[k][62]=""; data[k][63]=""; data[k][75]=""; 
				}
				try {
					simpleExcelWrite(new File(line3.replace("임시", "최종")) , data);
					simpleExcelWrite1(new File(line3.replace("임시", "결과")) , data);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				csv(line3.replace(".xls", ".csv").replace("임시", "최종"));
				
			}
				
		});//3 최종 버튼
		
		
	}//끝
	
    public final static void simpleExcelWrite1(File file , String data[][]) throws Exception{
    	  
    	WritableWorkbook workbook = null;
    	WritableSheet sheet = null;
    	  
    	try{
    	   
    		workbook = Workbook.createWorkbook(file);     //지정된 파일명 경로로 워크북 즉 엑셀파일일 만듭니다.
    		workbook.createSheet("Sheet", 0);                    //지정한 워크북에 싯트를 만듭니다. "Sheet" 가 싯트명이 됩니다.
    		sheet = workbook.getSheet(0);                         //시트를 가져옵니다.
    	   
    		WritableCellFormat cellFormat = new WritableCellFormat();    //셀의 스타일을 지정하기 위한 부분입니다.
    		cellFormat.setBorder(Border.ALL , BorderLineStyle.THIN);      //셀의 스타일을 지정합니다. 테두리에 라인그리는거에요
    	   
    		// 빙글빙글 돌리면서 엑셀에 데이터를 작성합니다.
    		for(int row = 0 ; row<data.length ; row ++){
    			for(int col = 82 ; col < data[0].length ; col++){
    				Label label = new jxl.write.Label(col-82 , row , (String) data[row][col] , cellFormat);
    				sheet.addCell(label);
    			}
    		}
    	   
    		workbook.write();
    	   
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}finally{
    		try{
    			if(workbook != null) workbook.close();
    		}catch (WriteException e){
    			//e.printStackTrace();
    		}catch (IOException e){
    			//e.printStackTrace();
    		}
    	}
    	  
    }

    public final static void simpleExcelWrite(File file , String data[][]) throws Exception{
  	  
    	WritableWorkbook workbook = null;
    	WritableSheet sheet = null;
    	  
    	try{
    	   
    		workbook = Workbook.createWorkbook(file);     //지정된 파일명 경로로 워크북 즉 엑셀파일일 만듭니다.
    		workbook.createSheet("Sheet", 0);                    //지정한 워크북에 싯트를 만듭니다. "Sheet" 가 싯트명이 됩니다.
    		sheet = workbook.getSheet(0);                         //시트를 가져옵니다.
    	   
    		WritableCellFormat cellFormat = new WritableCellFormat();    //셀의 스타일을 지정하기 위한 부분입니다.
    		cellFormat.setBorder(Border.ALL , BorderLineStyle.THIN);      //셀의 스타일을 지정합니다. 테두리에 라인그리는거에요
    	   
    		// 빙글빙글 돌리면서 엑셀에 데이터를 작성합니다.
    		for(int row = 0 ; row<data.length ; row ++){
    			for(int col = 0 ; col < data[0].length ; col++){
    				Label label = new jxl.write.Label(col , row , (String) data[row][col] , cellFormat);
    				sheet.addCell(label);
    			}
    		}
    	   
    		workbook.write();
    	   
    	}catch (Exception e){
    		e.printStackTrace();
    		throw e;
    	}finally{
    		try{
    			if(workbook != null) workbook.close();
    		}catch (WriteException e){
    			//e.printStackTrace();
    		}catch (IOException e){
    			//e.printStackTrace();
    		}
    	}
    	  
    }

	public static void dumpArray(String[] array){
		for (int i = 0; i < array.length; i++)
			System.out.format("array[%d] = %s%n", i, array[i]);
	}
	public static int htmlchek(String htmllink){
		int num1=0;
		try{
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
		System.out.println("html 작업="+num1);
		return num1;	
	}
	static String line1 = "";
	static String line2 = "";
	static String line3 = "";
	public static String dnjstkswl(String name) throws Exception{
    	String rnqns="";
    	if(name.equals("국내")){
    		rnqns="D";
    	}else if(name.equals("")){
    		rnqns="N";
    	}else{
    		rnqns="O";
    	}	
    	return rnqns;
    }
	public static void vhfej(String rudfh)throws Exception{	
		File f4 = new File(rudfh);
		if( f4.mkdirs()){
			System.out.println("폴더를 생성하였습니다.");
		}
	}
	public static void dufrl1(String arg){
		
		try{
			File aFile = new File(arg);
			FileReader fileReader = new FileReader(aFile);
			BufferedReader reader = new BufferedReader(fileReader);
		
			String line = null;	
			int i=1;
			while((line = reader.readLine()) !=null){
				//System.out.println(line);
				line3=line;
				i++;
			//	int StringToInt = Integer.parseInt(line);
			}
			reader.close();
		}catch(Exception ex){
		
		}
	}	
	public static void dufrl(String arg){
		
		try{
			File aFile = new File(arg);
			FileReader fileReader = new FileReader(aFile);
			BufferedReader reader = new BufferedReader(fileReader);
		
			String line = null;	
			int i=1;
			while((line = reader.readLine()) !=null){
				//System.out.println(line);
				if(i==1){
					line1=line;
				}else{
					line2=line;
				}
				System.out.println(line);

				
				i++;
			//	int StringToInt = Integer.parseInt(line);
			}
			reader.close();
		}catch(Exception ex){
		
		}
	}
	static String data[][] = null;
	public static void getNum(String file) throws Exception{//초기 가격 파일 읽어오기
		
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
            System.out.println(rowCount);
            System.out.println(colCount);
            data = new String[rowCount][colCount+89];
           
            String[] data1={"자체상품코드","품목코드","상품명(50자)","옥션 상품명(50자)","지마켓 상품명(50자)","인터파크 상품명(80자)","SK11번가상품명(50자)","타오바오 상품명(20자)","카페24상품명(255자)","샵카페-세부카테고리코드","옥션 카테고리코드","G마켓 카테고리코드","인터파크 카테고리코드","SK11번가 카테고리코드","타오바오 카테고리 코드","카페24 회원ID","카페24 카테고리 이름","카페24카테고리 코드","판매가","옥션판매가(고정가)","G마켓 판매가","인터파크 판매가격","SK11번가판매가","타오바오 판매가","cafe24 판매가","경매시작가","옥션판매가(경매 - 즉시구매가)","G마켓 공동구매","11번가 공동구매","상품원가","구입가격","Market 공급가","소비자가","판매가능수량","최대구매허용수량","경매입찰가격단위","안전재고","제조사","G마켓 제조사명","G마켓 제조사코드","인터파크 제조사 명","인터파크 제조사 코드","브랜드G마켓 브랜드 명","G마켓 브랜드 코드","인터파크 브랜드 명","인터파크 브랜드 코드","모델명","공급업체","과세여부","물품상태","중고품 사용개월수","원산지구분","원산지","옥션 수입원","제조일자","출시일자","유효일자","상품이미지등록방식선택","대표이미지","리스트이미지","이미지1","이미지2","이미지3","이미지4","상세설명","옵션 형태","옵션1이름","옵션2이름","옵션1","옵션2","옵션금액","옵션별수량","서술형옵션","추가상품","추가상품데이터","저자","키워드","홍보문구(20자)","상품메모","프로필파일경로","","","제조사","상품분류(1)","상품분류(2)","모델명","모델 비고","원산지","매입가","옥션 가격","옥션%","지마켓 가격","지마켓%","인터파크 가격","인터파크%","11번가 가격","11번가 %","옥션 정산금액","지마켓 정산금액","인터파크 정산금액","11번가 정산금액","옥션 이윤","지마켓 이윤","인터파크 이윤","11번가 이윤","추가구성","배송비","상세페이지(누르면 보여짐)","검색어1","검색어2","검색어3","검색어4","검색어5"};

            for(int k=0;k<data1.length;k++){
    			data[0][k]=data1[k];
    		}
            
    		for(int i = 1; i < rowCount; i++){
                for(int k = 0 ; k < colCount+89 ; k++){
                    data[i][k] = "";                        //가져온 데이터 입력
                }
            }
            //엑셀데이터를 배열에 저장
    			for(int i = 1; i < rowCount; i++){
    				for(int k = 0 ; k < colCount ; k++){
    					Cell cell =sheet.getCell(k, i);                         //해당 위치의 셀을 가져옴
    					if(cell == null) continue;
    					data[i][82+k] = cell.getContents();                        //가져온 데이터 입력
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
        System.out.println(data);
	}
	
public static void getNum4(String file) throws Exception{//2. 업데이트 하기 읽기
		
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
        System.out.println(data);
	}
	
	public static void getNum2(String file) throws Exception{//2. 업데이트 하기 읽기
		
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
        System.out.println(data);
	}
	
	static String data10[][] = null;
	public static void getNum10(String file) throws Exception{//카테고리용
		data10 = null;	
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
 
            data10 = new String[rowCount][100];

    		for(int i = 0; i < rowCount; i++){
                for(int k = 0 ; k < 100 ; k++){
                    data10[i][k] = "";                        //가져온 데이터 입력
                }
            }
            //엑셀데이터를 배열에 저장
    			for(int i = 0; i < rowCount; i++){
    				for(int k = 0 ; k < 100 ; k++){
    					Cell cell =sheet.getCell(k, i);                         //해당 위치의 셀을 가져옴
    					if(cell == null) continue;
    					data10[i][k] = cell.getContents();                        //가져온 데이터 입력
    				}
    			}
    		//데이터 검증
    		for(int r = 0; r < data10.length; r++){
                for(int c = 0; c < data10[0].length; c++){
                    System.out.print("["+r+"]["+c+"]"+data10[r][c]+" ");
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
        System.out.println(data10);
	}

	
	///////////////////////////////////
	public static void csv(String file) {
        
        // 현재 인코딩을 확인한다.
        String enc = new java.io.OutputStreamWriter(System.out).getEncoding(); 
        System.out.println( "현재 인코딩 : "  + enc);
         
        try {
             String csvFileName = file;
             
            /*
             *  파일을 실제 쓴다.
             *  csv는 ' , ' 로 구분 지어 주고 csv라는 확장자만 붙여 주면 해당 파일이 완성된다. 
             */
  
            String data123         = "";
           
            /*
             * FileWriter로 쓸 경우 csv에 글씨가 깨져서 나오므로 BufferedWriter를 이용해서   MS949 캐릭터 셋으로 쓴다.
             */
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFileName), "MS949"));

            for(int i=0;i<data.length;i++){
            	for(int k=0;k<82;k++){
            		if(k==0){
            			data123+=data[i][k];
            		}else{
            			data123+=","+data[i][k];
            		}		
            	}
            	data123+="\r\n";
            }
            writer.write(data123);
            writer.close();
 
             
        } catch (IOException e) {
             
            e.printStackTrace();
        }
    }
	/////////////////////////////
	public static void getNum3(String file) throws Exception{//3. 최종 업데이
		String skfWk=new SimpleDateFormat("yyyyMMddHH").format(new Date());
		String dkaghghk=""+Integer.parseInt(skfWk)/85+42*3;//품번암호화
		
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
 
            data = new String[rowCount*3-2][colCount];

    		for(int i = 0; i < rowCount*3-2; i++){
                for(int k = 0 ; k < colCount ; k++){
                    data[i][k] = "";                        //가져온 데이터 입력
                }
            }
            //엑셀데이터를 배열에 저장
    		int number=0;
    		for(int i = 0; i < rowCount; i++){
    			for(int k = 0 ; k < colCount ; k++){
    				Cell cell =sheet.getCell(k, i);                         //해당 위치의 셀을 가져옴
    				if(cell == null) continue;
    				data[i][k] = cell.getContents();                        //가져온 데이터 입력
    				if(i!=0){
    					data[i][0]="a"+getNu(i)+dkaghghk;
    					data[i][3]=data[i][2];data[i][4]=data[i][2];data[i][5]=data[i][2];data[i][6]=data[i][2];data[i][8]=data[i][2];
    				}	
    			}
    			number++;
    		}    		
    		for(int i = 1; i < rowCount; i++){
    			for(int k = 0 ; k < 82 ; k++){
    				Cell cell =sheet.getCell(k, i);                         //해당 위치의 셀을 가져옴
    				if(cell == null) continue;
    				data[number][k] = cell.getContents();                        //가져온 데이터 입력
    				data[number][0]="b"+getNu(i)+dkaghghk;
    				if(k==2){
    					String namidsd1="";
    					String namidsd=cell.getContents().replace("/", ":");
    					String[] array=null;
    					array = namidsd.split(":");
    					dumpArray(array);
    					for(int n=0;n<array.length;n++){
    						if(n==0){
    							namidsd1=array[0];
    						}else if(n==2){
    							namidsd1+=" /"+array[3];
    							namidsd1+=" /"+array[2];
    						}else if(n==3){
    						}else{
    							namidsd1+=" /"+array[n];	
    						}
    					}    					
    					data[number][2]=namidsd1;
    				}
    				data[number][3]=data[number][2];data[number][4]=data[number][2];data[number][5]=data[number][2];data[number][6]=data[number][2];data[number][8]=data[number][2];
    			}
    			number++;
    		}
    		for(int i = 1; i < rowCount; i++){
    			for(int k = 0 ; k < 82 ; k++){
    				Cell cell =sheet.getCell(k, i);                         //해당 위치의 셀을 가져옴
    				if(cell == null) continue;
    				data[number][k] = cell.getContents();                        //가져온 데이터 입력
    				data[number][0]="c"+getNu(i)+dkaghghk;	
    				if(k==2){
    					String namidsd1="";
    					String namidsd=cell.getContents().replace("/", ":");
    					String[] array=null;
    					array = namidsd.split(":");
    					dumpArray(array);
    					for(int n=0;n<array.length;n++){
    						if(n==0){
    							namidsd1=array[0];
    						}else if(n==1){
    							namidsd1+=" /"+array[3];
    							namidsd1+=" /"+array[1];
    						}else if(n==3){
    						}else{
    							namidsd1+=" /"+array[n];
    						}
    					}    					
    					data[number][2]=namidsd1;
    				}
    				data[number][3]=data[number][2];data[number][4]=data[number][2];data[number][5]=data[number][2];data[number][6]=data[number][2];data[number][8]=data[number][2];
    			}
    			number++;
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
        System.out.println(data);
	}
	private static String getNu(int i){
		  if(i<10)
			  return "00"+i;
		  else if(i>=10 && i<100)
			  return "0"+i;
		  else
			  return ""+i;
	}
	public static void main(String[] arg){
		dufrl("C:\\tk작업파일\\html.txt");
		System.out.println(line1);
		System.out.println(line2);
		
		
		new LoginOkk();
	}
		
}
