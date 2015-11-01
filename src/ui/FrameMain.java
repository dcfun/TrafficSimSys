package ui;

import utils.FrameUtils;

import javax.swing.*;

/**
 * Created by uu789 on 2015/10/24.
 */
public class FrameMain extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 865;
    public static final int HEIGHT = 520;

    public FrameMain(PanelMain panel){
        this.setTitle("交通仿真系统");
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);

        FrameUtils.setFrameCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setVisible(true);
    }


}
