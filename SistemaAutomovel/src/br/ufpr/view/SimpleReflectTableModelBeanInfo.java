/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.view;

import java.beans.*;

/**
 *
 * @author Lucas
 */
public class SimpleReflectTableModelBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( br.ufpr.view.SimpleReflectTableModel.class , null ); // NOI18N//GEN-HEADEREND:BeanDescriptor
        // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor


    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_columnClass = 0;
    private static final int PROPERTY_columnCount = 1;
    private static final int PROPERTY_columnName = 2;
    private static final int PROPERTY_dataList = 3;
    private static final int PROPERTY_rowCount = 4;
    private static final int PROPERTY_tableModelListeners = 5;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[6];
    
        try {
            properties[PROPERTY_columnClass] = new IndexedPropertyDescriptor ( "columnClass", br.ufpr.view.SimpleReflectTableModel.class, null, null, "getColumnClass", null ); // NOI18N
            properties[PROPERTY_columnCount] = new PropertyDescriptor ( "columnCount", br.ufpr.view.SimpleReflectTableModel.class, "getColumnCount", null ); // NOI18N
            properties[PROPERTY_columnName] = new IndexedPropertyDescriptor ( "columnName", br.ufpr.view.SimpleReflectTableModel.class, null, null, "getColumnName", null ); // NOI18N
            properties[PROPERTY_dataList] = new PropertyDescriptor ( "dataList", br.ufpr.view.SimpleReflectTableModel.class, "getDataList", "setDataList" ); // NOI18N
            properties[PROPERTY_rowCount] = new PropertyDescriptor ( "rowCount", br.ufpr.view.SimpleReflectTableModel.class, "getRowCount", null ); // NOI18N
            properties[PROPERTY_tableModelListeners] = new PropertyDescriptor ( "tableModelListeners", br.ufpr.view.SimpleReflectTableModel.class, "getTableModelListeners", null ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties
        // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties

    // EventSet identifiers//GEN-FIRST:Events
    private static final int EVENT_tableModelListener = 0;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[1];
    
        try {
            eventSets[EVENT_tableModelListener] = new EventSetDescriptor ( br.ufpr.view.SimpleReflectTableModel.class, "tableModelListener", javax.swing.event.TableModelListener.class, new String[] {"tableChanged"}, "addTableModelListener", "removeTableModelListener" ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Events
        // Here you can add code for customizing the event sets array.

        return eventSets;     }//GEN-LAST:Events

    // Method identifiers//GEN-FIRST:Methods
    private static final int METHOD_findColumn0 = 0;
    private static final int METHOD_fireTableCellUpdated1 = 1;
    private static final int METHOD_fireTableChanged2 = 2;
    private static final int METHOD_fireTableDataChanged3 = 3;
    private static final int METHOD_fireTableRowsDeleted4 = 4;
    private static final int METHOD_fireTableRowsInserted5 = 5;
    private static final int METHOD_fireTableRowsUpdated6 = 6;
    private static final int METHOD_fireTableStructureChanged7 = 7;
    private static final int METHOD_getListeners8 = 8;
    private static final int METHOD_getValueAt9 = 9;
    private static final int METHOD_isCellEditable10 = 10;
    private static final int METHOD_setValueAt11 = 11;

    // Method array 
    /*lazy MethodDescriptor*/
    private static MethodDescriptor[] getMdescriptor(){
        MethodDescriptor[] methods = new MethodDescriptor[12];
    
        try {
            methods[METHOD_findColumn0] = new MethodDescriptor(javax.swing.table.AbstractTableModel.class.getMethod("findColumn", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_findColumn0].setDisplayName ( "" );
            methods[METHOD_fireTableCellUpdated1] = new MethodDescriptor(javax.swing.table.AbstractTableModel.class.getMethod("fireTableCellUpdated", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_fireTableCellUpdated1].setDisplayName ( "" );
            methods[METHOD_fireTableChanged2] = new MethodDescriptor(javax.swing.table.AbstractTableModel.class.getMethod("fireTableChanged", new Class[] {javax.swing.event.TableModelEvent.class})); // NOI18N
            methods[METHOD_fireTableChanged2].setDisplayName ( "" );
            methods[METHOD_fireTableDataChanged3] = new MethodDescriptor(javax.swing.table.AbstractTableModel.class.getMethod("fireTableDataChanged", new Class[] {})); // NOI18N
            methods[METHOD_fireTableDataChanged3].setDisplayName ( "" );
            methods[METHOD_fireTableRowsDeleted4] = new MethodDescriptor(javax.swing.table.AbstractTableModel.class.getMethod("fireTableRowsDeleted", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_fireTableRowsDeleted4].setDisplayName ( "" );
            methods[METHOD_fireTableRowsInserted5] = new MethodDescriptor(javax.swing.table.AbstractTableModel.class.getMethod("fireTableRowsInserted", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_fireTableRowsInserted5].setDisplayName ( "" );
            methods[METHOD_fireTableRowsUpdated6] = new MethodDescriptor(javax.swing.table.AbstractTableModel.class.getMethod("fireTableRowsUpdated", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_fireTableRowsUpdated6].setDisplayName ( "" );
            methods[METHOD_fireTableStructureChanged7] = new MethodDescriptor(javax.swing.table.AbstractTableModel.class.getMethod("fireTableStructureChanged", new Class[] {})); // NOI18N
            methods[METHOD_fireTableStructureChanged7].setDisplayName ( "" );
            methods[METHOD_getListeners8] = new MethodDescriptor(javax.swing.table.AbstractTableModel.class.getMethod("getListeners", new Class[] {java.lang.Class.class})); // NOI18N
            methods[METHOD_getListeners8].setDisplayName ( "" );
            methods[METHOD_getValueAt9] = new MethodDescriptor(br.ufpr.view.SimpleReflectTableModel.class.getMethod("getValueAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getValueAt9].setDisplayName ( "" );
            methods[METHOD_isCellEditable10] = new MethodDescriptor(javax.swing.table.AbstractTableModel.class.getMethod("isCellEditable", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_isCellEditable10].setDisplayName ( "" );
            methods[METHOD_setValueAt11] = new MethodDescriptor(javax.swing.table.AbstractTableModel.class.getMethod("setValueAt", new Class[] {java.lang.Object.class, int.class, int.class})); // NOI18N
            methods[METHOD_setValueAt11].setDisplayName ( "" );
        }
        catch( Exception e) {}//GEN-HEADEREND:Methods
        // Here you can add code for customizing the methods array.

        return methods;     }//GEN-LAST:Methods

    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons

    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx


//GEN-FIRST:Superclass
    // Here you can add code for customizing the Superclass BeanInfo.

//GEN-LAST:Superclass
    /**
     * Gets the bean's <code>BeanDescriptor</code>s.
     *
     * @return BeanDescriptor describing the editable properties of this bean.
     * May return null if the information should be obtained by automatic
     * analysis.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        return getBdescriptor();
    }

    /**
     * Gets the bean's <code>PropertyDescriptor</code>s.
     *
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean. May return null if the information
     * should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will belong
     * to the IndexedPropertyDescriptor subclass of PropertyDescriptor. A client
     * of getPropertyDescriptors can use "instanceof" to check if a given
     * PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return getPdescriptor();
    }

    /**
     * Gets the bean's <code>EventSetDescriptor</code>s.
     *
     * @return An array of EventSetDescriptors describing the kinds of events
     * fired by this bean. May return null if the information should be obtained
     * by automatic analysis.
     */
    @Override
    public EventSetDescriptor[] getEventSetDescriptors() {
        return getEdescriptor();
    }

    /**
     * Gets the bean's <code>MethodDescriptor</code>s.
     *
     * @return An array of MethodDescriptors describing the methods implemented
     * by this bean. May return null if the information should be obtained by
     * automatic analysis.
     */
    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        return getMdescriptor();
    }

    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are
     * customizing the bean.
     *
     * @return Index of default property in the PropertyDescriptor array
     * returned by getPropertyDescriptors.
     * <P>
     * Returns -1 if there is no default property.
     */
    @Override
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }

    /**
     * A bean may have a "default" event that is the event that will mostly
     * commonly be used by human's when using the bean.
     *
     * @return Index of default event in the EventSetDescriptor array returned
     * by getEventSetDescriptors.
     * <P>
     * Returns -1 if there is no default event.
     */
    @Override
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }

    /**
     * This method returns an image object that can be used to represent the
     * bean in toolboxes, toolbars, etc. Icon images will typically be GIFs, but
     * may in future include other formats.
     * <p>
     * Beans aren't required to provide icons and may return null from this
     * method.
     * <p>
     * There are four possible flavors of icons (16x16 color, 32x32 color, 16x16
     * mono, 32x32 mono). If a bean choses to only support a single icon we
     * recommend supporting 16x16 color.
     * <p>
     * We recommend that icons have a "transparent" background so they can be
     * rendered onto an existing background.
     *
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @return An image object representing the requested icon. May return null
     * if no suitable icon is available.
     */
    @Override
    public java.awt.Image getIcon(int iconKind) {
        switch (iconKind) {
            case ICON_COLOR_16x16:
                if (iconNameC16 == null) {
                    return null;
                } else {
                    if (iconColor16 == null) {
                        iconColor16 = loadImage(iconNameC16);
                    }
                    return iconColor16;
                }
            case ICON_COLOR_32x32:
                if (iconNameC32 == null) {
                    return null;
                } else {
                    if (iconColor32 == null) {
                        iconColor32 = loadImage(iconNameC32);
                    }
                    return iconColor32;
                }
            case ICON_MONO_16x16:
                if (iconNameM16 == null) {
                    return null;
                } else {
                    if (iconMono16 == null) {
                        iconMono16 = loadImage(iconNameM16);
                    }
                    return iconMono16;
                }
            case ICON_MONO_32x32:
                if (iconNameM32 == null) {
                    return null;
                } else {
                    if (iconMono32 == null) {
                        iconMono32 = loadImage(iconNameM32);
                    }
                    return iconMono32;
                }
            default:
                return null;
        }
    }
    
}
