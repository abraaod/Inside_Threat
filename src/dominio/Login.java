package dominio;

/**
 * @author Abraao
 */
public class Login extends Node {
    
    Logon logon;
    Logoff logoff;

    /** Construtor da classe Login.
     * 
     * @param id Identificador de logon e logoff
     */
    public Login(String id) {
        super(id);
        logon = new Logon(id);
        logoff = new Logoff(id);
    }

    /**
     * Atualizar o horário de logon.
     * 
     * @param pos horário a ser alterado.
     */
    public void logonUpdate(int pos) {
        logon.updateHist(pos);
    }

    /**
     * Atualizar o horário de logoff.
     * 
     * @param pos horário a ser alterado.
     */
    public void logoffUpdate(int pos) {
        logoff.updateHist(pos);
    }

    /**
     * Retorna a classe de Logon.
     * 
     * @return classe logon, que possui a quantidade de logons.
     */
    public Logon getLogon() {
        return logon;
    }

    /**
     * Configura/Muda a classelogon.
     * 
     * @param logon Classe logon.
     */
    public void setLogon(Logon logon) {
        this.logon = logon;
    }
    
    
    /**
     * Retorna a classe logoff.
     * 
     * @return retorna a classe logoff.
     */
    public Logoff getLogoff() {
        return logoff;
    }

    /** Modifica a classe de logoff.
     * 
     * @param logoff Classe de logoff.
     */
    public void setLogoff(Logoff logoff) {
        this.logoff = logoff;
    }

    /** Retorna o histograma gerado pelo logon e logoff tornando em um só.
     * 
     * @return retorno com um único histograma com a quantidade de login total.
     */
    public int[] getHist() {
        int[] a = logon.getHist();
        int[] b = logoff.getHist();
        int[] hist = new int[24];
        for (int i = 0; i < hist.length; i++) {
            hist[i] = a[i] + b[i];
        }
        return hist;

    }

}
