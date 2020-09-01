package serviciosWeb;

import estructural.Enfermedad;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import servicios.SerivicioEnfermedad;


@WebService(name = "ServicioEnfermedadSW", serviceName = "ServicioEnfermedadSW", portName = "ServicioEnfermedadSWPort")
public class EnfermedadSW {
    public EnfermedadSW() {
        super();
    }

    @WebMethod
    public List listarEnfermedades() {
               
       return SerivicioEnfermedad.listarEnfermedades();
       }

    @WebMethod
    public int agregarEnfermedad(@WebParam(name = "arg0") Enfermedad enfermedad) {
         return SerivicioEnfermedad.agregarEnfermedad(enfermedad);
       }
    
}
