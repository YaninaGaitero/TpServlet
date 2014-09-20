SELECT * FROM tpservlets.usuarios;
INSERT INTO `tpservlets`.`usuarios` (`Idusuario`, `dni`, `apellido`, `nombre`, `activo`, `administrador`, `usuario`, `pass`) VALUES ('4', '34125415', 'Cristeche', 'Ezequiel', '1', '1', 'admin02', 'admin02');
INSERT INTO `tpservlets`.`usuarios` (`Idusuario`, `dni`, `apellido`, `nombre`, `activo`, `administrador`, `usuario`, `pass`) VALUES ('5', '14258963', 'Lopez', 'Jorge', '0', '0', 'lopez', 'lopez');
INSERT INTO `tpservlets`.`usuarios` (`Idusuario`, `dni`, `apellido`, `nombre`, `activo`, `administrador`, `usuario`, `pass`) VALUES ('6', '25412365', 'Roman', 'Rodrigo', '0', '0', 'Roman', 'Roman');
INSERT INTO `tpservlets`.`usuarios` (`Idusuario`, `dni`, `apellido`, `nombre`, `activo`, `administrador`, `usuario`, `pass`) VALUES ('7', '14258963', 'Guccione', 'Leonel', '1', '0', 'leonel', 'leonel');
INSERT INTO `tpservlets`.`usuarios` (`Idusuario`, `dni`, `apellido`, `nombre`, `activo`, `administrador`, `usuario`, `pass`) VALUES ('8', '32123456', 'Zerna', 'Pedro', '1', '0', 'zerna', 'zerna');
INSERT INTO `tpservlets`.`usuarios` (`Idusuario`, `dni`, `apellido`, `nombre`, `activo`, `administrador`, `usuario`, `pass`) VALUES ('9', '14256365', 'Justo', 'Jose', '1', '0', 'justo', 'justo');
INSERT INTO `tpservlets`.`usuarios` (`Idusuario`, `dni`, `apellido`, `nombre`, `activo`, `administrador`, `usuario`, `pass`) VALUES ('10', '11258963', 'Roque', 'Norberto', '1', '0', 'roque', 'roque');

INSERT INTO `tpservlets`.`productos` (`IdProducto`, `descripcion`, `precio`, `stock`) VALUES ('1', 'Tornillos', '0.10', '10');
INSERT INTO `tpservlets`.`productos` (`IdProducto`, `descripcion`, `precio`, `stock`) VALUES ('2', 'Tuercas', '0.10', '12');
INSERT INTO `tpservlets`.`productos` (`IdProducto`, `descripcion`, `precio`, `stock`) VALUES ('3', 'Martillo', '80', '2');
INSERT INTO `tpservlets`.`productos` (`IdProducto`, `descripcion`, `precio`, `stock`) VALUES ('4', 'Pinza', '25', '5');
INSERT INTO `tpservlets`.`productos` (`IdProducto`, `descripcion`, `precio`, `stock`) VALUES ('5', 'Pinza grande', '50', '10');
INSERT INTO `tpservlets`.`productos` (`IdProducto`, `descripcion`, `precio`, `stock`) VALUES ('6', 'Matafuego', '254', '1');
INSERT INTO `tpservlets`.`productos` (`IdProducto`, `descripcion`, `precio`, `stock`) VALUES ('7', 'Chaleco reflectario', '54', '8');
INSERT INTO `tpservlets`.`productos` (`IdProducto`, `descripcion`, `precio`, `stock`) VALUES ('9', 'Foco bajo consumo', '22', '10');
INSERT INTO `tpservlets`.`productos` (`IdProducto`, `descripcion`, `precio`, `stock`) VALUES ('10', 'Foco bajo consumo luz calida', '25', '5');


INSERT INTO `tpservlets`.`ccompras` (`IdFactura`, `UsuarioId`, `Fecha`) VALUES ('1', '1', '15/09/2014');
INSERT INTO `tpservlets`.`ccompras` (`IdFactura`, `UsuarioId`, `Fecha`) VALUES ('2', '2', '15/09/2014');
UPDATE `tpservlets`.`ccompras` SET `Fecha`='2014-09-15' WHERE `IdFactura`='1';
UPDATE `tpservlets`.`ccompras` SET `Fecha`='2014-09-14' WHERE `IdFactura`='2';
INSERT INTO `tpservlets`.`ccompras` (`IdFactura`, `UsuarioId`, `Fecha`) VALUES ('3', '2', '2014-09-12');
INSERT INTO `tpservlets`.`ccompras` (`IdFactura`, `UsuarioId`, `Fecha`) VALUES ('4', '2', '2014-05-10');
INSERT INTO `tpservlets`.`ccompras` (`IdFactura`, `UsuarioId`, `Fecha`) VALUES ('5', '3', '2014/05/05');
INSERT INTO `tpservlets`.`ccompras` (`IdFactura`, `UsuarioId`, `Fecha`) VALUES ('6', '3', '2014/03/01');
