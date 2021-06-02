package kpu.club.persistence;

import kpu.club.domain.*;

import java.sql.*;
import java.util.ArrayList;


public class MemberDAO{
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	String jdbc_url ="jdbc:mysql://localhost/jspdb?useSSL=false&serverTimezone=UTC";
	
	void connect() {
	try {
	Class.forName(jdbc_driver);
	conn = DriverManager.getConnection(jdbc_url,"jspbook","passwd");
	} catch(Exception e) {
	e.printStackTrace();
	}
	}
	
	void disconnect() {
	if(pstmt != null) {
	try {
	pstmt.close();
	} catch(SQLException e) {
	e.printStackTrace();
	}
	}
	if(conn != null) {
	try {
	conn.close();
	} catch(SQLException e) {
	e.printStackTrace();
	}
	}

}
	
	public boolean add( PetVO ab ) {
		connect();
		String sql = "insert into pet values (?,?,?,?,?,?,?)";
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ab.getId());
		pstmt.setString(2, ab.getPet_name());
		pstmt.setString(3, ab.getPet_sex());
		pstmt.setString(4, ab.getKind());
		pstmt.setString(5, ab.getOwner_name());
		pstmt.setString(6, ab.getMobile());
		pstmt.setString(7, ab.getAddress());
		pstmt.executeUpdate();
		} catch(SQLException e) {
		e.printStackTrace();
		return false;
		} finally {
		disconnect();
		}
		return true;
		}
	
		public ArrayList<PetVO>getpetList() {
		connect();
		ArrayList<PetVO> petList = new ArrayList<PetVO>();
		String sql = "select * from pet";
		try {
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
		PetVO ab = new PetVO();
		
		ab.setId(rs.getString("id"));
		ab.setPet_name(rs.getString("pet_name"));
		ab.setPet_sex(rs.getString("pet_sex"));
		ab.setKind(rs.getString("kind"));
		ab.setOwner_name(rs.getString("owner_name"));
		ab.setMobile(rs.getString("mobile"));
		ab.setAddress(rs.getString("address"));
		
		petList.add(ab);
		}
		rs.close();
		} catch(SQLException e) {
		e.printStackTrace();
		} finally {
		disconnect();
		}
		return petList;
		}
		
		
		public PetVO read(String id) {
			// TODO Auto-generated method stub
			connect();

			PetVO ab =null;
			
			String sql = "select * from pet where id=?";
			
			try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
				ab= new PetVO();
				ab.setId(rs.getString("id"));
				ab.setPet_name(rs.getString("pet_name"));
				ab.setPet_sex(rs.getString("pet_sex"));
				ab.setKind(rs.getString("kind"));
				ab.setOwner_name(rs.getString("owner_name"));
				ab.setMobile(rs.getString("mobile"));
				ab.setAddress(rs.getString("address"));

				}
				
				rs.close();
				} catch(SQLException e) {
				e.printStackTrace();
				} finally {
				disconnect();
				}
				
				return ab;
				
				}
		
		
		public boolean update(PetVO ab) {
			// TODO Auto-generated method stub
			connect();
			String sql = "update pet set pet_name=?, pet_sex=?, kind=?, owner_name=?, mobile=?, address=? where id=?";
			try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ab.getPet_name() );	
			pstmt.setString(2, ab.getPet_sex() );	
			pstmt.setString(3, ab.getKind());
			pstmt.setString(4, ab.getOwner_name());
			pstmt.setString(5, ab.getMobile());
			pstmt.setString(6, ab.getAddress());
			pstmt.setString(7, ab.getId());
			
			pstmt.executeUpdate();
			
			} catch(SQLException e) {
			e.printStackTrace();
			return false;
			} finally {
			disconnect();
			}
			return true;
		}
		
		public boolean delete(PetVO ab) {
			// TODO Auto-generated method stub
			connect();
			String sql = "delete from pet where id=?";
			try {
			pstmt = conn.prepareStatement(sql);
			//뭔가를 해줘야하나?
			pstmt.setString(1, ab.getId());	
			pstmt.executeUpdate();
			
			} catch(SQLException e) {
			e.printStackTrace();
			} finally {
			disconnect();
			}
			return true;
		
		}
	
}

