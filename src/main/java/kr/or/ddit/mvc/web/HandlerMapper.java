package kr.or.ddit.mvc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.model.UrlMapping;
import kr.or.ddit.mvc.repository.IUrlMappingDao;
import kr.or.ddit.mvc.repository.UrlMappingDao;

public class HandlerMapper {
	
	private Map<String, IController> uriMapping;
	
	public HandlerMapper() {
		
		//아래 데이터는 데이터베이스의 정보를 바탕으로 생성 되었다고 가정 -현재는 하드코딩
		uriMapping = new HashMap<String, IController>();
		
		IUrlMappingDao dao = new UrlMappingDao();
		
		// url, cotroller의 full name --> 인스턴스 생성
		List<UrlMapping> urlMappingList = dao.getUrlMapping();
		
		for(UrlMapping urlMapping : urlMappingList) {
			String controllerStr = urlMapping.getController();
			
			try {
				Class clazz = Class.forName(controllerStr);
				IController controller = (IController)clazz.newInstance();
				uriMapping.put(urlMapping.getUrl(), controller); 
				
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		/*uriMapping.put("/mvc/userList.do", new UserListController());
		uriMapping.put("/mvc/memberList.do", new MemberListController());
		uriMapping.put("/mvc/user.do", new UserController());
		uriMapping.put("/mvc/userFrom.do", new UserFormController());*/
	}

	/**
	* Method : getController
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param uri
	* @return
	* Method 설명 : uri를 처리해주는 컨트롤러를 리턴
	*/
	public IController getController(String uri) {
		return uriMapping.get(uri);
	}

}




