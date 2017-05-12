package willzh.java8test;

/**
 * 业务逻辑异常类
 *
 */
public class BusinessException extends RuntimeException {

	public BusinessException() {
		super();
	}

	public BusinessException(String msg) {
		super(msg);		
		
	}

}
