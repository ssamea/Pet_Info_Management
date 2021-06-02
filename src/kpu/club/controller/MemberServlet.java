package kpu.club.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kpu.club.domain.PetVO;
import kpu.club.persistence.MemberDAO;

/**
 * Servlet implementation class MemberServlet
 */

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset-UTF-8 "); 
	//	response.getWriter().append("Served at: ").append(request.getContextPath());

		String cmd="";
		cmd = request.getParameter("key");
		 
		if(cmd.equals("join")) {
		 response.sendRedirect("register.html");	
		}
		
		else if(cmd.equals("list")) {
		MemberDAO dao=new MemberDAO();
		ArrayList<PetVO> petList=dao.getpetList();
		request.setAttribute("petList", petList);
		RequestDispatcher view =request.getRequestDispatcher("pet_list.jsp");
        view.forward(request, response);
	}
		
		else if(cmd.equals("update")){
			MemberDAO dao=new MemberDAO();
			PetVO pet=dao.read(request.getParameter("id"));
			request.setAttribute("pet", pet);
			RequestDispatcher view =request.getRequestDispatcher("update.jsp");
	        view.forward(request, response);
		}
		
		
		else if(cmd.equals("delete")) {
			MemberDAO dao=new MemberDAO();
			PetVO pet=dao.read(request.getParameter("id"));
			request.setAttribute("pet", pet);
			RequestDispatcher view =request.getRequestDispatcher("delete.jsp");
	        view.forward(request, response);
		}
		
		
	}
	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-UTF-8"); 
	
		
		String cmd="";
		String message;
		cmd = request.getParameter("key");
		 
		if(cmd.equals("join")) {

			PetVO petVO= new PetVO();
			
			petVO.setId(request.getParameter("id"));
			petVO.setPet_name(request.getParameter("pet_name"));
			petVO.setPet_sex(request.getParameter("pet_sex"));
			petVO.setKind(request.getParameter("kind"));
			petVO.setOwner_name(request.getParameter("owner_name"));
			petVO.setMobile(request.getParameter("mobile"));
			petVO.setAddress(request.getParameter("address"));
			
			MemberDAO memDAO =new MemberDAO();
			//memDAO.join(PetVO);
		    
		
			if(memDAO.add(petVO)) {
				message="가입축하합니다";
			}
			else message="가입 실패입니다";
			

			request.setAttribute("message", message);
			request.setAttribute("pet", petVO);
			
		    RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}
	
		else if(cmd.equals("update")) {
			PetVO petVO= new PetVO();
			
			petVO.setId(request.getParameter("id"));
			petVO.setPet_name(request.getParameter("pet_name"));
			petVO.setPet_sex(request.getParameter("pet_sex"));
			petVO.setKind(request.getParameter("kind"));
			petVO.setOwner_name(request.getParameter("owner_name"));			
			petVO.setMobile(request.getParameter("mobile"));
			petVO.setAddress(request.getParameter("address"));
			
			MemberDAO dao=new MemberDAO();
			
			if(dao.update(petVO)) {
				message="수정이 완료되었습니다.";
			}
			else message="수정 실패입니다";
			request.setAttribute("message", message);
			request.setAttribute("pet", petVO);
			
		    RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		}
		
		else if(cmd.equals("login")) {
			String id="root";
			String passwd="passwd";
			//PetVO PetVO= new PetVO();
			
			if(id.equals(request.getParameter("root_id"))&&passwd.equals(request.getParameter("root_passwd"))) {
				RequestDispatcher view = request.getRequestDispatcher("welcom.html");
				view.forward(request, response);
			}
			else {
				response.setContentType("text/html;charset=utf-8"); // 어떤 타입으로 출력할것인지 명시하였다.

				PrintWriter out=response.getWriter(); //getWriter() 출력스트림. 응답할 정보를 갖고 있는 객체에 출력스트림을 써서 out 객체에 담았다.

				out.println("<script>");
				out.println("alert('아이디 또는 패스워드가 틀렸습니다!!!');");
				out.println("history.back();");
				out.println("</script>");

			}
		}
		
		 else if(cmd.equals("delete")) {
			
		     //PetVO petVO=(PetVO)request.getAttribute("pet");
	         MemberDAO dao=new MemberDAO();
	         PetVO petVO= new PetVO();
				
			petVO.setId(request.getParameter("id"));

	            if(dao.delete(petVO)) {
					message="삭제가 완료되었습니다.";
				}
				else message="삭제 실패입니다";
	            
	            request.setAttribute("message", message);
				request.setAttribute("pet", petVO);
				
			    RequestDispatcher view = request.getRequestDispatcher("result2.jsp");
				view.forward(request, response);
	        }
	     
	}

}
