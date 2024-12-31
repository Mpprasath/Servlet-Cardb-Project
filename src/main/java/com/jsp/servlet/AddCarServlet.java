package com.jsp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/add-car")
public class AddCarServlet extends  HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("carId"));
		String model=req.getParameter("carModel");
		String brand=req.getParameter("carBrand");
		String color=req.getParameter("carColor");
		int price=Integer.parseInt(req.getParameter("carPrice"));

		Connection conn=null;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_cardb","root","root");
			
			PreparedStatement ps=conn.prepareStatement("insert into car values(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, model);
			ps.setString(3, brand);
			ps.setString(4, color);
			ps.setInt(5, price);
			ps.executeUpdate();
			
		    resp.sendRedirect("index.jsp");
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
