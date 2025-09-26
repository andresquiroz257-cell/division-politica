package servicios;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import com.fasterxml.jackson.databind.ObjectMapper;

import entidades.Ciudad;
import entidades.Pais;
import entidades.Region;

public class paisServicio {

    private static List<Pais> paises;

    public static void cargarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            String nombreArchivo = System.getProperty("user.dir")
                    + "/src/datos/DivisionPolitica.json";
            paises = objectMapper.readValue(new File(nombreArchivo),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Pais.class));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudieron cargar los datos" + e);
        }
    }
 
    public static void mostrar (DefaultMutableTreeNode nodoRaiz){
        if (paises != null)
            for(Pais p : paises){
                DefaultMutableTreeNode nodoPais = new DefaultMutableTreeNode(p.getNombre());
                nodoRaiz.add(nodoPais);
            }
    }
}
