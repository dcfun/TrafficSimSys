package ui;

import control.SysControl;
import dto.MapArray;
import dto.SysDto;
import entity.Car;
import entity.Node;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 * Created by uu789 on 2015/10/24.
 */
public class PanelMain extends JPanel implements MouseMotionListener, Runnable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysDto dto;
	MapArray map = new MapArray();
    private Point point = new Point(0,0);
    private static final int SIZE = 20;		//小车在panel中是个正方形的像素块，像素块的边长size = 20;
    public static Image CAR = new ImageIcon("img/car.png").getImage();

    public PanelMain() {
        this.addMouseMotionListener(this);
    }

    public PanelMain(SysDto dto, SysControl control) {
        this.dto = dto;
        this.addMouseMotionListener(this);
    }

    public void paint(Graphics g) {

        int[][] Cmap = map.init();
        int width = FrameMain.WIDTH;
        int height = FrameMain.HEIGHT;
        Color[] colors = new Color[]{
                new Color(217, 217, 217), new Color(255, 255, 255), new Color(112, 173, 71)
        };

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                g.setColor(colors[Cmap[i][j]]);
                g.fillRect(i, j, 1, 1);
            }
        }
        
        drawDestColor(g, dto);
        drawCar(g, dto);
    }
    
    public void drawDestColor(Graphics g, SysDto dto){
    	Color[] colors = new Color[]{
    		new Color(207,57,56), new Color(255, 226, 82), new Color(46, 229, 95),new Color(25, 57, 137),new Color(135, 57, 172),new Color(84, 105, 133)
        };
    	List<Node> nodeList = dto.getNodeList();
    	int i = 0;
    	
    	for(Node node: nodeList){
            int type = node.getType();
            if (type == 3){
            	g.setColor(colors[i++]);
        		g.fillRect(node.getPoint().getX()-SIZE/2, node.getPoint().getY(), SIZE, SIZE);
            }
        }

    }
    //drawCar
    public void drawCar(Graphics g, SysDto dto) {
        List<Car> carList = dto.getCarList();
        
        for(Car car : carList){
        	int dx1 = car.getCoord().getX() - SIZE/2;
        	int dy1 = car.getCoord().getY() - SIZE/2;
        	int dx2 = car.getCoord().getX() + SIZE/2;
        	int dy2 = car.getCoord().getY() + SIZE/2;
        	int sx1 = car.getDir() * SIZE;
        	int sy1 = car.getColor() * SIZE;
        	int sx2 = sx1 + SIZE;
        	int sy2 = sy1 + SIZE;
        	g.drawImage(CAR, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, null);
        
        }
    	

    }


    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        this.point.x = e.getX();
        this.point.y = e.getY();
    }

    public void run() {
        while (true){
            this.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
