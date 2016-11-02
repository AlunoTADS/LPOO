/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.data;

import br.ufpr.model.Automovel;
import br.ufpr.model.Categoria;
import br.ufpr.model.Estado;
import br.ufpr.model.Locacao;
import br.ufpr.model.Marca;
import br.ufpr.model.ModeloAutomovel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class AutomovelDao extends Dao implements DaoI<Automovel> {

    @Override
    public void inserir(Automovel t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Automovel t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Automovel t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Automovel buscar(Automovel t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Automovel> listar(Automovel automovel) throws Exception {
        List<Automovel> resultado = new ArrayList<Automovel>();
        open();
        
        stmt = con.prepareStatement(montarQuery(automovel));
        rs = stmt.executeQuery();
        while (rs.next()) {
            ModeloAutomovel modeloAutomovel = ModeloAutomovel.fromValue(rs.getInt("idmodeloautomovel"));
            Marca marca = Marca.fromValue(rs.getInt("idmarca"));
            Estado estado = Estado.fromValue(rs.getInt("idestado"));
            Categoria categoria = Categoria.fromValue(rs.getInt("idcategoria"));
            Double valorCompra = rs.getDouble("valorcompra");
            String placa = rs.getString("placa");
            Integer ano = rs.getInt("ano");
            if (estado.equals(Estado.LOCADO)) {
                Locacao locacao = new Locacao(null, rs.getInt("idveiculo"), null, null, null);
                locacao = LocacaoDao.buscar(locacao);
            }            
            Automovel a = new Automovel(modeloAutomovel, marca, estado, null, categoria, valorCompra, placa, ano);
        }
        
        close();
        return resultado;
    }
    
    public String montarQuery(Automovel automovel) {
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT * FROM automovel WHERE 1=1");
        if (automovel != null) {
            if (automovel.getIdVeiculo() != null) {
                query.append(String.format(" AND idveiculo = %d ", automovel.getIdVeiculo()));
            }
            if (automovel.getModelo() != null && automovel.getModelo().getCodigo() != null) {
                query.append(String.format(" AND idmodeloautomovel = %d ", automovel.getModelo().getCodigo()));
            }
<<<<<<< HEAD
            if (automovel.getMarca() != null && automovel.getMarca().getCodigo() != null) {
                query.append(String.format(" AND idmarca = %d ", automovel.getMarca().getCodigo()));
=======
            if (automovel.getMarca() != null && automovel.getMarca().getIdMarca() != null) {
                query.append(String.format(" AND IDMARCA = %d ", automovel.getMarca().getIdMarca()));
>>>>>>> origin/master
            }
            if (automovel.getEstado() != null && automovel.getEstado().getCodigo() != null) {
                query.append(String.format(" AND idestado = %d ", automovel.getEstado().getCodigo()));
            }
<<<<<<< HEAD
            if (automovel.getCategoria() != null && automovel.getCategoria().getCodigo() != null) {
                query.append(String.format(" AND idcategoria = %d ", automovel.getCategoria().getCodigo()));
=======
            if (automovel.getCategoria() != null && automovel.getCategoria().getIdCategoria() != null) {
                query.append(String.format(" AND IDCATEGORIA = %d ", automovel.getCategoria().getIdCategoria()));
>>>>>>> origin/master
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