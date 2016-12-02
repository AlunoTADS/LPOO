package br.ufpr.data;

import br.ufpr.model.Automovel;
import br.ufpr.model.Categoria;
import br.ufpr.model.Estado;
import br.ufpr.model.Locacao;
import br.ufpr.model.Marca;
import br.ufpr.model.ModeloAutomovel;
import br.ufpr.model.Veiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class AutomovelDao extends VeiculoDao implements DaoI<Veiculo> {

    public void inserir(Automovel automovel) throws Exception {
        super.inserir(automovel);
        open();
        
        stmt = con.prepareStatement("INSERT INTO automovel VALUES (?, ?)");
        int idx = 0;
        stmt.setInt(++idx, automovel.getIdVeiculo());
        stmt.setInt(++idx, automovel.getModelo().getIdModeloAutomovel());
        stmt.execute();
        
        close();
    }

    public void editar(Automovel automovel) throws Exception {
        super.editar(automovel);
        open();
        
        stmt = con.prepareStatement("UPDATE automovel SET idmodeloautomovel = ? WHERE idveiculo = ?");
        int idx = 0;
        stmt.setInt(++idx, automovel.getModelo().getIdModeloAutomovel());
        stmt.setInt(++idx, automovel.getIdVeiculo());
        stmt.execute();
        
        close();
    }

    public void excluir(Automovel automovel) throws Exception {
        open();
        
        stmt = con.prepareStatement("DELETE FROM automovel WHERE idveiculo = ?");
        int idx = 0;
        stmt.setInt(++idx, automovel.getIdVeiculo());
        stmt.execute();
        
        close();
        super.excluir(automovel);
    }

    public Automovel buscar(Automovel automovel) throws Exception {
        List<Automovel> lista = this.listar(automovel);
        return lista.size() == 1 ? lista.get(0) : null;
    }

    public List<Automovel> listar(Automovel automovel) throws Exception {
        List<Automovel> resultado = new ArrayList<>();
        open();
        
        stmt = con.prepareStatement(this.montarQuery(automovel));
        rs = stmt.executeQuery();
        while (rs.next()) {
            Integer idVeiculo = rs.getInt("id");
            ModeloAutomovel modeloAutomovel = ModeloAutomovel.fromValue(rs.getInt("idmodeloautomovel"));
            Marca marca = Marca.fromValue(rs.getInt("idmarca"));
            Estado estado = Estado.fromValue(rs.getInt("idestado"));
            Categoria categoria = Categoria.fromValue(rs.getInt("idcategoria"));
            Double valorCompra = rs.getDouble("valorcompra");
            String placa = rs.getString("placa");
            Integer ano = rs.getInt("ano");
            Locacao locacao = null;
            if (estado.equals(Estado.LOCADO)) {
                locacao = new Locacao(rs.getInt("idveiculo"));
                //locacao = new LocacaoDao.buscar(locacao);
            }
            Automovel a = new Automovel(idVeiculo, modeloAutomovel, marca, estado, locacao, categoria, valorCompra, placa, ano);
            resultado.add(a);
        }
        
        close();
        return resultado;
    }
    
    public String montarQuery(Automovel automovel) {
        StringBuilder query = new StringBuilder();
        
        query.append(" SELECT a.idmodeloautomovel, v.* ");
        query.append(" FROM automovel a ");
        query.append(" INNER JOIN veiculo v ON v.idveiculo = a.idveiculo ");
        query.append(" WHERE 1=1 ");
        if (automovel != null) {
            if (automovel.getIdVeiculo() != null) {
                query.append(String.format(" AND idveiculo = %d ", automovel.getIdVeiculo()));
            }
            if (automovel.getModelo() != null && automovel.getModelo().getIdModeloAutomovel() != null) {
                query.append(String.format(" AND idmodeloautomovel = %d ", automovel.getModelo().getIdModeloAutomovel()));
            }
            if (automovel.getMarca() != null && automovel.getMarca().getIdMarca() != null) {
                query.append(String.format(" AND idmarca = %d ", automovel.getMarca().getIdMarca()));
            }
            if (automovel.getEstado() != null && automovel.getEstado().getIdEstado() != null) {
                query.append(String.format(" AND idestado = %d ", automovel.getEstado().getIdEstado()));
            }
            if (automovel.getCategoria() != null && automovel.getCategoria().getIdCategoria() != null) {
                query.append(String.format(" AND idcategoria = %d ", automovel.getCategoria().getIdCategoria()));
            }
            if (automovel.getValorCompra() != null) {
                query.append(String.format(" AND valorcompra = %f ", automovel.getValorCompra()));
            }
            if (automovel.getPlaca() != null) {
                query.append(String.format(" AND placa = '%s' ", automovel.getPlaca()));
            }
            if (automovel.getAno() != 0) {
                query.append(String.format(" AND ano = %d ", automovel.getAno()));
            }
        }
        
        return query.toString();
    }
}