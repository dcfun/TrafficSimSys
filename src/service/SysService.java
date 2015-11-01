package service;

import dto.MapArray;
import dto.SysDto;
import entity.Car;
import entity.Node;
import entity.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by uu789 on 2015/10/25.
 */
public class SysService {

	private SysDto dto;
    private Random rand = new Random();
    private MapArray map;
    private int cnt = 0;

    //初始化地图接点
  	public void initMapNodes() {
    	List<Node> nodeList = this.dto.getNodeList();
    	List<Integer> birthList = this.dto.getBirthList();
        List<Integer> destList = this.dto.getDestList();

        //1
        nodeList.add(new Node(++cnt, 1, new Point(0, map.getCross1_y() - 15), 2, -1));
        //2 - 7
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() - 35, map.getCross1_y() + 15), cnt + 5, cnt + 1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() - 15, map.getCross1_y() + 35), cnt + 1, -1));
        nodeList.add(new Node(++cnt, 3, new Point(map.getCross1_x() - 15, (map.getCross1_y()*2-48)), -1, -1));
//        System.out.println(nodeList.get(3).getPoint().getX()+","+nodeList.get(3).getPoint().getY());
        nodeList.add(new Node(++cnt, 1, new Point(map.getCross1_x() + 15, map.getCross1_y() * 2), cnt + 1, -1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() + 15, map.getCross1_y() + 35), 23, cnt + 1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() + 35, map.getCross1_y() + 15), cnt + 1, -1));
        //8 - 13
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() - 35, map.getCross2_y() + 15), cnt + 5, cnt + 1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() - 15, map.getCross2_y() + 35), cnt + 1, -1));
        nodeList.add(new Node(++cnt, 3, new Point(map.getCross2_x() - 15, map.getCross2_y() * 2-48), -1, -1));
//        System.out.println(nodeList.get(9).getPoint().getX()+","+nodeList.get(9).getPoint().getY());
        nodeList.add(new Node(++cnt, 1, new Point(map.getCross2_x() + 15, map.getCross2_y() * 2), cnt + 1, -1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() + 15, map.getCross2_y() + 35), 17, cnt + 1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() + 35, map.getCross2_y() + 15), cnt + 1, -1));
        //14 、15
        nodeList.add(new Node(++cnt, 3, new Point(map.getCross1_x() * 3-15, map.getCross2_y() + 5), -1, -1));
//        System.out.println(nodeList.get(13).getPoint().getX()+","+nodeList.get(13).getPoint().getY());
        nodeList.add(new Node(++cnt, 1, new Point(map.getCross1_x() * 3, map.getCross2_y() + 15), 16, -1));
        //16 - 21
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() + 35, map.getCross2_y() - 15), cnt + 5, cnt + 1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() + 15, map.getCross2_y() - 35), cnt + 1, -1));
        nodeList.add(new Node(++cnt, 3, new Point(map.getCross2_x() + 15, 0), -1, -1));
//        System.out.println(nodeList.get(17).getPoint().getX()+","+nodeList.get(17).getPoint().getY());
        nodeList.add(new Node(++cnt, 1, new Point(map.getCross2_x() - 15, 0), cnt + 1, -1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() - 15, map.getCross2_y() - 35), 9, cnt + 1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() - 35, map.getCross2_y() - 15), cnt + 1, -1));
        //22 - 27
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() + 35, map.getCross1_y() - 15), cnt + 5, cnt + 1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() + 15, map.getCross1_y() - 35), cnt + 1, -1));
        nodeList.add(new Node(++cnt, 3, new Point(map.getCross1_x() + 15, 0), -1, -1));
//        System.out.println(nodeList.get(23).getPoint().getX()+","+nodeList.get(23).getPoint().getY());
        nodeList.add(new Node(++cnt, 1, new Point(map.getCross1_x() - 15, 0), cnt + 1, -1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() - 15, map.getCross1_y() - 35), 3, cnt + 1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() - 35, map.getCross1_y() - 15), cnt + 1, -1));
        //28
        nodeList.add(new Node(++cnt, 3, new Point(10, map.getCross1_y() -25), cnt + 1, -1));
//        System.out.println(nodeList.get(27).getPoint().getX()+","+nodeList.get(27).getPoint().getY());
        //29
        nodeList.add(new Node(++cnt, 4, new Point(-100, map.getCross1_y() - 15), 1, -1));
        //30
        nodeList.add(new Node(++cnt, 4, new Point(map.getCross1_x() + 15, map.getCross1_y() * 2 + 100), 5, -1));
        //31
        nodeList.add(new Node(++cnt, 4, new Point(map.getCross2_x() + 15, map.getCross2_y() * 2 + 100), 11, -1));
        //32
        nodeList.add(new Node(++cnt, 4, new Point(map.getCross2_x() * 3+100, map.getCross2_y() - 15), 15, -1));
        //33
        nodeList.add(new Node(++cnt, 4, new Point(map.getCross2_x() - 15, -100), 19, -1));
        //34
        nodeList.add(new Node(++cnt, 4, new Point(map.getCross1_x() - 15, -100), 25, -1));

        /*node Type :
         * 1 - 出生节点
         * 2 - 十字路口
         * 3 - 死亡节点
         * 4 - 预处理节点
         */

        for(Node node: nodeList){
            int type = node.getType();
            if (type == 1){
                birthList.add(node.getId());
            } else if (type == 3){
                destList.add(node.getId());
            }
        }

  	}

    //初始化小车列表
    public void initCarList(){
    	List<Car> carList = this.dto.getCarList();        
    	for (int i = 0; i < this.dto.getMAX_NUM() ; i++) {
            Car car = new Car(i);
            InitCar(car);      //处理小车的投胎事宜
            car.setLife(false);
            carList.add(car);
        }

    }

    
    //投胎函数
    public void InitCar(Car car) {
        List<Integer> birthList = this.dto.getBirthList();
        List<Integer> destList = this.dto.getDestList();
        List<Node> nodeList = this.dto.getNodeList();
        
        int color = rand.nextInt(destList.size());	//0~6
        int birthId = birthList.get(rand.nextInt(birthList.size()));//出生地--
        int destId = destList.get(color);//死亡地
        
        car.setCoord(nodeList.get(birthId).getPoint());
        car.setColor(color);
        car.setBirthId(birthId);
        car.setDestId(destId);
        car.setPartSrc(birthId);
    }
    
    //暂时是 能右转就右转，直到destId消失。
    private void setPartEnd(Car car) {
    	List<Node> nodeList = this.dto.getNodeList();
    	Node currentNode = nodeList.get(car.getPartSrc());	
    	
    	if((currentNode.getRightNodeId())>0){//可以右转
    		car.setPartEnd(currentNode.getRightNodeId());
    	}else {
    		car.setPartEnd(currentNode.getStraightNodeId());
    	}
	}
    
    /**
     * 1 == 上
     * 2 == 下
     * 3 == 左
     * 4 == 右
     */
    private void setDir(Car car){
    	List<Node> nodeList = this.dto.getNodeList();
    	int x1 = nodeList.get(car.getPartSrc()).getPoint().getX();
    	int y1 = nodeList.get(car.getPartSrc()).getPoint().getY();
    	int x2 = nodeList.get(car.getPartEnd()).getPoint().getX();
    	int y2 = nodeList.get(car.getPartEnd()).getPoint().getY();
    	
    	if(x1==x2 && y2>y1){
    		car.setDir(1);
    	}else if (x1==x2 && y2<y1 ){
    		car.setDir(2);
    	}else if(y1==y2 && x2>x1){
    		car.setDir(3);
    	}else if(y1==y2 && x2<x1){
    		car.setDir(4);
    	}else{
    		System.out.print("???????/无法判断方向");
    	}
    }

    //判断*碰撞*函数
    public boolean canMove(){
		
    	
    	return true;
    }
    
	//
    public void carRun(){
    	List<Car> carList = this.dto.getCarList();
    	List<Node> nodeList = this.dto.getNodeList();
    	for(Car car: carList){
    		if(car.isLife() ){	//是活的 
    			int newX = car.getCoord().getX() + car.getMoveXY().getX();
    			int newY = car.getCoord().getX() + car.getMoveXY().getX();

    			Point partEndCoord = nodeList.get(car.getPartEnd()).getPoint(); 
    			if(newX==partEndCoord.getX() && newY==partEndCoord.getY()){	//到达partEnd
System.out.println("+++++++++");
    				car.setPartSrc(car.getPartEnd());
   					car.setCoord(partEndCoord);
   					setPartEnd(car);	//根据partSrc 计算partEnd
   					setDir(car);		//根据partSrc、partEnd 计算dir
    				
   					if(car.getPartEnd() == car.getDestId()){
    					car.setLife(false);
    				}
   					
   				}else{		//**在路上**
       				if(canMove()){	//调用*判断碰撞函数* 	要么移动，要么停一下
       					car.move();
       				}
   				}
    				
    		} else{		//死的, 暂时使其立即复活
        		//将小车的 坐标、partSrc 设置在 出生节点上 “1”
        		InitCar(car);
        		car.setLife(true);
        	}
    	}
    }

	public SysDto getDto() {
		return dto;
	}

	public void setDto(SysDto dto) {
		this.dto = dto;
	}

	public MapArray getMap() {
		return map;
	}

	public void setMap(MapArray map) {
		this.map = map;
	}
	

}
