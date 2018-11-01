/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.File;
import javax.swing.JFileChooser;
import java.util.Scanner;

/**
 *
 * @author henriquedavid
 */
public class OpenFiles {

    final JFileChooser fc;
    StringBuilder sb;
    Scanner input;

    public OpenFiles() {
        fc = new JFileChooser();
        sb = new StringBuilder();
    }

    public void getFiles() throws Exception {

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File[] file = fc.getSelectedFiles();

            for (File tx : file) {
                input = new Scanner(tx);

                while (input.hasNext()) {
                    sb.append(input.hasNextLine());
                    sb.append("\n");
                }

            }

            input.close();

        } else {
            sb.append("Nenhum arquivo selecionado!");
        }
    }

}
