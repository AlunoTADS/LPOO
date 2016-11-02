package br.ufpr.data;

import br.ufpr.model.Locacao;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
                .append(" INSERT INTO locacao ")
                .append(" (idveiculo, datainicio, dias, idcliente, valor) ")
                .append(" VALUES (?, ?, ?, ?, ?) ")
                .toString();

        stmt = con.prepareStatement(sql);

        int idx = 0;
        stmt.setInt(++idx, locacao.getIdVeiculo());
        stmt.setDate(++idx, (Date) locacao.getDataInicio());
        stmt.setInt(++idx, locacao.getDias());
        stmt.setInt(++idx, locacao.getCliente().getIdCliente());

        stmt.execute();

        try {
            stmt.execute();
        } finally {
            close();
        }
    }

    @Override
    public void editar(Locacao locacao) throws Exception {
        open();

        String sql = new StringBuilder()
                .append(" UPDATE locacao SET ")
                .append(" datainicio = ?, dias = ?, idcliente = ?, valor = ? ")
                .append(" WHERE idveiculo = ? ")
                .toString();

        stmt = con.prepareStatement(sql);

        int idx = 0;
        stmt.setDate(++idx, (Date) locacao.getDataInicio());
        stmt.setInt(++idx, locacao.getDias());
        stmt.setInt(++idx, locacao.getCliente().getIdCliente());
        stmt.setInt(++idx, locacao.getIdVeiculo());

        try {
            stmt.execute();
        } finally {
            close();
        }
    }

    @Override
    public void excluir(Locacao locacao) throws Exception {
        open();

        String sql = new StringBuilder()
                .append(" UPDATE locacao SET ")
                .append(" datainicio = ?, dias = ?, idcliente = ?, valor = ? ")
                .append(" WHERE idveiculo = ? ")
                .toString();

        stmt = con.prepareStatement(sql);

        stmt.setInt(0, locacao.getIdVeiculo());

        try {
            stmt.execute();
        } finally {
            close();
        }
    }

    @Override
    public Locacao buscar(Locacao locacao) throws Exception {

        String sql = new StringBuilder()
                .append(" SELECT idveiculo, dias, datainicio, idcliente, valor ")
                .append(" FROM locacao ")
                .append(String.format(" WHERE idveiculo = %d ", locacao.getIdVeiculo()))
                .toString();
        
        stmt = con.prepareStatement(sql);
        
        try {
            rs = stmt.executeQuery();
        }
        catch(Exception e) {
            throw e;
        }
        finally {
            close();
        }
        //Integer idVeiculo, Cliente cliente, Integer dias, Date dataInicio, Double valor
        return new Locacao(rs.getInt(0), rs.getInt(1), rs.getDate(2), rs., Double.NaN);
    }

    @Override
    public List<Locacao> listar(Locacao t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
