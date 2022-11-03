package com.gdu.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdu.contact.domain.ContactDTO;
import com.gdu.contact.repository.ContactDAO;


public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDAO dao;
	
	@Override
	public List<ContactDTO> findAllContacts() {
		return dao.selectAllContacts();
	}

	@Override
	public ContactDTO findContact(int no) {
		return dao.selectContact(no);
	}

	@Override
	public int addContacts(ContactDTO contact) {
		return dao.insertContact(contact);
	}

	@Override
	public int modifyContacts(ContactDTO contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeContacts(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
