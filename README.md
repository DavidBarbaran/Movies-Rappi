# Movies for Rappi

![](https://i.imgur.com/EzfsDUj.png)

[![Kotlin](https://img.shields.io/badge/kotlin-1.4.21-blue.svg)](http://kotlinlang.org) [![Gradle](https://img.shields.io/badge/gradle-6.1.1-%2366DCB8.svg)](https://developer.android.com/studio/releases/gradle-plugin)

Aplicación demo de películas para evaluación técnica en Rappi.

:white_check_mark: 100% en **Kotlin**

:white_check_mark: Consumo de web services con **Retrofit**

:white_check_mark: Clean **architecture**

:white_check_mark: Patrón de arquitectura **MVVM**

:white_check_mark: Inyección de dependencia con **Koin**

:white_check_mark: Clean **code**


<a href="https://youtu.be/u9X_9_HOmfs"><img src="https://i.imgur.com/6kifBl4.png" width="277"/></a>

<a href="https://firebasestorage.googleapis.com/v0/b/davidbarbarandev.appspot.com/o/MoviesforRappi.apk?alt=media&token=2422ff8e-1252-4bce-982b-29eb3da22b49"><img src="https://i.imgur.com/jMDgwCn.png" width="234"/></a>

## Requerimientos ✔️

:white_check_mark: Películas categorizadas por Popular y Top Rated.

:white_check_mark: Detalle de Películas.

:white_check_mark: Buscador de Películas por nombre.

:white_check_mark: Detalle de Película.

:white_check_mark: Visualización de Videos en el detalle.

:white_check_mark: App con funcionamiento offline.

:white_check_mark: Pruebas Unitarias.

:white_check_mark: App con funcionamiento offline.

:white_check_mark: Transiciones/Animaciones.

:white_check_mark: Aplicación con escalabilidad.

## Coming soon

Integrar *The Movie Database API* ha sido un proyecto demo muy interesante. Esta API es bastante completa y detallada en todos los sentidos. Los features que me hubiera gustado agregar al proyecto son:

💡 **Autenticación de usuarios:** Agregando Firebase Authentication  y sumándole que The Movie Database API en su versión 4 posee el endpoint de request token que te permite crear y eliminar access token (logout) a nuestra disposición.

💡 **Perfil de usuario:** Con Firebase Authentication y si a esto le sumamos Firebase Cloud Firestore podremos gestionar los datos del usuario a nuestra disposición.

💡 **Películas favoritas por usuario:** The Movie Database API cuenta con los endpoints para listar, crear, editar y eliminar listas de películas.

💡 **Reviews por película:** The Movie Database API cuenta con los servicios para obtener reviews por películas.

💡 **Integración de Firebase Analytics:** Integrar la solución brindada por Firebase para poder medir las métricas de interacción de usuario en el app.

💡 **Integración de Crashlytics:** Integrar la solución brindada por Firebase para poder registrar posibles errores que pueden salir en la aplicación.

## Instrucciones

Estas instrucciones le proporcionarán una copia del proyecto en funcionamiento en su máquina local para fines de desarrollo y pruebas.

### Pre requisitos 📋
- [Android Studio](https://developer.android.com/studio/)
- [Git](https://git-scm.com/downloads)

### Instalación 🔧
Después de descargar Android Studio y git en su máquina local, ejecute el comando:

> git clone https://github.com/DavidBarbaran/Movies-Rappi

Abrir Android Studio y haga clic en la opción **Abrir un proyecto existente en Android Studio** y seleccione la carpeta donde se encuentra clonado el proyecto.

## Estructura del proyecto

![](https://i.imgur.com/WQSNeZ0.png)

El proyecto esta desarrollado con **Clean Architecture** que consta de 3 capas que están estructuradas por paquetes según el feature.

### Capa de presentación :iphone:
La capa de presentación es la encargada de mostrar los datos e interactuar con la interfaz de usuario donde usamos el patrón de arquitectura Model-ViewModel-View (MVVM) usando los componentes de arquitectura de Android donde encontramos los siguientes elementos:

- Activity
- ViewModel
- Model

### Capa de dominio :large_orange_diamond:
La capa de dominio es la que se encarga de ejecutar la logica de negocio e interactúa con las capas de data y presentación donde encontramos los siguientes elementos:

- Use Cases
- Domain Entity
- Interactors

### Capa de datos :open_file_folder:
La capa de datos es la que se encarga de gestionar los datos locales y remotos de la aplicación, usando **Retrofit** para el consumo de web Services y Shared Preference para guardar datos del usuario donde encontramos los siguientes elementos:

- Repository
- Data Entity
- RestApi

## Bibliotecas usadas en el proyecto:

- Diseño
	- [Material components](https://material.io/develop/android/docs/getting-started)
	- [Lottie](https://github.com/airbnb/lottie-android)

- Multimedia
	- [Youtube Player](https://developers.google.com/youtube/android/player)

- Arquitectura:
	- [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
	- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

- Inyección de dependencia
	- [Koin](https://github.com/InsertKoinIO/koin)

- Net
	- [Retrofit](https://github.com/square/retrofit)
	- [Glide](https://github.com/bumptech/glide)

- Serialización / Deserialización
	- [Gson](https://github.com/google/gson)

- Programación asincrona:
	- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
