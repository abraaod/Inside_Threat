/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Henrique
 */
public class FilterJFileChooser extends FileFilter {

    /**
     * Filter the files on the JFileChooser to just show ".csv" files.
     * 
     * @param f File accepted.
     * @return return if is valid.
     */
    @Override
    public boolean accept(File f) {
        String name = f.getName();
        return name.endsWith(".csv");
    }

    /**
     * Get description of the file.
     * 
     * @return return the .csv files.
     */
    @Override
    public String getDescription() {
        return "*.csv";
    }
    
}
