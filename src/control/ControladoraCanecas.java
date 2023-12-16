/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import dao.*;
import domain.Caneca;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;


public class ControladoraCanecas {
    private Vector<Caneca> canecas;
    private int marcador;
    CanecaFileDao canecaDao;
    
    private String obterNomeColunaBanco(String coluna) {
        if (coluna.equals("Cor"))
            return "Cor";
        if (coluna.equals("Preco"))
            return "Preco";
        if (coluna.equals("Beleza"))
            return "Beleza";
        return coluna.toString();
    }

    public ControladoraCanecas() {
        this.canecaDao = new CanecaFileDao();
    }
    
    private void atualizarCaneca(Caneca caneca, Vector linha){
        caneca.setBeleza(Integer.parseInt((String) linha.get(0)));
        caneca.setCor(linha.get(1).toString());
        caneca.setPreco(Double.parseDouble(linha.get(2).toString()));       
    }
    
    private Vector criarLinhaCaneca(Caneca caneca) {
        Vector linha = new Vector();
        linha.add(caneca.getBeleza());
        linha.add(caneca.getCor());
        linha.add(caneca.getPreco());
        return linha;
    }
     
    
    public void inserirNovoCaneca(Vector linha) throws FileNotFoundException, IOException, ClassNotFoundException{
        Caneca caneca = new Caneca();
        this.atualizarCaneca(caneca, linha);
        this.canecas.add(caneca);
        canecaDao.salvarCanecas(this.canecas);
    }
    
    public void setMarcador(int marcador){
        this.marcador = marcador;
    }

    public void alterarCaneca(Vector linha) throws FileNotFoundException, IOException, ClassNotFoundException {
        Caneca caneca = canecas.get(marcador);
        this.atualizarCaneca(caneca, linha);
        canecaDao.salvarCanecas(this.canecas);
    }
    
    public void  excluirCaneca() throws FileNotFoundException, IOException, ClassNotFoundException{
        canecas.remove(marcador);
        canecaDao.salvarCanecas(this.canecas);
    }
    
    private Vector<Caneca> obterCanecas(String coluna, boolean crescente) throws FileNotFoundException, IOException, ClassNotFoundException{
        String nomeColunaBanco = this.obterNomeColunaBanco(coluna);
        canecas = canecaDao.obterCanecas(nomeColunaBanco, crescente);
        return canecas; 
    }

    public Vector obterLinhasCanecas(String coluna, boolean crescente) throws FileNotFoundException, IOException, ClassNotFoundException {
        Vector<Caneca> canecas = obterCanecas(coluna, crescente);
        Vector linhas = new Vector();
        
        // Montando as linhas
        for(int i = 0; i < canecas.size(); i++){
            Caneca caneca = canecas.get(i);
            linhas.addElement(this.criarLinhaCaneca(caneca));
        }
        return linhas;
    }

}
