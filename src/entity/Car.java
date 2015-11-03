package entity;


/**
 * Created by uu789 on 2015/10/24.
 */
public class Car {
    private int id;
    private Point coord;	//当前坐标
    private Point moveXY;	//x,y坐标一次移动的距离
    private int birthId;	//出生地
    private int destId;		//死亡地
    private int partSrc;	//线段起点
    private int partEnd;	//线段终点
    private int dir;		//方向
    private int color;
    private boolean life;

	public Car(int id) {
        this.id = id;
    }
	
	public void move(){
//		//TODO
//		System.out.println("---------------------------");
//		System.out.println("move之前："+this.coord.getX()+","+this.coord.getY());
		this.coord.setX(this.getCoord().getX()+this.getMoveXY().getX());
		this.coord.setY(this.getCoord().getY()+this.getMoveXY().getY());
//		System.out.println("move之后："+this.coord.getX()+","+this.coord.getY());
//		System.out.println("---------------------------");
	}
    
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public Point getCoord() {
		return coord;
	}

	public void setCoord(Point coord) {
		this.coord = coord;
	}

	public Point getMoveXY() {
		return moveXY;
	}

	public void setMoveXY(Point moveXY) {
		this.moveXY = moveXY;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBirthId() {
        return birthId;
    }

    public void setBirthId(int birthId) {
        this.birthId = birthId;
    }

    public int getDestId() {
        return destId;
    }

    public void setDestId(int destId) {
        this.destId = destId;
    }

	public int getPartSrc() {
		return partSrc;
	}

	public void setPartSrc(int partSrc) {
		this.partSrc = partSrc;
	}

	public int getPartEnd() {
		return partEnd;
	}

	public void setPartEnd(int partEnd) {
		this.partEnd = partEnd;
	}

	public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }
}
