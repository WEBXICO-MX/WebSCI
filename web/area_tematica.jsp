<%-- 
    Document   : area_tematica
    Created on : 6/10/2014, 11:24:17 AM
    Author     : Roberto Eder Weiss Juárez
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SCI | Áreas Temáticas</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/css/sci.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <img src="${pageContext.request.contextPath}/img/headernuevologo.png" alt="SCI | Servicios de Capacitación para la Industria" class="img-responsive"/>
                    <h1 class="text-center">SCI | Servicios de Capacitación para la Industria</h1>
                </div>
                <div class="col-sm-12">
                    <h3 class="text-center">CLAVES Y DENOMINACIONES DEL CATALOGO DE AREAS TEMATICAS DE LOS CURSOS</h3>
                    <s:form  action="saveOrUpdateAreaTematica">
                        <s:push value="areaTematica">
                            <s:hidden name="cve_area_tematica" />
                            <s:textfield name="clave_del_area" label="Clave del área" maxLength="10" size="10" />
                            <s:textfield name="nombre" label="Nombre área temática" maxLength="50" size="30"/>
                            <s:checkbox name="activo" fieldValue="true" label="Activo" />
                            <s:reset value="Reset" /><s:submit />
                        </s:push>
                    </s:form><br/>
                    <s:if test="areaTematicaList.size() > 0">
                        <div class="content">
                            <table class="areaOcupacionTable" cellpadding="5px">
                                <tr class="even">
                                    <th>ID</th>
                                    <th>Clave del área</th>
                                    <th>Nombre área temática</th>
                                    <th>Activo</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                                <s:iterator value="areaTematicaList" status="areaTematicaStatus">
                                    <tr class="<s:if test="#areaTematicaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
                                    <td><s:property value="cve_area_tematica" /></td>
                                    <td><s:property value="clave_del_area" /></td>
                                    <td><s:property value="nombre" /></td>
                                    <td><s:property value="activo" /></td>
                                    <td><s:url id="editURL" action="editAreaTematica">
                                        <s:param name="id" value="%{cve_area_tematica}"></s:param>
                                    </s:url> <s:a href="%{editURL}">Edit</s:a>
                                    </td>
                                    <td><s:url id="deleteURL" action="deleteAreaTematica">
                                        <s:param name="id" value="%{cve_area_tematica}"></s:param>
                                    </s:url> <s:a href="%{deleteURL}">Delete</s:a>
                                    </td>
                                    </tr>
                                </s:iterator>
                            </table>
                        </div>
                    </s:if>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jQuery/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
