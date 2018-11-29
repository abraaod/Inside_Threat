/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

/**
 *
 * @author Henrique
 */
public class Horario {
    
    int hora;
    int valor;

    /**
     * Construtor da classe Horário.
     * @param hora hora da realização da ação.
     * @param valor o valor do histograma naquela hora.
     */
    public Horario(int hora, int valor) {
        this.hora = hora;
        this.valor = valor;
    }

    /**
     * Retornar a hora.
     * @return retornar horário.
     */
    public int getHora() {
        return hora;
    }

    /**
     * Configurar a hora.
     * @param hora novo horário.
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Retornar valor.
     * @return retornar valor.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Configurar o valor de um horário.
     * @param valor novo horário.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Impressão do padrão de impressão.
     * @return retorna horário.
     */
    @Override
    public String toString() {
        return String.valueOf(this.hora);
    }
    
}
