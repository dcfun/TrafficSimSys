package entity;

/**
 * Created by uu789 on 2015/10/25.
 */
public class Node {
    private int id;
    private int type;
    private Point point;
    private int straightNodeId;
    private int rightNodeId;

    public Node(int id, int type, Point point, int straightNode, int rightNode) {
        this.id = id;
        this.type = type;
        this.point = point;
        this.straightNodeId = straightNode;
        this.rightNodeId = rightNode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

	public int getStraightNodeId() {
		return straightNodeId;
	}

	public void setStraightNodeId(int straightNodeId) {
		this.straightNodeId = straightNodeId;
	}

	public int getRightNodeId() {
		return rightNodeId;
	}

	public void setRightNodeId(int rightNodeId) {
		this.rightNodeId = rightNodeId;
	}


}
