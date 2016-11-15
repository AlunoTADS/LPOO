package br.ufpr.data;

import br.ufpr.model.Cliente;
import br.ufpr.model.Locacao;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
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

        try {
            stmt.execute();
        } catch (Exception e) {
            throw e;
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
        } catch (Exception e) {
            throw e;
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
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    @Override
    public Locacao buscar(Locacao locacao) throws Exception {
        String sql = new StringBuilder()
                .append(" SELECT idveiculo, idcliente, dias, datainicio, valor ")
                .append(" FROM locacao ")
                .append(String.format(" WHERE idveiculo = %d ", locacao.getIdVeiculo()))
                .toString();

        stmt = con.prepareStatement(sql);

        try {
            stmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return new Locacao(rs.getInt(1), new Cliente(rs.getInt(2)), rs.getInt(3), rs.getDate(4), rs.getDouble(5));
    }

    @Override
    public List<Locacao> listar(Locacao locacao) throws Exception {
        StringBuilder sql = new StringBuilder()
                .append(" SELECT idveiculo, idcliente, dias, datainicio, valor ")
                .append(" FROM locacao ")
                .append(" WHERE 1 = 1 ");

        if (locacao.getIdVeiculo() != null) {
            sql.append(String.format(" AND idveiculo = %d ", locacao.getIdVeiculo()));
        }

        if (locacao.getCliente() != null && locacao.getCliente().getIdCliente() != null) {
            sql.append(String.format(" AND idcliente = %d ", locacao.getCliente().getIdCliente()));
        }

        if (locacao.getDias() != null) {
            sql.append(String.format(" AND dias = %d ", locacao.getIdVeiculo()));
        }

        if (locacao.getDataInicio() != null) {
            sql.append(String.format(" AND datainicio = '%s' ", new SimpleDateFormat("yyyy-MM-dd").format(locacao.getDataInicio())));
        }

        if (locacao.getValor() != null) {
            sql.append(String.format(" AND valor = %f ", locacao.getValor()));
        }

        stmt = con.prepareStatement(sql.toString());

        List<Locacao> list = new LinkedList<>();
        try {
            rs = stmt.executeQuery();
            list.add(new Locacao(rs.getInt(1), new Cliente(rs.getInt(2)), rs.getInt(3), rs.getDate(4), rs.getDouble(5)));
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return list;
    }

    @Override
    public Locacao resultSetToEntity(Locacao t, ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
