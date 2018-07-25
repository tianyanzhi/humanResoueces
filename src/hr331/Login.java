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
 *��Ŀ����:������Դ����ϵͳ
 *����:Login
 *������:��½����
 *������:an
 *�޸ı�ע:
 *@version 1.0.0
 */

public class Login {
	AdminBean abean = new AdminBean();
	JOptionPane op=new JOptionPane();
	static HrMain hr;
	JFrame f;
	JLabel label1;
	JLabel label2;
	JTextField user;//�û���
	JPasswordField pwd;//����
	JButton exit;//�˳�
	JButton login;//��½
	JButton register;//ע��
	
	public Login(){
	

		//hr.setVisible(false);
		int width=15;
		f=new JFrame();
		
		f.setLocation(600, 300);
		
		f.setResizable(false);//���ò����Ըı��С
		
		f.pack();//�Զ�����
		
		f.setTitle("���¹���ϵͳ��¼");
		
		Image image = Toolkit.getDefaultToolkit().getImage("images/computer.png");
		f.setIconImage(image);//���ñ�������ͼ��
		
		f.setLayout(new GridLayout(3,1,0,0));//3��1�еĲ���
		
		JPanel p1=new JPanel();
		
		JPanel p2=new JPanel();
		
		JPanel p3=new JPanel();
		
		
		label1=new JLabel("�˺�:");
		user=new JTextField(width);
		
		label2=new JLabel("����:");
		pwd=new JPasswordField(width);//�����
		pwd.setEchoChar('*');

		exit=new JButton("�˳�");
		//exit.setSize(30, 30);
		
		login=new JButton("��¼");
		//login.setSize(30, 30);
		
		register=new JButton("ע��");
		//register.setSize(30, 30);
		
		//�����˳�����¼��ر�
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		//���ע�ᰴť����
				register.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						f.setVisible(false);
						new Register();
					}
					
				});
		
	//������¼��֤�û����������Ƿ���ȷ,����ȷ������������,����ʾ����
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = user.getText();
				@SuppressWarnings("deprecation")
				String password = pwd.getText();
				/*if(user.getText().equals(username)&&pwd.getText().equals(password)){
					op.showMessageDialog(null, "��¼�ɹ�!");//��ʾ��¼�ɹ�
					new HrMain();
					f.setVisible(false);//���ص�¼��
				}else{
					op.showMessageDialog(null, "�������������룡");
				}*/
				
				if (username.trim().length() != 0 && password.trim().length() != 0) {
					if (AdminBean.find(username, password)) {
						JOptionPane.showMessageDialog(null, "��¼�ɹ�!");//��ʾ��¼�ɹ�
						hr = new HrMain();
						hr.setVisible(true);
						f.setVisible(false);//���ص�¼��
					} else
						JOptionPane.showMessageDialog(null, "�û��������벻��ȷ");

				} else
					JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ��");
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
		
		f.setVisible(true);//���ÿɼ���
		
		f.setSize(300,200);
		
		f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//������Ͻǽ�������
      
	}
	
	
	/*
	 * �ṩ���������ط���
	 */
	public static void hidden() {
		hr.setVisible(false);
	}
	
	public static void main(String[] args) {
	
			new Login();//��������
	
	}

}
