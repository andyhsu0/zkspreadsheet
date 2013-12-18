/*

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		2013/12/01 , Created by dennis
}}IS_NOTE

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zss.ngmodel;

import java.util.Iterator;
/**
 * 
 * @author dennis
 * @since 3.5.0
 */
public interface NRow {

	public NSheet getSheet();
	
	public int getIndex();
//	public String asString();
	public boolean isNull();
	public NCellStyle getCellStyle();
	
	//editable
	public void setCellStyle(NCellStyle cellStyle);
	
	public int getHeight();
	public boolean isHidden();
	
	public void setHeight(int height);
	public void setHidden(boolean hidden);
}
