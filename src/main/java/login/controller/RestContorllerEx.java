package login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/*
 * 객체 생성 객체 응답
 * html1 -> ajax 왠만한건 다 처리할 수 있다. 오케이?
 */
@Controller
@ResponseBody
public class RestContorllerEx {


	@RequestMapping(value = "/test/get", method = RequestMethod.POST)
	public HumanResponse ExResponse(@RequestBody ExRequest ex) {
		
		System.out.println(ex);
		
		return new HumanResponse("NAME", 1234);
	
	}
	
	@Builder
	@Setter
	@Getter
	@ToString
	static class HumanResponse{
		
		private String name;
		private int age;
	}
	
	@Setter
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	static class ExRequest{
		
		private String request;
		
	}
}
