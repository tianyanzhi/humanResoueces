package hr331;
import java.sql.*;

/**
 *项目名称:人力资源管理系统
 *类名:Database
 *类描述:实现数据库的操作、包括连接数据库、执行SQL语句、关闭数据库连接等
 *创建人:an
 *修改备注:
 *@version 1.0.0
 */
public class Database {

	static String driver = "com.mysql.jdbc.Driver";//数据库驱动
	static String url = "jdbc:mysql://localhost:3306/HrMS";//数据库连接url
	static String user = "root";//用户名
	static String password = "631481098";//密码

	private static Connection conn = null;//Connection对象
	private static Statement state = null;//Statement对象
	private static ResultSet res = null;//ResultSet对象
	
	/*
	 * Connection
	 * 加载数据库驱动，并连接数据库
	 */
	public static Connection getConnection(){
		try {
			Class.forName(driver);//
			conn = DriverManager.getConnection(url,user,password);//
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	/*
	 * Statement
	 * 创建Statement
	 */
	public static Statement createStatement(){
		try{
			state =getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
			return state;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * ResultSet
	 * 执行数据查询语句的方法，实现数据查询功能
	 */
	public static ResultSet query(String sql){
		try{
			res = createStatement().executeQuery(sql);
			return res;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 
	 * 返回整型
	 * 执行executeUpdate方法,实现数据的删除，修改，更新
	 */
	public static int update(String sql){
		try{
			return createStatement().executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
	/*
	 * 释放内存，关闭数据库
	 */
	public static void close(){
		try {
			if(conn!=null){
				conn.close();
			}else if(state!= null){
				state.close();
			}else if(res!=null){
				res.close();
			}
		} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	
	
}
