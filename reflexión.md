# Práctica: Pruebas unitarias con JaCoCo y GitHub Actions

##Entregables
Vídeo explicativo: https://drive.google.com/file/d/1C0n-tZmS6fNGVGUjiHPuihpnOTgK-Rwu/view?usp=sharing

Reflexión escrita sobre:

Dificultades técnicas.
Una de las principales dificultades fue entender bien los reportes de JaCoCo, ya que al inicio pensaba que mientras la línea estuviera en verde ya estaba probada, pero el reporte me 
mostraba mensajes como “3 of 8 branches missed” o decisiones no cubiertas. Tuve que aprender la diferencia entre cobertura de líneas y cobertura de ramas, y ver cómo el corto 
circuito de los operadores lógicos (|| y &&) hacía que algunas condiciones nunca se evaluaran. Otra dificultad fue la configuración del pipeline en GitHub Actions, porque al principio 
el workflow falló por la versión de Java y, porque no coincidía lo que tenía en mi máquina con lo que ponía en setup-java, pero una vez entendido, el flujo quedó estable, 
pero la primera vez fue prueba y error.

Riesgos de baja cobertura.
Con este trabajo me quedó claro que una cobertura baja es una señal de riesgo, ya que muchas ramas no se ejecutan en los tests, significa que hay validaciones y excepciones que nadie 
está cubriendo. En el caso de la contraseña, por ejemplo, sin pruebas para longitudes extremas o caracteres no permitidos, el sistema podría aceptar claves débiles o mal formadas 
sin que nos demos cuenta. Otro riesgo es que con pocos tests se genera una falsa sensación de seguridad. El código compila, funciona y se asume que todo está bien, 
pero cualquier cambio interno puede romper una rama no probada y el error recién se ve en producción. Eso suele ser más caro de corregir y puede impactar directamente al usuario final.
Además, con baja cobertura es muy difícil hacer refactorizaciones seguras

Beneficios de CI/CD.
El principal beneficio de usar CI/CD con GitHub Actions es que las pruebas dejan de depender de que yo me acuerde de ejecutarlas. Cada git push dispara automáticamente el pipeline, 
compila el proyecto, ejecuta los tests y genera el reporte de JaCoCo. Esto evita el típico “en mi máquina sí funcionaba” y asegura que el código en el repositorio siempre está validado. 
Además, otro beneficio es que se genera un historial de ejecuciones y de cobertura. En la pestaña de Actions puedo ver el estado inicial y comparar con el estado final después de 
añadir pruebas. Finalmente, CI/CD facilita escalar el proceso. En esta práctica solo corro tests y cobertura, pero el mismo pipeline podría ampliarse con más pasos
análisis estático, empaquetado, despliegue a un entorno de pruebas, etc. Tener ese flujo automatizado desde ahora ayuda a acostumbrarse a una forma de trabajo más profesional y repetible.
