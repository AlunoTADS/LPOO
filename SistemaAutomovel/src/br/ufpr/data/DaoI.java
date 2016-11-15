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
