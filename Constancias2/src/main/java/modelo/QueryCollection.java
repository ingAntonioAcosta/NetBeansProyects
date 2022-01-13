package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JComboBox;
import mapeo.*;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class QueryCollection {
    //Atributos:

    DataBase base;

    //Constructores:
    public QueryCollection() throws ClassNotFoundException, SQLException {
        base = new DataBase();
        System.out.println("qc creada");
    }

    //------------------------------------------------------------------ updates
    public void setEntregado(int folio, String fecha) throws SQLException {
        base.conectar();
        String sql = "UPDATE `docencia`.`constancias` SET `Entregado`= ? WHERE `Folio`= ?;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setDate(1, Date.valueOf(fecha));
        pstm.setInt(2, folio);
        pstm.execute();
    }

    //------------------------------------------------------------------ delete
    public void deleteListadoConstancias(Listado l) throws SQLException {
        base.conectar();
        String sql = "DELETE FROM `docencia`.`listadoConstancia` WHERE `listado`= ?;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, l.getNumero());
        pstm.execute();

    }

    public void deleteListado(Listado l) throws SQLException {
        base.conectar();
        deleteListadoConstancias(l);
        String sql = "DELETE FROM `docencia`.`listados` WHERE `numero`= ?;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, l.getNumero());
        pstm.execute();
    }

    //------------------------------------------------------------------ Inserts
    public void insertConstancia(Constancia constancia) throws SQLException, ClassNotFoundException {

        base.conectar();
        String sql = "INSERT INTO `docencia`.`constancias` (`Tipo`,`ClaveC`, `ClaveNE`, `Folio`, `Realizada`, `FechaE`, `TipoP`, `Enlace`, `Entregado`, `Reposicion`, `Entrega`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?);";

        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, constancia.getTipo());
        pstm.setInt(2, constancia.getClaveC());
        pstm.setInt(3, constancia.getClaveNE());
        pstm.setInt(4, constancia.getFolio());
        pstm.setString(5, constancia.getRealizada());
        pstm.setDate(6, constancia.getFechaE());
        pstm.setString(7, constancia.getTipoP());
        pstm.setString(8, constancia.getEnlace());
        pstm.setDate(9, constancia.getEntregado());
        pstm.setString(10, constancia.getReposicion());
        pstm.setString(11, constancia.getEntrega());

        pstm.execute();
        // base.cerrarConexion();
    }

    public void insertCurso(Curso curso) throws SQLException, ClassNotFoundException {

        base.conectar();
        String sql = "INSERT INTO `docencia`.`cursos` (`NombreCurso`, `NArchivo`, `FechaI`, `FechaF`, `Horas`, `FolioOficio`,`Obsx`, `Turno`, `Sede`) "
                + "VALUES (?,?,?,?,?,?,?,?,?);";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);

        pstm.setString(1, curso.getNombreCurso());
        pstm.setString(2, curso.getnArchivo());
        pstm.setDate(3, curso.getFechaI());
        pstm.setDate(4, curso.getFechaF());
        pstm.setInt(5, curso.getHoras());
        pstm.setInt(6, curso.getFolioOficio());
        pstm.setString(7, curso.getObsx());
        pstm.setString(8, curso.getTurno());
        pstm.setInt(9, curso.getSede());

        pstm.execute();
        // base.cerrarConexion();
    }

    public void insertConferencia(Conferencia conferencia) throws SQLException, ClassNotFoundException {

        base.conectar();
        String sql = "INSERT INTO `docencia`.`conferencias` (`NombreConf`, `MarcoConf`, `NArchivo`, `FechaI`, `Quees`, `foliooficio`, `Conj1`, `Sede`) "
                + "VALUES (?,?,?,?,?,?,?,?);";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);

        pstm.setString(1, conferencia.getNombreConf());
        pstm.setString(2, conferencia.getMarcoConf());
        pstm.setString(3, conferencia.getnArchivo());
        pstm.setDate(4, conferencia.getFechaI());
        pstm.setString(5, conferencia.getQuees());
        pstm.setInt(6, conferencia.getFolioOficio());
        pstm.setString(7, conferencia.getConj1());
        pstm.setInt(8, conferencia.getSede());
        pstm.execute();
        // base.cerrarConexion();
    }

    public void insertEvento(Evento evento) throws SQLException, ClassNotFoundException {
        base.conectar();

        String sql = "INSERT INTO `docencia`.`eventos` (`NombreEv`, `Conj1`, `Marco`, `NArchivo`, `FechaI`, `FechaF`, `Horas`, `FolioOficio`, `Quees`, `Llevado`, `Sede`, `Obsx`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);

        pstm.setString(1, evento.getNombreEv());
        pstm.setString(2, evento.getConj1());
        pstm.setString(3, evento.getMarco());
        pstm.setString(4, evento.getnArchivo());
        pstm.setDate(5, evento.getFechaI());
        pstm.setDate(6, evento.getFechaF());
        pstm.setInt(7, evento.getHoras());
        pstm.setInt(8, evento.getFolioOficio());
        pstm.setString(9, evento.getQuees());
        pstm.setString(10, evento.getLlevado());
        pstm.setInt(11, evento.getSede());
        pstm.setString(12, evento.getObsx());

        pstm.execute();

        // base.cerrarConexion();
    }

    public void insertMaterial(Material material) throws SQLException, ClassNotFoundException {
        base.conectar();

        String sql = "INSERT INTO `docencia`.`materiales` (`NombreMaterial`, `NArchivo`, `FolioOficio`, `Obsx`, `FechaI`, `FechaF`, `Sede`) "
                + "VALUES (?,?,?,?,?,?,?);";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);

        pstm.setString(1, material.getNombreMaterial());
        pstm.setString(2, material.getnArchivo());
        pstm.setInt(3, material.getFolioOficio());
        pstm.setString(4, material.getObsx());
        pstm.setDate(5, material.getFechaI());
        pstm.setDate(6, material.getFechaF());
        pstm.setInt(7, material.getSede());

        pstm.execute();

        //  base.cerrarConexion();
    }

    public void insertVisita(Visita visita) throws SQLException, ClassNotFoundException {
        base.conectar();

        String sql = "INSERT INTO `docencia`.`visitas` (`NombreVisita`, `Complemento`, `NArchivo`, `Quees`, `foliooficio`, `FechaI`, `FechaF`, `Sede`) "
                + "VALUES (?,?,?,?,?,?,?,?);";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);

        pstm.setString(1, visita.getNombreVisita());
        pstm.setString(2, visita.getComplemento());
        pstm.setString(3, visita.getnArchivo());
        pstm.setString(4, visita.getQuees());
        pstm.setInt(5, visita.getFolioOficio());
        pstm.setDate(6, visita.getFechaI());
        pstm.setDate(7, visita.getFechaF());
        pstm.setInt(8, visita.getSede());

        pstm.execute();

        // base.cerrarConexion();
    }

    public void insertListado(Listado l) throws SQLException, ClassNotFoundException {
        base.conectar();

        String sql = "INSERT INTO `docencia`.`listados` (`numero`, `fecha`, `desc`) "
                + "VALUES (?,?,?);";

        PreparedStatement pstm = base.getConexion().prepareStatement(sql);

        pstm.setInt(1, l.getNumero());
        pstm.setDate(2, l.getFecha());
        pstm.setString(3, l.getDesc());

        pstm.execute();

        // base.cerrarConexion();
    }

    public void insertListadoConstancia(Listado l, Constancia c) throws SQLException, ClassNotFoundException {
        base.conectar();

        String sql = "INSERT INTO `docencia`.`listadoConstancia` (`indice`, `listado`, `folio`) "
                + "VALUES (0,?,?);";

        PreparedStatement pstm = base.getConexion().prepareStatement(sql);

        pstm.setInt(1, l.getNumero());
        pstm.setInt(2, c.getFolio());

        pstm.execute();

        // base.cerrarConexion();
    }

    //---------------------------------------------------------------- Busquedas
    public HashMap selectAllConstancias() throws SQLException, ClassNotFoundException {
        base.conectar();

        System.out.println("BUSCANDO CONSTANCIAS");
        HashMap<Integer, Constancia> map = new HashMap();
        int contador = 0;

        String sql = "select constancias.*,concat(ApellidoP,' ',ApellidoM,' ',Nombre) as Nombre "
                + "from constancias, profesor "
                + "where profesor.ClaveNE = constancias.ClaveNE;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {

            Constancia c = new Constancia();
            c.setTipo(rs.getString("Tipo"));
            c.setClaveC(rs.getInt("ClaveC"));
            c.setClaveNE(rs.getInt("ClaveNE"));
            c.setFolio(rs.getInt("Folio"));
            c.setRealizada(rs.getString("Realizada"));

            try {
                c.setFechaE(rs.getDate("FechaE"));
            } catch (Exception e) {
                c.setFechaE(new Date(6666, 66, 6));
            }

            c.setTipoP(rs.getString("TipoP"));
            c.setEnlace(rs.getString("Enlace"));

            try {
                c.setEntregado(rs.getDate("Entregado"));
            } catch (Exception e) {
                c.setEntregado(new Date(6666, 66, 6));
            }

            c.setReposicion(rs.getString("Reposicion"));
            c.setEntrega(rs.getString("Entrega"));

            c.setNombreProfesor(rs.getString("Nombre"));
            c.setNombreEvento(nombreEvento(rs.getString("Tipo"), rs.getString("ClaveC")));

            map.put(contador, c);
            contador++;

        }

        //base.cerrarConexion();
        return map;
    }

    public HashMap selectConstanciasConFiltros(String folioI, String folioF, int area, String tipo, String fechaI, String fechaF, String tipoP, String claveNE, String claveC) throws SQLException, ClassNotFoundException {
        base.conectar();

        System.out.println("BUSCANDO CONSTANCIAS");
        HashMap<Integer, Constancia> map = new HashMap();
        int contador = 0;

        String sql = "select c.*, concat(p.ApellidoP,' ',p.ApellidoM,' ',p.Nombre) as Nombre"
                + " from constancias c, profesor p"
                + " where c.ClaveNE = p.ClaveNE";
        if (!folioI.isEmpty() && !folioF.isEmpty()) {//---------------------Folios
            sql = sql + " and c.Folio >=" + folioI
                    + " and c.Folio <=" + folioF;
        }
        if (!folioI.isEmpty() && folioF.isEmpty()) {
            sql = sql + " and c.Folio >=" + folioI
                    + " and c.Folio <=" + folioI;
        }
        if (area > 0) {//-------------------------------------Area
            sql = sql + " and p.Area =" + area;
        }
        if (!tipo.equals("todos")) {//------------------------------Tipo
            sql = sql + " and c.Tipo =" + "'" + tipo + "'";
        }
        if (!fechaI.isEmpty() && !fechaF.isEmpty()) {//-------FechaE
            sql = sql + " and c.FechaE >=" + "'" + fechaI + "'"
                    + " and c.FechaE <=" + "'" + fechaF + "'";
        }
        if (!fechaI.isEmpty() && fechaF.isEmpty()) {
            sql = sql + " and c.FechaE >=" + "'" + fechaI + "'"
                    + " and c.FechaE <=" + "'" + fechaI + "'";
        }
        if (!tipoP.isEmpty()) {//-----------------------------TipoP
            sql = sql + " and c.TipoP =" + "'" + tipoP + "'";
        }
        if (!claveNE.isEmpty()) {//----------------------------------ClaveNE
            sql = sql + " and c.ClaveNE =" + claveNE;
        }
        if (!claveC.isEmpty()) {//----------------------------------ClaveC
            sql = sql + " and c.ClaveC =" + claveC;
        }
        sql = sql + ";";

        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {

            Constancia c = new Constancia();
            c.setTipo(rs.getString("Tipo"));
            c.setClaveC(rs.getInt("ClaveC"));
            c.setClaveNE(rs.getInt("ClaveNE"));
            c.setFolio(rs.getInt("Folio"));
            c.setRealizada(rs.getString("Realizada"));

            try {
                c.setFechaE(rs.getDate("FechaE"));
            } catch (Exception e) {
                c.setFechaE(new Date(6666, 66, 6));
            }

            c.setTipoP(rs.getString("TipoP"));
            c.setEnlace(rs.getString("Enlace"));

            try {
                c.setEntregado(rs.getDate("Entregado"));
            } catch (Exception e) {
                c.setEntregado(new Date(6666, 66, 6));
            }

            c.setReposicion(rs.getString("Reposicion"));
            c.setEntrega(rs.getString("Entrega"));

            c.setNombreProfesor(rs.getString("Nombre"));
            c.setNombreEvento(nombreEvento(rs.getString("Tipo"), rs.getString("ClaveC")));

            map.put(contador, c);
            contador++;

        }

        //base.cerrarConexion();
        return map;
    }

    public Constancia selectConstanciaPorFolio(int folio) throws SQLException, ClassNotFoundException {
        base.conectar();

        System.out.println("BUSCANDO CONSTANCIAS");
        HashMap<Integer, Constancia> map = new HashMap();
        int contador = 0;

        String sql = "select constancias.*,concat(ApellidoP,' ',ApellidoM,' ',Nombre) as Nombre"
                + " from constancias, profesor"
                + " where profesor.ClaveNE = constancias.ClaveNE"
                + " and constancias.Folio = ?;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, folio);
        ResultSet rs = pstm.executeQuery();

        rs.next();
        Constancia c = new Constancia();
        c.setTipo(rs.getString("Tipo"));
        c.setClaveC(rs.getInt("ClaveC"));
        c.setClaveNE(rs.getInt("ClaveNE"));
        c.setFolio(rs.getInt("Folio"));
        c.setRealizada(rs.getString("Realizada"));

        try {
            c.setFechaE(rs.getDate("FechaE"));
        } catch (Exception e) {
            c.setFechaE(new Date(6666, 66, 6));
        }

        c.setTipoP(rs.getString("TipoP"));
        c.setEnlace(rs.getString("Enlace"));

        try {
            c.setEntregado(rs.getDate("Entregado"));
        } catch (Exception e) {
            c.setEntregado(new Date(6666, 66, 6));
        }

        c.setReposicion(rs.getString("Reposicion"));
        c.setEntrega(rs.getString("Entrega"));

        c.setNombreProfesor(rs.getString("Nombre"));
        c.setNombreEvento(nombreEvento(rs.getString("Tipo"), rs.getString("ClaveC")));

        return c;
        //base.cerrarConexion();

    }

    public HashMap selectAsistentesPorCurso(int ClaveC) throws SQLException, ClassNotFoundException {

        base.conectar();

        System.out.println("BUSCANDO Asistentes");
        HashMap<Integer, Asistente> map = new HashMap();
        int contador = 0;

        String sql = "SELECT constancias.Folio,"
                + "constancias.FechaE,"
                + "constancias.Entregado,"
                + "constancias.Reposicion,"
                + "constancias.Entrega,"
                + "profesor.Email,"
                + "profesor.ClaveNE,"
                + "profesor.RFC,"
                + "profesor.Nombre,"
                + "profesor.ApellidoP,"
                + "profesor.ApellidoM,"
                + "constancias.TipoP "
                + "FROM constancias "
                + "INNER JOIN profesor "
                + "on constancias.ClaveNE = profesor.ClaveNE "
                + "and constancias.Tipo = 'cursos'"
                + "where ClaveC = ?;";

        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, ClaveC);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            Asistente c = new Asistente();

            c.setFolio(rs.getInt("Folio"));

            try {
                c.setFechaE(rs.getDate("FechaE"));
            } catch (Exception e) {
                c.setFechaE(new Date(6666, 66, 6));
            }

            try {
                c.setEntregado(rs.getDate("Entregado"));
            } catch (Exception e) {
                c.setEntregado(new Date(6666, 66, 6));
            }

            c.setReposicion(rs.getString("Reposicion"));
            c.setEntrega(rs.getString("Entrega"));
            c.setEmail(rs.getString("Email"));
            c.setClaveNE(rs.getInt("ClaveNE"));
            c.setRfc(rs.getString("RFC"));
            c.setNombre(rs.getString("Nombre"));
            c.setApellidoP(rs.getString("ApellidoP"));
            c.setApellidoM(rs.getString("ApellidoM"));
            c.setTipoP(rs.getString("TipoP"));

            map.put(contador, c);
            contador++;
        }
        //  base.cerrarConexion();
        return map;
    }

    public HashMap selectAllCursos() throws SQLException, ClassNotFoundException {
        base.conectar();

        System.out.println("BUSCANDO CURSOS");
        HashMap<Integer, Curso> map = new HashMap();
        int contador = 0;

        String sql = "SELECT * FROM docencia.cursos; ";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Curso c = new Curso();
            c.setClaveC(rs.getInt("ClaveC"));
            c.setNombreCurso(rs.getString("NombreCurso"));
            c.setnArchivo(rs.getString("NArchivo"));
            c.setFechaI(rs.getDate("FechaI"));
            c.setFechaF(rs.getDate("FechaF"));
            c.setHoras(rs.getInt("Horas"));
            c.setFolioOficio(rs.getInt("FolioOficio"));
            c.setObsx(rs.getString("Obsx"));
            c.setTurno(rs.getString("Turno"));
            c.setSede(rs.getInt("Sede"));
            map.put(contador, c);
            contador++;
        }
        // base.cerrarConexion();
        return map;
    }

    public LinkedList<Profesor> selectAllProfesoresPorNombreCompleto(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        LinkedList<Profesor> list = new LinkedList<>();
        String sql = "SELECT * FROM docencia.profesor where concat(ApellidoP,' ',ApellidoM,' ',Nombre) like ? order by ApellidoP,ApellidoM,Nombre ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Profesor p = new Profesor();
            p.setClaveNE(rs.getInt("ClaveNE"));
            p.setRfc(rs.getString("RFC"));
            p.setNombre(rs.getString("Nombre"));
            p.setApellidoP(rs.getString("ApellidoP"));
            p.setApellidoM(rs.getString("ApellidoM"));
            p.setTitulo(rs.getString("Titulo"));
            p.setCategoria(rs.getInt("Categoria"));
            p.setSexo(rs.getString("Sexo"));
            p.setEmail(rs.getString("Email"));
            p.setArea(rs.getInt("Area"));
            p.setAdscr(rs.getInt("Adscr"));

            try {
                p.setIngreso(rs.getString("Ingreso")); //-- Cambiar por date
            } catch (Exception e) {
                p.setIngreso("");
            }

            p.setEstatus(rs.getString("Estatus"));
            p.setMarca(rs.getInt("Marca"));
            list.add(p);
        }
        // base.cerrarConexion();
        return list;
    }

    public LinkedList<Profesor> selectAllProfesoresPorApellidoP(String apellidoP) throws SQLException, ClassNotFoundException {
        base.conectar();
        LinkedList<Profesor> list = new LinkedList<>();
        String sql = "SELECT * FROM docencia.profesor where ApellidoP like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + apellidoP + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Profesor p = new Profesor();
            p.setClaveNE(rs.getInt("ClaveNE"));
            p.setRfc(rs.getString("RFC"));
            p.setNombre(rs.getString("Nombre"));
            p.setApellidoP(rs.getString("ApellidoP"));
            p.setApellidoM(rs.getString("ApellidoM"));
            p.setTitulo(rs.getString("Titulo"));
            p.setCategoria(rs.getInt("Categoria"));
            p.setSexo(rs.getString("Sexo"));
            p.setEmail(rs.getString("Email"));
            p.setArea(rs.getInt("Area"));
            p.setAdscr(rs.getInt("Adscr"));

            try {
                p.setIngreso(rs.getString("Ingreso")); //-- Cambiar por date
            } catch (Exception e) {
                p.setIngreso("");
            }

            p.setEstatus(rs.getString("Estatus"));
            p.setMarca(rs.getInt("Marca"));
            list.add(p);
        }
        //  base.cerrarConexion();
        return list;
    }

    public LinkedList<Profesor> selectAllProfesoresPorApellidoM(String apellidoM) throws SQLException, ClassNotFoundException {
        base.conectar();
        LinkedList<Profesor> list = new LinkedList<>();
        String sql = "SELECT * FROM docencia.profesor where ApellidoM like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + apellidoM + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Profesor p = new Profesor();
            p.setClaveNE(rs.getInt("ClaveNE"));
            p.setRfc(rs.getString("RFC"));
            p.setNombre(rs.getString("Nombre"));
            p.setApellidoP(rs.getString("ApellidoP"));
            p.setApellidoM(rs.getString("ApellidoM"));
            p.setTitulo(rs.getString("Titulo"));
            p.setCategoria(rs.getInt("Categoria"));
            p.setSexo(rs.getString("Sexo"));
            p.setEmail(rs.getString("Email"));
            p.setArea(rs.getInt("Area"));
            p.setAdscr(rs.getInt("Adscr"));
            try {
                p.setIngreso(rs.getString("Ingreso"));//-- Cambiar por date
            } catch (Exception exception) {
                p.setIngreso("");
            }
            p.setEstatus(rs.getString("Estatus"));
            p.setMarca(rs.getInt("Marca"));
            list.add(p);
        }
        // base.cerrarConexion();
        return list;
    }

    public LinkedList<Profesor> selectAllProfesoresPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        LinkedList<Profesor> list = new LinkedList<>();
        String sql = "SELECT * FROM docencia.profesor where Nombre like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Profesor p = new Profesor();
            p.setClaveNE(rs.getInt("ClaveNE"));
            p.setRfc(rs.getString("RFC"));
            p.setNombre(rs.getString("Nombre"));
            p.setApellidoP(rs.getString("ApellidoP"));
            p.setApellidoM(rs.getString("ApellidoM"));
            p.setTitulo(rs.getString("Titulo"));
            p.setCategoria(rs.getInt("Categoria"));
            p.setSexo(rs.getString("Sexo"));
            p.setEmail(rs.getString("Email"));
            p.setArea(rs.getInt("Area"));
            p.setAdscr(rs.getInt("Adscr"));
            try {
                p.setIngreso(rs.getString("Ingreso"));//-- Cambiar por date
            } catch (Exception exception) {
                p.setIngreso("");
            }
            p.setEstatus(rs.getString("Estatus"));
            p.setMarca(rs.getInt("Marca"));
            list.add(p);
        }
        //  base.cerrarConexion();
        return list;
    }

    public LinkedList<Profesor> selectAllProfesoresPorClaveNE(int claveNE) throws SQLException, ClassNotFoundException {
        base.conectar();
        LinkedList<Profesor> list = new LinkedList<>();
        String sql = "SELECT * FROM docencia.profesor where ClaveNE like ?;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + claveNE + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Profesor p = new Profesor();
            p.setClaveNE(rs.getInt("ClaveNE"));
            p.setRfc(rs.getString("RFC"));
            p.setNombre(rs.getString("Nombre"));
            p.setApellidoP(rs.getString("ApellidoP"));
            p.setApellidoM(rs.getString("ApellidoM"));
            p.setTitulo(rs.getString("Titulo"));
            p.setCategoria(rs.getInt("Categoria"));
            p.setSexo(rs.getString("Sexo"));
            p.setEmail(rs.getString("Email"));
            p.setArea(rs.getInt("Area"));
            p.setAdscr(rs.getInt("Adscr"));
            p.setIngreso(rs.getString("Ingreso"));
            p.setEstatus(rs.getString("Estatus"));
            p.setMarca(rs.getInt("Marca"));
            list.add(p);
        }
        // base.cerrarConexion();
        return list;
    }

    public ArrayList selectAllCursosPorClaveC(int ClaveC) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Curso> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.cursos where ClaveC like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + ClaveC + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Curso c = new Curso();
            c.setClaveC(rs.getInt("ClaveC"));
            c.setNombreCurso(rs.getString("NombreCurso"));
            c.setnArchivo(rs.getString("NArchivo"));
            c.setFechaI(rs.getDate("FechaI"));
            c.setFechaF(rs.getDate("FechaF"));
            c.setHoras(rs.getInt("Horas"));
            c.setFolioOficio(rs.getInt("FolioOficio"));
            c.setObsx(rs.getString("Obsx"));
            c.setTurno(rs.getString("Turno"));
            c.setSede(rs.getInt("Sede"));
            list.add(c);
        }
        // base.cerrarConexion();
        return list;
    }

    public HashMap selectAllCursosPorNombreMAP(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();

        System.out.println("BUSCANDO CURSOS");
        HashMap<Integer, Curso> map = new HashMap();
        int contador = 0;

        String sql = "SELECT * FROM docencia.cursos where NombreCurso like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Curso c = new Curso();
            c.setClaveC(rs.getInt("ClaveC"));
            c.setNombreCurso(rs.getString("NombreCurso"));
            c.setnArchivo(rs.getString("NArchivo"));
            c.setFechaI(rs.getDate("FechaI"));
            c.setFechaF(rs.getDate("FechaF"));
            c.setHoras(rs.getInt("Horas"));
            c.setFolioOficio(rs.getInt("FolioOficio"));
            c.setObsx(rs.getString("Obsx"));
            c.setTurno(rs.getString("Turno"));
            c.setSede(rs.getInt("Sede"));
            map.put(contador, c);
            contador++;
        }
        //base.cerrarConexion();
        return map;
    }

    public HashMap selectAllCursosPorFechaMAP(String fecha) throws SQLException, ClassNotFoundException {
        base.conectar();

        System.out.println("BUSCANDO CURSOS");
        HashMap<Integer, Curso> map = new HashMap();
        int contador = 0;

        String sql = "SELECT * FROM docencia.cursos where FechaI like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + fecha + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Curso c = new Curso();
            c.setClaveC(rs.getInt("ClaveC"));
            c.setNombreCurso(rs.getString("NombreCurso"));
            c.setnArchivo(rs.getString("NArchivo"));
            c.setFechaI(rs.getDate("FechaI"));
            c.setFechaF(rs.getDate("FechaF"));
            c.setHoras(rs.getInt("Horas"));
            c.setFolioOficio(rs.getInt("FolioOficio"));
            c.setObsx(rs.getString("Obsx"));
            c.setTurno(rs.getString("Turno"));
            c.setSede(rs.getInt("Sede"));
            map.put(contador, c);
            contador++;
        }
        //base.cerrarConexion();
        return map;
    }

    public ArrayList selectAllCursosPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Curso> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.cursos where NombreCurso like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Curso c = new Curso();
            c.setClaveC(rs.getInt("ClaveC"));
            c.setNombreCurso(rs.getString("NombreCurso"));
            c.setnArchivo(rs.getString("NArchivo"));
            c.setFechaI(rs.getDate("FechaI"));
            c.setFechaF(rs.getDate("FechaF"));
            c.setHoras(rs.getInt("Horas"));
            c.setFolioOficio(rs.getInt("FolioOficio"));
            c.setObsx(rs.getString("Obsx"));
            c.setTurno(rs.getString("Turno"));
            c.setSede(rs.getInt("Sede"));
            list.add(c);
        }
        // base.cerrarConexion();
        return list;
    }

    public ArrayList selectAllAsesoriasPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Asesoria> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.asesorias where NombreAsesoria like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Asesoria a = new Asesoria();
            a.setClaveAs(rs.getInt("ClaveAs"));
            a.setNombreAsesoria(rs.getString("NombreAsesoria"));
            a.setConj1(rs.getString("Conj1"));
            a.setMarco(rs.getString("Marco"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setHoras(rs.getInt("Horas"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setObsx(rs.getString("Obsx"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;
    }

    public ArrayList selectAllAsesoriasPorClaveC(int ClaveAs) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Asesoria> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.asesorias where ClaveAs like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + ClaveAs + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Asesoria a = new Asesoria();
            a.setClaveAs(rs.getInt("ClaveAs"));
            a.setNombreAsesoria(rs.getString("NombreAsesoria"));
            a.setConj1(rs.getString("Conj1"));
            a.setMarco(rs.getString("Marco"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setHoras(rs.getInt("Horas"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setObsx(rs.getString("Obsx"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;

    }

    public ArrayList selectAllConcursosPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Concurso> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.concursos where NombreConcurso like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Concurso a = new Concurso();
            a.setClaveCo(rs.getInt("ClaveCO"));
            a.setNombreConcurso(rs.getString("NombreConcurso"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setObsx(rs.getString("Obsx"));
            a.setConj1(rs.getString("Conj1"));
            a.setMarco(rs.getString("Marco"));
            a.setSede(rs.getInt("Sede"));
            a.setQuees(rs.getString("Quees"));
            list.add(a);
        }
        System.out.println("Con N");
        // base.cerrarConexion();
        return list;
    }

    public ArrayList selectAllConcursosPorClaveC(int ClaveCO) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Concurso> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.concursos where ClaveCO like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + ClaveCO + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Concurso a = new Concurso();
            a.setClaveCo(rs.getInt("ClaveCO"));
            a.setNombreConcurso(rs.getString("NombreConcurso"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setObsx(rs.getString("Obsx"));
            a.setConj1(rs.getString("Conj1"));
            a.setMarco(rs.getString("Marco"));
            a.setSede(rs.getInt("Sede"));
            a.setQuees(rs.getString("Quees"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;

    }

    public ArrayList selectAllConferenciasPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Conferencia> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.conferencias where NombreConf like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Conferencia a = new Conferencia();
            a.setClaveCo(rs.getInt("ClaveCo"));
            a.setNombreConf(rs.getString("NombreConf"));
            a.setMarcoConf(rs.getString("MarcoConf"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setQuees(rs.getString("Quees"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setConj1(rs.getString("Conj1"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        //  base.cerrarConexion();
        return list;
    }

    public ArrayList selectAllConferenciasPorClaveC(int ClaveCo) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Conferencia> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.conferencias where ClaveCo like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + ClaveCo + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Conferencia a = new Conferencia();
            a.setClaveCo(rs.getInt("ClaveCo"));
            a.setNombreConf(rs.getString("NombreConf"));
            a.setMarcoConf(rs.getString("MarcoConf"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setQuees(rs.getString("Quees"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setConj1(rs.getString("Conj1"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        //base.cerrarConexion();
        return list;

    }

    public ArrayList selectAllEventosPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Evento> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.eventos where NombreEv like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Evento a = new Evento();
            a.setClaveEv(rs.getInt("ClaveEv"));
            a.setNombreEv(rs.getString("NombreEv"));
            a.setConj1(rs.getString("Conj1"));
            a.setMarco(rs.getString("Marco"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setHoras(rs.getInt("Horas"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setQuees(rs.getString("Quees"));
            a.setLlevado(rs.getString("Llevado"));
            a.setSede(rs.getInt("Sede"));
            a.setObsx(rs.getString("Obsx"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;
    }

    public ArrayList selectAllEventosPorClaveC(int ClaveEv) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Evento> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.eventos where ClaveEv like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + ClaveEv + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Evento a = new Evento();
            a.setClaveEv(rs.getInt("ClaveEv"));
            a.setNombreEv(rs.getString("NombreEv"));
            a.setConj1(rs.getString("Conj1"));
            a.setMarco(rs.getString("Marco"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setHoras(rs.getInt("Horas"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setQuees(rs.getString("Quees"));
            a.setLlevado(rs.getString("Llevado"));
            a.setSede(rs.getInt("Sede"));
            a.setObsx(rs.getString("Obsx"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;

    }

    public ArrayList selectAllMaterialesPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Material> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.materiales where NombreMaterial like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Material a = new Material();
            a.setClaveM(rs.getInt("ClaveM"));
            a.setNombreMaterial(rs.getString("NombreMaterial"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setObsx(rs.getString("Obsx"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;
    }

    public ArrayList selectAllMaterialesPorClaveC(int ClaveM) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Material> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.materiales where ClaveM like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + ClaveM + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Material a = new Material();
            a.setClaveM(rs.getInt("ClaveM"));
            a.setNombreMaterial(rs.getString("NombreMaterial"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setObsx(rs.getString("Obsx"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;

    }

    public ArrayList selectAllSeminariosPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Seminario> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.seminarios where NombreSeminario like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Seminario a = new Seminario();
            a.setClaveS(rs.getInt("ClaveS"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setHoras(rs.getInt("Horas"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setNombreSeminario(rs.getString("NombreSeminario"));
            a.setObsx(rs.getString("Obsx"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;
    }

    public ArrayList selectAllSeminariosPorClaveC(int ClaveS) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Seminario> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.seminarios where ClaveS like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + ClaveS + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Seminario a = new Seminario();
            a.setClaveS(rs.getInt("ClaveS"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setHoras(rs.getInt("Horas"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setNombreSeminario(rs.getString("NombreSeminario"));
            a.setObsx(rs.getString("Obsx"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;

    }

    public ArrayList selectAllTalleresPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Taller> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.talleres where NombreTaller like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Taller a = new Taller();
            a.setClaveTa(rs.getInt("ClaveTa"));
            a.setNombreTaller(rs.getString("NombreTaller"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setQuees(rs.getString("Quees"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setHoras(rs.getInt("Horas"));
            a.setSede(rs.getInt("Sede"));
            a.setObsx(rs.getString("Obsx"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;
    }

    public ArrayList selectAllTalleresPorClaveC(int ClaveTa) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Taller> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.talleres where ClaveTa like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + ClaveTa + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Taller a = new Taller();
            a.setClaveTa(rs.getInt("ClaveTa"));
            a.setNombreTaller(rs.getString("NombreTaller"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setQuees(rs.getString("Quees"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setHoras(rs.getInt("Horas"));
            a.setSede(rs.getInt("Sede"));
            a.setObsx(rs.getString("Obsx"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;

    }

    public ArrayList selectAllVisitasPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Visita> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.visitas where NombreVisita like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Visita a = new Visita();
            a.setClaveV(rs.getInt("ClaveV"));
            a.setNombreVisita(rs.getString("NombreVisita"));
            a.setComplemento(rs.getString("Complemento"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setQuees(rs.getString("Quees"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;
    }

    public ArrayList selectAllVisitasPorClaveC(int ClaveV) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Visita> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.visitas where ClaveV like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + ClaveV + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Visita a = new Visita();
            a.setClaveV(rs.getInt("ClaveV"));
            a.setNombreVisita(rs.getString("NombreVisita"));
            a.setComplemento(rs.getString("Complemento"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setQuees(rs.getString("Quees"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;

    }

    public ArrayList selectAllInfocabPorNombre(String nombre) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Infocab> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.infocab where NombreProyecto like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + nombre + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Infocab a = new Infocab();
            a.setClaveI(rs.getInt("ClaveI"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setHoras(rs.getInt("Horas"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setNombreProyecto(rs.getString("NombreProyecto"));
            a.setObsx(rs.getString("Obsx"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;
    }

    public ArrayList selectAllInfocabPorClaveC(int ClaveI) throws SQLException, ClassNotFoundException {
        base.conectar();
        ArrayList<Infocab> list = new ArrayList<>();
        String sql = "SELECT * FROM docencia.infocab where ClaveI like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + ClaveI + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Infocab a = new Infocab();
            a.setClaveI(rs.getInt("ClaveI"));
            a.setnArchivo(rs.getString("NArchivo"));
            a.setFechaI(rs.getDate("FechaI"));
            a.setFechaF(rs.getDate("FechaF"));
            a.setHoras(rs.getInt("Horas"));
            a.setFolioOficio(rs.getInt("FolioOficio"));
            a.setNombreProyecto(rs.getString("NombreProyecto"));
            a.setObsx(rs.getString("Obsx"));
            a.setSede(rs.getInt("Sede"));
            list.add(a);
        }
        // base.cerrarConexion();
        return list;

    }

    public LinkedList<Listado> selectAllListados() throws SQLException, ClassNotFoundException {
        base.conectar();
        LinkedList<Listado> list = new LinkedList<>();
        String sql = "SELECT * FROM docencia.listados"
                + " order by numero desc;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Listado l = new Listado();
            l.setNumero(rs.getInt("numero"));
            l.setFecha(rs.getDate("fecha"));
            l.setDesc(rs.getString("desc"));

            list.add(l);
        }
        // base.cerrarConexion();
        return list;
    }

    public LinkedList<Listado> selectAllListadosPorDesc(String desc) throws SQLException, ClassNotFoundException {
        base.conectar();
        LinkedList<Listado> list = new LinkedList<>();
        String sql = "SELECT * FROM docencia.listados where listados.desc like ? ;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setString(1, "%" + desc + "%");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Listado l = new Listado();
            l.setNumero(rs.getInt("numero"));
            l.setFecha(rs.getDate("fecha"));
            l.setDesc(rs.getString("desc"));

            list.add(l);
        }
        // base.cerrarConexion();
        return list;
    }

    public LinkedList<Constancia> selectListadoConstancias(int numeroListado) throws SQLException {

        base.conectar();
        LinkedList<Constancia> list = new LinkedList<>();
        String sql = "select  c.*,concat(ApellidoP,' ',ApellidoM,' ',Nombre) as Nombre"
                + " from constancias c, listadoConstancia lc, listados l, profesor p"
                + " where	lc.folio = c.Folio"
                + " and		lc.listado = l.numero"
                + " and		c.ClaveNE = p.ClaveNE"
                + " and 	l.numero=?;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, numeroListado);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {

            Constancia c = new Constancia();
            c.setTipo(rs.getString("Tipo"));
            c.setClaveC(rs.getInt("ClaveC"));
            c.setClaveNE(rs.getInt("ClaveNE"));
            c.setFolio(rs.getInt("Folio"));
            c.setRealizada(rs.getString("Realizada"));

            try {
                c.setFechaE(rs.getDate("FechaE"));
            } catch (Exception e) {
                c.setFechaE(new Date(6666, 66, 6));
            }

            c.setTipoP(rs.getString("TipoP"));
            c.setEnlace(rs.getString("Enlace"));

            try {
                c.setEntregado(rs.getDate("Entregado"));
            } catch (Exception e) {
                c.setEntregado(new Date(6666, 66, 6));
            }

            c.setReposicion(rs.getString("Reposicion"));
            c.setEntrega(rs.getString("Entrega"));

            c.setNombreProfesor(rs.getString("Nombre"));
            c.setNombreEvento(nombreEvento(rs.getString("Tipo"), rs.getString("ClaveC")));

            list.add(c);
        }

        //base.cerrarConexion();
        return list;

    }

    //------------------------------------------------------------------- Jasper
    public LinkedList<ResultSetContanciaCursos> constanciasCursos(int ClaveC) throws SQLException, ClassNotFoundException {

        base.conectar();
        LinkedList<ResultSetContanciaCursos> list = new LinkedList<>();
        String sql = "Select NombreCurso, FechaI, FechaF, Horas, Folio, Obsx"
                + " ,Turno, Realizada, FechaE,TipoP, Nombre, ApellidoP, ApellidoM"
                + " ,Titulo, Sexo, M3.Mes MesI,M1.Mes MesF, M2.Mes MesE,Enlace"
                + " ,profesor.Area,profesor.Adscr"
                + " From   cursos, constancias, profesor, mes M1, mes M2, mes M3"
                + " Where  profesor.ClaveNE = constancias.ClaveNE"
                + " AND    cursos.ClaveC    = constancias.ClaveC"
                + " AND    Month(FechaF)    = M1.NMes"
                + " AND    Month(FechaE)    = M2.NMes"
                + " AND    Month(FechaI)    = M3.NMes"
                + " AND    constancias.Tipo = 'cursos'"
                + " AND    cursos.ClaveC  Between ? and ?"
                + " order by apellidop,apellidom";

        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, ClaveC);
        pstm.setInt(2, ClaveC);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            ResultSetContanciaCursos r = new ResultSetContanciaCursos();
            r.setNombreCurso(rs.getString("NombreCurso"));
            r.setFechaI(rs.getDate("FechaI"));
            r.setFechaF(rs.getDate("FechaF"));
            r.setHoras(rs.getInt("Horas"));
            r.setFolio(rs.getInt("Folio"));
            r.setObsx(rs.getString("Obsx"));
            r.setTurno(rs.getString("Turno"));
            r.setRealizada(rs.getString("Realizada"));
            r.setFechaE(rs.getDate("FechaE"));
            r.setTipoP(rs.getString("TipoP"));
            r.setNombre(rs.getString("Nombre"));
            r.setApellidoP(rs.getString("ApellidoP"));
            r.setApellidoM(rs.getString("ApellidoM"));
            r.setTitulo(rs.getString("Titulo"));
            r.setSexo(rs.getString("Sexo"));
            r.setMesI(rs.getString("MesI"));
            r.setMesF(rs.getString("MesF"));
            r.setMesE(rs.getString("MesE"));
            r.setEnlace(rs.getString("Enlace"));
            r.setArea(rs.getInt("Area"));
            r.setAds(rs.getInt("Adscr"));
            list.add(r);
        }
        //  base.cerrarConexion();
        return list;
    }

    public LinkedList<ResultSetContanciaCursos> constanciasCursosPorListado(int NumeroDeListado) throws SQLException, ClassNotFoundException {

        base.conectar();
        LinkedList<ResultSetContanciaCursos> list = new LinkedList<>();
        String sql = "Select NombreCurso, FechaI, FechaF, Horas, constancias.Folio"
                + " ,Obsx, Turno, Realizada, FechaE,TipoP, Nombre, ApellidoP, ApellidoM"
                + " ,Titulo, Sexo, M3.Mes MesI,M1.Mes MesF, M2.Mes MesE,Enlace"
                + " ,profesor.Area,profesor.Adscr"
                + " From   cursos, constancias, profesor, mes M1, mes M2, mes M3,listadoConstancia"
                + " Where  profesor.ClaveNE = constancias.ClaveNE"
                + " AND    cursos.ClaveC    = constancias.ClaveC"
                + " AND    Month(FechaF)    = M1.NMes"
                + " AND    Month(FechaE)    = M2.NMes"
                + " AND    Month(FechaI)    = M3.NMes"
                + " AND    constancias.Tipo = 'cursos'"
                + " and    constancias.Folio = listadoConstancia.folio"
                + " and   listadoConstancia.listado = ?"
                + " order by apellidop,apellidom,Nombre,Folio;";

        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, NumeroDeListado);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            ResultSetContanciaCursos r = new ResultSetContanciaCursos();
            r.setNombreCurso(rs.getString("NombreCurso"));
            r.setFechaI(rs.getDate("FechaI"));
            r.setFechaF(rs.getDate("FechaF"));
            r.setHoras(rs.getInt("Horas"));
            r.setFolio(rs.getInt("Folio"));
            r.setObsx(rs.getString("Obsx"));
            r.setTurno(rs.getString("Turno"));
            r.setRealizada(rs.getString("Realizada"));
            r.setFechaE(rs.getDate("FechaE"));
            r.setTipoP(rs.getString("TipoP"));
            r.setNombre(rs.getString("Nombre"));
            r.setApellidoP(rs.getString("ApellidoP"));
            r.setApellidoM(rs.getString("ApellidoM"));
            r.setTitulo(rs.getString("Titulo"));
            r.setSexo(rs.getString("Sexo"));
            r.setMesI(rs.getString("MesI"));
            r.setMesF(rs.getString("MesF"));
            r.setMesE(rs.getString("MesE"));
            r.setEnlace(rs.getString("Enlace"));
            r.setArea(rs.getInt("Area"));
            r.setAds(rs.getInt("Adscr"));
            list.add(r);
        }
        //  base.cerrarConexion();
        return list;
    }

    public LinkedList<ResultsetListado> selectListado(int NumeroDeListado) throws SQLException, ClassNotFoundException {

        base.conectar();
        LinkedList<ResultsetListado> list = new LinkedList<>();
        String sql = "select"
                + " concat(p.ApellidoP,' ',p.ApellidoM,' ',p.Nombre) as nombreProfesor"
                + " ,c.TipoP as motivoConstancia"
                + " ,c.Folio as folioConstancia"
                + " ,c.Tipo as tipoConstancia"
                + " ,a.AreaDescr as areaProfesor"
                + " ,ad.AdscrDescr as adscrProfesor"
                + " ,p.Email as emailProfesor"
                + " ,c.ClaveC as claveEvento"
                + " ,c.ClaveNE as claveProfesor"
                + " ,c.FechaE as fechaE"
                + " from constancias c, profesor p, listadoConstancia l, area a, adscripcion ad"
                + " where c.ClaveNE = p.ClaveNE"
                + " and c.Folio = l.folio"
                + " and p.Area=a.Area"
                + " and p.Adscr = ad.Adscr"
                + " and l.listado = ?"
                + " order by ApellidoP,ApellidoM;";

        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, NumeroDeListado);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            ResultsetListado r = new ResultsetListado();
            r.setNombreProfesor(rs.getString("nombreProfesor"));
            r.setMotivoConstancia(rs.getString("motivoConstancia"));
            r.setFolioConstancia(rs.getInt("folioConstancia"));
            r.setTipoConstancia(rs.getString("tipoConstancia"));
            r.setAreaProfesor(rs.getString("areaProfesor"));
            r.setAdscrProfesor(rs.getString("adscrProfesor"));
            r.setEmailProfesor(rs.getString("emailProfesor"));
            r.setClaveEvento(rs.getInt("claveEvento"));
            r.setClaveProfesor(rs.getInt("claveProfesor"));
            r.setNombreEvento(nombreEvento(rs.getString("tipoConstancia"), rs.getString("claveEvento")));
            r.setInstanciaEvento(adsEvento(rs.getString("tipoConstancia"), rs.getString("claveEvento")));
            r.setFechaE(rs.getDate("fechaE"));
            list.add(r);
        }
        //  base.cerrarConexion();
        return list;
    }

    public LinkedList<ResultSetConstanciaGeneral> constanciasGenerales(int folioInicio, int folioFin) throws SQLException, ClassNotFoundException, UnsupportedOperationException {

        base.conectar();
        LinkedList<ResultSetConstanciaGeneral> list = new LinkedList<>();
        String sql = "SELECT Sexo,Titulo,Nombre,ApellidoP,ApellidoM,TipoP"
                + " ,Tipo,ClaveC,Enlace,Realizada,Folio,Reposicion"
                + " ,profesor.Area,profesor.Adscr"
                + " FROM docencia.constancias inner JOIN docencia.profesor"
                + " ON docencia.constancias.ClaveNE = docencia.profesor.ClaveNE"
                + " where docencia.constancias.Folio between ? and ? ;";

        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, folioInicio);
        pstm.setInt(2, folioFin);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            ResultSetConstanciaGeneral r = new ResultSetConstanciaGeneral();

            if (rs.getString("Sexo").equals("M")) {
                r.setSexo("a la");
            } else {
                r.setSexo("al");
            }

            r.setTitulo(rs.getString("Titulo"));

            if (r.getTitulo().isEmpty()) {
                r.setSexo("a");
            }

            r.setNombre(rs.getString("Nombre"));
            r.setApellidoP(rs.getString("ApellidoP"));
            r.setApellidoM(rs.getString("ApellidoM"));
            r.setTipoP(rs.getString("TipoP"));

            r.setNombreCurso(nombreEvento(rs.getString("Tipo"), rs.getString("ClaveC")));

            r.setEnlace(rs.getString("Enlace"));
            r.setRealizada(rs.getString("Realizada"));
            r.setFolio(rs.getInt("Folio"));

            if (rs.getString("Reposicion").equals("1")) {
                r.setReposicion("Reposición");
            } else {
                r.setReposicion("");
            }

            r.setArea(rs.getInt("Area"));
            r.setAds(rs.getInt("Adscr"));
            list.add(r);
        }

        // base.cerrarConexion();
        return list;
    }

    public LinkedList<ResultSetConstanciaGeneral> constanciasGeneralesPorListado(int NumeroDeListado) throws SQLException, ClassNotFoundException, UnsupportedOperationException {

        base.conectar();
        LinkedList<ResultSetConstanciaGeneral> list = new LinkedList<>();
        String sql = "SELECT Sexo,Titulo,Nombre,ApellidoP,ApellidoM,TipoP"
                + " ,Tipo,ClaveC,Enlace,Realizada,c.Folio,Reposicion"
                + " ,profesor.Area,profesor.Adscr"
                + " FROM constancias c, profesor p, listadoConstancia l"
                + " where c.ClaveNE = p.ClaveNE"
                + " and c.Folio = l.folio"
                + " and l.listado = ?;";

        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, NumeroDeListado);
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            if (!rs.getString("Tipo").equals("cursos")) {
                ResultSetConstanciaGeneral r = new ResultSetConstanciaGeneral();

                if (rs.getString("Sexo").equals("M")) {
                    r.setSexo("A la");
                } else {
                    r.setSexo("Al");
                }

                r.setTitulo(rs.getString("Titulo"));

                if (r.getTitulo().isEmpty()) {
                    r.setSexo("a");
                }

                r.setNombre(rs.getString("Nombre"));
                r.setApellidoP(rs.getString("ApellidoP"));
                r.setApellidoM(rs.getString("ApellidoM"));
                r.setTipoP(rs.getString("TipoP"));

                r.setNombreCurso(nombreEvento(rs.getString("Tipo"), rs.getString("ClaveC")));

                r.setEnlace(rs.getString("Enlace"));
                r.setRealizada(rs.getString("Realizada"));
                r.setFolio(rs.getInt("Folio"));

                if (rs.getString("Reposicion").equals("1")) {
                    r.setReposicion("Reposición");
                } else {
                    r.setReposicion("");
                }

                r.setArea(rs.getInt("Area"));
                r.setAds(rs.getInt("Adscr"));
                list.add(r);
            }

        }
        // base.cerrarConexion();
        return list;
    }

    public String nombreEvento(String tipo, String clave) throws SQLException, UnsupportedOperationException {

        String tabla;
        String columnaClave;
        String columnaNombre;

        switch (tipo) {
            case "asesorias":
                tabla = "asesorias";
                columnaClave = "ClaveAS";
                columnaNombre = "NombreAsesoria";
                break;
            case "concursos":
                tabla = "concursos";
                columnaClave = "ClaveCO";
                columnaNombre = "NombreConcurso";
                break;
            case "conferencias":
                tabla = "conferencias";
                columnaClave = "ClaveCo";
                columnaNombre = "NombreConf";
                break;
            case "cursos":
                tabla = "cursos";
                columnaClave = "ClaveC";
                columnaNombre = "NombreCurso";
                break;
            case "eventos":
                tabla = "eventos";
                columnaClave = "ClaveEv";
                columnaNombre = "NombreEv";
                break;
            case "materiales":
                tabla = "materiales";
                columnaClave = "ClaveM";
                columnaNombre = "NombreMaterial";
                break;
            case "seminarios":
                tabla = "seminarios";
                columnaClave = "ClaveS";
                columnaNombre = "NombreSeminario";
                break;
            case "talleres":
                tabla = "talleres";
                columnaClave = "ClaveTa";
                columnaNombre = "NombreTaller";
                break;
            case "visitas":
                tabla = "visitas";
                columnaClave = "ClaveV";
                columnaNombre = "NombreVisita";
                break;
            case "infocab":
                tabla = "infocab";
                columnaClave = "ClaveI";
                columnaNombre = "NombreProyecto";
                break;
            case "diplomados":
                tabla = "diplomados";
                columnaClave = "ClaveD";
                columnaNombre = "NombreDiploCurso";
                break;
            case "pride":
                tabla = "pride";
                columnaClave = "ClaveP";
                columnaNombre = "Nombrepride";
                break;
            default:

                System.out.println("Tipo de constancia inexistente " + tipo + clave);
                return "error";

        }

        try {
            String sql = "SELECT " + columnaNombre + " FROM " + tabla + " where " + columnaClave + " = " + clave + ";";
            Statement stm = base.getConexion().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            return rs.getString(columnaNombre);
        } catch (Exception e) {
        }
        return "error";
    }

    public String adsEvento(String tipo, String clave) throws SQLException, UnsupportedOperationException {

        String tabla;
        String columnaClave;
        String columnaNombre;

        switch (tipo) {
            case "asesorias":
                tabla = "asesorias";
                columnaClave = "ClaveAS";
                columnaNombre = "NombreAsesoria";
                break;
            case "concursos":
                tabla = "concursos";
                columnaClave = "ClaveCO";
                columnaNombre = "NombreConcurso";
                break;
            case "conferencias":
                tabla = "conferencias";
                columnaClave = "ClaveCo";
                columnaNombre = "NombreConf";
                break;
            case "cursos":
                tabla = "cursos";
                columnaClave = "ClaveC";
                columnaNombre = "NombreCurso";
                break;
            case "eventos":
                tabla = "eventos";
                columnaClave = "ClaveEv";
                columnaNombre = "NombreEv";
                break;
            case "materiales":
                tabla = "materiales";
                columnaClave = "ClaveM";
                columnaNombre = "NombreMaterial";
                break;
            case "seminarios":
                tabla = "seminarios";
                columnaClave = "ClaveS";
                columnaNombre = "NombreSeminario";
                break;
            case "talleres":
                tabla = "talleres";
                columnaClave = "ClaveTa";
                columnaNombre = "NombreTaller";
                break;
            case "visitas":
                tabla = "visitas";
                columnaClave = "ClaveV";
                columnaNombre = "NombreVisita";
                break;
            case "infocab":
                tabla = "infocab";
                columnaClave = "ClaveI";
                columnaNombre = "NombreProyecto";
                break;
            case "diplomados":
                tabla = "diplomados";
                columnaClave = "ClaveD";
                columnaNombre = "NombreDiploCurso";
                break;
            case "pride":
                tabla = "pride";
                columnaClave = "ClaveP";
                columnaNombre = "Nombrepride";
                break;
            default:

                System.out.println("Tipo de constancia inexistente " + tipo + clave);
                return "error";

        }

        try {
            String sql = "SELECT " + columnaNombre + "  ,adscripcion.AdscrDescr"
                    + " FROM " + tabla + ", adscripcion"
                    + " where " + tabla + ".sede = adscripcion.Adscr"
                    + " and " + columnaClave + " = " + clave + ";";

            Statement stm = base.getConexion().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            rs.next();
            return rs.getString("AdscrDescr");
        } catch (Exception e) {
            System.out.println("en la base:" + e.toString());

        }
        return "error";
    }
    //----------------------------------------------------------------  Reportes

    //--------------------------------------------------------------- Utilidades
    public void llenarListaAdscripciones(JComboBox<Adscripcion> comboBox) throws ClassNotFoundException, SQLException {
        base.conectar();
        String sql = "SELECT * FROM adscripcion";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Adscripcion a = new Adscripcion();
            a.setAdscr(rs.getInt("Adscr"));
            a.setAdscrDescr(rs.getString("AdscrDescr"));
            comboBox.addItem(a);
        }
        //  base.cerrarConexion();
    }

    public void llenarAreas(JComboBox<Area> comboBox) throws ClassNotFoundException, SQLException {
        base.conectar();
        String sql = "SELECT AREA ,AREADESCR  FROM AREA";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Area a = new Area();
            a.setArea(rs.getInt("Area"));
            a.setAreaDescr(rs.getString("AreaDescr"));
            comboBox.addItem(a);
        }
        //  base.cerrarConexion();
    }

    public void setMarca(int claveNE, int marca) throws SQLException, ClassNotFoundException {
        base.conectar();
        String sql = "UPDATE `docencia`.`profesor` SET `Marca`=? WHERE `ClaveNE`=?;";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, marca);
        pstm.setInt(2, claveNE);
        pstm.execute();
        //   base.cerrarConexion();
    }

    public int addMarca(int claveNE, int marca) throws SQLException, ClassNotFoundException {
        try {
            base.conectar();
            String sql = "UPDATE `docencia`.`profesor` SET `Marca`=? WHERE `ClaveNE`=?;";
            PreparedStatement pstm = base.getConexion().prepareStatement(sql);

            int marcaAnterior = getMarca(claveNE);
            String marcaConcat = "" + marcaAnterior + marca;
            int marcaNueva = Integer.parseInt(marcaConcat);

            pstm.setInt(1, marcaNueva);
            pstm.setInt(2, claveNE);
            return pstm.executeUpdate();

        } catch (Exception e) {
            return 0;
        }
    }

    public int getMarca(int claveNE) throws SQLException, ClassNotFoundException {
        base.conectar();
        String sql = "select Marca from docencia.profesor where ClaveNE = ? ";
        PreparedStatement pstm = base.getConexion().prepareStatement(sql);
        pstm.setInt(1, claveNE);
        ResultSet r = pstm.executeQuery();
        r.next();
        return r.getInt("Marca");
    }

    //Getters & Setters:
    public DataBase getBase() {
        return base;
    }

}
