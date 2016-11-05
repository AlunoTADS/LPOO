package br.ufpr.model;

/**
 *
 * @author Matheus
 */
public enum Estado {
    NOVO(1, "Novo"),
    LOCADO(2, "Locado"),
    DISPONIVEL(3, "Disponivel"),
    VENDIDO(4, "Vendido");

    private Integer idEstado;
    private String descricao;

    private Estado(Integer codigo, String descricao) {
        this.idEstado = codigo;
        this.descricao = descricao;
    }

    public static Estado fromValue(Integer idEstado) {
        for (Estado estado : Estado.values()) {
            if (estado.getIdEstado() == idEstado) {
                return estado;
            }
        }
        return null;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}
