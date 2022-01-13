package control;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modelo.QueryCollection;
import modelo.ResultSetConstanciaGeneral;
import modelo.ResultSetContanciaCursos;
import modelo.ResultsetListado;
import mapeo.Listado;
import vista.VentanaPDF;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
//import org.icepdf.ri.common.MyAnnotationCallback;
//import org.icepdf.ri.common.SwingController;
//import org.icepdf.ri.common.SwingViewBuilder;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class ReportesManager {
    //Atributos:

    QueryCollection qc;

    //Constructores:
    public ReportesManager(QueryCollection qc) {
        this.qc = qc;
        System.out.println("RP creada");
    }
    //Métodos:

    public void generarConstanciasCursos(int ClaveConstancia, String plantilla) throws SQLException, ClassNotFoundException, JRException {
        LinkedList<ResultSetContanciaCursos> lista = qc.constanciasCursos(ClaveConstancia);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("libs\\" + plantilla));
        JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
        JasperViewer.viewReport(mostrarReporte, false);
    }

    public void generarConstanciasCursosPorListado(int folioListado, String plantilla) throws SQLException, ClassNotFoundException, JRException {
        LinkedList<ResultSetContanciaCursos> lista = qc.constanciasCursosPorListado(folioListado);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("lib/" + plantilla));
        JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
        JasperViewer.viewReport(mostrarReporte, false);
    }

    public void generarConstanciasGenerales(int folioInicio, int folioFin, String plantilla) throws SQLException, ClassNotFoundException, UnsupportedOperationException, JRException {
        LinkedList<ResultSetConstanciaGeneral> lista = qc.constanciasGenerales(folioInicio, folioFin);       
        JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("libs\\" + plantilla));
        JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
        JasperViewer.viewReport(mostrarReporte, false);
    }

    public void generarConstanciasGeneralesPorListado(int folioListado, String plantilla) throws SQLException, ClassNotFoundException, JRException {
        LinkedList<ResultSetConstanciaGeneral> lista = qc.constanciasGeneralesPorListado(folioListado); //corregir vlv
        JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("lib/" + plantilla));
        JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
        JasperViewer.viewReport(mostrarReporte, false);
    }

    public void generarListado(Listado l) throws SQLException, ClassNotFoundException, JRException {
        File f;
        HashMap<String, Object> map = new HashMap<>();
        map.put("listadoDesc", l.getDesc());
        map.put("listadoNumero", l.getNumero());
        map.put("listadoFecha", l.getFecha());

        LinkedList<ResultsetListado> lista = qc.selectListado(l.getNumero());

        for (ResultsetListado r : lista) {
            f = new File("lib\\fotos\\" + r.getClaveProfesor() + ".jpg");
            if (f.exists() && !f.isDirectory()) {
                r.setCredencial(r.getClaveProfesor());
            } else {
                r.setCredencial(1);
            }
        }
        JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("lib/Listado.jasper"));
        JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, map, new JRBeanCollectionDataSource(lista));
        JasperViewer.viewReport(mostrarReporte, false);
    }

        void abrirAcuse(int folio) {
//        String ruta = "ConstanciasEscaneadas/";
//        
//        SwingController controller = new SwingController();
//        SwingViewBuilder factory = new SwingViewBuilder(controller);
//        JPanel viewerComponentPanel = factory.buildViewerPanel();
//        viewerComponentPanel.setSize(850, 800);
//        controller.getDocumentViewController().setAnnotationCallback(new MyAnnotationCallback(controller.getDocumentViewController()));
//           
//        VentanaPDF ventanaPDF =new VentanaPDF();
//        ventanaPDF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        ventanaPDF.add(viewerComponentPanel);
//        controller.openDocument(ruta+folio+".pdf");
//        
//        ventanaPDF.pack();
//        ventanaPDF.setVisible(true);
    }
          
        
    // en des uso:
    public void generarConstanciasGeneralesSecretarioGeneral(int folioInicio, int folioFin) throws SQLException, ClassNotFoundException, UnsupportedOperationException, JRException {
        LinkedList<ResultSetConstanciaGeneral> lista = qc.constanciasGenerales(folioInicio, folioFin);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("lib/SGeneral.jasper"));
        JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
        JasperViewer.viewReport(mostrarReporte, false);
    }

    public void generarReconocimientosGenerales(int folioInicio, int folioFin) throws SQLException, ClassNotFoundException, UnsupportedOperationException, JRException {
        LinkedList<ResultSetConstanciaGeneral> lista = qc.constanciasGenerales(folioInicio, folioFin);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("lib/ReconocimientoGeneral.jasper"));
        JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
        JasperViewer.viewReport(mostrarReporte, false);
    }

    public void generarReconocimientosGeneralesSecretarioGeneral(int folioInicio, int folioFin) throws SQLException, ClassNotFoundException, UnsupportedOperationException, JRException {
        LinkedList<ResultSetConstanciaGeneral> lista = qc.constanciasGenerales(folioInicio, folioFin);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("lib/ReconocimientoSGeneral.jasper"));
        JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(lista));
        JasperViewer.viewReport(mostrarReporte, false);
    }

    //Getters & Setters:
}
