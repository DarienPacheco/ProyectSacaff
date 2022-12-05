# ProyectSacaff
Instrucciones de uso. De todas formas el video explicativo incluye el como abrir el programa e iniciar la base de datos.

Integrantes:  Darien Pacheco
	      Rocio Ramirez
	      Vicente Sepulveda
	      Nicole Navarrete
Datos de creacion para la base de datos: Nombre de la base "Sacaff" user "root" direccion "127.0.0.1:3306" contraseña "complejosacaff2022"
Se incluyen las tablas de MySql para correr el programa, para agregarlas existira un tutorial dentro del video.

Se requiere JDK19, MySql 8.0.31.0, Netbeans 12.6. Las librerias estaran incluidas en el programa pero se indicaran en el video las
utilizadas para aclarar.

Primero para hacer funcionar el programa se debe ejecutar "Ventana1" ubicada en el paquete "Vistas", el cual tiene como funcion
conectarse a mysql. Desde esta ventana se puede acceder al registro, en caso de que no se cuente con un usuario, y con inicio de sesion
para entrar a la interfaz de usuario (un menu con las funciones). Esta incluye:
-Vender: Permite seleccionar los productos del inventario a vender y estos se descontaran del inventario, ademas de mostrar el total del precio.
-Reservar canchas: Mostrara un menu con el tipo de cancha a reservar, tenis o futbol, una vez seleccionado se podra ver un calendario para escoger
la fecha de reserva, y una vez escogido mostrara otra ventana con solo los horarios disponibles, al elegir uno se reservara a nombre de un cliente
que se agregara a la base de datos.
-Mostrar inventario: Se muestra todo el inventario con opcion de 2 funciones, agregar mas cantidad a un producto ya existente en el
inventario seleccionandolo en la ventana y presionando el boton de agregar. Tambien se puede agregar un producto totalmente nuevo el cual
abre una nueva ventana con la informacion a completar para ser agregado.
