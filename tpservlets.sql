-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-09-2014 a las 00:03:43
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tpservlets`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ccompras`
--

CREATE TABLE IF NOT EXISTS `ccompras` (
  `IdFactura` int(11) NOT NULL AUTO_INCREMENT,
  `UsuarioId` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  PRIMARY KEY (`IdFactura`),
  KEY `usuarioid_idx` (`UsuarioId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dcompras`
--

CREATE TABLE IF NOT EXISTS `dcompras` (
  `IdDetalle` int(11) NOT NULL,
  `FacturaId` int(11) NOT NULL,
  `importe` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `ProductoId` int(11) NOT NULL,
  KEY `ProductoId_idx` (`ProductoId`),
  KEY `FacturaID_idx` (`FacturaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `IdProducto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(60) COLLATE utf8_spanish2_ci NOT NULL,
  `precio` double NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`IdProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `Idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `dni` int(11) NOT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `administrador` tinyint(1) NOT NULL,
  PRIMARY KEY (`Idusuario`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ccompras`
--
ALTER TABLE `ccompras`
  ADD CONSTRAINT `usuarioid` FOREIGN KEY (`UsuarioId`) REFERENCES `usuarios` (`Idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `dcompras`
--
ALTER TABLE `dcompras`
  ADD CONSTRAINT `ProductoId` FOREIGN KEY (`ProductoId`) REFERENCES `productos` (`IdProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FacturaID` FOREIGN KEY (`FacturaId`) REFERENCES `ccompras` (`IdFactura`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
