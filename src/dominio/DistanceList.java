/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author Henrique
 */
public class DistanceList extends Vector<Distance>{
    
    public DistanceList(){
        super();
    }
    
    public DistanceList sort(){
            DistanceList sorted = (DistanceList) this.clone();
            Collections.sort(sorted);
            
            return sorted;
    }
    
}
