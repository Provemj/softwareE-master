package THUgame.main;
import java.util.Random;

import THUgame.datapack.DataPack;
import THUgame.event.EventBase;
import THUgame.event.EventCeremony;
import THUgame.event.EventCeremonyLec;
import THUgame.event.EventChoice;
import THUgame.event.EventCourseRegistration;
import THUgame.event.EventCourseWithdraw;
import THUgame.event.EventInDom;
import THUgame.event.EventInputName;
import THUgame.event.EventLeave;
import THUgame.event.EventMorningClass;
import THUgame.event.EventNoonClass;
import THUgame.event.EventSaveAndLoad;
import THUgame.event.EventStateManager;
import THUgame.event.EventHome;
import THUgame.event.EventBackground;
import THUgame.event.EventWelcome;
import THUgame.subevents.EventSTA;
import THUgame.subevents.EventSUPE1;
import THUgame.subevents.EventSUPE21;
import THUgame.subevents.EventSUPE22;
import THUgame.subevents.EventSUPE3;
import THUgame.subevents.EventSUPE4;
import THUgame.subevents.EventSUPE5;
import THUgame.subevents.EventSUPE6;
import THUgame.subevents.EventSUPE7;
import THUgame.subevents.EventClubActivityFive;
import THUgame.subevents.EventClubActivityFour;
import THUgame.subevents.EventClubActivityOne;
import THUgame.subevents.EventClubActivitySeven;
import THUgame.subevents.EventClubActivitySix;
import THUgame.subevents.EventClubActivityThree;
import THUgame.subevents.EventClubActivityTwo;
import THUgame.subevents.EventClubRecirement;
import THUgame.subevents.EventEnd2050_1;
import THUgame.subevents.EventEndAnimate;
import THUgame.subevents.EventEndCivilServant;
import THUgame.subevents.EventEndDropOut;
import THUgame.subevents.EventEndFinanceWorker;
import THUgame.subevents.EventEndProgrammer;
import THUgame.subevents.EventEndWhiteCollar;
import THUgame.subevents.EventOrgEnroll;
import THUgame.subevents.EventOrganization;
import THUgame.subevents.EventResearch;
import THUgame.subevents.EventResearchBegin;
import THUgame.subevents.EventResearchMeetingNotice;
import THUgame.subevents.EventResearchGroupMeetingOne;
import THUgame.subevents.EventResearchGroupMeetingTwo;
import THUgame.subevents.EventResearchGroupMeetingThree;
import THUgame.subevents.EventResearchGroupMeetingFour;
import THUgame.subevents.EventResearchGroupMeetingFive;
import THUgame.subevents.EventResearchGroupMeetingSix;
import THUgame.subevents.EventResearchGroupMeetingSeven;
import THUgame.subevents.EventResearchGroupMeetingEight;
public class EventManager extends Thread{
	
    private WindowManager GUI;
    private EventBase pushForward;
	static public DataPack dataPackage;
    public void set(WindowManager GUI){this.GUI=GUI;}
    
    public void run(){
    	while(true){
    		/*********************************		
    		 *     		 * 整体逻辑为：
    		 * 	开始——事件响应——数据包更新——判断是否是新事件——绘图——事件响应……
    		 * 
    		 * 在下面进行分支事件的选择，处理数据包
    		 * 并且重新绘制界面，界面根据数据包内容绘制
    		 * list:
    		 * 	-1.开始后进入的过路事件，什么都不做->30001
    		 * 	0.inDom 在宿舍->1/2／sub
    		 * 	1.MorningClass 早上上课事件->2/0／sub
    		 *  2.NoonClass 下午上课事件->0／sub
    		 *  3.Map 选择地图上的点，用于场景切换
    		 *  4.Class Chosse class 
    		 *  
    		 *  20016. STA科协的事件。只要满足加入了科协，任意白天时间都可以去
    		 *  
    		 *  21XXX.SRT
    		 *  
    		 *  30000.通过选择确定人物模板事件->30002
    		 *  30003.基本信息输入->30001
    		 *  30001.人物基本背景说明及选择提示->30000
    		 *  30002.欢迎界面->0
    		 *  30004.存档界面
    		 *  
    		 *  40000.End 1
    		 *  
    		 * 	
    		 *********************************/
    		/*		START OF YOUR CODE		*/
    		switch(dataPackage.ID) {
    			case -1:
    				pushForward = new EventHome();
    				break;
				case 0:
					pushForward = new EventInDom();
					break;
				case 1:
					pushForward = new EventMorningClass();
					break;	
				case 2:
					pushForward = new EventNoonClass();
					break;	
				case 4:
					pushForward = new EventCourseRegistration();
					break;	
				case 5:
					pushForward = new EventCourseWithdraw();
					break;	
				case 6:
					pushForward = new EventCeremony();
					break;
				case 7:
					pushForward = new EventCeremonyLec();
					break;
				case 8:
					 pushForward = new EventLeave(); 
					 break;
				case 20001:
					pushForward = new EventOrganization();
					break;
				case 200011:
					pushForward = new EventOrgEnroll();
					break;
				case 200012:
					pushForward = new EventSUPE1();
					break;
				case 200013:	
					if (dataPackage.SUPEmentor == 1) {
						pushForward = new EventSUPE21();
					}
					else if (dataPackage.SUPEmentor == 2) {
						pushForward = new EventSUPE22();
					}
					break;
				case 200014:
					pushForward = new EventSUPE3();
					break;
				case 200015:
					pushForward = new EventSUPE4();
					break;
				case 200016:
					pushForward = new EventSUPE5();
					break;
				case 200017:
					pushForward = new EventSUPE6();
					break;
				case 200018:
					pushForward = new EventSUPE7();
					break;
				case 20016:
					pushForward = new EventSTA();
					break;
				case 21000:
					pushForward = new EventResearchBegin();
					break;
				case 21001:
					pushForward = new EventResearchMeetingNotice();
					break;
				case 21002:
					pushForward = new EventResearchGroupMeetingOne();
					break;
				case 21003:
					pushForward = new EventResearchGroupMeetingTwo();
					break;
				case 21004:
					pushForward = new EventResearchGroupMeetingThree();
					break;
				case 21005:
					pushForward = new EventResearchGroupMeetingFour();
					break;
				case 21006:
					pushForward = new EventResearchGroupMeetingFive();
					break;
				case 21007:
					pushForward = new EventResearchGroupMeetingSix();
					break;
				case 21008:
					pushForward = new EventResearchGroupMeetingSeven();
					break;
				case 21009:
					pushForward = new EventResearchGroupMeetingEight();
					break;
				case 21010:
					pushForward = new EventResearch();
					break;
				case 30000:
					pushForward = new EventChoice();
					break;
				case 30001:
					pushForward = new EventBackground();
					break;
				case 30002:
					pushForward = new EventWelcome();
					break;
				case 30003:
					pushForward = new EventInputName();
					break;
				case 30004:
					pushForward = new EventSaveAndLoad();
					break;	
				case 40000:
					pushForward = new EventEndAnimate();
					break;	
				case 40001:
					pushForward = new EventEnd2050_1();
					break;	
				case 40002:
					pushForward = new EventEndCivilServant();
					break;	
				case 40006:
					pushForward = new EventEndDropOut();
					break;	
				case 40004:
					pushForward = new EventEndFinanceWorker();
					break;	
				case 40005:
					pushForward = new EventEndProgrammer();
					break;	
				case 40003:
					pushForward = new EventEndWhiteCollar();
					break;	
				case 50000:
					pushForward = new EventClubRecirement();
					break;
				case 50001:
					pushForward = new EventClubActivityOne();
					break;
				case 50002:
					pushForward = new EventClubActivityTwo();
					break;
				case 50003:
					pushForward = new EventClubActivityThree();
					break;
				case 50004:
					pushForward = new EventClubActivityFour();
					break;
				case 50005:
					pushForward = new EventClubActivityFive();
					break;
				case 50006:
					pushForward = new EventClubActivitySix();
					break;
				case 50007:
					pushForward = new EventClubActivitySeven();
					break;
    		}
    		/*		END OF YOUR CODE		*/
    		pushForward.actOn(dataPackage);
    		pushForward = new EventStateManager();
    	    pushForward.actOn(dataPackage);
		    GUI.repaint();//每次更新完数据包，用新的数据包重新绘制窗口界面
		    synchronized(this){
		   		try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		   	}
    	}
	}
}
