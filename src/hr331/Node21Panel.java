package hr331;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
 *����:Node21Panel
 *������:��Ա����
 *������:an
 *�޸ı�ע:
 *			1.�����ˢ������
 *@version 1.0.1
 */

public class Node21Panel extends JPanel implements ActionListener,ItemListener,ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PersonBean pbean=new PersonBean();
	DeptBean dbean = new DeptBean();
	HistrjnBean hbean=new HistrjnBean();

	String deptId="1";
	String dDept;//һ������
	String sDept;//��������
	
	JLabel title;
	JPanel p1,p2,p3;
	JTable table;
	JComboBox<?> newDeptCom;//�²���
	JScrollPane scrollPane;
	GridBagLayout gridL;
	GridBagConstraints gridC;
	JButton newDeptBtn,clear;
	JTextField nameText,oriDeptText;
	
	JLabel nameLabel,oriDeptLabel,newDeptLabel;
	
	String tableTitle[] = {"����","����","�Ա�","����","н��","������Ϣ"};
	
	String tableValues[][] = dbean.searchMsg();//��ȡ���ݿ�����
	
	ListSelectionModel listModel;
	
	JOptionPane op=new JOptionPane();
	
	String oriDeptId="1";
	String oriDept="1";
	String nowDept="1";
	
	
	
	public Node21Panel(){
		init();
	}
	public void init(){
		int width = 5;
		
		setLayout(new BorderLayout());
		gridL = new GridBagLayout();
		//a.�ϲ�����
		p1 = new JPanel();
		
		title = new JLabel("��Ա����");
		p1.add(title);
		//b.�в�����
		p2 = new JPanel();
		
		//�������
		table = new JTable(tableValues,tableTitle);
		listModel=table.getSelectionModel();
		listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModel.addListSelectionListener(this);
		
		//���ñ���С�ó��ֹ�����
		Dimension a=new Dimension();
		a.height=280;
		a.width=500;
		table.setPreferredScrollableViewportSize(a);
		
		//�����ӵ��������
		scrollPane = new JScrollPane(table);
		
		p2.add(scrollPane);
		//c.�²�����
		p3 = new JPanel();
		p3.setLayout(gridL);
		//����
		nameLabel = new JLabel("����");
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
		//ԭ����
		oriDeptLabel = new JLabel("ԭ����:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(oriDeptLabel, gridC);
		p3.add(oriDeptLabel);
		
		oriDeptText = new JTextField(10);
		oriDeptText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(oriDeptText, gridC);
		p3.add(oriDeptText);
	//�²���
		newDeptLabel = new JLabel("�²���:");
		gridC = new GridBagConstraints();
		gridC.gridx = 4;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(newDeptLabel, gridC);
		p3.add(newDeptLabel);
		
		String newDept[] = dbean.searchAllForDept();
		newDeptCom = new JComboBox<Object>(newDept);//�����ݿ�����ݼӵ�JComboBox����
		newDeptCom.addItemListener(this);//���JComboBox�¼�
		newDeptCom.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 5;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(newDeptCom, gridC);
		p3.add(newDeptCom);
		//�����²��Ű�ť
		newDeptBtn = new JButton("�����²���");
		newDeptBtn.addActionListener(this);
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 2;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(newDeptBtn, gridC);
		p3.add(newDeptBtn);
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
	 * ���صĶ����¼�����
	 * */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == clear){
			clearAll();//����ı���
		}else if(e.getSource()==newDeptBtn){
			if(nameText.getText().trim().length()!=0) {
				
				oriDeptId=pbean.getDeptId(PersonId);//�õ��ɲ��ű��
				oriDept = pbean.getDept(oriDeptId);//�õ��ɲ�������
				
				pbean.updateDept(PersonId, deptId);//���²�����Ϣ
				
				nowDept = pbean.getDept(deptId);//�õ��²�������
				
				String jourNoStr=""+hbean.countJourNo();//��ȡ��ˮ��
				
				Calendar now = new GregorianCalendar();
				SimpleDateFormat formatter=new SimpleDateFormat();
				formatter.applyPattern("yyyy-MM-dd HH-mm-ss");//�����¼���ʽ
				String regDate=""+formatter.format(now.getTime());//��ȡϵͳʱ��
				
				String chgTime=""+hbean.countChgTime("��Ա����", PersonId);//��ȡ���ݿ�ı����
					
				hbean.add(jourNoStr, "��Ա����",oriDept,nowDept, regDate, chgTime,PersonId);
				table.revalidate();
				JOptionPane.showMessageDialog(null,"��Ա�����ɹ�!");
				HrMain.reDraw(this.getClass().getName());//���ˢ������
			}
			else
				JOptionPane.showMessageDialog(null, "����ѡ����Ҫ������Ա����");
			
		}
	}
	/*
	 * ����ı��򷽷�
	 */
	public void clearAll(){
		nameText.setText(null);
		oriDeptText.setText(null);
		
		
	}
	String PersonId;
	@Override
	/*
	 * ���ѡ���¼�����
	 */
	public void valueChanged(ListSelectionEvent e) {
		int row[]=table.getSelectedRows();//������
		int col[]=table.getSelectedColumns();//������
		
		for(int i=0;i<row.length;i++){
			for(int j=0;j<col.length;j++){
			
				nameText.setText(tableValues[row[i]][1]);//��ȡ������Ϣ
				
				oriDeptText.setText(tableValues[row[i]][3]);//ԭ���Ĳ���
				
				PersonId=tableValues[row[i]][0];//��Ա���
			}
		}
	}
	

	@Override
	/*
	 * �����˵��¼�����
	 */
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED){
			String s=""+e.getItem();//��ȡ�ַ���
			
			int i = s.indexOf("-");
			
			deptId = s.substring(0,i);
		}
		
	}
}
