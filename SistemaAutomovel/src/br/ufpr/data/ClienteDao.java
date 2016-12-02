package br.ufpr.data;

import br.ufpr.model.Cliente;
import br.ufpr.model.UnidadeFederativa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class ClienteDao extends Dao<Cliente> implements DaoI<Cliente> {

    @Override
    public void inserir(Cliente t) throws Exception {
        open();

        String sql = new StringBuilder()
                .append(" INSERT INTO cliente ")
                .append(" (idcliente, nome, sobrenome, endereco, cpf, rg, rgsiglauf) ")
                .append(" VALUES (?, ?, ?, ?, ?, ?, ?) ")
                .toString();

        stmt = con.prepareStatement(sql);

        int idx = 0;
        stmt.setInt(++idx, t.getIdCliente());
        stmt.setString(++idx, t.getNome());
        stmt.setString(++idx, t.getSobrenome());
        stmt.setString(++idx, t.getEndereco());
        stmt.setString(++idx, t.getCpf());
        stmt.setString(++idx, t.getRg());
        stmt.setString(++idx, t.getRgUF().getSiglaUF());

        try {
            stmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    @Override
    public void editar(Cliente t) throws Exception {
        open();

        String sql = new StringBuilder()
                .append(" UPDATE cliente SET ")
                .append(" nome = ?, sobrenome = ?, endereco = ?, cpf = ?, rg = ?, rgsiglauf = ? ")
                .append(" WHERE idcliente = ? ")
                .toString();

        stmt = con.prepareStatement(sql);

        int idx = 0;
        stmt.setString(++idx, t.getNome());
        stmt.setString(++idx, t.getSobrenome());
        stmt.setString(++idx, t.getEndereco());
        stmt.setString(++idx, t.getCpf());
        stmt.setString(++idx, t.getRg());
        stmt.setString(++idx, t.getRgUF().getSiglaUF());
        stmt.setInt(++idx, t.getIdCliente());

        try {
            stmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    @Override
    public void excluir(Cliente t) throws Exception {
        open();

        String sql = new StringBuilder()
                .append(" DELETE FROM cliente ")
                .append(" WHERE idcliente = ? ")
                .toString();

        stmt = con.prepareStatement(sql);

        int idx = 0;
        stmt.setInt(++idx, t.getIdCliente());

        try {
            stmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    @Override
    public Cliente buscar(Cliente t) throws Exception {
        List<Cliente> lista = this.listar(t);
        return lista.size() == 1 ? lista.get(0) : null;
    }

    @Override
    public List<Cliente> listar(Cliente t) throws Exception {
        open();
        List<Cliente> resultado = new ArrayList<>();

        try {
            stmt = con.prepareStatement(this.montarQuery(t));
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente a = new Cliente(rs.getInt("idcliente"), rs.getString("nome"), rs.getString("sobrenome"), rs.getString("cpf"), rs.getString("rg"), UnidadeFederativa.fromValue(rs.getString("rgsiglauf")), rs.getString("endereco"));
                resultado.add(a);
            }
        } finally {
            close();
        }
        return resultado;
    }

    public String montarQuery(Cliente t) {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT * ");
        query.append(" FROM   cliente ");
        query.append(" WHERE  1 = 1 ");
        if (t != null) {
            if (t.getIdCliente() != null) {
                query.append(String.format(" AND idcliente = %d ", t.getIdCliente()));
            }

            if (t.getNome() != null) {
                query.append(String.format(" AND UPPER(nome) LIKE UPPER('%s') ", t.getNome()));
            }

            if (t.getSobrenome() != null) {
                query.append(String.format(" AND UPPER(sobrenome) LIKE UPPER('%s') ", t.getSobrenome()));
            }

            if (t.getCpf() != null) {
                query.append(String.format(" AND cpf LIKE '%s' ", t.getCpf()));
            }

            if (t.getRg() != null) {
                query.append(String.format(" AND rg LIKE '%s' ", t.getRg()));
            }

            if (t.getRgUF() != null) {
                query.append(String.format(" AND rgsiglauf LIKE '%s' ", t.getRgUF().getSiglaUF()));
            }

            if (t.getEndereco() != null) {
                query.append(String.format(" AND UPPER(endereco) LIKE UPPER('%s') ", t.getEndereco()));
            }
        }
        query.append(" ORDER BY idcliente ");
        return query.toString();
    }

}
