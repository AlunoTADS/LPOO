/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.data;

import java.util.List;

/**
 *
 * @author Lucas
 * @param <T>
 */
public interface DaoI<T> {
     public void inserir(T t) throws Exception;
    
    public void editar(T t) throws Exception;
    
    public void excluir(T t) throws Exception;
    
    public T buscar(T t) throws Exception;
    
    public List<T> listar(T t) throws Exception;

}
