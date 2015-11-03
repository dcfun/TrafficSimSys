package service;

import dto.MapArray;
import dto.SysDto;
import entity.Car;
import entity.Node;
import entity.Point;

import java.util.List;
import java.util.Random;

import utils.ServiceUtils;

/**
 * Created by uu789 on 2015/10/25.
 */
public class SysService {

	private SysDto dto;
    private Random rand = new Random();
    private MapArray map;
    private int cnt = -1;	//nodeList 计数器
    private ServiceUtils serviceUtils;
    
    //初始化地图节点
  	public void initMapNodes() {
    	List<Node> nodeList = this.dto.getNodeList();
    	List<Integer> birthList = this.dto.getBirthList();
        List<Integer> destList = this.dto.getDestList();

        //0
        nodeList.add(new Node(++cnt, 1, new Point(10, map.getCross1_y() + 15), 1, -1));
        //1 - 6
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() - 35, map.getCross1_y() + 15), 6, 2));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() - 15, map.getCross1_y() + 35), 3, -1));
        nodeList.add(new Node(++cnt, 3, new Point(map.getCross1_x() - 15, (map.getCross1_y()*2-38)), -1, -1));
        nodeList.add(new Node(++cnt, 1, new Point(map.getCross1_x() + 15, (map.getCross1_y()*2-38)), 5, -1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() + 15, map.getCross1_y() + 35), 22, 6));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() + 35, map.getCross1_y() + 15), 7, -1));
        //7 - 12
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() - 35, map.getCross2_y() + 15), 12, 8));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() - 15, map.getCross2_y() + 35), 9, -1));
        nodeList.add(new Node(++cnt, 3, new Point(map.getCross2_x() - 15, map.getCross2_y()*2-38), -1, -1));
        nodeList.add(new Node(++cnt, 1, new Point(map.getCross2_x() + 15, map.getCross2_y()*2-38), 11, -1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() + 15, map.getCross2_y() + 35), 16, 12));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() + 35, map.getCross2_y() + 15), 13, -1));
        //13 、14
        nodeList.add(new Node(++cnt, 3, new Point(map.getCross1_x() * 3-15, map.getCross2_y() + 15), -1, -1));
        nodeList.add(new Node(++cnt, 1, new Point(map.getCross1_x() * 3-15, map.getCross2_y() -15), 15, -1));
        //15 - 20
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() + 35, map.getCross2_y() - 15), 20, 16));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() + 15, map.getCross2_y() - 35), 17, -1));
        nodeList.add(new Node(++cnt, 3, new Point(map.getCross2_x() + 15, 10), -1, -1));
        nodeList.add(new Node(++cnt, 1, new Point(map.getCross2_x() - 15, 10), 19, -1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() - 15, map.getCross2_y() - 35), 8, 20));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross2_x() - 35, map.getCross2_y() - 15), 21, -1));
        //21 - 26
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() + 35, map.getCross1_y() - 15), 26, 22));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() + 15, map.getCross1_y() - 35), 23, -1));
        nodeList.add(new Node(++cnt, 3, new Point(map.getCross1_x() + 15, 10), -1, -1));
        nodeList.add(new Node(++cnt, 1, new Point(map.getCross1_x() - 15, 10), 25, -1));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() - 15, map.getCross1_y() - 35), 2, 26));
        nodeList.add(new Node(++cnt, 2, new Point(map.getCross1_x() - 35, map.getCross1_y() - 15), 27, -1));
        //27
        nodeList.add(new Node(++cnt, 3, new Point(10, map.getCross1_y() -15), -1, -1));
//        System.out.println(nodeList.get(27).getPoint().getX()+","+nodeList.get(27).getPoint().getY());
        //29
        nodeList.add(new Node(++cnt, 4, new Point(-100, map.getCross1_y() + 15), 0, -1));
        //30
        nodeList.add(new Node(++cnt, 4, new Point(map.getCross1_x() + 15, map.getCross1_y() * 2 + 100), 4, -1));
        //31
        nodeList.add(new Node(++cnt, 4, new Point(map.getCross2_x() + 15, map.getCross2_y() * 2 + 100), 10, -1));
        //32
        nodeList.add(new Node(++cnt, 4, new Point(map.getCross1_x() * 3+100, map.getCross2_y() - 15), 14, -1));
        //33
        nodeList.add(new Node(++cnt, 4, new Point(map.getCross2_x() - 15, -100), 18, -1));
        //34
        nodeList.add(new Node(++cnt, 4, new Point(map.getCross1_x() - 15, -100), 24, -1));

        /*node Type :
         * 1 - 出生节点
         * 2 - 十字路口
         * 3 - 死亡节点
         * 4 - 预处理节点
         */

        for(Node node: nodeList){
            int type = node.getType();
            if (type == 4){
                birthList.add(node.getId());
            } else if (type == 3){
                destList.add(node.getId());
            }
        }
        
        //TODO
//        for(Integer node : destList){
//        	System.out.print(node+"  ");        
//        }
        getNextEnd();	//就是填写一个 Next_partEnd_matrix[][]
  	}

    //自制算法 求 【多源最短路径】
    /**
     * wrote after 测试完毕小车可以 一直右转 绕地图走一圈之后。
     */
  	public void getNextEnd(){
  		int nodeSize = cnt+1;
  		int[][] next_partEnd_matrix = new int[nodeSize][nodeSize];
  		List<Node> nodeList = dto.getNodeList();
		
  		//初始化   存储【下一个partEnd】的数组1
//  		for(int i=0; i<nodeSize; i++){
//  			for(int j=0; j<nodeSize; j++){
//  				next_partEnd_matrix[i][j] = j;
//  			}
//  		}
  		
  		//初始化   存储【下一个partEnd】的数组2
  		for(int i=0; i<nodeSize; i++){
  			int straightId = nodeList.get(i).getStraightNodeId();
  			int rightId = nodeList.get(i).getRightNodeId();
		
  			if(rightId>0){		//有右转节点
  				
  				for(int j=0;j<nodeSize; j++){
  					next_partEnd_matrix[i][j] = nodeList.get(i).getRightNodeId();
  				}
  			}
  			if(straightId>0){	//nodeList的第i个Node 有直走节点
  				for(int j=0;j<nodeSize; j++){
  					next_partEnd_matrix[i][j] = nodeList.get(i).getStraightNodeId();
  				}
  			}  
		
  			if(straightId==-1 && rightId ==-1){
  				if(i==27){
  					for(int j=0;j<nodeSize; j++){
  						next_partEnd_matrix[i][j] = 0;
  					}
  				}
  				for(int j=0;j<nodeSize; j++){
  					next_partEnd_matrix[i][j] = i+1;
  				}
  			}
		
		
  		}
	
//	for(int i=0;i<nodeSize; i++){
//		for(int j=0;j<nodeSize; j++){
//			System.out.print(next_partEnd_matrix[i][j]+"  ");
//		}
//		System.out.println();
//	}
	
  		dto.setNext_partEnd_matrix(next_partEnd_matrix);
  	}
  	
  	
    /*public void getNextEnd(){
//    	int MaxNum = 5000;
    	int nodeSize = cnt+1;
//    	int[][] Weight_Sum_matrix = new int[nodeSize][nodeSize];
    	int[][] next_partEnd_matrix = new int[nodeSize][nodeSize];
    	List<Node> nodeList = dto.getNodeList();
    	
    	//初始化 【节点权值和】数组 和   存储【下一个partEnd】的数组1
    	for(int i=0; i<nodeSize; i++){
    		for(int j=0; j<nodeSize; j++){
//    			if(i==j){
//    				Weight_Sum_matrix[i][j] = 0;	
//    			}else {
//    				Weight_Sum_matrix[i][j] = MaxNum;
//    			}
    			next_partEnd_matrix[i][j] = j;
    		}
    	}
    	
    	//初始化 【节点权值和】数组 和   存储【下一个partEnd】的数组2
    	for(int i=0; i<nodeSize; i++){
    		int straightId = nodeList.get(i).getStraightNodeId();
    		int rightId = nodeList.get(i).getRightNodeId();
    		
//    		System.out.println("第"+i+"个节点的"+" straightId="+straightId+" rightId="+rightId);
//    		System.out.println("p1.x="+nodeList.get(i).getPoint().getX()+" p1.y="+nodeList.get(i).getPoint().getY());
//    		System.out.println("p1.x="+nodeList.get(straightId-1).getPoint().getX()+" p1.y="+nodeList.get(straightId-1).getPoint().getY());
//    		System.out.println(serviceUtils
//    					.getWeight(nodeList.get(i).getPoint(), nodeList.get(straightId-1).getPoint()));
    		
    		if(rightId>0){		//有右转节点
//    			System.out.println(i+"---------------"+rightId);
//    			Weight_Sum_matrix[i][rightId] = serviceUtils
//    					.getWeight(nodeList.get(i).getPoint(), nodeList.get(rightId).getPoint());
    			for(int j=0;j<nodeSize; j++){
        			next_partEnd_matrix[i][j] = nodeList.get(i).getRightNodeId();
        		}
    		}
    		if(straightId>0){	//nodeList的第i个Node 有直走节点
//    			System.out.println(i+"---------------"+straightId);
//    			Weight_Sum_matrix[i][straightId] = serviceUtils
//    					.getWeight(nodeList.get(i).getPoint(), nodeList.get(straightId).getPoint());
    			for(int j=0;j<nodeSize; j++){
        			next_partEnd_matrix[i][j] = nodeList.get(i).getStraightNodeId();
        		}
    		}    		
    		
    		if(straightId==-1 && rightId ==-1){
    			if(i==27){
    				for(int j=0;j<nodeSize; j++){
            			next_partEnd_matrix[i][j] = 0;
            		}
    			}
    			for(int j=0;j<nodeSize; j++){
        			next_partEnd_matrix[i][j] = i+1;
        		}
    		}
    		
    		
    	}
    	
    	//弗洛伊德算法
//    	for(int i=0; i<nodeSize; i++){
//    		for(int j=0; j<nodeSize; j++){
//    			for(int k=0; k<nodeSize; k++){
//    				if(Weight_Sum_matrix[j][k] > (Weight_Sum_matrix[j][i] + Weight_Sum_matrix[i][k])){
//    					Weight_Sum_matrix[j][k] = Weight_Sum_matrix[j][i] + Weight_Sum_matrix[i][k];
//    					next_partEnd_matrix[j][k] = next_partEnd_matrix[j][i];
//    				}
//    			}
//    		}
//    	}
//    	for(int i=0;i<nodeSize; i++){
//    		for(int j=0;j<nodeSize; j++){
//    			System.out.print(Weight_Sum_matrix[i][j]+"  ");
//    		}
//    		System.out.println();
//    	}
    	
    	for(int i=0;i<nodeSize; i++){
    		for(int j=0;j<nodeSize; j++){
    			System.out.print(next_partEnd_matrix[i][j]+"  ");
    		}
    		System.out.println();
    	}
    	
    	dto.setNext_partEnd_matrix(next_partEnd_matrix);
    }*/
    
    /*//暂时是 能右转就右转，直到destId消失。
    private int calcPartEnd(Car car) {
    	List<Node> nodeList = this.dto.getNodeList();
    	Node currentNode = nodeList.get(car.getPartSrc());
    	car.setCoord(new Point(nodeList.get(car.getPartSrc()).getPoint().getX(), nodeList.get(car.getPartSrc()).getPoint().getY()));
//TODO
    	System.out.print("【calcPartEnd】: partSrc = "+car.getPartSrc());
    	System.out.println("【calcPartEnd】: 此时 car.x = "+car.getCoord().getX()+", car.y = "+car.getCoord().getY());
    	if((currentNode.getRightNodeId())>0){//可以右转
    		return currentNode.getRightNodeId();
    	}else if(currentNode.getStraightNodeId()>0){
    		return currentNode.getStraightNodeId();
    	}else {
    		//TODO
    		System.out.println("partEndId = "+car.getPartEnd());
    		return car.getPartSrc()+1;
    	}
	}*/
  	
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
        int birthIndex = rand.nextInt(birthList.size());	//0~6
        int birthId = birthList.get(birthIndex);//出生地--
        int destId = destList.get(color);//死亡地
        
        //TODO
//        System.out.println("birthId = "+birthId);
        
        car.setCoord(new Point(nodeList.get(birthId).getPoint().getX(), nodeList.get(birthId).getPoint().getY()));
        car.setColor(color);
        car.setBirthId(birthId);
        car.setDestId(destId);
        car.setPartSrc(birthId);
        car.setPartEnd(nodeList.get(birthId).getStraightNodeId());
//        car.setCoord(new Point(nodeList.get(car.getPartSrc()-1).getPoint().getX(), nodeList.get(car.getPartSrc()-1).getPoint().getY()));
//        System.out.println(car.getCoord().getX()+","+car.getCoord().getY());
        setDir(car);
        //TODO
//        System.out.println("birthId="+car.getBirthId()+"  destId="+car.getDestId());
//        System.out.println("partSrc:"+car.getPartSrc());
//        System.out.println("partEnd:"+car.getPartEnd());
    }
    
    private int calcPartEnd(Car car) {
    	int nodeSize = cnt+1;
    	int[][] next_partEnd_matrix = new int[nodeSize][nodeSize];
    	List<Node> nodeList = dto.getNodeList();
    	int currentId = car.getPartSrc();
    	
		int straightId = nodeList.get(currentId).getStraightNodeId();
		int rightId = nodeList.get(currentId).getRightNodeId();
		int flag = (car.getDestId()-currentId) % 6;
		
		//如果终点不是对面位置 右转！
		if(rightId>0 && flag>0){		//有右转节点
			return car.getPartSrc()+1;
		}
		if(currentId==25 && car.getDestId()!=3){
			return car.getPartSrc()+1;
		}
		if(currentId==19 && car.getDestId()!=9){
			return car.getPartSrc()+1;
		}
		if(currentId==5 && car.getDestId()!=23 && car.getDestId()!=27){
			return car.getPartSrc()+1;
		}
		////////////////////////////////////////////////////////////////////
		if(currentId==19 || currentId==25){
			if(car.getDestId()==3){
				return nodeList.get(currentId).getStraightNodeId();
			}
			if(car.getDestId()==9){
				return nodeList.get(currentId).getStraightNodeId();
			}
		}
		if(currentId==1 && car.getDestId()!=3){
			return nodeList.get(currentId).getStraightNodeId();
		}
    	
    	return this.dto.getNext_partEnd_matrix()[car.getPartSrc()][car.getDestId()]; 
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
    	int length = 1;	//每次走的长度
    	//TODO
//    	System.out.println("partSrcId = "+car.getPartSrc()+". x1="+x1+", y1="+y1);
//    	System.out.println("partEndId = "+car.getPartEnd()+". x2="+x2+", y2="+y2);
    	
    	//	x1==x2 && 
    	//	y1==y2 && 
    	
    	if(y2<y1 && x1>x2){
    		//TODO
//    		System.out.println("上");
    		car.setMoveXY(new Point(0,length*(-1)));
    		car.setCoord(new Point(x2,y1));
    		car.setDir(0);
    	}else if(y2<y1 && x1==x2){
    		//TODO
//    		System.out.println("上");
    		car.setMoveXY(new Point(0,length*(-1)));
    		car.setDir(0);
    	}else if (y2>y1 && x2>x1){
//    		System.out.println("下");
    		car.setMoveXY(new Point(0,length));
    		car.setCoord(new Point(x2,y1));
    		car.setDir(2);
    	}else if (y2>y1 && x2==x1){
//    		System.out.println("下");
    		car.setMoveXY(new Point(0,length));
    		car.setDir(2);
    	}else if(x2<x1 && y2>y1){
//    		System.out.println("左");
    		car.setMoveXY(new Point(length*(-1),0));
    		car.setCoord(new Point(x1,y2));
    		car.setDir(3);
    	}else if(x2<x1 && y2==y1){
//    		System.out.println("左");
    		car.setMoveXY(new Point(length*(-1),0));
    		car.setDir(3);
    	}else if(x2>x1 && y2<y1){
//    		System.out.println("右");
    		car.setMoveXY(new Point(length,0));
    		car.setCoord(new Point(x1,y2));
    		car.setDir(1);
    	}else if(x2>x1 && y2==y1){
//    		System.out.println("右");
    		car.setMoveXY(new Point(length,0));
    		car.setDir(1);
    	}else{
    		//TODO
//    		System.out.println("x1="+x1+", x2="+y1);
//        	System.out.println("x2="+y1+", x2="+y2);
    		System.out.println("?????????????????????????????????????????????????????/无法判断方向");
    	}
    }

    //判断*碰撞*函数
    public boolean canMove(Car car){
    	List<Car> carList = this.dto.getCarList();
    	int x1 = car.getCoord().getX();
    	int y1 = car.getCoord().getY();
    	
    	for(Car otherCar: carList){
   			int x2 = otherCar.getCoord().getX();
      		int y2 = otherCar.getCoord().getY();

      		if(x2==x1+20 && y2==y1){
      			return false;
      		}
      		if(x2==x1-20 && y2==y1){
      			return false;
      		}
        	if(x2==x1 && y2==y1+20){
        		return false;
        	}
        	if(x2==x1 && y2==y1-20){
        		return false;
        	}
    	}
    	
    	return true;
    }
    
	//
    public void carRun(){
    	List<Car> carList = this.dto.getCarList();
    	List<Node> nodeList = this.dto.getNodeList();
    	for(Car car: carList){
    		//TODO
//    		System.out.println(car.isLife());
//    		System.out.println("------------当前坐标："+car.getCoord().getX()+","+car.getCoord().getY());
    		if(car.isLife() ){	//是活的
    			int newX = car.getCoord().getX() + car.getMoveXY().getX();
    			int newY = car.getCoord().getY() + car.getMoveXY().getY();
    			//TODO
//				System.out.println("++++是活的+++++");
//				System.out.println(car.getCoord().getX()+","+car.getCoord().getY());
//				System.out.println("newX="+car.getCoord().getX()+", newY="+car.getCoord().getY());
    			Point partEndCoord = nodeList.get(car.getPartEnd()).getPoint();
//    			System.out.println("partEndX="+partEndCoord.getX()+", partEndY="+partEndCoord.getY());
    			if(newX==partEndCoord.getX() && newY==partEndCoord.getY()){	//到达partEnd
//TODO
    				if(car.getPartEnd() == car.getDestId()){
//    					System.out.println("$$$$$$$$$$$死了么$$$$死了么￥￥￥￥￥死了么$$$$$$死了么$$$$$$$死了么？？？？？？？？？？//");
    					car.setLife(false);
    					break;
    				}
//    				System.out.println("+++到达partEnd***************************************************************************");
//    				System.out.println("此partEnd为： "+car.getPartEnd());
    				car.setPartSrc(car.getPartEnd());
   					car.setCoord(new Point(nodeList.get(car.getPartEnd()).getPoint().getX(), nodeList.get(car.getPartEnd()).getPoint().getY()));
   					car.setPartEnd(calcPartEnd(car));	//根据partSrc 计算partEnd
//   					System.out.println("下一个partEnd = "+car.getPartEnd());
   					setDir(car);		//根据partSrc、partEnd 计算dir
   					
//   					if(car.getCoord() == nodeList.get(car.getDestId()-1).getPoint()){
//   						System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$死了么？？？？？？？？？？？？？？？？？？？");
//    					car.setLife(false);
//    				}
   					//TODO
//   					System.out.println("setDir之后： x="+car.getCoord().getX()+"y="+car.getCoord().getY());
   				}else{		//**在路上**
       				if(canMove(car)){	//调用*判断碰撞函数* 	要么移动，要么停一下
       					car.move();
       				}
       				
   				}
    				
    		} else{		//死的, 暂时使其立即复活
        		//将小车的 坐标、partSrc 设置在 出生节点上 “1”
        		InitCar(car);
        		if(canMove(car)){
        			car.setLife(true);
        		}
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
