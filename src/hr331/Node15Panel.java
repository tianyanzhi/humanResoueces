package hr331;

import java.awt.BorderLayout;
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
 *����:Node15Panel
 *������:������Ϣ����Ĳ��Ź���
 *������:an
 *�޸ı�ע:
 *			1.�����ˢ�����⣨�������ṩһ��ˢ�·�����ҳ���ڵ��ã�
 *@version 1.0.1
 */

public class Node15Panel extends JPanel implements ActionListener,ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DeptBean dbean = new DeptBean(); 
	JLabel title;
	JPanel p1,p2,p3;
	JTable table;
	JScrollPane scrollPane;
	GridBagLayout gridL;
	GridBagConstraints gridC;
	JLabel pIdLabel,pDeptLabel,sDeptLabel;
	JTextField pIdText,pDeptText,sDeptText;
	JButton getNewId,add,update,delete,clear;
	
	String tableTitle[] = {"���ű��","һ������","��������"};//������
	
	String tableValues[][] = dbean.select();//������ݴ����ݿ��ȡ
	
	ListSelectionModel listModel;
	
	JOptionPane op=new JOptionPane();
	
	public Node15Panel(){
		init();
	}
	public void init(){
		int width = 10;

		setLayout(new BorderLayout());
		
		gridL = new GridBagLayout();
		
		//a.�ϲ�����
		p1 = new JPanel();
		
		title = new JLabel("���Ź���");
		p1.add(title);
		
		//b.�в�����
		p2 = new JPanel();
		
		table = new JTable(tableValues,tableTitle);
		
		listModel=table.getSelectionModel();
		listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModel.addListSelectionListener(this);
		
		Dimension a=new Dimension();
        a.height=240;
        a.width=500;
        table.setPreferredScrollableViewportSize(a);
		
		scrollPane = new JScrollPane(table);
		
		p2.add(scrollPane);
		
		//c.�²�����
		p3 = new JPanel();
		p3.setLayout(gridL);
		//���ű��
		pIdLabel = new JLabel("���:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 10, 10);
		gridL.setConstraints(pIdLabel, gridC);
		p3.add(pIdLabel);
		
		pIdText = new JTextField(width);
		pIdText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 10, 10);
		gridL.setConstraints(pIdText, gridC);
		p3.add(pIdText);
		
		//һ������
		pDeptLabel = new JLabel("һ������:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 10, 10);
		gridL.setConstraints(pDeptLabel, gridC);
		p3.add(pDeptLabel);
		
		pDeptText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 1;
		gridC.insets = new Insets(5, 10, 10, 10);
		gridL.setConstraints(pDeptText, gridC);
		p3.add(pDeptText);
		//��������
		sDeptLabel = new JLabel("��������:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 2;
		gridC.insets = new Insets(5, 10, 10, 10);
		gridL.setConstraints(sDeptLabel, gridC);
		p3.add(sDeptLabel);
		
		sDeptText = new JTextField(width);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 2;
		gridC.insets = new Insets(5, 10, 10, 10);
		gridL.setConstraints(sDeptText, gridC);
		p3.add(sDeptText);
		//��ȡ�±�Ű�ť
		getNewId = new JButton("��ȡ�±��");
		getNewId.addActionListener(this);
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 3;
		gridC.insets = new Insets(5, 10, 10, 10);
		gridL.setConstraints(getNewId, gridC);
		p3.add(getNewId);
		//��Ӱ�ť
		add =  new JButton("���");
		add.addActionListener(this);
		//add.setEnabled(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 3;
		gridC.insets = new Insets(5, 10, 10, 10);
		gridL.setConstraints(add, gridC);
		p3.add(add);
		//�޸İ�ť
		update = new JButton("�޸�");
		update.addActionListener(this);
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 3;
		gridC.insets = new Insets(5, 10, 10, 10);
		gridL.setConstraints(update, gridC);
		p3.add(update);
		//ɾ����ť
		delete = new JButton("ɾ��");
		delete.addActionListener(this);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 3;
		gridC.insets = new Insets(5, 10, 10, 10);
		gridL.setConstraints(delete, gridC);
		p3.add(delete);
		//��հ�ť
		clear = new JButton("���");
		clear.addActionListener(this);
		gridC = new GridBagConstraints();
		gridC.gridx = 4;
		gridC.gridy = 3;
		gridC.insets = new Insets(5, 10, 10, 10);
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
		}
		else if (e.getSource() == add) {
			if(pIdText.getText().trim().length()!=0 && pDeptText.getText().trim().length()!=0&&sDeptText.getText().trim().length()!=0) {
				if(DeptBean.checkDept(pIdText.getText())) {
					dbean.addDeptMsg(pIdText.getText(), pDeptText.getText(), sDeptText.getText());
					clearAll();
					JOptionPane.showMessageDialog(null, "��Ӳ�����Ϣ�ɹ�!");
					HrMain.reDraw(this.getClass().getName());//���ˢ��
				}
				else
					JOptionPane.showMessageDialog(null, "�ò����Ѵ��ڣ����ȡ�²��ű�ţ�");
			}else
				JOptionPane.showMessageDialog(null, "�����Ʋ�����Ϣ������Ӳ��ţ�");
		}
		else if(e.getSource()==delete){
			if(pIdText.getText().trim().length()!=0) {
				dbean.deleteDeptMsg(pIdText.getText());//ɾ��������Ϣ
				clearAll();
				JOptionPane.showMessageDialog(null, "ɾ��������Ϣ�ɹ�!");
				table.revalidate();
				HrMain.reDraw(this.getClass().getName());
			}else
				JOptionPane.showMessageDialog(null, "����ѡ����Ҫɾ���Ĳ��ţ�");
			
		}else if(e.getSource()==update){//�޸Ĳ�����Ϣ
			if(pIdText.getText().trim().length()!=0) {
				dbean.update(pIdText.getText(), pDeptText.getText(), sDeptText.getText());
				clearAll();
				JOptionPane.showMessageDialog(null, "�޸Ĳ�����Ϣ�ɹ�!");
				HrMain.reDraw(this.getClass().getName());
			}else
				JOptionPane.showMessageDialog(null, "����ѡ����Ҫ�޸ĵĲ��ţ�");
		}else if(e.getSource()==getNewId){//��ȡ�µĲ��ű��
			int i =dbean.getNewId();
			String id=Integer.toString(i);

			pIdText.setText(id);
			pDeptText.setText(null);
			sDeptText.setText(null);
			JOptionPane.showMessageDialog(null, "��ȡ�±�ųɹ�!");
			
		}
		
	}
	/*
	 * ����ı��򷽷�
	 * */
	public void clearAll(){
		pIdText.setText(null);
		pDeptText.setText(null);
		sDeptText.setText(null);
		
	}
	@Override
	
	/*
	 * ѡ����ʱ��������¼�
	 */
	public void valueChanged(ListSelectionEvent e) {

		int row[]=table.getSelectedRows();//������
		int col[]=table.getSelectedColumns();//������
		
		for(int i=0;i<row.length;i++)
			for(int j=0;j<col.length;j++){
				pIdText.setText(tableValues[row[i]][0]);
				pDeptText.setText(tableValues[row[i]][1]);
				sDeptText.setText(tableValues[row[i]][2]);
			}
			
	}
}
