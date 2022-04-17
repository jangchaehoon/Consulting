package com.yp.swagger.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.yp.base.BaseController;
import com.yp.exception.MessageCommonCode;
import com.yp.security.model.ResponseDefault;
import com.yp.security.model.ResponseList;
import com.yp.security.model.ResponseView;
import com.yp.security.model.User;

@RestController
@RequestMapping(value="/api")
public class AuthenticationSwaggerController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSwaggerController.class);
	
	@ApiOperation( httpMethod="GET"
				 , value="현재 로그인된 사용자 조회"
				 , notes="현재 로그인된 사용자를 조회합니다."
				 , consumes = "application/json"
				 , produces = "application/json"
				 , protocols = "http"
				 , responseHeaders = {}
				 )
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "토큰", required = true, dataType = "string", paramType = "header", defaultValue = ""),
	})
	@ApiResponses({ @ApiResponse(code = 200, message = "OK")
	 			  , @ApiResponse(code = 401, message = "Unauthorized")
	 			  , @ApiResponse(code = 403, message = "Forbidden")
	 			  , @ApiResponse(code = 404, message = "Not Found")
	 			  , @ApiResponse(code = 400, message = "Bad Request")
	 			  , @ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping( value="/auth/me", method=RequestMethod.GET, produces = "application/json")
	public ResponseList<List<User>> apiauthmeget(String token) throws Exception{
		ResponseList<List<User>> responseValue = new ResponseList<List<User>>();
		List<User> list = new ArrayList<User>();
		User user = new User();
		list.add(user);
		responseValue.setList(list);
		return responseValue;
	}
	
	@ApiOperation(httpMethod="POST"
			 , value="로그인하기"
			 , notes="로그인 합니다."
			 , consumes = "application/json"
			 , produces = "application/json"
			 , protocols = "http"
			 , responseHeaders = {}
			)
	@RequestMapping(value="/auth/sign-in",method=RequestMethod.POST, produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name="parameter",required = true,dataType = "SignInVO", paramType = "body")})
	@ResponseBody
	public ResponseView<HashMap<String, String>> apiauthsigninpost(HttpServletRequest request, HttpServletResponse response,@RequestBody SignInVO parameter) throws Exception{
		ResponseView<HashMap<String, String>> responseView = new ResponseView<HashMap<String, String>>(){};
		HashMap<String, String> map = new HashMap<String, String>();
		String JSON_WEB_TOKEN = "";
		
		try {
			JSON_WEB_TOKEN = getAuthenticationSwaggerService().getMemberLoginAuthCheck(parameter);
			map.put("JSON_WEB_TOKEN", JSON_WEB_TOKEN);
			
			responseView.setSuccess(true);
			responseView.setStatuscode(MessageCommonCode.MSG0200.getMessageCode());
			responseView.setMessage(MessageCommonCode.MSG0200.getMessage());
		} catch (BadCredentialsException e) {
			responseView.setSuccess(false);
			responseView.setStatuscode(MessageCommonCode.ERR0014.getMessageCode());
			responseView.setMessage(MessageCommonCode.ERR0014.getMessage());
		} catch (UsernameNotFoundException e) {
			responseView.setSuccess(false);
			responseView.setStatuscode(MessageCommonCode.ERR0012.getMessageCode());
			responseView.setMessage(MessageCommonCode.ERR0012.getMessage());
		} catch (Exception e) {
			responseView.setSuccess(false);
			responseView.setStatuscode(MessageCommonCode.ERR0011.getMessageCode());
			responseView.setMessage(MessageCommonCode.ERR0011.getMessage());
		}
		responseView.setView(map);
		return responseView;
	}
	
	@ApiOperation(httpMethod="POST"
			 , value="로그아웃하기"
			 , notes="로그아웃 합니다."
			 , consumes = "application/json"
			 , produces = "application/json"
			 , protocols = "http"
			 , responseHeaders = {}
			)
	@RequestMapping(value="/auth/sign-out",method=RequestMethod.POST, produces = "application/json")
	@ApiImplicitParams({
	@ApiImplicitParam(name="parameter",required = true,dataType = "SignInVO", paramType = "body")})
	@ResponseBody
	public ResponseView<ResponseDefault> apiauthsignoutpost(String token) throws Exception{
		ResponseView<ResponseDefault> responseView = new ResponseView<ResponseDefault>(){};
		ResponseDefault responseDefault = new ResponseDefault() {};
		responseDefault.setSuccess(true);
		responseDefault.setMessage("succes");
		responseView.setView(responseDefault);
		return responseView;
	}
	@ApiOperation(httpMethod="POST"
	 , value="테스트하기"
	 , notes="테스트 합니다."
	 , consumes = "application/json"
	 , produces = "application/json"
	 , protocols = "http"
	 , responseHeaders = {}
	)
@RequestMapping(value="/auth/signabc",method=RequestMethod.POST, produces = "application/json")
@ApiImplicitParams({
@ApiImplicitParam(name="parameter",required = true,dataType = "SignInVO", paramType = "body")})
@ResponseBody
	public ResponseView<SignInVO> apiauthtestpost(@RequestBody String parameter) throws Exception{
		ResponseView<SignInVO> responseView = new ResponseView<SignInVO>(){};
		SignInVO signInVO = new SignInVO() {};
		responseView.setSuccess(true);
		responseView.setMessage("succes");
		responseView.setView(signInVO);
		return responseView;
	}
}
