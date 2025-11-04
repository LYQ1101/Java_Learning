import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    int[][] data=new int[4][4];
    int[][] win={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    //定义xy来记录空白方块在二维数组种的位置
    int x=0;
    int y=0;

    int step=0;

    JMenuItem restart =new JMenuItem("重新开始");
    JMenuItem relogin =new JMenuItem("重新登录");
    JMenuItem cancle=new JMenuItem("关闭游戏");
    JMenuItem lianxifangsh=new JMenuItem("联系方式");

    public GameJFrame()
    {
        initJFrame();
        initJMenuBar();
        initDate();
        initImage();

        this.setVisible(true);  //建议把这个放到最后一行
    }

    private void initJFrame() {
        this.setTitle("拼图游戏");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setSize(588,630);

        //给游戏界面添加键盘监听
        this.addKeyListener(this);
    }

    private void initJMenuBar() {
        //创建菜单相关
        JMenuBar jMenuBar=new JMenuBar();   //创建菜单对象

        JMenu functionJMenu=new JMenu("功能");    //创建菜单上的两个功能项
        JMenu about=new JMenu("关于我们");

        JMenuItem change=new JMenuItem("更换图片");

        restart.addActionListener(this);
        relogin.addActionListener(this);
        cancle.addActionListener(this);
        lianxifangsh.addActionListener(this);

        functionJMenu.add(restart);
        functionJMenu.add(relogin);
        functionJMenu.add(cancle);

        about.add(lianxifangsh);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(about);

        this.setJMenuBar(jMenuBar);
    }

    //随机化方法
    private void initDate()
    {
        int[] temArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        Random r=new Random();
        for (int i = 0; i < temArr.length; i++) {
            int index=r.nextInt(temArr.length);
            int temp=temArr[i];
            temArr[i]=temArr[index];
            temArr[index]=temp;

        }

        for (int i = 0; i < temArr.length; i++) {
            if(temArr[i]==0)
            {
                x=i/4;
                y=i%4;
            }
            data[i/4][i%4]=temArr[i];
        }
    }

    //随机初始化图片位置
    private void initImage() {
        //清空已经出现的所有图片
        this.getContentPane().removeAll();

        if(victory())
        {
            JLabel winJlabel=new JLabel(new ImageIcon("pic/win.png"));
            winJlabel.setBounds(203,283,148,133);
            this.getContentPane().add(winJlabel);
        }
        else {
            setLayout(null);          // 空布局，必须要
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int num = data[i][j];
                    // 1. 装载图标（任意尺寸）
                    ImageIcon origin = new ImageIcon("pic/" + num + ".png");
                    // 2. 缩放到 105×105
                    Image scaled = origin.getImage()
                            .getScaledInstance(105, 105, Image.SCALE_SMOOTH);
                    // 3. 把缩略图重新包成图标并放入标签
                    JLabel label = new JLabel(new ImageIcon(scaled));
                    label.setBounds(105 * j + 83, 105 * i + 104, 105, 105);
                    //给图片加边框
                    label.setBorder(new BevelBorder(0));

                    getContentPane().add(label);
                }
            }
        }

        JLabel stepCount=new JLabel("步数:"+step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

        //添加背景图片
        java.net.URL imageUrl = getClass().getClassLoader().getResource("pic/background.png");

        if (imageUrl != null) {
            JLabel background = new JLabel(new ImageIcon(imageUrl));
            background.setBounds(20, -10, 538, 630);
            this.getContentPane().add(background);
        } else {
            System.err.println("错误：无法找到背景图片 'pic/background.png'，请检查路径和文件是否存在于类路径中。");
        }

        //刷新一下界面
        this.getContentPane().repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下不松时调用的方法
    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==65)
        {
            // 步骤 1: 清空容器
            this.getContentPane().removeAll();
            ImageIcon originIcon = new ImageIcon("pic/total.png");
            Image originImage = originIcon.getImage();
            int targetWidth = 420;
            int targetHeight = 420;
            Image scaledImage = originImage.getScaledInstance(
                    targetWidth,
                    targetHeight,
                    Image.SCALE_DEFAULT // 或 Image.SCALE_FAST
            );
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel all = new JLabel(scaledIcon);
            all.setBounds(83, 134, targetWidth, targetHeight);
            this.getContentPane().add(all);

            //添加背景图片
            java.net.URL imageUrl = getClass().getClassLoader().getResource("pic/background.png");
            if (imageUrl != null) {
                JLabel background = new JLabel(new ImageIcon(imageUrl));
                background.setBounds(20, -10, 538, 630);
                this.getContentPane().add(background);
            } else {
                System.err.println("错误：无法找到背景图片 'pic/background.png'，请检查路径和文件是否存在于类路径中。");
            }

            //刷新
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();

        // 37: 左箭头 (右边的块向左移动 -> 空白块向右移动)
        if(code==37)
        {
            // 边界判断：确保右边有方块可移 (y < 3)
            if (y < 3) {
                System.out.printf("←\n");
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 0;
                y++;
                step++;
                initImage();
            }
        }

        // 38: 上箭头 (下边的块向上移动 -> 空白块向下移动)
        else if(code==38)
        {
            // 边界判断：确保下边有方块可移 (x < 3)
            if (x < 3) {
                System.out.printf("↑\n");
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
                x++;
                step++;
                initImage();
            }
        }

        // 39: 右箭头 (左边的块向右移动 -> 空白块向左移动)
        else if(code==39)
        {
            // 边界判断：确保左边有方块可移 (y > 0)
            if (y > 0) {
                System.out.printf("→\n");
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 0;
                y--;
                step++;
                initImage();
            }
        }

        // 40: 下箭头 (上边的块向下移动 -> 空白块向上移动)
        else if(code==40)
        {
            // 边界判断：确保上边有方块可移 (x > 0)
            if (x > 0) {
                System.out.printf("↓\n");
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 0;
                x--;
                step++;
                initImage();
            }
        }
        //取消显示全图
        else if(code==65)
        {
            initImage();
        }

        //一键通关
        else if(code==87)
        {
            data=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initImage();
        }
    }

    //判断胜利的代码
    public boolean victory()
    {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j]!=win[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        if(obj==restart)
        {
            System.out.printf("重新开始");
            step=0;
            initDate();
            initImage();
        }
        else if(obj==relogin)
        {
            System.out.printf("重新登录");
            JDialog jDialog=new JDialog();
            JLabel jLabel=new JLabel("这个功能还没有开发喵，请敲打作者喵~\n邮箱:1355784761@qq.com");
            jLabel.setBounds(0,0,360,400);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(360,350);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }
        else if(obj==cancle)
        {
            System.out.printf("退出游戏");
            System.exit(0);
        } else if (obj==lianxifangsh) {
            System.out.printf("联系方式");

            JDialog jDialog=new JDialog();
            JLabel jLabel=new JLabel(new ImageIcon("pic/host.jpg"));
            jLabel.setBounds(0,0,1560,800);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(1360,950);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);

        }
    }
}
