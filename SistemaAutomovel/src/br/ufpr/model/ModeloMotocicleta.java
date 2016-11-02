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


    private ModeloMotocicleta(Integer codigo, String descricao) {
        this.codigo = codigo;
=======
    ModeloMotocicleta(Integer idModeloMotocicleta, String descricao) {
        this.idModeloMotocicleta = idModeloMotocicleta;

        this.descricao = descricao;
    }
    
    public static ModeloMotocicleta fromValue(Integer codigo) {
        for (ModeloMotocicleta modelo : ModeloMotocicleta.values()) {
            if (modelo.getCodigo() == codigo) {
                return modelo;
            }
        }
        return null;
    }

    public int getIdModeloMotocicleta() {
        return idModeloMotocicleta;
    public Integer getCodigo() {
        return codigo;
    public int getIdModeloMotocicleta() {
        return idModeloMotocicleta;
