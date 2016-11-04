package br.ufpr.data;

import br.ufpr.model.Categoria;
import br.ufpr.model.Estado;
import br.ufpr.model.Locacao;
import br.ufpr.model.Marca;
import br.ufpr.model.ModeloMotocicleta;
import br.ufpr.model.Motocicleta;
import br.ufpr.model.Veiculo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class MotocicletaDao extends VeiculoDao implements DaoI<Veiculo> {

    public void inserir(Motocicleta motocicleta) throws Exception {
        super.inserir(motocicleta);
        open();

        String sql = new StringBuilder()
                .append(" INSERT INTO motocicleta ")
                .append(" (idveiculo, idmodelomotocicleta) ")
                .append(" VALUES (?, ?) ")
                .toString();

        stmt = con.prepareStatement(sql);

        int idx = 0;
        stmt.setInt(++idx, motocicleta.getIdVeiculo());
        stmt.setInt(++idx, motocicleta.getModelo().getIdModeloMotocicleta());
        stmt.execute();

        try {
            stmt.execute();
        } finally {
            close();
        }

    }

    public void editar(Motocicleta motocicleta) throws Exception {
        super.editar(motocicleta);
        open();

        String sql = new StringBuilder()
                .append(" UPDATE motocicleta SET ")
                .append(" idmotocicletamodelo = ? ")
                .append(" WHERE idveiculo = ? ")
                .toString();

        stmt = con.prepareStatement(sql);

        int idx = 0;
        stmt.setInt(++idx, motocicleta.getModelo().getIdModeloMotocicleta());
        stmt.setInt(++idx, motocicleta.getIdVeiculo());

        try {
            stmt.execute();
        } finally {
            close();
        }

    }

    public void excluir(Motocicleta motocicleta) throws Exception {
        open();

        String sql = new StringBuilder()
                .append(" UPDATE motocicleta SET ")
                .append(" idveiculo = ? ")
                .append(" WHERE idveiculo = ? ")
                .toString();

        stmt = con.prepareStatement(sql);

        stmt.setInt(0, motocicleta.getIdVeiculo());

        try {
            stmt.execute();
            super.excluir(motocicleta);
        } finally {
            close();
        }
    }

    public Motocicleta buscar(Motocicleta motocicleta) throws Exception {
        String sql = new StringBuilder()
                .append(" SELECT m.idmodelomotocicleta, v.idveiculo, v.idmarca, v.idestado, v.idcategoria, v.valorcompra, v.placa, v.ano ")
                .append(" FROM   veiculo v ")
                .append("        INNER JOIN motocicleta m ON m.idveiculo = v.idveiculo ")
                .append(String.format(" WHERE idveiculo = %d ", motocicleta.getIdVeiculo()))
                .toString();

        stmt = con.prepareStatement(sql);

        try {
            rs = stmt.executeQuery();
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return new Motocicleta(
                ModeloMotocicleta.fromValue(rs.getInt(1)),
                Marca.fromValue(rs.getInt(2)),
                Estado.fromValue(rs.getInt(rs.getInt(3))),
                new LocacaoDao().buscar(new Locacao(rs.getInt(4), null, null, null, null)),
                Categoria.fromValue(rs.getInt(5)),
                rs.getDouble(6),
                rs.getString(7),
                rs.getInt(8)
        );

    }

    public List<Motocicleta> listar(Motocicleta motocicleta) throws Exception {
        StringBuilder sql = new StringBuilder()
                .append(" SELECT m.idmodelomotocicleta, v.idveiculo, v.idmarca, v.idestado, v.idcategoria, v.valorcompra, v.placa, v.ano ")
                .append(" FROM   veiculo v ")
                .append("        INNER JOIN motocicleta m ON m.idveiculo = v.idveiculo ")
                .append(" WHERE 1 = 1 ");

        if (motocicleta.getModelo() != null) {
            sql.append(String.format(" AND m.idmodelomotocicleta = %d ", motocicleta.getModelo().getIdModeloMotocicleta()));
        }

        if (motocicleta.getIdVeiculo() != null) {
            sql.append(String.format(" AND v.idveiculo = %d ", motocicleta.getIdVeiculo()));
        }

        if (motocicleta.getMarca() != null) {
            sql.append(String.format(" AND v.idmarca = %d ", motocicleta.getMarca().getIdMarca()));
        }

        if (motocicleta.getEstado() != null) {
            sql.append(String.format(" AND v.idestado = %d ", motocicleta.getEstado().getIdEstado()));
        }

        if (motocicleta.getCategoria() != null) {
            sql.append(String.format(" AND v.idcategoria = %d ", motocicleta.getCategoria().getIdCategoria()));
        }

        if (motocicleta.getValorCompra() != null) {
            sql.append(String.format(" AND v.valorcompra = %f ", motocicleta.getValorCompra()));
        }

        if (motocicleta.getPlaca() != null) {
            sql.append(String.format(" AND v.placa = '%s' ", motocicleta.getPlaca()));
        }

        if (motocicleta.getAno() != 0) {
            sql.append(String.format(" AND v.ano = '%d' ", motocicleta.getAno()));
        }

        stmt = con.prepareStatement(sql.toString());

        List<Motocicleta> list = new LinkedList<>();
        try {
            rs = stmt.executeQuery();
            list.add(new Motocicleta(
                    ModeloMotocicleta.fromValue(rs.getInt(1)),
                    Marca.fromValue(rs.getInt(2)),
                    Estado.fromValue(rs.getInt(rs.getInt(3))),
                    new LocacaoDao().buscar(new Locacao(rs.getInt(4), null, null, null, null)),
                    Categoria.fromValue(rs.getInt(5)),
                    rs.getDouble(6),
                    rs.getString(7),
                    rs.getInt(8)
            ));
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
        return list;
    }

}
