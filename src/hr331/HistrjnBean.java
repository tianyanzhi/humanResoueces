package hr331;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *��Ŀ����:������Դ����ϵͳ
 *����:HistrjnBean
 *������:ʵ�ֶ���ʷ��ˮ�����Ϣ�������ݿ�����Ĺ��ܣ�����������ˮ��Ϣ���ṩ���ַ�ʽ�Ĳ�ѯ��
 *������:an
 *�޸ı�ע:
 *@version 1.0.0
 */

public class HistrjnBean {
	
	Database db = new Database();
	
	ResultSet res = null;
	
	String id;
	
	String s1,s2,s3,s4,s5,s6,s7;
	
	/*
	 * ��Ա������ʷ��ѯ
	 * ����:(1)ģ��2����Ա��������������ʷ��ѯ����Histrjn�����Ա������Ϣ���ص������
	 * 
	 */
	public String[][] transferHis(){
		String s[][] = null;
		int i = 0;
		int rows = 0;
		String sql = "select JourNo,Name,OldInfo,NewInfo,ChgTime,RegDate,FromAcc,Person.PersonID,Histrjn.PersonID "
				+ "from Person,Histrjn where Person.PersonID = Histrjn.PersonID and FromAcc = '��Ա����' order by JourNo";
		res = Database.query(sql);
		
		try {
			if(res.last()){
				rows = res.getRow();//��ȡ����
			}
		
			if(rows == 0){
				s = new String[1][6];
				s[0][0]="";
				s[0][1]="";
				s[0][2]="";
				s[0][3]="";
				s[0][4]="";
				s[0][5]="";
			}else{
				s = new String[rows][6];	
				res.first();//��һ��
				res.previous();//�����ѯ
				while(res.next()){
					s[i][0]=res.getString("JourNo");
					s[i][1]=res.getString("Name");
					s[i][2]=res.getString("OldInfo");
					s[i][3]=res.getString("NewInfo");
					s[i][4]=res.getString("ChgTime");
					s[i][5]=res.getString("RegDate");
					i++;//�������ۼ�
				}
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Database.close();//�ر����ݿ�
		}
		return s;//���ض�ά����
	}
	
	
	
	
	
	
	/*
	 * ��Ա������ʷ��ѯ
	 * ����:(1)ģ��3����Ա���˹���������ʷ��ѯ����Histrjn�����Ա������Ϣ���ص������
	 * 
	 */
	public String[][] assessHis(){
		String s[][] = null;
		int i = 0;
		int rows = 0;
		String sql = "select JourNo,Name,OldInfo,NewInfo,ChgTime,RegDate,FromAcc,Person.PersonID,Histrjn.PersonID "
				+ "from Person,Histrjn where Person.PersonID = Histrjn.PersonID and FromAcc = '��Ա����' order by JourNo";
		res = Database.query(sql);
		try {
			if(res.last()){
				rows = res.getRow();
			}
		
			if(rows == 0){
				s = new String[1][6];
				s[0][0]="";
				s[0][1]="";
				s[0][2]="";
				s[0][3]="";
				s[0][4]="";
				s[0][5]="";
			}else{
				s = new String[rows][6];	
				res.first();//��һ��
				res.previous();//�����ѯ
				while(res.next()){
					s[i][0]=res.getString("JourNo");
					s[i][1]=res.getString("Name");
					s[i][2]=res.getString("OldInfo");
					s[i][3]=res.getString("NewInfo");
					s[i][4]=res.getString("ChgTime");
					s[i][5]=res.getString("RegDate");
					i++;
				}
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Database.close();//�ر����ݿ�
		}
		return s;//����
	}
	
	
	
	/*
	 * ���ʷ�����ʷ��ѯ
	 * ����:(1)ģ��4�����ʷ���������ʷ�����ʷ��ѯ����Histrjn������ʷ�����Ϣ���ص������
	 * 
	 */
	public String[][] salaryHis(){
		String s[][] = null;//��ά����
		int i = 0;
		int rows = 0;
		//�漰2�ű�Ĳ�ѯ,Ҫͨ�������������
		String sql = "select JourNo,Name,OldInfo,NewInfo,ChgTime,RegDate,FromAcc,Person.PersonID,Histrjn.PersonID "
				+ "from Person,Histrjn where Person.PersonID = Histrjn.PersonID and FromAcc = '���ʷ���' order by JourNo";
		res = Database.query(sql);
		try {
			if(res.last()){
				rows = res.getRow();
			}
			if(rows == 0){
				s = new String[1][6];
				s[0][0]="";
				s[0][1]="";
				s[0][2]="";
				s[0][3]="";
				s[0][4]="";
				s[0][5]="";
			}else{
				s = new String[rows][6];	
				res.first();//��һ��
				res.previous();//�����ѯ
				while(res.next()){
					s[i][0]=res.getString("JourNo");
					s[i][1]=res.getString("Name");
					s[i][2]=res.getString("OldInfo");
					s[i][3]=res.getString("NewInfo");
					s[i][4]=res.getString("ChgTime");
					s[i][5]=res.getString("RegDate");
					i++;
				}
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Database.close();
		}
		return s;
	}
	
	String personId;

/*
 * ͳ��Histrjn�������ˮ������
 * ����:(1)ģ��2����Ա����������Ա����,��ȡԭ�����ŵı��
 * 
 */
public int countJourNo(){
	int no=1;
	String sql="select max(JourNo) from Histrjn ";
	res=Database.query(sql);
	
	try {
		if(res.next()){
			no=res.getInt(1)+1;
		}else{
			no=1;
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return no;
}

/*
 * ��Ӳ�ѯ��ʷ��Ϣ
 * ����:(1)ģ��2�����ʷ��������ģ��3����Ա���˹�����ģ��4�����ʹ����ֱ�
 * ��Histrjn�����Ӧ��Ϣ���ص���Ӧ��ʷ��ѯ�ı����
 * 
 */
public void add(String s1, String s2,String s3,String s4,String s5,String s6,String s7){
	this.s1=s1;
	this.s2=s2;
	this.s3=s3;
	this.s4=s4;
	this.s5=s5;
	this.s6=s6;
	this.s7=s7;
	
	String sql="insert into Histrjn(JourNo,FromAcc,OldInfo,NewInfo,RegDate,ChgTime,PersonID) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
	
	Database.update(sql);

	
}


/*
 * ͳ���޸Ĵ���
 * ���ڣ�(1)ģ��2����Ա������������Ա��������ȡ�޸ĵ���ʷ����
 * 
 */
public int countChgTime(String s2,String s7){
	this.s2=s2;
	this.s7=s7;
	int i=1;
	
	String sql="select max(ChgTime) from Histrjn where FromAcc='"+s2+"' and PersonID="+s7+"";
	
	res=Database.query(sql);
	
	try {
		if(res.next()){
			i=res.getInt(1)+1;
		}else{
			i=1;
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}finally{
		Database.close();
	}
	
	return i;
}

	
}
