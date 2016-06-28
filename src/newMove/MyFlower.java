/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newMove;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
/**
 *
 * @author Administrator
 */
public class MyFlower extends MouseAdapter implements KeyListener,ActionListener{
    private JPanel pa,panel1,panel2,panel4,panel5,panel6,panel7,panel666,panel8;
    private JPanel[] panel3;
    private JButton panel1Button1,panel1Close;
    private JButton panel2Button1,panel2Button2,panel2Button3,panel2Button4,panel2Close;
    private JButton panel3Return,panel4Return,panel5Return,panel6Return,panel7Return;
    private JFrame frame;
    private CardLayout card;
    private int level;
    private ScrollPane panel66;
    private java.awt.Font f;
    private static final long serialVersionUID=1L; 
    private Point origin;
    private ImgPanel panel22;
      
    private JLabel[] scoreLabel; 
    private JLabel[] nameLabel;
    private JLabel[] levelLabel;
    private JButton ONMUSIC,OFFMUSIC;
    private Wall[][] wall;
    private boolean drop;
    private int which,score,flag;
    AudioClip backmusic;
    Dialog basicSet;
    private JButton basicButton;
    private JTextField basicField;
    private JLabel basicLabel,personName,personLevel;
    private Timer timer1;
    static String[] name;
    private String myName;
    static int[] allscore;
    static int[] levels;
    static int[] types;
    private JProgressBar progressbar;
    private int doorPlace,playerPlace,chooseWall;
  
    private int xPos,yPos,xVPos,yVPos,tempx,tempy,xVPos1,yVPos1;
    public int direction;
    private int moveDirection;
    public boolean isStanding = true;
    private boolean canMoveUp1,canMoveDown1,canMoveLeft1,canMoveRight1;
    private boolean canMoveUp2,canMoveDown2,canMoveLeft2,canMoveRight2;
    
    
        Thread animatorThread;
        int delay = 10;

    public static void main(String[] args){
        MyFlower aLi = new MyFlower();
        aLi.go();
    }
    
    public void go(){
        frame = new JFrame();
        f = new java.awt.Font("SansSerif",java.awt.Font.BOLD+java.awt.Font.ITALIC,28);
         panel1= new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                ImageIcon icon =
                        new ImageIcon("F:\\pp\\newback.jpg");
                g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
            }
        };
        panel1.setOpaque(false);
        panel1.setLayout(null);
        panel1.setBounds(0,0,1000,700);
        panel1Button1 = new JButton("进入");
        panel1Button1.setFont(f);
        panel1Button1.setBackground(Color.YELLOW);
         panel1Close = new JButton(new ImageIcon("F:\\pp\\endd.png"));
         panel1Close.setRolloverIcon(new ImageIcon("F:\\pp\\end.png"));
        panel1Close.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              System.exit(0);
            }
        });
        panel1Close.setBounds(900,0,70,70);
        panel1Close.setContentAreaFilled(false);
        panel1Close.setBorder(null);
        panel1Button1.setBounds(450, 500, 100, 50); 
        panel1Button1.addMouseListener(this);
        panel1.add(panel1Button1);
        panel1.add(panel1Close);
        
        //菜单界面
         panel2= new JPanel() {
             @Override
            public void paintComponent(Graphics g) {
                ImageIcon icon =
                        new ImageIcon("F:\\pp\\back.jpg");
                g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
            }
        };
        panel2.setOpaque(false);
        panel2.setLayout(null);
        panel2.setBounds(0, 0, 1000, 700);
        panel2Button1 = new JButton( "新游戏");
        panel2Button1.setFont(f);
        panel2Button1.setBackground(Color.PINK);
        panel2Button2 = new JButton("新玩家");
        panel2Button2.setFont(f);
        panel2Button2.setBackground(Color.PINK);
        panel2Button3 = new JButton("游戏介绍");
        panel2Button3.setFont(f);
        panel2Button3.setBackground(Color.PINK);
       panel2Button4= new JButton("游戏记录");
       panel2Button4.setFont(f);
       panel2Button4.setBackground(Color.PINK);
         panel2Close = new JButton(new ImageIcon("F:\\pp\\endd.png"));
         panel2Close.setRolloverIcon(new ImageIcon("F:\\pp\\end.png"));
        panel2Close.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              ImgPane ip=new ImgPane(Toolkit.getDefaultToolkit().createImage("F:\\pp\\Bubbles.png"));
              ip.setBounds(850, 450, 128, 128);
              ip.setOpaque(false);
            panel8.add(ip);
              card.show(pa,"card9");
              ip.outStart();
            }
        });
        panel2Close.setBounds(900,20,70,70);
        panel2Close.setContentAreaFilled(false);
        panel2Close.setBorder(null);
        panel2Button1.setBounds(300, 250, 200, 50);
        panel2Button2.setBounds(600, 250, 200, 50);
        panel2Button3.setBounds(300, 400, 200, 50);
        panel2Button4.setBounds(600, 400 , 200, 50);
        panel2Button1.addMouseListener(this);
        panel2Button2.addMouseListener(this);
        panel2Button3.addMouseListener(this);
        panel2Button4.addMouseListener(this);
        panel2.add(panel2Button1);
        panel2.add(panel2Button2);
        panel2.add(panel2Button3);
        panel2.add(panel2Button4);
        panel2.add(panel2Close);
 panel22 = new ImgPanel(Toolkit.getDefaultToolkit().createImage("F:\\pp\\Bubbles.png"));
 panel22.setBounds(850, 550, 128, 128);
   panel22.setOpaque(false);
      
        //游戏界面
        panel3 = new JPanel[2];
        panel3[0]= new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                ImageIcon icon =
                        new ImageIcon("F:\\pp\\bisai.jpg");
                g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
            }
        };
        panel3[0].setOpaque(false);
        panel3[0].setLayout(null);
        panel3[0].setBounds(0, 0, 1000, 700);
        panel3[1]= new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                ImageIcon icon =
                        new ImageIcon("F:\\pp\\bisai.jpg");
                g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
            }
        };
        panel3[1].setOpaque(false);
        panel3[1].setLayout(null);
        panel3[1].setBounds(0, 0, 1000, 700);
        panel3Return = new JButton(new ImageIcon("F:\\pp\\LEFT.png"));
        panel3Return.setRolloverIcon(new ImageIcon("F:\\pp\\LEFTT.png"));
        panel3Return.addMouseListener(this);
        panel3Return.setContentAreaFilled(false);
        panel3Return.setBorder(null);
        panel3Return.setBounds(900,0,75,75);
        initMusic();
        ONMUSIC = new JButton(new ImageIcon("F:\\pp\\ON.png"));
         ONMUSIC.setRolloverIcon(new ImageIcon("F:\\pp\\ON1.png"));
        ONMUSIC.addMouseListener(this);
        OFFMUSIC = new JButton(new ImageIcon("F:\\pp\\OFF.png"));
         OFFMUSIC.setRolloverIcon(new ImageIcon("F:\\pp\\OFF1.png"));
        OFFMUSIC.addMouseListener(this);
        OFFMUSIC.addMouseListener(this);
        ONMUSIC.setContentAreaFilled(false);
        ONMUSIC.setBorder(null);
        ONMUSIC.setBounds(950,300,50,50);
        OFFMUSIC.setContentAreaFilled(false);
        OFFMUSIC.setBorder(null);
        OFFMUSIC.setBounds(950,400,50,50);
        
        //休息一下
        panel4= new JPanel() {
             @Override
            public void paintComponent(Graphics g) {
                ImageIcon icon =
                        new ImageIcon("F:\\pp\\sleep.jpg");
                g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
            }
        };
         panel4.setLayout(null);
        panel4Return = new JButton(new ImageIcon("F:\\pp\\LEFT.png"));//能否用键盘实现
         panel4Return.setRolloverIcon(new ImageIcon("F:\\pp\\LEFTT.png"));
        panel4Return.setContentAreaFilled(false);
        panel4Return.setBorder(null);
        panel4Return.setBounds(900, 0, 75, 75);
        panel4Return.addMouseListener(this);
        panel4.add(panel4Return);
        
        //游戏规则
        panel5= new JPanel() {
             @Override
            public void paintComponent(Graphics g) {
                ImageIcon icon =
                        new ImageIcon("F:\\pp\\intro.jpg");
                g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
            }
        };
         panel5.setLayout(null);
         panel5Return = new JButton(new ImageIcon("F:\\pp\\LEFT.png"));
          panel5Return.setRolloverIcon(new ImageIcon("F:\\pp\\LEFTT.png"));
         panel5Return.setBorder(null);
         panel5Return.setContentAreaFilled(false);
         panel5Return.setBounds(900, 0, 75, 75);
         panel5Return.addMouseListener(this);
         panel5.add(panel5Return);
         
         //游戏记录
         panel66 = new ScrollPane();
         panel666= new JPanel() {
             @Override
            public void paintComponent(Graphics g) {
                ImageIcon icon =
                        new ImageIcon("F:\\pp\\back.jpg");
                g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
            }
        };
         panel666.setLayout(null);
        panel6= new JPanel() ;
         panel6.setLayout(new GridLayout(60,3,30,30));
         panel6Return = new JButton(new ImageIcon("F:\\pp\\LEFT.png"));
          panel6Return.setRolloverIcon(new ImageIcon("F:\\pp\\LEFTT.png"));
         panel6Return.setBorder(null);
         panel6Return.setContentAreaFilled(false);
         panel6Return.setBounds(900, 0, 75, 75);
         panel6Return.addMouseListener(this);
         panel6.setBackground(Color.getHSBColor(255, 213, 170));
         panel66.setBounds(200, 0, 600, 700);
         panel66.add(panel6);
         panel666.add(panel66);
         panel666.add(panel6Return);
         
         myName = new String("匿名玩家");
         level =0;
        basicButton = new JButton("确定");
        basicLabel = new JLabel("请输入玩家姓名：");
        basicField = new JTextField();
        basicSet = new Dialog(frame, "基本设置");
        
       
        basicButton.addActionListener(new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) { 
                 myName=basicField.getText();
                 System.out.println("xingming :" + myName);
                 if(myName==null || myName.length()<=0){
                     myName="匿名玩家";
                 }else{
                     JOptionPane.showMessageDialog(basicSet, "创建成功","创建成功", JOptionPane.INFORMATION_MESSAGE);
                 }
                basicSet.setVisible(false);           
            }       
        }); 
       
        basicSet.setSize(300, 200);  
        basicSet.setLocation(500,300); 
        basicSet.setUndecorated(true);
        basicSet.add(basicButton, "South");        
        basicSet.add(basicField,"Center"); 
        basicSet.add(basicLabel,"North");     
        basicSet.setModal(false);        
        basicSet.setVisible(false); 
        
         //个人成绩
  
         panel7= new JPanel() {
             @Override
            public void paintComponent(Graphics g) {
                ImageIcon icon =
                        new ImageIcon("F:\\pp\\back.jpg");
                g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
            }
        };
          panel7.setLayout(null);
          panel7Return = new JButton(new ImageIcon("F:\\pp\\LEFT.png"));
           panel7Return.setRolloverIcon(new ImageIcon("F:\\pp\\LEFTT.png"));
         panel7Return.setBorder(null);
         panel7Return.setContentAreaFilled(false);
         panel7Return.setBounds(900, 0, 75, 75);
         panel7Return.addMouseListener(this);
         personName = new JLabel();
         personLevel = new JLabel();
         personName.setBounds(400, 180, 200, 150);
         personLevel.setBounds(400, 220, 200, 150);
         
       panel8= new JPanel() {
             @Override
            public void paintComponent(Graphics g) {
                ImageIcon icon =
                        new ImageIcon("F:\\pp\\back111.jpg");
                g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
            }
        };
           panel8.setLayout(null);
         
         //面板添加
         pa = new JPanel();
        pa.setBounds(0, 0, 1000, 700);
        card = new CardLayout();
        pa.setLayout(card);
         pa.add(panel1,"card1");
        pa.add(panel2,"card2");
        pa.add(panel3[0],"card3");
        pa.add(panel3[1],"card4");
        pa.add(panel4,"card5");
        pa.add(panel5,"card6");
        pa.add(panel666,"card7");
        pa.add(panel7,"card8");
      pa.add(panel8,"card9");
       
        frame.addMouseListener(         new MouseAdapter(){  
            @Override
           public void mousePressed(MouseEvent e){  
             origin.x = e.getX();  
             origin.y = e.getY();  
           } 
            @Override
           public void mouseClicked(MouseEvent e){
               if(e.getButton()==MouseEvent.BUTTON3){  
                   if(timer1!=null){
                       timer1.stop();
                       card.show(pa,"card5");
                   }
                    frame.setExtendedState(JFrame.ICONIFIED);     
               }
                }
            @Override
        public void mouseEntered(MouseEvent e){
            frame.setCursor(Cursor.HAND_CURSOR);
        }}
               );

        origin = new Point(); 
     frame.addMouseMotionListener(  
         new MouseAdapter(){  
             @Override
           public void mouseDragged(MouseEvent e){  
             Point p =frame.getLocation();  
             frame.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y ); 
           }      
           
             @Override
             public void mouseMoved(MouseEvent e){
                 panel22.setLocation(e.getX(),e.getY());
             }  }
     );    
     frame.add(panel22);
        frame.add(pa);
        frame.setUndecorated(true);
        frame.setLocation(100,30);
        frame.setSize(1000,700);
        frame.setVisible(true);
    }
       

    
    
    public void initMusic(){
        try { 
            URL cb1;
            File f1 = new File("F:\\pp\\backmusic1.au"); 
             cb1 = f1.toURL();
             backmusic = Applet.newAudioClip(cb1); 
        } catch (MalformedURLException e) {}
    }
    
    public void FIRST(){
        wall = walls();
        which = 1;
        pa.addKeyListener(this);
        pa.requestFocus();
        initWall(wall);
        initPlayerAndDoor(wall,chooseWall);
        initXY();
        drawPlayer();
        initStep();
        initScore();
        drawDoor(wall);
        draw();
    }
    
    public void initWall(Wall[][] wall){
         double a;
            a = Math.random()*10;
            chooseWall = new Double(a).intValue();
            chooseWall %= wall.length;
    }
    
    //初始化player的性质
    public void initPlayerAndDoor(Wall[][] wall,int chooseWall){
        double a,b;
        do{
            a = Math.random()*wall[chooseWall].length;
       playerPlace = new Double(a).intValue();
       playerPlace %= wall[chooseWall].length;
       b = Math.random()*wall[chooseWall].length;
       doorPlace = new Double(b).intValue();
       doorPlace %= wall[chooseWall].length;
        }while(playerPlace == doorPlace );
        direction = 0;
        isStanding = true;
    }
    
    public void initXY(){
    xPos = wall[chooseWall][playerPlace].getxPos();
    yPos = wall[chooseWall][playerPlace].getyPos();
}
    
    public void initStep(){
            
         }
   
public void initScore(){
        score+=50;
  }

    
    public void drawPlayer(){
          if(isStanding){
                for(int j = 0;j<wall[chooseWall].length;j++){
                    {
                         if(xPos ==wall[chooseWall][j].getxPos()  && yPos== wall[chooseWall][j].getyPos()){
                                 wall[chooseWall][j].getWall().setIcon(new ImageIcon("F:\\pp\\standing.png"));
                                 break;
                         }
                    }
                }
            }
            if(!isStanding){
                if(direction == 0) {
                     for(int j = 0;j<wall[chooseWall].length;j++){
                        {
                            if(xPos==wall[chooseWall][j].getxPos()  && yPos== wall[chooseWall][j].getyPos()){
                                wall[chooseWall][j].getWall().setIcon(new ImageIcon("F:\\pp\\up1.png"));
                                wall[chooseWall][j].getWall().setSize(50, 50);
                            }
                            if(xPos==wall[chooseWall][j].getxPos()  && yPos+50== wall[chooseWall][j].getyPos()){
                                wall[chooseWall][j].getWall().setIcon(new ImageIcon("F:\\pp\\up2.png"));
                                wall[chooseWall][j].getWall().setSize(50, 50);
                            }
                    }
                 }
                }
                if(direction == 1) {
                     for(int j = 0;j<wall[chooseWall].length;j++){
                     if(xPos==wall[chooseWall][j].getxPos()  && yPos== wall[chooseWall][j].getyPos()){
                         wall[chooseWall][j].getWall().setSize(50, 50);
                             wall[chooseWall][j].getWall().setIcon(new ImageIcon("F:\\pp\\down2.png"));
                     }
                     if(xPos==wall[chooseWall][j].getxPos()  && yPos-50== wall[chooseWall][j].getyPos()){
                         wall[chooseWall][j].getWall().setSize(50, 50);
                             wall[chooseWall][j].getWall().setIcon(new ImageIcon("F:\\pp\\down1.png"));
                     }
                 }
                }
                if(direction == 2) {    
                     for(int j = 0;j<wall[chooseWall].length;j++){
                     if(xPos==wall[chooseWall][j].getxPos()  && yPos== wall[chooseWall][j].getyPos()){
                         wall[chooseWall][j].getWall().setSize(50, 50);
                             wall[chooseWall][j].getWall().setIcon(new ImageIcon("F:\\pp\\left1.png"));
                     }
                     if(xPos+50==wall[chooseWall][j].getxPos()  && yPos== wall[chooseWall][j].getyPos()){
                         wall[chooseWall][j].getWall().setSize(50, 50);
                             wall[chooseWall][j].getWall().setIcon(new ImageIcon("F:\\pp\\left2.png"));
                     }
                     }
                }
                if(direction == 3) {
                     for(int j = 0;j<wall[chooseWall].length;j++){
                         if(xPos==wall[chooseWall][j].getxPos()  && yPos== wall[chooseWall][j].getyPos()){
                             wall[chooseWall][j].getWall().setSize(50, 50);
                             wall[chooseWall][j].getWall().setIcon(new ImageIcon("F:\\pp\\right2.png"));
                        }
                         if(xPos-50==wall[chooseWall][j].getxPos()  && yPos== wall[chooseWall][j].getyPos()){
                             wall[chooseWall][j].getWall().setSize(50, 50);
                             wall[chooseWall][j].getWall().setIcon(new ImageIcon("F:\\pp\\right1.png"));
                         }
                     }
                 }
            } 
    }
    
    public void drawDoor(Wall[][] wall){
        wall[chooseWall][doorPlace].getWall().setIcon(new ImageIcon("F:\\pp\\door.png"));
    }
    
  
    public void draw(){
        wall = walls();
        drawDoor(wall);
        drawPlayer();
                for(int j = 0;j<wall[chooseWall].length;j++){
                    wall[chooseWall][j].getWall().setSize(49, 49);
                    panel3[which-1].add(wall[chooseWall][j].getWall());
              }
                 JButton[] showScore = new JButton[5];
                 int[] a = new int[5];
                 a[0] = score%10;    //4是高位
                 a[1] = score/10%10;
                 a[2] = (score/100)%10;
                 a[3] = score/1000%10;
                 a[4] = score/10000;
                 for(int i =0;i<=4;i++){
                     if(a[i] ==0 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\0.png"));}
                     if(a[i] ==1 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\1.png")); }
                     if(a[i] ==2 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\2.png")); }
                     if(a[i] ==3 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\3.png")); }
                     if(a[i] ==4 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\4.png")); }
                     if(a[i] ==5 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\5.png")); }
                     if(a[i] ==6 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\6.png")); }
                     if(a[i] ==7 ){  showScore[i] = new JButton(new ImageIcon("F:\\pp\\7.png"));}
                     if(a[i] ==8 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\8.png")); }
                     if(a[i] ==9 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\9.png")); }
                 }
                 for(int i =0;i<=4;i++){
                     showScore[i].setContentAreaFilled(false);
                     showScore[i].setBorder(null);
                 }
               showScore[4].setBounds(0, 630,50,70);
               showScore[3].setBounds(60, 630,50,70);
               showScore[2].setBounds(120, 630,50,70);
               showScore[1].setBounds(180, 630,50,70);
               showScore[0].setBounds(240, 630,50,70);
                 panel3[which-1].add(showScore[0]);
                 panel3[which-1].add(showScore[1]);
                 panel3[which-1].add(showScore[2]);
                 panel3[which-1].add(showScore[3]);
                 panel3[which-1].add(showScore[4]);
                  panel3[which-1].add(ONMUSIC);
                 panel3[which-1].add(OFFMUSIC);
                 //进度条
               progressbar.setBounds(400, 0,300,20);
                 panel3[which-1].add(progressbar);
                 panel3[which-1].add(panel3Return);
                if(which ==1 ){ 
                 which = 2;
                 card.show(pa, "card4");
             }
             if(which == 2){
                 which =1;
                 card.show(pa, "card3");
             }
        
    }
    
    
    //移动修改player的位置
     public void move(Wall[][] wall){
         canMoveUp1 = false;canMoveUp1 = false;
         canMoveLeft1 = false;
         canMoveLeft1 = false;
         canMoveDown1 = false;
         canMoveDown1 = false;
         canMoveRight1 = false;
         canMoveRight1 = false;
         wall = walls();
         score -= 1; 
        
            drop = true;
            if(isStanding){
                if(moveDirection==0){
                        xVPos = xPos;
                        yVPos = yPos - 100;
                        yVPos1 = yPos -50;
                        for(int j=0;j<wall[chooseWall].length;j++){
                            if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                 canMoveUp1 = true;break;
                             }
                        }
                           for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos1 == wall[chooseWall][j].getyPos()) {
                                 canMoveUp2 = true;break;
                             }
                        }
                        
                        if( canMoveUp1 && canMoveUp2){
                                xPos = xVPos;
                                 yPos = yVPos;
                                 direction = 0;
                                 drop = false;
                                isStanding = false;
                                         }
                                     
                        }
                 if(moveDirection==1){
                        xVPos = xPos;
                        yVPos = yPos + 100;
                        yVPos1 = yPos +50;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                 canMoveDown1 = true;break;
                             }
                        }
                           for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos1 == wall[chooseWall][j].getyPos()) {
                                 canMoveDown2 = true;break;
                             }
                        }
                        
                        if( canMoveDown1 && canMoveDown2){
                                xPos = xVPos;
                                 yPos = yVPos;
                                 direction = 1;
                                 drop = false;
                                isStanding = false;
                                         }
                        }
                 if(moveDirection==2){
                        xVPos = xPos - 100;
                        xVPos1 = xPos - 50;
                        yVPos = yPos;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                 canMoveLeft1 = true;break;
                             }
                        }
                           for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos1 == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                 canMoveLeft2 = true;break;
                             }
                        }
                        
                        if( canMoveLeft1 && canMoveLeft2){
                                xPos = xVPos;
                                 yPos = yVPos;
                                 direction = 2;
                                 drop = false;
                                isStanding = false;
                                         }
                        }
                 if(moveDirection==3){
                        xVPos = xPos+100;
                        xVPos1 = xPos+50;
                        yVPos = yPos ;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                 canMoveRight1 = true;break;
                             }
                        }
                           for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos1 == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                 canMoveRight2 = true;break;
                             }
                        }
                        
                        if( canMoveRight1 && canMoveRight2){
                                xPos = xVPos;
                                 yPos = yVPos;
                                 direction = 3;
                                 drop = false;
                                isStanding = false;
                                         }
                        }
            }else{
            	if(direction==0&&moveDirection==0){
                     xVPos = xPos;
                      yVPos = yPos - 50;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                xPos = xVPos;
                                 yPos = yVPos;
                                direction = 0;
                                drop = false;
                                isStanding = true;
                                break;
                      }
                    }
                }
                if(direction==0&&moveDirection==1){
                      xVPos = xPos;
                        yVPos = yPos + 100;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                               xPos = xVPos;
                                 yPos = yVPos;
                               direction = 0;
                               drop = false;
                                isStanding = true;
                                break;
                      }
                    }
                }
                if(direction==0&&moveDirection==2){
                      xVPos = xPos-50;
                      tempx = xVPos;
                        yVPos = yPos;
                        tempy = yPos +50;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                canMoveLeft1 = true;
                                break;
                      }
                        }
                             for(int l=0;l<wall[chooseWall].length;l++){
                             if(tempx == wall[chooseWall][l].getxPos() && tempy == wall[chooseWall][l].getyPos()) {
                                canMoveLeft2 = true;
                                break;
                      }
                    }
                             if(canMoveLeft1 && canMoveLeft2){
                                  xPos = xVPos;
                                yPos = yVPos;
                                 direction = 0;
                                 drop = false;
                                isStanding = false;
                             }
                }
                if(direction==0&&moveDirection==3){
                      xVPos = xPos+50;
                      tempx = xVPos;
                        yVPos = yPos;
                        tempy = yPos+50;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                canMoveRight1 = true;
                                break;
                      }
                    }
                         for(int l=0;l<wall[chooseWall].length;l++){
                             if(tempx == wall[chooseWall][l].getxPos() && tempy == wall[chooseWall][l].getyPos()) {
                                canMoveRight2 = true;
                                break;
                      }
                    }
                          if(canMoveRight1 && canMoveRight2){
                                 xPos = xVPos;
                                yPos = yVPos;
                                direction = 0;
                                drop = false;
                                isStanding = false;
                             }
                    }
                
                if(direction==1&&moveDirection==0){
                     xVPos = xPos;
                        yVPos = yPos - 100;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                xPos = xVPos;
                                yPos = yVPos;
                                direction = 0;
                                drop = false;
                                isStanding = true;
                                break;
                      }
                    }
                }
                if(direction==1&&moveDirection==1){
                     xVPos = xPos;
                        yVPos = yPos +50;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                xPos = xVPos;
                                yPos = yVPos;
                                direction = 0;
                                drop = false;
                                isStanding = true;
                                break;
                      }
                    }
                }
                if(direction==1&&moveDirection==2){
                      xVPos = xPos-50;
                      tempx = xVPos;
                        yVPos = yPos;
                        tempy = yPos -50;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                canMoveLeft1 = true;
                                break;
                      }
                        }
                             for(int l=0;l<wall[chooseWall].length;l++){
                             if(tempx == wall[chooseWall][l].getxPos() && tempy == wall[chooseWall][l].getyPos()) {
                                canMoveLeft2 = true;
                                break;
                      }
                    }
                             if(canMoveLeft1 && canMoveLeft2){
                                 xPos = xVPos;
                                 yPos = yVPos;
                                direction = 1;
                                drop = false;
                                 isStanding = false;
                             }
                }
                if(direction==1&&moveDirection==3){
                       xVPos = xPos+50;
                      tempx = xVPos;
                        yVPos = yPos;
                        tempy = yPos -50;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                canMoveRight1 = true;
                                break;
                      }
                        }
                             for(int l=0;l<wall[chooseWall].length;l++){
                             if(tempx == wall[chooseWall][l].getxPos() && tempy == wall[chooseWall][l].getyPos()) {
                                canMoveRight2 = true;
                                break;
                      }
                    }
                             if(canMoveRight1 && canMoveRight2){
                                xPos = xVPos;
                                 yPos = yVPos;
                                     direction = 1;
                                     drop = false;
                                 isStanding = false;
                             }
                    }
                
                if(direction==2&&moveDirection==0){
                     xVPos = xPos;
                      tempx = xVPos +50;
                        yVPos = yPos - 50;
                        tempy = yVPos ;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                canMoveUp1 = true;
                                break;
                      }
                        }
                             for(int l=0;l<wall[chooseWall].length;l++){
                             if(tempx == wall[chooseWall][l].getxPos() && tempy == wall[chooseWall][l].getyPos()) {
                                canMoveUp2 = true;
                                break;
                      }
                    }
                             if(canMoveUp1 && canMoveUp2){
                                 xPos = xVPos;
                                yPos = yVPos;
                                direction = 2;
                                drop = false;
                                isStanding = false;
                             }
                }
                if(direction==2&&moveDirection==1){
                    xVPos = xPos;
                      tempx = xVPos +50;
                        yVPos = yPos +50;
                        tempy = yVPos ;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                canMoveDown1 = true;
                                break;
                      }
                        }
                             for(int l=0;l<wall[chooseWall].length;l++){
                             if(tempx == wall[chooseWall][l].getxPos() && tempy == wall[chooseWall][l].getyPos()) {
                                canMoveDown2 = true;
                                break;
                      }
                    }
                             if(canMoveDown1 && canMoveDown2){
                                  xPos = xVPos;
                                 yPos = yVPos;
                                direction = 2;
                                drop = false;
                                 isStanding = false;
                             }
                }
                if(direction==2&&moveDirection==2){
                     xVPos = xPos - 50;
                        yVPos = yPos ;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                 xPos = xVPos;
                                 yPos = yVPos;
                                 direction = 0;
                                 drop = false;
                                 isStanding = true;
                                break;
                      }
                    }
                }
                if(direction==2&&moveDirection==3){
                     xVPos = xPos +100;
                        yVPos = yPos;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                 xPos = xVPos;
                                 yPos = yVPos;
                                direction = 0;
                                drop = false;
                                isStanding = true;
                                break;
                      }
                    }
                }
                
                if(direction==3&&moveDirection==0){
                   xVPos = xPos;
                      tempx = xVPos -50;
                        yVPos = yPos - 50;
                        tempy = yVPos ;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                canMoveUp1 = true;
                                break;
                      }
                        }
                             for(int l=0;l<wall[chooseWall].length;l++){
                             if(tempx == wall[chooseWall][l].getxPos() && tempy == wall[chooseWall][l].getyPos()) {
                                canMoveUp2 = true;
                                break;
                      }
                    }
                             if(canMoveUp1 && canMoveUp2){
                                xPos = xVPos;
                                yPos = yVPos;
                                direction = 3;
                                drop = false;
                                isStanding = false;
                             }
                }
                if((direction==3)&&moveDirection==1){
                  xVPos = xPos;
                      tempx = xVPos -50;
                        yVPos = yPos +50;
                        tempy = yVPos ;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                canMoveDown1 = true;
                                break;
                      }
                        }
                             for(int l=0;l<wall[chooseWall].length;l++){
                             if(tempx == wall[chooseWall][l].getxPos() && tempy == wall[chooseWall][l].getyPos()) {
                                canMoveDown2 = true;
                                break;
                      }
                    }
                             if(canMoveDown1 && canMoveDown2){
                                xPos = xVPos;
                                yPos = yVPos;
                                direction = 3;
                                drop = false;
                                isStanding = false;
                             }
                }
                if(direction==3&&moveDirection==2){
                    xVPos = xPos -100;
                        yVPos = yPos;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                xPos = xVPos;
                                 yPos = yVPos;
                                 direction = 0;
                                 drop = false;
                                 isStanding = true;
                                break;
                      }
                        }
                }
                if(direction==3&&moveDirection==3){
                     xVPos = xPos +50;
                        yVPos = yPos;
                        for(int j=0;j<wall[chooseWall].length;j++){
                             if(xVPos == wall[chooseWall][j].getxPos() && yVPos == wall[chooseWall][j].getyPos()) {
                                xPos = xVPos;
                                 yPos = yVPos;
                                direction = 0;
                                drop = false;
                                isStanding = true;
                                break;
                      }
                    }
                 }
            
            }
        }
     
     //获取玩家想要移动的方向
     public void ChangeDirection(int a){
          if(a == 0 ){moveDirection = 0;}
          if(a == 1 ){moveDirection = 1;}
          if(a == 2 ){moveDirection = 2;}
          if(a == 3 ){moveDirection = 3;}
     }

     //设置每一关的墙壁位置
         private static Wall[][] walls(){
             Wall[][] w =new Wall[6][];
             w[0]= new Wall[35];
             w[0][0] = new Wall(275,175);
             w[0][1] = new Wall(325,175);
             w[0][2] = new Wall(375,175);
             w[0][3] = new Wall(275,225);
             w[0][4] = new Wall(325,225);
             w[0][5] = new Wall(375,225);
             w[0][6] = new Wall(425,225);
             w[0][7]  = new Wall(475,225);
             w[0][8] = new Wall(525,225);
             w[0][9] = new Wall(275,275);
             w[0][10] = new Wall(325,275);
             w[0][11] = new Wall(375,275);
             w[0][12] = new Wall(425,275);
             w[0][13] = new Wall(475,275);
             w[0][14] = new Wall(525,275);
             w[0][15] = new Wall(575,275);
             w[0][16] = new Wall(625,275);
             w[0][17] = new Wall(675,275);
             w[0][18] = new Wall(325,325);
             w[0][19] = new Wall(375,325);
             w[0][20] = new Wall(425,325);
             w[0][21] = new Wall(475,325);
             w[0][22] = new Wall(525,325);
             w[0][23] = new Wall(575,325);
             w[0][24] = new Wall(625,325);
             w[0][25] = new Wall(675,325);
             w[0][26] = new Wall(725,325);
             w[0][27] = new Wall(525,375);
             w[0][28] = new Wall(575,375);
             w[0][29] = new Wall(625,375);
             w[0][30] = new Wall(675,375);
             w[0][31] = new Wall(725,375);
             w[0][32] = new Wall(575,425);
             w[0][33] = new Wall(625,425);
             w[0][34] = new Wall(675,425);
             
             w[1]= new Wall[24];
             int i;
             for(i=0;i<=2;i++){
                 w[1][i] = new Wall(275+50*i,275);
             }
             for(i=3;i<=5;i++){
                 w[1][i] = new Wall(575+50*(i-3),275);
             }
             for(i=6;i<=14;i++){
                 w[1][i] = new Wall(275+50*(i-6),325);
             }
             for(i=15;i<=17;i++){
                 w[1][i] = new Wall(275+50*(i-15),375);
             }
             for(i=18;i<=20;i++){
                 w[1][i] = new Wall(575+50*(i-18),375);
             }
             w[1][21] = new Wall(725,275);
             w[1][22] = new Wall(725,325);
             w[1][23] = new Wall(725,375);
             
              w[2] = new Wall[30];
             for(i=0;i<=6;i++){
                 w[2][i] = new Wall(325+50*i,175);
             }
             for(i=7;i<=10;i++){
                 w[2][i] = new Wall(275+50*(i-7),225);
             }
             w[2][11] = new Wall(625,225);
             for(i=12;i<=15;i++){
                 w[2][i] = new Wall(275+50*(i-12),275);
             }
             w[2][16] = new Wall(625,275);
             w[2][17] = new Wall(625,325);
             w[2][18] = new Wall(725,325);
             for(i=19;i<=22;i++){
                 w[2][i] = new Wall(625+50*(i-19),375);
             }
             for(i=23;i<=26;i++){
                 w[2][i] = new Wall(625+50*(i-23),425);
             }
             for(i=27;i<=29;i++){
                 w[2][i] = new Wall(675+50*(i-27),475);
             }

            
             
             w[3] = new Wall[46];
             for(i=0;i<=6;i++){
                 w[3][i] = new Wall(425+50*i,175);
             }
             for(i=7;i<=10;i++){
                 w[3][i] = new Wall(125+50*(i-7),225);
             }
             for(i=11;i<=13;i++){
                 w[3][i] = new Wall(425+50*(i-11),225);
             }
             for(i=14;i<=15;i++){
                 w[3][i] = new Wall(675+50*(i-14),225);
             }
             for(i=16;i<=24;i++){
                 w[3][i] = new Wall(125+50*(i-16),275);
             }
             for(i=25;i<=26;i++){
                 w[3][i] = new Wall(675+50*(i-25),275);
             }
             for(i=27;i<=30;i++){
                 w[3][i] = new Wall(125+50*(i-27),325);
             }
             for(i=31;i<=34;i++){
                 w[3][i] = new Wall(675+50*(i-31),325);
             }
             for(i=35;i<=38;i++){
                 w[3][i] = new Wall(125+50*(i-35),375);
             }
             for(i=39;i<=42;i++){
                 w[3][i] = new Wall(675+50*(i-39),375);
             }
             for(i=43;i<=45;i++){
                 w[3][i] = new Wall(725+50*(i-43),425);
             }
              
              w[4] = new Wall[58];
             for(i=0;i<=5;i++){
                 w[4][i] = new Wall(375+50*i,100);
             }
             w[4][6] = new Wall(375,150);
              for(i=7;i<=11;i++){
                 w[4][i] = new Wall(525+50*(i-7),150);
             }
              w[4][12] = new Wall(375,200);
              for(i=13;i<=17;i++){
                 w[4][i] = new Wall(525+50*(i-13),200);
             }
              for(i=18;i<=23;i++){
                 w[4][i] = new Wall(125+50*(i-18),250);
             }
              for(i=24;i<=27;i++){
                 w[4][i] = new Wall(675+50*(i-24),250);
             }
              for(i=28;i<=30;i++){
                 w[4][i] = new Wall(325+50*(i-28),300);
             }
              for(i=31;i<=33;i++){
                 w[4][i] = new Wall(725+50*(i-31),300);
             }
              for(i=34;i<=36;i++){
                 w[4][i] = new Wall(325+50*(i-34),350);
             }
              for(i=37;i<=39;i++){
                 w[4][i] = new Wall(725+50*(i-37),350);
             }
              w[4][40] = new Wall(425,400);
              w[4][41] = new Wall(575,400);
              w[4][42] = new Wall(625,400);
              for(i=43;i<=47;i++){
                 w[4][i] = new Wall(425+50*(i-43),450);
             }
              for(i=48;i<=52;i++){
                 w[4][i] = new Wall(425+50*(i-48),500);
             }
              for(i=53;i<=55;i++){
                 w[4][i] = new Wall(475+50*(i-53),550);
             }
              w[4][56] = new Wall(775,400);
              w[4][57] = new Wall(725,400);
              
              w[5] = new Wall[51];
              for(i=0;i<=3;i++){
                 w[5][i] = new Wall(275+50*(i-0),75);
             }
              for(i=4;i<=7;i++){
                 w[5][i] = new Wall(275+50*(i-4),125);
             }
              for(i=8;i<=10;i++){
                 w[5][i] = new Wall(275+50*(i-8),175);
             }
              w[5][11] = new Wall(275,225);
              w[5][12] = new Wall(275,275);
              for(i=13;i<=18;i++){
                 w[5][i] = new Wall(475+50*(i-13),275);
             }
              w[5][19] = new Wall(275,325);
              for(i=20;i<=21;i++){
                 w[5][i] = new Wall(475+50*(i-20),325);
             }
              for(i=22;i<=23;i++){
                 w[5][i] = new Wall(675+50*(i-22),325);
             }
              for(i=24;i<=30;i++){
                 w[5][i] = new Wall(225+50*(i-24),375);
             }
              for(i=31;i<=33;i++){
                 w[5][i] = new Wall(675+50*(i-31),375);
              }
              w[5][34] = new Wall(475,425);
              w[5][35] = new Wall(775,425);
              for(i=36;i<=39;i++){
                 w[5][i] = new Wall(475+50*(i-36),475);
             }
              w[5][40] = new Wall(775,475);
              for(i=41;i<=47;i++){
                 w[5][i] = new Wall(475+50*(i-41),525);
             }
              for(i=48;i<=50;i++){
                 w[5][i] = new Wall(625+50*(i-50),575);
             }
             return w;
         }
         
       public void compare(){
           if(flag == 0){
           for(int i=name.length-1;i>=1;i--){
               if(score<allscore[name.length-1]){
                   break;
               }
               if(score>=allscore[i] && score<allscore[i-1]){
                   for(int j=name.length-2;j<=i;j--){
                           name[j+1] = name[j];
                           types[j+1] = types[j];
                           levels[j+1] = levels[j];
                           allscore[j+1] = allscore[j];
                       }
                       name[i] = myName;
                       levels[i] = level;
                       allscore[i] = score;
                       break;
                   }
               if(i==1){
                   for(int j=name.length-2;j<=0;j--){
                           name[j+1] = name[j];
                           types[j+1] = types[j];
                           levels[j+1] = levels[j];
                           allscore[j+1] = allscore[j];
                       }
                       name[0] = myName;
                       levels[0] = level;
                       allscore[0] = score;
                       break;
               }
               }
           }
    
           nameLabel = new JLabel[name.length];
           scoreLabel = new JLabel[name.length];
           levelLabel = new JLabel[name.length];
   
           for(int a =0;a<name.length;a++){
               nameLabel[a] = new JLabel();
               scoreLabel[a] = new JLabel();
               levelLabel[a] = new JLabel();
               nameLabel[a].setText(name[a]);
               scoreLabel[a].setText(""+allscore[a]);
               levelLabel[a].setText(""+levels[a]);
               panel6.add(nameLabel[a]);
               panel6.add(levelLabel[a]);
               panel6.add(scoreLabel[a]);
           }
    }
    
    public void Progress() {
		progressbar = new JProgressBar();
		progressbar.setOrientation(JProgressBar.HORIZONTAL);
		progressbar.setMinimum(0);
		progressbar.setMaximum(100);
		progressbar.setValue(100);
		progressbar.setStringPainted(true);
		progressbar.setPreferredSize(new Dimension(28 , 20));
		progressbar.setBorderPainted(true);
		progressbar.setBackground(Color.green);
		timer1 = new Timer(1600, this);
		timer1.start();
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer1) { // 进度条的时间
			int value = progressbar.getValue();
			if (value > 0) {
				progressbar.setValue(--value);
			} else {
				timer1.stop();
                           pa.removeKeyListener(this);
				card.show(pa,"card8");
                                readExcel(new File("F:\\pp\\moving.xls"));
                                  compare();
                                  writeExcel("F:\\pp\\moving.xls");
                                
			}
		}
    }
    @Override
     public void mousePressed(MouseEvent e){
        Object eo =e.getSource();
        if( eo == panel1Button1){
            frame.requestFocus();
            card.show(pa, "card2");
        }
        if(eo == panel2Button1){
            panel3[0].removeAll();
            panel3[1].removeAll();
            level = 1;
            Progress();
            score=0;
            FIRST();
        }
        if(eo == panel2Button2){
            basicSet.setVisible(true);//创建新玩家
        }
        if(eo == panel2Button3){  //游戏规则
            card.show(pa, "card6");
        }
        if(eo == panel2Button4){  //游戏记录
            panel22.setVisible(false);
            panel6.removeAll();
            readExcel(new File("F:\\pp\\moving.xls"));
            compare();
            writeExcel("F:\\pp\\moving.xls");
            card.show(pa, "card7");
        }
        if(eo == ONMUSIC){
            backmusic.loop();
            pa.requestFocus();
        }
        if(eo == OFFMUSIC){
            backmusic.stop();
            pa.requestFocus();
        }
        if(eo == panel3Return){  //游戏规则
            card.show(pa, "card2");
        }
       if( eo == panel4Return){
          pa.addKeyListener(this);
          pa.requestFocus();
            timer1.restart();
            if(which ==1 ){ 
                 card.show(pa, "card3");
             }
             if(which == 2){
                 card.show(pa, "card4");
             }
        }
       if(eo == panel5Return){ 
            card.show(pa, "card2");
        }
       if(eo == panel6Return){ 
           panel22.setVisible(true);
            card.show(pa, "card2");
        }
       if(eo == panel7Return){ 
            card.show(pa, "card2");
        }
        
    }
    
    
     public void addPanel7(){
         panel7.removeAll();
         panel7.add(panel7Return);
         if(level==1){score=0;}
         else{
             if(score>=49){
         score-=49;
             }else{
                 score=0;
             }
         }
         JButton[] showScore = new JButton[5];
                 int[] a = new int[5];
                 a[0] = score%10;    //4是高位
                 a[1] = score/10%10;
                 a[2] = (score/100)%10;
                 a[3] = score/1000%10;
                 a[4] = score/10000;
                 for(int i =0;i<=4;i++){
                     if(a[i] ==0 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\0.png")); }
                     if(a[i] ==1 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\1.png")); }
                     if(a[i] ==2 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\2.png")); }
                     if(a[i] ==3 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\3.png")); }
                     if(a[i] ==4 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\4.png")); }
                     if(a[i] ==5 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\5.png")); }
                     if(a[i] ==6 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\6.png")); }
                     if(a[i] ==7 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\7.png"));}
                     if(a[i] ==8 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\8.png")); }
                     if(a[i] ==9 ){ showScore[i] = new JButton(new ImageIcon("F:\\pp\\9.png")); }
                 }
                 for(int i =0;i<=4;i++){
                     showScore[i].setContentAreaFilled(false);
                     showScore[i].setBorder(null);
                 }
               showScore[4].setBounds(350, 350,50,70);
               showScore[3].setBounds(410, 350,50,70);
               showScore[2].setBounds(470, 350,50,70);
               showScore[1].setBounds(530, 350,50,70);
               showScore[0].setBounds(590, 350,50,70);
               panel7.add(showScore[4]);
               panel7.add(showScore[3]);
               panel7.add(showScore[2]);
               panel7.add(showScore[1]);
               panel7.add(showScore[0]);
               personName.setText(myName);
                personName.setFont(f);
                level-=1;
                personLevel.setText("关卡数："+level+"");
                personLevel.setFont(f);
                panel7.add(personName);
                panel7.add(personLevel);
     }
    
    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
     public void keyPressed(KeyEvent e){
        int code=e.getKeyCode(); 
         if( code == KeyEvent.VK_UP){
            ChangeDirection(0);
            move(wall);
            if(drop == true){
                flag =0;
                backmusic.stop();
                addPanel7();
                panel6.removeAll();
             pa.removeKeyListener(this);
                    card.show(pa,"card8");
                    readExcel(new File("F:\\pp\\moving.xls"));
            compare();
            writeExcel("F:\\pp\\moving.xls");
            flag =1;
            }else{
                if(isStanding &&xPos== wall[chooseWall][doorPlace].getxPos() && yPos==wall[chooseWall][doorPlace].getyPos()){               
                 pa.removeKeyListener(this);
                  ++level;
                  panel3[0].removeAll();
                         panel3[1].removeAll();
                 FIRST();
                  }else{
                         panel3[0].removeAll();
                         panel3[1].removeAll();
                        draw();
                 }
                }
            }
        if( code == KeyEvent.VK_DOWN){
            ChangeDirection(1);
            move(wall);
             if(drop == true){
                 flag =0;
                 backmusic.stop();
                addPanel7();
             pa.removeKeyListener(this);
                    card.show(pa,"card8");
                    panel6.removeAll();
                    readExcel(new File("F:\\pp\\moving.xls"));
            compare();
            writeExcel("F:\\pp\\moving.xls");
            flag =1;
            }else{
                 if(isStanding &&xPos== wall[chooseWall][doorPlace].getxPos() && yPos==wall[chooseWall][doorPlace].getyPos()){
                  pa.removeKeyListener(this);
                 ++level;
                 panel3[0].removeAll();
                         panel3[1].removeAll();
                 FIRST();
                  }else{
                         panel3[0].removeAll();
                         panel3[1].removeAll();
                        draw();
                 }
                 }
   
        }
        if( code == KeyEvent.VK_LEFT){
            ChangeDirection(2);
            move(wall);
             if(drop == true){
                 flag =0;
                  backmusic.stop();
                addPanel7();
             pa.removeKeyListener(this);
                    card.show(pa,"card8");
                    panel6.removeAll();
                    readExcel(new File("F:\\pp\\moving.xls"));
            compare();
            writeExcel("F:\\pp\\moving.xls");
            flag =1;
            }else{
                 if(isStanding &&xPos== wall[chooseWall][doorPlace].getxPos() && yPos==wall[chooseWall][doorPlace].getyPos()){
                  pa.removeKeyListener(this);
                  ++level;
                  panel3[0].removeAll();
                         panel3[1].removeAll();
                 FIRST();
                  }else{
                         panel3[0].removeAll();
                         panel3[1].removeAll();
                        draw();
                 }
                 }
        }
        if( code == KeyEvent.VK_RIGHT){
            ChangeDirection(3);
            move(wall);
             if(drop == true){
                 flag =0;
                  backmusic.stop();
                addPanel7();
             pa.removeKeyListener(this);
                    card.show(pa,"card8");
                    panel6.removeAll();
                    readExcel(new File("F:\\pp\\moving.xls"));
            compare();
            writeExcel("F:\\pp\\moving.xls");
            flag =1;
            }else{
                 if(isStanding &&xPos== wall[chooseWall][doorPlace].getxPos() && yPos==wall[chooseWall][doorPlace].getyPos()){
                 pa.removeKeyListener(this);
                  ++level;
                  panel3[0].removeAll();
                         panel3[1].removeAll();
                 FIRST();
                  }else{
                         panel3[0].removeAll();
                         panel3[1].removeAll();
                        draw();
                 }
            }   
        }
        if(code == KeyEvent.VK_SPACE){
            timer1.stop();
           pa.removeKeyListener(this);
            card.show(pa,"card5");
     }
    }

    @Override
    public void keyReleased(KeyEvent e) {  }
    
//向excel中写入数据
  public static void writeExcel(String fileName){
       WritableWorkbook wwb = null;
       try{
           wwb = Workbook.createWorkbook(new File(fileName));
       }catch(IOException e){
       }
       if(wwb != null){
           WritableSheet ws = wwb.createSheet("sheet1", 0);
           for(int i = 0;i<name.length;i++){
                   jxl.write.Label labelC = new jxl.write.Label(0,i,name[i]);
                   jxl.write.Number labelNB1 = new jxl.write.Number(1,i,levels[i]);
                   jxl.write.Number labelNB2 = new jxl.write.Number(2,i,allscore[i]);
                   try{
                       ws.addCell(labelC);
                       ws.addCell(labelNB1);
                       ws.addCell(labelNB2);
                   }catch(RowsExceededException e){
                   }catch(WriteException e){
                   }
           }
           try{
               wwb.write();
               wwb.close();
           }catch(     IOException | WriteException e){
           }
       }
   }
   //从excel中读取数据
   public static void readExcel(File file){
       Workbook wb = null;
       try{
           wb = Workbook.getWorkbook(file);
       }catch(  BiffException | IOException e){
       }
       if(wb == null){
           return ;
       }
       Sheet sheet = wb.getSheet(0);
       if(sheet !=null ){
               int rowNum = sheet.getRows();
               name = new String[rowNum];
               allscore = new int[rowNum];
               types = new int[rowNum];
               levels = new int[rowNum];
               for(int j=0;j<rowNum;j++){
                   Cell[] cells = sheet.getRow(j);
                   name[j] = cells[0].getContents();
                   if(cells[1].getType() == CellType.NUMBER){
                       NumberCell num = (NumberCell)cells[1];
                       levels[j] = (int)num.getValue();
                   }
                   if(cells[2].getType() == CellType.NUMBER){
                       NumberCell num = (NumberCell)cells[2];
                       allscore[j] = (int)num.getValue();
                   }
               }
           }
       wb.close();
   }
   
  class ImgPane extends JPanel implements Runnable{
      java.awt.Image img;
      Point q;
      Thread t;
    public ImgPane(java.awt.Image img){	
       this.img = img;
    
	 }		
@Override
   public void paint(Graphics g) {	
      super.paint(g);
      g.drawImage(img, 0,0,128,128, this);
      //其中第二到第五个参数分别为x,y,width,height	
   }

public void outStart(){
     t=new Thread(this);
       t.start();
}

        @Override
        public void run() {
             Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
             q=this.getLocation();
               int i=q.x;
               int j=q.y;
            while(true){   
                this.setLocation(i-=5, j);
                if(i<25){ 
                    t.interrupt();
                System.exit(0);
                }
                try{
                    Thread.sleep(30);
                }catch(InterruptedException e){
                }
            }
        }
    }

}


   

   

