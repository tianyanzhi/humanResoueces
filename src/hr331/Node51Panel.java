package hr331;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *项目名称:人力资源管理系统
 *类名:Node51Panel
 *类描述:管理员修改自己的信息
 *创建人:an
 *修改备注:
 *@version 1.0.0
 */

public class Node51Panel extends JPanel implements ActionListener,ItemListener{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String[] p = null;
	
	AdminBean abean = new AdminBean();
	
	JLabel title;
	JButton startUpdate,update;	//修改，清空
	JPanel p1,p2;
	GridBagLayout gridL;
	GridBagConstraints gridC;
	JTextField usnameText,nameText,sexText,birText,natText,adText;
	JLabel pIdLabel,nameLabel,sexLabel,birLabel,natLabel,adLabel;
	public Node51Panel(){
		init();
	
	}
	
	public void init(){
		
		setLayout(new BorderLayout());
		
		gridL = new GridBagLayout();
		
		int width = 8;//JTextField的宽度,便于代码修改
		//a.上部布局
		p1 = new JPanel();
		title = new JLabel("管理员信息修改");
		p1.add(title);
		//b.中部布局
		p2 = new JPanel();
		p2.setLayout(gridL);
		//帐户名
		pIdLabel = new JLabel("账户名:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 1;
		gridC.insets = new Insets(10, 1, 20, 5);
		gridL.setConstraints(pIdLabel, gridC);
		p2.add(pIdLabel);
		
		usnameText = new JTextField(width);
		usnameText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 1;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(usnameText, gridC);
		p2.add(usnameText);
		//姓名
		nameLabel = new JLabel("姓名		:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 1;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(nameLabel, gridC);
		p2.add(nameLabel);
		
		nameText = new JTextField(width);
		nameText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 1;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(nameText, gridC);
		p2.add(nameText);
		//性别
		sexLabel = new JLabel("性别		:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(sexLabel, gridC);
		p2.add(sexLabel);
		
		sexText = new JTextField(width);
		sexText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(sexText, gridC);
		p2.add(sexText);
		
		//生日
		birLabel = new JLabel("生日		:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(birLabel, gridC);
		p2.add(birLabel);
		
		birText = new JTextField(width);
		birText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(birText, gridC);
		p2.add(birText);
		//民族
		natLabel = new JLabel("民族		:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(natLabel, gridC);
		p2.add(natLabel);
		
		natText = new JTextField(width);
		natText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(natText, gridC);
		p2.add(natText);
		
		//地址
		adLabel = new JLabel("地址	:");
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(adLabel, gridC);
		p2.add(adLabel);
		
		adText = new JTextField(width);
		adText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 3;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(adText, gridC);
		p2.add(adText);
		
		startUpdate =  new JButton("开启修改");
		startUpdate.addActionListener(this);//添加动作事件
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(startUpdate, gridC);
		p2.add(startUpdate);
		
		update =  new JButton("确认修改");
		update.addActionListener(this);//添加动作事件
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(update, gridC);
		p2.add(update);
		
		
		add("North",p1);
		add("Center",p2);	
		infoIn();//信息填充
	}
/*
 * 重载的动作事件
 * 
 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == update){//单击修改
			//调用PersonBean的修改方法
			abean.update(usnameText.getText(), nameText.getText(), sexText.getText(), 
					birText.getText(), natText.getText(), adText.getText());
			
			JOptionPane.showMessageDialog(null, "修改成功!");//提示
			updateConfiemed();
			infoIn();//将信息填充到里面
		}else if (e.getSource() == startUpdate) {
			startUpdate();
		}
	}
	

	/*
	 * 清空文本框方法
	 */
	public void clearAll(){
		usnameText.setText(null);
		nameText.setText(null);
		sexText.setText(null);
		birText.setText(null);
		natText.setText(null);
		adText.setText(null);	
	}
	
	/*
	 *开启修改方法，讲文本框设置为可编辑，同时收起按钮，放出确认按钮 
	 */
	public void startUpdate() {
		
		nameText.setEditable(true);
		sexText.setEditable(true);
		birText.setEditable(true);
		natText.setEditable(true);
		adText.setEditable(true);
		p2.remove(startUpdate);
		p2.add(update);
		p2.repaint();//重画
	}
	/*
	 *修改完成后 
	 */
	public void updateConfiemed() {
		
		nameText.setEditable(false);
		sexText.setEditable(false);
		birText.setEditable(false);
		natText.setEditable(false);
		adText.setEditable(false);
		p2.remove(update);
		p2.add(startUpdate);
		p2.repaint();//重画
	}

	
	/*
	 * 重载的JcomboBox事件
	 */
	
	public void infoIn() {
			p = abean.search(AdminBean.titlename);//字符串数组p用于获取从数据库导入的人员信息
			//将数据库导入的人员信息通过数组，添加到相应的组件
			usnameText.setText(p[0]);//账户名
			nameText.setText(p[1]);
			sexText.setText(p[2]);
			birText.setText(p[3]);//出生年月信息
			natText.setText(p[4]);//民族信息
			adText.setText(p[5]);//地址信息
	
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
}
