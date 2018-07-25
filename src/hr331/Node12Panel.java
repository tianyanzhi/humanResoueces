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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *��Ŀ����:������Դ����ϵͳ
 *����:Node12Panel
 *������:������Ϣ������޸���Ա��Ϣ
 *������:an
 *�޸ı�ע:
 *@version 1.0.0
 */

public class Node12Panel extends JPanel implements ActionListener,ItemListener{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String DeptId = "1";//���ű��
	
	String salary = "0";//����
	
	String assess = "δ����";//������Ϣ
	
	String[] p = null;
	
	String PersonId = "";//��Ա���
	
	PersonBean pbean = new PersonBean();
	
	JLabel title;
	JButton update,clear;	//�޸ģ����
	JPanel p1,p2;
	GridBagLayout gridL;
	GridBagConstraints gridC;
	JComboBox<Object> msg;//ѡ����Ա��Ϣ
	JTextField pIdText,nameText,sexText,birText,natText,adText,otherText;
	JLabel pIdLabel,nameLabel,sexLabel,birLabel,natLabel,adLabel,msgLabel,otherLabel;
	public Node12Panel(){
		init();
	
	}
	
	public void init(){
		
		setLayout(new BorderLayout());
		
		gridL = new GridBagLayout();
		
		int width = 8;//JTextField�Ŀ��,���ڴ����޸�
		//a.�ϲ�����
		p1 = new JPanel();
		title = new JLabel("�޸���Ա��Ϣ");
		p1.add(title);
		//b.�в�����
		p2 = new JPanel();
		p2.setLayout(gridL);
		//��Ա���
		pIdLabel = new JLabel("��Ա���:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 1;
		gridC.insets = new Insets(10, 1, 20, 5);
		gridL.setConstraints(pIdLabel, gridC);
		p2.add(pIdLabel);
		
		pIdText = new JTextField(width);
		pIdText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 1;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(pIdText, gridC);
		p2.add(pIdText);
		//��Ա����
		nameLabel = new JLabel("��Ա����:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 1;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(nameLabel, gridC);
		p2.add(nameLabel);
		
		nameText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 1;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(nameText, gridC);
		p2.add(nameText);
		//�Ա�
		sexLabel = new JLabel("�Ա�		:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(sexLabel, gridC);
		p2.add(sexLabel);
		
		sexText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(sexText, gridC);
		p2.add(sexText);
		
		//��������
		birLabel = new JLabel("��������:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(birLabel, gridC);
		p2.add(birLabel);
		
		birText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(birText, gridC);
		p2.add(birText);
		//����
		natLabel = new JLabel("����		:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(natLabel, gridC);
		p2.add(natLabel);
		
		natText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(natText, gridC);
		p2.add(natText);
		
	//��ַ
		adLabel = new JLabel("��ַ	:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(adLabel, gridC);
		p2.add(adLabel);
		
		adText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(adText, gridC);
		p2.add(adText);
		//����
		otherLabel = new JLabel("���� 	:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(otherLabel, gridC);
		p2.add(otherLabel);
		
		otherText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(otherText, gridC);
		p2.add(otherText);
		//ѡ����Ա��Ϣ
		msgLabel = new JLabel("ѡ����Ա��Ϣ:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 5;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(msgLabel, gridC);
		p2.add(msgLabel);
		
		
		String msgStr[]= pbean.getPersonMsg();//��ȡ���ݿ���Ϣ
		msg = new JComboBox<Object>(msgStr);
		msg.addItemListener(this);//���JComboBoxѡ���¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 5;
		gridC.insets = new Insets(20,1,20,5);
		gridL.setConstraints(msg,gridC);
		p2.add(msg);
		
		//�޸İ�ť
		update =  new JButton("�޸�");
		update.addActionListener(this);//��Ӷ����¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 5;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(update, gridC);
		p2.add(update);
		//��հ�ť
		clear = new JButton("���");
		
		clear.addActionListener(this);//��Ӷ����¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 5;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(clear, gridC);
		p2.add(clear);
		
		add("North",p1);
		add("Center",p2);	
	}
/*
 * ���صĶ����¼�
 * 
 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == update){//�����޸�
			//����PersonBean���޸ķ���
			String ID = pIdText.getText();
			if(ID.trim().length()!=0) {
				pbean.update(pIdText.getText(), nameText.getText(), sexText.getText(), 
						birText.getText(), natText.getText(), adText.getText(),DeptId,salary,assess, otherText.getText());
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�!");//��ʾ
			}
			else {
				JOptionPane.showMessageDialog(null, "����ѡ��Ա����");
			}
		}else if(e.getSource() == clear){
			clearAll();//����ı���
			
		}
	}
	

	/*
	 * ����ı��򷽷�
	 */
	public void clearAll(){
		pIdText.setText(null);
		nameText.setText(null);
		sexText.setText(null);
		birText.setText(null);
		natText.setText(null);
		adText.setText(null);
		//msg.setToolTipText(null);
		otherText.setText(null);		
	}

	/*
	 * ���ص�JcomboBox�¼�
	 */
	public void itemStateChanged(ItemEvent e) {
	
		if(e.getStateChange()==ItemEvent.SELECTED){//ѡ��״̬
			String s = "" + e.getItem().toString();//��ȡ�ַ���
			int i = s.indexOf("-");//��"-"�ָ�
			PersonId = s.substring(0, i);//��Ա���
			p = pbean.search(PersonId);//�ַ�������p���ڻ�ȡ�����ݿ⵼�����Ա��Ϣ
			
			//�����ݿ⵼�����Ա��Ϣͨ�����飬��ӵ���Ӧ�����
			pIdText.setText(p[0]);//��Ա���
			nameText.setText(p[1]);
			sexText.setText(p[2]);
			birText.setText(p[3]);//����������Ϣ
			natText.setText(p[4]);//������Ϣ
			adText.setText(p[5]);//��ַ��Ϣ
			DeptId = "" + p[6];
			salary = "" + p[7];//����
			assess = "" + p[8];//������Ϣ
			otherText.setText(p[9]);
			
		}
	}
}
