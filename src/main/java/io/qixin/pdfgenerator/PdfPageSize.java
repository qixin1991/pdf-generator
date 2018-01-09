package io.qixin.pdfgenerator;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;

import java.io.Serializable;

public class PdfPageSize extends PageSize {
    public PdfPageSize(float width, float height) {
        super(width, height);
    }

    public PdfPageSize(Rectangle box) {
        super(box);
    }
}
