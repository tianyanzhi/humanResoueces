package hr331;
import java.sql.*;

/**
 *��Ŀ����:������Դ����ϵͳ
 *����:Database
 *������:ʵ�����ݿ�Ĳ����������������ݿ⡢ִ��SQL��䡢�ر����ݿ����ӵ�
 *������:an
 *�޸ı�ע:
 *@version 1.0.0
 */
public class Database {

	static String driver = "com.mysql.jdbc.Driver";//���ݿ�����
	static String url = "jdbc:mysql://localhost:3306/HrMS";//���ݿ�����url
	static String user = "root";//�û���
	static String password = "631481098";//����

	private static Connection conn = null;//Connection����
	private static Statement state = null;//Statement����
	private static ResultSet res = null;//ResultSet����
	
	/*
	 * Connection
	 * �������ݿ����������������ݿ�
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
	 * ����Statement
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
	 * ִ�����ݲ�ѯ���ķ�����ʵ�����ݲ�ѯ����
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
	 * ��������
	 * ִ��executeUpdate����,ʵ�����ݵ�ɾ�����޸ģ�����
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
	 * �ͷ��ڴ棬�ر����ݿ�
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
