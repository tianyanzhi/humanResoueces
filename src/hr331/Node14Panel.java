package hr331;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *��Ŀ����:������Դ����ϵͳ
 *����:Node14Panel
 *������:������Ϣ����Ĳ�ѯ��Ա��Ϣ
 *������:an
 *�޸ı�ע:
 *@version 1.0.0
 */

public class Node14Panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PersonBean pbean = new PersonBean();
	JLabel title;
	JPanel p1,p2,p3;
	JTable table;//���
	JScrollPane scrollPane;
	JLabel numLabel,nameLabel,sexLabel,birLabel;
	JTextField numText,nameText,sexText,birText;
	public Node14Panel(){
		init();
	}
	public void init(){
		//a.�ϲ�����
		p1 = new JPanel();
		title = new JLabel("");
		p1.add(title);
		
		//b.�в�����
		p2 = new JPanel();
		
		String tableTitle[] = {"���","����","��������","����","��ַ","����"};
		
		String tableValues[][] = pbean.select();//��ȡ���ݿ��������
		
		table = new JTable(tableValues,tableTitle);
		
		Dimension a=new Dimension();
        a.height=320;
        a.width=500;
        table.setPreferredScrollableViewportSize(a);
		
		scrollPane = new JScrollPane(table);
		
		p2.add(scrollPane);
		
		//c.�²�����
		p3 = new JPanel();

		
		add("North",p1);
		add("Center",p2);
		add("South",p3);
	}
}












