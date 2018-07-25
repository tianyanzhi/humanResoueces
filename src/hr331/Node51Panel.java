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
 *��Ŀ����:������Դ����ϵͳ
 *����:Node51Panel
 *������:����Ա�޸��Լ�����Ϣ
 *������:an
 *�޸ı�ע:
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
	JButton startUpdate,update;	//�޸ģ����
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
		
		int width = 8;//JTextField�Ŀ��,���ڴ����޸�
		//a.�ϲ�����
		p1 = new JPanel();
		title = new JLabel("����Ա��Ϣ�޸�");
		p1.add(title);
		//b.�в�����
		p2 = new JPanel();
		p2.setLayout(gridL);
		//�ʻ���
		pIdLabel = new JLabel("�˻���:");
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
		//����
		nameLabel = new JLabel("����		:");
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
		//�Ա�
		sexLabel = new JLabel("�Ա�		:");
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
		
		//����
		birLabel = new JLabel("����		:");
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
		//����
		natLabel = new JLabel("����		:");
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
		
		//��ַ
		adLabel = new JLabel("��ַ	:");
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
		
		startUpdate =  new JButton("�����޸�");
		startUpdate.addActionListener(this);//��Ӷ����¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(startUpdate, gridC);
		p2.add(startUpdate);
		
		update =  new JButton("ȷ���޸�");
		update.addActionListener(this);//��Ӷ����¼�
		gridC = new GridBagConstraints();
		gridC.gridx = 2;
		gridC.gridy = 4;
		gridC.insets = new Insets(20, 1, 20, 5);
		gridL.setConstraints(update, gridC);
		p2.add(update);
		
		
		add("North",p1);
		add("Center",p2);	
		infoIn();//��Ϣ���
	}
/*
 * ���صĶ����¼�
 * 
 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == update){//�����޸�
			//����PersonBean���޸ķ���
			abean.update(usnameText.getText(), nameText.getText(), sexText.getText(), 
					birText.getText(), natText.getText(), adText.getText());
			
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�!");//��ʾ
			updateConfiemed();
			infoIn();//����Ϣ��䵽����
		}else if (e.getSource() == startUpdate) {
			startUpdate();
		}
	}
	

	/*
	 * ����ı��򷽷�
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
	 *�����޸ķ��������ı�������Ϊ�ɱ༭��ͬʱ����ť���ų�ȷ�ϰ�ť 
	 */
	public void startUpdate() {
		
		nameText.setEditable(true);
		sexText.setEditable(true);
		birText.setEditable(true);
		natText.setEditable(true);
		adText.setEditable(true);
		p2.remove(startUpdate);
		p2.add(update);
		p2.repaint();//�ػ�
	}
	/*
	 *�޸���ɺ� 
	 */
	public void updateConfiemed() {
		
		nameText.setEditable(false);
		sexText.setEditable(false);
		birText.setEditable(false);
		natText.setEditable(false);
		adText.setEditable(false);
		p2.remove(update);
		p2.add(startUpdate);
		p2.repaint();//�ػ�
	}

	
	/*
	 * ���ص�JcomboBox�¼�
	 */
	
	public void infoIn() {
			p = abean.search(AdminBean.titlename);//�ַ�������p���ڻ�ȡ�����ݿ⵼�����Ա��Ϣ
			//�����ݿ⵼�����Ա��Ϣͨ�����飬��ӵ���Ӧ�����
			usnameText.setText(p[0]);//�˻���
			nameText.setText(p[1]);
			sexText.setText(p[2]);
			birText.setText(p[3]);//����������Ϣ
			natText.setText(p[4]);//������Ϣ
			adText.setText(p[5]);//��ַ��Ϣ
	
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
}
