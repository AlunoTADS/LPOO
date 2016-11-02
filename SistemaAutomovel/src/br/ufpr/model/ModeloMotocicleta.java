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

    private Integer codigo;
    private String descricao;

    ModeloMotocicleta(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

}
