import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Libro> catalogoLibros;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        this.catalogoLibros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        catalogoLibros.add(libro);
    }

    public Libro consultarLibroPorISBN(String ISBN) {
        return catalogoLibros.stream()
                .filter(libro -> libro.getISBN().equals(ISBN))
                .findFirst()
                .orElse(null);
    }

    public void prestarLibro(Libro libro, Cliente cliente) {
        Prestamo prestamo = new Prestamo(libro, cliente);
        prestamos.add(prestamo);
    }

    public void devolverLibro(Prestamo prestamo) {
        prestamos.remove(prestamo);
    }

    public List<Prestamo> consultarPrestamosPorCliente(Cliente cliente) {
        return prestamos.stream()
                .filter(prestamo -> prestamo.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    public List<Libro> consultarLibrosPorAutor(Autor autor) {
        return catalogoLibros.stream()
                .filter(libro -> libro.getAutor().equals(autor))
                .collect(Collectors.toList());
    }
}

public class Libro {
    private String ISBN;
    private String titulo;
    private Autor autor;
    private String genero;
    private String estado;

    public Libro(String ISBN, String titulo, Autor autor, String genero, String estado) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.estado = estado;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", genero='" + genero + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

public class Prestamo {
    private int idPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Libro libro;
    private Cliente cliente;

    public Prestamo(Libro libro, Cliente cliente) {
        this.libro = libro;
        this.cliente = cliente;
        // Configurar fechas de préstamo y devolución
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo=" + idPrestamo +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                ", libro=" + libro +
                ", cliente=" + cliente +
                '}';
    }
}

public class Cliente {
    private String toString;

    public String getToString() {
        return toString;
    }

    public void setToString(String toString) {
        this.toString = toString;
    }

    @Override
    public String toString() {
        return toString;
    }
}

public class Autor extends Persona {
    private LocalDate fechaNacimiento;
    private LocalDate fechaFallecimiento;

    public Autor(String nombre, String apellido, String direccion, String telefono, LocalDate fechaNacimiento, LocalDate fechaFallecimiento) {
        super(nombre, apellido, direccion, telefono);
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaFallecimiento(LocalDate fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaFallecimiento=" + fechaFallecimiento;
    }
}

public class Persona {
    private int idPersona;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Persona(String nombre, String apellido, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @Override
public String toString() {
    return "Persona{" +
            "idPersona=" + idPersona +
            ", nombre='" + nombre + '\'' +
            ", apellido='" + apellido + '\'' +
            ", direccion='" + direccion + '\'' +
            ", telefono='" + telefono + '\'' +
            '}';
}