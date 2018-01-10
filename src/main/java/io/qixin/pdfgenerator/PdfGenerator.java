package io.qixin.pdfgenerator;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.css.media.MediaDeviceDescription;
import com.itextpdf.html2pdf.css.media.MediaType;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

/**
 * Pdf-html 转换
 */
public class PdfGenerator {
    public static Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    public static final String FONT_PATH = "src/main/resources/fonts";
    /**
     * html -> pdf
     * @param htmlStr html string.
     * @param os output stream, for example: HttpServletResponse.
     * @param pageSize print page size.
     * @throws IOException
     */
    public static void generatePdfWithHtml(String htmlStr, OutputStream os, PageSize pageSize) throws IOException {
        PdfWriter writer = new PdfWriter(os);
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.setDefaultPageSize(pageSize);
        // Set media device description details
        MediaDeviceDescription mediaDeviceDescription = new MediaDeviceDescription(MediaType.SCREEN);
        mediaDeviceDescription.setWidth(pageSize.getWidth());

        ConverterProperties properties = new ConverterProperties();
        properties.setMediaDeviceDescription(mediaDeviceDescription);

        FontProvider fontProvider = new DefaultFontProvider();
        fontProvider.addDirectory(FONT_PATH); // 解决中文不显示问题
        properties.setFontProvider(fontProvider);
        //Create acroforms from text and button input fields
        properties.setCreateAcroForm(true);
        HtmlConverter.convertToPdf(htmlStr,pdfDoc, properties);
        pdfDoc.close();
    }

    /**
     * freemarker template -> html string.
     * @param param Object param
     * @param ftlFilePath freemarker template file path. example: "src/main/resources/templates/hello.ftl"
     * @return html string.
     * @throws IOException
     * @throws TemplateException
     */
    public static String generateStringFromFtl(Object param,String ftlFilePath) throws IOException, TemplateException {
        configuration.setDefaultEncoding("UTF-8");
        Template template = configuration.getTemplate(ftlFilePath);

        StringWriter stringWriter = new StringWriter();
        template.process(param,stringWriter);
        String htmlStr = stringWriter.toString();
        stringWriter.flush();
        stringWriter.close();
        return htmlStr;
    }
}
