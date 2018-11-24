package dominio;

import java.util.Vector;

/**
 *
 * @author Abraao.
 *
 */
public class Http extends Node {

    
    private Vector<String> urls;

    /**
     * Construtor para a classe. Inicializar o vetor e informar o identificador.
     * 
     * @param id identificador da URL.
     */
    public Http(String id) {
        super(id);
        urls = new Vector<>();
    }

    
    /**
     * Adicionar uma nova URL.
     * 
     * @param url url a ser adicionada.
     */
    public void addUrl(String url) {
        this.urls.add(url);
    }

    /**
     * Retornar vetor com as urls.
     * 
     * @return vetor com todas as URLs.
     */
    public Vector<String> getUrls() {
        return urls;
    }

    /**
     * Configurar o vetor de URLs.
     * 
     * @param urls vetor com as urls.
     */
    public void setUrls(Vector<String> urls) {
        this.urls = urls;
    }

}
