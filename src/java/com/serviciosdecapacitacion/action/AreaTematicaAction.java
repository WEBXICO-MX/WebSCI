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
import com.serviciosdecapacitacion.dao.AreaTematicaDAO;
import com.serviciosdecapacitacion.dao.DAOFactory;
import com.serviciosdecapacitacion.model.AreaTematica;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class AreaTematicaAction extends ActionSupport implements ModelDriven {

    AreaTematica areaTematica = new AreaTematica();
    List<AreaTematica> areaTematicaList = new ArrayList<AreaTematica>();
    AreaTematicaDAO areaTematicaDAO = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getAreaTematicaDAO();

    public AreaTematicaAction() {
    }

    @Override
    public String execute() {
        return Action.SUCCESS;
    }

    public String saveOrUpdate() {
        areaTematicaDAO.saveOrUpdate(areaTematica);
        return Action.SUCCESS;
    }

    public String list() {
        areaTematicaList = areaTematicaDAO.findAll();
        return Action.SUCCESS;
    }

    public String edit() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        areaTematica = areaTematicaDAO.findById(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        areaTematicaDAO.delete(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    @Override
    public Object getModel() {
        return areaTematica;
    }

    public AreaTematica getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(AreaTematica areaTematica) {
        this.areaTematica = areaTematica;
    }

    public List<AreaTematica> getAreaTematicaList() {
        return areaTematicaList;
    }

    public void setAreaTematicaList(List<AreaTematica> areaTematicaList) {
        this.areaTematicaList = areaTematicaList;
    }

}
