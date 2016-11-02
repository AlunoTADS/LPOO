package br.ufpr.model;

/**
 * @see Motocicleta
 * @author Lucas
 */
public enum ModeloMotocicleta {

    CG_125(1, "CG 125"),
    CB_500(2, "CB 500"),
    CBR_500(3, "CBR 500"),
    XTZ_125(4, "XTZ 125");/*Quem quiser adicionar valores aqui, fique a vontade*/

    private Integer idModeloMotocicleta;
    private String descricao;

    ModeloMotocicleta(Integer idModeloMotocicleta, String descricao) {
        this.idModeloMotocicleta = idModeloMotocicleta;
        this.descricao = descricao;
    }

    public int getIdModeloMotocicleta() {
        return idModeloMotocicleta;
    }

    public String getDescricao() {
        return descricao;
    }

}
