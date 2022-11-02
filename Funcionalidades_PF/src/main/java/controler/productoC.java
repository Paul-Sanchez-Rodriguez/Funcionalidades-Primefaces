package controler;

import dao.productoImpl;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modell.producto;

@Named(value = "ProductosC")
@SessionScoped
public class productoC implements Serializable {

    private List<producto> listadoProd;
    private producto prod;
    private productoImpl dao;

    private Integer numero1;

    public productoC() {
        prod = new producto();
        dao = new productoImpl();

    }

    public void listar() {
        try {
            listadoProd = dao.listar();
        } catch (Exception e) {
            System.out.println("Error en listarC" + e.getMessage());
        }
    }

    public void cancelar() {
        numero1 = null;
    }
    
    public void culmanado(){
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Carga completa"));
    }
    
    public void añadir(){
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Producto Añadido"));
    }

    public producto getProd() {
        return prod;
    }

    public void setProd(producto prod) {
        this.prod = prod;
    }

    public productoImpl getDao() {
        return dao;
    }

    public void setDao(productoImpl dao) {
        this.dao = dao;
    }

    public List<producto> getListadoProd() {
        return listadoProd;
    }

    public void setListadoProd(List<producto> listadoProd) {
        this.listadoProd = listadoProd;
    }

    public Integer getNumero1() {
        return numero1;
    }

    public void setNumero1(Integer numero1) {
        this.numero1 = numero1;
    }

    
}
