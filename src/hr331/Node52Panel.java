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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *项目名称:人力资源管理系统
 *类名:Node52Panel
 *类描述:管理员账号的密码修改与销户
 *创建人:an
 *修改备注:
 *@version 1.0.0
 */

public class Node52Panel extends JPanel implements ActionListener,ItemListener{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String[] p = null;
	
	AdminBean abean = new AdminBean();
	
	JLabel title;
	JButton update,delete;	//修改，清空
	JPanel p1,p2,p3;
	GridBagLayout gridL;
	GridBagConstraints gridC;
	JPasswordField newPwdText,confirmText;
	JTextField usnameText;
	JLabel usnameLabel,newPwdLabel,confirmLabel;
	public Node52Panel(){
		init();
	
	}
	
	public void init(){
		
		setLayout(new BorderLayout());
		
		gridL = new GridBagLayout();
		
		int width = 8;//JTextField的宽度,便于代码修改
		//a.上部布局
		p1 = new JPanel();
		title = new JLabel("密码修改");
		p1.add(title);
		//b.中部布局
		p2 = new JPanel();
		p2.setLayout(gridL);
		//账户名
		usnameLabel = new JLabel("帐户名:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 1;
		gridC.insets = new Insets(10, 1, 20, 5);
		gridL.setConstraints(usnameLabel, gridC);
		p2.add(usnameLabel);
		
		usnameText = new JTextField(width);
		usnameText.setEditable(false);
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 1;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(usnameText, gridC);
		p2.add(usnameText);
		//新密码
		newPwdLabel = new JLabel("新密码:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(newPwdLabel, gridC);
		p2.add(newPwdLabel);
		
		newPwdText = new JPasswordField(width);
		newPwdText.setEchoChar('*');
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 2;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(newPwdText, gridC);
		p2.add(newPwdText);
		//确认新密码
		confirmLabel = new JLabel("确认密码:");
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(confirmLabel, gridC);
		p2.add(confirmLabel);
				
		confirmText = new JPasswordField(width);
		confirmText.setEchoChar('*');
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 3;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(confirmText, gridC);
		p2.add(confirmText);		
		
		//修改按钮
		update =  new JButton("修改");
		update.addActionListener(this);//添加动作事件
		gridC = new GridBagConstraints();
		gridC.gridx = 0;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(update, gridC);
		p2.add(update);
		
		//注销按钮
		delete = new JButton("销户");
		
		delete.addActionListener(this);//添加动作事件
		gridC = new GridBagConstraints();
		gridC.gridx = 1;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(delete, gridC);
		p2.add(delete);		
		
		
		add("North",p1);
		add("Center",p2);	
		infoIn();//信息填充
	}
/*
 * 重载的动作事件
 * 
 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e){
		String newPwd = newPwdText.getText();
		String conPwd = confirmText.getText();
		if(e.getSource() == update){//单击修改
			//调用PersonBean的修改方法
			if(newPwd.trim().length()!=0) {
				if(conPwd.trim().length()!=0) {
					if(newPwd.equals(conPwd)) {
						abean.update(usnameText.getText(), newPwdText.getText());
						JOptionPane.showMessageDialog(null, "修改密码成功!请重新登陆！");//提示
						Login.hidden();
						new Login();
					}
					else JOptionPane.showMessageDialog(null, "两次密码不符合！请核对后再尝试！");
				}
				else JOptionPane.showMessageDialog(null, "请确认新密码！");
			}
			else
				JOptionPane.showMessageDialog(null, "请输入原密码！");
		}
		else if (e.getSource() == delete) {
			int option = JOptionPane.showConfirmDialog(null, "点击以继续", "账户注销", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);  
	        if (option == JOptionPane.YES_OPTION) {  
	            // ......  
	        	int optionsAgain = JOptionPane.showConfirmDialog(null, "此操作将直接注销您的管理员账户！", "警告", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE); 
		        	if(optionsAgain == JOptionPane.YES_NO_OPTION) {
		        		abean.cancelAccount(p[0]);//销户操作！
			        	JOptionPane.showMessageDialog(null, "销户成功！将返回登陆界面！");
			        	Login.hidden();
			        	new Login();
			        	super.repaint();
		        	}
		        	else if (optionsAgain == JOptionPane.NO_OPTION) {
						//无操作返回
					}
	        } else if (option == JOptionPane.NO_OPTION) {  
	            // ......  返回
	        }  
		}
	}
	

	/*
	 * 清空文本框方法
	 */
	public void clearAll(){
		usnameText.setText(null);
		newPwdText.setText(null);
		confirmText.setText(null);	
	}



	/*
	 * 重载的JcomboBox事件
	 */
	
	public void infoIn() {
			p = abean.search(AdminBean.titlename);//字符串数组p用于获取从数据库导入的人员信息
			//将数据库导入的人员信息通过数组，添加到相应的组件
			usnameText.setText(p[0]);//账户名
	
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
}
