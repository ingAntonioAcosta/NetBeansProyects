package control;

import mapeo.Constancia;
import mapeo.Curso;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import modelo.QueryCollection;
import mapeo.Area;
import mapeo.Asistente;
import mapeo.Profesor;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class TablasManager {
    //Atributos:

    QueryCollection qc;
    VistaPrincipalHandler vp;

    //Constructores:
    public TablasManager(QueryCollection qc, VistaPrincipalHandler vp) {
        this.qc = qc;
        this.vp = vp;
        System.out.println("tm creada");
    }

    //Métodos:
    public void cargarTablaConstancias() throws SQLException, ClassNotFoundException {
        llenarTablaConstancias(vp.getTableConstancias());
    }

    public void cargarTablaCursos() throws SQLException, ClassNotFoundException {
        llenarTablaCursos(vp.getTableCursos());
    }

    public void vaciarTabla(JTable tabla) {

        tabla.setModel(new DefaultTableModel());

    }
    // prueba para la tabla de asistentes a los cursos

    public void cargarTablaAsistentesCursos() throws SQLException, ClassNotFoundException {
        llenarTablaAsistentesCursos((int) vp.getTableCursos().getValueAt(vp.getTableCursos().getSelectedRow(), 0), vp.getTableAsistentesCursos());
    }

    public void llenarTablaConstancias(JTable tableConstancias) throws SQLException, ClassNotFoundException {

        String folioI = vp.getTextFieldBusquedaConstanciasFolioI().getText().trim(); //folios
        String folioF = vp.getTextFieldBusquedaConstanciasFolioF().getText().trim();
        int area = ((Area) vp.getComboBoxBusquedaConstanciasArea().getSelectedItem()).getArea();
        String tipo = ((String) vp.getComboBoxBusquedaConstanciasTipo().getSelectedItem()).trim(); //tipo
        String fechaI = vp.getTextFieldBusquedaConstanciasFechaI().getText().trim(); //fechas
        String fechaF = vp.getTextFieldBusquedaConstanciasFechaF().getText().trim();
        String tipoP = vp.getTextFieldBusquedaConstanciasTipoP().getText().trim(); //tipoP
        String claveNE = "";
        if (vp.getComboBoxBusquedaConstanciasProfesor().getItemCount() > 0) {

            if (vp.getComboBoxBusquedaConstanciasProfesor().getSelectedIndex() > -1) {
                claveNE = Integer.toString(((Profesor) vp.getComboBoxBusquedaConstanciasProfesor().getSelectedItem()).getClaveNE()); //ClaveNE
            } else {
                claveNE = Integer.toString(((Profesor) vp.getComboBoxBusquedaConstanciasProfesor().getItemAt(0)).getClaveNE()); //ClaveNE
            }
        }
        String claveC = vp.getTextFieldBusquedaConstanciasEvento().getText().trim(); //ClaveC
        
        HashMap map = qc.selectConstanciasConFiltros(
                folioI, folioF, area, tipo, fechaI, fechaF, tipoP, claveNE, claveC
        );
        
        String[] columnNames = {
            "Tipo",
            "ClaveC",
            "Evento",//Adicional a la contancia
            "ClaveNE",
            "Profesor",//Adicional a la contancia
            "Folio",
            "Realizada",
            "FechaE",
            "TipoP",
            "Enlace",
            "Entregado",
            "Reposicion",
            "Entrega"
        };
        llenarTabla(tableConstancias, map, columnNames, "Constancia");
        vp.getLogGestionarConstancias().append(map.size() + " Constancias Encontradas \n");
    }

    public void llenarTablaCursos(JTable tableCursos) throws SQLException, ClassNotFoundException {
        HashMap map = qc.selectAllCursos();
        String[] columnNames = {
            "ClaveC",
            "NombreCurso",
            "NArchivo",
            "FechaI",
            "FechaF",
            "Horas",
            "FolioOficio",
            "Obsx",
            "Turno",
            "Sede"
        };
        llenarTabla(tableCursos, map, columnNames, "Curso");
    }

    private void llenarTablaAsistentesCursos(int ClaveC, JTable tableAsistentesCursos) throws SQLException, ClassNotFoundException {

        HashMap map = qc.selectAsistentesPorCurso(ClaveC);
        String[] columnNames = {
            "Folio",
            "FechaE",
            "Entregado",
            "Reposicion",
            "Entrega",
            "Email",
            "ClaveNE",
            "RFC",
            "Nombre",
            "ApellidoP",
            "ApellidoM",
            "TipoP"
        };
        llenarTabla(tableAsistentesCursos, map, columnNames, "AsistentesCursos");
    }

    public void buscar(String busqueda, String tipo) {

        switch (tipo) {

            case "profesor":

                break;
            case "asesoria":
                break;
            case "concurso":
                break;
            case "conferencia":
                break;
            case "constancia":
                break;
            case "curso":

                if (busqueda.equals("") || busqueda.length() < 3) {

                } else {
                    try {
                        HashMap map = qc.selectAllCursosPorNombreMAP(busqueda);
                        if (busqueda.charAt(0) == '2') {
                            map = qc.selectAllCursosPorFechaMAP(busqueda);
                            String[] columnNames = {
                                "ClaveC",
                                "NombreCurso",
                                "NArchivo",
                                "FechaI",
                                "FechaF",
                                "Horas",
                                "FolioOficio",
                                "Obsx",
                                "Turno",
                                "Sede"
                            };
                            llenarTabla(vp.getTableCursos(), map, columnNames, "Curso");
                        } else {
                            String[] columnNames = {
                                "ClaveC",
                                "NombreCurso",
                                "NArchivo",
                                "FechaI",
                                "FechaF",
                                "Horas",
                                "FolioOficio",
                                "Obsx",
                                "Turno",
                                "Sede"
                            };
                            llenarTabla(vp.getTableCursos(), map, columnNames, "Curso");
                        }
                    } catch (Exception e) {
                    }
                }
                break;

            case "diplomado":
                break;
            case "evento":
                break;
            case "seminario":
                break;
            case "taller":
                break;
            case "visita":
                break;

        }

    }

    private void llenarTabla(javax.swing.JTable table, HashMap mapa, String[] columnNames, String tipo) {

        table.setModel(new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return mapa.size();
            }

            @Override
            public int getColumnCount() {
                return columnNames.length;
            }

            @Override
            public String getColumnName(int col) {
                return columnNames[col];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getTipo();
                        }
                        if (tipo.equals("Curso")) {
                            return ((Curso) mapa.get(rowIndex)).getClaveC();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getFolio();
                        }

                    case 1:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getClaveC();
                        }
                        if (tipo.equals("Curso")) {
                            return ((Curso) mapa.get(rowIndex)).getNombreCurso();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getFechaE();
                        }

                    case 2:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getNombreEvento();
                        }
                        if (tipo.equals("Curso")) {
                            return ((Curso) mapa.get(rowIndex)).getnArchivo();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getEntregado();
                        }

                    case 3:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getClaveNE();
                        }
                        if (tipo.equals("Curso")) {
                            return ((Curso) mapa.get(rowIndex)).getFechaI();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getReposicion();
                        }

                    case 4:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getNombreProfesor();
                        }
                        if (tipo.equals("Curso")) {
                            return ((Curso) mapa.get(rowIndex)).getFechaF();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getEntrega();
                        }

                    case 5:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getFolio();
                        }
                        if (tipo.equals("Curso")) {
                            return ((Curso) mapa.get(rowIndex)).getHoras();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getEmail();
                        }

                    case 6:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getRealizada();
                        }
                        if (tipo.equals("Curso")) {
                            return ((Curso) mapa.get(rowIndex)).getFolioOficio();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getClaveNE();
                        }

                    case 7:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getFechaE();
                        }
                        if (tipo.equals("Curso")) {
                            return ((Curso) mapa.get(rowIndex)).getObsx();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getRfc();
                        }

                    case 8:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getTipoP();
                        }
                        if (tipo.equals("Curso")) {
                            return ((Curso) mapa.get(rowIndex)).getTurno();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getNombre();
                        }

                    case 9:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getEnlace();
                        }
                        if (tipo.equals("Curso")) {
                            return ((Curso) mapa.get(rowIndex)).getSede();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getApellidoP();
                        }

                    case 10:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getEntregado();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getApellidoM();
                        }
                    case 11:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getReposicion();
                        }
                        if (tipo.equals("AsistentesCursos")) {
                            return ((Asistente) mapa.get(rowIndex)).getTipoP();
                        }
                    case 12:
                        if (tipo.equals("Constancia")) {
                            return ((Constancia) mapa.get(rowIndex)).getEntrega();
                        }

                    default:
                        return "ERROR";
                }
            }
        });
    }

    //Getters & Setters:
}
