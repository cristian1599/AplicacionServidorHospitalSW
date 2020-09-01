package estructural;

public class Enfermedad {
    public Enfermedad() {
        super();
    }
    
      private  int codigo;
      private  String nombre;
      private  String tipo;

      

        public Enfermedad(int codigo, String nombre, String tipo) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.tipo = tipo;
        }

        public int getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        @Override
        public String toString() {
            return "Enfermedades{" + "codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + '}';
        }
}
