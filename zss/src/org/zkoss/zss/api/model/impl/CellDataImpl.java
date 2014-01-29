/* CellDataImpl.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		2013/5/1 , Created by dennis
}}IS_NOTE

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zss.api.model.impl;

import java.util.Date;

import org.zkoss.zss.api.impl.RangeImpl;
import org.zkoss.zss.api.model.CellData;
import org.zkoss.zss.ngapi.NRange;
import org.zkoss.zss.ngmodel.NCell;
import org.zkoss.zss.ngmodel.NSheet;
/**
 * 
 * @author dennis
 * @since 3.0.0
 */
public class CellDataImpl implements CellData{

	private RangeImpl _range;
	
	private NCell _cell;
	private boolean _cellInit;
	
	public CellDataImpl(RangeImpl range) {
		this._range = range;
	}

	@Override
	public int getRow() {
		return _range.getRow();
	}

	@Override
	public int getColumn() {
		return _range.getColumn();
	}

	private void initCell(){
		if(_cellInit){
			return;
		}
		_cellInit = true;
		NRange x = _range.getNative();
		NSheet sheet = x.getSheet();
		
		_cell = sheet.getCell(x.getRow(),x.getColumn());
	}
	

	@Override
	public CellType getResultType() {
		CellType type = getType();
		
		if(type != CellType.FORMULA){
			return type;
		}
		
		return toCellType(_cell.getFormulaResultType());
	}
	
	private CellType toCellType(NCell.CellType type){
		switch(type){
		case BLANK:
			return CellType.BLANK;
		case BOOLEAN:
			return CellType.BOOLEAN;
		case ERROR:
			return CellType.ERROR;
		case FORMULA:
			return CellType.FORMULA;
		case NUMBER:
			return CellType.NUMERIC;
		case STRING:
			return CellType.STRING;
		}
		return CellType.BLANK;
	}
	
	@Override
	public CellType getType() {
		initCell();
		
		if(_cell.isNull()){
			return CellType.BLANK;
		}
		
		CellType type = toCellType(_cell.getType());
		
		if(type==CellType.FORMULA){
			if(toCellType(_cell.getFormulaResultType())==CellType.ERROR){
				return CellType.ERROR;
			}
		}
		return type;
	}

	@Override
	public Object getValue() {
		return _range.getCellValue();
	}

	@Override
	public String getFormatText() {
		return _range.getCellFormatText();
	}

	@Override
	public String getEditText() {
		return _range.getCellEditText();
	}

	@Override
	public void setValue(Object value) {
		_range.setCellValue(value);
	}

	@Override
	public void setEditText(String editText) {
		_range.setCellEditText(editText);
	}

	public boolean validateEditText(String editText){
		return _range.getNative().validate(editText)==null;
	}

	@Override
	public boolean isBlank() {
		return getType() == CellType.BLANK;
	}

	@Override
	public boolean isFormula() {
		return getType() == CellType.FORMULA;
	}

	@Override
	public Double getDoubleValue() {
		initCell();
		return _cell.getNumberValue().doubleValue();
	}

	@Override
	public Date getDateValue() {
		initCell();
		return _cell.getDateValue();
	}

	@Override
	public String getStringValue() {
		initCell();
		return _cell.getStringValue();
	}

	@Override
	public Boolean getBooleanValue() {
		initCell();
		return _cell.getBooleanValue();
	}
}