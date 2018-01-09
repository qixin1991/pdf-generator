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