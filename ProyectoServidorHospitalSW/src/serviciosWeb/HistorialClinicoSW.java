package serviciosWeb;

import estructural.Enfermedad;
import estructural.HistorialClinico;

import java.util.ArrayList;
import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import servicios.ServicioHistorialClinico;

@WebService(serviceName = "ServicioHistorialClinicoSW")
public class HistorialClinicoSW {
    public HistorialClinicoSW() {
        super();
    }

    @WebMethod
    public int agregarHistorial(@WebParam(name = "arg0") HistorialClinico historial) 
    {
         return ServicioHistorialClinico.agregarHistorial(historial);
    }

    @WebMethod
    public HistorialClinico buscarHistorial(@WebParam(name = "arg0") int pNumero,
                                            @WebParam(name = "arg1") String documento ){
         return ServicioHistorialClinico.buscarHistorial(pNumero,documento);
       }

    @WebMethod
    public int modificarHistorial(@WebParam(name = "arg0") HistorialClinico historial,
                                  @WebParam(name = "arg1") int numero) {
           return ServicioHistorialClinico.modificarHistorial(historial, numero);
       }

    @Oneway
    @WebMethod
    public void eliminarHistorial(@WebParam(name = "arg0") int pNumero) {
           ServicioHistorialClinico.eliminarHistorial(pNumero);
       }

    @WebMethod
    public List listarHistorial() {
           return ServicioHistorialClinico.listarHistorial();
        }


    @WebMethod
    public List listarHistorialPorParametro(@WebParam(name = "arg0") String nombre) {
            return ServicioHistorialClinico.listarHistorialPorParametro(nombre);
        }

    @WebMethod
    public HistorialClinico buscarHistorialSolo(@WebParam(name = "arg0") int pNumero){
          return ServicioHistorialClinico.buscarHistorialSolo(pNumero);
       }
   
    
    
}
