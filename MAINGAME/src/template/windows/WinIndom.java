package template.windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import template.datapack.DataPack;
import template.main.EventManager;
import template.tool.ImagePanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.border.LineBorder;
/*
 * template version 1.3
 * 可视化界面模板
 * update:20190930 18:30
 * 跟新：解决了界面闪烁的问题
 * 		跟新了一些类的结构和注释的问题
 * 		注释中：//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥***¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
 * 			表示最重要的事情
 * 		蓝色的部分则是表示对代码块的解释
 * 		细节用单句注释阐述
 * 		推荐收起后再看代码
 * 
 * 	推荐看WinInDom.java的注释
 * 
 * 可视化界面模板
 * update:20191006 18:30
 * 加入了按钮的可见／不可见
 * 加入了时钟（简陋）
 * 鼠标事件响应不需要再写set game了，使用方法和dataPack的传递一样
 * 
 **/
	/*************************************************************	
	 *
	 * 推荐直接复制粘贴pureDmoe使用，直接使用JFrame生成的窗口不太符合我们的需求
	 * 界面的实现可以参考这个文件
	 * 
	 *************************************************************/


public class WinIndom extends WinBase{
	
	/*************************************************************	
	 *
	 *【内部的事件响应类】
	 * 这里只写了鼠标的动作，如果之后熟悉了可以加入键盘的操作
	 * 写成类内部的类是为了防止别的分支事件访问到它，所以可以乱命名
	 * 所有必要实现的接口都实现了。
	 * 
	 *************************************************************/
	static private class demoMouseListener extends BaseMouseListener{
		static public DataPack dataPackage;
		static public EventManager mainGame;
		private JFrame frame;
		private JButton button;
		private int mode;
		
		public demoMouseListener(int i){
			this.mode=i;
		}
		public void setFrame(JFrame frame) {
			this.frame=frame;
		}
		
		public void setButton(JButton button) {
			this.button=button;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			/*		START OF YOUR CODE		*/
			if(mode==0) {
				dataPackage.choiceA="sleep";	//点按钮0（睡觉按钮）返回sleep
			}else if(mode==1) {
				dataPackage.choiceA="selfstudy";//点按钮1（自习按钮）返回selfstudy
			}else{
				dataPackage.choiceA="gotoclass";//点按钮2（上课按钮）返回gotoclass
			}
			/*		END OF YOUR CODE		*/
			//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥要刷新事件这部分一定要加¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
			EventManager.dataPackage=dataPackage;
			synchronized(mainGame) {
				mainGame.notify();
			}
			//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥要刷新事件这部分一定要加¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
	}


	/*************************************************************
	 * 	
	 * 【构造函数】
	 * 不要新建JFrame窗口对象，而是把上层传进来的窗口对象里面的东西扔了，重新添加
	 * 
	 *************************************************************/
	public WinIndom(EventManager mainGame,JFrame frame) {
		
		//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥这部分不允许改¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.mainGame=mainGame;
		//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥这部分不允许改¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
		
		/*************************************************************	
		 *【背景镶板】
		 * 所有的组件都在里面，两个按钮直接用插件拖进去的
		 * 这一部分按照流程做的话就会自然消失的，推荐直接在可视化界面编辑属性 
		 *************************************************************/
		JPanel backgroundPanel=new JPanel();
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setBounds(0, 0, 1080, 720);
		backgroundPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("继续睡觉");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.setBounds(819, 544, 148, 55);
		backgroundPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("自习");
		btnNewButton_1.setBounds(812, 477, 155, 55);
		btnNewButton_1.setText("自习");
		backgroundPanel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(819, 611, 148, 55);
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		if (dataPackage.stateB.equals("classtime")) {	//仅仅在符合“classtime”状态的时候显示这个按钮
			backgroundPanel.add(btnNewButton_2);
			btnNewButton_2.setText(dataPackage.stateA);
		}
		/*************************************************************	
		 * 【小事件】 
		 *  	这一部分需要用dataPackage.trigSubEvent决定是否绘制
		 *************************************************************/
		
		JPanel EventPanel = new JPanel();				//将来可以用它来放临时小事件，目前没有需要
		EventPanel.setBounds(225, 121, 575, 425);
		backgroundPanel.add(EventPanel);
		EventPanel.setLayout(null);
		EventPanel.setVisible(dataPackage.trigSubEvent);
		
		/*************************************************************	
		 * 【镶时钟】
		 *************************************************************/
		
		JPanel timePanel = new JPanel();
		timePanel.setBorder(new LineBorder(new Color(204, 153, 255), 3));
		timePanel.setBackground(new Color(204, 204, 255));
		timePanel.setBounds(66, 32, 195, 63);
		backgroundPanel.add(timePanel);
		timePanel.setLayout(null);
		
		JLabel label_1 = new JLabel("当前时间为："+String.valueOf(dataPackage.time)+" 时");
		label_1.setBounds(6, 35, 172, 16);
		timePanel.add(label_1);
		
		JLabel label_2 = new JLabel("当前日期为：第"+String.valueOf(dataPackage.term)+"学期"+String.valueOf(dataPackage.date)+"日");
		label_2.setBounds(6, 10, 172, 16);
		timePanel.add(label_2);
		
		/*************************************************************	
		 * 【镶属性】
		 *************************************************************/
		
		JPanel sxPanel = new JPanel();
		sxPanel.setBounds(64, 184, 197, 267);
		backgroundPanel.add(sxPanel);
		sxPanel.setLayout(null);
		
		JLabel StudentIDLable = new JLabel("学号");
		StudentIDLable.setFont(new Font("STFangsong", Font.PLAIN, 13));
		StudentIDLable.setBounds(26, 82, 32, 16);
		sxPanel.add(StudentIDLable);
		
		JTextPane nameShow = new JTextPane();
		nameShow.setEditable(false);
		nameShow.setBounds(70, 42, 78, 24);
		sxPanel.add(nameShow);
		
		JLabel nameLable = new JLabel("姓名");
		nameLable.setFont(new Font("STFangsong", Font.PLAIN, 13));
		nameLable.setBounds(26, 42, 32, 24);
		sxPanel.add(nameLable);
		
		JProgressBar healthBar = new JProgressBar();
		healthBar.setBounds(60, 119, 124, 20);
		sxPanel.add(healthBar);
		
		JProgressBar IQBar = new JProgressBar();
		IQBar.setBounds(60, 139, 124, 20);
		sxPanel.add(IQBar);
		
		JProgressBar StrongBar = new JProgressBar();
		StrongBar.setBounds(60, 165, 124, 20);
		sxPanel.add(StrongBar);
		
		JProgressBar happyBar = new JProgressBar();
		happyBar.setBounds(60, 187, 124, 20);
		sxPanel.add(happyBar);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(60, 211, 124, 20);
		sxPanel.add(progressBar);
		
		JLabel labelIQ = new JLabel("智力值");
		labelIQ.setBounds(6, 142, 52, 16);
		sxPanel.add(labelIQ);
		
		JLabel labelstrong = new JLabel("体力值");
		labelstrong.setBounds(6, 166, 52, 16);
		sxPanel.add(labelstrong);
		
		JLabel labelshealth = new JLabel("健康值");
		labelshealth.setBounds(6, 118, 52, 16);
		sxPanel.add(labelshealth);
		
		JLabel label_happy = new JLabel("心   情");
		label_happy.setBounds(6, 189, 52, 16);
		sxPanel.add(label_happy);
		
		JLabel label_social = new JLabel("社交力");
		label_social.setBounds(6, 213, 52, 16);
		sxPanel.add(label_social);
		
		JTextPane IDshow = new JTextPane();
		IDshow.setBounds(70, 78, 78, 24);
		sxPanel.add(IDshow);
		IDshow.setEditable(false);
		IDshow.setText(dataPackage.name);//显示名字
		
		JPanel coursePanel = new JPanel();
		coursePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		coursePanel.setBounds(752, 35, 263, 160);
		backgroundPanel.add(coursePanel);
		coursePanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("课程表");
		lblNewLabel.setBounds(6, 6, 61, 16);
		coursePanel.add(lblNewLabel);
		
		JPanel kcbBackground = new ImagePanel("imgsrc//kcb.jpg",0, 0, 263, 160);
		kcbBackground.setBounds(0, 0, 263, 160);
		coursePanel.add(kcbBackground);
		
		/*************************************************************	
		 * 【镶待办事项】
		 *  这一部分按照流程做的话就会自然消失的
		 *************************************************************/
		JPanel imagePanel = new JPanel();
		imagePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		imagePanel.setLayout(null);
		imagePanel.setBounds(752, 248, 263, 189);
		backgroundPanel.add(imagePanel);
		
		JLabel label = new JLabel("待办事项");
		label.setBounds(6, 6, 61, 16);
		imagePanel.add(label);
		
		JPanel dbsxBackgruond = new ImagePanel("imgsrc//dbsx.jpg",0, 0, 263, 189);
		dbsxBackgruond.setBounds(0, 0, 263, 189);
		imagePanel.add(dbsxBackgruond);
		
		JPanel sxBackground = new ImagePanel("imgsrc//shuxing.jpg",0, 0, 197, 267);
		sxBackground.setBounds(0, 0, 197, 267);
		sxPanel.add(sxBackground);
		sxBackground.setOpaque(false);
		sxBackground.setLayout(null);
		
		JPanel Background=new ImagePanel("imgsrc//dom.jpg",0, 0, 1080, 720);
		Background.setBounds(0, 0, 1080, 720);
		backgroundPanel.add(Background);
		Background.setLayout(null);
		/*****************************************************************				
		 * 
		 * 【细节设定】
		 * 在用插件绘制完界面之后进行界面内数值设定
		 * 利用数据包进行显示控件的输出的设置
		 * 
		 *****************************************************************/
		/*		START OF YOUR CODE		*/

		
		IQBar.setValue(dataPackage.characterIQ);
		progressBar.setValue(dataPackage.characterEQ);
		StrongBar.setValue(dataPackage.characterStrength);
		happyBar.setValue(dataPackage.characterHappiness);
		healthBar.setValue(dataPackage.characterHealth);//进度条设置进度
		IQBar.setStringPainted(true);
		progressBar.setStringPainted(true);
		StrongBar.setStringPainted(true);//开启进度条显示字
		happyBar.setStringPainted(true);
		healthBar.setStringPainted(true);
		IQBar.setString(String.format("%d",dataPackage.characterIQ));
		progressBar.setString(String.format("%d",dataPackage.characterEQ));
		StrongBar.setString(String.format("%d",dataPackage.characterStrength));
		happyBar.setString(String.format("%d",dataPackage.characterHappiness));
		healthBar.setString(String.format("%d",dataPackage.characterHealth));//进度条显示字
		nameShow.setText(dataPackage.studentID);//显示学号
		

		/*********************************************			
		 * 【鼠标动作的设置】
		 ********************************************/
		demoMouseListener.dataPackage=dataPackage;//数据包注册，不需要改
		demoMouseListener.mainGame=mainGame;
		
		demoMouseListener clicksleep=new demoMouseListener(0);//设置鼠标监听器，发生1号事件
		demoMouseListener clickselfstudy=new demoMouseListener(1);//设置鼠标监听器，发生0号事件
		demoMouseListener clickgotoclass=new demoMouseListener(2);//设置鼠标监听器，发生1号事件

		clicksleep.setButton(btnNewButton);
		clickselfstudy.setButton(btnNewButton_1);
		clickgotoclass.setButton(btnNewButton_2);
		
    	btnNewButton.addMouseListener(clicksleep);//0号事件是 睡觉按钮 被点击
		btnNewButton_1.addMouseListener(clickselfstudy);//1号事件是 去自习按钮 被点击
		btnNewButton_2.addMouseListener(clickgotoclass);//2号事件是 去上课按钮 被点击

		/*		END OF YOUR CODE		*/
    	    	
    	/*****************************************************************				
		 * 【恢复显示】
		 * 必须存在的四行代码！！！！
		 ******************************************************************/
		//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥这部分不允许改¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
		frame.getContentPane().removeAll();
		frame.getContentPane().add(backgroundPanel);
		frame.getContentPane().repaint();
    	frame.setVisible(true);
    	//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥这部分不允许改¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
	}
}