package THUgame.subwindows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import java.awt.Font;
import THUgame.datapack.DataPack;
import THUgame.main.EventManager;
import THUgame.tool.ImagePanel;
import THUgame.windows.WinBase;

/*
 * 【宿舍界面】
 * 
 * --DIALOG--
 *  update:20191123
 *  via：余冬杰  
 *  
 *  update:20191029
 *  via：余冬杰
 *  更新：
 *  TODO:
 *      1.
 *  TODO LIST in line:
 *  
 **/


public class WinOrgEnroll extends WinBase{
	
	/*************************************************************	
	 *
	 *【内部的事件响应类】
	 * 		这里只写了鼠标的动作，如果之后熟悉了可以加入键盘的操作
	 * 		写成类内部的类是为了防止别的分支事件访问到它，所以可以乱命名
	 * 		所有必要实现的接口都实现了。
	 * 
	 * 
	 *************************************************************/
	static JRadioButton studentUnion;
	static JRadioButton hobbyClub;
	static JRadioButton STA;
	
	static private class demoMouseListener extends BaseMouseListener{
		static public DataPack dataPackage;
		static public EventManager mainGame;
		private JFrame frame;
		private JButton button;
		private int mode;
		
		
		
		public demoMouseListener(int i){
			this.mode=i;
		}
		
		@Override
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
				dataPackage.choiceC="closeQuestionnaire";	//点按钮0（关闭按钮）返回closeQuestionnaire
			}else if(mode ==1){
				dataPackage.choiceC="submitQuestionnaire";//点按钮1（提交按钮）返回submitQuestionnaire
			}else if(mode ==2){
				dataPackage.choiceA="clickNext";//点按钮2（下一步按钮），状态标记为点击下一步
			}else if(mode ==3){
				dataPackage.choiceA="quitCertificate";//点按钮3(关闭按钮)，状态为关闭聘书
			}else if(mode ==4){
				dataPackage.choiceB="refuse";//点按钮4（待着按钮）返回refuse
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
	 * 		不要新建JFrame窗口对象，而是把上层传进来的窗口对象里面的东西扔了，重新添加
	 * 
	 *************************************************************/
	public WinOrgEnroll(EventManager mainGame,JFrame frame) {
		
		//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥这部分不允许改¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.mainGame=mainGame;
		//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥这部分不允许改¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
		/*************************************************************	
		 *【背景镶板】
		 * 		所有的组件都在里面，两个按钮直接用插件拖进去的
		 * 		这一部分按照流程做的话就会自然消失的，推荐直接在可视化界面编辑属性 
		 *************************************************************/
		JPanel backgroundPanel=new JPanel();
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setBounds(0, 0, 1080, 720);
		backgroundPanel.setLayout(null);
		
		
		/*************************************************************	
		 * 【镶对话框】
		 * 		建立一个带背景的Panel的流程设setBounds(x, y, 宽, 高);
		 *  	1.建一个Panel	
		 * 		2.Panel里建两个subPanel，全部都设成setBounds(0, 0, 宽, 高);
		 * 		3.底下的用imagePanel工具类放图片，上面的放控件
		 * 		4.设置两个Panel为透明这一部分按照流程做的话就会自然消失的
		 *************************************************************/
		JPanel dialogPack = new JPanel();
		dialogPack.setBounds(66, 475, 689, 189);
		dialogPack.setOpaque(false);//注意要设成透明的
		dialogPack.setLayout(null);
		
			JPanel dialogPanel = new JPanel();//第1个subPanel，放控件
			dialogPanel.setBounds(0, 0, 689, 189);//(0, 0, 宽, 高);
			
			JPanel dialogBackgoundPanel = new ImagePanel("imgsrc//Dialog.png",0, 0, 689, 189);	//第2个subPanel，放图
																								//(0, 0, 宽, 高);
			dialogBackgoundPanel.setBounds(0, 0, 689, 189);//(0, 0, 宽, 高);
			dialogBackgoundPanel.setOpaque(false);//注意要设成透明的
			dialogPanel.setOpaque(false);		//注意要设成透明的
			dialogPanel.setLayout(null);
			
			JLabel dialogName = new JLabel();
			dialogName.setBounds(17, 6, 89, 40);
			dialogPanel.add(dialogName);
			
			if (dataPackage.count == 1 ||
				dataPackage.count == 3) {
				dialogName.setText("凌艺涵");
			} else {
				dialogName.setText(dataPackage.name);
			}
			
			
			JLabel dialogContent = new JLabel();
			dialogName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			dialogContent.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			dialogContent.setBounds(27, 42, 632, 137);
			dialogPanel.add(dialogContent);
			
			if (!dataPackage.notification.equals(""))//设置对话内容
				dialogContent.setText(dataPackage.notification);
			else
				dialogContent.setText("“咚咚咚。”似乎有人在敲宿舍门");//设置默认对话内容
		
		dialogPack.add(dialogPanel);		//注意：先放的在上层，所以先放带控件的
		
		/*************************************************************	
		* 【下一步按钮】 
		*  	特殊步骤下才会触发
		*  	具体用法见MorninigClass窗口
		*************************************************************/

		JButton nextButton = new JButton();
		nextButton.setBounds(597, 113, 52, 48);
		dialogPanel.add(nextButton);
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		setIcon("/imgsrc/WinOrganization/next.png", nextButton);
		setSelectedIcon("/imgsrc/WinOrganization/nextPressed.png", nextButton);
				
			/*********************************************			
			 * 【局部鼠标动作的设置】
			 ********************************************/
			demoMouseListener.dataPackage=dataPackage;//数据包注册，不需要改
			demoMouseListener.mainGame=mainGame;	
			demoMouseListener clickNext=new demoMouseListener(2);//设置鼠标监听器，发生0号事件
				
			clickNext.setButton(nextButton);
			nextButton.addMouseListener(clickNext);//3号事件是下一步 去上课按钮 被点击	
			
		dialogPack.add(dialogBackgoundPanel);
		backgroundPanel.add(dialogPack);

		if (dataPackage.count == 2) {              //触发聘书，不显示next，通过×交互  
			nextButton.setVisible(false);
		}
		
		
		/*************************************************************	
		* 【聘书】 
		*  	count=2触发
		*  
		*************************************************************/
		JPanel certificatePack = new JPanel();
		certificatePack.setLayout(null);
		certificatePack.setOpaque(false);//注意要设成透明的
		certificatePack.setBounds(309, 136, 407, 290);
		certificatePack.setVisible(false);
			
			JPanel certificatePanel = new JPanel();
			certificatePanel.setBounds(0, 0, 407, 290);
			certificatePanel.setOpaque(false);//注意要设成透明的
			certificatePanel.setLayout(null);
		
			JPanel certificateImage = new ImagePanel("imgsrc/WinOrganization/certificate.png", 0, 0, 407, 290);
			certificateImage.setBounds(0, 0, 407, 290);
			certificateImage.setOpaque(false);//注意要设成透明的
			
			
				// 标题
				JLabel textTitle = new JLabel();
				textTitle.setVerticalAlignment(SwingConstants.CENTER);
				textTitle.setHorizontalAlignment(SwingConstants.CENTER);
				textTitle.setText("<html>聘书</html>");
				textTitle.setOpaque(false);
				textTitle.setFont(new Font("印品黑体", Font.BOLD, 30));
				textTitle.setBounds(10, 37, 387, 50);
				certificatePanel.add(textTitle);
				// 正文
				JLabel textContent = new JLabel();
				textContent.setVerticalAlignment(SwingConstants.TOP);
				String text = "<html>"+dataPackage.name+"：<br>&nbsp&nbsp&nbsp&nbsp";
				if(dataPackage.joinSA) {
					text += "恭喜你被系学生会体育部录取为干事 。";
				}
				if(dataPackage.joinSTA) {
					text += "恭喜你被系科协录取为干事。";
				}
				text += "</html>";
				textContent.setText(text);
				textContent.setOpaque(false);
				textContent.setFont(new Font("印品黑体", Font.BOLD, 20));
				textContent.setBounds(34, 88, 344, 142);
				certificatePanel.add(textContent);
				//落款
				JLabel textLast = new JLabel();
				textLast.setVerticalAlignment(SwingConstants.BOTTOM);
				textLast.setHorizontalAlignment(SwingConstants.RIGHT);
				textLast.setText("<html>系团委</html>");
				textLast.setOpaque(false);
				textLast.setFont(new Font("印品黑体", Font.BOLD, 20));
				textLast.setBounds(231, 172, 147, 50);
				certificatePanel.add(textLast);
				
				// 退出的×
				JButton quitButton = new JButton();
				quitButton.setBounds(347, 37, 50, 50);
				quitButton.setBorderPainted(false);
				quitButton.setContentAreaFilled(false);
				setIcon("/imgsrc/WinOrganization/redCross.png", quitButton);
				setSelectedIcon("/imgsrc/WinOrganization/redCrossPressed.png", quitButton);
				certificatePanel.add(quitButton);
				
				demoMouseListener clickCross=new demoMouseListener(3);//设置鼠标监听器，发生3号事件——关闭聘书
				clickCross.setButton(quitButton);
				quitButton.addMouseListener(clickCross);
				
			certificatePack.add(certificatePanel);
			certificatePack.add(certificateImage);
		backgroundPanel.add(certificatePack);     //触发聘书，不显示next，通过×交互
		
		if (dataPackage.count == 2) {
			certificatePack.setVisible(true);
		}
		
		/*************************************************************	
		 * 【镶时钟】
		 * 		不需要修改
		 * 		简而言之就是显示一个Table
		 *************************************************************/
		/*************************************************************	
		 * 【镶时钟】
		 * 		不需要修改
		 * 		简而言之就是显示一个Table
		 *************************************************************/

		JPanel timePack = new JPanel();
		timePack.setLayout(null);
		timePack.setOpaque(false);//注意要设成透明的
		timePack.setBounds(66, 32, 195, 90);
		
			JPanel timePanel = new JPanel();
			timePanel.setBounds(0, 0, 195, 90);
			JPanel timeBackgoundPanel = new ImagePanel("imgsrc//taili.png",0, 0, 195, 90);	
			timeBackgoundPanel.setBounds(0, 0, 195, 90);
			
			timeBackgoundPanel.setOpaque(false);//注意要设成透明的
			timePanel.setOpaque(false);//注意要设成透明的
			timePanel.setLayout(null);
			
			JLabel timeText = new JLabel("当前时间为："+String.valueOf(dataPackage.time)+" 时");
			timeText.setBounds(6, 60, 172, 16);
			timePanel.add(timeText);
			timeText.setFont(new Font("STFangsong", Font.BOLD, 14));
			
			JLabel dateText = new JLabel("今天是：第"+String.valueOf(dataPackage.term)+"学期"+String.valueOf(dataPackage.week)+"周"+String.valueOf(dataPackage.date)+"日");
			dateText.setBounds(6, 35, 172, 16);
			timePanel.add(dateText);
			dateText.setFont(new Font("STFangsong", Font.BOLD, 14));
			
		timePack.add(timePanel);
		timePack.add(timeBackgoundPanel);
		backgroundPanel.add(timePack);
		/*************************************************************	
		 *************************************************************/

		JPanel panel = new JPanel();
		panel.setBounds(64, 140, 197, 290);
		backgroundPanel.add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setLayout(null);
		
		JLabel StudentIDLable = new JLabel("学号：");
		StudentIDLable.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		StudentIDLable.setBounds(10, 78, 48, 16);
		panel.add(StudentIDLable);
		
		JLabel nameShow = new JLabel();
		nameShow.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		nameShow.setBounds(70, 45, 114, 20);
		panel.add(nameShow);
		
		JLabel nameLable = new JLabel("姓名：");
		nameLable.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		nameLable.setBounds(10, 42, 48, 24);
		panel.add(nameLable);
		
		JLabel IDshow = new JLabel();
		IDshow.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		IDshow.setBounds(70, 76, 114, 20);
		panel.add(IDshow);
		
		JProgressBar healthBar = new JProgressBar();
		healthBar.setBounds(70, 119, 114, 20);
		panel.add(healthBar);
		
		JProgressBar Bar_progress = new JProgressBar();
		Bar_progress.setBounds(70, 140, 114, 20);
		panel.add(Bar_progress);
		
		JProgressBar Bar_Energy = new JProgressBar();
		Bar_Energy.setBounds(70, 165, 114, 20);
		panel.add(Bar_Energy);
		
		JProgressBar Bar_happiness = new JProgressBar();
		Bar_happiness.setBounds(70, 187, 114, 20);
		panel.add(Bar_happiness);
		
		JLabel label_workProgress = new JLabel("学习进度");
		label_workProgress.setBounds(10, 142, 60, 16);
		label_workProgress.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(label_workProgress);
		
		JLabel label_Energy = new JLabel("体力值");
		label_Energy.setBounds(10, 166, 52, 16);
		label_Energy.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(label_Energy);
		
		JLabel label_health = new JLabel("健康值");
		label_health.setBounds(10, 118, 52, 16);
		label_health.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(label_health);
		
		JLabel label_happy = new JLabel("心   情");
		label_happy.setBounds(10, 189, 52, 16);
		label_happy.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(label_happy);
		
		JLabel label_social = new JLabel("社交能力:");
		label_social.setBounds(10, 219, 92, 16);
		label_social.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(label_social);
		
		
		JLabel label_Art = new JLabel("才艺能力:");
		label_Art.setBounds(10, 245, 92, 16);
		label_Art.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(label_Art);
		
		JLabel label_IQ = new JLabel("智商:");
		label_IQ.setBounds(100, 219, 84, 16);
		label_IQ.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(label_IQ);
		
		JLabel label_lucky = new JLabel("幸运值:");
		label_lucky.setBounds(100, 245, 84, 16);
		label_lucky.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		panel.add(label_lucky);
		
		/*************************************************************	
		 * 镶待办事项 这一部分按照流程做的话就会自然消失的
		 *************************************************************/
		JPanel todoList = new JPanel();
		todoList.setLayout(null);
		todoList.setOpaque(false);	
		todoList.setBounds(752, 35, 263, 189);
			
			JLabel label = new JLabel("待办事项");
			label.setForeground(Color.WHITE);
			label.setBounds(20, 25, 100, 18);
			todoList.add(label);
			label.setFont(new Font("STFangsong", Font.BOLD, 16));
				
			JLabel label2 = new JLabel("1.上午课:"+dataPackage.todayMorningClass);
			label2.setForeground(Color.WHITE);
			label2.setBounds(20, 55, 200, 18);
			todoList.add(label2);
			label2.setFont(new Font("STFangsong", Font.BOLD, 16));
				
			JLabel label3 = new JLabel("2.下午课:"+dataPackage.todayAfternoonClass);
			label3.setForeground(Color.WHITE);
			label3.setBounds(20, 85, 200, 18);
			todoList.add(label3);
			label3.setFont(new Font("STFangsong", Font.BOLD, 16));
				
			JLabel label4 = new JLabel("3.");
			label4.setForeground(Color.WHITE);
			label4.setBounds(20, 115, 100, 18);
			todoList.add(label4);
			label4.setFont(new Font("STFangsong", Font.BOLD, 16));
			
			JPanel dbsxBackgruond = new ImagePanel("imgsrc//todoList.png",0, 0, 263, 189);
			dbsxBackgruond.setOpaque(false);	
			dbsxBackgruond.setBounds(0, 0, 263, 189);
		
		todoList.add(dbsxBackgruond);
		dbsxBackgruond.setLayout(null);
		backgroundPanel.add(todoList);
		
		
		/*************************************************************	
		 * 【放背景图】
		 * 		最后放。
		 *************************************************************/
		
		JPanel Background=new ImagePanel("imgsrc//Windom/dom3.jpg",0, 0, 1080, 720);
		if(dataPackage.choiceA.equals("sleep")) {
			Background=new ImagePanel("imgsrc//Windom/dom2.jpg",0, 0, 1080, 720);
		}else if(dataPackage.choiceA.equals("selfstudy")) {
			Background=new ImagePanel("imgsrc//Windom/dom1.jpg",0, 0, 1080, 720);
		}
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
		
		Bar_progress.setValue(dataPackage.studyProgress);
		Bar_Energy.setValue(dataPackage.characterEnergy);
		Bar_happiness.setValue(dataPackage.characterHappiness);
		healthBar.setValue(dataPackage.characterHealth);//进度条设置进度
		Bar_progress.setStringPainted(true);
		Bar_Energy.setStringPainted(true);//开启进度条显示字
		Bar_happiness.setStringPainted(true);
		healthBar.setStringPainted(true);
		Bar_progress.setString(String.format("%d",dataPackage.studyProgress));
		Bar_Energy.setString(String.format("%d",dataPackage.characterEnergy));
		Bar_happiness.setString(String.format("%d",dataPackage.characterHappiness));
		healthBar.setString(String.format("%d",dataPackage.characterHealth));//进度条显示字
		IDshow.setText(dataPackage.studentID);//显示学号
		nameShow.setText(dataPackage.name);//显示名字
		
		label_social.setText("社交能力:"+dataPackage.characterEQ);
		label_Art.setText("才艺能力:"+dataPackage.characterArt);
		label_IQ.setText("智商:"+dataPackage.characterIQ);
		label_lucky.setText("幸运值:"+dataPackage.characterlucky);
		

		/*********************************************			
		 * 【鼠标动作的设置】
		 ********************************************/
		demoMouseListener.dataPackage=dataPackage;//数据包注册，不需要改
		demoMouseListener.mainGame=mainGame;
		
//		demoMouseListener clickClose=new demoMouseListener(0);//设置鼠标监听器，发生0号事件
//		demoMouseListener clickSubmit=new demoMouseListener(1);//设置鼠标监听器，发生1号事件
//		demoMouseListener clickOut=new demoMouseListener(2);//设置鼠标监听器，发生2号事件
//		demoMouseListener clickwake=new demoMouseListener(3);//设置鼠标监听器，发生3号事件
//		demoMouseListener clickstay=new demoMouseListener(4);
		
//		clickClose.setButton(closeButton);
//		closeButton.addMouseListener(clickClose);//2号事件是 去上课按钮 被点击
//		
//		clickClose.setButton(submitButton);
//		submitButton.addMouseListener(clickSubmit);//2号事件是 去上课按钮 被点击
	
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