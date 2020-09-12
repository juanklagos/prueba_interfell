/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysimplicado;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Juank
 */
public class ArraySimplicado {

    /**
     * @param args the command line arguments
     * 
     * 
    Diseñar un algoritmo en PHP, Javascript y Java (3 soluciones distintas), que
    simplifique un array multidimensional utilizando las mejores prácticas de desarrollo
    posibles. Se valorará la implementación de una función recursiva por sobre códigos
    extensos.
    Ejemplo de entrada: [ [ 1, 2, [ 3 ] ], 4, 5, [ 6, [ 7, 8, [ 10, [ 9 ] ] ] ] ]
    Salida requerida: [ 1, 2, 3, 4, 5, 6, 7, 8, 10, 9 ]
    Observar que se mantiene el orden del array de entrada.
     */
    public static void main(String[] args) {
        // Se usa la libreria Gson para convertir el array declarado en texto a un ArrayList multidimensional variable.
        String input = JOptionPane.showInputDialog(null, "Ingrese el array a simplificar:");
        if(input != null && input.length()>0){
            try{
               ArrayList<Object> list = new Gson().fromJson("[ [ 1, 2, [ 3 ] ], 4, 5, [ 6, [ 7, 8, [ 10, [ 9 ] ] ] ] ]", ArrayList.class);
               ArrayList result = simplification(list);
               System.out.println(result); 
               JOptionPane.showMessageDialog(null, "El resutado del proceso es :\n"+String.valueOf(result));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error en los datos de entrada.\n"+e.getMessage());
            }
        }
        
    }
    
    public static ArrayList simplification(ArrayList list){
        ArrayList result = new ArrayList<>();
        for(Object i : list){
            if (i instanceof Double){
                result.add(i);
            }else if(i instanceof ArrayList){
                simplification((ArrayList) i).forEach( item -> {result.add(item);});
            }
        }
        return result;
    }
    
    
    

    
}
