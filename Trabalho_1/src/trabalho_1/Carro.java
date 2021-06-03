/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_1;

/**
 *
 * @author Evandro Duarte
 */
public class Carro implements Comparable<Carro> {

    private Integer id;
    private Integer probAbastecimento;
    private Integer probQuebra;
    Integer avarias;

    public Carro() {
        this.id = id;
        this.probAbastecimento = probAbastecimento;
        this.probQuebra = probQuebra;
        this.avarias = avarias;
    }

    @Override
    public String toString() {
        return "{" + "id='" + id + '\''
                + ", avarias=" + avarias + '}';
    }

    @Override
    public int compareTo(Carro c) {
        if (this.avarias != c.getAvarias()) {
            return this.avarias - c.getAvarias();
        }
        return this.avarias.compareTo(c.getAvarias());
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAbs(Integer probAbastecimento) {
        this.probAbastecimento = probAbastecimento;
    }

    public void setQuebra(Integer probQuebra) {
        this.probQuebra = probQuebra;
    }

    public int getId() {
        return id;
    }

    public int getProbAbs() {
        return probAbastecimento;
    }

    public int getProbQuebra() {
        return probQuebra;
    }

    public void setAvarias(Integer avarias) {
        this.avarias = avarias;
    }

    public int getAvarias() {
        return avarias;
    }

}
