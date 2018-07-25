package hr331;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *项目名称:人力资源管理系统
 *类名:Login
 *类描述:登陆界面
 *创建人:an
 *修改备注:
 *@version 1.0.0
 */

public class Login {
	AdminBean abean = new AdminBean();
	JOptionPane op=new JOptionPane();
	static HrMain hr;
	JFrame f;
	JLabel label1;
	JLabel label2;
	JTextField user;//用户名
	JPasswordField pwd;//密码
	JButton exit;//退出
	JButton login;//登陆
	JButton register;//注册
	
	public Login(){
	

		//hr.setVisible(false);
		int width=15;
		f=new JFrame();
		
		f.setLocation(600, 300);
		
		f.setResizable(false);//设置不可以改变大小
		
		f.pack();//自动调整
		
		f.setTitle("人事管理系统登录");
		
		Image image = Toolkit.getDefaultToolkit().getImage("images/computer.png");
		f.setIconImage(image);//设置标题栏的图标
		
		f.setLayout(new GridLayout(3,1,0,0));//3行1列的布局
		
		JPanel p1=new JPanel();
		
		JPanel p2=new JPanel();
		
		JPanel p3=new JPanel();
		
		
		label1=new JLabel("账号:");
		user=new JTextField(width);
		
		label2=new JLabel("密码:");
		pwd=new JPasswordField(width);//密码框
		pwd.setEchoChar('*');

		exit=new JButton("退出");
		//exit.setSize(30, 30);
		
		login=new JButton("登录");
		//login.setSize(30, 30);
		
		register=new JButton("注册");
		//register.setSize(30, 30);
		
		//单击退出，登录框关闭
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		//添加注册按钮监听
				register.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						f.setVisible(false);
						new Register();
					}
					
				});
		
	//单击登录验证用户名和密码是否正确,若正确，弹出主界面,否提示密码
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = user.getText();
				@SuppressWarnings("deprecation")
				String password = pwd.getText();
				/*if(user.getText().equals(username)&&pwd.getText().equals(password)){
					op.showMessageDialog(null, "登录成功!");//提示登录成功
					new HrMain();
					f.setVisible(false);//隐藏登录框
				}else{
					op.showMessageDialog(null, "请输入您的密码！");
				}*/
				
				if (username.trim().length() != 0 && password.trim().length() != 0) {
					if (AdminBean.find(username, password)) {
						JOptionPane.showMessageDialog(null, "登录成功!");//提示登录成功
						hr = new HrMain();
						hr.setVisible(true);
						f.setVisible(false);//隐藏登录框
					} else
						JOptionPane.showMessageDialog(null, "用户名或密码不正确");

				} else
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
			}
		});

		
		p1.add(label1);
		
		p1.add(user);
		
		p2.add(label2);
		
		p2.add(pwd);
		
		p3.add(login);
		
		p3.add(register);

		p3.add(exit);
		
		f.add(p1);
		f.add(p2);
		f.add(p3);
		
		f.setVisible(true);//设置可见性
		
		f.setSize(300,200);
		
		f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//点击右上角结束程序
      
	}
	
	
	/*
	 * 提供主窗口隐藏方法
	 */
	public static void hidden() {
		hr.setVisible(false);
	}
	
	public static void main(String[] args) {
	
			new Login();//创建对象
	
	}

}
