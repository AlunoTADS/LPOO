package br.ufpr.data;

import br.ufpr.model.Cliente;
import br.ufpr.model.Locacao;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

        try {
            stmt = con.prepareStatement(sql);

            int idx = 0;
            stmt.setInt(++idx, locacao.getIdVeiculo());
            stmt.setDate(++idx, new java.sql.Date(locacao.getDataInicio().getTime()));
            stmt.setInt(++idx, locacao.getDias());
            stmt.setInt(++idx, locacao.getCliente().getIdCliente());
            stmt.setDouble(++idx, locacao.getValor());
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

        try {

            stmt = con.prepareStatement(sql);

            int idx = 0;
            stmt.setDate(++idx, (Date) locacao.getDataInicio());
            stmt.setInt(++idx, locacao.getDias());
            stmt.setInt(++idx, locacao.getCliente().getIdCliente());
            stmt.setInt(++idx, locacao.getIdVeiculo());
            stmt.execute();
        } finally {
            close();
        }
    }

    @Override
    public void excluir(Locacao locacao) throws Exception {
        open();

        String sql = new StringBuilder()
                .append(" DELETE FROM locacao ")
                .append(" WHERE idveiculo = ? ")
                .toString();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, locacao.getIdVeiculo());
            stmt.execute();
        } finally {
            close();
        }
    }

    @Override
    public Locacao buscar(Locacao locacao) throws Exception {
        open();
        String sql = new StringBuilder()
                .append(" SELECT idveiculo, idcliente, dias, datainicio, valor ")
                .append(" FROM locacao ")
                .append(String.format(" WHERE idveiculo = %d ", locacao.getIdVeiculo()))
                .toString();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                locacao = new Locacao(
                        rs.getInt("idveiculo"), 
                        new Cliente(rs.getInt("idcliente")),
                        rs.getInt("dias"),
                        rs.getDate("datainicio"), 
                        rs.getDouble("valor"));
            } else {
                locacao = null;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return locacao;
    }

    @Override
    public List<Locacao> listar(Locacao locacao) throws Exception {
        open();
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

        List<Locacao> list = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Locacao(rs.getInt("idveiculo"),
                        new Cliente(rs.getInt("idcliente")),
                        rs.getInt("dias"),
                        rs.getDate("datainicio"),
                        rs.getDouble("valor")));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return list;
    }
}
