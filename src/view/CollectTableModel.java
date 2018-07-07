package view;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class CollectTableModel extends AbstractTableModel {
	 String[] columnNames = {"编号","单词","意思","例句","翻译","选择"};
	 Object[][] data ;
	 int i = 0;
	 
	 public CollectTableModel(int rowCount) {
		 data = new Object[rowCount][];
	 }
	 public void setRowData(Object[] row){
		 data[i++] = row;
	 }
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	@Override
	public int getRowCount() {
		return data.length;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return data[0][columnIndex].getClass();  
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex >=5)
			return true;
		return false;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = aValue;  
        /*通知监听器数据单元数据已经改变*/  
        fireTableCellUpdated(rowIndex, columnIndex);  
	}

}
