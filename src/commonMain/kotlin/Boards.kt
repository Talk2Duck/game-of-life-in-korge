fun asciiToBoard(ascii: String): Board {
    val split = ascii.split('\n').map(String::trim).filterNot(String::isEmpty)
    val columns = split[0].length
    val rows = split.size
    val rowDelta = columns / 2
    val columnDelta = rows / 2

    val cells = mutableSetOf<Cell>()

    for (x in 0 until columns) {
        for (y in 0 until rows) {
            if (split[y][x] == '*') cells.add(Cell(-rowDelta + x, -columnDelta + y))
        }
    }
    return Board(cells)
}

const val ascii3 = """
    ......................................................**.......
	.....................................................**........
	...............................................**.....*........
	..............................................**.....**........
	................................................*....*.*..**...
	..................................................**...**.****.
	..................................................**..........*
	..............................................................*
	........................................................*......
	..........................................................**...
	...............................................................
	..........................................................***..
	.........................................................**..*.
	...............................**..........................*...
	..............................**...............................
	...............................*.*...................***..*....
	..........................*....***...................*..***....
	.........................*****.***..*.**................**.....
	.........................*..**......*...**.**.........**.**....
	...................................*....**...**.**.......**....
	...........................**..**.**..**.....**...**.*.*.......
	...................................*.......**.....**...........
	.....................***...*.....**.............**....*........
	.....................*.....*..*.**...................*.........
	......................*...**.*.................................
	.........................**...*.*..............................
	.............***..........*....................................
	.............*.....***..**.....................................
	..............*..**.***.**.....................................
	................*..........*...................................
	.................*.*.**....*...................................
	...................**.*........................................
	.................**...*.*......................................
	................**.............................................
	..................*............................................
	...............**..............................................
	..............***..............................................
	.............**.*..............................................
	............****.*.............................................
	.................***...........................................
	..................**...........................................
	..........***.**...............................................
	.........*...***...............................................
	............***................................................
	........*.*.*..................................................
	.......****....................................................
	.......*.......................................................
	........**.....................................................
	.........*..*..................................................
	**.............................................................
	*.*...***......................................................
	*...*....*.....................................................
	...**..........................................................
	...*.....*.....................................................

    """
const val ascii2 = """
    ...*..*..*..*..*..*..*..*..*..*..*...
	.***********************************.
	*...................................*
	.***********************************.
	.....................................
	.***********************************.
	*...................................*
	.***********************************.
	.....................................
	.***********************************.
	*...................................*
	.***********************************.
	.....................................
	.***********************************.
	*...................................*
	.*****************..****************.
	.....................................
	.***************......**************.
	*...............*....*..............*
	.****************....***************.
	.....................................
	.*************...****...************.
	*.................**................*
	.************............***********.
	.............*..........*............
	.**************........*************.
	*..............*......*.............*
	.***************......**************.
	..........**....*....*....**.........
	.*******......****..****......******.
	*.......*...**...*..*...**...*......*
	.*******.........*..*.........******.
	.........*.....*......*.....*........
	.*********......*....*......********.
	*.........*....**.**.**....*........*
	.***********....*....*....**********.
	............**....**....**...........
	.*******..***.*..*..*..*.***..******.
	*..............***..***.............*
	.*****......***.*....*.***......****.
	......*....*..............*....*.....
	.******........*......*........*****.
	*......*...**..*..**..*..**...*.....*
	.********.....*.**..**.*.....*******.
	.........*..*.**......**.*..*........
	.*********...**........**...********.
	*..........*..............*.........*
	.****************....***************.
	.................****................
	.*****************..****************.
	*...................................*
	.***********************************.
	...*..*..*..*..*..*..*..*..*..*..*...

"""


const val ascii1 = """
    ..................................................................*..*..*..*..*..*..*..*..*..*..*...
    .............**.................................................***********************************.
	.....**....**.*.*..............................................*...................................*
	....***....****.................................................***********************************.
	...**......**.....*.................................................................................
	..**..**...*..*..*..............................................***********************************.
	.**.....*.......*..**..........................................*...................................*
	.**.*...****....................................................***********************************.
	....*...**..**.*....................................................................................
	.....***....*.*.................................................***********************************.
	......**...**..*...............................................*...................................*
	......*.....*...................................................***********************************.
	.****.*..*..*...*...................................................................................
	.***...*****..*******.*.........................................***********************************.
	*.*....*..........*..**........................................*...................................*
	***.*...*...*.....***...........................................*****************..****************.
	.......*.*..*.......**..............................................................................
	.*...*.....**........**..*.*....................................***************......**************.
	....*.......*........***.*.***.................................*...............*....*..............*
	...*........***......*....*.....................................****************....***************.
	.....*......*.*.....*.*.............................................................................
	.....*......*.**...*....*.......................................*************...****...************.
	.............*.****...*.....*..*...............................*.................**................*
	............**..**.*.*...*.***..................................************............***********.
	.................*......*..***...***........................................*..........*............
	....................*..*......**................................**************........*************.
	................**....*..*..........**.........................*..............*......*.............*
	..................*.............*...*...........................***************......**************.
	................**....**........*........................................**....*....*....**.........
	.................*...***........*.*.*.*.........................*******......****..****......******.
	.................*....**........*.....**.......................*.......*...**...*..*...**...*......*
	........................*........*..***.........................*******.........*..*.........******.
	.....................*..*........*........*.............................*.....*......*.....*........
	..........................****........**...*....................*********......*....*......********.
	.......................*......**......**...*...................*.........*....**.**.**....*........*
	.......................*....*............*......................***********....*....*....**********.
	.......................*...............*...................................**....**....**...........
	.........................**.*.*.......*..*......................*******..***.*..*..*..*.***..******.
	.........................*....*.........***....................*..............***..***.............*
	............................***.**..*...*...*.**................*****......***.*....*.***......****.
	.............................*..**.*.....*...*..*....................*....*..............*....*.....
	.....................................**..*...*..................******........*......*........*****.
	..................................*.**.**.*..**...*............*......*...**..*..**..*..**...*.....*
	...............................*.....*...*.......*.*............********.....*.**..**.*.....*******.
	................................**............**...*....................*..*.**......**.*..*........
	......................................*.......**................*********...**........**...********.
	.......................................***...**..*.............*..........*..............*.........*
	......................................*..*.***..................****************....***************.
	......................................*....**...................................****................
	.......................................*........................*****************..****************.
	..........................................*..*.................*...................................*
	.........................................*......................***********************************.
	..........................................**......................*..*..*..*..*..*..*..*..*..*..*...
"""

const val ascii4 = """
    .............**.....................................
	.....**....**.*.*...................................
	....***....****.....................................
	...**......**.....*.................................
	..**..**...*..*..*..................................
	.**.....*.......*..**...............................
	.**.*...****........................................
	....*...**..**.*....................................
	.....***....*.*.....................................
	......**...**..*....................................
	......*.....*.......................................
	.****.*..*..*...*...................................
	.***...*****..*******.*.............................
	*.*....*..........*..**.............................
	***.*...*...*.....***...............................
	.......*.*..*.......**..............................
	.*...*.....**........**..*.*........................
	....*.......*........***.*.***......................
	...*........***......*....*.........................
	.....*......*.*.....*.*.............................
	.....*......*.**...*....*...........................
	.............*.****...*.....*..*....................
	............**..**.*.*...*.***......................
	.................*......*..***...***................
	....................*..*......**....................
	................**....*..*..........**..............
	..................*.............*...*...............
	................**....**........*...................
	.................*...***........*.*.*.*.............
	.................*....**........*.....**............
	........................*........*..***.............
	.....................*..*........*........*.........
	..........................****........**...*........
	.......................*......**......**...*........
	.......................*....*............*..........
	.......................*...............*............
	.........................**.*.*.......*..*..........
	.........................*....*.........***.........
	............................***.**..*...*...*.**....
	.............................*..**.*.....*...*..*...
	.....................................**..*...*......
	..................................*.**.**.*..**...*.
	...............................*.....*...*.......*.*
	................................**............**...*
	......................................*.......**....
	.......................................***...**..*..
	......................................*..*.***......
	......................................*....**.......
	.......................................*............
	..........................................*..*......
	.........................................*..........
	..........................................**........
"""


const val parasiteSeed = """
    	......*.............*.........
	.....***...........***........
	...**.***.........***.**......
	....*..*.**.....**.*..*.......
	.**.*....*.*...*.*....*.**....
	.**.*.*..*.**.**.*..*.*.**....
	.*........*.*.*.*........*....
	**.......**.*.*.**.......**...
	............*.*...............
	.......***.*...*.***..........
	......**...........**.........
	......*.....*....**..*........
	.....**....***...**..*........
	...........*.**...***.........
	............***....*..........
	............***...............
	............***...............
	............**................
	..............................
	...................*.*........
	....................**........
	...............**...*.........
	........**......**............
	.......**......*..............
	.........*....................
	..............................
	..............................
	.................**...........
	..........*......***..........
	.........***.*...***..........
	........**.*.....***..........
	........**......*.**..........
	........**......***....**.....
	........**.**....*.....*......
	.........**...........**......
	..........***.*...*.***.......
	...............*.*............
	...**.......**.*.*.**.......**
	....*........*.*.*.*........*.
	....**.*.*..*.**.**.*..*.*.**.
	....**.*....*.*...*.*....*.**.
	.......*..*.**.....**.*..*....
	......**.***.........***.**...
	........***...........***.....
	.........*.............*......
"""
