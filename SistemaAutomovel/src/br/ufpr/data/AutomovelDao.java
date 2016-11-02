/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.data;

import br.ufpr.model.Automovel;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class AutomovelDao extends Dao {
    
    public void inserir(Automovel automovel) throws Exception {
        
    }
    
    public void editar(Automovel automovel) throws Exception {
        
    }
    
    public void excluir(Automovel automovel) throws Exception {
        
    }
    
    public Automovel buscar(Automovel automovel) throws Exception {
        return null;
    }
    
    public List<Automovel> listar(Automovel automovel) throws Exception {
        List<Automovel> resultado = null;
        open();
        
        stmt = con.prepareStatement(montarQuery(automovel));

        
        return resultado;
    }
    
    public String montarQuery(Automovel automovel) {
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT * FROM AUTOMOVEL WHERE 1=1");
        if (automovel != null) {
            if (automovel.getIdVeiculo() != null) {
                query.append(String.format(" AND IDVEICULO = %d ", automovel.getIdVeiculo()));
            }
            if (automovel.getModelo() != null && automovel.getModelo().getCodigo() != null) {
                query.append(String.format(" AND IDMODELOAUTOMOVEL = %d ", automovel.getModelo().getCodigo()));
            }
            if (automovel.getMarca() != null && automovel.getMarca().getCodigo() != null) {
                query.append(String.format(" AND IDMARCA = %d ", automovel.getMarca().getCodigo()));
            }
            if (automovel.getEstado() != null && automovel.getEstado().getCodigo() != null) {
                query.append(String.format(" AND IDESTADO = %d ", automovel.getEstado().getCodigo()));
            }
            if (automovel.getCategoria() != null && automovel.getCategoria().getCodigo() != null) {
                query.append(String.format(" AND IDCATEGORIA = %d ", automovel.getCategoria().getCodigo()));
            }
            if (automovel.getValorCompra() != null) {
                query.append(String.format(" AND VALORCOMPRA = %f ", automovel.getValorCompra()));
            }
            if (automovel.getPlaca() != null) {
                query.append(String.format(" AND PLACA = '%s' ", automovel.getPlaca()));
            }
            if (automovel.getAno() != 0) {
                query.append(String.format(" AND ANO = %d ", automovel.getAno()));
            }
        }
        
        return query.toString();
    }
}