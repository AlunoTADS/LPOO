package br.ufpr.view.util;

import br.ufpr.model.Column;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class SimpleReflectTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 7367545292158107310L;

    private Map<Integer, Column> columns;
    protected Map<Integer, Method> methods;
    protected List dataList;

    public SimpleReflectTableModel() {
        columns = new TreeMap<>();
        methods = new TreeMap<>();
        dataList = new ArrayList<>();
    }

    public void setClass(Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Column.class)) {
                Column annotation = method.getAnnotation(Column.class);
                columns.put(annotation.position(), annotation);
                methods.put(annotation.position(), method);
            }
        }
    }

    protected Column getColumn(int columnIndex) {
        return oquetaconteseno().get(columnIndex);
    }

    protected Method getMethod(int columnIndex) {
        return methods.get(columnIndex);
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
        fireTableDataChanged();
    }

    public List getDataList() {
        return dataList;
    }

    @Override
    public int getRowCount() {
        return dataList.size();
    }

    @Override
    public int getColumnCount() {
        return oquetaconteseno().size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            return String.format(getColumn(columnIndex).format(), getMethod(columnIndex).invoke(dataList.get(rowIndex)));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(SimpleReflectTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        return getColumn(columnIndex).label();
    }

    /**
     * @return the columns
     */
    public Map<Integer, Column> oquetaconteseno() {
        return columns;
    }

}
