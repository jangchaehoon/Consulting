package com.yp.common.util;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.springframework.stereotype.Component;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(value = "CommUtil")
public class CommUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(CommUtil.class);
	
	/**
	 * @Description  : Client IP 가져오기
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : Object
	 */

	public static String getClientIp(HttpServletRequest request) {
		String ip = InetUtil.getClientIP(request);

		if (ip.equals("0:0:0:0:0:0:0:1") || ip.equals("127.0.0.1")) {
			ip = InetUtil.getCurrentEnvironmentNetworkIp();
		}

		return ip;
	}
	
	/**
	 * @Description  : 접속환경 확인(웹/모바일)
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : boolean
	 */
	public static boolean isMobile(HttpServletRequest request) {
		String userAgent = request.getHeader("user-agent");
		boolean mobile1 = userAgent.matches(".*(iPhone|iPod|iPad|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson).*");
		boolean mobile2 = userAgent.matches(".*(LG|SAMSUNG|Samsung).*");
		
		return mobile1 || mobile2;
	}

	/**
	 * @Description  : 값이 비어있으면 참
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : boolean
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj instanceof String) {
			return obj == null || "".equals(obj.toString().trim());
		} else if (obj instanceof List) {
			return obj == null || ((List<?>) obj).isEmpty();
		} else if (obj instanceof Map) {
			return obj == null || ((Map) obj).isEmpty();
		} else if (obj instanceof Object[]) {
			return obj == null || Array.getLength(obj) == 0;
		} else {
			return obj == null;
		}
	}

	/**
	 * @Description  : 값이 비어있지 않으면 참
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : boolean
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	/**
	 * @Description  : 값이 동일하면 참
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : boolean
	 */
	public static boolean isEquals(Object sobj, Object tobj) {
		if (CommUtil.isNotEmpty(sobj)) {
			return sobj.equals(tobj);
		} else {
			return false;			
		}
	}

	/**
	 * @Description  : 값이 다르면 참
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : boolean
	 */
	public static boolean isNotEquals(Object sobj, Object tobj) {
		return !isEquals(sobj, tobj);
	}

	/**
	 * @Description  : 렌덤 스트링 생성
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : String
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	/***************************************************************** Class 변환 *****************************************************************/
	/* JsonObjectTo */
	/**
	 * @Description  : JsonObject를 지정한 Class로 변환
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : Object
	 */
	public static Object convertJsonObjectToClass(JsonObject jobj, Class<?> c) {
		Gson gson = new Gson();
		return gson.fromJson(jobj, c);
	}
	
	/**
	 * @Description  : JsonObject를 Object로 변환
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : Object
	 */
	@SuppressWarnings("rawtypes")
	public static Object convertJsonObjectToObject(JsonObject json, Object objClass) {
		String keyAttribute = null;
		String setMethodString = "set";
		String methodString = null;
		Iterator itr = json.keySet().iterator();
		
		while (itr.hasNext()) {

			keyAttribute = (String) itr.next();
			methodString = setMethodString + keyAttribute.substring(0, 1).toUpperCase() + keyAttribute.substring(1);
			try {
				Method[] methods = objClass.getClass().getDeclaredMethods();

				for (int i = 0; i <= methods.length - 1; i++) {

					if (methodString.equals(methods[i].getName())) {
						Object jsonObjType = json.get(keyAttribute).getClass();
						if (jsonObjType instanceof Boolean) {
							if (json.get(keyAttribute).getAsBoolean()) {
								methods[i].invoke(objClass, true);
							} else {
								methods[i].invoke(objClass, false);
							}
						}
						else if (!(jsonObjType instanceof ArrayList)) {
							if (json.get(keyAttribute) == null) {
								methods[i].invoke(objClass, "");
							} else {
								methods[i].invoke(objClass, json.get(keyAttribute).toString());
							}
						}
					}
				}
			} catch (SecurityException e) {

			} catch (IllegalAccessException e) {

			} catch (IllegalArgumentException e) {

			} catch (InvocationTargetException e) {

			}
		}
		return objClass;
	}
	
	/**
	 * @Description  : JsonObject를 Map으로 변환
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : Object
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> convertJsonObjectToMap(JsonObject jsonObj) {
		Map<String, Object> map = null;

		try {
			map = new ObjectMapper().readValue(jsonObj.toString(), Map.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}
	

	/* JsonArrayTo */
	/**
	 * @Description  : JsonArray를 List<Map>으로 변환
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : Object
	 */
	public static List<Map<String, Object>> getListMapFromJsonArray(JsonArray jsonArray) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		if (jsonArray != null) {
			int jsonSize = jsonArray.size();
			for (int i = 0; i < jsonSize; i++) {
				Map<String, Object> map = convertJsonObjectToMap((JsonObject) jsonArray.get(i));
				list.add(map);
			}
		}

		return list;
	}
	
	/* ObjectTo */
	/**
	 * @Description  : Object를 Map으로 변환
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map ConverObjectToMap(Object obj) {
		Map resultMap = new HashMap();
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (int i = 0; i <= fields.length - 1; i++) {
				fields[i].setAccessible(true);
				resultMap.put(fields[i].getName(), fields[i].get(obj));
			}

			logger.debug("resultMap[{}]", resultMap);
		} catch (IllegalArgumentException e) {

		} catch (IllegalAccessException e) {

		}
		return resultMap;
	}
	
	/* MapTo */
	/**
	 * @Description  : Map을 Object로 변환
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : Object
	 */
	@SuppressWarnings("rawtypes")
	public static Object convertMapToObject(Map map, Object objClass) {
		String keyAttribute = null;
		String setMethodString = "set";
		String methodString = null;
		Iterator itr = map.keySet().iterator();

		while (itr.hasNext()) {

			keyAttribute = (String) itr.next();
			methodString = setMethodString + keyAttribute.substring(0, 1).toUpperCase() + keyAttribute.substring(1);

			try {
				Class<? extends Object> paramClass = objClass.getClass();

				Method[] methods = paramClass.getDeclaredMethods(); // VO
				Method[] superClassmethods = paramClass.getSuperclass().getDeclaredMethods(); // BaseVO

				for (int i = 0; i <= methods.length - 1; i++) {
					if (methodString.equals(methods[i].getName())) {
						if (map.get(keyAttribute) instanceof Boolean) {
							if ((Boolean) map.get(keyAttribute)) {
								methods[i].invoke(objClass, true);
							} else {
								methods[i].invoke(objClass, false);
							}
						} else if (!(map.get(keyAttribute) instanceof ArrayList)) {
							if (map.get(keyAttribute) == null) {
								methods[i].invoke(objClass, "");
							} else {
								methods[i].invoke(objClass, map.get(keyAttribute).toString());
							}
						}
					}
				}

				for (int i = 0; i <= superClassmethods.length - 1; i++) {

					if (methodString.equals(superClassmethods[i].getName())) {
						if (map.get(keyAttribute) instanceof Boolean) {
							if ((Boolean) map.get(keyAttribute)) {
								superClassmethods[i].invoke(objClass, true);
							} else {
								superClassmethods[i].invoke(objClass, false);
							}
						} else if (!(map.get(keyAttribute) instanceof ArrayList)) {
							if (map.get(keyAttribute) == null) {
								superClassmethods[i].invoke(objClass, "");
							} else {
								superClassmethods[i].invoke(objClass, map.get(keyAttribute).toString());
							}
						}
					}
				}
			} catch (SecurityException e) {

			} catch (IllegalAccessException e) {

			} catch (IllegalArgumentException e) {

			} catch (InvocationTargetException e) {

			}
		}
		return objClass;
	}

	/**
	 * @Description  : Map을 JsonObject로 변환
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : JsonObject
	 */
	public static JsonObject convertMaptoJsonObjrct(Map<String, Object> map) {
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			JsonElement value = gson.toJsonTree(entry.getValue());
			
			jsonObject.add(key, value);
		}

		return jsonObject;
	}
	
	/* ListTo */
	/**
	 * @Description  : List을 JsonArray로 변환
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : JsonArray
	 */
	public static JsonArray convertListToJsonArray(List<Map<String, Object>> list) {
		JsonArray jsonArray = new JsonArray();
		for (Map<String, Object> map : list) {
			jsonArray.add(convertMaptoJsonObjrct(map));
		}

		return jsonArray;
	}

	/**
	 * @Description  : List를 JsonArraySting으로 변환
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : Object
	 */
	public static String convertListToJsonArrayString(List<Map<String, Object>> list) {
		JsonArray jsonArray = convertListToJsonArray(list);
		return jsonArray.toString();
	}
	
	/**
	 * @Description  : String[]를 String 로 변환
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : Object
	 */
	public static String parseMessage(String message, String... args) {
		if (message == null || message.trim().length() <= 0)
			return message;

		if (args == null || args.length <= 0)
			return message;

		String[] splitMsgs = message.split("%");
		if (splitMsgs == null || splitMsgs.length <= 1)
			return message;

		for (int i = 0; i < args.length; i++) {
			String replaceChar = "%" + (i + 1);
			message = message.replaceFirst(replaceChar, args[i]);
		}
		return message;
	}
	
	/***************************************************************** Class 변환 끝 *****************************************************************/

	/**
	 * @Description  : 임시비밀번호 생성
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : Object
	 */
	public static String temporaryPassword(int size) {

		StringBuffer buffer = new StringBuffer();
		SecureRandom random = new SecureRandom();
		random.setSeed(new Date().getTime());

		String chars[] = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,0,1,2,3,4,5,6,7,8,9"
				.split(",");
		String SpecialChars[] = "~,!,@,#,$,%,^,&,*,(,),+,-".split(",");

		int SpCnt = random.nextInt(9);

		for (int i = 0; i < size; i++) {
			if (SpCnt == i) {
				// 특수문자
				buffer.append(SpecialChars[random.nextInt(SpecialChars.length)]);
			} else {
				// 영어+숫자
				buffer.append(chars[random.nextInt(chars.length)]);
			}
		}

		return buffer.toString();
	}
	
	/**
	 * @Description  : 페이징 쿼리에서 페이지 시작점 구하기
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : Object
	 */
	public static Integer getPageOffset(String page, String pageSize) {
		return ((Integer.parseInt(page) - 1) * Integer.parseInt(pageSize));
	}

}