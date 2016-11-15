package br.ufpr.view.util;

import br.ufpr.model.Column;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Map;

/**
 *
 * @author Lucas
 */
public class SimpleReflectTable extends JPanel {

    private SimpleReflectTableModel simpleReflectTableModel;
    private JTable table;

    public SimpleReflectTable() {
        super(new GridLayout(1, 0));
    }

    public void setClass(Class clazz) {
        simpleReflectTableModel = new SimpleReflectTableModel(clazz);

        table = new JTable(getSimpleReflectTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        adjustTableColumns();

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    private void adjustTableColumns() {
        for (Map.Entry<Integer, Column> entry : simpleReflectTableModel.getColumns().entrySet()) {
            table.getColumnModel()
                    .getColumn(entry.getKey())
                    .setPreferredWidth(entry.getValue().width());
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    /**
     * @return the simpleReflectTableModel
     */
    public SimpleReflectTableModel getSimpleReflectTableModel() {
        return simpleReflectTableModel;
    }

    /**
     * @return the table
     */
    private JTable getTable() {
        return table;
    }
}
