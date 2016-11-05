package br.ufpr.model;

/**
 *
 * @author Matheus
 */
public enum Categoria {

    POPULAR(1, "Popular"),
    INTERMEDIARIO(2, "Intermediario"),
    LUXO(3, "Luxo");

    private Integer idCategoria;
    private String descricao;

    Categoria(Integer idCategoria, String descricao) {
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }

    public static Categoria fromValue(Integer idCategoria) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getIdCategoria() == idCategoria) {
                return categoria;
            }
        }
        return null;
    }

    public Integer getIdCategoria() {
        return idCategoria;

    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}
