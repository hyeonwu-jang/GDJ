package com.gdu.contact.service;

import java.util.List;

import com.gdu.contact.domain.ContactDTO;

public interface ContactService {
	
	public List<ContactDTO> findAllContacts();
	public ContactDTO findContact(int no);
	public int addContacts(ContactDTO contact);
	public int modifyContacts(ContactDTO contact);
	public int removeContacts(int no);
	
}
