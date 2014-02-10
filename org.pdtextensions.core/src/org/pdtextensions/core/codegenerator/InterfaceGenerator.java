/*******************************************************************************
 * Copyright (c) 2014 The PDT Extension Group (https://github.com/pdt-eg)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package org.pdtextensions.core.codegenerator;

import org.eclipse.php.internal.core.ast.nodes.InterfaceDeclaration;
import org.eclipse.php.internal.core.ast.nodes.Statement;

@SuppressWarnings("restriction")
public class InterfaceGenerator extends ElementGenerator {

	public InterfaceGenerator() throws Exception {
		super();
	}

	@Override
	protected Statement generateElementNode() {
		InterfaceDeclaration interfaceModel = ast.newInterfaceDeclaration();
		interfaceModel.setName(ast.newIdentifier(name));
		interfaceModel.setBody(ast.newBlock());

		for (String interfaceName : interfaces) {
			if (interfaceName.lastIndexOf("\\") != 0) {
				interfaceName = interfaceName.substring(interfaceName.lastIndexOf("\\") + 1);
			}
			interfaceModel.interfaces().add(ast.newIdentifier(interfaceName));
		}

		return interfaceModel;
	}
}