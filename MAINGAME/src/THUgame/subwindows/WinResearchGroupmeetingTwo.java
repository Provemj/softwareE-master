package THUgame.subwindows;

import THUgame.windows.WinBase;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import THUgame.datapack.DataPack;
import THUgame.main.EventManager;
import THUgame.tool.ImagePanel;
import java.awt.Font;

/* 
 * 科研第二次组会事件
 * 
 * --DIALOG--
 * 
 * update:20191108
 * via：黄天翼
 * 更新：新建此事件
 * 
 * 
 **/


/*************************************************************	
 *简介
 * 基于其它模板改写，与多次多重选择事件模板一起使用
 * 
 *************************************************************/

public class WinResearchGroupmeetingTwo extends WinBase{
	

		
		
		/*************************************************************	
		 *
		 *【内部的事件响应类】
		 * 这里只写了鼠标的动作，如果之后熟悉了可以加入键盘的操作
		 * 写成类内部的类是为了防止别的分支事件访问到它，所以可以乱命名
		 * 所有必要实现的接口都实现了。
		 * 
		 *************************************************************/
		static private class ResearchGroupmeetingTwoListener extends BaseMouseListener{
			static public DataPack dataPackage;
			static public EventManager mainGame;
			private JFrame frame;
			private JButton button;
			private int mode;
			
			public ResearchGroupmeetingTwoListener(int i){
				this.mode=i;
			}
			public void setButton(JButton button) {
				this.button=button;
			}
			public void setFrame(JFrame frame) {
				this.frame=frame;
			}
			public void setGame(EventManager mainGame) {
				this.mainGame=mainGame;
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
				if(safeGuardCount==0) {
					safeGuardCount++;
					if(mode==0) {
						dataPackage.choiceA="Next";
					}
					/*		END OF YOUR CODE		*/
				//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥要刷新事件这部分一定要加¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
					EventManager.dataPackage=dataPackage;
					synchronized(mainGame) {
						mainGame.notify();
					}
				}
				//¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥要刷新事件这部分一定要加¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥¥
				
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
	 * 【构造函数】
	 * 不要新建JFrame窗口对象，而是把上层传进来的窗口对象里面的东西扔了，重新添加
	 *************************************************************/
	public WinResearchGroupmeetingTwo(EventManager mainGame,JFrame frame) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.mainGame=mainGame;
		
		/*************************************************************	
		 * 背景镶板，所有的组件都在里面
		 * 两个按钮直接用插件拖进去的
		 * 这一部分按照流程做的话就会自然消失的，推荐直接在可视化界面编辑属性
		 * 最后放一下背景
		 *************************************************************/
		JPanel backgroundPanel=new JPanel();
		backgroundPanel.setBackground(Color.GRAY);
		backgroundPanel.setBounds(0, 0, 1080, 720);
		backgroundPanel.setLayout(null);
		backgroundPanel.setOpaque(false);
		
		JPanel backgroundImage=new ImagePanel("imgsrc//WinResearchGroupmeeting/ResearchBackground.png",0, 0, 1080, 720);	
		backgroundImage.setOpaque(false);
		backgroundImage.setBounds(0, 0, 1080, 720);
		
		JPanel dialogPanel = new JPanel();
		dialogPanel.setBounds(67,390,965,255);
		dialogPanel.setOpaque(false);
		dialogPanel.setLayout(null);
		
		
		JPanel dialogText = new JPanel();
		dialogText.setBounds(0, 0, 938, 250);
		dialogText.setOpaque(false);
		dialogText.setLayout(null);
		
		
		JPanel dialogImage = new ImagePanel("imgsrc//WinResearchGroupmeeting/DialogOfResearch.png",0, 0, 965, 255);	

		dialogImage.setBounds(0, 0, 965, 255);
		dialogImage.setOpaque(false);//注意要设成透明的
		
		JLabel textSpeaker = new JLabel();
		textSpeaker.setHorizontalAlignment(SwingConstants.CENTER);
		textSpeaker.setText("<html>人名</html>");
		textSpeaker.setOpaque(false);
		textSpeaker.setFont(new Font("印品黑体", Font.PLAIN, 19));
		textSpeaker.setBounds(0, 0, 133, 48);
		
		
		JLabel textThis = new JLabel();
		textThis.setVerticalAlignment(SwingConstants.CENTER);
		textThis.setHorizontalAlignment(SwingConstants.LEFT);
		textThis.setText("<html>这样会自动换行</html>");
		textThis.setOpaque(false);
		textThis.setFont(new Font("印品黑体", Font.PLAIN, 19));
		textThis.setBounds(10, 60, 938, 180);
		

		dialogText.add(textSpeaker);
		dialogText.add(textThis);
		dialogPanel.add(dialogText);
		dialogPanel.add(dialogImage);
		

		//A选项按钮
		JPanel panelNext = new JPanel();
		panelNext.setLayout(null);
		panelNext.setOpaque(false);
		panelNext.setBounds(900, 560, 50, 45);
		panelNext.setLayout(null);
	
		JPanel nextImage = new ImagePanel("imgsrc//WinResearchGroupmeeting/Next.png",0, 0, 50, 45);	
		nextImage.setOpaque(false);
		nextImage.setBounds(0, 0, 50, 45);
		nextImage.setOpaque(false);//注意要设成透明的
		
		JButton nextButton = new JButton();	
		nextButton.setBorderPainted(false);
		nextButton.setFont(new Font("印品黑体", Font.PLAIN, 19));
		nextButton.setForeground(Color.BLACK);
		nextButton.setBounds(0, 0, 50, 45);
		nextButton.setContentAreaFilled(false);
		nextButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel PanelTeacher = new JPanel();
		PanelTeacher.setOpaque(false);
		PanelTeacher.setBounds(100, 140, 290, 420);
		PanelTeacher.setLayout(null);
		
		JPanel teacherImage = new ImagePanel("imgsrc//WinResearchGroupmeeting/Teacher.png",0, 0, 290, 420);
		teacherImage.setBounds(0, 0, 290, 420);
		teacherImage.setOpaque(false);//注意要设成透明的T
		
		PanelTeacher.add(teacherImage);
		
		JPanel PanelStudentOther = new JPanel();
		PanelStudentOther.setOpaque(false);
		PanelStudentOther.setBounds(700, 140, 270, 355);
		PanelStudentOther.setLayout(null);
		
		JPanel studentOtherImage = new ImagePanel("imgsrc//WinResearchGroupmeeting/StudentOther.png",0, 0, 270, 355);
		studentOtherImage.setBounds(0, 0, 270, 355);
		studentOtherImage.setOpaque(false);//注意要设成透明的

		PanelStudentOther.add(studentOtherImage);
		
		JPanel PanelStudentYou = new JPanel();
		PanelStudentYou.setOpaque(false);
		PanelStudentYou.setBounds(700, 140, 270, 355);
		PanelStudentYou.setLayout(null);
		
		JPanel studentYouImage = new ImagePanel("imgsrc//WinResearchGroupmeeting/StudentYou.png",0, 0, 270, 355);
		studentYouImage.setBounds(0, 0, 270, 355);
		studentYouImage.setOpaque(false);//注意要设成透明的

		PanelStudentYou.add(studentYouImage);
		
		int speaker=-1;//0代表老师，1/2/3分别代表同学A、B、C、4代表你
		String text="";//对话内容
		
		switch(dataPackage.count) {
		case 0:
			speaker=0;
			text="<html>都到了啊，那么从你开始，一个个展示吧。</html>";
			break;
		case 1:
			speaker=1;
			text="<html>呃...这篇文章讲的是...</html>";
			break;
		case 2:
			speaker=1;
			text="<html>(同学们依次介绍了所读的文献内容，现在轮到你了)</html>";
			break;
		case 3:
			speaker=4;
			text="<html>这篇文章...呃...呃...呃...</html>";
			break;
		case 4:
			speaker=0;
			text="<html>我看你根本没把这事放在心上，你回去吧，以后不用来了。<br><br>(由于进展太差，你被老师扫地出门)</html>";
			break;
		case 5:
			speaker=4;
			text="<html>我觉得这篇文章不错，是一篇文献综述，对这个领域的前沿说得比较清楚。<br>......<br>......</html>";
			break;
		case 6:
			speaker=4;
			text="<html>这篇文章也还可以......<br>......<br>......</html>";
			break;
		case 7:
			speaker=4;
			text="<html>这篇文章则是......。<br>......<br>......</html>";
			break;
		case 8:
			speaker=4;
			switch(dataPackage.researchDataPackage.i_map) {
			case 1:
				text="<html>看了这些文献，我觉得对“物理算法”方向比较有兴趣，希望进行进一步的研究。</html>";
				break;
			case 2:
				text="<html>看了这些文献，我觉得对“热工耦合”方向比较有兴趣，希望进行进一步的研究。</html>";
				break;
			case 3:
				text="<html>看了这些文献，我觉得对“数值模拟”方向比较有兴趣，希望进行进一步的研究。</html>";
				break;
			case 4:
				text="<html>看了这些文献，我觉得对“堆型设计”方向比较有兴趣，希望进行进一步的研究。</html>";
				break;
			}
			break;
		case 9:
			speaker=0;
			text="<html>不错，不错。</html>";
			break;
		case 10:
			speaker=0;
			text="<html>大家的进展还可以，我再提一两点吧。首先，大家在讲其它人的文章内容时，要在同一张ppt上表明引文来源，方便他人以后追踪文章。</html>";
			break;
		case 11:
			speaker=0;
			text="<html>并且，可以在读文章同时使用个人文献管理软件来存储这些文章，将来方便查找和生成引文。比如学校图书馆购买的NoteExpress，去官方网站就可下载到。</html>";
			break;
		case 12:
			speaker=0;
			text="<html>在读的过程中，了解通用的方法和创新点。学习在已有答案的问题上深入思考，挖掘他人没有想到要做，或做得还不够深入的问题。我们做科研，就是要走在自己方向的最前沿，不断填补空白，拓展人类的知识范围。</html>";
			break;
		case 13:
			speaker=0;
			text="<html>那么，这周组会就到这里，下周周四下午再过来讨论，讲讲这一周的进度，希望到时候各位都已经找到了想要做的方向。</html>";
			break;
		}
		
		textThis.setText(text);
		switch(speaker) {
		case 0:
			studentYouImage.setVisible(false);
			studentOtherImage.setVisible(false);
			teacherImage.setVisible(true);
			textSpeaker.setText("<html>老师</html>");
			break;
		case 1:
			studentYouImage.setVisible(false);
			studentOtherImage.setVisible(true);
			teacherImage.setVisible(false);
			textSpeaker.setText("<html>同学A</html>");
			break;
		case 2:
			studentYouImage.setVisible(false);
			studentOtherImage.setVisible(true);
			teacherImage.setVisible(false);
			textSpeaker.setText("<html>同学B</html>");
			break;
		case 3:
			studentYouImage.setVisible(false);
			studentOtherImage.setVisible(true);
			teacherImage.setVisible(false);
			textSpeaker.setText("<html>同学C</html>");
			break;
		case 4:
			studentYouImage.setVisible(true);
			studentOtherImage.setVisible(false);
			teacherImage.setVisible(false);
			textSpeaker.setText("<html>你</html>");
			break;
		}
		
		
		panelNext.add(nextButton);
		panelNext.add(nextImage);
		backgroundPanel.add(panelNext);
		backgroundPanel.add(dialogPanel);
		backgroundPanel.add(PanelTeacher);
		backgroundPanel.add(PanelStudentOther);
		backgroundPanel.add(PanelStudentYou);
		backgroundPanel.add(backgroundImage);
		
		ResearchGroupmeetingTwoListener.dataPackage=dataPackage;
		ResearchGroupmeetingTwoListener.mainGame=mainGame;
		
		/*		START OF YOUR CODE		*/
		/*****			
		 * 重要，事件监听器一定要把mainGame传入
		 ****/
		ResearchGroupmeetingTwoListener clicknext=new ResearchGroupmeetingTwoListener(0);//设置鼠标监听器，发生0号事件
		clicknext.setButton(nextButton);
		nextButton.addMouseListener(clicknext);//0号事件是 a 被点击

		

		/*		END OF YOUR CODE		*/
    	    	
    	/*****************************************************************				
		 * 恢复显示，按照流程做就不会消失，之后四行不允许更改
		 ******************************************************************/
		
		

		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(backgroundPanel);
		frame.getContentPane().repaint();
		frame.setVisible(true);
	}
}

