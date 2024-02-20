package trabajar_fichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GestionAgenda {

    private String nombreDeArchivo;

    public GestionAgenda(String nombreDeArchivo) {
        this.nombreDeArchivo = nombreDeArchivo;
    }

    //Lee el archivo creado a mano
    public void ver() {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreDeArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
    
    public void anadePersona(Persona persona) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.nombreDeArchivo, true)))) {
            // Suponiendo que la clase Persona tiene métodos getters para sus atributos
            String infoPersona = persona.getTelefono() + "\t" +
                                 persona.getEdad() + "\t" +
                                 persona.getNombre() + "\t" +
                                 persona.getLugar();
            out.println(infoPersona);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    //Un metodo similar al de anterior pero general
    public static void escribirEnArchivo(String rutaArchivo, String texto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            // Escribe el texto en el archivo y añade una nueva línea
            bw.write(texto);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    //EL metodo comproba si 'param' nombre esta en la linea 'param'
    public boolean nombreEnLinea(String linea, String nombre) {
        String[] partes = linea.split("\t"); // el separador es el tabulador
        // Verifica si el nombre es el segundo elemento en la línea
        return partes.length > 1 && partes[1].trim().equalsIgnoreCase(nombre.trim());
    }
    
    
    // Método que transforma una línea de texto en un objeto Persona
    public Persona transforma(String linea) {
        String[] partes = linea.split("\t");
        // Asumiendo que el orden es: teléfono, edad, nombre, lugar
        String telefono = partes[0].trim();
        int edad = Integer.parseInt(partes[1].trim());
        String nombre = partes[2].trim();
        String lugar = partes[3].trim();

        return new Persona(nombre, edad, telefono, lugar);
    }
    
    
    //Buscar segun el nombre de la persona
    public Persona buscarPersona(String nombreBuscado) {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.nombreDeArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (nombreEnLinea(linea, nombreBuscado)) {
                    return transforma(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
        return null; // Retorna null si no encuentra la persona
    }
    
    
    
    
    
    //ELiminar con nombre de la persona
    public void eliminarPersona(String nombre) {
        File archivoOriginal = new File(nombreDeArchivo);
        File archivoTemporal = new File(archivoOriginal.getAbsolutePath() + ".tmp");

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal))) {

            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                // Divide la línea por tabulador y verifica si el nombre no coincide
                if (!nombreEnLinea(lineaActual, nombre)) {
                    writer.write(lineaActual);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer o escribir en el archivo: " + e.getMessage());
            return;
        }

        // Elimina el archivo original y renombra el temporal con el nombre del original
        if (!archivoOriginal.delete()) {
            System.out.println("No se pudo eliminar el archivo original.");
            return;
        }

        if (!archivoTemporal.renameTo(archivoOriginal)) {
            System.out.println("No se pudo renombrar el archivo temporal al nombre del original.");
        }
    }

    
    //ELiminar con la instancia de una persona
    public void eliminarPersona(Persona personaAEliminar) {
        File archivoOriginal = new File(nombreDeArchivo);
        File archivoTemporal = new File(archivoOriginal.getAbsolutePath() + ".tmp");

        List<String> lineasConservadas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal))) {
            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                // Utiliza el método transforma para convertir la línea a un objeto Persona
                Persona personaEnLinea = transforma(lineaActual);
                // Compara si la persona actual no es la que se quiere eliminar
                if (!personaAEliminar.getNombre().equalsIgnoreCase(personaEnLinea.getNombre())) {
                    lineasConservadas.add(lineaActual);
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
            return;
        }

        // Escribe las líneas conservadas al archivo temporal
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTemporal))) {
            for (String linea : lineasConservadas) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo temporal: " + e.getMessage());
            return;
        }

        // Elimina el archivo original y renombra el temporal con el nombre del original
        if (!archivoOriginal.delete()) {
            System.out.println("No se pudo eliminar el archivo original.");
            return;
        }

        if (!archivoTemporal.renameTo(archivoOriginal)) {
            System.out.println("No se pudo renombrar el archivo temporal al nombre del original.");
        }
    }
    
    
    
    
    
    
   public static void main(String[] args) {
        GestionAgenda gestionAgenda = new GestionAgenda("C:\\Users\\elmoh\\OneDrive\\Documentos\\Java primero\\Files\\src\\trabajar_fichero\\persona.txt");
        gestionAgenda.ver();
        
        //Persona p = new Persona("moha", 23, "12345678", "Aretxa");
        //gestionAgenda.anadePersona(p);

        
        System.out.println(gestionAgenda.buscarPersona("Juan").toString());
        
    }
	
	
}
