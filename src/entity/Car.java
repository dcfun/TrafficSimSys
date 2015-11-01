package entity;


/**
 * Created by uu789 on 2015/10/24.
 */
public class Car {
    private int id;
    private Point coord;	//当前坐标
    private Point moveXY = new Point(10,10);	//x,y坐标一次移动的距离
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
		this.coord.setX(this.coord.getX()+this.moveXY.getX());
		this.coord.setX(this.coord.getY()+this.moveXY.getY());
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
