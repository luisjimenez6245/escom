/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author luis
 */
public class Nav extends object<Nav> {

    public Long id;
    public String nombreMenu;
    public String direccion;
    public String accion;
    public int posicion;
    public int status;

    public Nav() {
    }

    public Nav(Long id, String nombreMenu, String direccion, String accion, int posicion, int status) {
        this.id = id;
        this.nombreMenu = nombreMenu;
        this.direccion = direccion;
        this.accion = accion;
        this.posicion = posicion;
        this.status = status;
    }

    @Override
    public String toJSON() {
        return "{ nav_id: " + id + ", nombre_menu: '" + nombreMenu + "' ,direccion:'" + direccion + "', accion: '" + accion + "', posicion: " + posicion + ", status: " + status + " }";
    }
 /*
    @Override
    public Nav parse(HttpServletRequest request) {
        return new Nav(
                request.getParameter("id_nav") == null ? 0 : Long.parseLong(request.getParameter("id_nav")),
                request.getParameter("nombreMenu") == null ? "" : request.getParameter("nombreMenu"),
                request.getParameter("direccion") == null ? "" : request.getParameter("direccion"),
                request.getParameter("accion") == null ? "" : request.getParameter("accion"),
                request.getParameter("posicion") == null ? 0 : Integer.parseInt(request.getParameter("posicion")),
                request.getParameter("status") == null ? 0 : Integer.parseInt(request.getParameter("status"))
        );
    }

    @Override
    public Nav parse(ResultSet res) {
        try {
            if (res.next()) {
                return new Nav(res.getLong("idMenu"), res.getString("nombreMenu"), res.getString("direccion"), res.getString("accion"), res.getInt("posicion"), res.getInt("status"));
            } else {
                return new Nav(0L, "", "", "", 0, 0);
            }
        } catch (SQLException ex) {
            new logger().error(ex);
            return null;
        }
    }

    @Override
    public List<nav> parseList(HttpServletRequest request) {
        ArrayList<nav> contenedorNav = new ArrayList<>();
        if (request.getParameter("list_nav") != null) {
            new Gson().fromJson(request.getParameter("list_nav"), Nav.class);
        }

        return contenedorNav;
    }

    @Override
    public List<nav> parseList(ResultSet res) {
        ArrayList<nav> contenedorNav = new ArrayList<>();
        try {
            while (res.next()) {
                contenedorNav.add(new Nav(res.getLong("idMenu"), res.getString("nombreMenu"), res.getString("direccion"), res.getString("accion"), res.getInt("posicion"), res.getInt("status")));
            }
            res.close();
        } catch (SQLException ex) {
            new logger().error(ex);
        }
        return contenedorNav;
    }*/
}
