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
 *项目名称:人力资源管理系统
 *类名:Node41Panel
 *类描述:劳资管理
 *创建人:an
 *修改备注:
 *			1.解决刷新问题
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
	//将一维数组的信息添加到表格的标题，二维数组的信息添加到表格主体
	String tableTitle[] = {"工号","姓名","性别","部门","薪酬","考核信息"};
	
	String tableValues[][] = dbean.searchMsg();//获取数据库信息
	
	ListSelectionModel listModel;//表格选择模式
	
	JOptionPane op = new JOptionPane();
	
	String PersonId;
	
	
	public Node41Panel(){
		init();
	}
	public void init(){
		int width = 5;//JTextField的宽，便于代码修改
		
		setLayout(new BorderLayout());
		gridL = new GridBagLayout();
		//a.上部布局
		p1 = new JPanel();
		
		title = new JLabel("劳资分配管理");
		p1.add(title);
		//b.中部布局
		p2 = new JPanel();
		//创建表格
		table = new JTable(tableValues,tableTitle);
		listModel=table.getSelectionModel();
		listModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModel.addListSelectionListener(this);//添加表格选中事件
		
		//设置表格大小该出现滚动条
		Dimension a=new Dimension();
		a.height=280;
		a.width=500;
		table.setPreferredScrollableViewportSize(a);
		
		scrollPane = new JScrollPane(table);
		
		p2.add(scrollPane);
		//c.下部布局
		p3 = new JPanel();
		p3.setLayout(gridL);
		//姓名
		nameLabel = new JLabel("姓名:");
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
	//之前工资
		beforeSalaryLabel = new JLabel("调整前的工资:");
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
		//调整后的工资
		afterSalaryLabel = new JLabel("调整后的工资:");
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
		//确定按钮
		ok= new JButton("确定");
		ok.addActionListener(this);//添加动作事件
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 2;
		gridC.insets = new Insets(5, 10, 5, 10);
		gridL.setConstraints(ok, gridC);
		p3.add(ok);
		//清空信息按钮
		clear = new JButton("清空信息");
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
	 * 单击按钮时，触发事件
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
				String chgTime=""+hbean.countChgTime("劳资分配", PersonId);
						
				hbean.add(jourNoStr, "劳资分配",beforeSalaryText.getText(), afterSalaryText.getText(), regDate, chgTime,PersonId);
			
				JOptionPane.showMessageDialog(null,"劳资分配成功!");
				HrMain.reDraw(this.getClass().getName());//解决刷新问题
			}else
				JOptionPane.showMessageDialog(null, "请先选择您要调整薪酬的员工！");
		}
		
		
	}
	/*
	 * 清空JTextField组件
	 */
	public void  clearAll(){
		nameText.setText(null);
		beforeSalaryText.setText(null);
		afterSalaryText.setText(null);
	}
	
	@Override
	/*
	 * 表格选中时，将信息加到JTextField组件
	 * */
	public void valueChanged(ListSelectionEvent e) {
		int row[]=table.getSelectedRows();//表格的行
		int col[]=table.getSelectedColumns();//表格的列
		
		//通过两重循环，获取表格每一个单元格的信息
		for(int i=0;i<row.length;i++)
			for(int j=0;j<col.length;j++){
			
				nameText.setText(tableValues[row[i]][1]);
				beforeSalaryText.setText(tableValues[row[i]][4]);
				//thisAssessCom.addItem(tableValues[row[i]][5]);
				PersonId=tableValues[row[i]][0];
				
				
			}
	}
}

