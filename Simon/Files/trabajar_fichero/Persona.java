package trabajar_fichero;

public class Persona {
	
    private String nombre;
    private int edad;
    private String telefono;
    private String lugar;

    public Persona(String nombre, int edad, String telefono, String lugar) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.lugar = lugar;
    }

  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", lugar='" + lugar + '\'' +
                '}';
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 25, "666555777", "Vitoria-Gasteiz");
        System.out.println(persona);
    }
}
