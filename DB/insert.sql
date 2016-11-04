
INSERT INTO comprobante VALUES 
('1','FACTURA');


INSERT INTO parametro VALUES 
('1');

INSERT INTO cliente VALUES 
('1', 'Diego Barrios','0','','','','0');

INSERT INTO empresa VALUES 
('1', '4k','','','','1');

INSERT INTO sucursal VALUES 
('1', 'Casa Matriz','1','0');

INSERT INTO proveedor VALUES 
('1', 'Casa Amin','0','0','','0');



INSERT INTO tipo_de_iva VALUES 
('0', '---'),
('1', 'Indistinto');

INSERT INTO ventas VALUES 
('0', '---'),
('1', 'Ventas al 5%, 10%');

INSERT INTO impuesto VALUES 
('0', '---'),
('1', 'IVA 10%'),
('2', 'IVA 5%'),
('3', 'EXENTAS');



INSERT INTO proveedor VALUES 
('0','No especificado', '0', '0','-','0');

INSERT INTO moneda VALUES 
('1','GUARANIES'),
('2','DOLARES'),
('3','REALES'),
('4','PESOS');


INSERT INTO condicion VALUES 
('1','CONTADO'),
('2','CREDITO');

INSERT INTO cuenta VALUES 
	('1', '1', '0', '0', '0', '0', 'ACTIVO','0'),
	('2', '1', '01', '0', '0', '0', 'ACTIVO CORRIENTE','0'),
	('3', '1', '01', '01', '0', '0', 'DISPONIBILIDADES','0'),
	('4', '1', '01', '01', '01','0', 'RECAUDACIONES A DEPOSITAR','0'),
	('5', '1', '01', '01', '02', '0', 'CAJA','0'),
	('6', '1', '01', '01', '03', '0', 'FONDOS FIJOS','0'),
	('7', '1', '01', '01', '04', '0', 'BANCOS','0'),

	('8', '1', '01', '02', '0', '0', 'INVERSIONES TEMPORARIAS','0'),
	('9', '1', '01', '02', '01', '0', 'INVERSIONES FINANCIERAS','0'),
	('10', '1', '01', '02', '02', '0', 'INVERSIONES EN ENTIDADES VINCULADAS','0'),
	('11', '1', '01', '02', '03', '0', 'OTRAS INVERSIONES','0'),
	('12', '1', '01', '02', '04', '0', 'INTERESES, REGALIAS Y OTROS RENDIMIENTOS DE INVERSIONES','0'),

	('13', '1', '01', '03', '0', '0', 'CREDITOS','0'),
	('14', '1', '01', '03', '01', '0', 'DEUDORES POR VENTAS','0'),
	('15', '1', '01', '03', '02', '0', 'DEUDORES POR PRESTAMOS','0'),
	('16', '1', '01', '03', '03', '0', 'CUENTAS A COBRAR A DIRECTORES Y FUNCIONARIOS','0'),
	('17', '1', '01', '03', '04', '0', 'CUENTAS A COBRAR A SOCIOS O ENTIDADES VINCULADAS','0'),
	('18', '1', '01', '03', '05', '0', 'CREDITOS POR IMPUESTOS CORRIENTES','0'),
	('19', '1', '01', '03', '05', '01', 'ANTICIPOS Y RETENCIONES DE IMPUESTO A LA RENTA','0'),
	('20', '1', '01', '03', '05', '02', 'RETENCIONES DE IVA','0'),
	('21', '1', '01', '03', '05', '03', 'IVA - CREDITO FISCAL','0'),
	('22', '1', '01', '03', '05', '04', 'IVA - CREDITO FISCAL - REGIMEN DE TURISMO','0'),
	('23', '1', '01', '03', '06', '0', 'ANTICIPO A PROVEEDORES','0'),
	('24', '1', '01', '03', '06', '01', 'ANTICIPO A PROVEEDORES LOCALES','0'),
	('25', '1', '01', '03', '06', '02', 'ANTICIPO A PROVEEDORES DEL EXTERIOR','0'),
	('26', '1', '01', '03', '99', '0', '(-) PREVISION PARA CREDITOS DE DUDOSO COBRO','0'),

	('27', '1', '01', '04', '0', '0', 'INVENTARIOS','0'),
	('28', '1', '01', '04', '01', '0', 'MERCADERIAS','0'),
	('29', '1', '01', '04', '01', '01', 'MERCADERIAS GRAVADAS POR EL IVA AL 10%','0'),
	('30', '1', '01', '04', '01', '02', 'MERCADERIAS GRAVADAS POR EL IVA AL 5%','0'),
	('31', '1', '01', '04', '01', '03', 'MERCADERIAS EXENTAS DEL IVA','0'),
	('32', '1', '01', '04', '02', '0', 'MERCADERIAS REGIMENES ESPECIALES','0'),
	('33', '1', '01', '04', '02', '01', 'MERCADERIAS REGIMENES DE TURISMO','0'),
	('34', '1', '01', '04', '02', '02', 'MERCADERIAS ZONA FRANCA','0'),
	('35', '1', '01', '04', '02', '03', 'MERCADERIAS REGIMEN DE MAQUILA','0'),
	('36', '1', '01', '04', '02', '04', 'MERCADERIAS OTROS REGIMENES ESPECIALES','0'),
	('37', '1', '01', '04', '03', '0', 'PRODUCTOS TERMINADOS','0'),
	('38', '1', '01', '04', '03', '01', 'PRODUCTOS TERMINADOS GRAVADOS POR EL IVA AL 10%','0'),
	('39', '1', '01', '04', '03', '02', 'PRODUCTOS TERMINADOS GRAVADOS POR EL IVA AL 5%','0'),
	('40', '1', '01', '04', '03', '03', 'PRODUCTOS TERMINADOS EXENTOS DEL IVA','0'),
	('41', '1', '01', '04', '04', '0', 'PRODUCTOS EN PROCESO','0'),
	('42', '1', '01', '04', '05', '0', 'MATERIAS PRIMAS','0'),
	('43', '1', '01', '04', '06', '0', 'MATERIALES, SUMINISTROS Y REPUESTOS','0'),
	('44', '1', '01', '04', '07', '0', 'PRODUCTOS AGRICOLAS','0'),
	('45', '1', '01', '04', '08', '0', 'PRODUCTOS FORESTALES','0'),
	('46', '1', '01', '04', '09', '0', 'ACTIVOS BIOLOGICOS EN PRODUCCION','0'),
	('47', '1', '01', '04', '10', '0', 'ACTIVOS BIOLOGICOS EN DESARROLLO','0'),
	('48', '1', '01', '04', '11', '0', 'IMPORTACIONES EN CURSO','0'),
	('49', '1', '01', '04', '99', '0', '(-) PREVISION POR DEVALUACION DE INVENTARIOS','0'),

	('50', '1', '01', '05', '0', '0', 'GASTOS PAGADOS POR ADELANTADO','0'),
	('51', '1', '01', '05', '01', '0', 'ALQUILERES PAGADOS POR ADELANTADO','0'),
	('52', '1', '01', '05', '02', '0', 'SEGUROS A DEVENGAR','0'),

	('53', '1', '01', '06', '0', '0', 'OTROS ACTIVOS','0'),

	('54', '1', '02', '0', '0', '0', 'ACTIVO NO CORRIENTE','0'),
	('55', '1', '02', '01', '0', '0', 'CREDITOS A LARGO PLAZO','0'),
	('56', '1', '02', '01', '01', '0', 'DEUDORES POR VENTAS','0'),
	('57', '1', '02', '01', '02', '0', 'DEUDORES POR PRESTAMOS','0'),
	('58', '1', '02', '01', '03', '0', 'CUENTAS A COBRAR A DIRECTORES Y FUNCIONARIOS','0'),
	('59', '1', '02', '01', '04', '0', 'CUENTAS A COBRAR A SOCIOS O ENTIDADES VINCULADAS','0'),
	('60', '1', '02', '01', '05', '0', 'DEUDORES EN GESTION DE COBRO - MOROSOS O SIMILARES','0'),
	('61', '1', '02', '01', '06', '0', 'ANTICIPOS A PROVEEDORES','0'),
	('62', '1', '02', '01', '06', '01', 'ANTICIPO A PROVEEDORES LOCALES','0'),
	('63', '1', '02', '01', '06', '02', 'ANTICIPO A PROVEEDORES DEL EXTERIOR','0'),
	('64', '1', '02', '01', '07', '0', 'CREDITOS POR IMPUESTOS DIFERIDOS','0'),
	('65', '1', '02', '01', '99', '0', '(-) PREVISION PARA CREDITOS DE DUDOSO COBRO','0'),

	('66', '1', '02', '02', '0', '0', 'INVENTARIOS A REALIZAR A LARGO PLAZO','0'),
	('67', '1', '02', '02', '01', '0', 'ACTIVOS BIOLOGICOS EN PRODUCCION','0'),
	('68', '1', '02', '02', '02', '0', 'ACTIVOS BIOLOGICOS EN DESARROLLO','0'),
	('69', '1', '02', '02', '99', '0', '(-) PREVENCION POR DEVALUACION DE ACTIVOS BIOLOGICOS','0'),

	('70', '1', '02', '03', '0', '0', 'INVERSIONES A LARGO PLAZO','0'),
	('71', '1', '02', '03', '01', '0', 'INVERSIONES FINANCIERAS','0'),
	('72', '1', '02', '03', '02', '0', 'INVERSIONES EN ENTIDADES VINCULADAS','0'),
	('73', '1', '02', '03', '03', '0', 'INVERSIONES INMOBILIARIAS','0'),
	('74', '1', '02', '03', '04', '0', 'OTRAS INVERSIONES','0'),
	('75', '1', '02', '03', '05', '0', 'INTERESES, REGALIAS Y OTROS RENDIMIENTOS DE INVERSIONES','0'),
	('76', '1', '02', '03', '99', '0', '(-) PREVENCION POR DEVALUACION DE INVERSIONES','0'),
	
	('77', '1', '02', '04', '0', '0', 'PROPIEDAD, PLANTA Y EQUIPO','0'),
	('78', '1', '02', '04', '01', '0', 'INMUEBLES','0'),
	('79', '1', '02', '04', '02', '0', 'RODADOS / TRANSPORTES','0'),
	('80', '1', '02', '04', '03', '0', 'MUEBLES, UTILES Y ENSERES','0'),
	('81', '1', '02', '04', '04', '0', 'MAQUINARIAS','0'),
	('82', '1', '02', '04', '05', '0', 'EQUIPOS','0'),
	('83', '1', '02', '04', '06', '0', 'HERRAMIENTAS','0'),
	('84', '1', '02', '04', '07', '0', 'BIENES FUERA DE OPERACION','0'),
	('85', '1', '02', '04', '08', '0', 'MEJORAS EN PREDIO AJENO','0'),
	('86', '1', '02', '04', '97', '0', 'BIENES INCORPORADOS AL AMPARO DE LA LEY 60/90','0'),
	('87', '1', '02', '04', '98', '0', 'BIENES EN ARRENDAMIENTO FINANCIERO','0'),
	('88', '1', '02', '04', '99', '0', '(-) DEPRECIACION ACUMULADA','0'),

	('89', '1', '02', '05', '0', '0', 'OTROS ACTIVOS A LARGO PLAZO','0'),
	('90', '1', '02', '05', '01', '0', 'DERECHOS FIDUCIARIOS','0'),

	('91', '1', '02', '06', '0', '0', 'CARGOS DIFERIDOS','0'),
	('92', '1', '02', '06', '01', '0', 'GASTOS DE CONSTITUCION','0'),
	('93', '1', '02', '06', '02', '0', 'GASTOS DE ORGANIZACION','0'),
	('94', '1', '02', '06', '03', '0', 'GASTOS DE DESARROLLO','0'),
	('95', '1', '02', '06', '04', '0', 'GASTOS DE PROYECTOS DE INVERSION','0'),
	('96', '1', '02', '06', '99', '0', '(-) AMORTIZACION ACUMULADA','0'),

	('97', '1', '02', '07', '0', '0', 'ACTIVOS INTANGIBLES','0'),
	('98', '1', '02', '07', '01', '0', 'LICENCIAS, MARCAS Y PATENTES','0'),
	('99', '1', '02', '07', '02', '0', 'FRANQUICIAS','0'),
	('100', '1', '02', '07', '99', '0', '(-) AMORTIZACIONACUMULADA','0'),

	('101', '2', '0', '0', '0', '0', 'PASIVO','0'),
	('102', '2', '01', '0', '0', '0', 'PASIVO CORRIENTE','0'),
	('103', '2', '01', '01', '0', '0', 'ACREEDORES COMERCIALES','0'),
	('104', '2', '01', '01', '01', '0', 'PROVEEDORES LOCALES','0'),
	('105', '2', '01', '01', '02', '0', 'PROVEEDORES DEL EXTERIOR','0'),
	('106', '2', '01', '01', '03', '0', 'INTERESES A PAGAR A PROVEEDORES','0'),
	('107', '2', '01', '01', '04', '0', 'OTROS ACREEDORES','0'),

	('108', '2', '01', '02', '0', '0', 'DEUDAS FINANCIERAS','0'),
	('109', '2', '01', '02', '01', '0', 'PRESTAMOS DE BANCOS Y OTRAS ENTIDADES FINANCIERAS','0'),
	('110', '2', '01', '02', '02', '0', 'PRESTAMOS DEL DUEÑO, SOCIOS O ENTIDADES VINCULADAS','0'),
	('111', '2', '01', '02', '03', '0', 'ARRENDAMIENTOS FINANCIEROS','0'),
	('112', '2', '01', '02', '04', '0', 'OTROS PRESTAMOS A PAGAR','0'),
	('113', '2', '01', '02', '05', '0', 'INTERESES A PAGAR','0'),

	('114', '2', '01', '03', '0', '0', 'OTRAS CUENTAS POR PAGAR','0'),
	('115', '2', '01', '03', '01', '0', 'DEUDAS FISCALES CORRIENTES','0'),
	('116', '2', '01', '03', '01', '01', 'IMPUESTO A LA RENTA A PAGAR','0'),
	('117', '2', '01', '03', '01', '02', 'IVA A PAGAR','0'),
	('118', '2', '01', '03', '01', '03', 'RETENCIONES DE IMPUESTOS A INGRESAR','0'),
	('119', '2', '01', '03', '02', '0', 'OBLIGACIONES LABORALES Y CARGAS SOCIALES','0'),
	('120', '2', '01', '03', '03', '0', 'DIVIDENDOS A PAGAR','0'),
	('121', '2', '01', '03', '04', '0', 'PASIVOS FIDUCIARIOS','0'),
	
	('122', '2', '01', '04', '0', '0', 'PROVISIONES','0'),
	('123', '2', '01', '04', '01', '0', 'OBLIGACIONES POR GARANTIAS OTORGADAS','0'),
	('124', '2', '01', '04', '02', '0', 'OBLIGACIONES LEGALES POR LITIGIO','0'),
	('125', '2', '01', '04', '03', '0', 'PROVISION PARA BENEFICIOS A EMPLEADOS','0'),
	
	('126', '2', '01', '05', '0', '0', 	'INGRESOS DIFERIDOS','0'),
	('127', '2', '01', '05', '01', '0', 	'ANTICIPOS DE CLIENTES','0'),
	('128', '2', '01', '05', '02', '0', 	'SUBVENCIONES','0'),
	('129', '2', '01', '05', '03', '0', 	'DERECHOS DE FIDELIZACION DE CLIENTES','0'),
	('130', '2', '01', '05', '04', '0', 	'ALQUILERES COBRADOS POR ADELANTADO','0'),
	
	('131', '2', '02', '0', '0', '0', 		'PASIVO NO CORRIENTE','0'),
	('132', '2', '02', '01', '0', '0', 	'ACREEDORES COMERCIALES A LARGO PLAZO','0'),
	('133', '2', '02', '01', '01', '0', 	'PROVEEDORES LOCALES','0'),	
	('134', '2', '02', '01', '02', '0', 	'PROVEEDORES DEL EXTERIOR','0'),
	('135', '2', '02', '01', '03', '0', 	'INTERESES A PAGAR A PROVEEDORES','0'),
	('136', '2', '02', '01', '04', '0', 	'OTROS ACREEDORES','0'),
	
	('137', '2', '02', '02', '0', '0', 	'DEUDAS FINANCIERAS A LARGO PLAZO','0'),
	('138', '2', '02', '02', '01', '0', 	'PRESTAMOS DE BANCOS Y OTRAS ENTIDADES FINANCIERAS','0'),
	('139', '2', '02', '02', '02', '0', 	'PRESTAMOS DEL DUEÑO, SOCIOS O ENTIDADES VINCULADAS','0'),
	('140', '2', '02', '02', '03', '0', 	'ARRENDAMIENTOS FINANCIEROS','0'),
	('141', '2', '02', '02', '04', '0', 	'OTROS PRESTAMOS','0'),
	('142', '2', '02', '02', '05', '0', 	'INTERESES A PAGAR','0'),
	
	('143', '2', '02', '03', '0', '0', 	'OTRAS CUENTAS POR PAGAR','0'),
	('144', '2', '02', '03', '01', '0', 	'PASIVOS POR IMPUESTOS DIFERIDOS','0'),
	('145', '2', '02', '03', '02', '0', 	'PASIVOS FIDUCIARIOS','0'),
	
	('146', '2', '02', '04', '0', '0', 	'PROVISIONES PARA OBLIGACIONES A LARGO PLAZO','0'),
	('147', '2', '02', '04', '01', '0', 	'OBLIGACIONES POR GARANTIAS OTORGADAS','0'),
	('148', '2', '02', '04', '02', '0', 	'OBLIGACIONES LEGALES POR LITIGIOS PENDIENTES','0'),
	('149', '2', '02', '04', '03', '0', 	'PROVISIONES PARA BENEFICIOS A EMPLEADOS','0'),
	
	('150', '2', '02', '05', '0', '0', 	'INGRESOS DIFERIDOS A LARGO PLAZO','0'),
	('151', '2', '02', '05', '01', '0', 	'ANTICIPOS DE CLIENTES','0'),
	('152', '2', '02', '05', '02', '0', 	'SUBVENCIONES','0'),
	('153', '2', '02', '05', '03', '0', 	'DERECHO DE FIDELIZACION DE CLIENTES','0'),
	('154', '2', '02', '05', '04', '0', 	'ALQUILERES COBRADOS POR ADELANTADO','0'),
	
	('155', '3', '0', '0', '0', '0', 		'PATRIMONIO NETO','0'),
	('156', '3', '01', '0', '0', '0', 		'CAPITAL','0'),
	('157', '3', '01', '01', '0', '0', 	'CAPITAL INTEGRADO','0'),
	('158', '3', '01', '01', '01', '0', 	'CAPITAL SUSCRIPTO','0'),
	('159', '3', '01', '01', '02', '0', 	'(-) CAPITAL A INTEGRAR','0'),
	
	('160', '3', '02', '0', '0', '0', 	'RESERVAS','0'),
	('161', '3', '02', '01', '0', '0', 	'RESERVA LEGAL','0'),
	('162', '3', '02', '02', '0', '0', 	'RESERVA DE REVALUO ','0'),
	('163', '3', '02', '02', '01', '0', 	'RESERVA DE REVALUO FISCAL','0'),
	('164', '3', '02', '02', '04', '0', 	'RESERVA DE REVALUO TECNICO','0'),
	('165', '3', '02', '03', '0', '0', 	'OTRAS RESERVAS','0'),
	
	('166', '3', '03', '0', '0', '0', 		'RESULTADOS','0'),
	('167', '3', '03', '01', '0', '0', 	'RESULTADOS ACUMULADOS','0'),
	('168', '3', '03', '02', '0', '0', 	'RESULTADOS DEL EJERCICIO','0'),
	
	('169', '4', '0', '0', '0', '0', 		'INGRESOS OPERATIVOS','0'),
	('170', '4', '01', '0', '0', '0', 		'VENTAS DE MERCADERIAS','0'),
	('171', '4', '01', '01', '0', '0', 	'VENTAS DE MERCADERIAS GRAVADAS POR EL IVA','0'),
	('172', '4', '01', '02', '0', '0', 	'VENTAS DE MERCADERIAS EXENTAS DEL IVA','0'),
	('173', '4', '02', '0', '0', '0', 		'VENTAS DE PRODUCTOS AGRICOLAS','0'),
	('174', '4', '02', '01', '0', '0', 	'VENTAS DE SOJA Y SUS DERIVADOS','0'),
	('175', '4', '02', '02', '0', '0', 	'VENTAS DE MAIZ','0'),
	('176', '4', '02', '03', '0', '0', 	'VENTAS DE TRIGO','0'),
	('177', '4', '02', '04', '0', '0', 	'OTROS PRODUCTOS AGRICOLAS','0'),
	('178', '4', '03', '0', '0', '0', 		'VENTAS DE GANADO','0'),
	('179', '4', '04', '0', '0', '0', 		'VENTAS DE PRODUCTOS FRUTICOLAS Y HORTICOLAS','0'),
	('180', '4', '05', '0', '0', '0', 		'VENTAS DE PRODUYCTOS DE LA EXPLOTACION FORESTAL','0'),
	('181', '4', '06', '0', '0', '0', 		'EXPORTACIONES DE PRODUCTOS AGRICOLAS EXPORTADOS','0'),
	('182', '4', '06', '01', '0', '0', 	'EXPORTACIONES DE SOJA Y SUS DERIVADOS','0'),
	('183', '4', '06', '01', '01', '0', 	'EXPORTACIONES A EMPRESAS VINCULADAS','0'),
	('184', '4', '06', '01', '02', '0', 	'EXPORTACIONES A TERCEROS NO VINCULADOS','0'),
	('185', '4', '06', '02', '0', '0', 	'EXPORTACIONES DE OTROS PRODUCTOS AGRICOLAS','0'),
	('186', '4', '07', '0', '0', '0', 		'EXPORTACION DE BIENES INDUSTRIALIZADOS','0'),
	('187', '4', '07', '01', '0', '0',	'EXPORTACION DE PRODUCTOS FARMACEUTICOS','0'),
	('188', '4', '07', '02', '0', '0',	'EXPORTACION DE MAQUINARIAS Y EQUIPOS','0'),
	('189', '4', '07', '03', '0', '0',	'EXPORTACION DE OTROS PRODUCTOS INDUSTRIALIZADOS','0'),
	('190', '4', '08', '0', '0', '0',		'EXPORTACION DE OTROS PRODUCTOS','0'),
	('191', '4', '09', '0', '0', '0',		'VENTAS DE SERVICIOS GRAVADOS','0'),
	('192', '4', '10', '0', '0', '0',		'VENTAS DE BIENES - REGIMENES ESPECIALES','0'),
	('193', '4', '10', '01', '0', '0',	'VENTAS DE MERCADERIAS - REGIMENES DE TURISMO','0'),
	('194', '4', '10', '01', '01', '0',	'VENTAS A EXTRANJEROS','0'),
	('195', '4', '10', '01', '02', '0',	'VENTAS A DISTRIBUIDORES LOCALES','0'),
	('196', '4', '10', '01', '03', '0',	'VENTAS A CLIENTES LOCALES','0'),
	('197', '4', '10', '02', '0', '0',	'VENTAS DE MERCADERIAS - ZONA FRANCA','0'),
	('198', '4', '10', '03', '0', '0',	'VENTAS POR REGIMEN DE MAQUILA','0'),
	('199', '4', '10', '04', '0', '0',	'VENTAS BAJO OTROS REGIMENES ESPECIALES','0'),
	('200', '4', '11', '0', '0', '0',		'OTRAS VENTAS EXENTAS DEL IVA','0'),
	('201', '4', '98', '0', '0', '0',		'(-) DESCUENTOS CONCEDIDOS','0'),
	('202', '4', '99', '0', '0', '0',		'(-) DEVOLUCIONES','0'),
	
	('203', '5', '0', '0', '0', '0',		'COSTOS OPERATIVOS','0'),
	('204', '5', '01', '0', '0', '0',		'COSTO DE MERCADERIAS','0'),
	('205', '5', '01', '01', '0', '0',	'COSTO DE MERCADERIAS GRAVADAS POR EL IVA','0'),
	('206', '5', '01', '02', '0', '0',	'COSTO DE MERCADERIAS EXENTAS DEL IVA','0'),
	('207', '5', '02', '0', '0', '0',		'COSTO DE PRODUCTOS AGRICOLAS','0'),
	('208', '5', '02', '01', '0', '0',	'COSTO DE VENTAS DE SOJA Y SUS DERIVADOS','0'),
	('209', '5', '02', '02', '0', '0',	'COSTO DE VENTAS DE MAIZ','0'),
	('210', '5', '02', '03', '0', '0',	'COSTO DE VENTAS DE TRIGO','0'),
	('211', '5', '02', '04', '0', '0',	'COSTO DE VENTAS DE OTROS PRODUCTOS AGRICOLAS','0'),
	('212', '5', '03', '0', '0', '0',		'COSTO DE VENTAS DE PRODUCTOS DE GANADO','0'),	
	('213', '5', '04', '0', '0', '0',		'COSTO DE VENTAS DE PRODUCTOS FRUTICOLAS Y HORTICOLAS','0'),
	('214', '5', '05', '0', '0', '0',		'COSTO DE VENTAS DE PRODUCTOS DE LA EXPLOTACION FORESTAL','0'),
	('215', '5', '06', '0', '0', '0',		'COSTO DE PRODUCTOS AGRICOLAS EXPORTADOS','0'),
	('216', '5', '06', '01', '0', '0',	'COSTO DE SOJA Y SUS DERIVADOS EXPORTADOS','0'),
	('217', '5', '06', '01', '01', '0',	'COSTO DE EXPORTACIONES A EMPRESAS VINCULADAS','0'),
	('218', '5', '06', '01', '02', '0',	'COSTO DE EXPORTACIONES A TERCEROS NO VINCULADOS','0'),
	('219', '5', '06', '02', '0', '0',	'COSTO DE OTROS PRODUCTOS AGRICOLAS EXPORTADORES','0'),
	('220', '5', '07', '0', '0', '0',		'COSTO DE BIENES INDUSTRIALIZADOS EXPORTADOS','0'),
	('221', '5', '07', '01', '0', '0',	'COSTO DE PRODUCTOS FARMACEUTICOS EXPORTADOS','0'),
	('222', '5', '07', '02', '0', '0',	'COSTO DE MAQUINARIAS Y EQUIPOS EXPORTADOS','0'),
	('223', '5', '07', '03', '0', '0',	'COSTO DE OTROS PRODUCTOS INSUTRIALIZADOS','0'),
	('224', '5', '08', '0', '0', '0',		'COSTO DE OTROS PRODUCTOS EXPORTADOS','0'),
	('225', '5', '09', '0', '0', '0',		'COSTO DE SERVICIOS GRAVADOS','0'),
	('226', '5', '10', '0', '0', '0',		'COSTO DE VENTAS DE BIENES - REGIMENES ESPECIALES','0'),
	('227', '5', '10', '01', '0', '0',	'COSTO DE VENTAS DE MERCADERIAS - REGIMEN DE TURISMO','0'),
	('228', '5', '10', '01', '01', '0',	'COSTO DE VENTAS A EXTRANJEROS','0'),
	('229', '5', '10', '01', '02', '0',	'COSTO DE VENTAS A DISTRIBUIDORES LOCALES','0'),
	('230', '5', '10', '01', '03', '0',	'COSTO DE VENTAS A CLIENTES LOCALES','0'),
	('231', '5', '10', '02', '0', '0',	'COSTO DE VENTAS DE MERCADERIAS - ZONA FRANCA','0'),
	('232', '5', '10', '03', '0', '0',	'COSTO DE VENTAS DE REGIMEN DE MAQUILA','0'),
	('233', '5', '10', '04', '0', '0',	'COSTO DE VENTAS POR REGINEN ','0'),
	('234', '5', '11', '0', '0', '0',		'COSTO DE VENTAS EXENTAS DEL IVA','0'),
	
	('235', '6', '0', '0', '0', '0',		'GANANCIAS (O PERDIDAS) BRUTAS EN VENTAS','0'),
	
	('236', '7', '0', '0', '0', '0',		'INGRESOS POR ACTIVOS BIOLOGICOS','0'),
	('237', '7', '01', '0', '0', '0',		'INGRESOS POR PRODUCCION Y/O TENENCIA DE ACTIVOS BIOLOGICOS','0'),
	('238', '7', '01', '01', '0', '0',	'INGRESOS POR PRODUCCION Y/O TENENCIA DE BIENES DEL SECTOR AGRICOLA','0'),
	('239', '7', '01', '02', '0', '0',	'INGRESOS POR PRODUCCION Y/O TENENCIA DE GANADO','0'),
	('240', '7', '01', '03', '0', '0',	'INGRESOS POR PRODUCCION Y/O TENENCIA DE BIENES DE LA ACTIVIDAD FORESTAL','0'),
	
	('241', '7', '02', '0', '0', '0',		'(-) COSTO DE PRODUCCION Y/O TENENCIA DE ACTIVOS BIOLOGICOS','0'),
	('242', '7', '02', '01', '0', '0',	'(-) COSTO DE PRODUCCION Y/O TENENCIA DE BINES DEL SECTOR AGRICOLA','0'),
	('243', '7', '02', '02', '0', '0',	'(-) COSTO DE PRODUCCION Y/O TENENCIA DE GANADO','0'),
	('244', '7', '02', '03', '0', '0',	'(-) COSTO DE PRODUCCION Y/O TENENCIA DE BINES DE LA ACTIVIDAD FORESTAL','0'),
	('245', '7', '02', '04', '0', '0',	'(-) MERMAS Y MORTANDAD','0'),
	
	('246', '8', '0', '0', '0', '0',		'OTROS INGRESOS','0'),
	('247', '8', '01', '0', '0', '0',		'INTERESES GANADOS','0'),
	('248', '8', '02', '0', '0', '0',		'COMISIONES COBRADAS','0'),
	('249', '8', '03', '0', '0', '0',		'DESCUENTOS OBTENIDOS','0'),
	('250', '8', '04', '0', '0', '0',		'SUBVENCIONES','0'),
	('251', '8', '05', '0', '0', '0',		'RESULTADO POR DIFERENCIA DE CAMBIO','0'),
	
	('252', '9', '0', '0', '0', '0',		'GANANCIAS (O PERDIDAS) BRUTAS TOTALES','0'),
	
	('253', '10', '0', '0', '0', '0',		'GASTOS DE VENTAS O COMERCIALIZACION','0'),
	('254', '10', '01', '0', '0', '0',		'SUELDOS Y OTRAS REMUNERACIONES AL PERSONAL','0'),
	('255', '10', '01', '01', '0', '0',	'SUELDOS Y JORNALES','0'),
	('256', '10', '01', '02', '0', '0',	'APORTE PATRONAL','0'),
	('257', '10', '01', '03', '0', '0',	'OTROS BENEFICIOS AL PERSONAL','0'),
	('258', '10', '02', '0', '0', '0',		'COMISIONES PAGADAS SOBRE VENTAS','0'),
	('259', '10', '03', '0', '0', '0',		'VIATICOS A VENDEDORES','0'),
	('260', '10', '04', '0', '0', '0',		'PUBLICIDAD Y PROPAGANDA','0'),
	('261', '10', '05', '0', '0', '0',		'FLETES PAGADOS','0'),
	
	('262', '11', '0', '0', '0', '0',		'GASTOS DE ADMINISTRACION','0'),
	('263', '11', '01', '0', '0', '0',		'SUELDOS Y OTRAS REMUNERACIONES DEL PERSONAL','0'),
	('264', '11', '01', '01', '0', '0',	'SUELDOS Y JORNALES','0'),
	('265', '11', '01', '02', '0', '0',	'APORTE PATRONAL','0'),
	('266', '11', '01', '03', '0', '0',	'OTROS BENEFICIOS AL PERSONAL','0'),
	('267', '11', '02', '0', '0', '0',		'REMUNERACION PERSONAL SUPERIOR','0'),
	('268', '11', '03', '0', '0', '0',		'GASTOS DE REPRESENTACION','0'),
	('269', '11', '04', '0', '0', '0',		'HONORARIOS PROFESIONALES','0'),
	('270', '11', '05', '0', '0', '0',		'ALQUILERES','0'),
	('271', '11', '06', '0', '0', '0',		'AGUA, LUZ, TELEFONO E INTERNET','0'),
	('272', '11', '07', '0', '0', '0',		'MOVILIDAD','0'),
	('273', '11', '08', '0', '0', '0',		'COMBUSTIBLES Y LUBRICANTES','0'),
	('274', '11', '09', '0', '0', '0',		'REPARACIONES Y MANTENIMIENTOS','0'),
	('275', '11', '10', '0', '0', '0',		'SEGUROS PAGADOS','0'),
	('276', '11', '11', '0', '0', '0',		'UTILES DE OFICINA','0'),
	('277', '11', '12', '0', '0', '0',		'GASTOS PAGADOS EN EL EXTERIOR','0'),
	('278', '11', '13', '0', '0', '0',		'JUICIOS Y GASTOS JUDICIALES','0'),
	('279', '11', '14', '0', '0', '0',		'GASTOS DE COBRANZA','0'),
	('280', '11', '15', '0', '0', '0',		'DONACIONES Y CONTRIBUCIONES','0'),
	('281', '11', '16', '0', '0', '0',		'COMISIONES Y GASTOS BANCARIOS OPERACIONALES','0'),
	('282', '11', '17', '0', '0', '0',		'IMPUESTOS, PATENTES, TASAS Y OTRAS CONTRIBUCIONES','0'),
	('283', '11', '18', '0', '0', '0',		'MULTAS Y SANCIONES','0'),
	
	('284', '12', '0', '0', '0', '0',		'GANACIAS (O PERDIDAS) ANTES DE GASTOS FINANCIEROS','0'),
	
	('285', '13', '0', '0', '0', '0',		'GASTOS BANCARIOS Y FINANCIEROS','0'),
	('286', '13', '01', '0', '0', '0',		'INTERESES PAGADOS A ENTIDADES BANCARIAS Y FINANCIERAS','0'),
	('287', '13', '02', '0', '0', '0',		'OTROS INTERESES PAGADOS','0'),
	('288', '13', '03', '0', '0', '0',		'COMISIONES Y GASTOS BANCARIOS SOBRE OPERACIONES CREDITICIAS','0'),
	('289', '13', '04', '0', '0', '0',		'RESULTADO POR DIFERENCIA DE CAMBIO','0'),
	
	('290', '14', '0', '0', '0', '0',		'PREVISIONES','0'),
	('291', '14', '01', '0', '0', '0',		'DESAFECTACION DE PREVISIONES','0'),
	('292', '14', '02', '0', '0', '0',		'(-) CONSTITUICION DE PREVICIONES','0'),
	
	('293', '15', '0', '0', '0', '0',		'DEPRECIACIONES Y AMORTIZACIONES DE ACTIVOSW','0'),
	('294', '15', '01', '0', '0', '0',		'DEPRECIACIONES DEL EJERCICIO','0'),
	('295', '15', '02', '0', '0', '0',		'AMORTIZACIONES DEL EJERCICIO','0'),
		
	('296', '16', '0', '0', '0', '0',		'GANACIAS (O PERDIDAS) OPERATIVAS','0'),	
	
	('297', '17', '0', '0', '0', '0',		'OTROS RESULTADOS NO OPERATIVOS','0'),
	('298', '17', '01', '0', '0', '0',		'UTILIDAD/PERDIDA EN VENTA DE ACTIVOS FIJOS','0'),
	('299', '17', '02', '0', '0', '0',		'UTILIDAD/PERDIDA EN VENTA DE INVERSIONES','0'),
	('300', '17', '03', '0', '0', '0',		'CUENTAS INCOBRABLES RECUPERADAS','0'),
	
	('301', '18', '0', '0', '0', '0',		'GANACIAS (O PERDIDAS) ANTES DEL IMPUESTO A LA RENTA','0'),
	
	('302', '19', '0', '0', '0', '0',		'IMPUESTO A LA RENTA','0'),
	
	('303', '20', '0', '0', '0', '0',		'GANANCIAS/PERDIDAS NETAS DEL EJERCICIO','0'),
	('304', '1', '1', '3', '5', '5',		'IVA - CREDITO FISCAL 5%','0');
	
	INSERT INTO parametro VALUES 
('1', '21','304','0','5');