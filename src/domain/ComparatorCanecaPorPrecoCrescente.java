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
public class ComparatorCanecaPorPrecoCrescente implements Comparator<Caneca> {
    public int compare(Caneca o1, Caneca o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}
