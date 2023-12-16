/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.Comparator;

/**
 *
 * @author Giovany
 */
public class ComparatorCanecaPorCorDecrescente implements Comparator<Caneca> {
    public int compare(Caneca o1, Caneca o2) {
        int valor = o2.getCor().compareTo(o1.getCor());
        return valor;
    }
}
