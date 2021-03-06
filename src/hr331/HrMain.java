package hr331;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *项目名称:人力资源管理系统
 *类名:HrMain
 *类描述:主界面
 *创建人:an
 *修改备注:
 *@version 1.0.0
 */

public class HrMain extends JFrame implements TreeSelectionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JSplitPane splitPane ;//split面板
	JPanel p1;//左右面板
	static JPanel p2;
	JScrollPane scrollPane;//滚动面板
	JTree tree ;//树
	Image image;//图片
	JLabel label,imgLabel;
	DefaultMutableTreeNode root;//树根
	DefaultMutableTreeNode node1,node2,node3,node4,node5;//树节点1、2、3、4、5,对应模块
	DefaultMutableTreeNode node11,node12,node13,node14,node15;//第一个节点的子节点
	DefaultMutableTreeNode node21,node22;//第二个节点的子节点
	DefaultMutableTreeNode node31,node32;//第三个节点的子节点
	DefaultMutableTreeNode node41,node42;//第四个节点的子节点
	DefaultMutableTreeNode node51,node52;//第五个节点的子节点
	//构造函数，用于初始
	HrMain(){
		Image image = Toolkit.getDefaultToolkit().getImage("images/computer.png");
		setIconImage(image);//设置标题栏的图标
		setTitle("管理员 - "+AdminBean.titlename);//设置标题栏的标题
		
		root = new DefaultMutableTreeNode("HR331人事管理");

		//添加节点1的子节点
		node1 = new DefaultMutableTreeNode("基本管理");
		node11 = new DefaultMutableTreeNode("添加人员信息");
		node1.add(node11);
		node12 = new DefaultMutableTreeNode("修改人员信息");
		node1.add(node12);
		node13 = new DefaultMutableTreeNode("删除人员信息");
		node1.add(node13);
		node14 = new DefaultMutableTreeNode("查询人员信息");
		node1.add(node14);
		node15 = new DefaultMutableTreeNode("部门管理");
		node1.add(node15);
		root.add(node1);
		
		//添加节点2的子节点
		node2 = new DefaultMutableTreeNode("岗位管理");
		node21 = new DefaultMutableTreeNode("人员调动");
		node2.add(node21);
		node22 = new DefaultMutableTreeNode("调动历史查询");
		node2.add(node22);
		root.add(node2);
		//添加节点3的子节点
		node3 = new DefaultMutableTreeNode("考核管理");
		node31 = new DefaultMutableTreeNode("人员考核");
		node3.add(node31);
		node32 = new DefaultMutableTreeNode("考核历史查询");
		node3.add(node32);
		root.add(node3);
		//添加节点4的子节点
		node4 = new DefaultMutableTreeNode("劳资管理");
		node41 = new DefaultMutableTreeNode("劳资分配管理");
		node4.add(node41);
		node42 = new DefaultMutableTreeNode("劳资历史查询");
		node4.add(node42);
		root.add(node4);
		//添加节点5的子节点
		node5 = new DefaultMutableTreeNode("账户管理");
		node51 = new DefaultMutableTreeNode("个人信息修改");
		node5.add(node51);
		node52 = new DefaultMutableTreeNode("修改密码");
		node5.add(node52);
		root.add(node5);
		//创建一棵树
		tree = new JTree(root);
		tree.addTreeSelectionListener(this);//添加树被选择事件

		scrollPane = new JScrollPane(tree);//将树添加到滚动面板
		//左面板
		p1 = new JPanel();
		p1.add(scrollPane);
		//右面板，可以被替改
		p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		
		//图标,加到标签，再加到右面板
        //ImageIcon icon = new ImageIcon("images/building1.png");
		imgLabel = new JLabel("",SwingConstants.CENTER);
		imgLabel.setBounds(10, 10, 300, 300);
		
		
		p2.add("Center",imgLabel);
		//将左右面板加到split面板
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(p1);
		splitPane.setRightComponent(p2);
		
		setContentPane(splitPane);
			
		//设置JFrame的属性
		setResizable(false);//设置不可以改变大小
		pack();//自动调整
		setSize(800,450);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//点击右上角结束程序
		
		//设置运行时窗口的位置
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				Dimension frameSize = getSize();
				if (frameSize.height > screenSize.height) {
					frameSize.height = screenSize.height;
				}
				if (frameSize.width > screenSize.width) {
					frameSize.width = screenSize.width;
				}
				setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setVisible(true);
	}
	

	
	
	@Override
	/*
	 * 重载的valueChange方法
	 * 当单击树节点时，事件触发，
	 * 创建的添加人员信息、修改人员信息等面板会自动加到右面板区域
	 */
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode dnode = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
		String dnode_str = dnode.toString();
		if(dnode_str == "人事管理系统"){
			splitPane.setRightComponent(p2);	
		}else if(dnode_str == "添加人员信息"){
			splitPane.setRightComponent(new Node11Panel());
		}else if(dnode_str == "修改人员信息"){
				splitPane.setRightComponent(new Node12Panel());	
		}else if(dnode_str == "查询人员信息"){
			splitPane.setRightComponent(new Node14Panel());	
		}else if(dnode_str == "删除人员信息"){
			splitPane.setRightComponent(new Node13Panel());	
		}else if(dnode_str == "部门管理"){
			splitPane.setRightComponent(new Node15Panel());	
		}else if(dnode_str == "人员调动"){
			splitPane.setRightComponent(new Node21Panel());	
		}else if(dnode_str == "调动历史查询"){
			splitPane.setRightComponent(new Node22Panel());	
		}else if(dnode_str == "人员考核"){
			splitPane.setRightComponent(new Node31Panel());	
		}else if(dnode_str == "考核历史查询"){
			splitPane.setRightComponent(new Node32Panel());	
		}else if(dnode_str == "劳资分配管理"){
			splitPane.setRightComponent(new Node41Panel());
		}else if(dnode_str == "劳资历史查询"){
			splitPane.setRightComponent(new Node42Panel());
		}else if(dnode_str == "个人信息修改"){
			splitPane.setRightComponent(new Node51Panel());
		}else if(dnode_str == "修改密码"){
			splitPane.setRightComponent(new Node52Panel());
		}else{
			splitPane.setRightComponent(p2);
		}
		
	}
	
	/*
	 * 提供刷新右边子面板的方法
	 */
	public static void reDraw(String cName) {
		
		if(cName == ""){
			splitPane.setRightComponent(p2);	
		}else if(cName.equals("hr331.Node11Panel")){
			splitPane.setRightComponent(new Node11Panel());
		}else if(cName.equals("hr331.Node12Panel")){
			splitPane.setRightComponent(new Node12Panel());	
		}else if(cName.equals("hr331.Node13Panel")){
			splitPane.setRightComponent(new Node13Panel());	
		}else if(cName.equals("hr331.Node14Panel")){
			splitPane.setRightComponent(new Node14Panel());	
		}else if(cName.equals("hr331.Node15Panel")){
			splitPane.setRightComponent(new Node15Panel());	
		}else if(cName.equals("hr331.Node21Panel")){
			splitPane.setRightComponent(new Node21Panel());	
		}else if(cName.equals("hr331.Node22Panel")){
			splitPane.setRightComponent(new Node22Panel());	
		}else if(cName.equals("hr331.Node31Panel")){
			splitPane.setRightComponent(new Node31Panel());	
		}else if(cName.equals("hr331.Node32Panel")){
			splitPane.setRightComponent(new Node32Panel());	
		}else if(cName.equals("hr331.Node41Panel")){
			splitPane.setRightComponent(new Node41Panel());
		}else if(cName.equals("hr331.Node42Panel")){
			splitPane.setRightComponent(new Node42Panel());
		}else if(cName.equals("hr331.Node51Panel")){
			splitPane.setRightComponent(new Node51Panel());
		}else if(cName.equals("hr331.Node52Panel")){
			splitPane.setRightComponent(new Node52Panel());
		}else{
			splitPane.setRightComponent(p2);
		}
	}
	


}
