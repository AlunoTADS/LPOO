package br.ufpr.view.veiculo;

import br.ufpr.view.util.SimpleReflectTableModel;
import br.ufpr.model.Veiculo;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 *
 * @author Lucas
 */
public class VeiculoTable extends JPanel {
    private SimpleReflectTableModel simpleReflectTableModel;

    public VeiculoTable() {
        super(new GridLayout(1, 0));
        simpleReflectTableModel = new SimpleReflectTableModel(Veiculo.class);
        JTable table = new JTable(getSimpleReflectTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    /**
     * @return the simpleReflectTableModel
     */
    public SimpleReflectTableModel getSimpleReflectTableModel() {
        return simpleReflectTableModel;
    }
}
