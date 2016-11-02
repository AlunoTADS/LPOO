/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.data;

import br.ufpr.model.Veiculo;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class VeiculoDao extends Dao implements DaoI<Veiculo> {

    @Override
    public void inserir(Veiculo veiculo) throws Exception {
        open();
        
        stmt = con.prepareStatement("INSERT INTO veiculo VALUES(?, ?, ?, ?, ?, ?, ?)");
        int idx = 0;
        stmt.setInt(++idx, veiculo.getIdVeiculo());
        stmt.setInt(++idx, veiculo.getMarca().getIdMarca());
        stmt.setInt(++idx, veiculo.getEstado().getIdEstado());
        stmt.setInt(++idx, veiculo.getCategoria().getIdCategoria());
        stmt.setDouble(++idx, veiculo.getValorCompra());
        stmt.setString(++idx, veiculo.getPlaca());
        stmt.setInt(++idx, veiculo.getAno());
        stmt.execute();
        
        close();
    }

    @Override
    public void editar(Veiculo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Veiculo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Veiculo buscar(Veiculo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Veiculo> listar(Veiculo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public String montarQuery(Veiculo veiculo) {
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT a.idmodeloautomovel, v.* ");
        query.append(" FROM automovel a ");
        query.append(" INNER JOIN veiculo v ON v.idveiculo = a.idveiculo ");
        query.append(" WHERE 1=1 ");
        if (veiculo != null) {
            if (veiculo.getIdVeiculo() != null) {
                query.append(String.format(" AND idveiculo = %d ", veiculo.getIdVeiculo()));
            }
            if (veiculo.getMarca() != null && veiculo.getMarca().getIdMarca() != null) {
                query.append(String.format(" AND idmarca = %d ", veiculo.getMarca().getIdMarca()));
            }
            if (veiculo.getEstado() != null && veiculo.getEstado().getIdEstado() != null) {
                query.append(String.format(" AND idestado = %d ", veiculo.getEstado().getIdEstado()));
            }
            if (veiculo.getCategoria() != null && veiculo.getCategoria().getIdCategoria() != null) {
                query.append(String.format(" AND idcategoria = %d ", veiculo.getCategoria().getIdCategoria()));
            }
            if (veiculo.getValorCompra() != null) {
                query.append(String.format(" AND valorcompra = %f ", veiculo.getValorCompra()));
            }
            if (veiculo.getPlaca() != null) {
                query.append(String.format(" AND placa = '%s' ", veiculo.getPlaca()));
            }
            if (veiculo.getAno() != 0) {
                query.append(String.format(" AND ano = %d ", veiculo.getAno()));
            }
        }
        
        return query.toString();
    }
}
