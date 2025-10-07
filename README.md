** Ejecución de pruebas

* Requerimientos de entorno
- Instalar android studio, (Versión Narwhal 3)
- Instalar npm, (versión 11.6.0)
- Instalar appium instalado, (versión 3.0.2)
  - Instalar el driver uiautomator2
- Instalar Node.js, (versión v22.19.0)
- Instalar java (versión 21.0.6)

* Deoendencias
- Slf4j => Slf4j-api: Es una api de abstracción de login, permite utilizar la api, sin depender de una implementación específica
- log4j => log4j-slf4j2-impl: conector entre SLF4J y Log4j 2 // log4j-core: Contiene toda la lógica para procesar, formatear y escribir logs (a consola, archivos, etc.) // log4j-api utliza implementciones propias del api
- selenium => selenium-java: Herramienta para simular acciones humnas, como clic, escribir, arrastrar etc. 
- appuim => java-client: librería oficial para poder automatizar aplicativos de escritorio, web y móvil en appium
- testNg => testNg: framework para automamtizar pruebas de softwrare

* Logs de ejecución:
10:11:42.643 [main] DEBUG com.mobile.drivers.PlatformDriver - Identificando ventana emergente de inicio de sesión con google
10:12:03.862 [main] WARN  com.mobile.drivers.PlatformDriver - El elemento no ha sido encontrado ya que actualmente no se visible en la página
10:12:03.862 [main] DEBUG com.mobile.drivers.PlatformDriver - Identificando coordenadas de ventana emergente de inicio de sesión con google
10:12:08.503 [main] INFO  com.mobile.drivers.PlatformDriver - Se dado clic en el link correspondiente de acuerdo a las coordenadas ingresadas
10:12:08.503 [main] DEBUG com.mobile.drivers.PlatformDriver - Identificado objeto para ingresar el usuario o correo
10:12:12.803 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha ingresado el texto correspondiente
10:12:12.803 [main] DEBUG com.mobile.drivers.PlatformDriver - Identificado botón 'next'
10:12:16.862 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha dado clic en el botón correspondiente
10:12:16.863 [main] DEBUG com.mobile.drivers.PlatformDriver - Identificado objeto para ingresar el usuario o correo
10:12:21.129 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha ingresado el texto correspondiente
10:12:21.130 [main] DEBUG com.mobile.drivers.PlatformDriver - Identificado botón 'next'
10:12:25.775 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha dado clic en el botón correspondiente
10:12:25.775 [main] DEBUG com.mobile.drivers.PlatformDriver - Identificado objeto para ingresar contrasenia
10:12:30.012 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha ingresado el texto correspondiente
10:12:30.013 [main] DEBUG com.mobile.drivers.PlatformDriver - Identificado botón para finalizar el login
10:12:34.790 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha dado clic en el botón correspondiente
10:12:34.790 [main] DEBUG com.mobile.Pages.HomePage - Identificado boton para rechazar las notificaciones
10:12:55.390 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha dado clic en el botón correspondiente
10:12:55.390 [main] DEBUG com.mobile.Pages.HomePage - Identificado el compenente de seccion para validar que actualmente el page es home
10:13:01.693 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha obtenido el texto For you en el home page
10:13:01.698 [main] DEBUG com.mobile.Pages.HomePage - Identificado boton de configuracion
10:13:05.567 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha dado clic en el botón correspondiente
10:13:05.568 [main] DEBUG com.mobile.Pages.SettingsLogoutPage - Identificado boton para ingresar a soporte de configuracion
10:13:08.718 [main] INFO  com.mobile.drivers.PlatformDriver - Se dado clic en el link correspondiente de acuerdo a las coordenadas ingresadas
10:13:08.719 [main] DEBUG com.mobile.Pages.SettingsLogoutPage - Identificado boton para ingresar a la configuracion de privacidad
10:13:13.586 [main] INFO  com.mobile.drivers.PlatformDriver - Se dado clic en el link correspondiente de acuerdo a las coordenadas ingresadas
10:13:13.587 [main] DEBUG com.mobile.Pages.SettingsLogoutPage - Identificado boton para ingresar a opcion 'your account'
10:13:17.374 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha dado clic en el botón correspondiente
10:13:17.375 [main] DEBUG com.mobile.Pages.SettingsLogoutPage - Identificado boton para ingresar a opcion 'account information'
10:13:20.765 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha dado clic en el botón correspondiente
10:13:20.765 [main] DEBUG com.mobile.Pages.SettingsLogoutPage - Identificado boton para ingresar a opcion 'log out'
10:13:24.395 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha dado clic en el botón correspondiente
10:13:24.397 [main] DEBUG com.mobile.Pages.SettingsLogoutPage - Identificado boton para dar clic en boton 'log out'
10:13:27.743 [main] INFO  com.mobile.drivers.PlatformDriver - Se ha dado clic en el botón correspondiente
10:13:27.745 [main] DEBUG com.mobile.Pages.SettingsLogoutPage - Identificando opción para alamcenar contrasenia
10:13:42.895 [main] INFO  com.mobile.drivers.PlatformDriver - Se dado clic en el link correspondiente de acuerdo a las coordenadas ingresadas

===============================================
Default Suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================


Process finished with exit code 0
