package xupt.se.ttms.model;

public class Play {
	private int id = 0;
	private int type_id = 0;
	private int lang_id = 0;
	private String name = "";
	private String introduction = "";
	private String image = "";
	private String video = "";
	private int length = 0;
	private float ticketPrice;
	//private int status;
	
	public Play() {
		id = 0;
	}
	
	public Play(int ID, int type_id, int lang_id, String name, String introduction, String image, String video, int length, float ticketPrice  ) {
		id = ID;
		this.type_id = type_id;
		this.lang_id = lang_id;
		this.name = name;
		this.introduction = introduction;
		this.image = image;
		this.video = video;
		this.length = length;
		this.ticketPrice = ticketPrice;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setID(int ID) {
		this.id = ID;
	}
	public int getID() {
		return id;
	}
	
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getType_id() {
		return type_id;
	}
	
	
	public void setLang_id(int lang_id) {
		this.lang_id = lang_id;
	}
	public int getLang_id() {
		return lang_id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getIntroduction() {
		return introduction;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public float getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "Play [id=" + id + ", type_id=" + type_id + ", lang_id=" + lang_id + ", name=" + name + ", introduction="
				+ introduction + ", image=" + image + ", video=" + video + ", length=" + length + ", ticketPrice="
				+ ticketPrice + "]";
	}
	
	
	
}
	
	
	