package control;

import java.sql.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import modelo.QueryCollection;
import mapeo.*;
/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class ListasManager {
    //Atributos:

    VistaPrincipalHandler vp;
    QueryCollection qc;

    DefaultListModel<Curso> lmCurso = new DefaultListModel<>();
    DefaultListModel<Conferencia> lmConferencia = new DefaultListModel<>();
    DefaultListModel<Evento> lmEvento = new DefaultListModel<>();
    DefaultListModel<Material> lmMaterial = new DefaultListModel<>();
    DefaultListModel<Visita> lmVisita = new DefaultListModel<>();
    DefaultListModel<Infocab> lmInfocab = new DefaultListModel<>();

    DefaultListModel<Curso> lmBusquedaCursoFcur2 = new DefaultListModel<>();
    DefaultListModel<Profesor> lmBusquedaProfesorFcur2 = new DefaultListModel<>();
    DefaultListModel<Profesor> lmBusquedaProfesorFConsG = new DefaultListModel<>();
    DefaultListModel<Constancia> lmListaConstanciaProfesorFcur2 = new DefaultListModel<>();
    DefaultListModel<Object> lmBusquedaEventoFConsG = new DefaultListModel<>();
    DefaultListModel<Constancia> lmListaListadosConstancias = new DefaultListModel<>();
    DefaultListModel<Listado> lmListaListados = new DefaultListModel<>();

    //Constructores:
    public ListasManager(VistaPrincipalHandler vp, QueryCollection qc) {
        this.vp = vp;
        this.qc = qc;
        vp.getListCursosFcur1().setModel(lmCurso);
        vp.getListConferenciasFConf1().setModel(lmConferencia);
        vp.getListEventosFEvent1().setModel(lmEvento);
        vp.getListMaterialesFMat1().setModel(lmMaterial);
        vp.getListVisitasFVisit1().setModel(lmVisita);
        vp.getListInfocabFInfo1().setModel(lmInfocab);

        vp.getListConstanciasFcur2().setModel(lmListaConstanciaProfesorFcur2);
        vp.getListBusquedaCursoFcur2().setModel(lmBusquedaCursoFcur2);
        vp.getListBusquedaProfesorFcur2().setModel(lmBusquedaProfesorFcur2);
        vp.getListBusquedaProfesorFConsG().setModel(lmBusquedaProfesorFConsG);
        vp.getListBusquedaEventoFConsG().setModel(lmBusquedaEventoFConsG);
        vp.getListListadosConstancias().setModel(lmListaListadosConstancias);
        vp.getListListados().setModel(lmListaListados);
        System.out.println("LM creada");
    }

    //Métodos:
    public void vaciarLista(DefaultListModel dm) {
        dm.removeAllElements();
    }

    public void buscar(String busqueda, String tipo) {

        switch (tipo) {

            case "profesor"://------------------------------------------Profesor
                lmBusquedaProfesorFcur2.removeAllElements();
                lmBusquedaProfesorFConsG.removeAllElements();
                vp.getComboBoxBusquedaConstanciasProfesor().removeAllItems();
                
                if (busqueda.equals("") || busqueda.length() < 3) {
                    lmBusquedaProfesorFcur2.removeAllElements();
                    lmBusquedaProfesorFConsG.removeAllElements();
                    vp.getComboBoxBusquedaConstanciasProfesor().removeAllItems();
                } else {
                    try { //----------------------------------Busqueda por Clave
                        for (Object c : qc.selectAllProfesoresPorClaveNE(Integer.parseInt(busqueda))) {
                            lmBusquedaProfesorFcur2.addElement((Profesor) c);
                            lmBusquedaProfesorFConsG.addElement((Profesor) c);
                            vp.getComboBoxBusquedaConstanciasProfesor().addItem((Profesor) c);
                        }
                    } catch (Exception e) {
                    }
                    try {//------------------------Busqueda por Nombre Completo

                        for (Object c : qc.selectAllProfesoresPorNombreCompleto(busqueda)) {
                            lmBusquedaProfesorFcur2.addElement((Profesor) c);
                            lmBusquedaProfesorFConsG.addElement((Profesor) c);
                            vp.getComboBoxBusquedaConstanciasProfesor().addItem((Profesor) c);
                        }

                    } catch (Exception e) {
                    }
//                    try {//------------------------Busqueda por Apellido Paterno
//
//                        for (Object c : qc.selectAllProfesoresPorApellidoP(busqueda)) {
//                            lmBusquedaProfesorFcur2.addElement((Profesor) c);
//                            lmBusquedaProfesorFConsG.addElement((Profesor) c);
//                        }
//
//                    } catch (Exception e) {
//                    }
//                    try {//----------------------------------Busqueda por Nombre
//                        for (Object c : qc.selectAllProfesoresPorNombre(busqueda)) {
//                            lmBusquedaProfesorFcur2.addElement((Profesor) c);
//                            lmBusquedaProfesorFConsG.addElement((Profesor) c);
//                        }
//                    } catch (Exception e) {
//                    }
//                    try {//------------------------Busqueda por apellido materno
//                        for (Object c : qc.selectAllProfesoresPorApellidoM(busqueda)) {
//                            lmBusquedaProfesorFcur2.addElement((Profesor) c);
//                            lmBusquedaProfesorFConsG.addElement((Profesor) c);
//                        }
//                    } catch (Exception e) {
//                    }

                }

                break;
            case "asesoria"://-----------------------------------------Asesorias
                lmBusquedaEventoFConsG.removeAllElements();
                if (busqueda.equals("") || busqueda.length() < 3) {
                    lmBusquedaEventoFConsG.removeAllElements();
                } else {
                    try {
                        for (Object c : qc.selectAllAsesoriasPorClaveC(Integer.parseInt(busqueda))) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                    try {
                        for (Object c : qc.selectAllAsesoriasPorNombre(busqueda)) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case "concurso"://-----------------------------------------Concursos
                lmBusquedaEventoFConsG.removeAllElements();
                if (busqueda.equals("") || busqueda.length() < 3) {
                    lmBusquedaEventoFConsG.removeAllElements();
                } else {
                    try {
                        for (Object c : qc.selectAllConcursosPorClaveC(Integer.parseInt(busqueda))) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                    try {
                        for (Object c : qc.selectAllConcursosPorNombre(busqueda)) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case "conferencia"://-----------------------------------Conferencias
                lmBusquedaEventoFConsG.removeAllElements();
                if (busqueda.equals("") || busqueda.length() < 3) {
                    lmBusquedaEventoFConsG.removeAllElements();
                } else {
                    try {
                        for (Object c : qc.selectAllConferenciasPorClaveC(Integer.parseInt(busqueda))) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {

                    }
                    try {
                        for (Object c : qc.selectAllConferenciasPorNombre(busqueda)) {

                            lmBusquedaEventoFConsG.addElement(c);

                        }

                    } catch (Exception e) {
                    }
                }
                break;
            case "constancia":
                break;
            case "curso"://-----------------------------------------------Cursos
                lmBusquedaCursoFcur2.removeAllElements();
                lmBusquedaEventoFConsG.removeAllElements();
                if (busqueda.equals("") || busqueda.length() < 3) {
                    lmBusquedaCursoFcur2.removeAllElements();
                    lmBusquedaEventoFConsG.removeAllElements();
                } else {
                    try {
                        for (Object c : qc.selectAllCursosPorClaveC(Integer.parseInt(busqueda))) {
                            lmBusquedaCursoFcur2.addElement((Curso) c);
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                    try {
                        for (Object c : qc.selectAllCursosPorNombre(busqueda)) {
                            lmBusquedaCursoFcur2.addElement((Curso) c);
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                }
                break;

            case "diplomado":
                break;
            case "evento"://----------------------------------------------Evento
                lmBusquedaEventoFConsG.removeAllElements();
                if (busqueda.equals("") || busqueda.length() < 3) {
                    lmBusquedaEventoFConsG.removeAllElements();
                } else {
                    try {
                        for (Object c : qc.selectAllEventosPorClaveC(Integer.parseInt(busqueda))) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                    try {
                        for (Object c : qc.selectAllEventosPorNombre(busqueda)) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case "material"://------------------------------------------Material
                lmBusquedaEventoFConsG.removeAllElements();
                if (busqueda.equals("") || busqueda.length() < 3) {
                    lmBusquedaEventoFConsG.removeAllElements();
                } else {
                    try {
                        for (Object c : qc.selectAllMaterialesPorClaveC(Integer.parseInt(busqueda))) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                    try {
                        for (Object c : qc.selectAllMaterialesPorNombre(busqueda)) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case "seminario"://----------------------------------------Seminario
                lmBusquedaEventoFConsG.removeAllElements();
                if (busqueda.equals("") || busqueda.length() < 3) {
                    lmBusquedaEventoFConsG.removeAllElements();
                } else {
                    try {
                        for (Object c : qc.selectAllSeminariosPorClaveC(Integer.parseInt(busqueda))) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                    try {
                        for (Object c : qc.selectAllSeminariosPorNombre(busqueda)) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case "taller"://----------------------------------------------Taller
                lmBusquedaEventoFConsG.removeAllElements();
                if (busqueda.equals("") || busqueda.length() < 3) {
                    lmBusquedaEventoFConsG.removeAllElements();
                } else {
                    try {
                        for (Object c : qc.selectAllTalleresPorClaveC(Integer.parseInt(busqueda))) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                    try {
                        for (Object c : qc.selectAllTalleresPorNombre(busqueda)) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case "visita"://----------------------------------------------Visita
                lmBusquedaEventoFConsG.removeAllElements();
                if (busqueda.equals("") || busqueda.length() < 3) {
                    lmBusquedaEventoFConsG.removeAllElements();
                } else {
                    try {
                        for (Object c : qc.selectAllVisitasPorClaveC(Integer.parseInt(busqueda))) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                    try {
                        for (Object c : qc.selectAllVisitasPorNombre(busqueda)) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case "infocab"://--------------------------------------------Infocab
                lmBusquedaEventoFConsG.removeAllElements();
                if (busqueda.equals("") || busqueda.length() < 3) {
                    lmBusquedaEventoFConsG.removeAllElements();
                } else {
                    try {
                        for (Object c : qc.selectAllInfocabPorClaveC(Integer.parseInt(busqueda))) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                    try {
                        for (Object c : qc.selectAllInfocabPorNombre(busqueda)) {
                            lmBusquedaEventoFConsG.addElement(c);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            case "pride":
                break;

        }

    }

    private int indexSede(int sede) {
        try {
            ComboBoxModel model = vp.getComboBoxFCur1Sede().getModel();
            int size = model.getSize();
            for (int i = 0; i < size; i++) {
                Adscripcion a = (Adscripcion) model.getElementAt(i);
                if (a.getAdscr() == sede) {
                    return i;
                }
            }

        } catch (Exception e) {
        }
        return 0;
    }

//------------------------------------------------------------------------------Listados
    public void quitarConstanciaListado() {
        lmListaListadosConstancias.removeElement(vp.getListListadosConstancias().getSelectedValue());
    }

    public void addConstanciasListado() {
        if (vp.getListListados().isSelectionEmpty()) {
            vp.getLogGestionarConstancias().append("Listado no seleccionado" + "\n");
            return;
        }
        try {
            if (lmListaListadosConstancias.isEmpty()) {
                for (int i : vp.getTableConstancias().getSelectedRows()) {
                    Constancia c = qc.selectConstanciaPorFolio((int) vp.getTableConstancias().getValueAt(i, 5));
                    lmListaListadosConstancias.addElement(c);
                }
            } else {
                for (int fila : vp.getTableConstancias().getSelectedRows()) {
                    int folio = (int) vp.getTableConstancias().getValueAt(fila, 5);
                    if (!estaEnElListado(folio)) {
                        Constancia c = qc.selectConstanciaPorFolio(folio);
                        lmListaListadosConstancias.addElement(c);
                    } else {
                        vp.getLogGestionarConstancias().append(folio + " ya está en el listado" + "\n");
                    }
                }

            }

        } catch (Exception e) {
            vp.getLogGestionarConstancias().append(e.toString() + "\n");
        }

    }

    public boolean estaEnElListado(int folio) {

        int elementos = lmListaListadosConstancias.getSize();

        for (int i = 0; i < elementos; i++) {
            Constancia con = lmListaListadosConstancias.getElementAt(i);
            if (con.getFolio() == folio) {
                System.out.println("if");
                return true;
            }
        }
        return false;
    }

    public void limpiarListado() {
        vaciarLista(lmListaListadosConstancias);
        cargarTodosLosListados();
    }

    public void cargarTodosLosListados() {
        vaciarLista(lmListaListados);
        vaciarLista(lmListaListadosConstancias);
        try {
            for (Listado l : qc.selectAllListados()) {
                lmListaListados.addElement(l);
            }
        } catch (Exception e) {
            vp.getLogGestionarConstancias().append(e.toString() + "\n");
        }
    }

    public void cardarListadoSeleccionado() {
        vaciarLista(lmListaListadosConstancias);
        try {
            Listado l = vp.getListListados().getSelectedValue();
            for (Constancia c : qc.selectListadoConstancias(l.getNumero())) {
                lmListaListadosConstancias.addElement(c);
            }
        } catch (Exception e) {
            vp.getLogGestionarConstancias().append(e.toString() + "\n");
        }

    }

    public void guardarListado() {
        try {

            Listado l = vp.getListListados().getSelectedValue();
            int elementos = lmListaListadosConstancias.getSize();

            qc.deleteListadoConstancias(l);

            for (int i = 0; i < elementos; i++) {
                Constancia con = lmListaListadosConstancias.getElementAt(i);
                qc.insertListadoConstancia(l, con);
                vp.getLogGestionarConstancias().append(con.getFolio()+" - guardada"+ "\n");
            }
            vp.getLogGestionarConstancias().append("Listado No: "+l.getNumero()+" guardado"+" \n");
        } catch (Exception e) {
            vp.getLogGestionarConstancias().append(e.toString() + "\n");
        }
    }

    public void crearListado() {
        try {
            Listado l = new Listado(0, Date.valueOf(vp.getTextFieldListadosFecha().getText()), vp.getTextFieldListadosDesc().getText());
            qc.insertListado(l);
            vp.getLogGestionarConstancias().append("Listado creado"+"\n");
            cargarTodosLosListados();
            vp.getTextFieldListadosFecha().setText("");
            vp.getTextFieldListadosDesc().setText("");
        } catch (Exception e) {
            vp.getLogGestionarConstancias().append(e.toString() + "\n");
        }
    }
//------------------------------------------------------------------------------Fcur2      

    public void quitarConstanciaFcur2() {
        lmListaConstanciaProfesorFcur2.removeElement(vp.getListConstanciasFcur2().getSelectedValue());
    }

    public void addConstanciaFcur2() {
        if (vp.getCheckBoxPonerMarca().isSelected()) {
            try {
                Constancia c = new Constancia();
                c.setTipo("cursos");
                c.setClaveC(0);
                c.setClaveNE(vp.getListBusquedaProfesorFcur2().getSelectedValue().getClaveNE());
                c.setFolio(0);
                c.setRealizada("marca");
                c.setFechaE(new Date(1988, 8, 29));
                c.setTipoP("MARCA");
                c.setEnlace("");
                c.setEntregado(new Date(1988, 8, 29));
                c.setReposicion("0");
                c.setEntrega("0");
//                c.setNombreProfesor(vp.getListBusquedaProfesorFcur2().getSelectedValue().getNombre()
//                        + " " + vp.getListBusquedaProfesorFcur2().getSelectedValue().getApellidoP()
//                        + " " + vp.getListBusquedaProfesorFcur2().getSelectedValue().getApellidoM());
                c.setNombreProfesor(vp.getListBusquedaProfesorFcur2().getSelectedValue().getApellidoP()
                        + " " + vp.getListBusquedaProfesorFcur2().getSelectedValue().getApellidoM()
                        + " " + vp.getListBusquedaProfesorFcur2().getSelectedValue().getNombre()
                );
                lmListaConstanciaProfesorFcur2.addElement(c);
            } catch (Exception e) {
            }
            return;
        }
        try {
            Constancia c = new Constancia();
            c.setTipo("cursos");
            c.setClaveC(vp.getListBusquedaCursoFcur2().getSelectedValue().getClaveC());
            c.setClaveNE(vp.getListBusquedaProfesorFcur2().getSelectedValue().getClaveNE());
            c.setFolio(Integer.parseInt(vp.getTextFieldFolioConstanciaCursofCur2().getText()));
            c.setRealizada(vp.getTextFieldRealizadafCur2().getText());
            c.setFechaE(Date.valueOf(vp.getTextFechaEfCur2().getText()));
            c.setTipoP((String) vp.getComboBoxTipoPFcur2().getSelectedItem());
            c.setEnlace(vp.getTextFieldEnlacefCur2().getText());
            c.setEntregado(Date.valueOf(vp.getTextFieldEntregadofCur2().getText()));
            c.setReposicion(vp.getTextFieldReposicionfCur2().getText());
            c.setEntrega(vp.getTextFieldEntregafCur2().getText());
//            c.setNombreProfesor(vp.getListBusquedaProfesorFcur2().getSelectedValue().getNombre()
//                    + " " + vp.getListBusquedaProfesorFcur2().getSelectedValue().getApellidoP()
//                    + " " + vp.getListBusquedaProfesorFcur2().getSelectedValue().getApellidoM());
            c.setNombreProfesor(vp.getListBusquedaProfesorFcur2().getSelectedValue().getApellidoP()
                    + " " + vp.getListBusquedaProfesorFcur2().getSelectedValue().getApellidoM()
                    + " " + vp.getListBusquedaProfesorFcur2().getSelectedValue().getNombre()
            );
            c.setNombreEvento(vp.getListBusquedaCursoFcur2().getSelectedValue().getNombreCurso());
            lmListaConstanciaProfesorFcur2.addElement(c);

        } catch (Exception e) {
            vp.getTextAreaGenerarConstancia().append(e.toString() + "\n");
        }
        vp.getLabelFcur2TotalConstancias().setText(""+lmListaConstanciaProfesorFcur2.getSize());
    }

    public void addTodasLasConstanciasFcur2() {

        for (Object c : lmListaConstanciaProfesorFcur2.toArray()) {

            try {
                qc.insertConstancia((Constancia) c);
                lmListaConstanciaProfesorFcur2.removeElement((Constancia) c);
                vp.getTextAreaGenerarConstancia().append(((Constancia) c).toString() + "--- Agregada." + "\n");
            } catch (Exception e) {
                vp.getTextAreaGenerarConstancia().append(((Constancia) c).toString() + "--- " + e.toString() + "\n");
            }

        }
    }

    public void setMarca(String marca) {
        for (Object c : lmListaConstanciaProfesorFcur2.toArray()) {

            try {
                qc.setMarca(((Constancia) c).getClaveNE(), Integer.parseInt(marca));
                lmListaConstanciaProfesorFcur2.removeElement((Constancia) c);
                vp.getTextAreaGenerarConstancia().append(((Constancia) c).getClaveNE() + "--- Marca1." + "\n");
            } catch (Exception e) {
                vp.getTextAreaGenerarConstancia().append(((Constancia) c).getClaveNE() + "--- " + e.toString() + "\n");
            }

        }

    }

    public void addMarca(String marca) {
        for (Object c : lmListaConstanciaProfesorFcur2.toArray()) {

            try {
                qc.addMarca(((Constancia) c).getClaveNE(), Integer.parseInt(marca));
                lmListaConstanciaProfesorFcur2.removeElement((Constancia) c);
                vp.getTextAreaGenerarConstancia().append(((Constancia) c).getClaveNE() + "--- Marca1." + "\n");
            } catch (Exception e) {
                vp.getTextAreaGenerarConstancia().append(((Constancia) c).getClaveNE() + "--- " + e.toString() + "\n");
            }

        }
    }

//------------------------------------------------------------------------------Fcur1     
    public void modifyCursoFcur1() {
        try {
            vp.getTextFieldFCur1ClaveC().setText(Integer.toString(vp.getListCursosFcur1().getSelectedValue().getClaveC()));
            vp.getTextFieldFCur1NombreCurso().setText(vp.getListCursosFcur1().getSelectedValue().getNombreCurso());
            vp.getTextFieldFCur1NArchivo().setText(vp.getListCursosFcur1().getSelectedValue().getnArchivo());
            vp.getTextFieldFCur1FechaI().setText(vp.getListCursosFcur1().getSelectedValue().getFechaI().toString());
            vp.getTextFieldFCur1FechaF().setText(vp.getListCursosFcur1().getSelectedValue().getFechaF().toString());

            if (vp.getListCursosFcur1().getSelectedValue().getHoras() == 20) {
                vp.getComboBoxFCur1Horas().setSelectedIndex(0);
            } else {
                vp.getComboBoxFCur1Horas().setSelectedIndex(1);
            }
            vp.getTextFieldFCur1FolioOficio().setText(Integer.toString(vp.getListCursosFcur1().getSelectedValue().getFolioOficio()));
            vp.getTextFieldFCur1Obsx().setText(vp.getListCursosFcur1().getSelectedValue().getObsx());
            if (vp.getListCursosFcur1().getSelectedValue().getTurno().equals("M")) {
                vp.getComboBoxFCur1Turno().setSelectedIndex(0);
            } else {
                vp.getComboBoxFCur1Turno().setSelectedIndex(1);
            }

            vp.getComboBoxFCur1Sede().setSelectedIndex(indexSede(vp.getListCursosFcur1().getSelectedValue().getSede()));

            lmCurso.removeElement(vp.getListCursosFcur1().getSelectedValue());
        } catch (Exception e) {
            vp.getTextAreaGenerarCurso().append("Err Modif Incompleto. " + e.toString() + "\n");
        }

    }

    public void addCursoFcur1() {

        try {
            Curso c = new Curso();
            c.setClaveC(Integer.parseInt(vp.getTextFieldFCur1ClaveC().getText()));
            c.setNombreCurso(vp.getTextFieldFCur1NombreCurso().getText());
            c.setnArchivo(vp.getTextFieldFCur1NArchivo().getText());
            c.setFechaI(Date.valueOf(vp.getTextFieldFCur1FechaI().getText()));
            c.setFechaF(Date.valueOf(vp.getTextFieldFCur1FechaF().getText()));
            c.setHoras(Integer.parseInt((vp.getComboBoxFCur1Horas().getSelectedItem().toString()).split(",")[0]));
            c.setFolioOficio(Integer.parseInt(vp.getTextFieldFCur1FolioOficio().getText()));
            c.setObsx(vp.getTextFieldFCur1Obsx().getText());
            c.setTurno((vp.getComboBoxFCur1Turno().getSelectedItem().toString()).split(",")[0]);
            c.setSede(((Adscripcion) vp.getComboBoxFCur1Sede().getSelectedItem()).getAdscr());
            lmCurso.addElement(c);

//            vp.getTextFieldFCur1ClaveC().setText("0");
            vp.getTextFieldFCur1NombreCurso().setText("");
//            vp.getTextFieldFCur1FechaI().setText("2019-MM-DD");
//            vp.getTextFieldFCur1FechaF().setText("2019-MM-DD");
//            vp.getComboBoxFCur1Horas().setSelectedIndex(0);
//            vp.getComboBoxFCur1Turno().setSelectedIndex(0);
//            vp.getComboBoxFCur1Sede().setSelectedIndex(0);

            vp.getTextFieldFCur1NombreCurso().grabFocus();

        } catch (Exception e) {
            vp.getTextAreaGenerarCurso().append("Curso Incompleto. " + e.toString() + "\n");
        }

    }

    public void addTodosLosCursosFcur1() {

        for (Object c : lmCurso.toArray()) {

            try {
                qc.insertCurso((Curso) c);
                lmCurso.removeElement((Curso) c);
                vp.getTextAreaGenerarCurso().append(((Curso) c).toString() + "--- Agregado." + "\n");
            } catch (Exception e) {
                vp.getTextAreaGenerarCurso().append(((Curso) c).toString() + "--- " + e.toString() + "\n");
            }

        }
    }

//------------------------------------------------------------------------------FConf1
    public void addConferenciaFConf1() {
        try {
            Conferencia c = new Conferencia();
            c.setClaveCo(Integer.parseInt(vp.getTextFieldFConf1ClaveCo().getText()));
            c.setNombreConf(vp.getTextFieldFConf1NombreConf().getText());
            c.setMarcoConf(vp.getTextFieldFConf1MarcoConf().getText());
            c.setnArchivo(vp.getTextFieldFConf1NArchivo().getText());
            c.setFechaI(Date.valueOf(vp.getTextFieldFConf1FechaI().getText()));
            c.setQuees(vp.getTextFieldFConf1Quees().getText());
            c.setFolioOficio(Integer.parseInt(vp.getTextFieldFConf1Foliooficio().getText()));
            c.setConj1(vp.getTextFieldFConf1Conj1().getText());
            c.setSede(((Adscripcion) vp.getComboBoxFConf1Sede().getSelectedItem()).getAdscr());
            lmConferencia.addElement(c);

//            vp.getTextFieldFConf1ClaveCo().setText("0");
            vp.getTextFieldFConf1NombreConf().setText("");
//            vp.getTextFieldFConf1MarcoConf().setText("");
//            vp.getTextFieldFConf1NArchivo().setText("Conferencia");
//            vp.getTextFieldFConf1FechaI().setText("2019-MM-DD");
//            vp.getTextFieldFConf1Quees().setText("");
//            vp.getTextFieldFConf1Foliooficio().setText("0");
//            vp.getTextFieldFConf1Conj1().setText("");
//            vp.getComboBoxFConf1Sede().setSelectedIndex(0);

            vp.getTextFieldFConf1NombreConf().grabFocus();

        } catch (Exception e) {
            vp.getTextAreaGenerarConferencia().append("Conferencia Incompleta. " + e.toString() + "\n");
        }
    }

    public void modifyConferenciaFconf1() {
        try {
            vp.getTextFieldFConf1ClaveCo().setText(Integer.toString(vp.getListConferenciasFConf1().getSelectedValue().getClaveCo()));
            vp.getTextFieldFConf1NombreConf().setText(vp.getListConferenciasFConf1().getSelectedValue().getNombreConf());
            vp.getTextFieldFConf1MarcoConf().setText(vp.getListConferenciasFConf1().getSelectedValue().getMarcoConf());
            vp.getTextFieldFConf1NArchivo().setText(vp.getListConferenciasFConf1().getSelectedValue().getnArchivo());
            vp.getTextFieldFConf1FechaI().setText(vp.getListConferenciasFConf1().getSelectedValue().getFechaI().toString());
            vp.getTextFieldFConf1Quees().setText(vp.getListConferenciasFConf1().getSelectedValue().getQuees());
            vp.getTextFieldFConf1Foliooficio().setText(Integer.toString(vp.getListConferenciasFConf1().getSelectedValue().getFolioOficio()));
            vp.getTextFieldFConf1Conj1().setText(vp.getListConferenciasFConf1().getSelectedValue().getConj1());
            vp.getComboBoxFConf1Sede().setSelectedIndex(indexSede(vp.getListConferenciasFConf1().getSelectedValue().getSede()));

            lmConferencia.removeElement(vp.getListConferenciasFConf1().getSelectedValue());
        } catch (Exception e) {
            vp.getTextAreaGenerarConferencia().append("Err Modif Incompleta. " + e.toString() + "\n");
        }

    }

    public void addTodasLasConferenciasFConf1() {
        for (Object c : lmConferencia.toArray()) {
            try {
                qc.insertConferencia((Conferencia) c);
                lmConferencia.removeElement((Conferencia) c);
                vp.getTextAreaGenerarConferencia().append(((Conferencia) c).toString() + "--- Agregado." + "\n");
            } catch (Exception e) {
                vp.getTextAreaGenerarConferencia().append(((Conferencia) c).toString() + "--- " + e.toString() + "\n");
            }
        }
    }

//------------------------------------------------------------------------------FEvent1
    public void addEventoFEvent1() {
        try {
            Evento e = new Evento();
            e.setClaveEv(Integer.parseInt(vp.getTextFieldFEvent1ClaveEv().getText()));
            e.setNombreEv(vp.getTextFieldFEvent1NombreEv().getText());
            e.setConj1(vp.getTextFieldFEvent1Conj1().getText());
            e.setMarco(vp.getTextFieldFEvent1Marco().getText());
            e.setnArchivo(vp.getTextFieldFEvent1NArchivo().getText());
            e.setFechaI(Date.valueOf(vp.getTextFieldFEvent1FechaI().getText()));
            e.setFechaF(Date.valueOf(vp.getTextFieldFEvent1FechaF().getText()));
            e.setHoras(Integer.parseInt(vp.getTextFieldFEvent1Horas().getText()));
            e.setFolioOficio(Integer.parseInt(vp.getTextFieldFEvent1FolioOficio().getText()));
            e.setQuees(vp.getTextFieldFEvent1Quees().getText());
            e.setLlevado(vp.getTextFieldFEvent1Llevado().getText());
            e.setSede(((Adscripcion) vp.getComboBoxFEvent1Sede().getSelectedItem()).getAdscr());
            e.setObsx(vp.getTextFieldFEvent1Obsx().getText());

            lmEvento.addElement(e);

//            vp.getTextFieldFEvent1ClaveEv().setText("0");
            vp.getTextFieldFEvent1NombreEv().setText("");
//            vp.getTextFieldFEvent1Conj1().setText("");
//            // vp.getTextFieldFEvent1Marco().setText("");
//            vp.getTextFieldFEvent1NArchivo().setText("Evento");
//            //vp.getTextFieldFEvent1FechaI().setText("2019-MM-DD");
//            //vp.getTextFieldFEvent1FechaF().setText("2019-MM-DD");
//            vp.getTextFieldFEvent1Horas().setText("0");
//            vp.getTextFieldFEvent1FolioOficio().setText("0");
//            vp.getTextFieldFEvent1Quees().setText("");
//            vp.getTextFieldFEvent1Llevado().setText("");
//            vp.getComboBoxFEvent1Sede().setSelectedIndex(0);
//            vp.getTextFieldFEvent1Obsx().setText("");

            vp.getTextFieldFEvent1NombreEv().grabFocus();

        } catch (Exception e) {
            vp.getTextAreaGenerarEvento().append("Evento Incompleto. " + e.toString() + "\n");
        }
    }

    public void modifyEventoFEvent1() {
        try {
            vp.getTextFieldFEvent1ClaveEv().setText(Integer.toString(vp.getListEventosFEvent1().getSelectedValue().getClaveEv()));
            vp.getTextFieldFEvent1NombreEv().setText(vp.getListEventosFEvent1().getSelectedValue().getNombreEv());
            vp.getTextFieldFEvent1Conj1().setText(vp.getListEventosFEvent1().getSelectedValue().getConj1());
            vp.getTextFieldFEvent1Marco().setText(vp.getListEventosFEvent1().getSelectedValue().getMarco());
            vp.getTextFieldFEvent1NArchivo().setText(vp.getListEventosFEvent1().getSelectedValue().getnArchivo());
            vp.getTextFieldFEvent1FechaI().setText(vp.getListEventosFEvent1().getSelectedValue().getFechaI().toString());
            vp.getTextFieldFEvent1FechaF().setText(vp.getListEventosFEvent1().getSelectedValue().getFechaF().toString());
            vp.getTextFieldFEvent1Horas().setText(Integer.toString(vp.getListEventosFEvent1().getSelectedValue().getHoras()));
            vp.getTextFieldFEvent1FolioOficio().setText(Integer.toString(vp.getListEventosFEvent1().getSelectedValue().getFolioOficio()));
            vp.getTextFieldFEvent1Quees().setText(vp.getListEventosFEvent1().getSelectedValue().getQuees());
            vp.getTextFieldFEvent1Llevado().setText(vp.getListEventosFEvent1().getSelectedValue().getLlevado());
            vp.getComboBoxFEvent1Sede().setSelectedIndex(indexSede(vp.getListEventosFEvent1().getSelectedValue().getSede()));
            vp.getTextFieldFEvent1Obsx().setText(vp.getListEventosFEvent1().getSelectedValue().getObsx());

            lmEvento.removeElement(vp.getListEventosFEvent1().getSelectedValue());
        } catch (Exception e) {
            vp.getTextAreaGenerarEvento().append("Err Modif Incompleta. " + e.toString() + "\n");
        }

    }

    public void addTodosLosEventos() {
        for (Object ev : lmEvento.toArray()) {
            try {
                qc.insertEvento((Evento) ev);
                lmEvento.removeElement((Evento) ev);
                vp.getTextAreaGenerarEvento().append(((Evento) ev).toString() + "--- Agregado." + "\n");
            } catch (Exception e) {
                vp.getTextAreaGenerarEvento().append(((Evento) ev).toString() + "--- " + e.toString() + "\n");
            }
        }
    }

//------------------------------------------------------------------------------FMat1
    public void addMaterialFMat1() {
        try {
            Material m = new Material();
            m.setClaveM(Integer.parseInt(vp.getTextFieldFMat1ClaveM().getText()));
            m.setNombreMaterial(vp.getTextFieldFMat1NombreMaterial().getText());
            m.setnArchivo(vp.getTextFieldFMat1NArchivo().getText());
            m.setFolioOficio(Integer.parseInt(vp.getTextFieldFMat1FolioOficio().getText()));
            m.setObsx(vp.getTextFieldFMat1Obsx().getText());
            m.setFechaI(Date.valueOf(vp.getTextFieldFMat1FechaI().getText()));
            m.setFechaF(Date.valueOf(vp.getTextFieldFMat1FechaF().getText()));
            m.setSede(((Adscripcion) vp.getComboBoxFMat1Sede().getSelectedItem()).getAdscr());

            lmMaterial.addElement(m);

//            vp.getTextFieldFMat1ClaveM().setText("0");
            vp.getTextFieldFMat1NombreMaterial().setText("");
//            vp.getTextFieldFMat1NArchivo().setText("Materiales");
//            vp.getTextFieldFMat1FolioOficio().setText("0");
//            vp.getTextFieldFMat1Obsx().setText("");
//            vp.getTextFieldFMat1FechaI().setText("2019-MM-DD");
//            vp.getTextFieldFMat1FechaF().setText("2019-MM-DD");
//            vp.getComboBoxFMat1Sede().setSelectedIndex(0);
//            vp.getTextFieldFMat1NombreMaterial().grabFocus();

        } catch (Exception e) {
            vp.getTextAreaGenerarMaterial().append("Evento Incompleto. " + e.toString() + "\n");
        }
    }

    public void modifyMaterialFMat1() {
        try {
            vp.getTextFieldFMat1ClaveM().setText(Integer.toString(vp.getListMaterialesFMat1().getSelectedValue().getClaveM()));
            vp.getTextFieldFMat1NombreMaterial().setText(vp.getListMaterialesFMat1().getSelectedValue().getNombreMaterial());
            vp.getTextFieldFMat1NArchivo().setText(vp.getListMaterialesFMat1().getSelectedValue().getnArchivo());
            vp.getTextFieldFMat1FolioOficio().setText(Integer.toString(vp.getListMaterialesFMat1().getSelectedValue().getFolioOficio()));
            vp.getTextFieldFMat1Obsx().setText(vp.getListMaterialesFMat1().getSelectedValue().getObsx());
            vp.getTextFieldFMat1FechaI().setText(vp.getListMaterialesFMat1().getSelectedValue().getFechaI().toString());
            vp.getTextFieldFMat1FechaF().setText(vp.getListMaterialesFMat1().getSelectedValue().getFechaF().toString());
            vp.getComboBoxFMat1Sede().setSelectedIndex(indexSede(vp.getListMaterialesFMat1().getSelectedValue().getSede()));

            lmMaterial.removeElement(vp.getListMaterialesFMat1().getSelectedValue());
        } catch (Exception e) {
            vp.getTextAreaGenerarMaterial().append("Err Modif Incompleta. " + e.toString() + "\n");
        }
    }

    public void addTodosLosMateriales() {
        for (Object m : lmMaterial.toArray()) {
            try {
                qc.insertMaterial((Material) m);
                lmMaterial.removeElement((Material) m);
                vp.getTextAreaGenerarMaterial().append(((Material) m).toString() + "--- Agregado." + "\n");
            } catch (Exception e) {
                vp.getTextAreaGenerarMaterial().append(((Material) m).toString() + "--- " + e.toString() + "\n");
            }
        }
    }

//------------------------------------------------------------------------------FVisit1
    public void addVisitaFVisit1() {
        try {
            Visita v = new Visita();
            v.setClaveV(Integer.parseInt(vp.getTextFieldFVisit1ClaveV().getText().trim()));
            v.setNombreVisita(vp.getTextFieldFVisit1NombreVisita().getText().trim());
            v.setComplemento(vp.getTextFieldFVisit1Complemento().getText().trim());
            v.setnArchivo(vp.getTextFieldFVisit1NArchivo().getText().trim());
            v.setQuees(vp.getTextFieldFVisit1Quees().getText().trim());
            v.setFolioOficio(Integer.parseInt(vp.getTextFieldFVisit1Foliooficio().getText().trim()));
            v.setFechaI(Date.valueOf(vp.getTextFieldFVisit1FechaI().getText().trim()));
            v.setFechaF(Date.valueOf(vp.getTextFieldFVisit1FechaF().getText().trim()));
            v.setSede(((Adscripcion) vp.getComboBoxFVisit1Sede().getSelectedItem()).getAdscr());

            lmVisita.addElement(v);

//            vp.getTextFieldFVisit1ClaveV().setText("0");
            vp.getTextFieldFVisit1NombreVisita().setText("");
//            vp.getTextFieldFVisit1Complemento().setText("");
//            vp.getTextFieldFVisit1NArchivo().setText("Visita");
//            vp.getTextFieldFVisit1Quees().setText("");
//            vp.getTextFieldFVisit1Foliooficio().setText("0");
//            vp.getTextFieldFVisit1FechaI().setText("2019-MM-DD");
//            vp.getTextFieldFVisit1FechaF().setText("2019-MM-DD");
//            vp.getComboBoxFVisit1Sede().setSelectedIndex(0);

            vp.getTextFieldFVisit1NombreVisita().grabFocus();

        } catch (Exception e) {
            vp.getTextAreaGenerarVisita().append("Evento Incompleto. " + e.toString() + "\n");
        }
    }

    public void modifyVisitaFVisit1() {
        try {
            vp.getTextFieldFVisit1ClaveV().setText(Integer.toString(vp.getListVisitasFVisit1().getSelectedValue().getClaveV()));
            vp.getTextFieldFVisit1NombreVisita().setText(vp.getListVisitasFVisit1().getSelectedValue().getNombreVisita());
            vp.getTextFieldFVisit1Complemento().setText(vp.getListVisitasFVisit1().getSelectedValue().getComplemento());
            vp.getTextFieldFVisit1NArchivo().setText(vp.getListVisitasFVisit1().getSelectedValue().getnArchivo());
            vp.getTextFieldFVisit1Quees().setText(vp.getListVisitasFVisit1().getSelectedValue().getQuees());
            vp.getTextFieldFVisit1Foliooficio().setText(Integer.toString(vp.getListVisitasFVisit1().getSelectedValue().getFolioOficio()));
            vp.getTextFieldFVisit1FechaI().setText(vp.getListVisitasFVisit1().getSelectedValue().getFechaI().toString());
            vp.getTextFieldFVisit1FechaF().setText(vp.getListVisitasFVisit1().getSelectedValue().getFechaF().toString());
            vp.getComboBoxFVisit1Sede().setSelectedIndex(indexSede(vp.getListVisitasFVisit1().getSelectedValue().getSede()));

            lmVisita.removeElement(vp.getListVisitasFVisit1().getSelectedValue());
        } catch (Exception e) {
            vp.getTextAreaGenerarVisita().append("Err Modif Incompleta. " + e.toString() + "\n");
        }
    }

    public void addTodasLasVisitas() {
        for (Object v : lmVisita.toArray()) {
            try {
                qc.insertVisita((Visita) v);
                lmVisita.removeElement((Visita) v);
                vp.getTextAreaGenerarVisita().append(((Visita) v).toString() + "--- Agregado." + "\n");
            } catch (Exception e) {
                vp.getTextAreaGenerarVisita().append(((Visita) v).toString() + "--- " + e.toString() + "\n");
            }
        }
    }

//------------------------------------------------------------------------------FInfo1
    public void addInfocabFInfo1() {
        try {
            Infocab I = new Infocab();
            I.setClaveI(Integer.parseInt(vp.getTextFieldFInfo1ClaveI().getText().trim()));
            I.setnArchivo(vp.getTextFieldFInfo1NArchivo().getText().trim());
            I.setFechaI(Date.valueOf(vp.getTextFieldFInfo1FechaI().getText().trim()));
            I.setFechaF(Date.valueOf(vp.getTextFieldFInfo1FechaF().getText().trim()));
            I.setHoras(Integer.parseInt(vp.getTextFieldFInfo1Horas().getText().trim()));
            I.setFolioOficio(Integer.parseInt(vp.getTextFieldFInfo1FolioOficio().getText().trim()));
            I.setNombreProyecto(vp.getTextFieldFInfo1NombreProyecto().getText().trim());
            I.setObsx(vp.getTextFieldFInfo1Obsx().getText().trim());
            I.setSede(((Adscripcion) vp.getComboBoxFInfo1Sede().getSelectedItem()).getAdscr());

            lmInfocab.addElement(I);

//            vp.getTextFieldFInfo1ClaveI().setText("0");
            vp.getTextFieldFInfo1NArchivo().setText("Infocab");
//            vp.getTextFieldFInfo1FechaI().setText("2019-MM-DD");
//            vp.getTextFieldFInfo1FechaF().setText("2019-MM-DD");
//            vp.getTextFieldFInfo1Horas().setText("0");
//            vp.getTextFieldFInfo1FolioOficio().setText("0");
//            vp.getTextFieldFInfo1NombreProyecto().setText("");
//            vp.getTextFieldFInfo1Obsx().setText("");
//            vp.getComboBoxFInfo1Sede().setSelectedIndex(0);

            vp.getTextFieldFInfo1NombreProyecto().grabFocus();

        } catch (Exception e) {
            vp.getTextAreaGenerarInfocab().append("Infocab Incompleto. " + e.toString() + "\n");
        }
    }

    public void modifyInfocabFInfo1() {
        try {
            vp.getTextFieldFVisit1ClaveV().setText(Integer.toString(vp.getListVisitasFVisit1().getSelectedValue().getClaveV()));
            vp.getTextFieldFVisit1NombreVisita().setText(vp.getListVisitasFVisit1().getSelectedValue().getNombreVisita());
            vp.getTextFieldFVisit1Complemento().setText(vp.getListVisitasFVisit1().getSelectedValue().getComplemento());
            vp.getTextFieldFVisit1NArchivo().setText(vp.getListVisitasFVisit1().getSelectedValue().getnArchivo());
            vp.getTextFieldFVisit1Quees().setText(vp.getListVisitasFVisit1().getSelectedValue().getQuees());
            vp.getTextFieldFVisit1Foliooficio().setText(Integer.toString(vp.getListVisitasFVisit1().getSelectedValue().getFolioOficio()));
            vp.getTextFieldFVisit1FechaI().setText(vp.getListVisitasFVisit1().getSelectedValue().getFechaI().toString());
            vp.getTextFieldFVisit1FechaF().setText(vp.getListVisitasFVisit1().getSelectedValue().getFechaF().toString());
            vp.getComboBoxFVisit1Sede().setSelectedIndex(indexSede(vp.getListVisitasFVisit1().getSelectedValue().getSede()));

            lmVisita.removeElement(vp.getListVisitasFVisit1().getSelectedValue());
        } catch (Exception e) {
            vp.getTextAreaGenerarVisita().append("Err Modif Incompleta. " + e.toString() + "\n");
        }
    }

    public void addTodosLosInfocab() {
        for (Object v : lmVisita.toArray()) {
            try {
                qc.insertVisita((Visita) v);
                lmVisita.removeElement((Visita) v);
                vp.getTextAreaGenerarVisita().append(((Visita) v).toString() + "--- Agregado." + "\n");
            } catch (Exception e) {
                vp.getTextAreaGenerarVisita().append(((Visita) v).toString() + "--- " + e.toString() + "\n");
            }
        }
    }

    //Getters & Setters:
    public VistaPrincipalHandler getVp() {
        return vp;
    }

    public QueryCollection getQc() {
        return qc;
    }

    public DefaultListModel<Curso> getLmCurso() {
        return lmCurso;
    }

    public DefaultListModel<Conferencia> getLmConferencia() {
        return lmConferencia;
    }

    public DefaultListModel<Curso> getLmBusquedaCursoFcur2() {
        return lmBusquedaCursoFcur2;
    }

    public DefaultListModel<Profesor> getLmBusquedaProfesorFcur2() {
        return lmBusquedaProfesorFcur2;
    }

    public DefaultListModel<Profesor> getLmBusquedaProfesorFConsG() {
        return lmBusquedaProfesorFConsG;
    }

    public DefaultListModel<Constancia> getLmListaConstanciaProfesorFcur2() {
        return lmListaConstanciaProfesorFcur2;
    }

    public DefaultListModel<Object> getLmBusquedaEventoFConsG() {
        return lmBusquedaEventoFConsG;
    }

}
