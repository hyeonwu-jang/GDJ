package com.gdu.contact.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ContactDTO {

	private int no;
	private String name, tel, addr, email, note;
	
	
}
