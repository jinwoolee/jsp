<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/js/jquery/jquery-1.12.4.js" type="text/javascript"></script>
<script src="/js/i18next/i18next.js" type="text/javascript"></script>
<script>
i18next.init({
	  lng: 'en',
	  debug: true,
	  resources: {
	    en: {
	      translation: {
	        "key": "hello world",
	        "key_next": "hello world {{USERID}}"
	      }
	    },
	    ko: {
		      translation: {
		        "key": "안녕하세요",
		        "key_next": "안녕하세요 {{USERID}}"
		      }
		    }
	  }
	}, function(err, t) {
	  // initialized and ready to go!
	  //document.getElementById('output').innerHTML = i18next.t('key');
	});

console.log(i18next.t('key'));
console.log(i18next.t('key_next', {"USERID":"brown"}));

i18next.changeLanguage("ko", null);

console.log(i18next.t('key_next', {"USERID":"brown"}));
</script>

<title>http://localhost:8080/js/i18next/i18next.jsp</title>
</head>
<body>
http://localhost:8080/js/i18next/i18next.jsp
</body>
</html>