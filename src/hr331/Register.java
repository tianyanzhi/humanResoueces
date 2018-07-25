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
 *类名:Register
 *类描述:注册界面
 *创建人:an
 *修改备注:
 *@version 1.0.0
 */

public class Register {
	
	AdminBean abean = new AdminBean();
	JOptionPane op=new JOptionPane();
	JFrame f;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JTextField user;//用户名
	JPasswordField pwd;//密码
	JPasswordField pwdAgain;//密码确认
	JButton exit;//退出
	JButton login;//登陆
	JButton register;//注册
	
	public Register(){
	
		int width=15;
		f=new JFrame();
		
		f.setLocation(600, 300);
		
		f.setResizable(false);//设置不可以改变大小
		
		f.pack();//自动调整
		
		f.setTitle("人事管理系统注册");
		
		Image image = Toolkit.getDefaultToolkit().getImage("images/computer.png");
		f.setIconImage(image);//设置标题栏的图标
		
		f.setLayout(new GridLayout(4,1,0,0));//3行1列的布局
		
		JPanel p1=new JPanel();
		
		JPanel p2=new JPanel();
		
		JPanel p3=new JPanel();

		JPanel p4=new JPanel();
		
		
		label1=new JLabel("账号:");
		user=new JTextField(width);
		
		label2=new JLabel("密码:");
		pwd=new JPasswordField(width);//密码框
		pwd.setEchoChar('*');
		
		label3=new JLabel("确认:");
		pwdAgain=new JPasswordField(width);//确认密码框
		pwdAgain.setEchoChar('*');

		exit=new JButton("退出");
		//exit.setSize(30, 30);
		
		login=new JButton("返回");
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
				login.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						f.setVisible(false);
						new Login();
					}
					
				});
		
	//单击注册，成功显示登陆界面并提示登陆
		register.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = user.getText();
				String password = pwd.getText();
				String password2 = pwdAgain.getText();
				/*if(user.getText().equals(username)&&pwd.getText().equals(password)){
					op.showMessageDialog(null, "登录成功!");//提示登录成功
					new HrMain();
					f.setVisible(false);//隐藏登录框
				}else{
					op.showMessageDialog(null, "请输入您的密码！");
				}*/
				
				if (username.trim().length() != 0 && password.trim().length() != 0) {
					if(password2.trim().length()!=0) {
						
						if(password.equals(password2)) {
						abean.addAdmin(username, password); 
							JOptionPane.showMessageDialog(null, "注册成功，请登陆！");//提示登录成功
							new Login();
							f.setVisible(false);//隐藏注册框
						}
						else
							JOptionPane.showMessageDialog(null, "两次密码不正确！");
					} 
					else
						JOptionPane.showMessageDialog(null, "请确认密码！");
				}
				else
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空！");
			}
		});

		
		p1.add(label1);
		
		p1.add(user);
		
		p2.add(label2);
		
		p2.add(pwd);
		
		p3.add(label3);
		
		p3.add(pwdAgain);
		
		p4.add(register);
		
		p4.add(login);

		p4.add(exit);
		
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		
		f.setVisible(true);//设置可见性
		
		f.setSize(300,300);
		f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//点击右上角结束程序
      
	}

}
