package control;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapeo.*;
import modelo.QueryCollection;
import vista.VistaPrincipal;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class VistaPrincipalHandler extends VistaPrincipal {

    //Atributos:
    QueryCollection qc;
    TablasManager tm;
    ListasManager lm;
    ReportesManager rm;
    LocalDate fecha = LocalDate.now();

    //Constructores:
    public VistaPrincipalHandler() {
        super();
        try {
            qc = new QueryCollection();
            tm = new TablasManager(qc, this);
            lm = new ListasManager(this, qc);
            rm = new ReportesManager(qc);
            System.out.println("llenando fechas");
            llenarFechas();
            System.out.println("fechas llenas");
            if (qc.getBase().isConectada()) {
                System.out.println("llenando combos");
                llenarCombos();
                System.out.println("combos llenos");
                textAreaGenerarCurso.append("Base Conectada" + "\n");
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            textAreaGenerarCurso.append(ex.toString() + "\n");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("VP creada");
    }

    //Métodos:
    public void llenarCombos() throws ClassNotFoundException, SQLException {
        comboBoxGenConsPorCursoPlantilla.removeAllItems();
        comboBoxGenConsPorCursoPlantilla.addItem("cursos.jasper");
        comboBoxGenConsPorCursoPlantilla.addItem("CursosWeb.jasper");
        comboBoxGenConsPorCursoPlantilla.addItem("cursos_SG_SD.jasper");
        comboBoxGenConsPorCursoPlantilla.addItem("CursosWeb2020.jasper");
        comboBoxGenConsPorCursoPlantilla.addItem("CursosWeb2020pasado.jasper");
        comboBoxGenConsPorCursoPlantilla.addItem("CursosINFOCAB.jasper");
        comboBoxGenConsPorCursoPlantilla.addItem("CursosEspecial.jasper");

        comboBoxGenConsPorFolioPlantilla.removeAllItems();
        comboBoxGenConsPorFolioPlantilla.addItem("General.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("GeneralAmpliada.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("General_D.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("General_D_SG.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("General_SG_SD.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("General_SD.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("General_D_direccion.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("General_D_apoyoA.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("General_SG_apoyoA.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("General_D_apoyoAFondo.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("General_SG_apoyoAFondo.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("General_D_SILADIN.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("GeneralFondo.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("General_SG_SecGeneral.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("ReconocimientoGeneral.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("ReconocimientoGeneral_SG_SD.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("ReconocimientoGeneral_D.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("ReconocimientoGeneral_D_SG.jasper");
        comboBoxGenConsPorFolioPlantilla.addItem("Reconocimiento_SG_SecGeneral.jasper");

        comboBoxTipoPFcur2.removeAllItems();
        comboBoxTipoPFcur2.addItem("ACREDITADO");
        comboBoxTipoPFcur2.addItem("IMPARTIDO");
        comboBoxTipoPFcur2.addItem("DISEÑADO");
        comboBoxTipoPFcur2.addItem("IMPARTIDO Y DISEÑADO");
        comboBoxTipoPFcur2.addItem("NO ACREDITADO");
        comboBoxTipoPFcur2.addItem("NO PRESENTADO");
        comboBoxTipoPFcur2.addItem("INSCRITO");

        comboBoxBusquedaConstanciasTipo.removeAllItems();
        comboBoxBusquedaConstanciasTipo.addItem("todos");
        comboBoxBusquedaConstanciasTipo.addItem("asesorias");
        comboBoxBusquedaConstanciasTipo.addItem("concurso");
        comboBoxBusquedaConstanciasTipo.addItem("conferencias");
        comboBoxBusquedaConstanciasTipo.addItem("cursos");
        comboBoxBusquedaConstanciasTipo.addItem("diplomados");
        comboBoxBusquedaConstanciasTipo.addItem("eventos");
        comboBoxBusquedaConstanciasTipo.addItem("materiales");
        comboBoxBusquedaConstanciasTipo.addItem("seminarios");
        comboBoxBusquedaConstanciasTipo.addItem("talleres");
        comboBoxBusquedaConstanciasTipo.addItem("visitas");
        comboBoxBusquedaConstanciasTipo.addItem("pride");
        comboBoxBusquedaConstanciasTipo.addItem("infocab");

        comboBoxBusquedaConstanciasArea.removeAllItems();
        comboBoxBusquedaConstanciasArea.addItem(new Area(0, "todas"));
        qc.llenarAreas(comboBoxBusquedaConstanciasArea);
        qc.llenarListaAdscripciones(comboBoxFConf1Sede);
        qc.llenarListaAdscripciones(comboBoxFCur1Sede);
        qc.llenarListaAdscripciones(comboBoxFEvent1Sede);
        qc.llenarListaAdscripciones(comboBoxFMat1Sede);
        qc.llenarListaAdscripciones(comboBoxFVisit1Sede);
        qc.llenarListaAdscripciones(comboBoxFInfo1Sede);
    }
    
    public void llenarFechas(){
          
        textFieldFCur1FechaI.setText(""+fecha);
        textFieldFCur1FechaF.setText(""+fecha);
        textFieldFConf1FechaI.setText(""+fecha);
        textFieldFEvent1FechaI.setText(""+fecha);
        textFieldFEvent1FechaF.setText(""+fecha);
        textFieldFMat1FechaI.setText(""+fecha);
        textFieldFMat1FechaF.setText(""+fecha);
        textFieldFVisit1FechaI.setText(""+fecha);
        textFieldFVisit1FechaF.setText(""+fecha);
        textFieldFInfo1FechaI.setText(""+fecha);
        textFieldFInfo1FechaF.setText(""+fecha);
        textFechaEfCur2.setText(""+fecha);
        textFieldFechaEFConsG.setText(""+fecha);
        textFieldBusquedaConstanciasFechaI.setText(""+fecha);
        textFieldBusquedaConstanciasFechaF.setText(""+fecha);
        textFieldListadosFecha.setText(""+fecha);
        
    }
    
    
    public String mes(int mes) {
        switch (mes) {
            case 1:
                return "enero";
            case 2:
                return "febrero";
            case 3:
                return "marzo";
            case 4:
                return "abril";
            case 5:
                return "mayo";
            case 6:
                return "junio";
            case 7:
                return "julio";
            case 8:
                return "agosto";
            case 9:
                return "septiembre";
            case 10:
                return "octubre";
            case 11:
                return "noviembre";
            case 12:
                return "diciembre";
            default:
                return "Mes invalido";
        }

    }

    //Métodos Abstractos:
    @Override
    public void appCerrada() {
        try {
            qc.getBase().cerrarConexion();
        } catch (Exception e) {
            System.out.println("Conexion Cerrada");
        }

    }

    @Override
    public void llenarAds() {
        try {
            llenarCombos();
        } catch (Exception e) {
            textAreaGenerarCurso.append(e.toString() + "\n");
        }
    }

    @Override
    public void botonGenerarTodasLasConstancias() {

        lm.addTodasLasConstanciasFcur2();

    }

    @Override
    public void botonGenerarConstanciasGenerales() {
        int folioInicio;
        int folioFin;
        if (textFieldGenConsPorFolioInicio.getText().isEmpty()) {
            return;
        } else {
            folioInicio = Integer.parseInt(textFieldGenConsPorFolioInicio.getText());
        }

        if (textFieldGenConsPorFolioFin.getText().isEmpty()) {
            folioFin = folioInicio;
        } else {
            folioFin = Integer.parseInt(textFieldGenConsPorFolioFin.getText());
        }

        try {

            rm.generarConstanciasGenerales(folioInicio, folioFin, (String) comboBoxGenConsPorFolioPlantilla.getSelectedItem());

        } catch (Exception e) {
            logGestionarConstancias.append("Error al generar el PDF" + e.toString() + "\n");
        }
    }

    @Override
    public void botonConstanciaCursos() {
        try {
            rm.generarConstanciasCursos(Integer.parseInt(textFieldGenConsCursosPorNum.getText()), (String) comboBoxGenConsPorCursoPlantilla.getSelectedItem());

        } catch (Exception e) {
            logGestionarConstancias.append("Error al generar el PDF" + e.toString() + "\n");
        }

    }

    @Override
    public void botonCargarTablaCursos() {

        try {
            tm.cargarTablaCursos();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(VistaPrincipalHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void textFieldBuscarCursoGEventos() {
        tm.buscar(textFieldBusquedaGCurso.getText(), "curso");
    }

    @Override
    public void cargarTablaAsistentesCursos() {
        try {
            tm.cargarTablaAsistentesCursos();
        } catch (Exception ex) {
            Logger.getLogger(VistaPrincipalHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//-------------------------------------------------------------------------Fcur2
    @Override
    public void botonBuscarCursoFcur2() {
        lm.buscar(textFieldBusquedaCursoFcur2.getText(), "curso");
    }

    @Override
    public void botonBuscarProfesorFcur2() {
        lm.buscar(textFieldBusquedaProfesorFcur2.getText(), "profesor");
    }

    @Override
    public void botonAddProfesorFcur2() {
        lm.addConstanciaFcur2();
        
    }

    @Override
    public void botonQuitarProfesorFcur2() {
        lm.quitarConstanciaFcur2();
    }

    @Override
    public void botonSetMarca() {
        lm.setMarca(textFieldMarcaFcur2.getText());

    }

    @Override
    public void botonAddMarca() {
        lm.addMarca(textFieldMarcaFcur2.getText());
    }

//------------------------------------------------------------------------FConsG
    @Override
    public void botonGenerarConstanciaGeneral() {
        try {
            Constancia c = new Constancia();
            if (radioButtonAsesoriasFConsG.isSelected()) {
                Asesoria a = (Asesoria) listBusquedaEventoFConsG.getSelectedValue();
                c.setClaveC(a.getClaveAs());
                c.setTipo("asesorias");
            }
            if (radioButtonConcursosFConsG.isSelected()) {
                Concurso a = (Concurso) listBusquedaEventoFConsG.getSelectedValue();
                c.setClaveC(a.getClaveCo());
                c.setTipo("concursos");
            }
            if (RadioButtonConferenciasFConsG.isSelected()) {
                Conferencia a = (Conferencia) listBusquedaEventoFConsG.getSelectedValue();
                c.setClaveC(a.getClaveCo());
                c.setTipo("conferencias");
            }
            if (radioButtonCursosFConsG.isSelected()) {
                Curso a = (Curso) listBusquedaEventoFConsG.getSelectedValue();
                c.setClaveC(a.getClaveC());
                c.setTipo("cursos");
            }
            if (radioButtonEventosFConsG.isSelected()) {
                Evento a = (Evento) listBusquedaEventoFConsG.getSelectedValue();
                c.setClaveC(a.getClaveEv());
                c.setTipo("eventos");
            }
            if (radioButtonMaterialesFConsG.isSelected()) {
                Material a = (Material) listBusquedaEventoFConsG.getSelectedValue();
                c.setClaveC(a.getClaveM());
                c.setTipo("materiales");
            }
            if (radioButtonSeminariosFConsG.isSelected()) {
                Seminario a = (Seminario) listBusquedaEventoFConsG.getSelectedValue();
                c.setClaveC(a.getClaveS());
                c.setTipo("seminarios");
            }
            if (radioButtonTalleresFConsG.isSelected()) {
                Taller a = (Taller) listBusquedaEventoFConsG.getSelectedValue();
                c.setClaveC(a.getClaveTa());
                c.setTipo("talleres");
            }
            if (radioButtonVisitasFConsG.isSelected()) {
                Visita a = (Visita) listBusquedaEventoFConsG.getSelectedValue();
                c.setClaveC(a.getClaveV());
                c.setTipo("visitas");
            }
            if (radioButtonInfocabFConsG.isSelected()) {
                Infocab a = (Infocab) listBusquedaEventoFConsG.getSelectedValue();
                c.setClaveC(a.getClaveI());
                c.setTipo("infocab");
            }
            System.out.println(c.getTipo());
            System.out.println(c.getClaveC());

            c.setClaveNE(listBusquedaProfesorFConsG.getSelectedValue().getClaveNE());
            System.out.println(c.getClaveNE());

            c.setFolio(0);
            System.out.println(c.getFolio());

            c.setRealizada(textFieldRealizadaFConsG.getText());
            System.out.println(c.getRealizada());

            c.setFechaE(Date.valueOf(textFieldFechaEFConsG.getText()));
            System.out.println(c.getFechaE().toString());

            c.setTipoP(textAreaTipoPFConsG.getText());
            System.out.println(c.getTipoP());

            c.setEnlace(textAreaEnlaceFConsG.getText());
            System.out.println(c.getEnlace());

            c.setEntregado(Date.valueOf("0006-06-06"));
            System.out.println(c.getEntregado().toString());

            c.setReposicion("0");
            System.out.println(c.getReposicion());

            c.setEntrega("0");
            System.out.println(c.getEntrega());

            qc.insertConstancia(c);

            TextAreaGenerarConstanciaFConsG.append("Constancia Generada " + c.getTipo() + " - " + c.getClaveC() + " - " + c.getClaveNE() + "\n");

        } catch (Exception e) {
            TextAreaGenerarConstanciaFConsG.append("Error: " + e.toString() + "\n");
        }
    }

    public void modificarTextoEnlaceFConsG() {

            String sexo1="AL/A LA";
            String sexo2="interesadO/A";
            String  diaE = "D";
            String mesE = "M";
            String yearE = "Y";
        
        if (radioButtonAsesoriasFConsG.isSelected()) {//-------------------------------------------Asesorias
            Asesoria a = (Asesoria) listBusquedaEventoFConsG.getSelectedValue();
            int diaI =Integer.parseInt( a.getFechaI().toString().split("-")[2]);
            String mesI = mes(Integer.parseInt(a.getFechaI().toString().split("-")[1]));
            int diaF =Integer.parseInt( a.getFechaF().toString().split("-")[2]);
            String mesF = mes(Integer.parseInt(a.getFechaF().toString().split("-")[1]));

            try {
                if (listBusquedaProfesorFConsG.getSelectedValue().getSexo().equals("M")) {
                    sexo1 = "a la";
                    sexo2 = "interesada";
                } else {
                    sexo1 = "al";
                    sexo2 = "interesado";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            try {
                if (Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) == 1) {
                    diaE = "al primer día";
                } else {
                    diaE = "a los " + Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) + " días";
                }
                mesE = mes(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                yearE = textFieldFechaEFConsG.getText().split("-")[0];

            } catch (Exception e) {
                System.out.println(e.toString());
 
            }

            textAreaEnlaceFConsG.setText("llevada a cabo del " + diaI + " de " + mesI + " al " + diaF + " de " + mesF
                    + " del presente año."
                    + "\n\nSe extiende la presente para los fines que " + sexo1 + " " + sexo2
                    + " convengan " + diaE + " del mes de " + mesE + " de "+yearE+ ".");

        }
        if (radioButtonConcursosFConsG.isSelected()) {//-------------------------------------------------Concursos
            Concurso a = (Concurso) listBusquedaEventoFConsG.getSelectedValue();
            int diaI = Integer.parseInt(a.getFechaI().toString().split("-")[2]);
            String mesI = mes(Integer.parseInt(a.getFechaI().toString().split("-")[1]));
            int diaF = Integer.parseInt(a.getFechaF().toString().split("-")[2]);
            String mesF = mes(Integer.parseInt(a.getFechaF().toString().split("-")[1]));
            try {
                if (listBusquedaProfesorFConsG.getSelectedValue().getSexo().equals("M")) {
                    sexo1 = "a la";
                    sexo2 = "interesada";
                } else {
                    sexo1 = "al";
                    sexo2 = "interesado";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            try {
                if (Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) == 1) {
                    diaE = "al primer día";
                } else {
                    diaE = "a los " + Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) + " días";
                }
                System.out.println(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                mesE = mes(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                yearE = textFieldFechaEFConsG.getText().split("-")[0];

            } catch (Exception e) {
                System.out.println(e.toString());
                diaE = "D";
                mesE = "M";
            }

            textAreaEnlaceFConsG.setText("llevado a cabo del " + diaI + " de " + mesI + " al " + diaF + " de " + mesF
                    + " presente año."
                    + "\n\nSe extiende la presente para los fines que " + sexo1 + " " + sexo2
                    + " convengan " + diaE + " del mes de " + mesE + " de "+yearE+ ".");
        }
        if (RadioButtonConferenciasFConsG.isSelected()) {//-----------------------------------------Conferencias
            Conferencia a = (Conferencia) listBusquedaEventoFConsG.getSelectedValue();
            int diaI =Integer.parseInt( a.getFechaI().toString().split("-")[2]);
            String mesI = mes(Integer.parseInt(a.getFechaI().toString().split("-")[1]));
            try {
                if (listBusquedaProfesorFConsG.getSelectedValue().getSexo().equals("M")) {
                    sexo1 = "a la";
                    sexo2 = "interesada";
                } else {
                    sexo1 = "al";
                    sexo2 = "interesado";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            try {
                if (Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) == 1) {
                    diaE = "al primer día";
                } else {
                    diaE = "a los " + Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) + " días";
                }
                mesE = mes(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                yearE = textFieldFechaEFConsG.getText().split("-")[0];

            } catch (Exception e) {
                System.out.println(e.toString());
            }

            textAreaEnlaceFConsG.setText("llevada a cabo el " + diaI + " de " + mesI
                    + " del presente año."
                    + "\n\nSe extiende la presente para los fines que " + sexo1 + " " + sexo2
                    + " convengan " + diaE + " del mes de " + mesE + " de "+yearE+".");

        }
        if (radioButtonCursosFConsG.isSelected()) {//-------------------------------------------------Cursos
            Curso a = (Curso) listBusquedaEventoFConsG.getSelectedValue();
            int diaI = Integer.parseInt(a.getFechaI().toString().split("-")[2]);
            String mesI = mes(Integer.parseInt(a.getFechaI().toString().split("-")[1]));
            int diaF = Integer.parseInt(a.getFechaF().toString().split("-")[2]);
            String mesF = mes(Integer.parseInt(a.getFechaF().toString().split("-")[1]));
            String turno;
            String duracion;
            try {
                if (listBusquedaProfesorFConsG.getSelectedValue().getSexo().equals("M")) {
                    sexo1 = "a la";
                    sexo2 = "interesada";
                } else {
                    sexo1 = "al";
                    sexo2 = "interesado";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            try {
                if (Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) == 1) {
                    diaE = "al primer día";
                } else {
                    diaE = "a los " + Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) + " días";
                }
                mesE = mes(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                yearE = textFieldFechaEFConsG.getText().split("-")[0];
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            try {
                if (a.getTurno().equals("M")) {
                    turno = " Durante el turno Matutino";

                } else {
                    turno = "";
                }
                if (a.getTurno().equals("V")) {
                    turno = " Durante el turno Vespertino";
                }
                if (a.getTurno().equals("V")) {
                    turno = " Durante el turno Mixto";
                }
            } catch (Exception e) {
                turno = "";
            }

            try {
                duracion = " Con una duración de " + a.getHoras() + " horas.";
            } catch (Exception e) {
                duracion = "";
            }

            textAreaEnlaceFConsG.setText("llevado a cabo del " + diaI + " de " + mesI + " al " + diaF + " de " + mesF
                    + " del presente año." + turno + duracion
                    + "\n\nSe extiende la presente para los fines que " + sexo1 + " " + sexo2
                    + " convengan " + diaE + " del mes de " + mesE + " de "+yearE+".");
        }
        if (radioButtonEventosFConsG.isSelected()) {//-----------------------------------------------Eventos
            Evento a = (Evento) listBusquedaEventoFConsG.getSelectedValue();
            int diaI = Integer.parseInt(a.getFechaI().toString().split("-")[2]);
            String mesI = mes(Integer.parseInt(a.getFechaI().toString().split("-")[1]));
            int diaF = Integer.parseInt(a.getFechaF().toString().split("-")[2]);
            String mesF = mes(Integer.parseInt(a.getFechaF().toString().split("-")[1]));
            try {
                if (listBusquedaProfesorFConsG.getSelectedValue().getSexo().equals("M")) {
                    sexo1 = "a la";
                    sexo2 = "interesada";
                } else {
                    sexo1 = "al";
                    sexo2 = "interesado";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            try {
                if (Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) == 1) {
                    diaE = "al primer día";
                } else {
                    diaE = "a los " + Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) + " días";
                }
                System.out.println(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                mesE = mes(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                yearE = textFieldFechaEFConsG.getText().split("-")[0];
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            textAreaEnlaceFConsG.setText("llevado a cabo del " + diaI + " de " + mesI + " al " + diaF + " de " + mesF
                    + " del presente año en las instalaciones del plantel."
                    + "\n\nSe extiende la presente para los fines que " + sexo1 + " " + sexo2
                    + " convengan " + diaE + " del mes de " + mesE + " de "+yearE+".");
        }
        if (radioButtonMaterialesFConsG.isSelected()) {//---------------------------------------------Materiales
            Material a = (Material) listBusquedaEventoFConsG.getSelectedValue();
            int diaI = Integer.parseInt(a.getFechaI().toString().split("-")[2]);
            String mesI = mes(Integer.parseInt(a.getFechaI().toString().split("-")[1]));
            int diaF = Integer.parseInt(a.getFechaF().toString().split("-")[2]);
            String mesF = mes(Integer.parseInt(a.getFechaF().toString().split("-")[1]));
            try {
                if (listBusquedaProfesorFConsG.getSelectedValue().getSexo().equals("M")) {
                    sexo1 = "a la";
                    sexo2 = "interesada";
                } else {
                    sexo1 = "al";
                    sexo2 = "interesado";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            try {
                if (Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) == 1) {
                    diaE = "al primer día";
                } else {
                    diaE = "a los " + Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) + " días";
                }
                System.out.println(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                mesE = mes(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                yearE = textFieldFechaEFConsG.getText().split("-")[0];
            } catch (Exception e) {
                System.out.println(e.toString());

            }

            textAreaEnlaceFConsG.setText("llevado a cabo del " + diaI + " de " + mesI + " al " + diaF + " de " + mesF
                    + " del presente año."
                    + "\n\nSe extiende la presente para los fines que " + sexo1 + " " + sexo2
                    + " convengan " + diaE + " del mes de " + mesE + " de "+yearE+".");
        }
        if (radioButtonSeminariosFConsG.isSelected()) {//------------------------------------------------------Seminarios
            Seminario a = (Seminario) listBusquedaEventoFConsG.getSelectedValue();
            int diaI = Integer.parseInt(a.getFechaI().toString().split("-")[2]);
            String mesI = mes(Integer.parseInt(a.getFechaI().toString().split("-")[1]));
            int diaF = Integer.parseInt(a.getFechaF().toString().split("-")[2]);
            String mesF = mes(Integer.parseInt(a.getFechaF().toString().split("-")[1]));
            try {
                if (listBusquedaProfesorFConsG.getSelectedValue().getSexo().equals("M")) {
                    sexo1 = "a la";
                    sexo2 = "interesada";
                } else {
                    sexo1 = "al";
                    sexo2 = "interesado";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            try {
                if (Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) == 1) {
                    diaE = "al primer día";
                } else {
                    diaE = "a los " + Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) + " días";
                }
                mesE = mes(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                yearE = textFieldFechaEFConsG.getText().split("-")[0];
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            textAreaEnlaceFConsG.setText("llevado a cabo del " + diaI + " de " + mesI + " al " + diaF + " de " + mesF
                    + " del presente año."
                    + "\n\nSe extiende la presente para los fines que " + sexo1 + " " + sexo2
                    + " convengan " + diaE + " del mes de " + mesE + " de "+yearE+".");
        }
        if (radioButtonTalleresFConsG.isSelected()) {//------------------------------------------Talleres
            Taller a = (Taller) listBusquedaEventoFConsG.getSelectedValue();
            int diaI = Integer.parseInt(a.getFechaI().toString().split("-")[2]);
            String mesI = mes(Integer.parseInt(a.getFechaI().toString().split("-")[1]));
            int diaF = Integer.parseInt(a.getFechaF().toString().split("-")[2]);
            String mesF = mes(Integer.parseInt(a.getFechaF().toString().split("-")[1]));
            try {
                if (listBusquedaProfesorFConsG.getSelectedValue().getSexo().equals("M")) {
                    sexo1 = "a la";
                    sexo2 = "interesada";
                } else {
                    sexo1 = "al";
                    sexo2 = "interesado";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            try {
                if (Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) == 1) {
                    diaE = "al primer día";
                } else {
                    diaE = "a los " + Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) + " días";
                }
                mesE = mes(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                yearE = textFieldFechaEFConsG.getText().split("-")[0];
            } catch (Exception e) {
                System.out.println(e.toString());

            }

            textAreaEnlaceFConsG.setText("llevado a cabo del " + diaI + " de " + mesI + " al " + diaF + " de " + mesF
                    + " del presente año."
                    + "\n\nSe extiende la presente para los fines que " + sexo1 + " " + sexo2
                    + " convengan " + diaE + " del mes de " + mesE + " de "+yearE+".");
        }
        if (radioButtonVisitasFConsG.isSelected()) {//----------------------------------------------Visitas
            Visita a = (Visita) listBusquedaEventoFConsG.getSelectedValue();
            int diaI = Integer.parseInt(a.getFechaI().toString().split("-")[2]);
            String mesI = mes(Integer.parseInt(a.getFechaI().toString().split("-")[1]));
            int diaF = Integer.parseInt(a.getFechaF().toString().split("-")[2]);
            String mesF = mes(Integer.parseInt(a.getFechaF().toString().split("-")[1]));
            try {
                if (listBusquedaProfesorFConsG.getSelectedValue().getSexo().equals("M")) {
                    sexo1 = "a la";
                    sexo2 = "interesada";
                } else {
                    sexo1 = "al";
                    sexo2 = "interesado";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            try {
                if (Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) == 1) {
                    diaE = "al primer día";
                } else {
                    diaE = "a los " + Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) + " días";
                }
                mesE = mes(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                yearE = textFieldFechaEFConsG.getText().split("-")[0];
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            textAreaEnlaceFConsG.setText("llevado a cabo del " + diaI + " de " + mesI + " al " + diaF + " de " + mesF
                    + " del presente año."
                    + "\n\nSe extiende la presente para los fines que " + sexo1 + " " + sexo2
                    + " convengan " + diaE + " del mes de " + mesE + " de "+yearE+".");
        }
        if (radioButtonInfocabFConsG.isSelected()) {//---------------------------------------------------Infocab
            Infocab a = (Infocab) listBusquedaEventoFConsG.getSelectedValue();
            int diaI = Integer.parseInt( a.getFechaI().toString().split("-")[2]);
            String mesI = mes(Integer.parseInt(a.getFechaI().toString().split("-")[1]));
            int diaF = Integer.parseInt(a.getFechaF().toString().split("-")[2]);
            String mesF = mes(Integer.parseInt(a.getFechaF().toString().split("-")[1]));
            try {
                if (listBusquedaProfesorFConsG.getSelectedValue().getSexo().equals("M")) {
                    sexo1 = "a la";
                    sexo2 = "interesada";
                } else {
                    sexo1 = "al";
                    sexo2 = "interesado";
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            try {
                if (Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) == 1) {
                    diaE = "al primer día";
                } else {
                    diaE = "a los " + Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[2]) + " días";
                }
                mesE = mes(Integer.parseInt(textFieldFechaEFConsG.getText().split("-")[1]));
                yearE = textFieldFechaEFConsG.getText().split("-")[0];
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            textAreaEnlaceFConsG.setText("llevado a cabo del " + diaI + " de " + mesI + " al " + diaF + " de " + mesF
                    + " del presente año."
                    + "\n\nSe extiende la presente para los fines que " + sexo1 + " " + sexo2
                    + " convengan " + diaE + " del mes de " + mesE + " de "+yearE+".");
        }

    }

    @Override
    public void botonBuscarProfesorFConsG() {
        labelConstanciaGeneralTextoNombre.setText("");
        lm.buscar(textFieldBusquedaProfesorFConsG.getText(), "profesor");
    }

    @Override
    public void seleccionListaProfesorFConsG() {

        String sexo;
        try {

            if (listBusquedaProfesorFConsG.getSelectedValue().getSexo().equals("M")) {
                sexo = "A la";
            } else {
                sexo = "Al";

            }
            labelConstanciaGeneralTextoTitulo.setText(sexo + " " + listBusquedaProfesorFConsG.getSelectedValue().getTitulo());
            labelConstanciaGeneralTextoNombre.setText(listBusquedaProfesorFConsG.getSelectedValue().getNombre()
                    + " " + listBusquedaProfesorFConsG.getSelectedValue().getApellidoP()
                    + " " + listBusquedaProfesorFConsG.getSelectedValue().getApellidoM());
        } catch (Exception e) {
        }

    }

    @Override
    public void introducirTextoTextAreaTipoPFConsG() {
        labelConstanciaGeneralTextoTipoP.setText("<html><body>" + textAreaTipoPFConsG.getText() + "</body></html>");
    }

    @Override
    public void introducirTextoTextAreaEnlaceFConsG() {
        labelConstanciaGeneralEnlace.setText("<html><body>" + textAreaEnlaceFConsG.getText() + "</body></html>");
    }

    @Override
    public void botonBuscarEventoFConsG() {

        if (radioButtonAsesoriasFConsG.isSelected()) {
            lm.buscar(textFieldBusquedaEventoFConsG.getText(), "asesoria");
        }
        if (radioButtonConcursosFConsG.isSelected()) {
            lm.buscar(textFieldBusquedaEventoFConsG.getText(), "concurso");
        }
        if (RadioButtonConferenciasFConsG.isSelected()) {
            lm.buscar(textFieldBusquedaEventoFConsG.getText(), "conferencia");
        }
        if (radioButtonCursosFConsG.isSelected()) {
            lm.buscar(textFieldBusquedaEventoFConsG.getText(), "curso");
        }
        if (radioButtonEventosFConsG.isSelected()) {
            lm.buscar(textFieldBusquedaEventoFConsG.getText(), "evento");
        }
        if (radioButtonMaterialesFConsG.isSelected()) {
            lm.buscar(textFieldBusquedaEventoFConsG.getText(), "material");
        }
        if (radioButtonSeminariosFConsG.isSelected()) {
            lm.buscar(textFieldBusquedaEventoFConsG.getText(), "seminario");
        }
        if (radioButtonTalleresFConsG.isSelected()) {
            lm.buscar(textFieldBusquedaEventoFConsG.getText(), "taller");
        }
        if (radioButtonVisitasFConsG.isSelected()) {
            lm.buscar(textFieldBusquedaEventoFConsG.getText(), "visita");
        }
        if (radioButtonInfocabFConsG.isSelected()) {
            lm.buscar(textFieldBusquedaEventoFConsG.getText(), "infocab");
        }

    }

    @Override
    public void tipoDeEventoSeleccionadoFConsG() {
        lm.vaciarLista(lm.getLmBusquedaEventoFConsG());
        labelConstanciaGeneralEvento.setText("");
        labelConstanciaGeneralEnlace.setText("");
        botonBuscarEventoFConsG();
    }

    @Override
    public void seleccionListaEventoFConsG() {
        try {

            if (radioButtonAsesoriasFConsG.isSelected()) {
                Asesoria a = (Asesoria) listBusquedaEventoFConsG.getSelectedValue();
                labelConstanciaGeneralEvento.setText("<html><body>" + a.getNombreAsesoria() + "</body></html>");
            }
            if (radioButtonConcursosFConsG.isSelected()) {
                Concurso a = (Concurso) listBusquedaEventoFConsG.getSelectedValue();
                labelConstanciaGeneralEvento.setText("<html><body>" + a.getNombreConcurso() + "</body></html>");
            }
            if (RadioButtonConferenciasFConsG.isSelected()) {
                Conferencia a = (Conferencia) listBusquedaEventoFConsG.getSelectedValue();
                labelConstanciaGeneralEvento.setText("<html><body>" + a.getNombreConf() + "</body></html>");
            }
            if (radioButtonCursosFConsG.isSelected()) {
                Curso a = (Curso) listBusquedaEventoFConsG.getSelectedValue();
                labelConstanciaGeneralEvento.setText("<html><body>" + a.getNombreCurso() + "</body></html>");
            }
            if (radioButtonEventosFConsG.isSelected()) {
                Evento a = (Evento) listBusquedaEventoFConsG.getSelectedValue();
                labelConstanciaGeneralEvento.setText("<html><body>" + a.getNombreEv() + "</body></html>");
            }
            if (radioButtonMaterialesFConsG.isSelected()) {
                Material a = (Material) listBusquedaEventoFConsG.getSelectedValue();
                labelConstanciaGeneralEvento.setText("<html><body>" + a.getNombreMaterial() + "</body></html>");
            }
            if (radioButtonSeminariosFConsG.isSelected()) {
                Seminario a = (Seminario) listBusquedaEventoFConsG.getSelectedValue();
                labelConstanciaGeneralEvento.setText("<html><body>" + a.getNombreSeminario() + "</body></html>");
            }
            if (radioButtonTalleresFConsG.isSelected()) {
                Taller a = (Taller) listBusquedaEventoFConsG.getSelectedValue();
                labelConstanciaGeneralEvento.setText("<html><body>" + a.getNombreTaller() + "</body></html>");
            }
            if (radioButtonVisitasFConsG.isSelected()) {
                Visita a = (Visita) listBusquedaEventoFConsG.getSelectedValue();
                labelConstanciaGeneralEvento.setText("<html><body>" + a.getNombreVisita() + "</body></html>");
            }
            if (radioButtonInfocabFConsG.isSelected()) {
                Infocab a = (Infocab) listBusquedaEventoFConsG.getSelectedValue();
                labelConstanciaGeneralEvento.setText("<html><body>" + a.getNombreProyecto() + "</body></html>");
            }
        } catch (Exception e) {
        }
        try {
            modificarTextoEnlaceFConsG();
            introducirTextoTextAreaEnlaceFConsG();
        } catch (Exception e) {
        }

    }

//------------------------------------------------------------------------------Fcur1
    @Override
    public void botonAddCursoFcur1() {
        lm.addCursoFcur1();
    }

    @Override
    public void botonModifyCursoFcur1() {
        lm.modifyCursoFcur1();
    }

    @Override
    public void botonAddTodosLosCursosFcur1() {
        lm.addTodosLosCursosFcur1();
    }

//------------------------------------------------------------------------------FConf1
    @Override
    public void botonAddConferenciaFConf1() {
        lm.addConferenciaFConf1();
    }

    @Override
    public void botonModifyConferenciaFConf1() {
        lm.modifyConferenciaFconf1();
    }

    @Override
    public void botonAddTodasLasConferenciasFConf1() {
        lm.addTodasLasConferenciasFConf1();
    }

//------------------------------------------------------------------------------FEvent1
    @Override
    public void botonAddEventoFEvent1() {
        lm.addEventoFEvent1();
    }

    @Override
    public void botonModifyEventoFEvent1() {
        lm.modifyEventoFEvent1();
    }

    @Override
    public void botonAddTodosLosEventosFEvent1() {
        lm.addTodosLosEventos();
    }

//------------------------------------------------------------------------------FMat1
    @Override
    public void botonAddMaterialFMat1() {
        lm.addMaterialFMat1();
    }

    @Override
    public void botonModifyMaterialFMat1() {
        lm.modifyMaterialFMat1();
    }

    @Override
    public void botonAddTodosLosMaterialesFMat1() {
        lm.addTodosLosMateriales();
    }

//------------------------------------------------------------------------------FVisit1
    @Override
    public void botonAddVisitaFVisit1() {
        lm.addVisitaFVisit1();
    }

    @Override
    public void botonModifyVisitaFVisit1() {
        lm.modifyVisitaFVisit1();
    }

    @Override
    public void botonAddTodasLasVisitasFVisit1() {
        lm.addTodasLasVisitas();
    }

//------------------------------------------------------------------------------FInfo1
    @Override
    public void botonAddInfocabFInfo1() {
        lm.addInfocabFInfo1();
    }

    @Override
    public void botonModifyInfocabFInfo1() {
        lm.modifyInfocabFInfo1();
    }

    @Override
    public void botonAddTodosLosInfocabFInfo1() {
        lm.addTodosLosInfocab();
    }
//------------------------------------------------------------------------------Listados

    @Override
    public void botonAgregarConstanciaAListado() {
        lm.addConstanciasListado();
    }

    @Override
    public void botonQuitarConstanciaDeListado() {
        lm.quitarConstanciaListado();
    }

    @Override
    public void botonLimpiarListado() {
        lm.limpiarListado();
    }

    @Override
    public void botonCargarListados() {
        lm.cargarTodosLosListados();
    }

    @Override
    public void listadoSeleccionado() {
        lm.cardarListadoSeleccionado();
    }

    @Override
    public void botonGuardarListado() {
        lm.guardarListado();
    }

    @Override
    public void botonCrearListado() {
        lm.crearListado();
    }

    @Override
    public void botonListadosGenerarPDF() {
        try {
            rm.generarListado(listListados.getSelectedValue());
        } catch (Exception e) {
            logGestionarConstancias.append(e.toString() + "\n");
        }
    }

    @Override
    public void botonListadosGenerarConstanciasDeCursos() {
        try {
            rm.generarConstanciasCursosPorListado(listListados.getSelectedValue().getNumero(), (String) comboBoxGenConsPorCursoPlantilla.getSelectedItem());
        } catch (Exception e) {
            logGestionarConstancias.append(e.toString() + "\n");
        }
    }

    @Override
    public void botonListadosGenerarConstanciasGenerales() {
        try {
            rm.generarConstanciasGeneralesPorListado(listListados.getSelectedValue().getNumero(), (String) comboBoxGenConsPorFolioPlantilla.getSelectedItem());
        } catch (Exception e) {
            logGestionarConstancias.append(e.toString() + "\n");
        }

    }

//------------------------------------------------------------------------------Gestionar constancias
    @Override
    public void botonCargarTablaConstancias() {
        try {
            tm.cargarTablaConstancias();
        } catch (SQLException | ClassNotFoundException ex) {
            logGestionarConstancias.append(ex.toString() + "\n");
        }
    }

    @Override
    public void botonLimpiarBusqueda() {

        textFieldBusquedaConstanciasFolioI.setText("");
        textFieldBusquedaConstanciasFolioF.setText("");
        comboBoxBusquedaConstanciasArea.setSelectedIndex(0);
        comboBoxBusquedaConstanciasTipo.setSelectedIndex(0);
        textFieldBusquedaConstanciasFechaI.setText("");
        textFieldBusquedaConstanciasFechaF.setText("");
        textFieldBusquedaConstanciasProfesor.setText("");
        comboBoxBusquedaConstanciasProfesor.removeAllItems();
        textFieldBusquedaConstanciasTipoP.setText("");
        textFieldBusquedaConstanciasEvento.setText("");
        tm.vaciarTabla(tableConstancias);
    }

    @Override
    public void botonSetEntrega() {
        try {
            String fecha = textFieldFechaEntregado.getText();
            int folio = (int) tableConstancias.getValueAt(tableConstancias.getSelectedRow(), 5);
            qc.setEntregado(folio, fecha);
            logGestionarConstancias.append("Entrega Actualizada: " + folio + " - " + fecha + "\n");
        } catch (Exception e) {
            logGestionarConstancias.append("Error: " + e.toString() + "\n");
        }
    }

    @Override
    public void botonResetEntrega() {
        try {
            String fecha = "0006-06-06";
            int folio = (int) tableConstancias.getValueAt(tableConstancias.getSelectedRow(), 5);
            qc.setEntregado(folio, fecha);
            logGestionarConstancias.append("Entrega revertida: " + folio);
        } catch (Exception e) {
            logGestionarConstancias.append("Error: " + e.toString() + "\n");
        }
    }

    @Override 
    public void botonBuscarProfesorGConstancias() {
        lm.buscar(textFieldBusquedaConstanciasProfesor.getText(), "profesor");
    }

    @Override
    public void botonAcuse() {
        int folio;
        folio = (int)tableConstancias.getValueAt(tableConstancias.getSelectedRow(), 5);
        rm.abrirAcuse(folio);
    }
    
    //Getters & Setters:
    public QueryCollection getQc() {
        return qc;
    }

    public void setQc(QueryCollection qc) {
        this.qc = qc;
    }

}
