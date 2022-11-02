# Memoria
# Índice
1. [Control de versiones](#control)
    1. [Github](#github)
    2. [Github Desktop](#desktop)
    3. [Ramas Utilizadas](#ramas)
        1. [Master](#master)
        2. [Develop](#develop)
        3. [Feature-bbdd](#bbdd)
        4. [Feature-interfaces](#interface)
2. [Proceso de construcción del sistema](#construccion)
    1. [Maven](#maven)
3. [Gestión de proyectos](#proyectos)
    1. [SCRUM](#scrum)
    2. [Product Backlog](#backlog)
    3. [Sprint 1](#sprint)
    4. [Issues en Github](#issues)
    5. [Futuros sprints](#futuros)
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
* Hibernate-core importa todos los jars necesarios para acceder a la base de datos usando hibernate

## Control de versiones <a name="proyectos"></a>
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

  ### Sprint 1 <a name="sprint"></a>
  El primer sprint que se corresponde con esta primera entrega, tenía una estimación de dos semanas, sin embargo debido a varias dificultades con la base de datos el sprint ha concluido a las tres semanas. Inicialmente este sprint abarcaría la construcción de la arquitectura junto a la historia de usuario de “Yo, como director de cursos quiero listar todos los cursos, poder hacer una nueva propuesta, editar un curso y crear una nueva edición de un curso”, pero un aspecto que no hemos tenido en cuenta al comienzo del proyecto ha sido la gestión de la configuración, lo cual ha dificultado la aplicación de Scrum los primeros 10 días del sprint. 
  
  ### Futuros sprints <a name="futuros"></a>
  Para los próximos sprints se pretende seguir la guía mencionada anteriormente, es decir cada sprint se correspondería con una historia de usuario y el tiempo estimado para cada uno es de 10 días. Por último, algunos de los sprint finales también abarcarían otros aspectos como testing, calidad y despliegue del software.


## Control de versiones <a name="persistencia"></a>

  ### Base de Datos Embebida <a name="embebida"></a>
  La base de datos es embebida y está creada con DBeaver, esto implica que está integrada en el sistema por lo que no tiene contraseña, las tablas están localizadas en el usuario root. El diagrama es el siguiente:

```

Foto del diagrama de la base de datos

```
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
  
```

foto del login y la pantalla principal

```
  
  ### PantallaDireccionCurso <a name="direccion"></a>
  En esta pantalla el usuario podrá ver una lista con todos los cursos guardados en la base de datos y podrá realizar diferentes acciones con ellos: cambiar el nombre, los creditos ECTS, el importe, el tipo, la fecha de inicio y fin, el centro, director y secretario.
Para introducir un nuevo curso, no tiene que haber otro curso seleccionado (lo podemos deseleccionar con el botón “Limpiar todo”) rellenamos todos los campos y presionamos el botón “Nuevo Curso”.

```

foto de direccion de cursos

```
***Las 3 pantallas restantes se han planteado para ver como serán desarrolladas en el futuro.***
  ### PantallaJefeGabinete <a name="gabinete"></a>
  En esta pantalla el jefe de gabinete podrá consultar diferente información sobre cursos seleccionando con los checkbox, filtrando por fechas de inicio y fin y por estado del curso

```

foto de jefe de gabinete

```
  ### PantallaEmpleadosVicerrectorado <a name="vicerectorado"></a>
  En esta pantalla se mostrarán los cursos disponibles y se podrán editar así como dar de alta los cursos que tengan estado validado
  
```

foto de empleados vicerectorado

```

  ### PantallaMatricula <a name="matricula"></a>
  En esta pantalla el usuario podrá matricularse en un curso, por lo que se mostrará una lista con todos los cursos disponibles, al pulsar el botón de realizar matricula se rellenarán los datos del estudiante que se esta matriculando así como el curso al que se quiere matricular. Podrá elegir con 2 botones el método de pago, paco con transferencia o con Tarjeta.
