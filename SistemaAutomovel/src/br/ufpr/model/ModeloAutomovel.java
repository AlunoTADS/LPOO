package br.ufpr.model;

/**
 *
 * @author Matheus
 */
public enum ModeloAutomovel {
    GOL(1, "Gol"),
    CELTA(2, "Celta"),
    PALIO(3, "Palio"),
    CORSA(4, "Corsa");/*Quem quiser adicionar valores aqui, fique a vontade*/

    private Integer idModeloAutomovel;
    private String descricao;

    private ModeloAutomovel(Integer idModeloAutomovel, String descricao) {
        this.idModeloAutomovel = idModeloAutomovel;
        this.descricao = descricao;
    }

    public static ModeloAutomovel fromValue(Integer idModeloAutomovel) {
        for (ModeloAutomovel categoria : ModeloAutomovel.values()) {
            if (categoria.getIdModeloAutomovel() == idModeloAutomovel) {
                return categoria;
            }
        }
        return null;
    }

    public Integer getIdModeloAutomovel() {
        return idModeloAutomovel;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}
