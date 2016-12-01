package br.ufpr.data;

import br.ufpr.model.Automovel;
import br.ufpr.model.Categoria;
import br.ufpr.model.Estado;
import br.ufpr.model.Locacao;
import br.ufpr.model.Marca;
import br.ufpr.model.Motocicleta;
import br.ufpr.model.Van;
import br.ufpr.model.Veiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class VeiculoDao extends Dao implements DaoI<Veiculo> {

    @Override
    public void inserir(Veiculo veiculo) throws Exception {
        Integer id = this.getNextId();
        open();
        
        stmt = con.prepareStatement("INSERT INTO veiculo VALUES(?, ?, ?, ?, ?, ?, ?)");
        int idx = 0;
        stmt.setInt(++idx, id);
        stmt.setInt(++idx, veiculo.getMarca().getIdMarca());
        stmt.setInt(++idx, veiculo.getEstado().getIdEstado());
        stmt.setInt(++idx, veiculo.getCategoria().getIdCategoria());
        stmt.setDouble(++idx, veiculo.getValorCompra());
        stmt.setString(++idx, veiculo.getPlaca());
        stmt.setInt(++idx, veiculo.getAno());
        stmt.execute();
        
        idx = 0;
        if (veiculo instanceof Automovel) {
            stmt = con.prepareStatement("INSERT INTO automovel VALUES(?, ?)");
            stmt.setInt(++idx, id);
            stmt.setInt(++idx, ((Automovel) veiculo).getModelo().getIdModeloAutomovel());
        } else if (veiculo instanceof Motocicleta) {
            stmt = con.prepareStatement("INSERT INTO motocicleta VALUES (?, ?)");
            stmt.setInt(++idx, id);
            stmt.setInt(++idx, ((Motocicleta) veiculo).getModelo().getIdModeloMotocicleta());
        } else if (veiculo instanceof Van) {
            stmt = con.prepareStatement("INSERT INTO van VALUES(?, ?)");
            stmt.setInt(++idx, id);
            stmt.setInt(++idx, ((Van) veiculo).getModelo().getIdModeloVan());
        }
        stmt.execute();
        
        close();
    }

    @Override
    public void editar(Veiculo veiculo) throws Exception {
        open();
        
        stmt = con.prepareStatement("UPDATE veiculo SET idmarca = ?, idestado = ?, idcategoria = ?, valorcompra = ?, placa = ?, ano = ? WHERE idveiculo = ?");
        int idx = 0;
        stmt.setInt(++idx, veiculo.getMarca().getIdMarca());
        stmt.setInt(++idx, veiculo.getEstado().getIdEstado());
        stmt.setInt(++idx, veiculo.getCategoria().getIdCategoria());
        stmt.setDouble(++idx, veiculo.getValorCompra());
        stmt.setString(++idx, veiculo.getPlaca());
        stmt.setInt(++idx, veiculo.getAno());
        stmt.setInt(++idx, veiculo.getIdVeiculo());
        stmt.execute();
        
        idx = 0;
        if (veiculo instanceof Automovel) {
            stmt = con.prepareStatement("UPDATE automovel SET idmodeloautomovel = ? WHERE idveiculo = ?");
            stmt.setInt(++idx, ((Automovel) veiculo).getModelo().getIdModeloAutomovel());
            stmt.setInt(++idx, veiculo.getIdVeiculo());
        } else if (veiculo instanceof Motocicleta) {
            stmt = con.prepareStatement("UPDATE motocicleta SET idmodelomotocicleta = ? WHERE idveiculo = ?)");
            stmt.setInt(++idx, ((Motocicleta) veiculo).getModelo().getIdModeloMotocicleta());
            stmt.setInt(++idx, veiculo.getIdVeiculo());
        } else if (veiculo instanceof Van) {
            stmt = con.prepareStatement("UPDATE van SET idmodelovan = ? WHERE idveiculo = ?)");
            stmt.setInt(++idx, ((Van) veiculo).getModelo().getIdModeloVan());
            stmt.setInt(++idx, veiculo.getIdVeiculo());
        }
        stmt.execute();
        
        close();
    }

    @Override
    public void excluir(Veiculo veiculo) throws Exception {
        open();
        
        int idx = 0;
        if (veiculo instanceof Automovel) {
            stmt = con.prepareStatement("DELETE FROM automovel WHERE idveiculo = ?");
            stmt.setInt(++idx, veiculo.getIdVeiculo());
        } else if (veiculo instanceof Motocicleta) {
            stmt = con.prepareStatement("DELETE FROM motocicleta WHERE idveiculo = ?");
            stmt.setInt(++idx, veiculo.getIdVeiculo());
        } else if (veiculo instanceof Van) {
            stmt = con.prepareStatement("DELETE FROM van WHERE idveiculo = ?");
            stmt.setInt(++idx, veiculo.getIdVeiculo());
        }
        stmt.execute();
        
        stmt = con.prepareStatement("DELETE FROM veiculo WHERE idveiculo = ?");
        idx = 0;
        stmt.setInt(++idx, veiculo.getIdVeiculo());
        stmt.execute();
        
        close();
    }

    @Override
    public Veiculo buscar(Veiculo veiculo) throws Exception {
        List<Veiculo> lista = this.listar(veiculo);
        return lista.size() == 1 ? lista.get(0) : null;
    }

    @Override
    public List<Veiculo> listar(Veiculo veiculo) throws Exception {
        List<Veiculo> resultado = new ArrayList<>();
        open();
        
        stmt = con.prepareStatement(this.montarQuery(veiculo));
        rs = stmt.executeQuery();
        while (rs.next()) {
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
            Veiculo v = null;
            if (veiculo instanceof Automovel) {
                v = new Automovel(null, marca, estado, locacao, categoria, valorCompra, placa, ano);
            } else if (veiculo instanceof Motocicleta) {
                v = new Motocicleta(null, marca, estado, locacao, categoria, valorCompra, placa, ano);
            } else if (veiculo instanceof Van) {
                v = new Van(null, marca, estado, locacao, categoria, valorCompra, placa, ano);
            }
            resultado.add(v);
        }
        return resultado;
    }
    
     public String montarQuery(Veiculo veiculo) {
        StringBuilder query = new StringBuilder();
        
        query.append(" SELECT * ");
        query.append(" FROM veiculo ");
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
//            if (veiculo.getAno() != 0) {
//                query.append(String.format(" AND ano = %d ", veiculo.getAno()));
//            }
        }
        
        return query.toString();
    }
}
