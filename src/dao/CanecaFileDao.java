/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.ComparatorCanecaPorPrecoCrescente;
import domain.ComparatorCanecaPorPrecoDecrescente;
import domain.ComparatorCanecaPorBelezaCrescente;
import domain.ComparatorCanecaPorBelezaDecrescente;
import domain.ComparatorCanecaPorCorCrescente;
import domain.ComparatorCanecaPorCorDecrescente;
import domain.Caneca;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author Giovany
 */
public class CanecaFileDao {

    public void salvarCanecas(Vector<Caneca> canecas) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream arquivo = new FileOutputStream(CanecaFileInformation.getCaminhoArquivo() + CanecaFileInformation.getNomeArquivo());

        //Classe responsavel por inserir os objetos
        ObjectOutputStream objGravar = new ObjectOutputStream(arquivo);

        //Grava o objeto de vetor de Canecas no arquivo
        objGravar.writeObject(canecas);
        objGravar.flush();
        objGravar.close();
        arquivo.flush();
        arquivo.close();
    }

    private boolean estaArquivoVazio() throws FileNotFoundException, IOException {
        //Carrega o arquivo
        String local_arquivo = CanecaFileInformation.getCaminhoArquivo() + CanecaFileInformation.getNomeArquivo();
        FileInputStream arquivoLeitura = new FileInputStream(local_arquivo);
        boolean estaVazio = (arquivoLeitura.read() == -1);
        arquivoLeitura.close();
        return estaVazio;
    }

    public Vector<Caneca> obterCanecas() throws FileNotFoundException, IOException, ClassNotFoundException {
        //Carrega o arquivo
        if (estaArquivoVazio()) {
            return new Vector();
        } else {
            //Classe responsavel por recuperar os objetos do arquivo
            String local_arquivo = CanecaFileInformation.getCaminhoArquivo() + CanecaFileInformation.getNomeArquivo();
            FileInputStream arquivoLeitura = new FileInputStream(local_arquivo);
            ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
            Vector<Caneca> vetor = (Vector<Caneca>) objLeitura.readObject();
            objLeitura.close();
            arquivoLeitura.close();
            return vetor;
        }
    }

   
    public Vector<Caneca> obterCanecas(String coluna, boolean crescente) throws FileNotFoundException, IOException, ClassNotFoundException {
        Vector<Caneca> canecas = this.obterCanecas();
        if (coluna.equals("Preco")){
            if (crescente) Collections.sort(canecas, new ComparatorCanecaPorPrecoCrescente());
            else Collections.sort(canecas, new ComparatorCanecaPorPrecoDecrescente());
        }
        else if (coluna.equals("Cor")){
            if (crescente) Collections.sort(canecas, new ComparatorCanecaPorCorCrescente());
            else Collections.sort(canecas, new ComparatorCanecaPorCorDecrescente());
        }
        else if (coluna.equals("Beleza")){
            if (crescente) Collections.sort(canecas, new ComparatorCanecaPorBelezaCrescente());
            else Collections.sort(canecas, new ComparatorCanecaPorBelezaDecrescente());
        }
        return canecas;
    }
}
