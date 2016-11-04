/*
 * Created on 29/08/2007 00:30:07
 * 
 * History
 * =======
 *    Date    Description
 * ---------- ----------------------------------------------------------------------------
 *
 */
package br.ufpr.view;

import com.elisha.commons.ui.table.t2.ReflectTableModelManager;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.elisha.commons.util.StringUtil;
import com.elisha.commons.util.TypesUtil;

/**
 * @author Douglas Granzotto
 * @version 1.0
 */
public class ReflectTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 7367545292158107310L;
    
    protected Method[] getMethods = null;
    protected Method[] setMethods = null;
    protected String[] columnLabels = null;
    protected String[] columnNames = null;
    protected Class[] columnClasses = null;
    protected boolean[] editableColumns = null;
    protected Class clazz = null;
    protected List dataList = null;
    protected ReflectTableModelManager tableModelManager;

    
    public ReflectTableModel(String columnNames[], Class clazz) {
        this(null, columnNames, null, null, clazz);
    }

    public ReflectTableModel(String columnLabels[], String columnNames[], Class clazz) {
        this(columnLabels, columnNames, null, null, clazz);
    }

    public ReflectTableModel(String columnLabels[], String columnNames[], Class columnClasses[], Class clazz) {
        this(columnLabels, columnNames, columnClasses, null, clazz);
    }

    public ReflectTableModel(String[] columnLabels, String[] columnNames, Class[] columnClasses, boolean[] editableColumns, Class clazz) {
        try {
            this.columnLabels = columnLabels;
            this.columnNames = columnNames;
            this.columnClasses = columnClasses;
            boolean noColumnClasses = (columnClasses == null);
            if (noColumnClasses) {
                this.columnClasses = new Class[columnNames.length];
            }
            this.editableColumns = editableColumns;
            this.clazz = clazz;
            getMethods = new Method[columnNames.length];
            setMethods = new Method[columnNames.length];
            for (int i = 0; i < columnNames.length; i++) {
                String uField = StringUtil.toFirstLetterUpperCase(columnNames[i]);
                try {
                    getMethods[i] = clazz.getMethod("get" + uField, (Class[]) null);
                } catch (NoSuchMethodException e) {
                    getMethods[i] = clazz.getMethod("is" + uField, (Class[]) null);
                }
                Class rt = getMethods[i].getReturnType();
                setMethods[i] = clazz.getMethod("set" + uField, new Class[]{rt});
                if (noColumnClasses) {
                    if (rt.isPrimitive()) {
                        this.columnClasses[i] = TypesUtil.primitiveJavaClassToWrapperClass(rt);
                    } else {
                        this.columnClasses[i] = rt;
                    }
                }
            }
            this.tableModelManager = new ReflectTableModelManager();
            this.tableModelManager.setTableModel(this);
        } catch (SecurityException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnLabels != null) {
            return columnLabels[columnIndex];
        } else {
            return columnNames[columnIndex];
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return dataList.size();
    }

    public Object getRow(int rowIndex) {
        return dataList.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = null;
        try {
            Object object = dataList.get(rowIndex);
            value = getMethods[columnIndex].invoke(object, (Object[]) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Object object = dataList.get(rowIndex);
            setMethods[columnIndex].invoke(object, new Object[]{aValue});
            fireTableCellUpdated(rowIndex, columnIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return tableModelManager.isCellEditable(rowIndex, columnIndex);
    }

    public void addObject(Object object) {
        dataList.add(object);
        int row = dataList.size() - 1;
        fireTableRowsInserted(row, row);
    }

    public void insertObjectAtRow(Object object, int rowIndex) {
        dataList.add(rowIndex, object);
        fireTableRowsInserted(rowIndex, rowIndex);
    }
    
    public void updateObjectAtRow(Object object, int rowIndex) {
        dataList.set(rowIndex, object);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void removeObjectAtRow(int rowIndex) {
        dataList.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void refreshRow(int rowIndex) {
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void refreshRows(int firstRowIndex, int lastRowIndex) {
        if (firstRowIndex < 0 || lastRowIndex < 0) {
            fireTableDataChanged();
        } else {
            fireTableRowsUpdated(firstRowIndex, lastRowIndex);
        }
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
        fireTableDataChanged();
    }

    public List getDataList() {
        return dataList;
    }

    public void setEditableColumns(boolean[] editableColumns) {
        this.editableColumns = editableColumns;
    }

    public void setColumnEditable(int columnIndex, boolean editable) {
        if (editableColumns != null && columnIndex > 0 && columnIndex < editableColumns.length) {
            editableColumns[columnIndex] = editable;
        }
    }

    public void setTableModelManager(ReflectTableModelManager tableModelManager) {
        this.tableModelManager = tableModelManager;
        this.tableModelManager.setTableModel(this);
    }
    
    public int indexOf(Object object) {
        return dataList.indexOf(object);
    }
    
    public int lastIndexOf(Object object) {
        return dataList.lastIndexOf(object);
    }
    
}
