/*******************************************************************************
 * Copyright (c) 2004, 2005 Jean-Michel Lemieux, Jeff McAffer and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Hyperbola is an RCP application developed for the book 
 *     Eclipse Rich Client Platform - 
 *         Designing, Coding, and Packaging Java Applications 
 *
 * Contributors:
 *     Jean-Michel Lemieux and Jeff McAffer - initial implementation
 *******************************************************************************/
package org.eclipsercp.hyperbola;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Add roster entry dialog, which prompts for the entry details.
 */
public class AddContactDialog extends Dialog {

	private Text userIdText;

	private Text serverText;

	private Text nicknameText;

	private String userId;

	private String server;

	private String nickname;

	public AddContactDialog(Shell parentShell) {
		super(parentShell);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Add Contact");
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);

		Label userIdLabel = new Label(composite, SWT.NONE);
		userIdLabel.setText("&User id:");
		userIdLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER,
				false, false));

		userIdText = new Text(composite, SWT.BORDER);
		userIdText.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, false));

		Label serverLabel = new Label(composite, SWT.NONE);
		serverLabel.setText("&Server:");
		serverLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER,
				false, false));

		serverText = new Text(composite, SWT.BORDER);
		serverText.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
				true, false));

		Label nicknameLabel = new Label(composite, SWT.NONE);
		nicknameLabel.setText("&Nickname:");
		nicknameLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER,
				false, false));

		nicknameText = new Text(composite, SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true,
				false);
		gridData.widthHint = convertHeightInCharsToPixels(20);
		nicknameText.setLayoutData(gridData);

		return composite;
	}

	protected void okPressed() {
		nickname = nicknameText.getText();
		server = serverText.getText();
		userId = userIdText.getText();

		if (nickname.equals("")) {
			MessageDialog.openError(getShell(), "Invalid Nickname",
					"Nickname field must not be blank.");
			return;
		}
		if (server.equals("")) {
			MessageDialog.openError(getShell(), "Invalid Server",
					"Server field must not be blank.");
			return;
		}
		if (userId.equals("")) {
			MessageDialog.openError(getShell(), "Invalid User id",
					"User id field must not be blank.");
			return;
		}

		super.okPressed();
	}

	public String getUserId() {
		return userId;
	}

	public String getServer() {
		return server;
	}

	public String getNickname() {
		return nickname;
	}
}
