package br.ufpr.data;

import br.ufpr.model.Locacao;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class LocacaoDao extends Dao implements DaoI<Locacao> {    

    @Override
    public void inserir(Locacao locacao) throws Exception {
        open();
        
        String sql = new StringBuilder()
                            .append("INSERT INTO locacao ")
                            .append("(idveiculo, datainicio, dias, idcliente, valor)")
                            .append("VALUES (?, ?, ?, ?, ?)")
                            .toString();
        
        stmt = con.prepareStatement(sql);
        
        int idx = 0;
        stmt.setInt(++idx, locacao.getIdVeiculo());
        stmt.setDate(++idx, (Date)locacao.getDataInicio());
        stmt.setInt(++idx, locacao.getDias());
        stmt.setInt(++idx, locacao.getCliente().getIdCliente());
        
        stmt.execute();
        
        close();
    }

    @Override
    public void editar(Locacao locacao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Locacao t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Locacao buscar(Locacao t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Locacao> listar(Locacao t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
