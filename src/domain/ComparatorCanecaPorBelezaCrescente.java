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
public class ComparatorCanecaPorBelezaCrescente implements Comparator<Caneca> {
    public int compare(Caneca o1, Caneca o2) {
        return Integer.compare(o1.getBeleza(), o2.getBeleza());
    }

}
