支持中文转换，使用之前将字体文件放入`/resources/fonts`目录下.

# Usage

gradle:

```
respositories {
    ...
    maven { url 'https://jitpack.io' }
}

ext {
    pdfGeneratorVersion = '1.0.0'
}

dependencies {
    ...
    compile 'com.github.qixin1991:pdf-generator:${pdfGeneratorVersion}'
}
```

iText dependencies:

```
compile 'com.itextpdf:kernel:7.1.0'
compile 'com.itextpdf:io:7.1.0'
compile 'com.itextpdf:layout:7.1.0'
compile 'com.itextpdf:forms:7.1.0'
compile 'com.itextpdf:pdfa:7.1.0'
compile 'com.itextpdf:barcodes:7.1.0'
compile 'com.itextpdf:hyph:7.1.0'
compile 'com.itextpdf:barcodes:7.1.0'
compile 'com.itextpdf:font-asian:7.1.0'
compile 'com.itextpdf:html2pdf:2.0.0'
```