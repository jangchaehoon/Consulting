package com.yp.config;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yp.common.util.PropertiesVO;
import com.yp.config.Constants.LOGGING;

/**
 * 
 * 시스템 초기화 클래스이다.
 * 서버 실행시 업로드경로설정등의 초기화 작업을 처리한다.
 * @author JANGCHAEHOON
 * 
 */
public class Startup {

	final static Logger logger = LoggerFactory.getLogger(Startup.class);

	private PropertiesVO vo = new PropertiesVO();

	private String LogerYN = vo.getLogerYN();
	
	private static String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * 서버 실행시 업로드경로설정등의 초기화 작업을 처리한다.
	 */
    public void init() 
    {
    	logger.debug("######################################");
    	logger.debug("-GNX FOR CF SYSTEM Starting -");
    	logger.debug("######################################");
    	logger.debug("-LOGING = {}-", LogerYN); // globals.xml에서 읽어옴.
    	LoadInit();
		logger.debug("######################################");
		logger.debug("-GNX FOR CF SYSTEM Started -");
	   	logger.debug("######################################");
    }
    
	private void LoadInit() 
	{
		try {
			logger.debug("-----LoadInitData...-----");
			String[] wrPathArr = this.getClass().getResource("/").getPath().split("/");
			String wrPath = "";
			String homePath = "";
			
			if("dev".equals(vo.getDBGubun())) {
				homePath = "/home/DEV_MIRAEASSET";//개발
			}else {
				homePath = "/data/uploadData/GX_MIRAEASSET";	// 상용
			}
			
			if (isWindows()) {
	            //System.out.println("This is Windows");
	            wrPath = StringUtils.join(wrPathArr, "/", 0, wrPathArr.length-2);
	            wrPath = homePath;
	        } else if (isMac()) {
	        	//System.out.println("This is Mac");
	            wrPath = homePath; // 상용
	        } else if (isUnix()) {
	        	//System.out.println("This is Unix or Linux");
	            wrPath = homePath; // 상용
	        } else if (isSolaris()) {
	        	//System.out.println("This is Solaris");
	            wrPath = homePath; // 상용
	        } else {
	        	//System.out.println("Your OS is not support!!");
	            wrPath = homePath; // 상용
	        }
			
			logger.debug("-Web Root Path = {}-",wrPath);
			Constants.setConstants(wrPath);
			if(LogerYN.equals("N")){
				Constants.QueryLogging = LOGGING.NOLOGGING;
			}else{
				Constants.QueryLogging = LOGGING.LOGGING;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.debug("######################################");
			logger.debug("-GNX FOR CF SYSTEM Start Fail -");
		   	logger.debug("######################################");
		}
	}
	
	public static boolean isWindows() {
		  
        return (OS.indexOf("win") >= 0);
  
    }
  
    public static boolean isMac() {
  
        return (OS.indexOf("mac") >= 0);
  
    }
  
    public static boolean isUnix() {
  
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
  
    }
  
    public static boolean isSolaris() {
  
        return (OS.indexOf("sunos") >= 0);
  
    }

}
