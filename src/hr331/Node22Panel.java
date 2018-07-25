package hr331;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *项目名称:人力资源管理系统
 *类名:Node22Panel
 *类描述:人员调动历史查询
 *创建人:an
 *修改备注:
 *			1.修复了部门修改后，部门修改历史新旧部门同为新部门的问题（方法顺序问题）
 *			2.修复了只显示部门编号不显示名字（personBean提供获取部门名字方法）
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
		//a.上部布局
		p1 = new JPanel();
		title = new JLabel("");
		p1.add(title);
		//b.中部布局
		p2 = new JPanel();
		
		String tableTitle[] = {"流水号","人员姓名","原部门","新部门","变更次数","变更日期"};
		
		String tableValues[][] = hbean.transferHis();//将人员调动历史的信息添加到表格
		//创建表格
		table = new JTable(tableValues,tableTitle);
		
		//设置表格大小该出现滚动条
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
