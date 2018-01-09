<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/js/jquery/jquery-1.12.4.js" type="text/javascript"></script>
<script src="/js/jqueryi18n/jquery.i18n.properties.js" type="text/javascript"></script>
<script>
//https://www.i18next.com/api.html
$.i18n.properties({
    name:'message', 
    path:'/resource/', 
    mode:'both',
    language:'en',
    async: true,
    callback: function() {
        // We specified mode: 'both' so translated values will be
        // available as JS vars/functions and as a map

        // Accessing a simple value through the map
        console.log($.i18n.prop('GREETING'));
        
        // Accessing a value with placeholders through the map
        console.log($.i18n.prop('VISITOR_TEST', 'brown', 'cony'));

        //Accessing a simple value through a JS variable
        console.log(GREETING);
        
        // Accessing a value with placeholders through a JS function
        console.log(VISITOR_TEST('brown', 'cony'));
    }
});
</script>

<title>http://localhost:8080/js/jqueryi18n/jsi18n.jsp</title>
</head>
<body>
jsi18n.jsp
</body>
</html>