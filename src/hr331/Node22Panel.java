package hr331;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *��Ŀ����:������Դ����ϵͳ
 *����:Node22Panel
 *������:��Ա������ʷ��ѯ
 *������:an
 *�޸ı�ע:
 *			1.�޸��˲����޸ĺ󣬲����޸���ʷ�¾ɲ���ͬΪ�²��ŵ����⣨����˳�����⣩
 *			2.�޸���ֻ��ʾ���ű�Ų���ʾ���֣�personBean�ṩ��ȡ�������ַ�����
 *@version 1.0.2
 */

public class Node22Panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HistrjnBean hbean = new HistrjnBean();
	JLabel title;
	JTable table;
	JPanel p1,p2,p3;
	JScrollPane scrollPane;
	JLabel numLabel,nameLabel,sexLabel,birLabel;
	JTextField numText,nameText,sexText,birText;
	public Node22Panel(){
		init();
	}
	public void init(){
		//a.�ϲ�����
		p1 = new JPanel();
		title = new JLabel("");
		p1.add(title);
		//b.�в�����
		p2 = new JPanel();
		
		String tableTitle[] = {"��ˮ��","��Ա����","ԭ����","�²���","�������","�������"};
		
		String tableValues[][] = hbean.transferHis();//����Ա������ʷ����Ϣ��ӵ����
		//�������
		table = new JTable(tableValues,tableTitle);
		
		//���ñ���С�ó��ֹ�����
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
