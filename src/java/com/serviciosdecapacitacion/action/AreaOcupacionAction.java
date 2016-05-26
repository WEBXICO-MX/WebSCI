/**
 *
 * @author Roberto Eder Weiss Juárez
 * @see {@link http://webxico.blogspot.mx/}
 */
package com.serviciosdecapacitacion.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.serviciosdecapacitacion.dao.AreaOcupacionDAO;
import com.serviciosdecapacitacion.dao.DAOFactory;
import com.serviciosdecapacitacion.model.AreaOcupacion;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class AreaOcupacionAction extends ActionSupport implements ModelDriven {

    AreaOcupacion areaOcupacion = new AreaOcupacion();
    List<AreaOcupacion> areaOcupacionList = new ArrayList<AreaOcupacion>();
    AreaOcupacionDAO areaOcupacionDAO = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getAreaOcupacionDAO();

    public AreaOcupacionAction() {
    }

    @Override
    public String execute() {
        return Action.SUCCESS;
    }

    public String saveOrUpdate() {
        areaOcupacionDAO.saveOrUpdate(areaOcupacion);
        return Action.SUCCESS;
    }

    public String list() {
        areaOcupacionList = areaOcupacionDAO.findAll();
        return Action.SUCCESS;
    }

    public String edit() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        areaOcupacion = areaOcupacionDAO.findById(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        areaOcupacionDAO.delete(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    @Override
    public Object getModel() {
        return areaOcupacion;
    }

    public AreaOcupacion getAreaOcupacion() {
        return areaOcupacion;
    }

    public void setAreaOcupacion(AreaOcupacion areaOcupacion) {
        this.areaOcupacion = areaOcupacion;
    }

    public List<AreaOcupacion> getAreaOcupacionList() {
        return areaOcupacionList;
    }

    public void setAreaOcupacionList(List<AreaOcupacion> areaOcupacionList) {
        this.areaOcupacionList = areaOcupacionList;
    }

    
}
