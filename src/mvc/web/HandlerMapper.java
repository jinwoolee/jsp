package mvc.web;

import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class HandlerMapper {
	private Map<String, IAction> handlerMap;

	public HandlerMapper(String mappingInfoLoc) {
		handlerMap = new LinkedHashMap<String, IAction>();
		ResourceBundle bundle = ResourceBundle.getBundle(mappingInfoLoc);
		Enumeration<String> urls = bundle.getKeys();
		while (urls.hasMoreElements()) {
			String url = (String) urls.nextElement().trim();
			String handlerName = bundle.getString(url).trim();
			try {
				Class<IAction> handlerClz = (Class<IAction>) Class.forName(handlerName);
				IAction handler = handlerClz.newInstance();
				handlerMap.put(url.trim(), handler);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}

	public IAction getHandler(String url) {
		return handlerMap.get(url);
	}

}
