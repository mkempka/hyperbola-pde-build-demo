/*******************************************************************************
 * Copyright (c) 2005 Jean-Michel Lemieux, Jeff McAffer and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Hyperbola is an RCP application developed for the book
 *     Eclipse Rich Client Platform - 
 *         Designing, Coding, and Packaging Java Applications
 * See http://eclipsercp.org
 *
 * Contributors:
 *     Jean-Michel Lemieux and Jeff McAffer - initial API and implementation
 *******************************************************************************/
package org.eclipsercp.hyperbola;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;
import org.eclipsercp.hyperbola.model.Contact;
import org.eclipsercp.hyperbola.model.ContactsEntry;
import org.eclipsercp.hyperbola.model.ContactsGroup;
import org.eclipsercp.hyperbola.model.IContactsListener;
import org.eclipsercp.hyperbola.model.Session;

public class ContactsView extends ViewPart {

	public static final String ID = "org.eclipsercp.hyperbola.views.contacts";

	private TreeViewer treeViewer;

	private Session session;

	private IAdapterFactory adapterFactory = new HyperbolaAdapterFactory();

	public ContactsView() {
		super();
	}

	public void createPartControl(Composite parent) {
		initializeSession(); // temporary tweak to build a fake model
		treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI
				| SWT.V_SCROLL);
		getSite().setSelectionProvider(treeViewer);
		Platform.getAdapterManager().registerAdapters(adapterFactory, Contact.class);
		treeViewer.setLabelProvider(new WorkbenchLabelProvider());
		treeViewer.setContentProvider(new BaseWorkbenchContentProvider());
		treeViewer.setInput(session.getRoot());
		session.getRoot().addContactsListener(new IContactsListener() {
			public void contactsChanged(ContactsGroup contacts,
					ContactsEntry entry) {
				treeViewer.refresh();
			}
		});
	}
	
	public void dispose() {
		Platform.getAdapterManager().unregisterAdapters(adapterFactory);
		super.dispose();
	}

	private void initializeSession() {
		session = new Session();
		ContactsGroup root = session.getRoot();
		ContactsGroup friendsGroup = new ContactsGroup(root, "Friends");
		root.addEntry(friendsGroup);
		friendsGroup.addEntry(new ContactsEntry(friendsGroup, "Alize", "aliz",
				"localhost"));
		friendsGroup.addEntry(new ContactsEntry(friendsGroup, "Sydney", "syd",
				"localhost"));
		ContactsGroup otherGroup = new ContactsGroup(root, "Other");
		root.addEntry(otherGroup);
		otherGroup.addEntry(new ContactsEntry(otherGroup, "Nadine", "nad",
				"localhost"));
	}

	public void setFocus() {
		treeViewer.getControl().setFocus();
	}
}
