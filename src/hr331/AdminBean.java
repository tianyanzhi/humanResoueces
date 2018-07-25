package hr331;

import java.sql.*;


/**
 *��Ŀ����:������Դ����ϵͳ
 *����:AdminBean
 *������:ʵ�ֶԹ���Ա��Ϣ��������ݿ�����Ĺ��ܣ���ѯ
 *������:an
 *�޸ı�ע:
 *@version 1.0.0
 */
public class AdminBean {

	
	Database db = new Database();
	ResultSet res=null;
	String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
	
	static String titlename;//���ڱ�����
	
	//find����������֤�û�������
	public static boolean find(String name,String password){
		String sql="select * from admin where username=? and password=?";
	    PreparedStatement stmt=null;//���Ԥ����
		ResultSet rs=null;
		Connection conn=Database.getConnection();
		try{
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2,password);
			rs=stmt.executeQuery();
			if(rs.next()) {//���ָ�����ƣ���ʾsql���ִ�гɹ�
				AdminBean.titlename = name;
				return true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//addAdmin������������¹���Ա�����˺�
	String username;
	String password;
	public void addAdmin(String username,String password){
		this.username=username;
		this.password=password;
		String sql = "insert into Admin set username='"+username+"',password='"+password+"'";//ע��һ������Ա�˺ţ�δ���������Ϣ
		Database.update(sql);
		
	}
	
	/*
	 * �޸���Ա��Ϣ
	 * ����:(1)ģ��5��������Ϣ�޸ġ����޸���Ա��Ϣ������username�����޸�
	 * 
	 */
	public void update(String s1,String s2,String s3,String s4,String s5,String s6){
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;
		this.s4=s4;
		this.s5=s5;
		this.s6=s6;
		
		String sql="update Admin set Name='"+s2+"',Sex='"+s3
				+"',Birth='"+s4+"',Nat='"+s5+"',Address='"+s6+"' where username="+s1+"";
		
		Database.update(sql);
	}
	
	
	/*
	 * �޸Ĺ���Ա����
	 * ����:(1)ģ��5�������޸ġ�����username�����޸�
	 * 
	 */
	public void update(String s1,String s2){
		this.s1=s1;
		this.s2=s2;
		
		String sql="update Admin set Password='"+s2+"' where username="+s1+"";
		
		Database.update(sql);
		Database.close();//�ر����ݿ�
	}
	
	
	/*
	 * �޸Ĺ���Ա����
	 * ����:(1)ģ��5�������޸�-����������username����ע��
	 * 
	 */
	public void cancelAccount(String s1){
		this.s1=s1;
		
		String sql="delete from Admin where username='"+s1+"'";
		
		Database.update(sql);
		Database.close();//�ر����ݿ�
	}
	
	
	
	
	/*
	 * ��ȡAdmin�����ȫ����Ϣ
	 * ����:(1)ģ��5��������Ϣ�޸ġ�
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
	
	/*
	 * ��ѯAdmin�����Ϣ
	 * ����:(1)ģ��5��������Ϣ�޸ġ�����username��ȡ��Ϣ
	 * 
	 */
	String id;
	public String[] search(String id){
		this.id = id;
	
		String sql = "select * from Admin where username = "+id+"";//����username��ѯ��Ϣ
		
		res = Database.query(sql);//��ѯ��Ϣ
		String s[] = new String[10];//����һ������,���ڽ��մ����ݿ⵼�����Ϣ
		try {
				while(res.next()){
					s[0] = res.getString("Username");
					s[1] = res.getString("Name");
					s[2] = res.getString("Sex");
					s[3] = res.getString("Birth");
					s[4] = res.getString("Nat");//����
					s[5] = res.getString("Address");
					
				}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			Database.close();//�ر����ݿ�
		}
		return s;//����һά����
	}
}
