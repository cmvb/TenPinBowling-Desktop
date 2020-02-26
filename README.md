# TenPinBowling-Desktop
Author: Carlos Baene - Bogotá, Colombia (2020)

# Información y características

Esta aplicación está orientada a la línea de comandos. Uso de JDK V8. Los archivos permitidos para cargar deben ser de extensión (.txt).

# Requerimientos previos

1. Dentro del proyecto hay archivos de prueba en la ruta: '.../src/test/Test Files'

# Instrucciones de ejecución y despliegue

1. Bajar las dependencias maven que se encuentran en el archivo: pom.xml.

1.1. Tutoriales para usar comandos mvn: https://www.vogella.com/tutorials/ApacheMaven/article.html <-> https://metamug.com/article/build-run-java-maven-project-command-line.html

1.2. Abrir la consola cmd en modo Administrador vaya a la carpeta raiz del proyecto con el comando 'cd' -> Carpeta donde se encuentra el archivo 'pom.xml'.

1.2.1. Si desea limpiar el proyecto y bajar dependencias escriba este comando: mvn clean install

1.2.2. Para compilar y generar la carpeta 'target' escriba este comando: mvn compile

1.2.3. Para ejecutar el proyecto escriba este comando: mvn exec:java -Dexec.mainClass=tenpinbowlingdeskapp.TenPinBowlingApp

1.2.4. Para ejecutar el proyecto sin necesidad de digitar la ruta del archivo escriba este comando: mvn exec:java -Dexec.mainClass=tenpinbowlingdeskapp.TenPinBowlingApp -Dexec.args="rutaArchivo"

1.2.5. Tenga en cuenta que la ruta no debería contener ningún espacio en blanco para usar este comando. Solo permite un parámetro a la vez.

5. Al ejecutar la aplicación si no se ha proporcionado la ruta del archivo de lectura, el sistema le pedirá que escriba en la consola para procesarlo.

5.1. Escoger el archivo deseado. Si escoge otra extensión, el sistema validará y mostrará un mensaje en consola.

5.3. Se procesa el archivo y si todo sale bien se verá en pantalla el cuadro de puntajes del juego Ten Pin-Bowling. Por otro lado, si algo está mal en la estructura o contenido del archivo, el sistema validará y mostrará un mensaje en consola
