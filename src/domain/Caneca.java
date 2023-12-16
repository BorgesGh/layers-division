/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;


/**
 *
 * @author Giovany
 */
public class Caneca implements Serializable {
    private double preco;
    private int beleza;
    private String cor;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getBeleza() {
        return beleza;
    }

    public void setBeleza(int beleza) {
        this.beleza = beleza;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
