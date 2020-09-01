package serviciosWeb;

import estructural.Paciente;

import java.util.ArrayList;
import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import servicios.ServicioPaciente;

@WebService(serviceName = "ServicioPacienteSW")
public class PacienteSW {
    public PacienteSW() {
        super();
    }

    @WebMethod
    public int agregarPaciente(@WebParam(name = "arg0") Paciente paciente) 
       {
         return ServicioPaciente.agregarPaciente(paciente);
       }

    @WebMethod
    public Paciente buscarPaciente(@WebParam(name = "arg0") String Documento)
       {
           return ServicioPaciente.buscarPaciente(Documento);
        }

    @WebMethod
    public int modificarPaciente(@WebParam(name = "arg0") Paciente paciente,
                                 @WebParam(name = "arg1") String Documento) 
        {
           return ServicioPaciente.modificarPaciente(paciente, Documento);
        }

    @WebMethod
    @Oneway
    public void eliminarPaciente(@WebParam(name = "arg0") String Documento)
    {
           ServicioPaciente.eliminarPaciente(Documento);
            
        }

    @WebMethod
    public List listar(){
           
             return ServicioPaciente.listar();
        }

    @WebMethod
    public List listarPorParametro(@WebParam(name = "arg0") String nombre) {
          return ServicioPaciente.listarPorParametro(nombre);
       }
    
}
