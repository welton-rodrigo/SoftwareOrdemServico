package br.com.wrs.servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig(
		fileSizeThreshold=1024*1024*10, //10MB
		maxFileSize=1024*1024*50, //50mb
		maxRequestSize=1024*1024*100 //100mb
		)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  private static final String UPLOAD_DIR = "uploads";
	
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // obtem o caminho completo
        String applicationPath = request.getServletContext().getRealPath("dados");
        
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        
     // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        System.out.println(fileSaveDir);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        
 //welton  System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
        
        String fileName = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(uploadFilePath + File.separator + fileName);
        }
        int idrow_sessao = (Integer) request.getSession().getAttribute("idrow");
        request.setAttribute("message", fileName + " Arquivo anexado com sucesso!!");
        response.sendRedirect("AbrirTicketServlet?idTicketRow=" + idrow_sessao + "");
    }
	 /**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
   //welton     System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
	}


