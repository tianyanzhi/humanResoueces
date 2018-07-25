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
 *����:Node11Panel
 *������:��Ա������Ϣ����������Ϣ��
 *������:an
 *�޸ı�ע:
 *			1.����������������Ա�������⣨��ȡ����Ա��ID��text��
 *			
 *@version 1.0.1
 */
public class Node11Panel extends JPanel implements ActionListener,ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String DeptId = "1";
	
	PersonBean pbean = new PersonBean();
	
	JLabel title;
	JButton add,clear;	//��ӣ����
	JPanel p1,p2;
	GridBagLayout gridL;
	GridBagConstraints gridC;
	JComboBox<?> deptCombobox;//����
	JTextField pIdText,nameText,sexText,birText,natText,adText,otherText;
	JLabel pIdLabel,nameLabel,sexLabel,birLabel,natLabel,adLabel,deptLabel,otherLabel;
//���췽��
	public Node11Panel(){
		init();
	
	}
	
	
	/*
	 * ���ڳ�ʼ���
	 */
	public void init(){
		
		setLayout(new BorderLayout());//���ò���ΪBorderLayout
		
		gridL = new GridBagLayout();
		
		int width = 10;//JTextField�Ŀ��,���ڴ����޸�
		//a.�ϲ�����
		p1 = new JPanel();
		title = new JLabel("������Ա��Ϣ");
		p1.add(title);
		//b.�в�����
		p2 = new JPanel();
		p2.setLayout(gridL);
		
		//��Ա���
		pIdLabel = new JLabel("��Ա���:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 1;
		gridC.insets = new Insets(10, 1, 20, 10);
		gridL.setConstraints(pIdLabel, gridC);
		p2.add(pIdLabel);
		
		pIdText = new JTextField(width);
		pIdText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 1;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(pIdText, gridC);
		p2.add(pIdText);
		pIdText.setText(""+pbean.getID());
		
		//��Ա����
		nameLabel = new JLabel("��Ա����:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 1;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(nameLabel, gridC);
		p2.add(nameLabel);
		
		nameText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 1;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(nameText, gridC);
		p2.add(nameText);
		//�Ա�
		sexLabel = new JLabel("�Ա�		:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(sexLabel, gridC);
		p2.add(sexLabel);
		
		sexText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(sexText, gridC);
		p2.add(sexText);
		//��������
		birLabel = new JLabel("��������:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(birLabel, gridC);
		p2.add(birLabel);
		
		birText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(birText, gridC);
		p2.add(birText);
		

		//����
		natLabel = new JLabel("����		:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(natLabel, gridC);
		p2.add(natLabel);
		
		natText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(natText, gridC);
		p2.add(natText);

		//��ַ
		adLabel = new JLabel("��ַ	:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(adLabel, gridC);
		p2.add(adLabel);
		
		adText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(adText, gridC);
		p2.add(adText);
		
		
		//����
		deptLabel = new JLabel("����		:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(deptLabel, gridC);
		p2.add(deptLabel);
		
		DeptBean dbean = new DeptBean();//�����������ݿ��������
		String deptItems[] = dbean.searchAllForDept();//����Dept�����ȡ�Ĳ�����Ϣ���ص�JComboBox
		deptCombobox = new JComboBox<Object>(deptItems);
		deptCombobox.addItemListener(this);//���JComboBoxѡ���¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(deptCombobox, gridC);
		p2.add(deptCombobox);
		
		//����
		otherLabel = new JLabel("����:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(otherLabel, gridC);
		p2.add(otherLabel);
		
		otherText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(otherText, gridC);
		p2.add(otherText);
		
		//��Ӱ�ť
		//ImageIcon image1=new ImageIcon("../pms/images/add.png");
		add =  new JButton("���");
		
		add.addActionListener(this);//��Ӷ����¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 5;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(add, gridC);
		p2.add(add);
		
		//��հ�ť
		clear = new JButton("���");
		
		clear.addActionListener(this);//��Ӷ����¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 5;
		gridC.insets = new Insets(20, 1, 20, 10);
		gridL.setConstraints(clear, gridC);
		p2.add(clear);
		
		add("North",p1);
		add("Center",p2);	
	}
	/*
	 * ���صĶ����¼�
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == add){//ѡ����Ӱ�ť
			//
			String salary = "0";//����
			String assess = "δ����";//������Ϣ
			if(nameText.getText().trim().length()!=0) {
				pbean.add(pIdText.getText(), nameText.getText(), sexText.getText(), birText.getText(), natText.getText(),
				adText.getText(),DeptId,salary, assess, otherText.getText());
				JOptionPane.showMessageDialog(null, "������Ϣ�ɹ�!");//��ʾ��Ϣ
				clearAll();//���
				pIdText.setText(""+pbean.getID());//����޷����������Ա��������
			}else
				JOptionPane.showMessageDialog(null, "�������������������һ����Ա����");
		}else if(e.getSource() == clear){//ѡ�������ť
			clearAll();
		}
	}
	/*
	 * ����ı��򷽷�
	 */
	public void clearAll(){
		nameText.setText(null);
		sexText.setText(null);
		birText.setText(null);
		natText.setText(null);
		adText.setText(null);
		deptCombobox.setToolTipText(null);
		otherText.setText(null);		
	}

	@Override
	/*
	 *���ص�itemStateChanged����
	 */
	public void itemStateChanged(ItemEvent e) {

		if(e.getStateChange()==ItemEvent.SELECTED){//ѡ��JComboBox���
			String s = ""+e.getItem();//��ȡ�ַ���
			String[] arr = s.split("-");//��"-"�ָ�
			DeptId = arr[0];//���ű��
		}
		
	}

}
