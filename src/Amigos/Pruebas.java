import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stephanie
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //llenandoGrafo(); // Al momento de llenar el grafo manualmente
        LeerArchivo leer = new LeerArchivo("C:\\Users\\stephanie\\Documents\\Amigos.txt");
        System.out.println("----------------------------------------------");

    }

    private static final class LeerArchivo {

        private ArrayList<String> nodos = new ArrayList<String>();
        private ArrayList<String> aristas = new ArrayList<String>();

        public LeerArchivo(String ruta) {
            //leer(ruta);
            llenandoGrafo();
        }

        public void leer(String nombre) {

            String linea = "";
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            try {

                archivo = new File(nombre);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                Scanner s = new Scanner(new File(nombre));
                while ((linea = br.readLine()) != null) {
                    nodos.add(linea.split(";")[0]);
                    aristas.add(linea.split(";")[1]);
                }
                s.close();
            } catch (IOException e) {
                System.out.println("Error:" + e.getMessage());
            }

        }

    //public static void llenandoGrafo(){
        //  Grafo grafo = new Grafo();
        public void llenandoGrafo() {

            javax.swing.JFileChooser j = new javax.swing.JFileChooser();
            j.showOpenDialog(j);
            String path = j.getSelectedFile().getAbsolutePath();
            leer(path);

            Grafo grafo = new Grafo();//<---Construimos al objeto grafo eh indicamos que estara definodo en  la clase Grafo

            for (int i = 0; i < nodos.size(); i++) {
                grafo.AgregarNodo(Integer.parseInt(nodos.get(i).split(",")[0]), nodos.get(i).split(",")[1]);
            }

            String[] tmp = null;
            for (int i = 0; i < aristas.size(); i++) {
                tmp = aristas.get(i).split(",");
                for (int k = 0; k < tmp.length; k++) {
                    grafo.AgregarArista( Integer.parseInt(nodos.get(i).split(",")[0]) , Integer.parseInt(tmp[k]));
                }
            }

                String lista = "";

                /*
                 //PRUEBA PRIMER GRAFO
                 grafo.AgregarNodo(1, "Stephanie Schoenherr");
                 grafo.AgregarNodo(2, "Kevin Lopez");
                 grafo.AgregarNodo(3, "Rosinda Lorenzana");
                 grafo.AgregarNodo(4, "Andres Torres");
                 grafo.AgregarNodo(5, "Karem Lorenzana");
                 grafo.AgregarNodo(6, "Tania Fiallos");
                 grafo.AgregarNodo(7, "Gerardo Bu");
                 grafo.AgregarNodo(8, "Britney Spears");
                 grafo.AgregarNodo(9, "David Reyes");
        
        
                 grafo.AgregarAristaDirigida(1, 9);
                 grafo.AgregarAristaDirigida(1, 3);
                 grafo.AgregarAristaDirigida(1, 6);
                 grafo.AgregarAristaDirigida(1, 4);
                 grafo.AgregarAristaDirigida(1, 8);
                 grafo.AgregarAristaDirigida(4, 5);
                 grafo.AgregarAristaDirigida(2, 5);
                 grafo.AgregarAristaDirigida(3, 6);             
                 grafo.AgregarAristaDirigida(3, 9);
                 grafo.AgregarAristaDirigida(5, 7); 
                 grafo.AgregarAristaDirigida(5, 8);
                 grafo.AgregarAristaDirigida(6, 9); 
                 grafo.AgregarAristaDirigida(7, 9);
                 grafo.AgregarAristaDirigida(8, 9);
                 */
                /* //PRUEBA 2 GRAFO
            
                 grafo.AgregarNodo(1, "Stephanie Schoenherr");
                 grafo.AgregarNodo(2, "Kevin Lopez");
                 grafo.AgregarNodo(3, "Daniel Acosta");
                 grafo.AgregarNodo(4, "Andres Torres");
                 grafo.AgregarNodo(5, "Karem Lorenzana");
                 grafo.AgregarNodo(6, "Tania Fiallos");
                 grafo.AgregarNodo(7, "Gerardo Bu");

                 grafo.AgregarAristaDirigida(1, 2);
                 grafo.AgregarAristaDirigida(1, 3);
                 grafo.AgregarAristaDirigida(1, 5);
                 grafo.AgregarAristaDirigida(2, 4);
                 grafo.AgregarAristaDirigida(2, 5);
                 grafo.AgregarAristaDirigida(3, 6);
                 grafo.AgregarAristaDirigida(3, 7);
                 grafo.AgregarAristaDirigida(4, 1);
                 grafo.AgregarAristaDirigida(4, 5);
                 grafo.AgregarAristaDirigida(6, 7);
             
                 */
                System.out.println("........................(LISTA AMIGOS)........................................");
                grafo.imprimirGrafo();
                System.out.println();
                System.out.println("....................RECORRIDO........................");
                System.out.println();
                grafo.recorrido();
                grafo.imprimirRecorrido();
                System.out.println();

                System.out.println("............SUBCONJUNTO MAS PEQUEÑO(SET COVER:)...............");
                System.out.println();
                grafo.SetCover();
                grafo.imprimirSetcover();
                System.out.println();
                System.out.println(".......................CLIQUE:......................");
                System.out.println();
                grafo.Clique();
            }
        }
}
        
