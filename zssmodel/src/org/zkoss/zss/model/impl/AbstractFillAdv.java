/* AbstractFillAdv.java

	Purpose:
		
	Description:
		
	History:
		Mar 31, 2015 6:04:04 PM, Created by henrichen

	Copyright (C) 2015 Potix Corporation. All Rights Reserved.
*/

package org.zkoss.zss.model.impl;

import java.io.Serializable;

import org.zkoss.zss.model.SBook;
import org.zkoss.zss.model.SColor;
import org.zkoss.zss.model.SFill;

/**
 * @author henri
 * @since 3.8
 */
public abstract class AbstractFillAdv implements SFill, Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * gets the string key of this font, the key should combine all the style value in short string as possible
	 */
	abstract String getStyleKey();
	
	//ZSS-1145
	//@since 3.8.2
	public abstract SColor getRawFillColor();

	//ZSS-1145
	//@since 3.8.2
	public abstract SColor getRawBackColor();

	//ZSS-1145
	//@since 3.8.2
	public abstract FillPattern getRawFillPattern();
	
	//ZSS-1183
	//@since 3.9.0
	/*package*/ abstract SFill cloneFill(SBook book);
}
