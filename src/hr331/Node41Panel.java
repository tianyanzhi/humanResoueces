package hr331;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *��Ŀ����:������Դ����ϵͳ
 *����:Node41Panel
 *������:���ʹ���
 *������:an
 *�޸ı�ע:
 *			1.���ˢ������
 *@version 1.0.1
 */

public class Node41Panel extends JPanel implements ActionListener,ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PersonBean pbean=new PersonBean();
	DeptBean dbean = new DeptBean();
	HistrjnBean hbean=new HistrjnBean();
	JLabel title;
	JTable table;
	JPanel p1,p2,p3;
	JButton ok,clear;
	JScrollPane scrollPane;
	GridBagLayout gridL;
	GridBagConstraints gridC;
	JTextField nameText,beforeSalaryText,afterSalaryText;
	JLabel nameLabel,beforeSalaryLabel,afterSalaryLabel;
	//��һά�������Ϣ��ӵ����ı��⣬��ά�������Ϣ��ӵ��������
	String tableTitle[] = {"����","����","�Ա�","����","н��","������Ϣ"};
	
	String tableValues[][] = dbean.searchMsg();//��ȡ���ݿ���Ϣ
	
	ListSelectionModel listModel;//���ѡ��ģʽ
	
	JOptionPane op = new JOptionPane();
	
	String PersonId;
	
	
	public Node41Panel(){
		init();
	}
	public void init(){
		int width = 5;//JTextField�Ŀ����ڴ����޸�
		
		setLayout(new BorderLayout());
		gridL = new GridBagLayout();
		//a.�ϲ�����
		p1 = new JPanel();
		
		title = new JLabel("���ʷ������");
		p1.add(title);
		//b.�в�����
		p2 = new JPanel();
		//�������
		table = new JTable(tableValues,tableTitle);
		listModel=table.getSelectionModel();
		listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModel.addListSelectionListener(this);//��ӱ��ѡ���¼�
		
		//���ñ���С�ó��ֹ�����
		Dimension a=new Dimension();
		a.height=280;
		a.width=500;
		table.setPreferredScrollableViewportSize(a);
		
		scrollPane = new JScrollPane(table);
		
		p2.add(scrollPane);
		//c.�²�����
		p3 = new JPanel();
		p3.setLayout(gridL);
		//����
		nameLabel = new JLabel("����:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(nameLabel, gridC);
		p3.add(nameLabel);
		
		nameText = new JTextField(width);
		nameText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(nameText, gridC);
		p3.add(nameText);
	//֮ǰ����
		beforeSalaryLabel = new JLabel("����ǰ�Ĺ���:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(beforeSalaryLabel, gridC);
		p3.add(beforeSalaryLabel);
		
		beforeSalaryText = new JTextField(width);
		beforeSalaryText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(beforeSalaryText, gridC);
		p3.add(beforeSalaryText);
		//������Ĺ���
		afterSalaryLabel = new JLabel("������Ĺ���:");
		gridC = new GridBagConstraints();
		gridC.gridx = 4;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(afterSalaryLabel, gridC);
		p3.add(afterSalaryLabel);
		
		afterSalaryText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 5;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(afterSalaryText, gridC);
		p3.add(afterSalaryText);
		//ȷ����ť
		ok= new JButton("ȷ��");
		ok.addActionListener(this);//��Ӷ����¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 2;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(ok, gridC);
		p3.add(ok);
		//�����Ϣ��ť
		clear = new JButton("�����Ϣ");
		clear.addActionListener(this);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 2;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(clear, gridC);
		p3.add(clear);
		
		add("North",p1);
		add("Center",p2);
		add("South",p3);
		
	}
	/*
	 * ������ťʱ�������¼�
	 * */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == clear){
			clearAll();
		}else if(e.getSource()==ok){
			if(nameText.getText().trim().length()!=0) {
				pbean.updateSalary(PersonId, afterSalaryText.getText());
				
				String jourNoStr=""+hbean.countJourNo();
				//String info=dbean.searchDeptId(oriDeptText.getText());
				
				Calendar now = new GregorianCalendar();
				
				SimpleDateFormat formatter=new SimpleDateFormat();
				formatter.applyPattern("yyyy-MM-dd HH-mm-ss");
				String regDate=""+formatter.format(now.getTime());
				String chgTime=""+hbean.countChgTime("���ʷ���", PersonId);
						
				hbean.add(jourNoStr, "���ʷ���",beforeSalaryText.getText(), afterSalaryText.getText(), regDate, chgTime,PersonId);
			
				JOptionPane.showMessageDialog(null,"���ʷ���ɹ�!");
				HrMain.reDraw(this.getClass().getName());//���ˢ������
			}else
				JOptionPane.showMessageDialog(null, "����ѡ����Ҫ����н���Ա����");
		}
		
		
	}
	/*
	 * ���JTextField���
	 */
	public void  clearAll(){
		nameText.setText(null);
		beforeSalaryText.setText(null);
		afterSalaryText.setText(null);
	}
	
	@Override
	/*
	 * ���ѡ��ʱ������Ϣ�ӵ�JTextField���
	 * */
	public void valueChanged(ListSelectionEvent e) {
		int row[]=table.getSelectedRows();//������
		int col[]=table.getSelectedColumns();//������
		
		//ͨ������ѭ������ȡ���ÿһ����Ԫ�����Ϣ
		for(int i=0;i<row.length;i++)
			for(int j=0;j<col.length;j++){
			
				nameText.setText(tableValues[row[i]][1]);
				beforeSalaryText.setText(tableValues[row[i]][4]);
				//thisAssessCom.addItem(tableValues[row[i]][5]);
				PersonId=tableValues[row[i]][0];
				
				
			}
	}
}

