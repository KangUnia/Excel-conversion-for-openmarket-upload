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
		setTitle("������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);

		JLabel la = new JLabel("���� ��� :");
		la.setLocation(10,10);
		la.setSize(200,20);
		add(la);
 

		JButton la2 = new JButton("���� ã��");
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

		
		JButton lao = new JButton("2.���� ����");
		lao.setLocation(10,100);
		lao.setSize(125,50);
		add(lao); 

		JButton lao1 = new JButton("3.������Ʈ");
		lao1.setLocation(140,100);
		lao1.setSize(125,50);
		add(lao1);
		
		JButton lao2 = new JButton("4.���� ���");
		lao2.setLocation(270,100);
		lao2.setSize(125,50);
		add(lao2);

		JButton lao0 = new JButton("0.ī�װ�");
		lao0.setLocation(300,40);
		lao0.setSize(100,23);
		add(lao0);
		
		JButton lao6 = new JButton("1.���Ϸ�");
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
				FileNameExtensionFilter filter = new FileNameExtensionFilter("��������.xls","xls");
				chooser.setFileFilter(filter);

				int ret = chooser.showOpenDialog(null);
				if (ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "���ϸ� ���������ʾҽ��ϴ�.","���", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				String filePath = chooser.getSelectedFile().getPath();  //���ϰ�θ� ������
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
				try {//����
					getNum10("C:\\tk�۾�����\\ī�װ�.xls");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//����
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
				try {//����
					getNum10("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//����
				
				for(int m=1;m<data.length;m++){
					for(int j=1;j<5;j++){
						for(int k=0;k<data10.length;k++){
							if(data[m][31].equals(data10[k][0])&&j==1){
								String rufrhk="";
								if(data10[k][2].equals("")){
									rufrhk=data10[k][2]+"���� �̻�:"+data10[k][3]+"%"+" ����:"+data10[k][4]+"%";
								}else{
									rufrhk=data10[k][3]+"%";
								}
								data[m][8]=rufrhk;
								data[m][33]=data10[k][1];
								
							}
							if(data[m][32].equals(data10[k][5])&&j==2){
								String rufrhk="";
								if(data10[k][7].equals("")){
									rufrhk=data10[k][7]+"���� �̻�:"+data10[k][8]+"%"+" ����:"+data10[k][9]+"%";
								}else{
									rufrhk=data10[k][8]+"%";
								}
								data[m][10]=rufrhk;
								data[m][34]=data10[k][6];
							}
							if(data[m][33].equals(data10[k][10])&&j==3){
								String rufrhk="";
								if(data10[k][12].equals("")){
									rufrhk=data10[k][12]+"���� �̻�:"+data10[k][13]+"%"+" ����:"+data10[k][14]+"%";
								}else{
									rufrhk=data10[k][13]+"%";
								}
								data[m][12]=rufrhk;
								data[m][35]=data10[k][11];
							}
							if(data[m][34].equals(data10[k][15])&&j==4){
								String rufrhk="";
								if(data10[k][17].equals("")){
									rufrhk=data10[k][17]+"���� �̻�:"+data10[k][18]+"%"+" ����:"+data10[k][19]+"%";
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

		lao.addActionListener(new ActionListener(){//������Ʈ ��ư
			String wpahrqjswl="";
			public void actionPerformed(ActionEvent e){
				String exlefilename = la1.getText();
				String html1 = la31.getText();
				String html3 = la41.getText();
				System.out.println(exlefilename);
//				System.out.println(html1);
//				System.out.println(html3);
				try {
					BufferedWriter out = new BufferedWriter(new FileWriter("C:\\tk�۾�����\\html.txt"));
					out.write(html1+"\r\n"+html3);
					out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}							
				try {//�������� �о� ����
					getNum(exlefilename);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				///////////////////////���� �ҷ� ���� ��///////////////////
				for(int k=1;k<data.length;k++){//���� ����
					wpahrqjswl=data[k][82].replaceAll("^\\s", "").replaceAll("\\s$", "").replace("?", "").replace("#", "").replace("\\", "").replace("|", "").replace("/", "").replace("*", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "");
					String wpahrqjsw2=data[k][83].replaceAll("^\\s", "").replaceAll("\\s$", "").replace("?", "").replace("#", "").replace("\\", "").replace("|", "").replace("/", "").replace("*", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "");
					String wpahrqjsw3=data[k][84].replaceAll("^\\s", "").replaceAll("\\s$", "").replace("?", "").replace("#", "").replace("\\", "").replace("|", "").replace("/", "").replace("*", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "");
					String wpahrqjsw4=data[k][85].replaceAll("^\\s", "").replaceAll("\\s$", "").replace("?", "").replace("#", "").replace("\\", "").replace("|", "").replace("/", "").replace("*", "").replace(":", "").replace("\"", "").replace("<", "").replace(">", "");		
					String wnthcro="C:\\"+wpahrqjswl+"\\"+wpahrqjsw2+"\\"+wpahrqjsw3+"\\"+wpahrqjsw4;
					File rudfh= new File(wnthcro);
					if(!rudfh.exists()){//���� ��� ���� �ϴ��� Ȯ��
						try {
							vhfej(wnthcro);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							try {//���н� �ٽ�
								vhfej(wnthcro);
							} catch (Exception e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}	
					}
					data[k][81]=wnthcro;
					data[k][79]=wnthcro+"\\1.jpg";//������ ���� ��� ����
					data[k][80]=wnthcro+"\\2.jpg";//�������� ��� ����
						
//					firstfile0="C:\\"+wpahrqjswl+"\\"+wpahrqjswl+"(�۾�����)0.xls";
//					firstfile1="C:\\"+wpahrqjswl+"\\"+wpahrqjswl+"(�۾�����).xls";
//					firstfile2="C:\\"+wpahrqjswl+"\\"+wpahrqjswl+"(�������).xls";
				}
				for(int qjsghrow=1;qjsghrow<data.length;qjsghrow++){//�⺻ ä���
//					String qjsgh=getNu(qjsghrow);//���ڿ��� 001
					String ghltn="";
					String wpahr="";
					String wpahr1="";
					String wpahr2="";
					String wpahr4="";
					String wpahrd="";
					wpahrd=data[qjsghrow][82]+" / "+data[qjsghrow][83]+" / "+data[qjsghrow][84]+" / "+data[qjsghrow][85]+" / "+data[qjsghrow][87]+" / "+data[qjsghrow][86];
					wpahr=wpahrd.replaceAll("\\s\\s+", " ").replaceAll("//+", "/").replaceAll("\\s+$", "").replaceAll("/$", "").replaceAll("\\s/\\s$", "");
					data[qjsghrow][2]=wpahr; //data[qjsghrow][3]=wpahr; data[qjsghrow][4]=wpahr; data[qjsghrow][5]=wpahr; data[qjsghrow][6]=wpahr; data[qjsghrow][8]=wpahr;//��ǰ�� 
					data[qjsghrow][9]="12070107";//�� ����ī�װ��ڵ�
					
					data[qjsghrow][19]=data[qjsghrow][89];
					data[qjsghrow][20]=data[qjsghrow][91];
					data[qjsghrow][21]=data[qjsghrow][93];
					data[qjsghrow][22]=data[qjsghrow][95];
					
					data[qjsghrow][15]="im7925";
					data[qjsghrow][18]=data[qjsghrow][88]; data[qjsghrow][24]=data[qjsghrow][88];//�ǸŰ�
					
					data[qjsghrow][25]="1000";data[qjsghrow][26]="10000";data[qjsghrow][33]="9999";//��Ž��۰�//��� ��� ���Ű�//�ǸŰ��ɼ���
					data[qjsghrow][37]=data[qjsghrow][82]; data[qjsghrow][38]=data[qjsghrow][82]; data[qjsghrow][40]=data[qjsghrow][82];//������
					data[qjsghrow][46]=data[qjsghrow][85];//�𵨸�
					data[qjsghrow][48]="A";data[qjsghrow][49]="N";//����//��ǰ ����
					try {
						data[qjsghrow][51]=dnjstkswl(data[qjsghrow][87]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					data[qjsghrow][52]=data[qjsghrow][87];// ������
					data[qjsghrow][57]="M";data[qjsghrow][58]="http://ai.esmplus.com/im7925/JH2/%EB%8F%99%EC%9A%B0%EC%82%B0%EC%97%85/main/�ڵ������/DWV-25DRA/1.jpg";//��ǰ �̹���//��ǰ �̹��� �ʱ� ���
					String html1rkrhd="<img src=\""+line1+"\" /><br />";
					String html2rkrhd="<img src=\"http://ai.esmplus.com/im7925/JH2/"+data[qjsghrow][80].replace("C:\\", "")+"\" /><br />";
					String html3rkrhd="<img src=\""+line2+"\" /><br />";					
					data[qjsghrow][64]=html1rkrhd.replace("\\", "/")+html2rkrhd.replace("\\", "/")+html3rkrhd.replace("\\", "/");//�󼼼���	
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
					data[qjsghrow][63]=result;//�������� �˼�
					data[qjsghrow][65]="2";data[qjsghrow][66]="��ۺ�(��ȭ����ʼ�)";data[qjsghrow][67]="";data[qjsghrow][68]="����������(1600-3176)";data[qjsghrow][69]="";data[qjsghrow][70]="0";data[qjsghrow][71]="9999";//���� ����//����1�̸�//����1
					String[] array=null;
					array = data[qjsghrow][85].split(":");
					dumpArray(array);
					for(int d=0;d<array.length;d++){
						//�߰� �ݾ� �� īŻ�α� �ۼ�Ʈ�� �ٽ� ����Ͽ� ���� �ֱ�
					}
					if(!data[qjsghrow][105].equals("")){data[qjsghrow][73]="Y"; data[qjsghrow][74]=data[qjsghrow][105];}else{data[qjsghrow][73]="N";}//�߰�����
					data[qjsghrow][108]=data[qjsghrow][82];data[qjsghrow][109]=data[qjsghrow][83];data[qjsghrow][110]=data[qjsghrow][84];data[qjsghrow][111]=data[qjsghrow][85];data[qjsghrow][112]=data[qjsghrow][86];data[qjsghrow][113]=data[qjsghrow][87];//�˻���
					data[qjsghrow][77]="�������/����������/1�� ����A/S";//ȫ������	
				}

			for(int d=0;d<data.length;d++){
				for(int i=0;i<data[1].length;i++){
					System.out.print("["+d+"]["+i+"]"+data[d][i] );
				}	
				System.out.println("");
			}
			
			try{
				simpleExcelWrite(new File("C:\\"+wpahrqjswl+"\\�ӽ� �۾� ����.xls") , data);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {	
				BufferedWriter out = new BufferedWriter(new FileWriter("C:\\tk�۾�����\\rlfhr.txt"));
				out.write("C:\\"+wpahrqjswl+"\\�ӽ� �۾� ����.xls");
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
//					simpleExcelWrite1(new File(firstfile2) , data);//�������� �� �����
			//		
		}
///////////////////////////////////////////////////////////				
	});
		lao1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dufrl1("C:\\tk�۾�����\\rlfhr.txt");
				String exlefieew=la1.getText();
				if(exlefieew.equals("")){
					if(line3.equals("")){//���̾�α� ���
						
					}else{//���� �о ����
						try {
							getNum2(line3);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						for(int k=1;k<data.length;k++){
							//data[k][88]=data[k][18];//�ǸŰ� ->�ʱ⵵�Ű��� ������Ʈ
							//data[k][88]=data[k][18];//
							data[k][82]=data[k][37];//������
							data[k][85]=data[k][46];//�𵨸�
							data[k][87]=data[k][52];//������
							
							try {
								String htmlrest1 = URLEncoder.encode(data[k][61],"UTF-8").replace("+","%20");
								data[k][107]=htmlrest1.replace("%3A",":").replace("%2F","/").replace("%7E","~").replace("%21","!").replace("%40","@").replace("%23","#").replace("%24","$").replace("%26","&").replace("%28","(").replace("%29",")").replace("%3D","=").replace("%2C",",").replace("%3B",";").replace("%3F","?").replace("%2B","+").replace("%27","'").replace("%22","\"").replace("%25","%");			
							} catch (UnsupportedEncodingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							dufrl("C:\\tk�۾�����\\html.txt");
							String html1rkrhd="<img src=\""+line1+"\" /><br />";
							String html2rkrhd="<img src=\""+data[k][107]+"\" /><br />";
							String html3rkrhd="<img src=\""+line2+"\" /><br />";
							data[k][64]=html1rkrhd+html2rkrhd+html3rkrhd;//�������� ������Ʈ
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
							
							////�ɼ� ������Ʈ 
							
							data[k][105]=data[k][74];//�߰�����
							data[k][76]=data[k][108]+";"+data[k][109]+";"+data[k][110]+";"+data[k][111]+";"+data[k][112];//Ű����
							
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
							f1.renameTo(new File(line3.replace("�ӽ� �۾� ����", "�ӽ� �۾� ����(0)")));//���� �̸� ����
							simpleExcelWrite(new File(line3) , data);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							BufferedWriter out = new BufferedWriter(new FileWriter("C:\\tk�۾�����\\rlfhr.txt"));
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
						//data[k][88]=data[k][18];//�ǸŰ� ->�ʱ⵵�Ű��� ������Ʈ
						//data[k][88]=data[k][18];//
						data[k][82]=data[k][37];//������
						data[k][85]=data[k][46];//�𵨸�
						data[k][87]=data[k][52];//������
						
						dufrl("C:\\tk�۾�����\\html.txt");
						String html1rkrhd="<img src=\""+line1+"\" /><br />";
						String html2rkrhd="<img src=\""+data[k][107]+"\" /><br />";
						String html3rkrhd="<img src=\""+line2+"\" /><br />";
						data[k][64]=html1rkrhd+html2rkrhd+html3rkrhd;//�������� ������Ʈ
						String result="";
							
						int cheking=htmlchek(data[k][107]);
						if(cheking==0){
							result="X";
						}else if(cheking==1){
							result="O";
						}
						data[k][63]=result;
							
						////�ɼ� ������Ʈ 
							
						data[k][105]=data[k][74];//�߰�����
						data[k][76]=data[k][108]+";"+data[k][109]+";"+data[k][110]+";"+data[k][111]+";"+data[k][112];//Ű����
							
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
						f1.renameTo(new File(exlefieew.replace("�ӽ� �۾� ����", "�ӽ� �۾� ����(0)")));//���� �̸� ����
						simpleExcelWrite(new File(exlefieew) , data);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {	
						BufferedWriter out = new BufferedWriter(new FileWriter("C:\\tk�۾�����\\rlfhr.txt"));
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
		});//2 ������Ʈ �̺�Ʈ

		lao2.addActionListener(new ActionListener(){//3. ������ư
			public void actionPerformed(ActionEvent e){
				dufrl1("C:\\tk�۾�����\\rlfhr.txt");
				try {
					getNum3(line3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int k=1;k<data.length;k++){//�ʿ� ���°� �����
					data[k][7]=""; data[k][14]=""; data[k][23]=""; data[k][27]=""; data[k][28]=""; data[k][29]=""; data[k][30]=""; data[k][31]=""; data[k][32]=""; data[k][34]=""; data[k][35]=""; data[k][36]=""; data[k][47]=""; data[k][50]=""; data[k][53]=""; data[k][54]=""; data[k][55]=""; data[k][56]=""; data[k][59]=""; data[k][60]=""; data[k][61]=""; data[k][62]=""; data[k][63]=""; data[k][75]=""; 
				}
				try {
					simpleExcelWrite(new File(line3.replace("�ӽ�", "����")) , data);
					simpleExcelWrite1(new File(line3.replace("�ӽ�", "���")) , data);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				csv(line3.replace(".xls", ".csv").replace("�ӽ�", "����"));
				
			}
				
		});//3 ���� ��ư
		
		
	}//��
	
    public final static void simpleExcelWrite1(File file , String data[][]) throws Exception{
    	  
    	WritableWorkbook workbook = null;
    	WritableSheet sheet = null;
    	  
    	try{
    	   
    		workbook = Workbook.createWorkbook(file);     //������ ���ϸ� ��η� ��ũ�� �� ���������� ����ϴ�.
    		workbook.createSheet("Sheet", 0);                    //������ ��ũ�Ͽ� ��Ʈ�� ����ϴ�. "Sheet" �� ��Ʈ���� �˴ϴ�.
    		sheet = workbook.getSheet(0);                         //��Ʈ�� �����ɴϴ�.
    	   
    		WritableCellFormat cellFormat = new WritableCellFormat();    //���� ��Ÿ���� �����ϱ� ���� �κ��Դϴ�.
    		cellFormat.setBorder(Border.ALL , BorderLineStyle.THIN);      //���� ��Ÿ���� �����մϴ�. �׵θ��� ���α׸��°ſ���
    	   
    		// ���ۺ��� �����鼭 ������ �����͸� �ۼ��մϴ�.
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
    	   
    		workbook = Workbook.createWorkbook(file);     //������ ���ϸ� ��η� ��ũ�� �� ���������� ����ϴ�.
    		workbook.createSheet("Sheet", 0);                    //������ ��ũ�Ͽ� ��Ʈ�� ����ϴ�. "Sheet" �� ��Ʈ���� �˴ϴ�.
    		sheet = workbook.getSheet(0);                         //��Ʈ�� �����ɴϴ�.
    	   
    		WritableCellFormat cellFormat = new WritableCellFormat();    //���� ��Ÿ���� �����ϱ� ���� �κ��Դϴ�.
    		cellFormat.setBorder(Border.ALL , BorderLineStyle.THIN);      //���� ��Ÿ���� �����մϴ�. �׵θ��� ���α׸��°ſ���
    	   
    		// ���ۺ��� �����鼭 ������ �����͸� �ۼ��մϴ�.
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
		System.out.println("html �۾�="+num1);
		return num1;	
	}
	static String line1 = "";
	static String line2 = "";
	static String line3 = "";
	public static String dnjstkswl(String name) throws Exception{
    	String rnqns="";
    	if(name.equals("����")){
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
			System.out.println("������ �����Ͽ����ϴ�.");
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
	public static void getNum(String file) throws Exception{//�ʱ� ���� ���� �о����
		
		Workbook workbook = null;
        Sheet sheet = null;
 
        try{
        	workbook = Workbook.getWorkbook(new File(file));        //�������� ��θ� ����
        	sheet = workbook.getSheet(0);                                   //ù��° ��Ʈ�� ����
 
            int rowCount = sheet.getRows();                                 //�� ���� ���� ������
            int colCount = sheet.getColumns();                              //�� ���� ���� ������
 
            if(rowCount <= 0){
                throw new Exception("Read �� �����Ͱ� ������ �������� �ʽ��ϴ�.");
            }
            System.out.println(rowCount);
            System.out.println(colCount);
            data = new String[rowCount][colCount+89];
           
            String[] data1={"��ü��ǰ�ڵ�","ǰ���ڵ�","��ǰ��(50��)","���� ��ǰ��(50��)","������ ��ǰ��(50��)","������ũ ��ǰ��(80��)","SK11������ǰ��(50��)","Ÿ���ٿ� ��ǰ��(20��)","ī��24��ǰ��(255��)","��ī��-����ī�װ��ڵ�","���� ī�װ��ڵ�","G���� ī�װ��ڵ�","������ũ ī�װ��ڵ�","SK11���� ī�װ��ڵ�","Ÿ���ٿ� ī�װ� �ڵ�","ī��24 ȸ��ID","ī��24 ī�װ� �̸�","ī��24ī�װ� �ڵ�","�ǸŰ�","�����ǸŰ�(������)","G���� �ǸŰ�","������ũ �ǸŰ���","SK11�����ǸŰ�","Ÿ���ٿ� �ǸŰ�","cafe24 �ǸŰ�","��Ž��۰�","�����ǸŰ�(��� - ��ñ��Ű�)","G���� ��������","11���� ��������","��ǰ����","���԰���","Market ���ް�","�Һ��ڰ�","�ǸŰ��ɼ���","�ִ뱸��������","����������ݴ���","�������","������","G���� �������","G���� �������ڵ�","������ũ ������ ��","������ũ ������ �ڵ�","�귣��G���� �귣�� ��","G���� �귣�� �ڵ�","������ũ �귣�� ��","������ũ �귣�� �ڵ�","�𵨸�","���޾�ü","��������","��ǰ����","�߰�ǰ ��밳����","����������","������","���� ���Կ�","��������","�������","��ȿ����","��ǰ�̹�����Ϲ�ļ���","��ǥ�̹���","����Ʈ�̹���","�̹���1","�̹���2","�̹���3","�̹���4","�󼼼���","�ɼ� ����","�ɼ�1�̸�","�ɼ�2�̸�","�ɼ�1","�ɼ�2","�ɼǱݾ�","�ɼǺ�����","�������ɼ�","�߰���ǰ","�߰���ǰ������","����","Ű����","ȫ������(20��)","��ǰ�޸�","���������ϰ��","","","������","��ǰ�з�(1)","��ǰ�з�(2)","�𵨸�","�� ���","������","���԰�","���� ����","����%","������ ����","������%","������ũ ����","������ũ%","11���� ����","11���� %","���� ����ݾ�","������ ����ݾ�","������ũ ����ݾ�","11���� ����ݾ�","���� ����","������ ����","������ũ ����","11���� ����","�߰�����","��ۺ�","��������(������ ������)","�˻���1","�˻���2","�˻���3","�˻���4","�˻���5"};

            for(int k=0;k<data1.length;k++){
    			data[0][k]=data1[k];
    		}
            
    		for(int i = 1; i < rowCount; i++){
                for(int k = 0 ; k < colCount+89 ; k++){
                    data[i][k] = "";                        //������ ������ �Է�
                }
            }
            //���������͸� �迭�� ����
    			for(int i = 1; i < rowCount; i++){
    				for(int k = 0 ; k < colCount ; k++){
    					Cell cell =sheet.getCell(k, i);                         //�ش� ��ġ�� ���� ������
    					if(cell == null) continue;
    					data[i][82+k] = cell.getContents();                        //������ ������ �Է�
    				}
    			}
    		//������ ����
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
	
public static void getNum4(String file) throws Exception{//2. ������Ʈ �ϱ� �б�
		
		Workbook workbook = null;
        Sheet sheet = null;
 
        try{
        	workbook = Workbook.getWorkbook(new File(file));        //�������� ��θ� ����
        	sheet = workbook.getSheet(0);                                   //ù��° ��Ʈ�� ����
 
            int rowCount = sheet.getRows();                                 //�� ���� ���� ������
            int colCount = sheet.getColumns();                              //�� ���� ���� ������
 
            if(rowCount <= 0){
                throw new Exception("Read �� �����Ͱ� ������ �������� �ʽ��ϴ�.");
            }
 
            data = new String[rowCount][colCount];

    		for(int i = 0; i < rowCount; i++){
                for(int k = 0 ; k < colCount ; k++){
                    data[i][k] = "";                        //������ ������ �Է�
                }
            }
            //���������͸� �迭�� ����
    			for(int i = 0; i < rowCount; i++){
    				for(int k = 0 ; k < colCount ; k++){
    					Cell cell =sheet.getCell(k, i);                         //�ش� ��ġ�� ���� ������
    					if(cell == null) continue;
    					data[i][k] = cell.getContents();                        //������ ������ �Է�
    				}
    			}
    		//������ ����
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
	
	public static void getNum2(String file) throws Exception{//2. ������Ʈ �ϱ� �б�
		
		Workbook workbook = null;
        Sheet sheet = null;
 
        try{
        	workbook = Workbook.getWorkbook(new File(file));        //�������� ��θ� ����
        	sheet = workbook.getSheet(0);                                   //ù��° ��Ʈ�� ����
 
            int rowCount = sheet.getRows();                                 //�� ���� ���� ������
            int colCount = sheet.getColumns();                              //�� ���� ���� ������
 
            if(rowCount <= 0){
                throw new Exception("Read �� �����Ͱ� ������ �������� �ʽ��ϴ�.");
            }
 
            data = new String[rowCount][colCount];

    		for(int i = 0; i < rowCount; i++){
                for(int k = 0 ; k < colCount ; k++){
                    data[i][k] = "";                        //������ ������ �Է�
                }
            }
            //���������͸� �迭�� ����
    			for(int i = 0; i < rowCount; i++){
    				for(int k = 0 ; k < colCount ; k++){
    					Cell cell =sheet.getCell(k, i);                         //�ش� ��ġ�� ���� ������
    					if(cell == null) continue;
    					data[i][k] = cell.getContents();                        //������ ������ �Է�
    				}
    			}
    		//������ ����
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
	public static void getNum10(String file) throws Exception{//ī�װ���
		data10 = null;	
		Workbook workbook = null;
        Sheet sheet = null;
 
        try{
        	workbook = Workbook.getWorkbook(new File(file));        //�������� ��θ� ����
        	sheet = workbook.getSheet(0);                                   //ù��° ��Ʈ�� ����
 
            int rowCount = sheet.getRows();                                 //�� ���� ���� ������
            int colCount = sheet.getColumns();                              //�� ���� ���� ������
 
            if(rowCount <= 0){
                throw new Exception("Read �� �����Ͱ� ������ �������� �ʽ��ϴ�.");
            }
 
            data10 = new String[rowCount][100];

    		for(int i = 0; i < rowCount; i++){
                for(int k = 0 ; k < 100 ; k++){
                    data10[i][k] = "";                        //������ ������ �Է�
                }
            }
            //���������͸� �迭�� ����
    			for(int i = 0; i < rowCount; i++){
    				for(int k = 0 ; k < 100 ; k++){
    					Cell cell =sheet.getCell(k, i);                         //�ش� ��ġ�� ���� ������
    					if(cell == null) continue;
    					data10[i][k] = cell.getContents();                        //������ ������ �Է�
    				}
    			}
    		//������ ����
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
        
        // ���� ���ڵ��� Ȯ���Ѵ�.
        String enc = new java.io.OutputStreamWriter(System.out).getEncoding(); 
        System.out.println( "���� ���ڵ� : "  + enc);
         
        try {
             String csvFileName = file;
             
            /*
             *  ������ ���� ����.
             *  csv�� ' , ' �� ���� ���� �ְ� csv��� Ȯ���ڸ� �ٿ� �ָ� �ش� ������ �ϼ��ȴ�. 
             */
  
            String data123         = "";
           
            /*
             * FileWriter�� �� ��� csv�� �۾��� ������ �����Ƿ� BufferedWriter�� �̿��ؼ�   MS949 ĳ���� ������ ����.
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
	public static void getNum3(String file) throws Exception{//3. ���� ������
		String skfWk=new SimpleDateFormat("yyyyMMddHH").format(new Date());
		String dkaghghk=""+Integer.parseInt(skfWk)/85+42*3;//ǰ����ȣȭ
		
		Workbook workbook = null;
        Sheet sheet = null;
 
        try{
        	workbook = Workbook.getWorkbook(new File(file));        //�������� ��θ� ����
        	sheet = workbook.getSheet(0);                                   //ù��° ��Ʈ�� ����
 
            int rowCount = sheet.getRows();                                 //�� ���� ���� ������
            int colCount = sheet.getColumns();                              //�� ���� ���� ������
 
            if(rowCount <= 0){
                throw new Exception("Read �� �����Ͱ� ������ �������� �ʽ��ϴ�.");
            }
 
            data = new String[rowCount*3-2][colCount];

    		for(int i = 0; i < rowCount*3-2; i++){
                for(int k = 0 ; k < colCount ; k++){
                    data[i][k] = "";                        //������ ������ �Է�
                }
            }
            //���������͸� �迭�� ����
    		int number=0;
    		for(int i = 0; i < rowCount; i++){
    			for(int k = 0 ; k < colCount ; k++){
    				Cell cell =sheet.getCell(k, i);                         //�ش� ��ġ�� ���� ������
    				if(cell == null) continue;
    				data[i][k] = cell.getContents();                        //������ ������ �Է�
    				if(i!=0){
    					data[i][0]="a"+getNu(i)+dkaghghk;
    					data[i][3]=data[i][2];data[i][4]=data[i][2];data[i][5]=data[i][2];data[i][6]=data[i][2];data[i][8]=data[i][2];
    				}	
    			}
    			number++;
    		}    		
    		for(int i = 1; i < rowCount; i++){
    			for(int k = 0 ; k < 82 ; k++){
    				Cell cell =sheet.getCell(k, i);                         //�ش� ��ġ�� ���� ������
    				if(cell == null) continue;
    				data[number][k] = cell.getContents();                        //������ ������ �Է�
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
    				Cell cell =sheet.getCell(k, i);                         //�ش� ��ġ�� ���� ������
    				if(cell == null) continue;
    				data[number][k] = cell.getContents();                        //������ ������ �Է�
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
    		//������ ����
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
		dufrl("C:\\tk�۾�����\\html.txt");
		System.out.println(line1);
		System.out.println(line2);
		
		
		new LoginOkk();
	}
		
}
