# Empresaurios S.A.
> Daniel Durán Fernández

> Lucian Andrei Farcas   

> Rubén García García   

> Carlos Gutiérrez Palmeiro
	
# Índice
1. [Control de versiones](#control)
    1. [Github](#github)
    2. [Github Desktop](#desktop)
    3. [Ramas Utilizadas](#ramas)
        1. [Master](#master)
        2. [Develop](#develop)
        3. [Feature-bbdd](#bbdd)
        4. [Feature-interfaces](#interface)
        5. [SonarCloud](#sonarcloud)
        6. [Testing](#testing)
        7. [Mantenimiento](#mantenimiento)
2. [Proceso de construcción del sistema](#construccion)
    1. [Maven](#maven)
3. [Gestión de proyectos](#proyectos)
    1. [SCRUM](#scrum)
    2. [Product Backlog](#backlog)
    3. [Issues en Github](#issues)
    4. [Sprint 1](#sprint1)
    5. [Sprint 2](#sprint2)
    6. [Sprint 3](#sprint3)
    7. [Sprint 4](#sprint4)
4. [Persistencia](#persistencia)
    1. [Base de Datos Embebida](#embebida)
    2. [Acceso con hibernate](#hibernate)
        1. [Anotaciones en entidades](#anotaciones)
        2. [Fichero de configuración](#config)
        3. [AbstractEntityDao](#abstract)
5. [Presentación](#presentacion)
    1. [WindowsBuilder](#builder)
    2. [Pantalla Login](#login)
    3. [PantallaDireccionCurso](#direccion)
    4. [PantallaJefeGabinete](#gabinete)
    5. [PantallaEmpleadosVicerrectorado](#vicerectorado)
    6. [PantallaMatricula](#matricula)
6. [Gestión de Calidad](#gestionCalidad)
7. [Testing](#testingCalidad)
8. [Mantenimiento](#mantenimientoo)

## Control de versiones <a name="control"></a>
  ### Github <a name="github"></a>
Como control de versiones usamos un repositorio privado de Github, tendremos el product backlog y otras informaciones organizativas en las issues, Github contiene todas las herramientas suficientes para ocuparse del control de versiones.

  ### Github Desktop <a name="desktop"></a>
En adición a Github usamos en la creación del repositorio local Github Desktop, éste nos permitirá cambiar de rama y hacer sentencias git de una forma mucho más sencilla e intuitiva, además de solucionar algunos problemas de compatibilidad en los merge de ramas.

  ### Ramas Utilizadas <a name="ramas"></a>
  #### Master <a name="master"></a>
  Es la rama origen, se hará un merge desde develop en ésta cuando se entregue una versión o la versión final al cliente.
  
  #### Develop <a name="develop"></a>
  Es la rama donde se han integrado las relaciones entre interfaces y base de datos después de haber hecho un merge de ambas en ésta.

  #### Feature-bbdd <a name="bbdd"></a>
  En esta rama se ha desarrollado la base de datos embebida, se ha poblado y se han creado los daos de cada entidad y abstract entity dao, también se han colocado las anotaciones en las entidades para hibernate.
  
  #### Feature-interfaces <a name="interface"></a>
  En esta rama se han creado las interfaces con un diseño no definitivo, pero orientado a los casos de uso del sistema, se irá editando en la rama develop cuando se haga merge a medida que se requiera

  #### Sonarcloud <a name="sonarcloud"></a>
  En esta rama se ha creado la configuración del proyecto con nuestro sonarcloud para poder mantenerlo de una forma más sencilla.
  #### Testing <a name="testing"></a>
  En esta rama se han creado todos los test con respecto a los controladores. También se ha configurado jacoco para poder ver el coverage de los tests.
  #### Mantenimiento <a name="mantenimiento"></a>
  En esta rama se ha reestructurado el código del proyecto para que sea más fácil de mantener en un futuro haciendo caso a las recomendaciones con respecto a bugs, code smells, security hotspots y código duplicado que nos proporciona el análisis estático de sonarcloud.

## Proceso de construcción del sistema <a name="construccion"></a>
  ### Maven <a name="maven"></a>
  Para simplificar los procesos de build a los desarrolladores usamos maven para construir el sistema, en el pom de éste (el archivo pom se usa para importar diferentes dependencias, entre otras cosas) hemos importado las siguientes dependencias necesarias para el desarrollo de la aplicación.
 ```pom.xml
 
 <dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.apache.derby</groupId>
			<artifactId>derby</artifactId>
			<version>10.15.2.0</version>
		</dependency>
		<dependency>
			<groupId>org.apache.derby</groupId>
			<artifactId>derbytools</artifactId>
			<version>10.15.2.0</version>
		</dependency>
		<dependency>
			<groupId>org.apache.derby</groupId>
			<artifactId>derbyshared</artifactId>
			<version>10.15.2.0</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate.orm</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>6.1.4.Final</version>
		</dependency>
	</dependencies>
 
 ```
* Junit lo usaremos más adelante para la automatización de pruebas.
* Las tres dependencias de derby las usamos para crear la base de datos y editarla, tanto sus columnas, como sus relaciones, como el contenido que tiene.
* Hibernate-core importa todos los jars necesarios para acceder a la base de datos usando hibernate.

También usaremos los siguientes plugins para analizar el coverage de los test que hacemos además de otras cosas de utilidad para los desarrolladores
```
<plugin>
	<groupId>org.jacoco</groupId>
	<artifactId>jacoco-maven-plugin</artifactId>
	<version>0.8.8</version>
	<executions>
		<execution>
			<id>default-prepare-agent</id>
			<goals>
				<goal>prepare-agent</goal>
			</goals>
		</execution>
		<execution>
			<id>default-prepare-agent-integration</id>
			<goals>
				<goal>prepare-agent-integration</goal>
			</goals>
		</execution>
		<execution>
			<id>default-report</id>
			<goals>
				<goal>report</goal>
			</goals>
		</execution>
		<execution>
			<id>default-report-integration</id>
			<goals>
				<goal>report-integration</goal>
			</goals>
		</execution>
		<execution>
			<id>default-check</id>
			<goals>
				<goal>check</goal>
			</goals>
			<configuration>
				<rules>
					<!-- implementation is needed only for Maven 2 -->
					<rule implementation="org.jacoco.maven.RuleConfiguration">
						<element>BUNDLE</element>
						<limits>
							<!-- implementation is needed only for Maven 2 -->
							<limit implementation="org.jacoco.report.check.Limit">
								<counter>COMPLEXITY</counter>
								<value>COVEREDRATIO</value>
								<minimum>0.10</minimum>
							</limit>
						</limits>
					</rule>
				</rules>
			</configuration>
		</execution>
	</executions>
</plugin>
```

```
<plugins>
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-project-info-reports-plugin</artifactId>
	</plugin>
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-jxr-plugin</artifactId>
		<version>3.0.0</version>
	</plugin>

	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-surefire-report-plugin</artifactId>
		<version>3.0.0-M5</version>
		<configuration>
			<skipEmptyReport>false</skipEmptyReport>
		</configuration>
	</plugin>

	<plugin>
		<groupId>org.jacoco</groupId>
		<artifactId>jacoco-maven-plugin</artifactId>
		<version>0.8.8</version>
		<reportSets>
			<reportSet>
				<reports>
					<report>report</report>
				</reports>
			</reportSet>
		</reportSets>
	</plugin>

</plugins>
```

## Gestión de proyectos <a name="proyectos"></a>
  ### SCRUM <a name="scrum"></a>
  Como metodología de gestión de proyectos hemos escogido SCRUM debido a la naturaleza del proyecto y la necesidad de realizar entregas cada cierto tiempo. Esto implica que el equipo ha sido multifuncional y todos hemos realizado un mínimo en cada aspecto del proyecto. También es importante tener en cuenta que no hemos establecido un Scrum Master si no que todos hemos tenido alguna influencia en este papel al proyectar el plan de desarrollo e ir asegurando el Scrum entre el equipo .
Al ser Scrum hemos definido una plantilla de sprints que nos servirá de guía a lo largo del desarrollo del proyecto, que de forma resumida consiste en: un sprint inicial más extenso en el que se desarrollará la arquitectura del sistema junto con una de las historias de usuario; y el resto de sprints que tendrán un duración normal y abarcan una historia de usuario cada uno.

  ### Product Backlog <a name="backlog"></a>
  Para poder gestionar bien las actividades del proyecto, hemos definido todas las historias de usuario que hemos creído convenientes. En un momento inicial habíamos recogido estas historias con la herramienta de gestión de proyectos ZenHub, sin embargo debido a ciertas dificultades hemos decidido cambiar a Trello, un software muy similar que simula las capacidades de ZenHub de una manera muy versátil. En general,  las historias de usuarios planteadas son las siguientes: 
* Yo, como usuario, quiero que mis datos sean persistentes.
* Yo, como usuario, quiero poder acceder al sistema para realizar diferentes acciones.
* Yo, como director de cursos quiero listar todos los cursos, poder hacer una nueva propuesta, editar un curso y crear una nueva edición de un curso.
* Yo, como vicerrector quiero poder visualizar las propuestas de cada curso
* Yo, como vicerrector quiero poder evaluar la propuesta de un curso.
* Yo, como jefe de gabinete vicerrectorado quiero poder consultar diferente información sobre los cursos.
* Yo, como estudiante quiero poder matricularme en un curso así como elegir el método de pago.
* Yo, como usuario del sistema quiero que la interfaz sea usable, confidencial, persistente, etc.
Todas las historias se pueden ver a través de nuestro Trello en el siguiente [enlace](https://trello.com/invite/b/0kcJkuo2/ATTI595f71b809ea5e19fd2197ce52231cee6016FA92/practicas-iso2).
  
  ### Issues en Github <a name="issues"></a>
  Una vez realizado todo el Backlog, hemos incorporado cada historia de usuario al repositorio de GitHub en forma de issues. Además cuando definimos el sprint, las issues seleccionadas pasan al SprintBacklog y se les adjudica la etiqueta correspondiente. Esto ayuda a localizar rápidamente el estado actual de cada issue y cualquier información adicional. Para ver todas las etiquetas y su función, se recomienda visitar el apartado de “Labels” dentro de las Issues del repositorio.

  ### Sprint 1 <a name="sprint1"></a>
  El primer sprint que se corresponde con esta primera entrega, tenía una estimación de dos semanas, sin embargo debido a varias dificultades con la base de datos el sprint ha concluido a las tres semanas. Inicialmente este sprint abarcaría la construcción de la arquitectura junto a la historia de usuario de “Yo, como director de cursos quiero listar todos los cursos, poder hacer una nueva propuesta, editar un curso y crear una nueva edición de un curso”, pero un aspecto que no hemos tenido en cuenta al comienzo del proyecto ha sido la gestión de la configuración, lo cual ha dificultado la aplicación de Scrum los primeros 10 días del sprint. 
  
  ### Sprint 2 <a name="sprint2"></a>
  Para el Sprint 2 cubriremos las siguientes issues:
* Yo, como jefe de gabinete vicerrectorado quiero poder consultar diferente información sobre los cursos.
* Yo, como director de cursos quiero poder visualizar las propuestas de cada curso.
* Yo, como vicerrector quiero poder evaluar la propuesta de un curso.

Con una fecha límite de mediados de noviembre

  ### Sprint 3 <a name="sprint3"></a>
Para el Sprint 3 cubriremos las siguientes issues:
* Desarrollar la cobertura de SonarQube.
* Yo, como estudiante quiero poder matricularme en un curso así como elegir el método de pago.

Con una fecha límite de principios de diciembre aunque se alargará la entrega por cuestiones no consideradas.

  ### Sprint 4 <a name="sprint4"></a>
Para el Sprint 4 cubriremos las siguientes issues:
* Implementación testing con Junit
* Yo, como usuario quiero poder logearme en el sistema para realizar diferentes acciones ICEBOX (al final no desarrollada)
* Yo, como usuario del sistema deseo que la interfaz sea usable, confidencial, persistente, etc ICEBOX (al final no desarrollada)
* Mejorar Hibernate utilizando relaciones ICEBOX (al final no desarrollada)

Con una fecha límite del 22 de diciembre.\
En esta fecha haremos la release 2.0


## Persistencia <a name="persistencia"></a>

  ### Base de Datos Embebida <a name="embebida"></a>
  La base de datos es embebida y está creada con DBeaver, esto implica que está integrada en el sistema por lo que no tiene contraseña, las tablas están localizadas en el usuario root. El diagrama es el siguiente:
![diagrama_bbdd](/SOURCE_README/diagrama_bbdd.png)

  ### Acceso con hibernate <a name="hibernate"></a>
  Usaremos hibernate para librar carga de trabajo al hacer la persistencia ya que de esta forma no tendremos que hacer las sentencias a mano ni hacer daos extensos uno por uno.
  
  #### Anotaciones en entidades <a name="anotaciones"></a>
  Para que hibernate funcione necesita tener una forma de relacionar entidades de java con tablas y columnas en la base de datos. Para ello se anotan clases y atributos en las entidades de java con una sintaxis dada por el propio hibernate. Puedes usar:
* ***@Entity***: se usa para indicar que la siguiente clase es una entidad de la base de datos.
* ***@Table***: se usa para relacionar la entidad con el nombre que tiene en la base de datos.
* ***@Column***: se usa para relacionar los atributos de las entidades con el nombre de las columnas de las tablas de la base de datos.
* ***@Transient***: se usa para indicar que un atributo de la entidad no tiene relación con la base de datos y no debería ser tomado en cuenta

```Apex
@Entity
@Table(name = "Materia")
public class Materia {

	@Id
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "horas")
	private double horas;

	@Column(name = "fechainicio")
	private Date fechaInicio;

	@Column(name = "fechafin")
	private Date fechaFin;

	@Transient
	Profesor responsable;

	@Column(name = "responsable")
	String idResponsable;

	@Transient
	CursoPropio curso;

	@Column(name = "curso")
	String idCurso;

```
Además de esas anotaciones existen otras dos que son requeridas por hibernate para entidades que tienen una relación de herencia (padre-hijo), éstas son @Inheritance para padre y @PrimaryKeyJoinColumn para el hijo.

```Apex
@Table(name = "Profesor")
@Inheritance(strategy=InheritanceType.JOINED)
public class Profesor {}

@Entity
@Table(name = "ProfesorUCLM")
@PrimaryKeyJoinColumn(name = "dni")
public class ProfesorUCLM extends Profesor {}

```

  #### Fichero de configuración <a name="config"></a>
  En el fichero de configuración guardaremos todo lo necesario para que hibernate pueda acceder a la base de datos. Url, dialecto, usuario…
  
```xml

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
		"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
		"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">org.apache.derby.jdbc.EmbeddedDriver</property>
        <property name="hibernate.connection.url">jdbc:derby:../practicas_ISOII\dbderby</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.dialect">org.hibernate.dialect.DerbyDialect</property>
        <property name="hibernate.show_sql">true</property>
    </session-factory>
</hibernate-configuration>

```
  #### AbstractEntityDao <a name="abstract"></a>
  Para construir el dao abstracto con genéricos con hibernate es necesario construir una SessionFactory y una Session, la SessionFactory se construye de la siguiente forma, siendo entityClass una variable class de la entidad en la que se desea trabajar.
```Apex

SessionFactory sessionfactory = newConfiguration().configure("hibernate.cfg.xml").addAnnotatedClass(entityClass).buildSessionFactory();

```
Para construir una Session se usa la SessionFactory ya creada con el método openSession().

```Apex

protected Session getSession() {
		return this.sessionfactory.openSession();
	}
```
Vamos a necesitar que el programa haga con genéricos las siguientes operaciones de base de datos:
* save(): guarda el objeto pasado por parámetro en la base de datos

```Apex

public void save(E entity) {
		Session sesion=getSession();
		sesion.beginTransaction();
		sesion.save(entity);
		sesion.getTransaction().commit();
		sesion.close();
	}

```
* update(): edita el objeto pasado por parámetro en la base de datos

```Apex

public void update(E entity) {
		Session sesion=getSession();
		sesion.beginTransaction();
		sesion.update(entity);
		sesion.getTransaction().commit();
		sesion.close();
	}
```
* delete(): borra el objeto pasado por parámetro en la base de datos

```Apex

public void delete(E entity) {
		Session sesion=getSession();
		sesion.beginTransaction();
		sesion.delete(entity);
		sesion.getTransaction().commit();
		sesion.close();
	}
```

* showAll(): recoge en una lista de objetos todos los objetos de una clase determinada (entityClass) de la base de datos

```Apex

public List<E> showAll() {
		Session sesion=getSession();
		sesion.beginTransaction();
		System.out.println(entityClass);
		Query query = sesion.createQuery("from " + entityClass.getSimpleName());
		list = (List<E>)query.list();
		sesion.getTransaction().commit();
		sesion.close();
		return list;
	}
```

* showAllWhere(where): recoge una lista de objetos con una sentencia where un atributo específico es igual a un entero/String específico, depende de lo que se le pase desde el DAO que lo invoca

```Apex

public List<E> showAllWhere(String where) {
		Session sesion = getSession();
		sesion.beginTransaction();
		Query<E> query = sesion.createQuery("from " + entityClass.getSimpleName() + " where " + where, entityClass);
		list = query.list();
		sesion.getTransaction().commit();
		sesion.close();
		return list;
	}
```

* show(id): recoge un objeto determinado por entityClass con una id igual a lo que se pasa por parámetro en la base de datos. Son dos métodos que se sobreescriben ya que a veces el id es una cadena de carácteres y otras veces es un entero.

```Apex

public Object show(String id) {
		Session sesion=getSession();
		sesion.beginTransaction();
		Object entidad = sesion.get(entityClass, id);
		sesion.getTransaction().commit();
		sesion.close();
		return entidad;
	}
public Object show(int id) {
		Session sesion=getSession();
		sesion.beginTransaction();
		Object entidad = sesion.get(entityClass, id);
		sesion.getTransaction().commit();
		sesion.close();
		return entidad;
	}

```


## Presentación <a name="presentacion"></a>

  ### WindowsBuilder <a name="builder"></a>
  Plugin de Eclipse que se ha utilizado para el desarrollo de las interfaces de usuario. En este sprint las pantallas se han creado de la forma más básica posible ya que la prioridad era la implementación de los requisitos funcionales, por lo que con una interfaz sencilla se pueden realizar todas las pruebas necesarias. Además las pantallas en las que se han hecho enfásis ha sido la PantallaDireccionCursos.
  
  ### PantallaLogin <a name="login"></a>
  Consiste en una pantalla con 2 TextBox uno para introducir el usuario y otro para la contraseña, y un Button para loguearse en el sistema. Cuando se pulsa el botón login se lanza la pantalla principal que permite al usuario seleccionar el modo de la aplicación (PantallaDireccionCursos, PantallaJefeGabinete, PantallaEmpleadosVicerrectorado, PantallaMatricula).
  
 PantallaLogin        |  Menu Principal
:-------------------------:|:-------------------------:
![login](/SOURCE_README/login.png)  |  ![menu_principal](/SOURCE_README/menu_principal.png)
  
  
  ### PantallaDireccionCurso <a name="direccion"></a>
  En esta pantalla el usuario podrá ver una lista con todos los cursos guardados en la base de datos y podrá realizar diferentes acciones con ellos: cambiar el nombre, los creditos ECTS, el importe, el tipo, la fecha de inicio y fin, el centro, director y secretario.
Para introducir un nuevo curso, no tiene que haber otro curso seleccionado (lo podemos deseleccionar con el botón “Limpiar todo”) rellenamos todos los campos y presionamos el botón “Nuevo Curso”.
| PantallaDireccionCurso        |
:-------------------------:|
![direccion](/SOURCE_README/direccion.png)  |


***Las 3 pantallas restantes se han planteado para ver como serán desarrolladas en el futuro.***
  ### PantallaJefeGabinete <a name="gabinete"></a>
  En esta pantalla el jefe de gabinete podrá consultar diferente información sobre cursos seleccionando con los checkbox, filtrando por fechas de inicio y fin y por estado del curso, también se mostrarán los ingresos de esos cursos filtrados
|   PantallaJefeGabinete        |
:-------------------------:|
| ![](/SOURCE_README/jefe_gabinete.jpeg)  |


  ### PantallaEmpleadosVicerrectorado <a name="vicerectorado"></a>
  En esta pantalla se mostrarán los cursos PROPUESTOS a la izquierda, se podrán poner a VALIDADO o a PROPUESTA_RECHAZADA, a la derecha se mostrarán los cursos VALIDADOS, si le das al botón “Dar de Alta” el curso cambiará a EN_MATRICULACION.
|   PantallaEmpleadosVicerrectorado        |
:-------------------------:|
| ![](/SOURCE_README/vicerectorado.jpeg)  |

  ### PantallaMatricula <a name="matricula"></a>
  En esta pantalla el usuario podrá matricularse en un curso, cuando se seleccione el alumno se mostrarán en una lista los cursos en los que no tiene una matrícula o los cursos donde tiene una matrícula y no está pagada.
En el caso de que pinche en uno de los cursos en los que no está matriculado se habilitará el botón de “Realizar Matriculación”, esto creará una matrícula del alumno en ese curso sin pagar. Sin embargo si pincha en un curso en el que está matriculado pero no está pagado se habilitará el botón de “Realizar Pago”, al pinchar en el botón la matrícula será pagada en la forma de pago que se haya marcado en las checkbox arriba.

|    PantallaMatricula        |
:-------------------------:|
| ![](/SOURCE_README/matriculacion.jpeg)  |

## Gestión de calidad <a name="gestionCalidad"></a>
A la hora de adaptar la calidad al software hemos utilizado las bases del concepto de Quality By Design, utilizando el ciclo de Process Understanding, Design, Scientific Knowledge, Process Control. De esta manera al realizar nuevas funcionalidades siempre comenzamos **entendiendo** lo que debería hacer una nueva funcionalidad (por ejemplo, realizar una consulta debería permitir acceder a la información de la base de datos y obtener un informe sobre los datos solicitados), después procedemos a **diseñar** como se realizaria esta implementación (sobre toda la parte visual, referente a la interfaz con la que va a interactuar el usuario). \
A continuación definiremos los **procesos** que se realizarán para poder llevar a cabo dicha funcionalidad (en este caso una sentencia SQL que devuelva la información adecuada) y por último un **control del proceso** para asegurar el correcto funcionamiento (para las consulta un control de error en el que se obligue al usuario rellenar los campos de la consulta). \
Este ha sido el esquema seguido en la mayoría de las nuevas funcionalidades en las que es el dominio y el software los que se adaptan a los requisitos y no al contrario.

Para la gestión de la calidad hemos utilizado principalmente Sonar Cloud para los análisis, pero además hemos hecho uso de Sonar Lint como principal herramienta dentro de nuestro IDE para una resolución más rápida y efectiva de las diferentes “issues”. \
Después de configurar apropiadamente Sonar Cloud con Github Actions para una integración continua, hemos continuado el desarrollo del proyecto siempre teniendo en cuenta las diferentes soluciones que Sonar Lint nos indicaba para cualquier bug, code smell y el resto de “issues” posibles. \
La entrega de los nuevos Sprints realizados a partir de esta configuración han tenido la siguiente estructura:
* Implementación de nueva funcionalidad
* Análisis para conocer las diferentes issues provocadas por el desarrollo y la implementación de la nueva funcionalidad.
* Mejora a nivel de código junto a Sonar Lint para resolver las issues.
* Nuevo análisis en Sonar Cloud para conocer la mejora.
Además de resolver los problemas que indicaba Sonar Lint, hemos reestructurado varias clases para un mejor entendimiento del código y su funcionamiento, incluyendo cierta abstracción en las interfaces a la hora de interactuar con estas. 

Por otro lado, para hacer un análisis más ajustado de Sonar Cloud se han modificado la Quality Gate y algunos Quality Profiles. En concreto, se ha creado una nueva Quality Gate en la que se ha bajado el requerimiento mínimo de coverage a un 30%; el Quality Profile de XML ha sido copiado y modificado, desactivando un regla de seguridad debido a su complicado manejo y se ha realizado lo mismo con el Quality Profile de Java editando y desactivando algunas de las reglas por la misma razón. Las reglas modificadas o desactivadas son las siguientes:
* Cognitive Complexity of methods should not be too high (java:S3776)
* Jump statements should not be redundant (java:S3626)
* Fields in a "Serializable" class should either be transient or serializable (java:S1948)
* Formatting SQL queries is security-sensitive (java:S2077)
* Methods should not have too many parameters (java:S107)
* Hard-coded credentials are security-sensitive (xml:S2068)

## Testing <a name="testingCalidad"></a>
  **[Link para acceder a informes de Maven](https://empresauriossa.000webhostapp.com/site/index.html)**
  
  **[Link a carpeta testing](/practicas_ISOII/Tablas_Testing/)**
  
Al realizar el plan de testing hemos analizado los diferentes requisitos e historias de usuario existentes para poder idear las pruebas más ajustadas a estas. Una vez analizado, hemos llegado a la conclusión de que la capa más crítica para realizar los test se trataba de la capa de negocio, en concreto los controladores, ya que contiene gran parte del dominio del sistema. Debido a esto la mayoría de pruebas que se han realizado han sido de caja blanca, en concreto pruebas unitarias para poder comprobar el correcto funcionamiento de las entidades y la persistencia. \
Debido al deseo de automatizar estas pruebas no ha sido posible realizar pruebas a la capa de presentación ya que está formada en su totalidad por elementos cuyo testeo resulta problemático en entornos sin interfaz gráfica como Github Actions, además que la mayoría requieren estimulación por parte del usuario. 

**Para poder ver todas las tablas puede acceder desde los siguientes enlaces:**

**[testDarBajaCurso](https://empresauriossa.000webhostapp.com/testDarBajaCurso.html)** \
**[testEditarPropuestaCurso](https://empresauriossa.000webhostapp.com/testEditarPropuestaCurso.html)** \
**[testListarCentros](https://empresauriossa.000webhostapp.com/testListarCentros.html)** \
**[testListarCurso](https://empresauriossa.000webhostapp.com/testListarCurso.html)** \
**[testListarCursos](https://empresauriossa.000webhostapp.com/testListarCursos.html)** \
**[testListarCursosWhereEstadoCurso](https://empresauriossa.000webhostapp.com/testListarCursosWhereEstadoCurso.html)** \
**[testListarCursosWhereTipoCurso](https://empresauriossa.000webhostapp.com/testListarCursosWhereTipoCurso.html)** \
**[testListarEstudiante](https://empresauriossa.000webhostapp.com/testListarEstudiante.html)** \
**[testListarEstudiantes](https://empresauriossa.000webhostapp.com/testListarEstudiantes.html)** \
**[testListarMatriculas](https://empresauriossa.000webhostapp.com/testListarMatriculas.html)** \
**[testListarProfesoresUCLM](https://empresauriossa.000webhostapp.com/testListarProfesoresUCLM.html)** \
**[testRealizarMatriculacion](https://empresauriossa.000webhostapp.com/testRealizarMatriculacion.html)** \
**[testRealizarPagoMatricula](https://empresauriossa.000webhostapp.com/testRealizarPagoMatricula.html)** \
**[testRealizarPropuestaCurso](https://empresauriossa.000webhostapp.com/testRealizarPropuestaCurso.html)**

## Mantenimiento <a name="mantenimientoo"></a>

Gracias a los análisis de Sonar Cloud y la herramiento de Sonar Lint, al realizar el plan de mantenimiento se han ordenado de mayor a menor prioridad los diferentes tipos de issues de la siguiente manera: Vulnerabilidades, Bugs, Security Hotspots y Code Smells. \
Debido a que no hemos tenido ningún tipo de vulnerabilidad hemos podido pasar a resolver directamente los bugs que simplemente se trataban de variables que se inicializan a null. Por otra parte ha sido necesario un mayor esfera en las Security Hotspots ya que algunos se trataban de contraseñas o usuarios que se guardaban directamente en el código para realizar pruebas o conexiones a la base de datos, la mejor solución a este problema es realizar un archivo de configuración personal para guardar este tipo de información sensible. \
Por último para resolver gran parte de los Code Smells se ha hecho uso de la herramienta de Sonar Lint que permite una rápida modificación para los smells más sencillos y una gran ayuda para los más complicados. Algunos de estos han sido definiciones abstractas de variables sin parametrizar adecuadamente, nombres inapropiados para variables, código residual y comentarios, etc.
