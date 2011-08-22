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

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class ChatEditorInput implements IEditorInput {
	private String participant;

	public ChatEditorInput(String participant) {
		super();
		Assert.isNotNull(participant);
		this.participant = participant;
	}

	public boolean exists() {
		return false;
	}

	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	public String getName() {
		return participant;
	}

	public IPersistableElement getPersistable() {
		return null;
	}

	public boolean equals(Object obj) {
		if (super.equals(obj))
			return true;
		if (!(obj instanceof ChatEditorInput))
			return false;
		ChatEditorInput other = (ChatEditorInput) obj;
		return this.participant.equals(other.participant);
	}

	public int hashCode() {
		return participant.hashCode();
	}

	public String getToolTipText() {
		return participant;
	}

	public Object getAdapter(Class adapter) {
		return null;
	}
}
