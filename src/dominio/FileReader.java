package dominio;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Abraao e Henrique
 *
 */
public class FileReader {

    /**
     * Realiza a leitura dos arquivos com as informações dos usuários.
     *
     * @param tree árvore a qual será gerado os dados.
     * @param FileName arquivo com os dados para a leitura.
     */
    public void read_ldap(Tree_insiders tree, File FileName) {

        FileInputStream file = null;
        BufferedReader br = null;
        try {
            file = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(file));

            // jump first line
            br.readLine();

            String sNull = "";

            while ((sNull = br.readLine()) != null) {
                String text = sNull;
                String[] spliter = text.split(",");
                User user = new User(spliter[0], spliter[1], spliter[2], spliter[3], spliter[4]);
                tree.insertUser(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Realiza a leitura dos dados dos dispositivos.
     *
     * @param tree árvore a qual será formado os dados no final.
     * @param FileName arquivo com os dados dos dispositivos.
     */
    public void read_input(Tree_insiders tree, File FileName) {
        FileInputStream file = null;
        BufferedReader br = null;
        try {
            file = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(file));

            // jump first line
            br.readLine();

            String sNull = null;
            while ((sNull = br.readLine()) != null) {
                String text = sNull;
                String[] spliter = text.split(",");
                String[] date_id = spliter[1].split(" ");
                String hours = date_id[1];
                String[] user_id = spliter[2].split("/");
                Date date = new Date(date_id[0], user_id[1]);
                tree.insertDate(date);
                Device device = new Device(spliter[3], user_id[1], date_id[0]);
                tree.insertDevice(device);
                if (spliter[4].equalsIgnoreCase("connect")) {
                    tree.insertConnect(device, hours);
                } else {
                    tree.insertDisconnect(device, hours);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Realiza a leitura das URLs.
     *
     * @param tree árvore para a formação dos dados.
     * @param FileName arquivo com os dados das URL's.
     */
    public void read_http(Tree_insiders tree, File FileName) {
        FileInputStream file = null;
        BufferedReader br = null;
        //Scanner sc = null;
        try {
            file = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(file));

            // jump first line
            br.readLine();

            String sNull = null;

            while ((sNull = br.readLine()) != null) {
                String text = sNull;
                String[] spliter = text.split(",");
                String[] date_id = spliter[1].split(" ");
                String[] user_id = spliter[2].split("/");
                Date date = new Date(date_id[0], user_id[1]);
                tree.insertDate(date);
                Device device = new Device(spliter[3], user_id[1], date_id[0]);
                tree.insertDevice(device);
                tree.insertUrl(device, spliter[4], date_id[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();

        } finally {
            if (file != null) {
                try {
                    file.close();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Realiza a leitura do arquivo de logins.
     *
     * @param tree árvore para a geração do nó.
     * @param FileName arquivo a ser feita a leitura.
     */
    public void read_logon(Tree_insiders tree, File FileName) {
        FileInputStream file = null;
        BufferedReader br = null;
        int contador = 0;
        try {
            file = new FileInputStream(FileName);
            br = new BufferedReader(new InputStreamReader(file));
            //sc = new Scanner(file, "UTF-8");

            // jump first line
            br.readLine();

            String sNull = null;

            while ((sNull = br.readLine()) != null) {
                String text = sNull;
                String[] spliter = text.split(",");
                String[] date_id = spliter[1].split(" ");
                String[] user_id = spliter[2].split("/");
                Date date = new Date(date_id[0], user_id[1]);
                tree.insertDate(date);
                Device device = new Device(spliter[3], user_id[1], date_id[0]);
                tree.insertDevice(device);
                if (spliter[4].equalsIgnoreCase("logon")) {
                    tree.insertLogon(device, date_id[1]);
                } else {
                    tree.insertLogon(device, date_id[1]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
