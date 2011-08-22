package org.eclipsercp.hyperbola.core;

import static org.junit.Assert.*;

import org.eclipsercp.hyperbola.model.ContactsGroup;
import org.junit.Test;

public class ContactsGroup_Test {

	@Test
	public void sometest() throws Exception {
		assertEquals("name", new ContactsGroup(null , "name").getName());
	}
}
