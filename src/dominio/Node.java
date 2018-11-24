package dominio;

import java.util.HashMap;

/**
 *
 * @author Abraao
 *
 */
public class Node {

    private String id;
    private int[] hist;

    /**
     * Construtor para o nó.
     * 
     * @param id Identificador do nó.
     */
    public Node(String id) {
        this.id = id;
        hist = new int[24];

    }

    /**
     * Retorna o id.
     * 
     * @return retorna o identificador.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Modifica o valor do identificador.
     * 
     * @param id valor do identificador.
     */
    public void setId(String id) {
        this.id = id;
    }

    
    /**
     * Retorna o histograma.
     * 
     * @return vetor com os valores do histograma.
     */
    public int[] getHist() {
        return this.hist;
    }

    /**
     * Modifica o histograma.
     * 
     * @param hist novo histograma.
     */
    public void setHist(int[] hist) {
        this.hist = hist;
    }

    /**
     * 
     * Atualiza o valor do histograma.
     * 
     * @param pos posição a ser modificada.
     */
    public void updateHist(int pos) {
        hist[pos] += 1;
    }

}
