package hr331;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *��Ŀ����:������Դ����ϵͳ
 *����:PersonBean
 *������:ʵ�ֶ���Ա��Ϣ��������ݿ�����Ĺ��ܣ�������Ա��Ϣ�����ӡ��޸ġ�ɾ������ѯ��
 *������:an
 *�޸ı�ע:
 *@version 1.0.0
 */

public class PersonBean {
	Database db = new Database();
	ResultSet res=null;

	String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
	/*
	 * �����Ա��Ϣ
	 * ����:(1)ģ��1��������Ϣ�����������Ա��Ϣ,�����ݵ��뵽���ݿ�
	 * 
	 */
		public void add(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10){
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
		this.s5 = s5;
		this.s6 = s6;
		this.s7 = s7;
		this.s8 = s8;
		this.s9 = s9;
		this.s10 = s10;
		//checkEmpty();//����ı����Ƿ�Ϊ��
		
		String sql="insert into Person values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"')";
	    Database.update(sql);//��������
	}
	/*
	 * ����ı����Ƿ�Ϊ��
	 */
		public void checkEmpty(){
			if((s1.trim().equals("")) || (s1 == null)){
				JOptionPane.showMessageDialog(null, "����д��ţ�");
			}else if((s2.trim().equals("")) || (s2  == null)){
				JOptionPane.showMessageDialog(null, "����д������");
			}else if((s3.trim().equals("")) || (s3== null)){
				JOptionPane.showMessageDialog(null, "����д�Ա�");
			}else if((s4.trim().equals("")) || (s4 == null)){
				JOptionPane.showMessageDialog(null, "����д�������£�");
			}else if((s5.trim().equals("")) || (s5 == null)){
				JOptionPane.showMessageDialog(null, "����д���壡");
			}else if((s6.trim().equals("")) || (s6 == null)){
				JOptionPane.showMessageDialog(null, "����д��ַ��");
			}else if((s7.trim().equals("")) || (s7 == null)){
				JOptionPane.showMessageDialog(null, "����д���ţ�");
			}else if((s8.trim().equals("")) || (s8 == null)){
				JOptionPane.showMessageDialog(null, "����д������Ϣ��");
			}
		}
		
		/*
		 * ��ȡPerson�������������
		 * ���ڣ�(1)ģ��1��������Ϣ�����������Ա��Ϣ,�Զ���ȡPersonId��ֵ
		 */
	public int getID(){
		int id = 1;
		String sql = "select max(PersonID) from Person";//count()��������ͳ��**
		//Database db = new Database();
		res = Database.query(sql);//��ѯ
		try {
			if(res.next()){//���������,���ȡ��������
				
				id = res.getInt(1)+1;
			
			}else{
				
				id =1;//��,id��Ϊ1
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Database.close();//�ر����ݿ�
		}
		return id;
	}
	/*
	 * ��ȡPerson�����ȫ����Ϣ
	 * ����:(1)ģ��1��������Ϣ�������޸���Ա��Ϣ�Զ������Ϣ��JComboBox�����
	 * 
	 */
	@SuppressWarnings("null")
	public String[] getPersonMsg(){
		
		String sql = "select * from Person";//��ѯ������Ϣ
		String s[] = null;
		int i = 0;
		int rows = 0;
		res = Database.query(sql);
		try {
			if(res.last()){
				rows = res.getRow();//��ȡ����
			}
			
			if(rows == 0){//����Ϊ0
				s[0]="";
				s[1]="";
				s[2]="";
			}else{//������Ϊ0
				s = new String[rows];
				res.first();//��һ��
				res.previous();//�����ѯ
				while(res.next()){
					s[i]=res.getString("PersonID")+"-"+res.getString("Name");
					i++;//�������ۼ�
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Database.close();//�ر����ݿ�
		}
		return s;
	}
	String id;
	/*
	 * ��ѯPerson�����Ϣ
	 * ����:(1)ģ��1��������Ϣ�������޸���Ա��Ϣ������JComboBox���ʱ,����PersonID��ȡ��Ϣ
	 * 
	 */
	public String[] search(String id){
		this.id = id;
	
		String sql = "select * from Person where PersonID = "+id+"";//����PersonID��ѯ��Ϣ
		
		res = Database.query(sql);//��ѯ��Ϣ
		String s[] = new String[10];//����һ������,���ڽ��մ����ݿ⵼�����Ϣ
		try {
				while(res.next()){
					s[0] = res.getString("PersonID");
					s[1] = res.getString("Name");
					s[2] = res.getString("Sex");
					s[3] = res.getString("Birth");
					s[4] = res.getString("Nat");//����
					s[5] = res.getString("Address");
					s[6] = res.getString("DeptID");
					s[7] = res.getString("Salary");//����
					s[8] = res.getString("Assess");//������Ϣ
					s[9] = res.getString("Other");//������Ϣ
				}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			Database.close();//�ر����ݿ�
		}
		return s;//����һά����
	}
	
	String pid;
	/*
	 * ɾ����Ա��Ϣ
	 * ����:(1)ģ��1��������Ϣ������ɾ����Ա��Ϣ
	 * 
	 */
	public void delete(String pid){
		this.pid = pid;
		//����PersonIDɾ����Ϣ
		String sql = "delete from Person where PersonID="+pid+"";
		Database.update(sql);
		
		Database.close();//�ر����ݿ�
		
		
	}
	
	/*
	 * �漰Dept���Person��Ĳ�ѯ
	 * ����:(1)ģ��1��������Ϣ������ɾ����Ա��Ϣ�Ͳ�ѯ��Ա��Ϣ������Ϣ���ص����
	 * 
	 */
	public String[][] select(){
		//�漰Dept��Person��Ĳ�ѯͨ��DeptID��������
		String sql = "select PersonID,Name,Birth,Nat,Address,Dept.DeptID,Person.DeptID,B_Dept,S_Dept from Person,Dept where Person.DeptID = Dept.DeptID order by PersonID";
		
		int i = 0;
		int rows = 0;
		String s[][] = null;//��ά����
		res = Database.query(sql);
		
		try {
			
			if(res.last()){
				rows = res.getRow();//��ȡ����
			}
			if(rows == 0){//����Ϊ0
			
				s = new String[1][6];
				s[0][0] = "";
				s[0][1] = "";
				s[0][2] = "";
				s[0][3] = "";
				s[0][4] = "";
				s[0][5] = "";
				
			}else{//������Ϊ0
				s = new String[rows][6];
		
				res.first();//��һ��
				res.previous();//�����ѯ
				while(res.next()){
				
					s[i][0]=res.getString("PersonID");
					s[i][1]=res.getString("Name");
					s[i][2]=res.getString("Birth");
					s[i][3]=res.getString("Nat");//����
					s[i][4]=res.getString("Address");
					s[i][5]=res.getString("B_Dept")+"-"+res.getString("S_Dept");
					i++;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return s;//���ض�ά����
	}
	
	/*
	 * �޸���Ա��Ϣ
	 * ����:(1)ģ��1��������Ϣ�������޸���Ա��Ϣ������PersonID�����޸�
	 * 
	 */
	public void update(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10){
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;
		this.s4=s4;
		this.s5=s5;
		this.s6=s6;
		this.s7=s7;
		this.s8=s8;
		this.s9=s9;
		this.s10=s10;
		
		String sql="update Person set Name='"+s2+"',Sex='"+s3
				+"',Birth='"+s4+"',Nat='"+s5+"',Address='"+s6+"',DeptID="+s7+",Salary='"+s8+"',Assess='"+s9+"',Other='"+s10+"' where PersonID="+s1+"";
		
		Database.update(sql);
	}
	/*
	 * 
	 * �޸Ĳ��ź�
	 * ����:(1)ģ��2����Ա������������Ա����,���Ĳ��ű��
	 */
	String deptId;
	String personId;
	public void updateDept(String personId,String deptId){
		this.personId=personId;
		this.deptId=deptId;
	//���Ĳ��ű��
		String sql="update Person set DeptID="+deptId+" where PersonID="+personId+"";
		Database.update(sql);
	}
	/*
	 * ������Ա����
	 * ����:(1)ģ��4�����ʷ�����������ʷ���,������Ա����
	 * 
	 */
	String sal;
	public void updateSalary(String personId,String sal){
		this.personId=personId;
		this.sal=sal;
		String sql="update Person set Salary='"+sal+"' where PersonID="+personId+"";
		Database.update(sql);
	}
	/*
	 * ������Ա����
	 * ����:(1)ģ��4����Ա���˹�������Ա����,������Ա������Ϣ
	 * 
	 */
	String assess;
	public void updateAssess(String personId,String assess){
		this.personId=personId;
		this.assess=assess;
		
		String sql="update Person set Assess='"+assess+"' where PersonID="+personId+"";
		Database.update(sql);
	}
	
	/*
	 *��ȡ���ű��
	 *����:(1)ģ��2����Ա������������Ա��������ȡ����ԭ���ı��
	 */
	 
	public String getDeptId(String s1){
		this.s1=s1;
		String i=null;
		
		String sql="select DeptID from Person where PersonID="+s1+"";
		res=Database.query(sql);
		try {
			if(res.next()){
				i=res.getString("DeptID");
			}else{
				i="";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return i;
		
	}
	/*
	 *��ȡ���ű��
	 *����:(1)ģ��2����Ա������������Ա���������ݲ��ű�Ż�ȡ��������
	 */
	
	public String getDept(String s1){
		this.s1=s1;
		String i=null;
		
		String sql="select B_Dept from dept where DeptID="+s1+"";
		res=Database.query(sql);
		try {
			if(res.next()){
				i=res.getString("B_Dept");
			}else{
				i="";
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return i;
		
	}
}
