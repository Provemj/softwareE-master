package THUgame.subwindows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import THUgame.datapack.DataPack;
import THUgame.main.EventManager;
import THUgame.tool.ImagePanel;
import THUgame.windows.WinBase;

import javax.swing.SwingConstants;



public class WinEndWhiteCollar extends WinBase{
	
	static File file;
	static JLabel lblNewLabel;
	/*************************************************************	
	 *
	 *【内部的事件响应类】
	 * 		这里只写了鼠标的动作，如果之后熟悉了可以加入键盘的操作
	 * 		写成类内部的类是为了防止别的分支事件访问到它，所以可以乱命名
	 * 		所有必要实现的接口都实现了。
	 * 
	 *************************************************************/
	static private class EndWhiteCollarListener extends BaseMouseListener{
		static public DataPack dataPackage;
		static public EventManager mainGame;
		private JFrame frame;
		private JButton button;
		private int mode;
		
		public EndWhiteCollarListener(int i){
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
    		synchronized(mainGame) {
    			mainGame.notify();
    		}
    		return;
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
	public WinEndWhiteCollar(EventManager mainGame,JFrame frame)  {
		
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
		backgroundPanel.setOpaque(false);
		backgroundPanel.setBounds(0, 0, 1080, 720);
		backgroundPanel.setLayout(null);

		JPanel backgroundImage=new ImagePanel("imgsrc//WinEndNormal/Office.png",0, 0, 1080, 720);
		backgroundImage.setBounds(0, 0, 1080, 720);
		backgroundImage.setOpaque(false);
		backgroundImage.setLayout(null);
		
		JButton button= new JButton("Next");	
		button.setBorderPainted(false);
		button.setFont(new Font("印品黑体", Font.PLAIN, 19));
		button.setForeground(Color.BLACK);
		button.setBounds(570, 380, 80, 80);
		button.setContentAreaFilled(false);
		button.setHorizontalAlignment(SwingConstants.CENTER);
		setIcon("/imgsrc/WinSTA/2.png",button);
		setSelectedIcon("/imgsrc/WinSTA/2p.png",button);

		JPanel dialogPack = new JPanel();
		dialogPack.setBounds(20, 500, 689, 189);
		dialogPack.setOpaque(false);//注意要设成透明的
		dialogPack.setLayout(null);
		
			JPanel dialogPanel = new JPanel();//第1个subPanel，放控件
			dialogPanel.setBounds(0, 0, 700, 189);//(0, 0, 宽, 高);
			
			JPanel dialogBackgoundPanel = new ImagePanel("imgsrc//Dialog.png",0, 0, 689, 189);	//第2个subPanel，放图																	//(0, 0, 宽, 高);
			dialogBackgoundPanel.setBounds(0, 0, 689, 189);//(0, 0, 宽, 高);
			dialogBackgoundPanel.setOpaque(false);//注意要设成透明的
			dialogPanel.setOpaque(false);		//注意要设成透明的
			dialogPanel.setLayout(null);
			
			JLabel dialogName = new JLabel();
			dialogName.setBounds(17, 6, 89, 40);
			dialogName.setText("旁白");
			
			JLabel dialogContent = new JLabel();
			dialogName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
			dialogContent.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			dialogContent.setBounds(44, 42, 580, 141);

			JButton nextDialog = new JButton("");
			nextDialog.setBounds(600, 120, 40, 40);
			nextDialog.setBorderPainted(false);
			nextDialog.setContentAreaFilled(false);
			nextDialog.setHorizontalAlignment(SwingConstants.CENTER);
			setIcon("/imgsrc/WinSTA/ca.png",nextDialog);
			setSelectedIcon("/imgsrc/WinSTA/cb.png",nextDialog);
		
		
		
		
		
		switch(dataPackage.count) 
		{
		case 0:
			dialogContent.setText("<html>毕业后，你进入企业，成为一名普通的白领。</html>");
			break;
		case 1:
			dialogContent.setText("<html>你感觉平时做的事情都很平凡，不过因为获得的报酬足以维持较体面的生活，你并不认为这是件坏事。</html>");
			break;
		case 2:
			dialogContent.setText("<html>你大学时的专业与工作并没有多少相关，或许社交经历的打磨让你更能适应职场的环境。</html>");
			break;
		case 3:
			dialogContent.setText("<html>有时候你感觉自己很渺小，但你又明白，你这样的个体是社会保持正常运转所必需的。</html>");
			break;
		case 4:
			dialogContent.setText("<html>如果再来一次，是否一切都会不同？</html>");
			break;
		case 5:
			dialogContent.setText("<html>>>>>>游戏结束，你达成结局：【公司白领】<<<<<<</html>");
			break;
			
		}

		
		dialogPanel.add(dialogName);
		dialogPanel.add(dialogContent);
		dialogPanel.add(nextDialog);
		dialogPack.add(dialogPanel);		//注意：先放的在上层，所以先放带控件的
		dialogPack.add(dialogBackgoundPanel);
		backgroundPanel.add(dialogPack);
		backgroundPanel.add(backgroundImage);

		/*********************************************			
		 * 【鼠标动作的设置】
		 ********************************************/
		EndWhiteCollarListener.dataPackage=dataPackage;//数据包注册，不需要改
		EndWhiteCollarListener.mainGame=mainGame;
		EndWhiteCollarListener click=new EndWhiteCollarListener(0);//设置鼠标监听器，发生0号事件
		click.setButton(nextDialog);
		nextDialog.addMouseListener(click);//0号事件是 睡觉按钮 被点击

		/*		END OF YOUR CODE		*/
    	    	
    	/*****************************************************************				
		 * 【恢复显示】
		 * 必须存在的四行代码！！！！
		 ******************************************************************/
		//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥这部分不允许改¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
		frame.getContentPane().removeAll();
		frame.getContentPane().add(backgroundPanel);
		frame.getContentPane().add(backgroundImage);
		frame.getContentPane().repaint();
    	frame.setVisible(true);
    	//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥这部分不允许改¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
	}
}

    

