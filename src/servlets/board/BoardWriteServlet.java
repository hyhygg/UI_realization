package servlets.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.BoardDao;
import dao.MemberDao;
import vo.Board;
import vo.FileDTO;
import vo.Member;


@SuppressWarnings("serial")
@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
   
   String user_email = "";
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      RequestDispatcher rd = req.getRequestDispatcher
                     ("write.jsp");
      rd.forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      resp.setContentType("text/html;charset=UTF-8");
      
      HttpSession session = (HttpSession)req.getSession();
      Member member = (Member)session.getAttribute("member");
      user_email = member.getEmail();
      
   
      PrintWriter out = resp.getWriter();
      out.println("<html><head><title>file upload Test" +
            "</title></head><body>"); //  강사님 코드 - 우리도 필요한가?
      
      try {
         ServletContext sc = this.getServletContext();
         BoardDao boardDao = (BoardDao)sc.getAttribute("boardDao");
         MemberDao memberDao = (MemberDao)sc.getAttribute("memberDao");
         
       // 이미지 파일 업로드 ㄱ
         // D드라이브 프로젝트 실제경로 얻기
         String contextRootPath = this.getServletContext().getRealPath("/");
         System.out.println("contextRootPath: " + contextRootPath);
         //파일 보관 객체
         DiskFileItemFactory diskFactory = new DiskFileItemFactory();
         //임시 저장 경로
         diskFactory.setRepository(
               new File(contextRootPath + "/WEB-INF/temp"));
         //요청 처리 객체
         ServletFileUpload upload = new ServletFileUpload(diskFactory);
         // 최대 업로드 파일 크기 제한시(예시는 10MB)
         // upload.setSizeMax(1024*1024*10)
         
         
         // 업로드 요청을 바꿔 파일아이템 목록 구하기
         @SuppressWarnings("unchecked")
         List<FileItem> items = upload.parseRequest(req);
         
         String imageFileName = "";
         Board board = new Board();
         
         FileItem item = null;
         for(int i=0;i<items.size();i++) {
            item = items.get(i);
            // 업로드 파일이 파일인지 일반변수인지에 따라 if문으로 분기
            if(!item.isFormField()) { 
               imageFileName = processUploadFile(out, item, contextRootPath);
               break;
            }
         }

         System.out.println("imageUrl : " + imageFileName);
         Member mem = memberDao.selectOne(new Member().setEmail(user_email));
         Board bo = new Board();
         bo.setImageUrl(imageFileName);
         bo.setNo(mem.getNo());
         bo.setWriter(mem.getName());
         
         for(int i=0;i<items.size();i++) {
            item = items.get(i);

            if(item.isFormField()) {
               String name = item.getFieldName(); // 변수명
               String value = item.getString("UTF-8"); // 변수값
               
               if(name.equals("genre"))
                  bo.setGenre(value);
               else if(name.equals("movieTitle"))
                bo.setMovieTitle(value);
               else if(name.equals("director"))
                  bo.setDirector(value);
               else if(name.equals("title"))
                  bo.setTitle(value);
               else if(name.equals("content"))
                  bo.setContent(value);
            }
         }
         
         boardDao.insert(bo);
         
      }catch(Exception e) {
         e.printStackTrace();
         req.setAttribute("error", e);
         RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
         rd.forward(req, resp);
      }
      
      out.println("</body></html>"); // 우리도 필요한가?
   }
   
   
   // 파일을 dopost에서 처리하는 메소드
   private String processUploadFile(PrintWriter out, FileItem item, String contextRootPath) throws Exception{
      String name = item.getFieldName(); // name(변수명, 필드이름) 받아오기
      String fileName = item.getName(); // 유저가 올린 파일의 이름 받기
      String contentType = item.getContentType(); // 유저가 올린 파일의 확장자
      long fileSize = item.getSize(); // 유저가 올린 파일 용량(*바이트표기?)
      
      // 저장명(유저가 올린 파일을 서버 폴더에 저장할 때 지정할 이름)을 바꿔 파일객체 생성
      String uploadedFileName =  "Boogie_" + user_email + "_" + System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf(".")); 
      System.out.println("저장파일 이름 : " + uploadedFileName);
      File uploadedFile = new File(contextRootPath + "/upload/" + uploadedFileName);
      item.write(uploadedFile);
      
      out.println("<p>");
      out.println("파라미터 이름 : " + name + "<br/>");
      out.println("파일 이름 : " + fileName + "<br/>");
      out.println("콘텐츠 타입 : " + contentType + "<br/>");
      out.println("파일 크기 : " + fileSize + "<br/>");
      out.println("<img src='./upload/" + uploadedFileName
            + "' width='500'><br>");
      out.println("</p>");
      
      return uploadedFileName;
   }
      
 

}
