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
 *����:Register
 *������:ע�����
 *������:an
 *�޸ı�ע:
 *@version 1.0.0
 */

public class Register {
	
	AdminBean abean = new AdminBean();
	JOptionPane op=new JOptionPane();
	JFrame f;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JTextField user;//�û���
	JPasswordField pwd;//����
	JPasswordField pwdAgain;//����ȷ��
	JButton exit;//�˳�
	JButton login;//��½
	JButton register;//ע��
	
	public Register(){
	
		int width=15;
		f=new JFrame();
		
		f.setLocation(600, 300);
		
		f.setResizable(false);//���ò����Ըı��С
		
		f.pack();//�Զ�����
		
		f.setTitle("���¹���ϵͳע��");
		
		Image image = Toolkit.getDefaultToolkit().getImage("images/computer.png");
		f.setIconImage(image);//���ñ�������ͼ��
		
		f.setLayout(new GridLayout(4,1,0,0));//3��1�еĲ���
		
		JPanel p1=new JPanel();
		
		JPanel p2=new JPanel();
		
		JPanel p3=new JPanel();

		JPanel p4=new JPanel();
		
		
		label1=new JLabel("�˺�:");
		user=new JTextField(width);
		
		label2=new JLabel("����:");
		pwd=new JPasswordField(width);//�����
		pwd.setEchoChar('*');
		
		label3=new JLabel("ȷ��:");
		pwdAgain=new JPasswordField(width);//ȷ�������
		pwdAgain.setEchoChar('*');

		exit=new JButton("�˳�");
		//exit.setSize(30, 30);
		
		login=new JButton("����");
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
				login.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						f.setVisible(false);
						new Login();
					}
					
				});
		
	//����ע�ᣬ�ɹ���ʾ��½���沢��ʾ��½
		register.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = user.getText();
				String password = pwd.getText();
				String password2 = pwdAgain.getText();
				/*if(user.getText().equals(username)&&pwd.getText().equals(password)){
					op.showMessageDialog(null, "��¼�ɹ�!");//��ʾ��¼�ɹ�
					new HrMain();
					f.setVisible(false);//���ص�¼��
				}else{
					op.showMessageDialog(null, "�������������룡");
				}*/
				
				if (username.trim().length() != 0 && password.trim().length() != 0) {
					if(password2.trim().length()!=0) {
						
						if(password.equals(password2)) {
						abean.addAdmin(username, password); 
							JOptionPane.showMessageDialog(null, "ע��ɹ������½��");//��ʾ��¼�ɹ�
							new Login();
							f.setVisible(false);//����ע���
						}
						else
							JOptionPane.showMessageDialog(null, "�������벻��ȷ��");
					} 
					else
						JOptionPane.showMessageDialog(null, "��ȷ�����룡");
				}
				else
					JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ�գ�");
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
		
		f.setVisible(true);//���ÿɼ���
		
		f.setSize(300,300);
		f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//������Ͻǽ�������
      
	}

}
