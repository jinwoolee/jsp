package fileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownloadAbsolutePathServlet
 */
@WebServlet("/fileDownloadAbsolutePathServlet")
public class FileDownloadAbsolutePathServlet extends HttpServlet {
	private final String UPLOAD_STORAGE = "/Applications/ljw/server/uploadStorage";
	private static final long serialVersionUID = 1L;
       
    
    public FileDownloadAbsolutePathServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String fileName = request.getParameter("fileName");
		File f = new File(UPLOAD_STORAGE + File.separator + fileName);
		
		response.setHeader("Content-Disposition","attachment;filename=" + fileName);
        response.setContentType("application/octet-stream");
        response.setContentLength((int)f.length());
        
		
		if(f.exists()) {
			
			byte[] buff = new byte[512];
			int len = -1;
			FileInputStream fis = new FileInputStream(f);
			ServletOutputStream sos = response.getOutputStream();
			
			while( (len = fis.read(buff)) != -1) {
				sos.write(buff, 0, len);
			}
			
			sos.close();
			fis.close();
		}
	}
}
