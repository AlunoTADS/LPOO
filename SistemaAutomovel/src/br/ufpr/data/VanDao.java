/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.data;

import br.ufpr.model.Categoria;
import br.ufpr.model.Estado;
import br.ufpr.model.Locacao;
import br.ufpr.model.Marca;
import br.ufpr.model.ModeloVan;
import br.ufpr.model.Van;
import br.ufpr.model.Veiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class VanDao extends VeiculoDao implements DaoI<Veiculo> {

    public void inserir(Van van) throws Exception {
        super.inserir(van);
        open();
        
        stmt = con.prepareStatement("INSERT INTO van VALUES (?, ?)");
        int idx = 0;
        stmt.setInt(++idx, van.getIdVeiculo());
        stmt.setInt(++idx, van.getModelo().getIdModeloVan());
        stmt.execute();
        
        close();
    }

    public void editar(Van van) throws Exception {
        super.editar(van);
        open();
        
        stmt = con.prepareStatement("UPDATE van SET idmodelovan = ? WHERE idveiculo = ?");
        int idx = 0;
        stmt.setInt(++idx, van.getModelo().getIdModeloVan());
        stmt.setInt(++idx, van.getIdVeiculo());
        stmt.execute();
        
        close();
    }

    public void excluir(Van van) throws Exception {
        open();
        
        stmt = con.prepareStatement("DELETE FROM van WHERE idveiculo = ?");
        int idx = 0;
        stmt.setInt(++idx, van.getIdVeiculo());
        stmt.execute();
        
        close();
        super.excluir(van);
    }

    public Van buscar(Van van) throws Exception {
        List<Van> lista = this.listar(van);
        return lista.size() == 1 ? lista.get(0) : null;
    }

    public List<Van> listar(Van van) throws Exception {
        List<Van> resultado = new ArrayList<>();
        open();
        
        stmt = con.prepareStatement(this.montarQuery(van));
        rs = stmt.executeQuery();
        while (rs.next()) {
            ModeloVan modeloVan = ModeloVan.fromValue(rs.getInt("idmodelovan"));
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
            Van v = new Van(modeloVan, marca, estado, locacao, categoria, valorCompra, placa, ano);
            resultado.add(v);
        }
        
        close();
        return resultado;
    }
    
    public String montarQuery(Van van) {
        StringBuilder query = new StringBuilder();
        
        query.append(" SELECT van.idmodelovan, v.* ");
        query.append(" FROM van ");
        query.append(" INNER JOIN veiculo v ON v.idveiculo = van.idveiculo ");
        query.append(" WHERE 1=1 ");
        if (van != null) {
            if (van.getIdVeiculo() != null) {
                query.append(String.format(" AND idveiculo = %d ", van.getIdVeiculo()));
            }
            if (van.getModelo() != null && van.getModelo().getIdModeloVan() != null) {
                query.append(String.format(" AND idmodeloautomovel = %d ", van.getModelo().getIdModeloVan()));
            }
            if (van.getMarca() != null && van.getMarca().getIdMarca() != null) {
                query.append(String.format(" AND idmarca = %d ", van.getMarca().getIdMarca()));
            }
            if (van.getEstado() != null && van.getEstado().getIdEstado() != null) {
                query.append(String.format(" AND idestado = %d ", van.getEstado().getIdEstado()));
            }
            if (van.getCategoria() != null && van.getCategoria().getIdCategoria() != null) {
                query.append(String.format(" AND idcategoria = %d ", van.getCategoria().getIdCategoria()));
            }
            if (van.getValorCompra() != null) {
                query.append(String.format(" AND valorcompra = %f ", van.getValorCompra()));
            }
            if (van.getPlaca() != null) {
                query.append(String.format(" AND placa = '%s' ", van.getPlaca()));
            }
            if (van.getAno() != 0) {
                query.append(String.format(" AND ano = %d ", van.getAno()));
            }
        }
        
        return query.toString();
    }
}
