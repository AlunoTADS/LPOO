package br.ufpr.data;

import br.ufpr.model.Cliente;
import java.sql.ResultSet;
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
                .append(" DELETE cliente SET ")
                .append(" WHERE idcliente = ? ")
                .toString();

        stmt = con.prepareStatement(sql);

        int idx = 0;
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
    public Cliente buscar(Cliente t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> listar(Cliente t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente resultSetToEntity(Cliente t, ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
