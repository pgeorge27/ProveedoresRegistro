-- phpMyAdmin SQL Dump
-- version 4.2.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 31-01-2015 a las 19:55:53
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.5.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bdregistroproveedores`
--
CREATE DATABASE IF NOT EXISTS `bdregistroproveedores` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bdregistroproveedores`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_bancos_nac`
--

CREATE TABLE IF NOT EXISTS `bdv_bancos_nac` (
  `banco_id` int(15) NOT NULL,
  `banco_descripcion` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_bancos_nac`
--

INSERT INTO `bdv_bancos_nac` (`banco_id`, `banco_descripcion`) VALUES
(10000, 'BANCO DE VENEZUELA S.A.C.A.'),
(10001, 'BANCO CARACAS'),
(10002, 'Credit Card Bank'),
(10021, 'Venezolano de Credito'),
(10022, 'Banesco'),
(10023, 'Provincial'),
(10024, 'Mercantil'),
(10025, 'Citibank N,A'),
(10026, 'Fondo Comun'),
(10027, 'BanPro'),
(10041, 'Federal'),
(10061, 'Banco del Caribe'),
(10081, 'B.O.D.Banco occidental de descuento'),
(10101, 'Banco Sofitasa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_banco_cuenta`
--

CREATE TABLE IF NOT EXISTS `bdv_banco_cuenta` (
`id_banco_cuenta` int(11) NOT NULL,
  `id_banco` int(15) NOT NULL,
  `id_tipo_cuenta` int(11) NOT NULL,
  `codigo_cuenta` varchar(20) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_banco_cuenta`
--

INSERT INTO `bdv_banco_cuenta` (`id_banco_cuenta`, `id_banco`, `id_tipo_cuenta`, `codigo_cuenta`, `telefono`) VALUES
(1, 10002, 2, '12378152315236751627', '(0212)445-4442'),
(2, 10000, 1, '16341634154312435614', '(2131)231-2312'),
(3, 10000, 1, '16341634154312435614', '(2131)231-2312'),
(4, 10000, 1, '16341634154312435614', '(2131)231-2312'),
(5, 10000, 1, '16325612367152367142', '(1543)514-2356'),
(6, 10000, 1, '61253612356153671536', '(1367)152-3651');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_banco_cuenta_vnz`
--

CREATE TABLE IF NOT EXISTS `bdv_banco_cuenta_vnz` (
`id_banco_cuenta_vnz` int(11) NOT NULL,
  `codigo_cuenta` varchar(20) DEFAULT NULL,
  `id_tipo_cuenta` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_banco_cuenta_vnz`
--

INSERT INTO `bdv_banco_cuenta_vnz` (`id_banco_cuenta_vnz`, `codigo_cuenta`, `id_tipo_cuenta`) VALUES
(1, '16523615236715236167', 1),
(2, '61523614235142375412', 1),
(3, '61523614235142375412', 1),
(4, '61523614235142375412', 1),
(5, '15243512435142361523', 1),
(6, '16231623461436715236', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_categoria_producto`
--

CREATE TABLE IF NOT EXISTS `bdv_categoria_producto` (
`id_categoria_producto` int(11) NOT NULL,
  `descr_categoria` varchar(100) NOT NULL,
  `f_creacion` date NOT NULL,
  `f_desde` date NOT NULL,
  `f_fin` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_categoria_producto`
--

INSERT INTO `bdv_categoria_producto` (`id_categoria_producto`, `descr_categoria`, `f_creacion`, `f_desde`, `f_fin`) VALUES
(1, 'ARTICULOS DEPORTIVOS', '2014-12-09', '2014-12-09', NULL),
(2, 'ADQUISICION LICENCIAS', '2014-12-09', '2014-12-09', NULL),
(3, 'ADQUISICION PAPELERIA COMEDOR', '2014-12-09', '2014-12-09', NULL),
(4, 'ADQUISICION PRENDAS DE VESTIR', '2014-12-09', '2014-12-09', NULL),
(5, 'ADQUISICION UNIFORMES PERSONAL', '2014-12-09', '2014-12-09', NULL),
(6, 'MATERIALES DE LIMPIEZA', '2014-12-09', '2014-12-09', NULL),
(7, 'ADQUSICION UTENSILIOS COMEDOR', '2014-12-09', '2014-12-09', NULL),
(8, 'ALIMENTACION Y BEBIDAS', '2014-12-09', '2014-12-09', NULL),
(9, 'ALQUILER DE ESPACIO FISICO', '2014-12-09', '2014-12-09', NULL),
(10, 'ARRENDAMIENTO DE EQUIPOS', '2014-12-09', '2014-12-09', NULL),
(11, 'ARRENDAMIENTO DE ESPACIOS FISICOS', '2014-12-09', '2014-12-09', NULL),
(12, 'ARTICULOS GENERALES DE FERRETERIA', '2014-12-09', '2014-12-09', NULL),
(13, 'CAPACITACIONES PARA EMPLEADOS', '2014-12-09', '2014-12-09', NULL),
(14, 'DERECHO DE USO SOFTWARE / LICENCIA', '2014-12-09', '2014-12-09', NULL),
(15, 'DISPOSITIVOS DE SEGURIDAD', '2014-12-09', '2014-12-09', NULL),
(16, 'DISPOSITIVOS MENORES DE COMPUTACION', '2014-12-09', '2014-12-09', NULL),
(17, 'EQUIPO DE COMPUTACION', '2014-12-09', '2014-12-09', NULL),
(18, 'EQUIPO DE OFICINA', '2014-12-09', '2014-12-09', NULL),
(19, 'EQUIPO DE TRANSPORTE', '2014-12-09', '2014-12-09', NULL),
(20, 'EQUIPO MULTISERVICIO', '2014-12-09', '2014-12-09', NULL),
(21, 'EQUIPO PARA AUDIO', '2014-12-09', '2014-12-09', NULL),
(22, 'EQUIPOS AUDIOVISUALES', '2014-12-09', '2014-12-09', NULL),
(23, 'EQUIPOS AUXILIARES DE TRANSPORTE', '2014-12-09', '2014-12-09', NULL),
(24, 'EQUIPOS COMEDOR COCINA', '2014-12-09', '2014-12-09', NULL),
(25, 'EQUIPOS DE SEGURIDAD', '2014-12-09', '2014-12-09', NULL),
(26, 'EQUIPOS DE TELECOMUNICACION', '2014-12-09', '2014-12-09', NULL),
(27, 'EQUIPOS PARA AUDIO', '2014-12-09', '2014-12-09', NULL),
(28, 'ESPACIOS PUBLICITARIOS MEDIOS', '2014-12-09', '2014-12-09', NULL),
(29, 'GASTOS DE IMPORTACION', '2014-12-09', '2014-12-09', NULL),
(30, 'IMPRESIîN Y REPRODUCCION', '2014-12-09', '2014-12-09', NULL),
(31, 'INSTRUMENTOS PARA MUSICA', '2014-12-09', '2014-12-09', NULL),
(32, 'MANTENIMIENTO DE EQUIPOS', '2014-12-09', '2014-12-09', NULL),
(33, 'MANTENIMIENTO DE LICENCIAS', '2014-12-09', '2014-12-09', NULL),
(34, 'MATERIAL DE ORDEN PUBLICO', '2014-12-09', '2014-12-09', NULL),
(35, 'MATERIAL E INSUMOS MEDICO', '2014-12-09', '2014-12-09', NULL),
(36, 'MATERIAL POP', '2014-12-09', '2014-12-09', NULL),
(37, 'MATERIAL USO COMPUTACION', '2014-12-09', '2014-12-09', NULL),
(38, 'MATERIALES DE OFICINA', '2014-12-09', '2014-12-09', NULL),
(39, 'MATERIALES DE SEGURIDAD', '2014-12-09', '2014-12-09', NULL),
(40, 'MATERIALES ELECTRICOS', '2014-12-09', '2014-12-09', NULL),
(41, 'OTROS EQUIPOS', '2014-12-09', '2014-12-09', NULL),
(42, 'OTROS MATERIALES Y SUMINISTROS', '2014-12-09', '2014-12-09', NULL),
(43, 'SERVICIOS PROFESIONALES', '2014-12-09', '2014-12-09', NULL),
(44, 'PATROCINIOS VARIOS', '2014-12-09', '2014-12-09', NULL),
(45, 'PLAN VACACIONAL', '2014-12-09', '2014-12-09', NULL),
(46, 'POLIZAS DE SEGURO', '2014-12-09', '2014-12-09', NULL),
(47, 'PRODUCTO DE PAPELERIA', '2014-12-09', '2014-12-09', NULL),
(48, 'PRODUCTOS DE SEGURIDAD EN EL TRABAJO', '2014-12-09', '2014-12-09', NULL),
(49, 'REGALOS CORPORATIVOS', '2014-12-09', '2014-12-09', NULL),
(50, 'REGALOS INSTITUCIONALES (INTERNOS)', '2014-12-09', '2014-12-09', NULL),
(51, 'SERVICIO DE MENSAJERIA', '2014-12-09', '2014-12-09', NULL),
(52, 'SERVICIO DE VIGILANCIA', '2014-12-09', '2014-12-09', NULL),
(53, 'SERVICIO ELABORACION DE COMIDA', '2014-12-09', '2014-12-09', NULL),
(54, 'SERVICIOS PROFESIONALES TECNOLOGICOS', '2014-12-09', '2014-12-09', NULL),
(55, 'SERVICIOS Y ELABORACION MERCHANDISING', '2014-12-09', '2014-12-09', NULL),
(56, 'TRASLADO Y CUSTODIA DE FONDOS Y VALORES', '2014-12-09', '2014-12-09', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_contacto`
--

CREATE TABLE IF NOT EXISTS `bdv_contacto` (
`id_contacto` int(11) NOT NULL,
  `primer_apellido` varchar(100) DEFAULT NULL,
  `segundo_apellido` varchar(100) DEFAULT NULL,
  `primer_nombre` varchar(100) DEFAULT NULL,
  `segundo_nombre` varchar(100) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `documento_identidad` varchar(50) DEFAULT NULL,
  `numero_identidad` varchar(50) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `area_ocupacional` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_contacto`
--

INSERT INTO `bdv_contacto` (`id_contacto`, `primer_apellido`, `segundo_apellido`, `primer_nombre`, `segundo_nombre`, `sexo`, `documento_identidad`, `numero_identidad`, `cargo`, `area_ocupacional`) VALUES
(1, 'PEREZ', 'MEZA', 'GEORGE', 'FELIX', 'MASCULINO', 'CEDULA DE CIUDADANIA', '18141034', 'DESARROLLADOR WEB', 'DESARROLLO WEB'),
(2, 'd', 'd', 'd', 'd', 'FEMENINO', 'CEDULA DE CIUDADANIA', '21313212', '1', '1'),
(3, 'd', 'd', 'd', 'd', 'FEMENINO', 'CEDULA DE CIUDADANIA', '21313212', '1', '1'),
(4, 'd', 'd', 'd', 'd', 'FEMENINO', 'CEDULA DE CIUDADANIA', '21313212', '1', '1'),
(5, '2', '2', '2', '2', 'FEMENINO', 'CEDULA DE CIUDADANIA', '23132213', '2', '2'),
(6, 'h', 'h', 'h', 'h', 'FEMENINO', 'CEDULA DE CIUDADANIA', '16735612', 'h', 'h');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_empresa`
--

CREATE TABLE IF NOT EXISTS `bdv_empresa` (
`id_empresa` int(11) NOT NULL,
  `tipo_persona` varchar(20) DEFAULT NULL,
  `origen` varchar(20) DEFAULT NULL,
  `ente` varchar(10) DEFAULT NULL,
  `tipo_rif` varchar(1) DEFAULT NULL,
  `rif` varchar(20) DEFAULT NULL,
  `id_nacionalidad` int(11) DEFAULT NULL,
  `id_naturaleza_cliente` int(11) DEFAULT NULL,
  `razon_social` varchar(100) DEFAULT NULL,
  `nombre_comercial` varchar(100) DEFAULT NULL,
  `pagina_web` varchar(100) DEFAULT NULL,
  `anio_inicio_actividades` int(4) DEFAULT NULL,
  `id_sector` int(11) DEFAULT NULL,
  `domicilio_tributario` varchar(100) DEFAULT NULL,
  `interseccion_referencia` varchar(100) DEFAULT NULL,
  `numero` varchar(100) DEFAULT NULL,
  `edificio_referencia` varchar(100) DEFAULT NULL,
  `departamento_oficina` varchar(100) DEFAULT NULL,
  `pais` varchar(50) DEFAULT NULL,
  `estado` int(4) DEFAULT NULL,
  `municipio` int(4) DEFAULT NULL,
  `parroquia` int(4) DEFAULT NULL,
  `tlf_oficina` varchar(20) DEFAULT NULL,
  `tlf_celular` varchar(20) DEFAULT NULL,
  `tlf_opcional` varchar(20) DEFAULT NULL,
  `id_contacto1` int(11) DEFAULT NULL,
  `id_contacto2` int(11) DEFAULT NULL,
  `id_contacto3` int(11) DEFAULT NULL,
  `id_representate_legal1` int(11) DEFAULT NULL,
  `id_representate_legal2` int(11) DEFAULT NULL,
  `id_representate_legal3` int(11) DEFAULT NULL,
  `id_banco_cuenta_vnz1` int(11) DEFAULT NULL,
  `id_banco_cuenta_vnz2` int(11) DEFAULT NULL,
  `id_banco_cuenta1` int(11) DEFAULT NULL,
  `id_banco_cuenta2` int(11) DEFAULT NULL,
  `id_banco_cuenta3` int(11) DEFAULT NULL,
  `otro_producto` varchar(100) DEFAULT NULL,
  `finalizo_registro` tinyint(1) NOT NULL DEFAULT '0',
  `id_recaudos` int(11) DEFAULT NULL,
  `empresa_aprobada` tinyint(1) NOT NULL DEFAULT '0',
  `activado_desactivado_por` varchar(50) DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_actualizado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fecha_activado_desactivado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_empresa`
--

INSERT INTO `bdv_empresa` (`id_empresa`, `tipo_persona`, `origen`, `ente`, `tipo_rif`, `rif`, `id_nacionalidad`, `id_naturaleza_cliente`, `razon_social`, `nombre_comercial`, `pagina_web`, `anio_inicio_actividades`, `id_sector`, `domicilio_tributario`, `interseccion_referencia`, `numero`, `edificio_referencia`, `departamento_oficina`, `pais`, `estado`, `municipio`, `parroquia`, `tlf_oficina`, `tlf_celular`, `tlf_opcional`, `id_contacto1`, `id_contacto2`, `id_contacto3`, `id_representate_legal1`, `id_representate_legal2`, `id_representate_legal3`, `id_banco_cuenta_vnz1`, `id_banco_cuenta_vnz2`, `id_banco_cuenta1`, `id_banco_cuenta2`, `id_banco_cuenta3`, `otro_producto`, `finalizo_registro`, `id_recaudos`, `empresa_aprobada`, `activado_desactivado_por`, `fecha_registro`, `fecha_actualizado`, `fecha_activado_desactivado`) VALUES
(1, 'NATURAL', 'NACIONAL', 'PUBLICO', 'V', '181410341', 1, 1, 'Inversiones Gs Technology CA', 'Inversiones Gs Technology CA', 'www.icomp.co.ve', 2012, 9, 'CARABALLEDA', '', '', '', '', 'VENEZUELA', 24, 359, 1479, '(0212) 613-0240', '(0426) 408-3981', '', 1, NULL, NULL, 1, NULL, NULL, 1, NULL, 1, NULL, NULL, 'ninguno', 1, NULL, 0, NULL, '2015-01-22 03:29:25', '2015-01-31 19:48:38', '2015-01-31 19:48:38'),
(2, 'NATURAL', 'NACIONAL', 'PUBLICO', 'V', '213131231', 1, 1, '1', 'Inversiones Pepito', '', 1900, 1, '2', '', '', '', '', 'VENEZUELA', 1, 128, 692, '(2312) 313-1231', '', '', 2, NULL, NULL, 2, NULL, NULL, 2, NULL, 2, NULL, NULL, 'ninguno', 0, 1, 0, NULL, '2015-01-28 01:07:05', '2015-01-31 19:48:43', '2015-01-31 19:48:43'),
(3, 'NATURAL', 'NACIONAL', 'PUBLICO', 'V', '213131231', 1, 1, '1', 'Inversiones Pepito', '', 1900, 1, '2', '', '', '', '', 'VENEZUELA', 1, 128, 692, '(2312) 313-1231', '', '', 3, NULL, NULL, 3, NULL, NULL, 3, NULL, 3, NULL, NULL, 'ninguno', 0, 2, 0, NULL, '2015-01-28 01:07:05', '2015-01-31 19:48:49', '2015-01-31 19:48:49'),
(4, 'NATURAL', 'NACIONAL', 'PUBLICO', 'V', '213131231', 1, 1, '1', 'Inversiones Pepito', '', 1900, 1, '2', '', '', '', '', 'VENEZUELA', 1, 128, 692, '(2312) 313-1231', '', '', 4, NULL, NULL, 4, NULL, NULL, 4, NULL, 4, NULL, NULL, 'ninguno', 0, 3, 0, NULL, '2015-01-28 01:07:05', '2015-01-31 19:48:54', '2015-01-31 19:48:54'),
(5, 'NATURAL', 'NACIONAL', 'PUBLICO', 'V', '152435143', 1, 1, '1', 'Inversiones Pepito', '', 1900, 1, 'g', '', '', '', '', 'VENEZUELA', 1, 128, 692, '(1534) 153-4514', '', '', 5, NULL, NULL, 5, NULL, NULL, 5, NULL, 5, NULL, NULL, 'ninguno', 1, 4, 0, NULL, '2015-01-28 01:19:41', '2015-01-31 19:48:57', '2015-01-31 19:48:57'),
(6, 'NATURAL', 'NACIONAL', 'PUBLICO', 'V', '999999999', 1, 1, '1', 'Pepito Pimentel', '', 1900, 1, 'Caracas', '', '', '', '', 'VENEZUELA', 1, 128, 692, '(1231) 231-2312', '', '', 6, NULL, NULL, 6, NULL, NULL, 6, NULL, 6, NULL, NULL, 'no', 1, 5, 0, NULL, '2015-01-28 01:26:34', '2015-01-31 19:49:01', '2015-01-31 19:49:01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_empresa_categoria_producto`
--

CREATE TABLE IF NOT EXISTS `bdv_empresa_categoria_producto` (
  `id_empresa` int(11) NOT NULL,
  `id_categoria_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_empresa_categoria_producto`
--

INSERT INTO `bdv_empresa_categoria_producto` (`id_empresa`, `id_categoria_producto`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2),
(1, 3),
(2, 3),
(3, 3),
(4, 3),
(6, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_mcbe_ubic_geo`
--

CREATE TABLE IF NOT EXISTS `bdv_mcbe_ubic_geo` (
  `id_ubic_geo` int(4) NOT NULL,
  `descripcion` varchar(256) NOT NULL,
  `nivel` int(4) NOT NULL,
  `id_padre` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_mcbe_ubic_geo`
--

INSERT INTO `bdv_mcbe_ubic_geo` (`id_ubic_geo`, `descripcion`, `nivel`, `id_padre`) VALUES
(1, 'DISTRITO CAPITAL', 1, 0),
(2, 'AMAZONAS', 1, 0),
(3, 'ANZOATEGUI', 1, 0),
(4, 'APURE', 1, 0),
(5, 'ARAGUA', 1, 0),
(6, 'BARINAS', 1, 0),
(7, 'BOLIVAR', 1, 0),
(8, 'CARABOBO', 1, 0),
(9, 'COJEDES', 1, 0),
(10, 'DELTA AMACURO', 1, 0),
(11, 'FALCON', 1, 0),
(12, 'GUARICO', 1, 0),
(13, 'LARA', 1, 0),
(14, 'MERIDA', 1, 0),
(15, 'MIRANDA', 1, 0),
(16, 'MONAGAS', 1, 0),
(17, 'NUEVA ESPARTA', 1, 0),
(18, 'PORTUGUESA', 1, 0),
(19, 'SUCRE', 1, 0),
(20, 'TACHIRA', 1, 0),
(21, 'TRUJILLO', 1, 0),
(22, 'YARACUY', 1, 0),
(23, 'ZULIA', 1, 0),
(24, 'VARGAS', 1, 0),
(25, 'Alto Orinoco', 2, 2),
(26, 'Atabapo', 2, 2),
(27, 'Atures', 2, 2),
(28, 'Autana', 2, 2),
(29, 'Manapiare', 2, 2),
(30, 'Maroa', 2, 2),
(31, 'Río Negro', 2, 2),
(32, 'Anaco', 2, 3),
(33, 'Aragua', 2, 3),
(34, 'Diego Bautista Urbaneja', 2, 3),
(35, 'Fernando de Peñalver', 2, 3),
(36, 'Francisco de Carmen Carvajal', 2, 3),
(37, 'Francisco de Miranda', 2, 3),
(38, 'Guanta', 2, 3),
(39, 'Independencia', 2, 3),
(40, 'José Gregorio Monagas', 2, 3),
(41, 'Juan Antonio Sotillo', 2, 3),
(42, 'Juan Manuel Cajigal', 2, 3),
(43, 'Libertad', 2, 3),
(44, 'Manuel Ezequiel Bruzual', 2, 3),
(45, 'Pedro María Freites', 2, 3),
(46, 'Píritu', 2, 3),
(47, 'San José de Guanipa', 2, 3),
(48, 'San Juan de Capistrano', 2, 3),
(49, 'Santa Ana', 2, 3),
(50, 'Simón Bolívar', 2, 3),
(51, 'Simón Rodríguez', 2, 3),
(52, 'Sir Artur McGregor', 2, 3),
(53, 'Achaguas', 2, 4),
(54, 'Biruaca', 2, 4),
(55, 'Muñoz', 2, 4),
(56, 'Páez', 2, 4),
(57, 'Pedro Camejo', 2, 4),
(58, 'Rómulo Gallegos', 2, 4),
(59, 'San Fernando', 2, 4),
(60, 'Bolívar', 2, 5),
(61, 'Camatagua', 2, 5),
(62, 'Francisco Linares Alcántara', 2, 5),
(63, 'Girardot', 2, 5),
(64, 'José ángel Lamas', 2, 5),
(65, 'José Félix Ribas', 2, 5),
(66, 'José Rafael Revenga', 2, 5),
(67, 'Libertador', 2, 5),
(68, 'Mario Briceño Iragorry', 2, 5),
(69, 'Ocumare de la Costa de Oro', 2, 5),
(70, 'San Casimiro', 2, 5),
(71, 'San Sebastián', 2, 5),
(72, 'Santiago Mariño', 2, 5),
(73, 'Santos Michelena', 2, 5),
(74, 'Sucre', 2, 5),
(75, 'Tovar', 2, 5),
(76, 'Urdaneta', 2, 5),
(77, 'Zamora', 2, 5),
(78, 'Alberto Arvelo Torrealba', 2, 6),
(79, 'Andrés Eloy Blanco', 2, 6),
(80, 'Antonio José de Sucre', 2, 6),
(81, 'Arismendi', 2, 6),
(82, 'Barinas', 2, 6),
(83, 'Bolívar', 2, 6),
(84, 'Cruz Paredes', 2, 6),
(85, 'Ezequiel Zamora', 2, 6),
(86, 'Obispos', 2, 6),
(87, 'Pedraza', 2, 6),
(88, 'Rojas', 2, 6),
(89, 'Sosa ', 2, 6),
(90, 'Caroní', 2, 7),
(91, 'Cedeño', 2, 7),
(92, 'El Callao', 2, 7),
(93, 'Gran Sabana', 2, 7),
(94, 'Heres', 2, 7),
(95, 'Padre Pedro Chien', 2, 7),
(96, 'Piar', 2, 7),
(97, 'Raúl Leoni', 2, 7),
(98, 'Roscio', 2, 7),
(99, 'Sifontes', 2, 7),
(100, 'Sucre', 2, 7),
(101, 'Bejuma', 2, 8),
(102, 'Carlos Arvelo', 2, 8),
(103, 'Diego Ibarra', 2, 8),
(104, 'Guacara', 2, 8),
(105, 'Juan José Mora', 2, 8),
(106, 'Libertador', 2, 8),
(107, 'Los Guayos', 2, 8),
(108, 'Miranda', 2, 8),
(109, 'Montalbán', 2, 8),
(110, 'Naguanagua', 2, 8),
(111, 'Puerto Cabello', 2, 8),
(112, 'San Diego', 2, 8),
(113, 'San Joaquín', 2, 8),
(114, 'Valencia', 2, 8),
(115, 'Anzoátegui', 2, 9),
(116, 'El Pao de San Juan Bautista', 2, 9),
(117, 'Falcón', 2, 9),
(118, 'Girardot', 2, 9),
(119, 'Lima Blanco', 2, 9),
(120, 'Ricaurte', 2, 9),
(121, 'Rómulo Gallegos', 2, 9),
(122, 'Ezequiel Zamora', 2, 9),
(123, 'Tinaco', 2, 9),
(124, 'Antonio Díaz', 2, 10),
(125, 'Casacoima', 2, 10),
(126, 'Pedernales', 2, 10),
(127, 'Tucupita', 2, 10),
(128, 'Libertador', 2, 1),
(129, 'Acosta', 2, 11),
(130, 'Bolívar', 2, 11),
(131, 'Buchivacoa', 2, 11),
(132, 'Cacique Manaure', 2, 11),
(133, 'Carirubana', 2, 11),
(134, 'Colina', 2, 11),
(135, 'Dabajuro', 2, 11),
(136, 'Democracia', 2, 11),
(137, 'Falcón', 2, 11),
(138, 'Federación', 2, 11),
(139, 'Jacura', 2, 11),
(140, 'Los Taques', 2, 11),
(141, 'Mauroa', 2, 11),
(142, 'Miranda', 2, 11),
(143, 'Monseñor Iturriza', 2, 11),
(144, 'Palmasola', 2, 11),
(145, 'Petit', 2, 11),
(146, 'Píritu', 2, 11),
(147, 'San Francisco', 2, 11),
(148, 'Silva', 2, 11),
(149, 'Sucre', 2, 11),
(150, 'Tocópero', 2, 11),
(151, 'Unión', 2, 11),
(152, 'Urumaco', 2, 11),
(153, 'Zamora', 2, 11),
(154, 'Camaguán', 2, 12),
(155, 'Chaguaramas', 2, 12),
(156, 'El Socorro', 2, 12),
(157, 'Francisco de Miranda', 2, 12),
(158, 'José Félix Ribas', 2, 12),
(159, 'José Tadeo Monagas', 2, 12),
(160, 'Juan Germán Roscio', 2, 12),
(161, 'Julián Mellado', 2, 12),
(162, 'Las Mercedes', 2, 12),
(163, 'Leonardo Infante', 2, 12),
(164, 'Ortiz', 2, 12),
(165, 'Pedro Zaraza', 2, 12),
(166, 'San Gerónimo de Guayabal', 2, 12),
(167, 'San José de Guaribe', 2, 12),
(168, 'Santa María de Ipire', 2, 12),
(169, 'Andrés Eloy Blanco', 2, 13),
(170, 'Crespo', 2, 13),
(171, 'Iribarren', 2, 13),
(172, 'Jiménez', 2, 13),
(173, 'Morán', 2, 13),
(174, 'Palavecino', 2, 13),
(175, 'Simón Planas', 2, 13),
(176, 'Torres', 2, 13),
(177, 'Urdaneta', 2, 13),
(178, 'Alberto Adriani', 2, 14),
(179, 'Andrés Bello', 2, 14),
(180, 'Antonio Pinto Salinas', 2, 14),
(181, 'Aricagua', 2, 14),
(182, 'Arzobispo Chacón', 2, 14),
(183, 'Campo Elías', 2, 14),
(184, 'Caracciolo Parra Olmedo', 2, 14),
(185, 'Cardenal Quintero', 2, 14),
(186, 'Guaraque', 2, 14),
(187, 'Julio César Salas', 2, 14),
(188, 'Justo Briceño', 2, 14),
(189, 'Libertador', 2, 14),
(190, 'Miranda', 2, 14),
(191, 'Obispo Ramos de Lora', 2, 14),
(192, 'Padre Noguera', 2, 14),
(193, 'Pueblo Llano', 2, 14),
(194, 'Rangel', 2, 14),
(195, 'Rivas Dávila', 2, 14),
(196, 'Santos Marquina', 2, 14),
(197, 'Sucre', 2, 14),
(198, 'Tovar', 2, 14),
(199, 'Tulio Febres Cordero', 2, 14),
(200, 'Zea', 2, 14),
(201, 'Acevedo', 2, 15),
(202, 'Andrés Bello', 2, 15),
(203, 'Baruta', 2, 15),
(204, 'Brión', 2, 15),
(205, 'Buroz', 2, 15),
(206, 'Carrizal', 2, 15),
(207, 'Chacao', 2, 15),
(208, 'Cristóbal Rojas', 2, 15),
(209, 'El Hatillo', 2, 15),
(210, 'Guaicaipuro', 2, 15),
(211, 'Independencia', 2, 15),
(212, 'Lander', 2, 15),
(213, 'Los Salias', 2, 15),
(214, 'Páez', 2, 15),
(215, 'Paz Castillo', 2, 15),
(216, 'Pedro Gual', 2, 15),
(217, 'Plaza', 2, 15),
(218, 'Simón Bolívar', 2, 15),
(219, 'Sucre', 2, 15),
(220, 'Urdaneta', 2, 15),
(221, 'Zamora', 2, 15),
(222, 'Acosta', 2, 16),
(223, 'Aguasay', 2, 16),
(224, 'Bolívar', 2, 16),
(225, 'Caripe', 2, 16),
(226, 'Cedeño', 2, 16),
(227, 'Ezequiel Zamora', 2, 16),
(228, 'Libertador', 2, 16),
(229, 'Maturín', 2, 16),
(230, 'Piar', 2, 16),
(231, 'Punceres', 2, 16),
(232, 'Santa Bárbara', 2, 16),
(233, 'Sotillo', 2, 16),
(234, 'Uracoa', 2, 16),
(235, 'Antolín del Campo', 2, 17),
(236, 'Arismendi', 2, 17),
(237, 'Díaz', 2, 17),
(238, 'García', 2, 17),
(239, 'Gómez', 2, 17),
(240, 'Maneiro', 2, 17),
(241, 'Marcano', 2, 17),
(242, 'Mariño', 2, 17),
(243, 'Península de Macanao', 2, 17),
(244, 'Tubores', 2, 17),
(245, 'Villalba', 2, 17),
(246, 'Agua Blanca', 2, 18),
(247, 'Araure', 2, 18),
(248, 'Esteller', 2, 18),
(249, 'Guanare', 2, 18),
(250, 'Guanarito', 2, 18),
(251, 'Monseñor José Vicente de Unda', 2, 18),
(252, 'Ospino', 2, 18),
(253, 'Páez', 2, 18),
(254, 'Papelón', 2, 18),
(255, 'San Genaro de Boconoito', 2, 18),
(256, 'San Rafael de Onoto', 2, 18),
(257, 'Santa Rosalía', 2, 18),
(258, 'Sucre', 2, 18),
(259, 'Turén', 2, 18),
(260, 'Andrés Eloy Blanco', 2, 19),
(261, 'Andrés Mata', 2, 19),
(262, 'Arismendi', 2, 19),
(263, 'Benítez', 2, 19),
(264, 'Bermúdez', 2, 19),
(265, 'Bolívar', 2, 19),
(266, 'Cajigal', 2, 19),
(267, 'Cruz Salmerón Acosta', 2, 19),
(268, 'Libertador', 2, 19),
(269, 'Mariño', 2, 19),
(270, 'Mejía', 2, 19),
(271, 'Montes', 2, 19),
(272, 'Ribero', 2, 19),
(273, 'Sucre', 2, 19),
(274, 'Valdez', 2, 19),
(275, 'Andrés Bello', 2, 20),
(276, 'Antonio Rómulo Costa', 2, 20),
(277, 'Ayacucho', 2, 20),
(278, 'Bolívar', 2, 20),
(279, 'Cárdenas', 2, 20),
(280, 'Córdoba', 2, 20),
(281, 'Fernández Feo', 2, 20),
(282, 'Francisco de Miranda', 2, 20),
(283, 'García de Hevia', 2, 20),
(284, 'Guasimos', 2, 20),
(285, 'Independencia', 2, 20),
(286, 'Jáuregui', 2, 20),
(287, 'Jose Maria Vargas', 2, 20),
(288, 'Junín', 2, 20),
(289, 'Libertad', 2, 20),
(290, 'Libertador', 2, 20),
(291, 'Lobatera', 2, 20),
(292, 'Michelena', 2, 20),
(293, 'Panamericano', 2, 20),
(294, 'Pedro Maria Ureña', 2, 20),
(295, 'Rafael Urdaneta', 2, 20),
(296, 'Samuel Darío Maldonado', 2, 20),
(297, 'San Cristóbal', 2, 20),
(298, 'San Judas Tadeo', 2, 20),
(299, 'Seboruco', 2, 20),
(300, 'Simón Rodríguez', 2, 20),
(301, 'Sucre', 2, 20),
(302, 'Torbes', 2, 20),
(303, 'Uribante', 2, 20),
(304, 'Andrés Bello', 2, 21),
(305, 'Boconó', 2, 21),
(306, 'Bolívar', 2, 21),
(307, 'Candelaria', 2, 21),
(308, 'Carache', 2, 21),
(309, 'Escuque', 2, 21),
(310, 'José Felipe Márquez Cañizales', 2, 21),
(311, 'José Vicente Campo Elías', 2, 21),
(312, 'La Ceiba', 2, 21),
(313, 'Miranda', 2, 21),
(314, 'Monte Carmelo', 2, 21),
(315, 'Motatán', 2, 21),
(316, 'Pampán', 2, 21),
(317, 'Pampanito', 2, 21),
(318, 'Rafael Rangel', 2, 21),
(319, 'San Rafael de Carvajal', 2, 21),
(320, 'Sucre', 2, 21),
(321, 'Trujillo', 2, 21),
(322, 'Urdaneta', 2, 21),
(323, 'Valera', 2, 21),
(324, 'Arístides Bastidas', 2, 22),
(325, 'Bolívar', 2, 22),
(326, 'Bruzual', 2, 22),
(327, 'Cocorote', 2, 22),
(328, 'Independencia', 2, 22),
(329, 'Jose Antonio Páez', 2, 22),
(330, 'La Trinidad', 2, 22),
(331, 'Manuel Monge', 2, 22),
(332, 'Nirgua', 2, 22),
(333, 'Peña', 2, 22),
(334, 'San Felipe', 2, 22),
(335, 'Sucre', 2, 22),
(336, 'Urachiche', 2, 22),
(337, 'Veroes', 2, 22),
(338, 'Almirante Padilla', 2, 23),
(339, 'Baralt', 2, 23),
(340, 'Cabimas', 2, 23),
(341, 'Catatumbo', 2, 23),
(342, 'Colón', 2, 23),
(343, 'Francisco Javier Pulgar', 2, 23),
(344, 'Jesús Enrique Losada', 2, 23),
(345, 'Jesús María Semprún', 2, 23),
(346, 'La Cañada de Urdaneta', 2, 23),
(347, 'Lagunillas', 2, 23),
(348, 'Machiques de Perijá', 2, 23),
(349, 'Mara', 2, 23),
(350, 'Maracaibo', 2, 23),
(351, 'Miranda', 2, 23),
(352, 'Guajira', 2, 23),
(353, 'Rosario de Perijá', 2, 23),
(354, 'San Francisco', 2, 23),
(355, 'Santa Rita', 2, 23),
(356, 'Simón Bolívar', 2, 23),
(357, 'Sucre', 2, 23),
(358, 'Valmore Rodríguez', 2, 23),
(359, 'Vargas', 2, 24),
(360, 'Huachamacare', 3, 25),
(361, 'La Esmeralda', 3, 25),
(362, 'Marawaka', 3, 25),
(363, 'Mavaca', 3, 25),
(364, 'Sierra Parima', 3, 25),
(365, 'Caname', 3, 26),
(366, 'San Fernando de Ataba', 3, 26),
(367, 'Ucata', 3, 26),
(368, 'Yapacana', 3, 26),
(369, 'Fernando Giron Tovar', 3, 27),
(370, 'Luis Alberto Gomez', 3, 27),
(371, 'Parhueña', 3, 27),
(372, 'Platanillal', 3, 27),
(373, 'Guayapo', 3, 28),
(374, 'Isla de Raton', 3, 28),
(375, 'Munduapo', 3, 28),
(376, 'Samariapo', 3, 28),
(377, 'Sipapo', 3, 28),
(378, 'Alto Ventuari', 3, 29),
(379, 'Bajo Ventuari', 3, 29),
(380, 'Medio Ventuari', 3, 29),
(381, 'San Juan de Manapiare', 3, 29),
(382, 'Comunidad', 3, 30),
(383, 'Maroa', 3, 30),
(384, 'Victorino', 3, 30),
(385, 'Casiquiare', 3, 31),
(386, 'Cocuy', 3, 31),
(387, 'San Carlos de Rio Neg', 3, 31),
(388, 'Solano', 3, 31),
(389, 'Anaco', 3, 32),
(390, 'San Joaquin', 3, 32),
(391, 'Aragua de Barcelona', 3, 33),
(392, 'Cachipo', 3, 33),
(393, 'El Morro', 3, 34),
(394, 'Lecherias', 3, 34),
(395, 'Puerto Piritu', 3, 35),
(396, 'San Miguel', 3, 35),
(397, 'Sucre', 3, 35),
(398, 'Santa Barbara', 3, 36),
(399, 'Valle Guanape', 3, 36),
(400, 'Atapirire', 3, 37),
(401, 'Boca del Pao', 3, 37),
(402, 'El Pao', 3, 37),
(403, 'Pariaguan', 3, 37),
(404, 'Chorreron', 3, 38),
(405, 'Guanta', 3, 38),
(406, 'Mamo', 3, 39),
(407, 'Soledad', 3, 39),
(408, 'Mapire', 3, 40),
(409, 'Piar', 3, 40),
(410, 'Santa Clara', 3, 40),
(411, 'San diego de cabrutica', 3, 40),
(412, 'Uverito', 3, 40),
(413, 'Zuata', 3, 40),
(414, 'Pozuelos', 3, 41),
(415, 'Puerto la Cruz', 3, 41),
(416, 'Onoto', 3, 42),
(417, 'San Pablo', 3, 42),
(418, 'El Carito', 3, 43),
(419, 'San Mateo', 3, 43),
(420, 'Santa Ines', 3, 43),
(421, 'Clarines', 3, 44),
(422, 'Guanape', 3, 44),
(423, 'Sabana de Uchire', 3, 44),
(424, 'Cantaura', 3, 45),
(425, 'Libertador', 3, 45),
(426, 'Santa Rosa', 3, 45),
(427, 'Urica', 3, 45),
(428, 'Piritu', 3, 46),
(429, 'San Francisco', 3, 46),
(430, 'San Jose de Guanipa', 3, 47),
(431, 'Boca de Chavez', 3, 48),
(432, 'Boca Uchire', 3, 48),
(433, 'Pueblo Nuevo', 3, 49),
(434, 'Santa Ana', 3, 49),
(435, 'Bergantin', 3, 50),
(436, 'Caigua', 3, 50),
(437, 'El Carmen', 3, 50),
(438, 'El Pilar', 3, 50),
(439, 'Naricual', 3, 50),
(440, 'San Cristobal', 3, 50),
(441, 'El Tigre', 3, 51),
(442, 'El Chaparro', 3, 52),
(443, 'Tomas Alfaro Calatrava', 3, 52),
(444, 'Achaguas', 3, 53),
(445, 'Apurito', 3, 53),
(446, 'El Yagual', 3, 53),
(447, 'Guachara', 3, 53),
(448, 'Mucuritas', 3, 53),
(449, 'Queseras del Medio', 3, 53),
(450, 'Biruaca', 3, 54),
(451, 'Bruzual', 3, 55),
(452, 'Mantecal', 3, 55),
(453, 'Quintero', 3, 55),
(454, 'Rincon Hondo', 3, 55),
(455, 'San Vicente', 3, 55),
(456, 'Aramendi', 3, 56),
(457, 'El Amparo', 3, 56),
(458, 'Guasdualito', 3, 56),
(459, 'San Camilo', 3, 56),
(460, 'Urdaneta', 3, 56),
(461, 'Codazzi', 3, 57),
(462, 'Cunaviche', 3, 57),
(463, 'San Juan de Payara', 3, 57),
(464, 'Elorza', 3, 58),
(465, 'La Trinidad', 3, 58),
(466, 'El Recreo', 3, 59),
(467, 'Peñalver', 3, 59),
(468, 'San fernando', 3, 59),
(469, 'San Rafael de Atamaica', 3, 59),
(470, 'San Mateo', 3, 60),
(471, 'Camatagua', 3, 61),
(472, 'Carmen De Cura', 3, 61),
(473, 'Francisco De Miranda', 3, 62),
(474, 'Mons Feliciano G', 3, 62),
(475, 'Santa Rita', 3, 62),
(476, 'Andres Eloy Blanco', 3, 63),
(477, 'Choroni', 3, 63),
(478, 'Joaquin Crespo', 3, 63),
(479, 'Jose Casanova Godoy', 3, 63),
(480, 'Las Delicias', 3, 63),
(481, 'Los Tacariguas', 3, 63),
(482, 'Madre Ma De San Jose', 3, 63),
(483, 'Pedro Jose Ovalles', 3, 63),
(484, 'Santa Cruz', 3, 64),
(485, 'Castor Nieves Rios', 3, 65),
(486, 'Las Guacamayas', 3, 65),
(487, 'La Victoria', 3, 65),
(488, 'Pao De Zarate', 3, 65),
(489, 'Zuata', 3, 65),
(490, 'El Consejo', 3, 66),
(491, 'Palo Negro', 3, 67),
(492, 'San Martin De Porres', 3, 67),
(493, 'Caña De Azucar', 3, 68),
(494, 'El Limon', 3, 68),
(495, 'Ocumare De La Costa', 3, 69),
(496, 'Guiripa', 3, 70),
(497, 'Ollas De Caramacate', 3, 70),
(498, 'San Casimiro', 3, 70),
(499, 'Valle Morin', 3, 70),
(500, 'San Sebastian', 3, 71),
(501, 'Alfredo Pacheco M', 3, 72),
(502, 'Arevalo Aponte', 3, 72),
(503, 'Chuao', 3, 72),
(504, 'Saman De Guere', 3, 72),
(505, 'Turmero', 3, 72),
(506, 'Las Tejerias', 3, 73),
(507, 'Tiara', 3, 73),
(508, 'Bella Vista', 3, 74),
(509, 'Cagua', 3, 74),
(510, 'Colonia Tovar', 3, 75),
(511, 'Barbacoas', 3, 76),
(512, 'Las Peñitas', 3, 76),
(513, 'San Francisco De Cara', 3, 76),
(514, 'Taguay', 3, 76),
(515, 'Augusto Mijares', 3, 77),
(516, 'Magdaleno', 3, 77),
(517, 'San Francisco De Asis', 3, 77),
(518, 'Valles De Tucutunemo', 3, 77),
(519, 'Villa De Cura', 3, 77),
(520, 'Rodriguez Dominguez', 3, 78),
(521, 'Sabaneta', 3, 78),
(522, 'El Canton', 3, 79),
(523, 'Puerto Vivas', 3, 79),
(524, 'Santa Cruz De Guacas', 3, 79),
(525, 'Andres Bello', 3, 80),
(526, 'Nicolas Pulido', 3, 80),
(527, 'Ticoporo', 3, 80),
(528, 'Arismendi', 3, 81),
(529, 'Guadarrama', 3, 81),
(530, 'La Union', 3, 81),
(531, 'San Antonio', 3, 81),
(532, 'Alfredo A Larriva', 3, 82),
(533, 'Alto Barinas', 3, 82),
(534, 'Barinas', 3, 82),
(535, 'Corazon De Jesus', 3, 82),
(536, 'Dominga Ortiz P', 3, 82),
(537, 'El Carmen', 3, 82),
(538, 'Juan A Rodriguez D', 3, 82),
(539, 'Manuel P Fajardo', 3, 82),
(540, 'Ramon I Mendez', 3, 82),
(541, 'Romulo Betancourt', 3, 82),
(542, 'San Silvestre', 3, 82),
(543, 'Santa Ines', 3, 82),
(544, 'Santa Lucia', 3, 82),
(545, 'Torunos', 3, 82),
(546, 'Altamira', 3, 83),
(547, 'Barinitas', 3, 83),
(548, 'Calderas', 3, 83),
(549, 'Barrancas', 3, 84),
(550, 'El Socorro', 3, 84),
(551, 'Masparrito', 3, 84),
(552, 'Jose Ignacio Del Pumar', 3, 85),
(553, 'Pedro Briceño Mendez', 3, 85),
(554, 'Ramon Ignacio Mendez', 3, 85),
(555, 'Santa Barbara', 3, 85),
(556, 'El Real', 3, 86),
(557, 'La Luz', 3, 86),
(558, 'Los Guasimitos', 3, 86),
(559, 'Obispos', 3, 86),
(560, 'Ciudad Bolivia', 3, 87),
(561, 'Ignacio Briceño', 3, 87),
(562, 'Jose Felix Ribas', 3, 87),
(563, 'Paez', 3, 87),
(564, 'Dolores', 3, 88),
(565, 'Libertad', 3, 88),
(566, 'Palacio Fajardo', 3, 88),
(567, 'Santa Rosa', 3, 88),
(568, 'Ciudad De Nutrias', 3, 89),
(569, 'El Regalo', 3, 89),
(570, 'Puerto De Nutrias', 3, 89),
(571, 'Santa Catalina', 3, 89),
(572, 'Cachamay', 3, 90),
(573, 'Chirica', 3, 90),
(574, 'Dalla Costa', 3, 90),
(575, 'Once De Abril', 3, 90),
(576, 'Pozo Verde', 3, 90),
(577, 'Simon Bolivar', 3, 90),
(578, 'Unare', 3, 90),
(579, 'Universidad', 3, 90),
(580, 'Vista Al Sol', 3, 90),
(581, 'Yocoima', 3, 90),
(582, 'Altagracia', 3, 91),
(583, 'Ascension Farreras', 3, 91),
(584, 'Caicara Del Orinoco', 3, 91),
(585, 'Guaniamo', 3, 91),
(586, 'La Urbana', 3, 91),
(587, 'Pijiguaos', 3, 91),
(588, 'El Callao', 3, 92),
(589, 'Ikabaru', 3, 93),
(590, 'Santa Elena De Uairen', 3, 93),
(591, 'Agua Salada', 3, 94),
(592, 'Catedral', 3, 94),
(593, 'Jose Antonio Paez', 3, 94),
(594, 'La Sabanita', 3, 94),
(595, 'Marhuanta', 3, 94),
(596, 'Orinoco', 3, 94),
(597, 'Panapana', 3, 94),
(598, 'Vista Hermosa', 3, 94),
(599, 'Zea', 3, 94),
(600, 'El Palmar', 3, 95),
(601, 'Andres Eloy Blanco', 3, 96),
(602, 'Pedro Cova', 3, 96),
(603, 'Upata', 3, 96),
(604, 'Barceloneta', 3, 97),
(605, 'Ciudad Piar', 3, 97),
(606, 'San Francisco', 3, 97),
(607, 'Santa Barbara', 3, 97),
(608, 'Guasipati', 3, 98),
(609, 'Salom', 3, 98),
(610, 'Dalla Costa', 3, 99),
(611, 'San Isidro', 3, 99),
(612, 'Tumeremo', 3, 99),
(613, 'Aripao', 3, 100),
(614, 'Guarataro', 3, 100),
(615, 'Las Majadas', 3, 100),
(616, 'Maripa', 3, 100),
(617, 'Moitaco', 3, 100),
(618, 'Bejuma', 3, 101),
(619, 'Canoabo', 3, 101),
(620, 'Simon Bolivar', 3, 101),
(621, 'Belen', 3, 102),
(622, 'Guigue', 3, 102),
(623, 'Tacarigua', 3, 102),
(624, 'Aguas Calientes', 3, 103),
(625, 'Mariara', 3, 103),
(626, 'Ciudad Alianza', 3, 104),
(627, 'Guacara', 3, 104),
(628, 'Yagua', 3, 104),
(629, 'Moron', 3, 105),
(630, 'Urama', 3, 105),
(631, 'Independencia', 3, 106),
(632, 'Tocuyito', 3, 106),
(633, 'Los Guayos', 3, 107),
(634, 'Miranda', 3, 108),
(635, 'Montalban', 3, 109),
(636, 'Naguanagua', 3, 110),
(637, 'Bartolome Salom', 3, 111),
(638, 'Borburata', 3, 111),
(639, 'Democracia', 3, 111),
(640, 'Fraternidad', 3, 111),
(641, 'Goaigoaza', 3, 111),
(642, 'Juan Jose Flores', 3, 111),
(643, 'Patanemo', 3, 111),
(644, 'Unión', 3, 111),
(645, 'San Diego', 3, 112),
(646, 'San Joaquin', 3, 113),
(647, 'Candelaria', 3, 114),
(648, 'Catedral', 3, 114),
(649, 'El Socorro', 3, 114),
(650, 'Miguel Peña', 3, 114),
(651, 'Negro Primero', 3, 114),
(652, 'Rafael Urdaneta', 3, 114),
(653, 'San Blas', 3, 114),
(654, 'San Jose', 3, 114),
(655, 'Santa Rosa', 3, 114),
(656, 'Cojedes', 3, 115),
(657, 'Juan De Mata Suarez', 3, 115),
(658, 'El Pao', 3, 116),
(659, 'Tinaquillo', 3, 117),
(660, 'El Baul', 3, 118),
(661, 'Sucre', 3, 118),
(662, 'La Aguadita', 3, 119),
(663, 'Macapo', 3, 119),
(664, 'El Amparo', 3, 120),
(665, 'Libertad De Cojedes', 3, 120),
(666, 'Rómulo Gallegos', 3, 121),
(667, 'Juan Angel Bravo', 3, 122),
(668, 'Manuel Manrique', 3, 122),
(669, 'San Carlos De Austria', 3, 122),
(670, 'Grl/Jefe Jose L Silva', 3, 123),
(671, 'Almirante Luis Brion', 3, 124),
(672, 'Aniceto Lugo', 3, 124),
(673, 'Curiapo', 3, 124),
(674, 'Manuel Renaud', 3, 124),
(675, 'Padre Barral', 3, 124),
(676, 'Santos De Abelgas', 3, 124),
(677, '5 De Julio', 3, 125),
(678, 'Imataca', 3, 125),
(679, 'Juan Bautista Arismen', 3, 125),
(680, 'Manuel Piar', 3, 125),
(681, 'Romulo Gallegos', 3, 125),
(682, 'Luis B Prieto Figuero', 3, 126),
(683, 'Pedernales', 3, 126),
(684, 'Jose Vidal Marcano', 3, 127),
(685, 'Juan Millan', 3, 127),
(686, 'Leonardo Ruiz Pineda', 3, 127),
(687, 'Mcl.Antonio J De Sucre', 3, 127),
(688, 'Mons. Argimiro Garcia', 3, 127),
(689, 'San Jose', 3, 127),
(690, 'San Rafael', 3, 127),
(691, 'Virgen Del Valle', 3, 127),
(692, 'Santa Rosalía', 3, 128),
(693, 'El Valle', 3, 128),
(694, 'Coche', 3, 128),
(695, 'Caricuao', 3, 128),
(696, 'Macarao', 3, 128),
(697, 'Antímano', 3, 128),
(698, 'La Vega', 3, 128),
(699, 'El Paraíso', 3, 128),
(700, 'El Junquito', 3, 128),
(701, 'Sucre', 3, 128),
(702, 'San Juan', 3, 128),
(703, 'Santa Teresa', 3, 128),
(704, '23 De Enero', 3, 128),
(705, 'La Pastora', 3, 128),
(706, 'Altagracia', 3, 128),
(707, 'San José', 3, 128),
(708, 'San Bernardino', 3, 128),
(709, 'Catedral', 3, 128),
(710, 'La Candelaria', 3, 128),
(711, 'San Agustín', 3, 128),
(712, 'El Recreo', 3, 128),
(713, 'San Pedro', 3, 128),
(714, 'Capadare', 3, 129),
(715, 'La Pastora', 3, 129),
(716, 'Libertador', 3, 129),
(717, 'San Juan De Los Cayos', 3, 129),
(718, 'Aracua', 3, 130),
(719, 'La Peña', 3, 130),
(720, 'San Luis', 3, 130),
(721, 'Bariro', 3, 131),
(722, 'Borojo', 3, 131),
(723, 'Capatarida', 3, 131),
(724, 'Guajiro', 3, 131),
(725, 'Seque', 3, 131),
(726, 'Zazarida', 3, 131),
(727, 'Yaracal', 3, 132),
(728, 'Carirubana', 3, 133),
(729, 'Norte', 3, 133),
(730, 'Punta Cardon', 3, 133),
(731, 'Santa Ana', 3, 133),
(732, 'Acurigua', 3, 134),
(733, 'Guaibacoa', 3, 134),
(734, 'Las Calderas', 3, 134),
(735, 'La Vela De Coro', 3, 134),
(736, 'Macoruca', 3, 134),
(737, 'Dabajuro', 3, 135),
(738, 'Agua Clara', 3, 136),
(739, 'Avaria', 3, 136),
(740, 'Pedregal', 3, 136),
(741, 'Piedra Grande', 3, 136),
(742, 'Purureche', 3, 136),
(743, 'Adaure', 3, 137),
(744, 'Adicora', 3, 137),
(745, 'Baraived', 3, 137),
(746, 'Buena Vista', 3, 137),
(747, 'El Hato', 3, 137),
(748, 'El Vinculo', 3, 137),
(749, 'Jadacaquiva', 3, 137),
(750, 'Moruy', 3, 137),
(751, 'Pueblo Nuevo', 3, 137),
(752, 'Agua Larga', 3, 138),
(753, 'Churuguara', 3, 138),
(754, 'El Pauji', 3, 138),
(755, 'Independencia', 3, 138),
(756, 'Maparari', 3, 138),
(757, 'Agua Linda', 3, 139),
(758, 'Araurima', 3, 139),
(759, 'Jacura', 3, 139),
(760, 'Judibana', 3, 140),
(761, 'Los Taques', 3, 140),
(762, 'Casigua', 3, 141),
(763, 'Mene De Mauroa', 3, 141),
(764, 'San Felix', 3, 141),
(765, 'Guzman Guillermo', 3, 142),
(766, 'Mitare', 3, 142),
(767, 'Rio Seco', 3, 142),
(768, 'Sabaneta', 3, 142),
(769, 'San Antonio', 3, 142),
(770, 'San Gabriel', 3, 142),
(771, 'Santa Ana', 3, 142),
(772, 'Boca De Tocuyo', 3, 143),
(773, 'Chichiriviche', 3, 143),
(774, 'Tocuyo De La Costa', 3, 143),
(775, 'Palma Sola', 3, 144),
(776, 'Cabure', 3, 145),
(777, 'Colina', 3, 145),
(778, 'Curimagua', 3, 145),
(779, 'Piritu', 3, 146),
(780, 'San Jose De La Costa', 3, 146),
(781, 'Mirimire', 3, 147),
(782, 'Boca De Aroa', 3, 148),
(783, 'Tucacas', 3, 148),
(784, 'Pecaya', 3, 149),
(785, 'Sucre', 3, 149),
(786, 'Tocopero', 3, 150),
(787, 'El Charal', 3, 151),
(788, 'Las Vegas Del Tuy', 3, 151),
(789, 'Sta.Cruz De Bucaral', 3, 151),
(790, 'Bruzual', 3, 152),
(791, 'Urumaco', 3, 152),
(792, 'La Cienaga', 3, 153),
(793, 'La Soledad', 3, 153),
(794, 'Pueblo Cumarebo', 3, 153),
(795, 'Puerto Cumarebo', 3, 153),
(796, 'Zazarida', 3, 153),
(797, 'Camaguan', 3, 154),
(798, 'Puerto Miranda', 3, 154),
(799, 'Uverito', 3, 154),
(800, 'Chaguaramas', 3, 155),
(801, 'El Socorro', 3, 156),
(802, 'Calabozo', 3, 157),
(803, 'El Calvario', 3, 157),
(804, 'El Rastro', 3, 157),
(805, 'Guardatinajas', 3, 157),
(806, 'San Rafael De Laya', 3, 158),
(807, 'Tucupido', 3, 158),
(808, 'Altagracia De Orituco', 3, 159),
(809, 'Lezama', 3, 159),
(810, 'Libertad De Orituco', 3, 159),
(811, 'Paso Real De Macaira', 3, 159),
(812, 'San Fco De Macaira', 3, 159),
(813, 'San Rafael De Orituco', 3, 159),
(814, 'Soublette', 3, 159),
(815, 'Cantagallo', 3, 160),
(816, 'Parapara', 3, 160),
(817, 'San Juan De Los Morros', 3, 160),
(818, 'El Sombrero', 3, 161),
(819, 'Sosa', 3, 161),
(820, 'Cabruta', 3, 162),
(821, 'Las Mercedes', 3, 162),
(822, 'Sta Rita De Manapire', 3, 162),
(823, 'Espino', 3, 163),
(824, 'Valle De La Pascua', 3, 163),
(825, 'Ortiz', 3, 164),
(826, 'San Fco. De Tiznados', 3, 164),
(827, 'San Jose De Tiznados', 3, 164),
(828, 'S Lorenzo De Tiznados', 3, 164),
(829, 'San Jose De Unare', 3, 165),
(830, 'Zaraza', 3, 165),
(831, 'Cazorla', 3, 166),
(832, 'Guayabal', 3, 166),
(833, 'San Jose De Guaribe', 3, 167),
(834, 'Altamira', 3, 168),
(835, 'Santa Maria De Ipire', 3, 168),
(836, 'Pio Tamayo', 3, 169),
(837, 'Qbda. Honda De Guache', 3, 169),
(838, 'Yacambu', 3, 169),
(839, 'Freitez', 3, 170),
(840, 'Jose Maria Blanco', 3, 170),
(841, 'Aguedo F. Alvarado', 3, 171),
(842, 'Buena Vista', 3, 171),
(843, 'Catedral', 3, 171),
(844, 'El Cuji', 3, 171),
(845, 'Juan De Villegas', 3, 171),
(846, 'Juarez', 3, 171),
(847, 'La Concepcion', 3, 171),
(848, 'Santa Rosa', 3, 171),
(849, 'Tamaca', 3, 171),
(850, 'Union', 3, 171),
(851, 'Crnel. Mariano Peraza', 3, 172),
(852, 'Cuara', 3, 172),
(853, 'Diego De Lozada', 3, 172),
(854, 'Jose Bernardo Dorante', 3, 172),
(855, 'Juan B Rodriguez', 3, 172),
(856, 'Paraiso De San Jose', 3, 172),
(857, 'San Miguel', 3, 172),
(858, 'Tintorero', 3, 172),
(859, 'Anzoategui', 3, 173),
(860, 'Bolivar', 3, 173),
(861, 'Guarico', 3, 173),
(862, 'Hilario Luna Y Luna', 3, 173),
(863, 'Humocaro Alto', 3, 173),
(864, 'Humocaro Bajo', 3, 173),
(865, 'La Candelaria', 3, 173),
(866, 'Moran', 3, 173),
(867, 'Agua Viva', 3, 174),
(868, 'Cabudare', 3, 174),
(869, 'Jose G. Bastidas', 3, 174),
(870, 'Buria', 3, 175),
(871, 'Gustavo Vegas Leon', 3, 175),
(872, 'Sarare', 3, 175),
(873, 'Altagracia', 3, 176),
(874, 'Antonio Diaz', 3, 176),
(875, 'Camacaro', 3, 176),
(876, 'Castañeda', 3, 176),
(877, 'Cecilio Zubillaga', 3, 176),
(878, 'Chiquinquira', 3, 176),
(879, 'El Blanco', 3, 176),
(880, 'Espinoza Los Monteros', 3, 176),
(881, 'Heriberto Arroyo', 3, 176),
(882, 'Lara', 3, 176),
(883, 'Las Mercedes', 3, 176),
(884, 'Manuel Morillo', 3, 176),
(885, 'Monta A Verde', 3, 176),
(886, 'Montes De Oca', 3, 176),
(887, 'Reyes Vargas', 3, 176),
(888, 'Torres', 3, 176),
(889, 'Trinidad Samuel', 3, 176),
(890, 'Moroturo', 3, 177),
(891, 'San Miguel', 3, 177),
(892, 'Siquisique', 3, 177),
(893, 'Xaguas', 3, 177),
(894, 'Gabriel Picon G.', 3, 178),
(895, 'Hector Amable Mora', 3, 178),
(896, 'Jose Nucete Sardi', 3, 178),
(897, 'Presidente Betancourt', 3, 178),
(898, 'Presidente Paez', 3, 178),
(899, 'Pte. Romulo Gallegos', 3, 178),
(900, 'Pulido Mendez', 3, 178),
(901, 'La Azulita', 3, 179),
(902, 'Mesa Bolivar', 3, 180),
(903, 'Mesa De Las Palmas', 3, 180),
(904, 'Sta Cruz De Mora', 3, 180),
(905, 'Aricagua', 3, 181),
(906, 'San Antonio', 3, 181),
(907, 'Canagua', 3, 182),
(908, 'Capuri', 3, 182),
(909, 'Chacanta', 3, 182),
(910, 'El Molino', 3, 182),
(911, 'Guaimaral', 3, 182),
(912, 'Mucuchachi', 3, 182),
(913, 'Mucutuy', 3, 182),
(914, 'Acequias', 3, 183),
(915, 'Fernandez Peña', 3, 183),
(916, 'Jaji', 3, 183),
(917, 'La Mesa', 3, 183),
(918, 'Matriz', 3, 183),
(919, 'Montalban', 3, 183),
(920, 'San Jose', 3, 183),
(921, 'Florencio Ramirez', 3, 184),
(922, 'Tucani', 3, 184),
(923, 'Las Piedras', 3, 185),
(924, 'Santo Domingo', 3, 185),
(925, 'Guaraque', 3, 186),
(926, 'Mesa De Quintero', 3, 186),
(927, 'Rio Negro', 3, 186),
(928, 'Arapuey', 3, 187),
(929, 'Palmira', 3, 187),
(930, 'San Cristobal De T', 3, 188),
(931, 'Torondoy', 3, 188),
(932, 'Antonio Spinetti Dini', 3, 189),
(933, 'Arias', 3, 189),
(934, 'Caracciolo Parra P', 3, 189),
(935, 'Domingo Peña', 3, 189),
(936, 'El Llano', 3, 189),
(937, 'El Morro', 3, 189),
(938, 'Gonzalo Picon Febres', 3, 189),
(939, 'Jacinto Plaza', 3, 189),
(940, 'Juan Rodriguez Suarez', 3, 189),
(941, 'Lasso De La Vega', 3, 189),
(942, 'Los Nevados', 3, 189),
(943, 'Mariano Picon Salas', 3, 189),
(944, 'Milla', 3, 189),
(945, 'Osuna Rodriguez', 3, 189),
(946, 'Sagrario', 3, 189),
(947, 'Andres Eloy Blanco', 3, 190),
(948, 'La Venta', 3, 190),
(949, 'Piñango', 3, 190),
(950, 'Timotes', 3, 190),
(951, 'Eloy Paredes', 3, 191),
(952, 'R De Alcazar', 3, 191),
(953, 'Sta Elena De Arenales', 3, 191),
(954, 'Sta Maria De Caparo', 3, 192),
(955, 'Pueblo Llano', 3, 193),
(956, 'Cacute', 3, 194),
(957, 'La Toma', 3, 194),
(958, 'Mucuchies', 3, 194),
(959, 'Mucuruba', 3, 194),
(960, 'San Rafael', 3, 194),
(961, 'Bailadores', 3, 195),
(962, 'Geronimo Maldonado', 3, 195),
(963, 'Tabay', 3, 196),
(964, 'Chiguara', 3, 197),
(965, 'Estanques', 3, 197),
(966, 'Lagunillas', 3, 197),
(967, 'La Trampa', 3, 197),
(968, 'Pueblo Nuevo Del Sur', 3, 197),
(969, 'San Juan', 3, 197),
(970, 'El Amparo', 3, 198),
(971, 'El Llano', 3, 198),
(972, 'San Francisco', 3, 198),
(973, 'Tovar', 3, 198),
(974, 'Independencia', 3, 199),
(975, 'Maria C Palacios', 3, 199),
(976, 'Nueva Bolivia', 3, 199),
(977, 'Santa Apolonia', 3, 199),
(978, 'Caño El Tigre', 3, 200),
(979, 'Zea', 3, 200),
(980, 'Araguita', 3, 201),
(981, 'Arevalo Gonzalez', 3, 201),
(982, 'Capaya', 3, 201),
(983, 'Caucagua', 3, 201),
(984, 'El Cafe', 3, 201),
(985, 'Marizapa', 3, 201),
(986, 'Panaquire', 3, 201),
(987, 'Ribas', 3, 201),
(988, 'Cumbo', 3, 202),
(989, 'San Jose De Barlovento', 3, 202),
(990, 'Baruta', 3, 203),
(991, 'El Cafetal', 3, 203),
(992, 'Las Minas De Baruta', 3, 203),
(993, 'Curiepe', 3, 204),
(994, 'Higuerote', 3, 204),
(995, 'Tacarigua', 3, 204),
(996, 'Mamporal', 3, 205),
(997, 'Carrizal', 3, 206),
(998, 'Chacao', 3, 207),
(999, 'Charallave', 3, 208),
(1000, 'Las Brisas', 3, 208),
(1001, 'El Hatillo', 3, 209),
(1002, 'Altagracia De La M', 3, 210),
(1003, 'Cecilio Acosta', 3, 210),
(1004, 'El Jarillo', 3, 210),
(1005, 'Los Teques', 3, 210),
(1006, 'Paracotos', 3, 210),
(1007, 'San Pedro', 3, 210),
(1008, 'Tacata', 3, 210),
(1009, 'El Cartanal', 3, 211),
(1010, 'Sta Teresa Del Tuy', 3, 211),
(1011, 'La Democracia', 3, 212),
(1012, 'Ocumare Del Tuy', 3, 212),
(1013, 'Santa Barbara', 3, 212),
(1014, 'San Antonio Los Altos', 3, 213),
(1015, 'El Guapo', 3, 214),
(1016, 'Paparo', 3, 214),
(1017, 'Rio Chico', 3, 214),
(1018, 'Sn Fernando Del Guapo', 3, 214),
(1019, 'Tacarigua De La Laguna', 3, 214),
(1020, 'Santa Lucia', 3, 215),
(1021, 'Cupira', 3, 216),
(1022, 'Machurucuto', 3, 216),
(1023, 'Guarenas', 3, 217),
(1024, 'San Fco De Yare', 3, 218),
(1025, 'S Antonio De Yare', 3, 218),
(1026, 'Caucaguita', 3, 219),
(1027, 'Filas De Mariches', 3, 219),
(1028, 'La Dolorita', 3, 219),
(1029, 'Leoncio Martinez', 3, 219),
(1030, 'Petare', 3, 219),
(1031, 'Cua', 3, 220),
(1032, 'Nueva Cua', 3, 220),
(1033, 'Zamora', 3, 221),
(1034, 'San Antonio', 3, 222),
(1035, 'San Francisco', 3, 222),
(1036, 'Aguasay', 3, 223),
(1037, 'Caripito', 3, 224),
(1038, 'Caripe', 3, 225),
(1039, 'El Guacharo', 3, 225),
(1040, 'La Guanota', 3, 225),
(1041, 'Sabana De Piedra', 3, 225),
(1042, 'San Agustin', 3, 225),
(1043, 'Teresen', 3, 225),
(1044, 'Areo', 3, 226),
(1045, 'Caicara', 3, 226),
(1046, 'San Felix', 3, 226),
(1047, 'Viento Fresco', 3, 226),
(1048, 'El Tejero', 3, 227),
(1049, 'Punta De Mata', 3, 227),
(1050, 'Chaguaramas', 3, 228),
(1051, 'Las Alhuacas', 3, 228),
(1052, 'Tabasca', 3, 228),
(1053, 'Temblador', 3, 228),
(1054, 'Alto De Los Godos', 3, 229),
(1055, 'Boqueron', 3, 229),
(1056, 'El Corozo', 3, 229),
(1057, 'El Furrial', 3, 229),
(1058, 'Jusepin', 3, 229),
(1059, 'La Pica', 3, 229),
(1060, 'Las Cocuizas', 3, 229),
(1061, 'San Simon', 3, 229),
(1062, 'Santa Cruz', 3, 229),
(1063, 'San Vicente', 3, 229),
(1064, 'Aparicio', 3, 230),
(1065, 'Aragua', 3, 230),
(1066, 'Chaguaramal', 3, 230),
(1067, 'El Pinto', 3, 230),
(1068, 'Guanaguana', 3, 230),
(1069, 'La Toscana', 3, 230),
(1070, 'Taguaya', 3, 230),
(1071, 'Cachipo', 3, 231),
(1072, 'Quiriquire', 3, 231),
(1073, 'Santa Barbara', 3, 232),
(1074, 'Barrancas', 3, 233),
(1075, 'Los Barrancos De Fajardo', 3, 233),
(1076, 'Uracoa', 3, 234),
(1077, 'Cm.La Plaza De Paraguachi', 3, 235),
(1078, 'La Asuncion', 3, 236),
(1079, 'San Juan Bautista', 3, 237),
(1080, 'Zabala', 3, 237),
(1081, 'Francisco Fajardo', 3, 238),
(1082, 'Valle Esp Santo', 3, 238),
(1083, 'Bolivar', 3, 239),
(1084, 'Guevara', 3, 239),
(1085, 'Matasiete', 3, 239),
(1086, 'Santa Ana', 3, 239),
(1087, 'Sucre', 3, 239),
(1088, 'Aguirre', 3, 240),
(1089, 'Pampatar', 3, 240),
(1090, 'Adrian', 3, 241),
(1091, 'Juan Griego', 3, 241),
(1092, 'Porlamar', 3, 242),
(1093, 'Boca Del Rio', 3, 243),
(1094, 'San Francisco', 3, 243),
(1095, 'Los Barales', 3, 244),
(1096, 'Punta De Piedras', 3, 244),
(1097, 'San Pedro De Coche', 3, 245),
(1098, 'Vicente Fuentes', 3, 245),
(1099, 'Agua Blanca', 3, 246),
(1100, 'Araure', 3, 247),
(1101, 'Rio Acarigua', 3, 247),
(1102, 'Piritu', 3, 248),
(1103, 'Uveral', 3, 248),
(1104, 'Cordoba', 3, 249),
(1105, 'Guanare', 3, 249),
(1106, 'San Jose De La Montaña', 3, 249),
(1107, 'San Juan Guanaguanare', 3, 249),
(1108, 'Virgen De La Coromoto', 3, 249),
(1109, 'Divina Pastora', 3, 250),
(1110, 'Guanarito', 3, 250),
(1111, 'Trinidad De La Capilla', 3, 250),
(1112, 'Chabasquen', 3, 251),
(1113, 'Peña Blanca', 3, 251),
(1114, 'Aparicion', 3, 252),
(1115, 'La Estacion', 3, 252),
(1116, 'Ospino', 3, 252),
(1117, 'Acarigua', 3, 253),
(1118, 'Payara', 3, 253),
(1119, 'Pimpinela', 3, 253),
(1120, 'Ramon Peraza', 3, 253),
(1121, 'Caño Delgadito', 3, 254),
(1122, 'Papelon', 3, 254),
(1123, 'Antolin Tovar Aquino', 3, 255),
(1124, 'Boconoito', 3, 255),
(1125, 'San Rafael De Onoto', 3, 256),
(1126, 'Santa Fe', 3, 256),
(1127, 'Thermo Morles', 3, 256),
(1128, 'El Playon', 3, 257),
(1129, 'Florida', 3, 257),
(1130, 'Biscucuy', 3, 258),
(1131, 'Concepcion', 3, 258),
(1132, 'San Jose De Saguaz', 3, 258),
(1133, 'San Rafael Palo Alzado', 3, 258),
(1134, 'Uvencio A Velasquez', 3, 258),
(1135, 'Villa Rosa', 3, 258),
(1136, 'Canelones', 3, 259),
(1137, 'San Isidro Labrador', 3, 259),
(1138, 'Santa Cruz', 3, 259),
(1139, 'Villa Bruzual', 3, 259),
(1140, 'Mariño', 3, 260),
(1141, 'Romulo Gallegos', 3, 260),
(1142, 'San Jose De Areocuar', 3, 261),
(1143, 'Tavera Acosta', 3, 261),
(1144, 'Antonio Jose De Sucre', 3, 262),
(1145, 'El Morro De Pto Santo', 3, 262),
(1146, 'Puerto Santo', 3, 262),
(1147, 'Rio Caribe', 3, 262),
(1148, 'San Juan Galdonas', 3, 262),
(1149, 'El Pilar', 3, 263),
(1150, 'El Rincon', 3, 263),
(1151, 'Gral Fco. A Vasquez', 3, 263),
(1152, 'Guaraunos', 3, 263),
(1153, 'Tunapuicito', 3, 263),
(1154, 'Union', 3, 263),
(1155, 'Bolivar', 3, 264),
(1156, 'Macarapana', 3, 264),
(1157, 'Santa Catalina', 3, 264),
(1158, 'Santa Rosa', 3, 264),
(1159, 'Santa Teresa', 3, 264),
(1160, 'Mariguitar', 3, 265),
(1161, 'Libertad', 3, 266),
(1162, 'Paujil', 3, 266),
(1163, 'Yaguaraparo', 3, 266),
(1164, 'Araya', 3, 267),
(1165, 'Chacopata', 3, 267),
(1166, 'Manicuare', 3, 267),
(1167, 'Campo Elias', 3, 268),
(1168, 'Tunapuy', 3, 268),
(1169, 'Mariño', 3, 269),
(1170, 'San Ant Del Golfo', 3, 270),
(1171, 'Arenas', 3, 271),
(1172, 'Aricagua', 3, 271),
(1173, 'Cocollar', 3, 271),
(1174, 'Cumanacoa', 3, 271),
(1175, 'San Fernando', 3, 271),
(1176, 'San Lorenzo', 3, 271),
(1177, 'Cariaco', 3, 272),
(1178, 'Catuaro', 3, 272),
(1179, 'Rendon', 3, 272),
(1180, 'Santa Cruz', 3, 272),
(1181, 'Santa Maria', 3, 272),
(1182, 'Altagracia', 3, 273),
(1183, 'Ayacucho', 3, 273),
(1184, 'Gran Mariscal', 3, 273),
(1185, 'Raul Leoni', 3, 273),
(1186, 'San Juan', 3, 273),
(1187, 'Santa Ines', 3, 273),
(1188, 'Valentin Valiente', 3, 273),
(1189, 'Bideau', 3, 274),
(1190, 'Cristobal Colon', 3, 274),
(1191, 'Guiria', 3, 274),
(1192, 'Punta De Piedra', 3, 274),
(1193, 'Cordero', 3, 275),
(1194, 'Las Mesas', 3, 276),
(1195, 'Colon', 3, 277),
(1196, 'Rivas Berti', 3, 277),
(1197, 'San Pedro Del Rio', 3, 277),
(1198, 'Isaias Medina Angarit', 3, 278),
(1199, 'Juan Vicente Gomez', 3, 278),
(1200, 'Palotal', 3, 278),
(1201, 'San Ant Del Tachira', 3, 278),
(1202, 'Amenodoro Rangel Lamu', 3, 279),
(1203, 'La Florida', 3, 279),
(1204, 'Tariba', 3, 279),
(1205, 'Sta. Ana Del Tachira', 3, 280),
(1206, 'Alberto Adriani', 3, 281),
(1207, 'Cm.San Rafael Del Pinal', 3, 281),
(1208, 'Santo Domingo', 3, 281),
(1209, 'San Jose De Bolivar', 3, 282),
(1210, 'Boca De Grita', 3, 283),
(1211, 'Jose Antonio Paez', 3, 283),
(1212, 'La Fria', 3, 283),
(1213, 'Palmira', 3, 284),
(1214, 'Capacho Nuevo', 3, 285),
(1215, 'Juan German Roscio', 3, 285),
(1216, 'Roman Cardenas', 3, 285),
(1217, 'Emilio C. Guerrero', 3, 286),
(1218, 'La Grita', 3, 286),
(1219, 'Mons. Miguel A Salas', 3, 286),
(1220, 'El Cobre', 3, 287),
(1221, 'Bramon', 3, 288),
(1222, 'La Petrolea', 3, 288),
(1223, 'Quinimari', 3, 288),
(1224, 'Rubio', 3, 288),
(1225, 'Capacho Viejo', 3, 289),
(1226, 'Cipriano Castro', 3, 289),
(1227, 'Manuel Felipe Rugeles', 3, 289),
(1228, 'Abejales', 3, 290),
(1229, 'Doradas', 3, 290),
(1230, 'Emeterio Ochoa', 3, 290),
(1231, 'San Joaquin De Navay', 3, 290),
(1232, 'Constitucion', 3, 291),
(1233, 'Lobatera', 3, 291),
(1234, 'Michelena', 3, 292),
(1235, 'Coloncito', 3, 293),
(1236, 'La Palmita', 3, 293),
(1237, 'Nueva Arcadia', 3, 294),
(1238, 'Ureña', 3, 294),
(1239, 'Delicias', 3, 295),
(1240, 'Bocono', 3, 296),
(1241, 'Hernandez', 3, 296),
(1242, 'La Tendida', 3, 296),
(1243, 'Dr. Fco. Romero Lobo', 3, 297),
(1244, 'La Concordia', 3, 297),
(1245, 'Pedro Maria Morantes', 3, 297),
(1246, 'San Sebastian', 3, 297),
(1247, 'Sn Juan Bautista', 3, 297),
(1248, 'Umuquena', 3, 298),
(1249, 'Seboruco', 3, 299),
(1250, 'San Simon', 3, 300),
(1251, 'Eleazar Lopez Contrera', 3, 301),
(1252, 'Queniquea', 3, 301),
(1253, 'San Pablo', 3, 301),
(1254, 'San Josecito', 3, 302),
(1255, 'Cardenas', 3, 303),
(1256, 'Juan Pablo Peñaloza', 3, 303),
(1257, 'Potosi', 3, 303),
(1258, 'Pregonero', 3, 303),
(1259, 'Araguaney', 3, 304),
(1260, 'El Jaguito', 3, 304),
(1261, 'La Esperanza', 3, 304),
(1262, 'Santa Isabel', 3, 304),
(1263, 'Ayacucho', 3, 305),
(1264, 'Bocono', 3, 305),
(1265, 'Burbusay', 3, 305),
(1266, 'El Carmen', 3, 305),
(1267, 'General Rivas', 3, 305),
(1268, 'Guaramacal', 3, 305),
(1269, 'La Vega De Guaramacal', 3, 305),
(1270, 'Monseñor Jauregui', 3, 305),
(1271, 'Mosquey', 3, 305),
(1272, 'Rafael Rangel', 3, 305),
(1273, 'San Jose', 3, 305),
(1274, 'San Miguel', 3, 305),
(1275, 'Cheregue', 3, 306),
(1276, 'Granados', 3, 306),
(1277, 'Sabana Grande', 3, 306),
(1278, 'Arnoldo Gabaldon', 3, 307),
(1279, 'Bolivia', 3, 307),
(1280, 'Carrillo', 3, 307),
(1281, 'Cegarra', 3, 307),
(1282, 'Chejende', 3, 307),
(1283, 'Manuel Salvador Ulloa', 3, 307),
(1284, 'San Jose', 3, 307),
(1285, 'Carache', 3, 308),
(1286, 'Cuicas', 3, 308),
(1287, 'La Concepcion', 3, 308),
(1288, 'Panamericana', 3, 308),
(1289, 'Santa Cruz', 3, 308),
(1290, 'Escuque', 3, 309),
(1291, 'La Union', 3, 309),
(1292, 'Sabana Libre', 3, 309),
(1293, 'Santa Rita', 3, 309),
(1294, 'Antonio Jose De Sucre', 3, 310),
(1295, 'El Socorro', 3, 310),
(1296, 'Los Caprichos', 3, 310),
(1297, 'Arnoldo Gabaldon', 3, 311),
(1298, 'Campo Elias', 3, 311),
(1299, 'El Progreso', 3, 312),
(1300, 'La Ceiba', 3, 312),
(1301, 'Santa Apolonia', 3, 312),
(1302, 'Tres De Febrero', 3, 312),
(1303, 'Agua Caliente', 3, 313),
(1304, 'Agua Santa', 3, 313),
(1305, 'El Cenizo', 3, 313),
(1306, 'El Dividive', 3, 313),
(1307, 'Valerita', 3, 313),
(1308, 'Buena Vista', 3, 314),
(1309, 'Monte Carmelo', 3, 314),
(1310, 'Sta Maria Del Horcon', 3, 314),
(1311, 'El Baño', 3, 315),
(1312, 'Jalisco', 3, 315),
(1313, 'Motatan', 3, 315),
(1314, 'Flor De Patria', 3, 316),
(1315, 'La Paz', 3, 316),
(1316, 'Pampan', 3, 316),
(1317, 'Santa Ana', 3, 316),
(1318, 'La Concepcion', 3, 317),
(1319, 'Pampanito', 3, 317),
(1320, 'Pampanito II', 3, 317),
(1321, 'Betijoque', 3, 318),
(1322, 'El Cedro', 3, 318),
(1323, 'Jose G Hernandez', 3, 318),
(1324, 'La Pueblita', 3, 318),
(1325, 'Antonio N Briceño', 3, 319),
(1326, 'Campo Alegre', 3, 319),
(1327, 'Carvajal', 3, 319),
(1328, 'Jose Leonardo Suarez', 3, 319),
(1329, 'El Paraiso', 3, 320),
(1330, 'Junin', 3, 320),
(1331, 'Sabana De Mendoza', 3, 320),
(1332, 'Valmore Rodriguez', 3, 320),
(1333, 'Andres Linares', 3, 321),
(1334, 'Chiquinquira', 3, 321),
(1335, 'Cristobal Mendoza', 3, 321),
(1336, 'Cruz Carrillo', 3, 321),
(1337, 'Matriz', 3, 321),
(1338, 'Monseñor Carrillo', 3, 321),
(1339, 'Tres Esquinas', 3, 321),
(1340, 'Cabimbu', 3, 322),
(1341, 'Jajo', 3, 322),
(1342, 'La Mesa', 3, 322),
(1343, 'La Quebrada', 3, 322),
(1344, 'Santiago', 3, 322),
(1345, 'Tuñame', 3, 322),
(1346, 'Juan Ignacio Montilla', 3, 323),
(1347, 'La Beatriz', 3, 323),
(1348, 'La Puerta', 3, 323),
(1349, 'Mendoza', 3, 323),
(1350, 'Mercedes Diaz', 3, 323),
(1351, 'San Luis', 3, 323),
(1352, 'San Pablo', 3, 324),
(1353, 'Aroa', 3, 325),
(1354, 'Campo Elias', 3, 326),
(1355, 'Chivacoa', 3, 326),
(1356, 'Cocorote', 3, 327),
(1357, 'Independencia', 3, 328),
(1358, 'Sabana De Parra', 3, 329),
(1359, 'Boraure', 3, 330),
(1360, 'Yumare', 3, 331),
(1361, 'Nirgua', 3, 332),
(1362, 'Salom', 3, 332),
(1363, 'Temerla', 3, 332),
(1364, 'San Andres', 3, 333),
(1365, 'Yaritagua', 3, 333),
(1366, 'Albarico', 3, 334),
(1367, 'San Felipe', 3, 334),
(1368, 'San Javier', 3, 334),
(1369, 'Guama', 3, 335),
(1370, 'Urachiche', 3, 336),
(1371, 'El Guayabo', 3, 337),
(1372, 'Farriar', 3, 337),
(1373, 'Isla De Toas', 3, 338),
(1374, 'Monagas', 3, 338),
(1375, 'General Urdaneta', 3, 339),
(1376, 'Libertador', 3, 339),
(1377, 'Manuel Guanipa Matos', 3, 339),
(1378, 'Marcelino Briceño', 3, 339),
(1379, 'Pueblo Nuevo', 3, 339),
(1380, 'San Timoteo', 3, 339),
(1381, 'Ambrosio', 3, 340),
(1382, 'Aristides Calvani', 3, 340),
(1383, 'Carmen Herrera', 3, 340),
(1384, 'German Rios Linares', 3, 340),
(1385, 'Jorge Hernandez', 3, 340),
(1386, 'La Rosa', 3, 340),
(1387, 'Punta Gorda', 3, 340),
(1388, 'Romulo Betancourt', 3, 340),
(1389, 'San Benito', 3, 340),
(1390, 'Encontrados', 3, 341),
(1391, 'Udon Perez', 3, 341),
(1392, 'Moralito', 3, 342),
(1393, 'San Carlos Del Zulia', 3, 342),
(1394, 'Santa Barbara', 3, 342),
(1395, 'Santa Cruz Del Zulia', 3, 342),
(1396, 'Urribarri', 3, 342),
(1397, 'Carlos Quevedo', 3, 343),
(1398, 'Francisco J Pulgar', 3, 343),
(1399, 'Simon Rodriguez', 3, 343),
(1400, 'Jose Ramon Yepez', 3, 344),
(1401, 'La Concepcion', 3, 344),
(1402, 'Mariano Parra Leon', 3, 344),
(1403, 'San Jose', 3, 344),
(1404, 'Bari', 3, 345),
(1405, 'Jesus M Semprun', 3, 345),
(1406, 'Andres Bello (Km 48)', 3, 346),
(1407, 'Chiquinquira', 3, 346),
(1408, 'Concepcion', 3, 346),
(1409, 'El Carmelo', 3, 346),
(1410, 'Potreritos', 3, 346),
(1411, 'Alonso De Ojeda', 3, 347),
(1412, 'Campo Lara', 3, 347),
(1413, 'Eleazar Lopez C', 3, 347),
(1414, 'Libertad', 3, 347),
(1415, 'Venezuela', 3, 347),
(1416, 'Bartolome De Las Casas', 3, 348),
(1417, 'Libertad', 3, 348),
(1418, 'Rio Negro', 3, 348),
(1419, 'San Jose De Perija', 3, 348),
(1420, 'La Sierrita', 3, 349),
(1421, 'Las Parcelas', 3, 349),
(1422, 'Luis De Vicente', 3, 349),
(1423, 'Mons.Marcos Sergio G', 3, 349),
(1424, 'Ricaurte', 3, 349),
(1425, 'San Rafael', 3, 349),
(1426, 'Tamare', 3, 349),
(1427, 'Antonio Borjas Romero', 3, 350),
(1428, 'Bolivar', 3, 350),
(1429, 'Cacique Mara', 3, 350),
(1430, 'Caracciolo Parra Perez', 3, 350),
(1431, 'Cecilio Acosta', 3, 350),
(1432, 'Chiquinquira', 3, 350),
(1433, 'Coquivacoa', 3, 350),
(1434, 'Cristo De Aranza', 3, 350),
(1435, 'Francisco Eugenio B', 3, 350),
(1436, 'Idelfonzo Vasquez', 3, 350),
(1437, 'Juana De Avila', 3, 350),
(1438, 'Luis Hurtado Higuera', 3, 350),
(1439, 'Manuel Dagnino', 3, 350),
(1440, 'Olegario Villalobos', 3, 350),
(1441, 'Raul Leoni', 3, 350),
(1442, 'San Isidro', 3, 350),
(1443, 'Santa Lucia', 3, 350),
(1444, 'Venancio Pulgar', 3, 350),
(1445, 'Altagracia', 3, 351),
(1446, 'Ana Maria Campos', 3, 351),
(1447, 'Faria', 3, 351),
(1448, 'San Antonio', 3, 351),
(1449, 'San Jose', 3, 351),
(1450, 'Alta Guajira', 3, 352),
(1451, 'Elias Sanchez Rubio', 3, 352),
(1452, 'Goajira', 3, 352),
(1453, 'Sinamaica', 3, 352),
(1454, 'Donaldo Garcia', 3, 353),
(1455, 'El Rosario', 3, 353),
(1456, 'Sixto Zambrano', 3, 353),
(1457, 'Domitila Flores', 3, 354),
(1458, 'El Bajo', 3, 354),
(1459, 'Francisco Ochoa', 3, 354),
(1460, 'Los Cortijos', 3, 354),
(1461, 'Marcial Hernandez', 3, 354),
(1462, 'San Francisco', 3, 354),
(1463, 'El Mene', 3, 355),
(1464, 'Jose Cenovio Urribarr', 3, 355),
(1465, 'Pedro Lucas Urribarri', 3, 355),
(1466, 'Santa Rita', 3, 355),
(1467, 'Manuel Manrique', 3, 356),
(1468, 'Rafael Maria Baralt', 3, 356),
(1469, 'Rafael Urdaneta', 3, 356),
(1470, 'Bobures', 3, 357),
(1471, 'El Batey', 3, 357),
(1472, 'Gibraltar', 3, 357),
(1473, 'Heras', 3, 357),
(1474, 'M.Arturo Celestino A', 3, 357),
(1475, 'Romulo Gallegos', 3, 357),
(1476, 'La Victoria', 3, 358),
(1477, 'Rafael Urdaneta', 3, 358),
(1478, 'Raul Cuenca', 3, 358),
(1479, 'Caraballeda', 3, 359),
(1480, 'Carayaca', 3, 359),
(1481, 'Carlos Soublette', 3, 359),
(1482, 'Caruao', 3, 359),
(1483, 'Catia La Mar', 3, 359),
(1484, 'El Junko', 3, 359),
(1485, 'La Guaira', 3, 359),
(1486, 'Macuto', 3, 359),
(1487, 'Maiquetia', 3, 359),
(1488, 'Naiguata', 3, 359),
(1489, 'Urimare', 3, 359);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_nacionalidad`
--

CREATE TABLE IF NOT EXISTS `bdv_nacionalidad` (
`id` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_nacionalidad`
--

INSERT INTO `bdv_nacionalidad` (`id`, `descripcion`) VALUES
(1, 'VENEZOLANA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_naturaleza_cliente`
--

CREATE TABLE IF NOT EXISTS `bdv_naturaleza_cliente` (
`id_naturaleza_cliente` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_naturaleza_cliente`
--

INSERT INTO `bdv_naturaleza_cliente` (`id_naturaleza_cliente`, `descripcion`) VALUES
(1, 'SOCIEDAD DE RESPONSABILIDAD LIMITADA'),
(2, 'SOCIEDAD ANONIMA'),
(3, 'COMPAÑÍA ANONIMA'),
(4, 'SOCIEDADES DE CAPITAL PUBLICO'),
(5, 'SOCIEDADES DE ECONOMIA MIXTA'),
(6, 'COOPERATIVAS'),
(7, 'ASOCIACION CIVIL'),
(8, 'INSTITUTO AUTONOMO'),
(9, 'SOCIEDADES ANÓNIMAS DE CAPITAL AUTORIZADO (S.A.C.A.)'),
(10, 'SOCIEDADES ANÓNIMAS INSCRITAS DE CAPITAL ABIERTO (S.A.I.C.A)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_recaudos`
--

CREATE TABLE IF NOT EXISTS `bdv_recaudos` (
`id_recaudos` int(11) NOT NULL,
  `certificado_snc` varchar(255) DEFAULT NULL,
  `planilla_rnc` varchar(255) DEFAULT NULL,
  `comunicacion_representante` varchar(255) DEFAULT NULL,
  `solvencia_sso` varchar(255) DEFAULT NULL,
  `solvencia_laboral` varchar(255) DEFAULT NULL,
  `solvencia_ince` varchar(255) DEFAULT NULL,
  `organigrama` varchar(255) DEFAULT NULL,
  `lista_productos` varchar(255) DEFAULT NULL,
  `referencia_bancaria` varchar(255) DEFAULT NULL,
  `referencia_comercial` varchar(255) DEFAULT NULL,
  `date_register` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_recaudos`
--

INSERT INTO `bdv_recaudos` (`id_recaudos`, `certificado_snc`, `planilla_rnc`, `comunicacion_representante`, `solvencia_sso`, `solvencia_laboral`, `solvencia_ince`, `organigrama`, `lista_productos`, `referencia_bancaria`, `referencia_comercial`, `date_register`, `date_update`) VALUES
(1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2015-01-28 01:07:05', '2015-01-28 01:07:05'),
(2, '/Users/georgeperez/NetBeansProjects/ProveedoresRegistro/web/resources/pdf/InversionesPepitocertificadoSnc.pdf', NULL, NULL, NULL, NULL, NULL, NULL, '/Users/georgeperez/NetBeansProjects/ProveedoresRegistro/web/resources/pdf/InversionesPepitoListaProductos.pdf', NULL, NULL, '2015-01-28 01:07:05', '2015-01-28 01:07:05'),
(3, '/Users/georgeperez/NetBeansProjects/ProveedoresRegistro/web/resources/pdf/InversionesPepitocertificadoSnc.pdf', NULL, NULL, NULL, NULL, NULL, NULL, '/Users/georgeperez/NetBeansProjects/ProveedoresRegistro/web/resources/pdf/InversionesPepitoListaProductos.pdf', NULL, NULL, '2015-01-28 01:07:05', '2015-01-28 01:07:05'),
(4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2015-01-28 01:19:41', '2015-01-28 01:19:41'),
(5, '/Users/georgeperez/NetBeansProjects/ProveedoresRegistro/web/resources/pdf/PepitoPimentelcertificadoSnc.pdf', NULL, NULL, NULL, NULL, NULL, NULL, '/Users/georgeperez/NetBeansProjects/ProveedoresRegistro/web/resources/pdf/PepitoPimentelListaProductos.pdf', NULL, NULL, '2015-01-28 01:26:34', '2015-01-28 01:26:34');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_representate_legal`
--

CREATE TABLE IF NOT EXISTS `bdv_representate_legal` (
`id_representate_legal` int(11) NOT NULL,
  `primer_nombre` varchar(100) DEFAULT NULL,
  `segundo_nombre` varchar(100) DEFAULT NULL,
  `primer_apellido` varchar(100) DEFAULT NULL,
  `segundo_apellido` varchar(100) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `documento_identidad` varchar(50) DEFAULT NULL,
  `numero_identidad` varchar(50) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `area_ocupacional` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_representate_legal`
--

INSERT INTO `bdv_representate_legal` (`id_representate_legal`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `sexo`, `documento_identidad`, `numero_identidad`, `cargo`, `area_ocupacional`) VALUES
(1, 'GEORGE', 'FELIX', 'PEREZ', 'MEZA', 'MASCULINO', 'CEDULA DE CIUDADANIA', '18141034', 'PRESIDENTE', 'DESARROLLO WEB'),
(2, 'n', 'n', 'n', 'n', 'FEMENINO', 'CEDULA DE CIUDADANIA', '16341623', 'ninguno', 'asd'),
(3, 'n', 'n', 'n', 'n', 'FEMENINO', 'CEDULA DE CIUDADANIA', '16341623', 'ninguno', 'asd'),
(4, 'n', 'n', 'n', 'n', 'FEMENINO', 'CEDULA DE CIUDADANIA', '16341623', 'ninguno', 'asd'),
(5, '1', '1', '1', '1', 'FEMENINO', 'CEDULA DE CIUDADANIA', '11111111', '1', '1'),
(6, '1', '1', '1', '1', 'FEMENINO', 'CEDULA DE CIUDADANIA', '11111111', '1', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_role`
--

CREATE TABLE IF NOT EXISTS `bdv_role` (
`id_role` int(11) NOT NULL,
  `role_nombre` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_role`
--

INSERT INTO `bdv_role` (`id_role`, `role_nombre`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'EDITOR'),
(3, 'CONSULTOR'),
(4, 'USUARIO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_sector_gremio`
--

CREATE TABLE IF NOT EXISTS `bdv_sector_gremio` (
`id_seector` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_sector_gremio`
--

INSERT INTO `bdv_sector_gremio` (`id_seector`, `descripcion`) VALUES
(1, 'SECTOR AGROPECUARIO (AGRICOLA Y GANADERO)'),
(2, 'SECTOR PESQUERO (DEL MAR, RIO U OCEANO)'),
(3, 'SECTOR MINERO (DE LAS MINAS Y COMPLEMENTOS ROCOSOS)'),
(4, 'SECTOR FORESTAL (DEL BOSQUE)'),
(5, 'SECTOR INDUSTRIAL'),
(6, 'SECTOR ENERGETICO'),
(7, 'SECTORES DE LA CONSTRUCCION'),
(8, 'SECTOR TRANSPORTES'),
(9, 'SECTOR TECNOLOGICO Y COMUNICACIONES'),
(10, 'SECTOR COMERCIAL'),
(11, 'SECTOR TURISTICO'),
(12, 'SECTOR SANITARIO'),
(13, 'SECTOR EDUCATIVO'),
(14, 'SECTOR FINANCIERO'),
(15, 'SECTOR DE LA ADMINISTRACION');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_tipo_cuenta`
--

CREATE TABLE IF NOT EXISTS `bdv_tipo_cuenta` (
`id_tipo_cuenta` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_tipo_cuenta`
--

INSERT INTO `bdv_tipo_cuenta` (`id_tipo_cuenta`, `descripcion`) VALUES
(1, 'AHORRO'),
(2, 'CORRIENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_user`
--

CREATE TABLE IF NOT EXISTS `bdv_user` (
`id_user` int(11) NOT NULL,
  `id_empresa` int(11) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `contrasenia` varchar(400) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '0',
  `email_valido` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_user`
--

INSERT INTO `bdv_user` (`id_user`, `id_empresa`, `email`, `contrasenia`, `activo`, `email_valido`) VALUES
(1, 1, 'pgeorge27@gmail.com', 'cb60ece79bddf395b76123b5618a5102c06e6b3a74d7f40d9e5b706f1f548aaa', 1, 1),
(2, 5, 'ppp@ppp.com', 'cb60ece79bddf395b76123b5618a5102c06e6b3a74d7f40d9e5b706f1f548aaa', 0, 1),
(3, 6, 'pepito@2.com', 'cb60ece79bddf395b76123b5618a5102c06e6b3a74d7f40d9e5b706f1f548aaa', 0, 1),
(4, NULL, 'perez@perez.com', 'cb60ece79bddf395b76123b5618a5102c06e6b3a74d7f40d9e5b706f1f548aaa', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_user_backend`
--

CREATE TABLE IF NOT EXISTS `bdv_user_backend` (
`id_user` int(11) NOT NULL,
  `userBackend` varchar(50) NOT NULL,
  `contrasenia` varchar(400) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdv_user_backend`
--

INSERT INTO `bdv_user_backend` (`id_user`, `userBackend`, `contrasenia`, `activo`) VALUES
(2, 'admin', 'cb60ece79bddf395b76123b5618a5102c06e6b3a74d7f40d9e5b706f1f548aaa', 1),
(3, 'admin2', 'cb60ece79bddf395b76123b5618a5102c06e6b3a74d7f40d9e5b706f1f548aaa', 1),
(4, 'admin3', 'cb60ece79bddf395b76123b5618a5102c06e6b3a74d7f40d9e5b706f1f548aaa', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdv_user_roles`
--

CREATE TABLE IF NOT EXISTS `bdv_user_roles` (
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bdv_bancos_nac`
--
ALTER TABLE `bdv_bancos_nac`
 ADD PRIMARY KEY (`banco_id`), ADD UNIQUE KEY `banco_id` (`banco_id`);

--
-- Indices de la tabla `bdv_banco_cuenta`
--
ALTER TABLE `bdv_banco_cuenta`
 ADD PRIMARY KEY (`id_banco_cuenta`), ADD KEY `id_banco` (`id_banco`), ADD KEY `id_tipo_cuenta` (`id_tipo_cuenta`);

--
-- Indices de la tabla `bdv_banco_cuenta_vnz`
--
ALTER TABLE `bdv_banco_cuenta_vnz`
 ADD PRIMARY KEY (`id_banco_cuenta_vnz`), ADD KEY `id_tipo_cuenta` (`id_tipo_cuenta`);

--
-- Indices de la tabla `bdv_categoria_producto`
--
ALTER TABLE `bdv_categoria_producto`
 ADD PRIMARY KEY (`id_categoria_producto`), ADD UNIQUE KEY `id_categoria_producto` (`id_categoria_producto`);

--
-- Indices de la tabla `bdv_contacto`
--
ALTER TABLE `bdv_contacto`
 ADD PRIMARY KEY (`id_contacto`);

--
-- Indices de la tabla `bdv_empresa`
--
ALTER TABLE `bdv_empresa`
 ADD PRIMARY KEY (`id_empresa`), ADD KEY `nacionalidad` (`id_nacionalidad`), ADD KEY `nacionalidad_2` (`id_nacionalidad`), ADD KEY `pais` (`pais`), ADD KEY `estado` (`estado`), ADD KEY `estado_2` (`estado`), ADD KEY `parroquia` (`parroquia`), ADD KEY `municipio` (`municipio`), ADD KEY `id_recaudos` (`id_recaudos`), ADD KEY `id_naturaleza_cliente` (`id_naturaleza_cliente`), ADD KEY `id_contacto1` (`id_contacto1`,`id_contacto2`,`id_contacto3`), ADD KEY `id_contacto2` (`id_contacto2`), ADD KEY `id_contacto3` (`id_contacto3`), ADD KEY `id_representate_legal1` (`id_representate_legal1`,`id_representate_legal2`,`id_representate_legal3`), ADD KEY `id_representate_legal2` (`id_representate_legal2`), ADD KEY `id_representate_legal3` (`id_representate_legal3`), ADD KEY `id_banco_cuenta` (`id_banco_cuenta1`), ADD KEY `sector` (`id_sector`), ADD KEY `nacionalidad_3` (`id_nacionalidad`), ADD KEY `id_banco_cuenta2` (`id_banco_cuenta2`,`id_banco_cuenta3`), ADD KEY `id_banco_cuenta_vnz1` (`id_banco_cuenta_vnz1`,`id_banco_cuenta_vnz2`), ADD KEY `id_banco_cuenta_vnz2` (`id_banco_cuenta_vnz2`), ADD KEY `id_banco_cuenta3` (`id_banco_cuenta3`), ADD KEY `id_naturaleza_cliente_2` (`id_naturaleza_cliente`);

--
-- Indices de la tabla `bdv_empresa_categoria_producto`
--
ALTER TABLE `bdv_empresa_categoria_producto`
 ADD PRIMARY KEY (`id_empresa`,`id_categoria_producto`), ADD KEY `id_categoria_producto` (`id_categoria_producto`);

--
-- Indices de la tabla `bdv_mcbe_ubic_geo`
--
ALTER TABLE `bdv_mcbe_ubic_geo`
 ADD PRIMARY KEY (`id_ubic_geo`);

--
-- Indices de la tabla `bdv_nacionalidad`
--
ALTER TABLE `bdv_nacionalidad`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `bdv_naturaleza_cliente`
--
ALTER TABLE `bdv_naturaleza_cliente`
 ADD PRIMARY KEY (`id_naturaleza_cliente`);

--
-- Indices de la tabla `bdv_recaudos`
--
ALTER TABLE `bdv_recaudos`
 ADD PRIMARY KEY (`id_recaudos`);

--
-- Indices de la tabla `bdv_representate_legal`
--
ALTER TABLE `bdv_representate_legal`
 ADD PRIMARY KEY (`id_representate_legal`);

--
-- Indices de la tabla `bdv_role`
--
ALTER TABLE `bdv_role`
 ADD PRIMARY KEY (`id_role`), ADD UNIQUE KEY `id_role_3` (`id_role`), ADD KEY `id_role` (`id_role`), ADD KEY `id_role_2` (`id_role`);

--
-- Indices de la tabla `bdv_sector_gremio`
--
ALTER TABLE `bdv_sector_gremio`
 ADD PRIMARY KEY (`id_seector`);

--
-- Indices de la tabla `bdv_tipo_cuenta`
--
ALTER TABLE `bdv_tipo_cuenta`
 ADD PRIMARY KEY (`id_tipo_cuenta`);

--
-- Indices de la tabla `bdv_user`
--
ALTER TABLE `bdv_user`
 ADD PRIMARY KEY (`id_user`), ADD UNIQUE KEY `email` (`email`), ADD UNIQUE KEY `id_user` (`id_user`), ADD KEY `id_empresa` (`id_empresa`);

--
-- Indices de la tabla `bdv_user_backend`
--
ALTER TABLE `bdv_user_backend`
 ADD PRIMARY KEY (`id_user`), ADD UNIQUE KEY `user` (`userBackend`,`contrasenia`), ADD UNIQUE KEY `id_user_3` (`id_user`), ADD KEY `id_user` (`id_user`), ADD KEY `id_user_2` (`id_user`);

--
-- Indices de la tabla `bdv_user_roles`
--
ALTER TABLE `bdv_user_roles`
 ADD PRIMARY KEY (`id_user`,`id_role`), ADD KEY `id_role` (`id_role`), ADD KEY `id_role_2` (`id_role`), ADD KEY `id_user` (`id_user`,`id_role`), ADD KEY `id_user_2` (`id_user`,`id_role`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bdv_banco_cuenta`
--
ALTER TABLE `bdv_banco_cuenta`
MODIFY `id_banco_cuenta` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `bdv_banco_cuenta_vnz`
--
ALTER TABLE `bdv_banco_cuenta_vnz`
MODIFY `id_banco_cuenta_vnz` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `bdv_categoria_producto`
--
ALTER TABLE `bdv_categoria_producto`
MODIFY `id_categoria_producto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT de la tabla `bdv_contacto`
--
ALTER TABLE `bdv_contacto`
MODIFY `id_contacto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `bdv_empresa`
--
ALTER TABLE `bdv_empresa`
MODIFY `id_empresa` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `bdv_nacionalidad`
--
ALTER TABLE `bdv_nacionalidad`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `bdv_naturaleza_cliente`
--
ALTER TABLE `bdv_naturaleza_cliente`
MODIFY `id_naturaleza_cliente` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `bdv_recaudos`
--
ALTER TABLE `bdv_recaudos`
MODIFY `id_recaudos` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `bdv_representate_legal`
--
ALTER TABLE `bdv_representate_legal`
MODIFY `id_representate_legal` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `bdv_role`
--
ALTER TABLE `bdv_role`
MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `bdv_sector_gremio`
--
ALTER TABLE `bdv_sector_gremio`
MODIFY `id_seector` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `bdv_tipo_cuenta`
--
ALTER TABLE `bdv_tipo_cuenta`
MODIFY `id_tipo_cuenta` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `bdv_user`
--
ALTER TABLE `bdv_user`
MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `bdv_user_backend`
--
ALTER TABLE `bdv_user_backend`
MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bdv_banco_cuenta`
--
ALTER TABLE `bdv_banco_cuenta`
ADD CONSTRAINT `bdv_banco_cuenta_ibfk_1` FOREIGN KEY (`id_banco`) REFERENCES `bdv_bancos_nac` (`banco_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_banco_cuenta_ibfk_2` FOREIGN KEY (`id_tipo_cuenta`) REFERENCES `bdv_tipo_cuenta` (`id_tipo_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bdv_banco_cuenta_vnz`
--
ALTER TABLE `bdv_banco_cuenta_vnz`
ADD CONSTRAINT `bdv_banco_cuenta_vnz_ibfk_1` FOREIGN KEY (`id_tipo_cuenta`) REFERENCES `bdv_tipo_cuenta` (`id_tipo_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bdv_empresa`
--
ALTER TABLE `bdv_empresa`
ADD CONSTRAINT `bdv_empresa_ibfk_1` FOREIGN KEY (`id_nacionalidad`) REFERENCES `bdv_nacionalidad` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_10` FOREIGN KEY (`id_representate_legal1`) REFERENCES `bdv_representate_legal` (`id_representate_legal`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_11` FOREIGN KEY (`id_representate_legal2`) REFERENCES `bdv_representate_legal` (`id_representate_legal`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_12` FOREIGN KEY (`id_representate_legal3`) REFERENCES `bdv_representate_legal` (`id_representate_legal`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_13` FOREIGN KEY (`id_banco_cuenta1`) REFERENCES `bdv_banco_cuenta` (`id_banco_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_14` FOREIGN KEY (`id_banco_cuenta2`) REFERENCES `bdv_banco_cuenta` (`id_banco_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_15` FOREIGN KEY (`id_banco_cuenta3`) REFERENCES `bdv_banco_cuenta` (`id_banco_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_16` FOREIGN KEY (`id_banco_cuenta_vnz1`) REFERENCES `bdv_banco_cuenta_vnz` (`id_banco_cuenta_vnz`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_17` FOREIGN KEY (`id_banco_cuenta_vnz2`) REFERENCES `bdv_banco_cuenta_vnz` (`id_banco_cuenta_vnz`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_18` FOREIGN KEY (`id_recaudos`) REFERENCES `bdv_recaudos` (`id_recaudos`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_2` FOREIGN KEY (`id_naturaleza_cliente`) REFERENCES `bdv_naturaleza_cliente` (`id_naturaleza_cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_3` FOREIGN KEY (`id_sector`) REFERENCES `bdv_sector_gremio` (`id_seector`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_4` FOREIGN KEY (`estado`) REFERENCES `bdv_mcbe_ubic_geo` (`id_ubic_geo`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_5` FOREIGN KEY (`municipio`) REFERENCES `bdv_mcbe_ubic_geo` (`id_ubic_geo`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_6` FOREIGN KEY (`parroquia`) REFERENCES `bdv_mcbe_ubic_geo` (`id_ubic_geo`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_7` FOREIGN KEY (`id_contacto1`) REFERENCES `bdv_contacto` (`id_contacto`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_8` FOREIGN KEY (`id_contacto2`) REFERENCES `bdv_contacto` (`id_contacto`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_ibfk_9` FOREIGN KEY (`id_contacto3`) REFERENCES `bdv_contacto` (`id_contacto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bdv_empresa_categoria_producto`
--
ALTER TABLE `bdv_empresa_categoria_producto`
ADD CONSTRAINT `bdv_empresa_categoria_producto_ibfk_3` FOREIGN KEY (`id_empresa`) REFERENCES `bdv_empresa` (`id_empresa`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_empresa_categoria_producto_ibfk_4` FOREIGN KEY (`id_categoria_producto`) REFERENCES `bdv_categoria_producto` (`id_categoria_producto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bdv_user`
--
ALTER TABLE `bdv_user`
ADD CONSTRAINT `bdv_user_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `bdv_empresa` (`id_empresa`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bdv_user_roles`
--
ALTER TABLE `bdv_user_roles`
ADD CONSTRAINT `bdv_user_roles_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `bdv_user_backend` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `bdv_user_roles_ibfk_2` FOREIGN KEY (`id_role`) REFERENCES `bdv_role` (`id_role`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
