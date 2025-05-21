package Model;

public class Image {

	private int id;
	private String name;
	private String imgName;

	public Image(int id, String name, String imgName) {
		super();
		this.id = id;
		this.name = name;
		this.imgName = imgName;
	}

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

}
