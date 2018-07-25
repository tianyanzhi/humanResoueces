package hr331;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *��Ŀ����:������Դ����ϵͳ
 *����:Node52Panel
 *������:����Ա�˺ŵ������޸�������
 *������:an
 *�޸ı�ע:
 *@version 1.0.0
 */

public class Node52Panel extends JPanel implements ActionListener,ItemListener{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String[] p = null;
	
	AdminBean abean = new AdminBean();
	
	JLabel title;
	JButton update,delete;	//�޸ģ����
	JPanel p1,p2,p3;
	GridBagLayout gridL;
	GridBagConstraints gridC;
	JPasswordField newPwdText,confirmText;
	JTextField usnameText;
	JLabel usnameLabel,newPwdLabel,confirmLabel;
	public Node52Panel(){
		init();
	
	}
	
	public void init(){
		
		setLayout(new BorderLayout());
		
		gridL = new GridBagLayout();
		
		int width = 8;//JTextField�Ŀ��,���ڴ����޸�
		//a.�ϲ�����
		p1 = new JPanel();
		title = new JLabel("�����޸�");
		p1.add(title);
		//b.�в�����
		p2 = new JPanel();
		p2.setLayout(gridL);
		//�˻���
		usnameLabel = new JLabel("�ʻ���:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 1;
		gridC.insets = new Insets(10, 1, 20, 5);
		gridL.setConstraints(usnameLabel, gridC);
		p2.add(usnameLabel);
		
		usnameText = new JTextField(width);
		usnameText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 1;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(usnameText, gridC);
		p2.add(usnameText);
		//������
		newPwdLabel = new JLabel("������:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(newPwdLabel, gridC);
		p2.add(newPwdLabel);
		
		newPwdText = new JPasswordField(width);
		newPwdText.setEchoChar('*');
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(newPwdText, gridC);
		p2.add(newPwdText);
		//ȷ��������
		confirmLabel = new JLabel("ȷ������:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(confirmLabel, gridC);
		p2.add(confirmLabel);
				
		confirmText = new JPasswordField(width);
		confirmText.setEchoChar('*');
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(confirmText, gridC);
		p2.add(confirmText);		
		
		//�޸İ�ť
		update =  new JButton("�޸�");
		update.addActionListener(this);//��Ӷ����¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(update, gridC);
		p2.add(update);
		
		//ע����ť
		delete = new JButton("����");
		
		delete.addActionListener(this);//��Ӷ����¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(delete, gridC);
		p2.add(delete);		
		
		
		add("North",p1);
		add("Center",p2);	
		infoIn();//��Ϣ���
	}
/*
 * ���صĶ����¼�
 * 
 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e){
		String newPwd = newPwdText.getText();
		String conPwd = confirmText.getText();
		if(e.getSource() == update){//�����޸�
			//����PersonBean���޸ķ���
			if(newPwd.trim().length()!=0) {
				if(conPwd.trim().length()!=0) {
					if(newPwd.equals(conPwd)) {
						abean.update(usnameText.getText(), newPwdText.getText());
						JOptionPane.showMessageDialog(null, "�޸�����ɹ�!�����µ�½��");//��ʾ
						Login.hidden();
						new Login();
					}
					else JOptionPane.showMessageDialog(null, "�������벻���ϣ���˶Ժ��ٳ��ԣ�");
				}
				else JOptionPane.showMessageDialog(null, "��ȷ�������룡");
			}
			else
				JOptionPane.showMessageDialog(null, "������ԭ���룡");
		}
		else if (e.getSource() == delete) {
			int option = JOptionPane.showConfirmDialog(null, "����Լ���", "�˻�ע��", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);  
	        if (option == JOptionPane.YES_OPTION) {  
	            // ......  
	        	int optionsAgain = JOptionPane.showConfirmDialog(null, "�˲�����ֱ��ע�����Ĺ���Ա�˻���", "����", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); 
		        	if(optionsAgain == JOptionPane.YES_NO_OPTION) {
		        		abean.cancelAccount(p[0]);//����������
			        	JOptionPane.showMessageDialog(null, "�����ɹ��������ص�½���棡");
			        	Login.hidden();
			        	new Login();
			        	super.repaint();
		        	}
		        	else if (optionsAgain == JOptionPane.NO_OPTION) {
						//�޲�������
					}
	        } else if (option == JOptionPane.NO_OPTION) {  
	            // ......  ����
	        }  
		}
	}
	

	/*
	 * ����ı��򷽷�
	 */
	public void clearAll(){
		usnameText.setText(null);
		newPwdText.setText(null);
		confirmText.setText(null);	
	}



	/*
	 * ���ص�JcomboBox�¼�
	 */
	
	public void infoIn() {
			p = abean.search(AdminBean.titlename);//�ַ�������p���ڻ�ȡ�����ݿ⵼�����Ա��Ϣ
			//�����ݿ⵼�����Ա��Ϣͨ�����飬��ӵ���Ӧ�����
			usnameText.setText(p[0]);//�˻���
	
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
}
