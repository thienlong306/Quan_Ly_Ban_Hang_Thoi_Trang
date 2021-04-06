package BLL;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import UTILS.ConnectionUtil;

import java.sql.*;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

public class Report {

	public void rphd() throws IOException, JRException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String reportSrcFile = "Blank_A4_Landscape.jrxml";
	       
	       // Compile file nguồn trước.
	       JasperReport jasperReport =    JasperCompileManager.compileReport(reportSrcFile);
	 
	       ConnectionUtil conUtil = new ConnectionUtil();
			Connection conn = conUtil.getConnection();
	 
	       // Tham số truyền vào báo cáo.
	       Map<String, Object> parameters = new HashMap<String, Object>();
	 
	       JasperPrint print = JasperFillManager.fillReport(jasperReport,
	               parameters, conn);
	       //
	     
			
	       // Đảm bảo thư mục đầu ra tồn tại.
	       File outDir = new File("jasperoutput");
	       outDir.mkdirs();
	 
	       // PDF Exportor.
	       JRPdfExporter exporter = new JRPdfExporter();
	    
	 
	       ExporterInput exporterInput = new SimpleExporterInput(print);
	       // ExporterInput
	       
	       exporter.setExporterInput(exporterInput);
	 
	       // ExporterOutput
	       OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
	               "jasperoutput/HoaDon.pdf");
	       // Output
	       exporter.setExporterOutput(exporterOutput);
	       
	       //
	       SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
	       exporter.setConfiguration(configuration);
	       
	       exporter.exportReport();
	       
	       
	       System.out.print("Done!");
	}

}
