package com.gdu.contact.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gdu.contact.domain.ContactDTO;

public class ContactDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	private void close() {
		try {
			if(rs != null) { rs.close(); }
			if(ps != null) { ps.close(); }
			if(con != null) { con.close(); }
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ContactDTO> selectAllContacts() {
		List<ContactDTO> contacts = new ArrayList<ContactDTO>();
		try {
			con = getConnection();
			String sql = "SELECT NO, NAME, TEL, ADDR, EMAIL, NOTE FROM CONTACT";
			ps = con.prepareStatement(sql);			
			rs = ps.executeQuery();
			while(rs.next()) {
				ContactDTO contact = new ContactDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				contacts.add(contact);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return contacts;
	}
	
	public ContactDTO selectContact(int no) {
		ContactDTO contact = new ContactDTO();
		try {
			con = getConnection();
			String sql = "SELECT NO, NAME, TEL, ADDR, EMAIL, NOTE FROM CONTACT WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				contact = new ContactDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return contact;
	}
	
	public int insertContact(ContactDTO contact) {
		int result = 0;
		try {
			con = getConnection();
			String sql = "INSERT INTO CONTACT VALUES(CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getAddr());
			ps.setString(4, contact.getEmail());
			ps.setString(5, contact.getNote());
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
//	public int updateContact(ContactDTO contact) {
//		
//	}
	
	
	
	
	
}
