<h1>Candy Crush Académico</h1>
<h2> Introducción </h2>
<p>La aplicación es una versión académica y muy reducida del juego "Candy Crush" realizado para la materia <b>Programación Orientada a Objetos</b> en el lenguaje <b>JAVA</b>. El juego
consiste en una grilla orientada verticalmente, donde caen y se apilan caramelos de diferentes
colores. La mecánica del juego consiste en elegir un par de caramelos adyacentes para intercambiar
sus posiciones. Este intercambio es válido solo si al realizarlo se forma alguna figura válida con
caramelos de un mismo color. Las figuras son líneas horizontales o verticales de 3, 4 o 5 caramelos, o bien una T (de tres
caramelos en línea y dos perpendiculares en el medio) en cualquier orientación, o bien una L en
cualquier orientación.</p>
<h2> Mecánica del juego </h2>
<p>El juego consta de tres niveles:</p>

<div align="center">
    <img src="/resources/images/levels.png" </img> 
</div>
<ul>
  <li><b>Level 1:</b> En este nivel se deben lograr 5000 puntos en sólo 20 movimientos</li>
  <li><b>Level 2: Golden Board:</b> El objetivo de este nivel es que todo el tablero se convierta en oro. Para ello es necesario
hacer intercambios. Intercambios horizontales válidos transforman la fila en cuestión en dorado.
Intercambios verticales válidos transforman la columna en cuestión en dorado. Si una fila o
columna ya es dorada y se realizan intercambios válidos sobre la misma, no hace nada.</li>
  <li><b>Level 3: WallBlast:</b> Se define en el tablero en una posición definida una pared compuesta por varias celdas
contiguas. Cada celda de la pared sólo puede romperse por explosiones de candys especiales. Si la
explosión de un candy especial pasa por una celda de la pared, esta celda se rompe. Por ejemplo la
explosión de un caramelo especial horizontal eliminará todas las celdas de la pared que estén en la
fila de la explosión. Cuando se rompen todas las partes de la pared del tablero, el nivel se da por ganado.</li>
</ul>


<div align="center">
    <h4>Golden Board</h4>
    <img src="/resources/images/goldenboard.png" </img> 
</div>


<div align="center">
    <h4>WallBlast</h4>
    <img src="/resources/images/wallblast.png" </img> 
</div>

<h2> Diseño y diagramas </h2>


<div align="center">
    <h4>Elements</h4>
    <img src="/resources/images/elementUML.png" </img> 
</div>


<div align="center">
    <h4>Moves</h4>
    <img src="/resources/images/moveUML.png" </img> 
</div>


<div align="center">
    <h4>Levels</h4>
    <img src="/resources/images/levelUML.png" </img> 
</div>

<h2>Autores</h2>
<ul>
  <li><a href="https://github.com/ssandrini">Santiago Sandrini</a></li>
  <li><a href="https://github.com/solkonfe">Sol Konfederak</a></li>
</ul>
