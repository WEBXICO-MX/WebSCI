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
import com.serviciosdecapacitacion.dao.DAOFactory;
import com.serviciosdecapacitacion.dao.ProgramaCapacitacionDAO;
import com.serviciosdecapacitacion.model.ProgramaCapacitacion;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class ProgramaCapacitacionAction extends ActionSupport implements ModelDriven {

    ProgramaCapacitacion programa = new ProgramaCapacitacion();
    List<ProgramaCapacitacion> programaList = new ArrayList<>();
    ProgramaCapacitacionDAO programaDAO = DAOFactory.getDAOFactory(DAOFactory.MSSQLSERVER).getProgramaCapacitacionDAO();

    public ProgramaCapacitacionAction() {
    }

    @Override
    public String execute() {
        return Action.SUCCESS;
    }

    public String saveOrUpdate() {
        programaDAO.saveOrUpdate(programa);
        return Action.SUCCESS;
    }

    public String list() {
        programaList = programaDAO.findAll();
        return Action.SUCCESS;
    }

    public String edit() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        programa = programaDAO.findById(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    public String delete() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        programaDAO.delete(Integer.parseInt(request.getParameter("id")));
        return Action.SUCCESS;
    }

    @Override
    public Object getModel() {
        return programa;
    }

    public ProgramaCapacitacion getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaCapacitacion programa) {
        this.programa = programa;
    }

    public List<ProgramaCapacitacion> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<ProgramaCapacitacion> programaList) {
        this.programaList = programaList;
    }

}
