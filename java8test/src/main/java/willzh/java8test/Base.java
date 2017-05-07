package willzh.java8test;

import java.util.Date;
import java.util.UUID;

public class Base {
	
	private String id;
	
	private Date createTime;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**  
	 * @Title:  setId
	 * @Description: id 2017年5月7日
	 * @return: String
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**  
	 * @Title:  setCreateTime
	 * @Description: createTime 2017年5月7日
	 * @return: Date
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Base() {
		super();
		this.id = UUID.randomUUID().toString().replace("-", "");
		this.createTime = new Date();
	}
	
	
	
	
	
}
