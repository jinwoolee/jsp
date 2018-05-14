package fileUpload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FileUploadAbsolutePathServlet
 */
@WebServlet("/fileUploadAbsolutePathServlet")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*3*5)
public class FileUploadAbsolutePathServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(FileUploadAbsolutePathServlet.class);
	private final String UPLOAD_STORAGE = "/Applications/ljw/server/uploadStorage";
	
	private static final long serialVersionUID = 1L;
	
    public FileUploadAbsolutePathServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramText = request.getParameter("paramText");
		logger.debug("paramText : {}", paramText);
		
		
		Part filePart = request.getPart("paramFile");
		String fileName = null;
		String uuidFileName = null;
		if(filePart.getSize() > 0) {
			String contentDisposition = filePart.getHeader("Content-Disposition");
			fileName = getFileName(contentDisposition);
			uuidFileName = UUID.randomUUID().toString();
			filePart.write(UPLOAD_STORAGE + File.separator + uuidFileName);
		}
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("fileName : " + fileName + "<br/>");
		pw.write("uuidFileName : " + uuidFileName + "<br/>");
	}
	
	private String getFileName(String contentDisposition) {
		String[] contentDispositionSplit = contentDisposition.split(";");
		String fileName = null;
		
		for(String str : contentDispositionSplit) {
			if(str.startsWith(" filename")) {
				fileName = str.substring(str.indexOf("=")+1).replace("\"", "");
			}
		}
		
		logger.debug("fileName : ", fileName);
		
		return fileName;
	}

}
