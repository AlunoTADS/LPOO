package br.ufpr.model;

/**
 *
 * @author Giovanni
 */
public enum Marca {

    VW(1, "Volkswagen"),
    GM(2, "General Motors"),
    FIAT(3, "Fiat"),
    HONDA(4, "Honda"),
    MERCEDES(5, "Mercedes"),
    VOLVO(6, "Volvo"),
    AUDI(7, "Audi"),
    FORD(8, "Ford"),
    KIA(9, "KIA"),
    TOYOTA(10, "Toyota"),
    LAND_ROVER(11, "Land Rover"),
    DODGE(12, "Dodge"),
    JAGUAR(13, "Jaguar"),
    PORSCHE(14, "Porsche");

    private Integer idMarca;
    private String descricao;

    private Marca(Integer idMarca, String descricao) {
        this.idMarca = idMarca;
        this.descricao = descricao;
    }

    public static Marca fromValue(Integer idMarca) {
        for (Marca marca : Marca.values()) {
            if (marca.getIdMarca() == idMarca) {
                return marca;
            }
        }
        return null;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}
