CREATE TABLE `arrays` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `input_array` varchar(20) NOT NULL
) ;

--
-- Volcado de datos para la tabla `arrays`
--

INSERT INTO `arrays` (`input_array`) VALUES
('2,4,5,6,7,8'),
('3,7,9,5,4,2'),
('5,7,9,11,13'),
('6,4,2,12,15'),
('7,10,15,11,9');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `arrays`
--
ALTER TABLE `arrays`
  ADD PRIMARY KEY (`id`);
