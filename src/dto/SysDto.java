package dto;

import entity.Car;
import entity.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uu789 on 2015/10/25.
 */
public class SysDto {

    private List<Car> carList = new ArrayList<Car>();
    private List<Node> nodeList = new ArrayList<Node>();
    private List<Integer> birthList = new ArrayList<Integer>();		// “4” 预处理节点的数组
    private List<Integer> destList = new ArrayList<Integer>();		// “3”
    private int[][] next_partEnd_matrix;	//使用弗洛伊德算法 得出的最短路径数组

/////////////////////////////////////////////////////
    private int MAX_NUM = 50;    //小车的最大数量
/////////////////////////////////////////////////////
    

    public int[][] getNext_partEnd_matrix() {
		return next_partEnd_matrix;
	}

	public void setNext_partEnd_matrix(int[][] next_partEnd_matrix) {
		this.next_partEnd_matrix = next_partEnd_matrix;
	}

    public int getMAX_NUM() {
        return MAX_NUM;
    }

	public void setMAX_NUM(int MAX_NUM) {
        this.MAX_NUM = MAX_NUM;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

	public List<Node> getNodeList() {
		return nodeList;
	}

	public void setNodeList(List<Node> nodeList) {
		this.nodeList = nodeList;
	}

	public List<Integer> getBirthList() {
		return birthList;
	}

	public void setBirthList(List<Integer> birthList) {
		this.birthList = birthList;
	}

	public List<Integer> getDestList() {
		return destList;
	}

	public void setDestList(List<Integer> destList) {
		this.destList = destList;
	}
    

}
