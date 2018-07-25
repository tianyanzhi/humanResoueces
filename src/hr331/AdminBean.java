package hr331;

import java.sql.*;


/**
 *项目名称:人力资源管理系统
 *类名:AdminBean
 *类描述:实现对管理员信息表进行数据库操作的功能，查询
 *创建人:an
 *修改备注:
 *@version 1.0.0
 */
public class AdminBean {

	
	Database db = new Database();
	ResultSet res=null;
	String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
	
	static String titlename;//窗口标题名
	
	//find方法用于验证用户与密码
	public static boolean find(String name,String password){
		String sql="select * from admin where username=? and password=?";
	    PreparedStatement stmt=null;//添加预处理
		ResultSet rs=null;
		Connection conn=Database.getConnection();
		try{
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2,password);
			rs=stmt.executeQuery();
			if(rs.next()) {//如果指针下移，表示sql语句执行成功
				AdminBean.titlename = name;
				return true;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//addAdmin方法用于添加新管理员控制账号
	String username;
	String password;
	public void addAdmin(String username,String password){
		this.username=username;
		this.password=password;
		String sql = "insert into Admin set username='"+username+"',password='"+password+"'";//注册一个管理员账号，未添加其他信息
		Database.update(sql);
		
	}
	
	/*
	 * 修改人员信息
	 * 用于:(1)模块5【个人信息修改】的修改人员信息，根据username进行修改
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
	 * 修改管理员密码
	 * 用于:(1)模块5【密码修改】根据username进行修改
	 * 
	 */
	public void update(String s1,String s2){
		this.s1=s1;
		this.s2=s2;
		
		String sql="update Admin set Password='"+s2+"' where username="+s1+"";
		
		Database.update(sql);
		Database.close();//关闭数据库
	}
	
	
	/*
	 * 修改管理员销户
	 * 用于:(1)模块5【密码修改-销户】根据username进行注销
	 * 
	 */
	public void cancelAccount(String s1){
		this.s1=s1;
		
		String sql="delete from Admin where username='"+s1+"'";
		
		Database.update(sql);
		Database.close();//关闭数据库
	}
	
	
	
	
	/*
	 * 获取Admin表里的全部信息
	 * 用于:(1)模块5【个人信息修改】
	 * 
	 */
	@SuppressWarnings("null")
	public String[] getPersonMsg(){
		
		String sql = "select * from Person";//查询所有信息
		String s[] = null;
		int i = 0;
		int rows = 0;
		res = Database.query(sql);
		try {
			if(res.last()){
				rows = res.getRow();//获取行数
			}
			
			if(rows == 0){//行数为0
				s[0]="";
				s[1]="";
				s[2]="";
			}else{//行数不为0
				s = new String[rows];
				res.first();//第一行
				res.previous();//反向查询
				while(res.next()){
					s[i]=res.getString("PersonID")+"-"+res.getString("Name");
					i++;//计数器累加
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Database.close();//关闭数据库
		}
		return s;
	}
	
	/*
	 * 查询Admin表的信息
	 * 用于:(1)模块5【个人信息修改】根据username获取信息
	 * 
	 */
	String id;
	public String[] search(String id){
		this.id = id;
	
		String sql = "select * from Admin where username = "+id+"";//根据username查询信息
		
		res = Database.query(sql);//查询信息
		String s[] = new String[10];//定义一个数组,用于接收从数据库导入的信息
		try {
				while(res.next()){
					s[0] = res.getString("Username");
					s[1] = res.getString("Name");
					s[2] = res.getString("Sex");
					s[3] = res.getString("Birth");
					s[4] = res.getString("Nat");//民族
					s[5] = res.getString("Address");
					
				}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			Database.close();//关闭数据库
		}
		return s;//返回一维数组
	}
}
