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
 *����:Node31Panel
 *������:��Ա����
 *������:an
 *�޸ı�ע:
 *			1.�����ˢ������
 *@version 1.0.1
 */

public class Node31Panel extends JPanel implements ActionListener,ListSelectionListener,ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PersonBean pbean=new PersonBean();
	DeptBean dbean = new DeptBean();
	HistrjnBean hbean = new HistrjnBean();
	JLabel title;
	JPanel p1,p2,p3;
	JTable table;
	JScrollPane scrollPane;
	JButton ok,clear;
	GridBagLayout gridL;
	JComboBox<?> thisAssessCom;//���ο���
	GridBagConstraints gridC;
	JTextField nameText,preAssessText;//�ϴο���
	JLabel nameLabel,preAssessLabel,thisAssessLabel;
	
	String tableTitle[] = {"����","����","�Ա�","����","н��","������Ϣ"};
	
	String tableValues [][] = dbean.searchMsg();
	
	ListSelectionModel listModel;
	
	String PersonId;//��Ա���
	
	String assess="����";//������Ϣ
	
	JOptionPane op = new JOptionPane();
	
	
	public Node31Panel(){
		init();
	}
	public void init(){
		int width = 10;//JTextField�Ŀ��
		
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
	//�ϴο���
		preAssessLabel = new JLabel("�ϴο���:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(preAssessLabel, gridC);
		p3.add(preAssessLabel);
		
		preAssessText = new JTextField(width);
		preAssessText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(preAssessText, gridC);
		p3.add(preAssessText);
		//���ο���
		thisAssessLabel = new JLabel("���ο���:");
		gridC = new GridBagConstraints();
		gridC.gridx = 4;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(thisAssessLabel, gridC);
		p3.add(thisAssessLabel);
		//����һ������,��������Ϣ�ӵ�JComboBox���
		String assessAry[]={"����","�ϸ�","���ϸ�"};
		thisAssessCom = new JComboBox<Object>(assessAry);
		thisAssessCom.addItemListener(this);//���JComboBoxѡ���¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 5;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(thisAssessCom, gridC);
		p3.add(thisAssessCom);
		//ȷ����ť
		ok= new JButton("ȷ��");
		ok.addActionListener(this);
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 2;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(ok, gridC);
		p3.add(ok);
		//�����Ϣ��ť
		clear = new JButton("�����Ϣ");
		clear.addActionListener(this);//��Ӷ����¼�
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
	 * ������ť�����ؼ�
	 * */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == clear){
			clearAll();//�����Ϣ
		}else if(e.getSource()==ok){
			if(nameText.getText().trim().length()!=0) {
				pbean.updateAssess(PersonId, assess);//���¿�����Ϣ
				String jourNoStr=""+hbean.countJourNo();//��ˮ��
				Calendar now = new GregorianCalendar();
				SimpleDateFormat formatter=new SimpleDateFormat();
				formatter.applyPattern("yyyy-MM-dd HH-mm-ss");//ʱ���ʽ
				String regDate=""+formatter.format(now.getTime());//��ȡϵͳʱ��

				String chgTime=""+hbean.countChgTime("��Ա����", PersonId);//��ȡ�ı����
						//�����Ϣ��Histrjn��
				hbean.add(jourNoStr, "��Ա����",preAssessText.getText(),assess, regDate, chgTime,PersonId);
			
				JOptionPane.showMessageDialog(null,"��Ա���˸��ĳɹ�!");
				HrMain.reDraw(this.getClass().getName());//���ˢ������
			}else
				JOptionPane.showMessageDialog(null, "����ѡ����Ҫ���˵�Ա����");
			
		}
	}
	/*
	 * ����ı��򷽷�
	 */
	public void clearAll(){
		nameText.setText(null);
		preAssessText.setText(null);
		thisAssessCom.setToolTipText(null);
	}
	
	@Override
	/*
	 * ���ѡ��ʱ�����¼�
	 */
	public void valueChanged(ListSelectionEvent e) {
		int row[]=table.getSelectedRows();//������
		int col[]=table.getSelectedColumns();//������
		
		for(int i=0;i<row.length;i++)
			for(int j=0;j<col.length;j++){
			
				nameText.setText(tableValues[row[i]][1]);
				
				preAssessText.setText(tableValues[row[i]][5]);//�ϴο�����Ϣ
				
				PersonId=tableValues[row[i]][0];//��Ա���
				
				
			}
	}

/*
 * JConboBox��ѡ��ʱ�����¼�
 * */
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED){
			assess=""+e.getItem();//��ȡ�µĿ�����Ϣ
		}
		
	}
}
