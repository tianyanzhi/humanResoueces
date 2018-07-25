package hr331;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *项目名称:人力资源管理系统
 *类名:Node14Panel
 *类描述:基本信息管理的查询人员信息
 *创建人:an
 *修改备注:
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
	JTable table;//表格
	JScrollPane scrollPane;
	JLabel numLabel,nameLabel,sexLabel,birLabel;
	JTextField numText,nameText,sexText,birText;
	public Node14Panel(){
		init();
	}
	public void init(){
		//a.上部布局
		p1 = new JPanel();
		title = new JLabel("");
		p1.add(title);
		
		//b.中部布局
		p2 = new JPanel();
		
		String tableTitle[] = {"编号","姓名","出生年月","民族","地址","部门"};
		
		String tableValues[][] = pbean.select();//获取数据库里的数据
		
		table = new JTable(tableValues,tableTitle);
		
		Dimension a=new Dimension();
        a.height=320;
        a.width=500;
        table.setPreferredScrollableViewportSize(a);
		
		scrollPane = new JScrollPane(table);
		
		p2.add(scrollPane);
		
		//c.下部布局
		p3 = new JPanel();

		
		add("North",p1);
		add("Center",p2);
		add("South",p3);
	}
}












