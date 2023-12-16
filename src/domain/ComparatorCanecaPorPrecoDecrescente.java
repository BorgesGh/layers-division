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
public class ComparatorCanecaPorPrecoDecrescente implements Comparator<Caneca> {
    public int compare(Caneca o1, Caneca o2) {
        return  Double.compare(o2.getPreco(), o1.getPreco());
    }

}
