package com.jsp.servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Display-cars")
public class DisplayAllCars extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb","root","root");
			PreparedStatement ps=conn.prepareStatement("select * from car");
			ResultSet rs=ps.executeQuery();
//			PrintWriter pw=resp.getWriter();
//			pw.write("CarId"+"\t"+"CarModel"+"\t"+"CarBrand"+"\t"+"CarColor"+"\t"+"Carprice"+"\n");
//			while(rs.next()) {
//				pw.write(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+"\n");     	
//			}

			req.setAttribute("resultSet", rs);
			req.getRequestDispatcher("displaycar.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
