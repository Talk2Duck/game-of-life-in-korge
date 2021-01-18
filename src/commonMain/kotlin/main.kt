import com.soywiz.klock.milliseconds
import com.soywiz.korge.Korge
import com.soywiz.korge.view.Graphics
import com.soywiz.korge.view.graphics
import com.soywiz.korim.color.Colors
import com.soywiz.korim.vector.StrokeInfo
import com.soywiz.korio.async.delay
import com.soywiz.korio.async.launchImmediately
import com.soywiz.korma.geom.vector.line
import com.soywiz.korma.geom.vector.rect

val backgroundColor = Colors["#2B2B2B"]
val gridColor = Colors["#CEC0B220"]
val cellColor = Colors["#FF7F50"]
const val cellSize = 10
const val windowWidth: Int = 2000
const val windowHeight: Int = 1000
const val seedBoard = parasiteSeed

suspend fun main() = Korge(width = windowWidth, height = windowHeight, bgcolor = backgroundColor) {
    var currentBoard = asciiToBoard(seedBoard)

    graphics {
        launchImmediately {
            while (true) {
                clear()
                board(currentBoard)
                grid()
                currentBoard = currentBoard.evolve()
                delay(500.milliseconds)
            }
        }
    }
}

private fun Graphics.grid() {
    stroke(gridColor, StrokeInfo()) {
        for (x in 1 until windowWidth / cellSize) {
            line(x * cellSize, 0, x * cellSize, windowHeight)
        }

        for (y in 1 until windowHeight / cellSize) {
            line(0, y * cellSize, windowWidth, y * cellSize)
        }
    }
}

private fun Graphics.board(board: Board) {
    val centerX: Int = (windowWidth / cellSize) / 2
    val centerY: Int = (windowHeight / cellSize) / 2
    fill(cellColor) {
        for (cell in board.populatedCells) {
            val x1 = (centerX + cell.x - 1) * cellSize
            val y1 = (centerY + cell.y - 1) * cellSize
            rect(x1, y1, cellSize, cellSize)
        }
    }
}
