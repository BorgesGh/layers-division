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
public class ComparatorCanecaPorBelezaDecrescente implements Comparator<Caneca> {
    public int compare(Caneca o1, Caneca o2) {
        return Integer.compare(o2.getBeleza(), o1.getBeleza());
    }

}
