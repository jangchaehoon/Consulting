package com.yp.config;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 시스템 전역 상수
 * @author JANGCHAEHOON
 *
 */
public class Constants {

	public enum UPLOADS{
		ROOT, UPLOAD_ROOT, DOWNLOAD_ROOT, COMMON_FILE, TEMP_FILE,
		IMAGE_FILE, BOARD_FILE
	};
	
	public enum LOGGING{LOGGING, NOLOGGING};
	
	public static LOGGING QueryLogging = LOGGING.LOGGING;
	
	/** WEB_ROOT */
	private static  String WEB_ROOT_PATH = "";
	
	/** UPLOAD_ROOT */
	private static  String UPLOAD_ROOT_PATH = "";
	private static final String UPLOAD_ROOT_URL = "/Upload/";
	
	/** DOWNLOAD_ROOT */
	private static  String DOWNLOAD_ROOT_PATH = "";
	private static final String DOWNLOAD_ROOT_URL = "/Download/";
	
	/** COMMON_FILE */
	private static  String COMMON_FILE_PATH = "";
	private static final String COMMON_FILE_URL = UPLOAD_ROOT_URL + "CommonUploadFiles/";
	
	/** TEMP_FILE */
	private static  String TEMP_FILE_PATH = "";
	private static final String TEMP_FILE_URL = UPLOAD_ROOT_URL + "TempFiles/";
	
	/** IMAGE_FILE */
	private static  String IMAGE_FILE_PATH = "";
	private static final String IMAGE_FILE_URL =  UPLOAD_ROOT_URL + "images/";
	
	/** BOARD_FILE */
	private static  String BOARD_FILE_PATH = "";
	private static final String BOARD_FILE_URL = UPLOAD_ROOT_URL + "boardFile/";
	
    public static void setConstants(String WebRootPath)
    {
    	Logger logger = LoggerFactory.getLogger(Constants.class);
    	logger.debug("-----Set Constants...-----");
    	
    	/** WEB_ROOT_PATH */
    	Constants.WEB_ROOT_PATH = WebRootPath;
    	
    	/** UPLOAD_ROOT_PATH */
    	Constants.UPLOAD_ROOT_PATH = WebRootPath+Constants.UPLOAD_ROOT_URL;
    	mkdir(Constants.UPLOAD_ROOT_PATH);
    	// logger.debug("-Constants.UPLOAD_ROOT_PATH={}-",Constants.UPLOAD_ROOT_PATH);
    	
    	/** DOWNLOAD_ROOT */
    	Constants.DOWNLOAD_ROOT_PATH = Constants.WEB_ROOT_PATH + Constants.DOWNLOAD_ROOT_URL;
    	mkdir(Constants.DOWNLOAD_ROOT_PATH);
    	
    	/** COMMON_FILE */
    	Constants.COMMON_FILE_PATH = Constants.WEB_ROOT_PATH + Constants.COMMON_FILE_URL;
    	mkdir(Constants.COMMON_FILE_PATH);
    	
    	/** TEMP_FILE_PATH */
    	Constants.TEMP_FILE_PATH = Constants.WEB_ROOT_PATH + Constants.TEMP_FILE_URL;
    	mkdir(Constants.TEMP_FILE_PATH);
    	
    	/** IMAGE_FILE_PATH */
    	Constants.IMAGE_FILE_PATH = Constants.WEB_ROOT_PATH + Constants.IMAGE_FILE_URL;
    	mkdir(Constants.IMAGE_FILE_PATH);
    	
    	/** BOARD_FILE_PATH */
    	Constants.BOARD_FILE_PATH = Constants.WEB_ROOT_PATH + Constants.BOARD_FILE_URL;
    	mkdir(Constants.BOARD_FILE_PATH);
    	
    }
    
    // getURL 은 프로젝트내 상대경로 반환
    public static String getURL(UPLOADS u)
    {
    	String rtnURL = "";
    	switch(u)
    	{
    		case ROOT:
    			rtnURL = "/";
    			break;
    			
    		case UPLOAD_ROOT:
    			rtnURL = Constants.UPLOAD_ROOT_URL;
    			break;
    			
    		case DOWNLOAD_ROOT:
    			rtnURL = Constants.DOWNLOAD_ROOT_URL;
    			break;
    			
    		case IMAGE_FILE:
    			rtnURL = Constants.IMAGE_FILE_URL;
    			break;
    			
    		case TEMP_FILE:
    			rtnURL = Constants.TEMP_FILE_URL;
    			break;
    			
    		case COMMON_FILE:
    			rtnURL = Constants.COMMON_FILE_URL;
    			break;
    			
    		case BOARD_FILE:
    			rtnURL = Constants.BOARD_FILE_URL;
    			break;
    			
    		default:
    			rtnURL = "/";
    			break;
    	}
    	return rtnURL;
    }
    
    // getPATH은 절대경로 반환
    public static String getPATH(UPLOADS u)
    {
    	String rtnPATH = "";
    	switch(u)
    	{
    		case ROOT:
    			rtnPATH = Constants.WEB_ROOT_PATH;
    			break;
    			
    		case UPLOAD_ROOT:
    			rtnPATH = Constants.UPLOAD_ROOT_PATH;
    			break;
    			
    		case DOWNLOAD_ROOT:
    			rtnPATH = Constants.DOWNLOAD_ROOT_PATH;
    			break;
    			
    		case IMAGE_FILE:
    			rtnPATH = Constants.IMAGE_FILE_PATH;
    			break;
    			
    		case TEMP_FILE:
    			rtnPATH = Constants.TEMP_FILE_PATH;
    			break;
    			
    		case COMMON_FILE:
    			rtnPATH = Constants.COMMON_FILE_PATH;
    			break;
    			
    		case BOARD_FILE:
    			rtnPATH = Constants.COMMON_FILE_PATH;
    			break;
    			
    		default:
    			rtnPATH = Constants.WEB_ROOT_PATH;
    			break;
    	}
    	return rtnPATH;
    }
    
    private static void mkdir(String path)
    {
    	File upDir = new File(path);
    	if(!upDir.exists())//해당 디렉토리의 존재여부를 확인
    	{
    		upDir.mkdirs();//없다면 생성 
    	}
    }

  //토큰 유효성 시간 부분
    public enum TOKEN_VALIDATE {
    	TOKEN_VALID_MINUTE, TOKEN_VALID_HOUR, TOKEN_VALID_DAY
	};
	
	private final static int TOKEN_VALID_MINUTE_VAL = 60;
	private final static int TOKEN_VALID_HOUR_VAL = 24;
	private final static int TOKEN_VALID_DAY_VAL = 1;
	
	public static int getTOKEN_VALIDATE(TOKEN_VALIDATE u) {
    	int rtnVal = 0;
    	
    	switch(u) {
    		case TOKEN_VALID_MINUTE:
    			rtnVal = Constants.TOKEN_VALID_MINUTE_VAL;
    			break;
    			
    		case TOKEN_VALID_HOUR:
    			rtnVal = Constants.TOKEN_VALID_HOUR_VAL;
    			break;
    		
    		case TOKEN_VALID_DAY:
    			rtnVal = Constants.TOKEN_VALID_DAY_VAL;
    			break;
    			
    		default:
    			rtnVal = Constants.TOKEN_VALID_MINUTE_VAL;
    			break;
    	}
    	
    	return rtnVal;
    }

}///~
