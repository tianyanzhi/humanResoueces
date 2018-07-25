package hr331;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
 *����:Node13Panel
 *������:������Ϣ�����ɾ����Ա��Ϣ
 *������:an
 *�޸ı�ע:
 *		δ���ɾ���ɹ����ܱ�ҳ��ˢ�����ݵ�����
 *			1.���ˢ�����⣬�����������ͬ������
 *@version 1.0.1
 */

public class Node13Panel extends JPanel implements ActionListener,ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PersonBean pbean = new PersonBean();
	JLabel title;
	JButton delete;//ɾ����ť
	JPanel p1,p2,p3;
	JTable table;//���
	JScrollPane scrollPane;
	GridBagLayout gridL;
	GridBagConstraints gridC;
	JLabel pIdLabel,nameLabel,deptLabel;
	JTextField pIdText,nameText,deptText;
	
	//������
	String tableTitle[] = {"���","����","��������","����","��ַ","����"};
	//�������ݣ������ݿ��ȡ
	String [][]tableValues = pbean.select();
	//���ñ��ѡ��ģʽ
	ListSelectionModel listModel=null;
	
	public Node13Panel(){
	
		init();
	}
	//��ʼ���
	public Component init(){
		int width = 5;//JTextField����Ŀ��
		
		setLayout(new BorderLayout());//���ò���ΪBorderLayout
		
		gridL = new GridBagLayout();
		
		//a.�ϲ�����
		p1 = new JPanel();
		
		title = new JLabel("ɾ����Ա��Ϣ");
		p1.add(title);
		
		//b.�в�����
		p2 = new JPanel();
		//�������
		table = new JTable(tableValues,tableTitle);
		
		//���ñ��
		listModel = table.getSelectionModel();
		listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModel.addListSelectionListener(this);
		//���ñ���С�ó��ֹ�����
		Dimension a=new Dimension();
        a.height=280;
        a.width=500;
        table.setPreferredScrollableViewportSize(a);
		
		//�������ӵ��������
		scrollPane = new JScrollPane(table);
        
		p2.add(scrollPane);
		
		
		//c.�²�����
		p3 = new JPanel();
		p3.setLayout(gridL);
		//���
		pIdLabel = new JLabel("���:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(pIdLabel, gridC);
		p3.add(pIdLabel);
		
		pIdText = new JTextField(width);
		pIdText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(pIdText, gridC);
		p3.add(pIdText);
		//����
		nameLabel = new JLabel("����:");
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(nameLabel, gridC);
		p3.add(nameLabel);
		
		nameText = new JTextField(width);
		nameText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 4;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(nameText, gridC);
		p3.add(nameText);
		//����
		deptLabel = new JLabel("����:");
		gridC = new GridBagConstraints();
		gridC.gridx = 5;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(deptLabel, gridC);
		p3.add(deptLabel);
		
		deptText = new JTextField(10);
		deptText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 6;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(deptText, gridC);
		p3.add(deptText);
		//ɾ����ť
		delete = new JButton("ɾ��");
		delete.addActionListener(this);//��Ӷ����¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 2;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(delete, gridC);
		p3.add(delete);
		
		//��ӵ������
		add("North",p1);
		add("Center",p2);
		add("South",p3);
		return(add("Center",p2));
	}
	
	/*
	 * 
	 * ���صĶ����¼�����
	 * */
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==delete){//ѡ��ɾ����ť
			String ID = pIdText.getText();
			if(ID.trim().length()!=0) {
				pbean.delete(ID);//ɾ����Ա��Ϣ
				JOptionPane.showMessageDialog(null, "ɾ����Ա��Ϣ�ɹ�!");
				//�ı������
				pIdText.setText(null);
				nameText.setText(null);
				deptText.setText(null);//�˴��ϵ�δ���ɾ���ɹ����ܱ�ҳ��ˢ�����ݵ�����
				HrMain.reDraw(this.getClass().getName());
				//tableValues = pbean.select();
			}else
				JOptionPane.showMessageDialog(null, "����ѡ����Ҫɾ����Ա����");
		}
	}
	@Override
	/*
	 * ���صı��ѡ���¼�
	 * 
	 * */
	public void valueChanged(ListSelectionEvent e) {
		int row[]=table.getSelectedRows();//������
		int col[]=table.getSelectedColumns();//������
		
		for(int i=0;i<row.length;i++)
			for(int j=0;j<col.length;j++){
				pIdText.setText(tableValues[row[i]][0]);
				nameText.setText(tableValues[row[i]][1]);
				deptText.setText(tableValues[row[i]][5]);
				
			}	
	}	
}
