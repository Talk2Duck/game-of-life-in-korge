import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GameOfLifeTest {

    private fun cell(x: Int, y: Int) = Cell(x, y)
    private fun board(vararg livingCells: Cell) = Board(livingCells.toSet())

    @Test
    fun `should return cell adjusted by given x and y delta`() {
        assertEquals(cell(1, 2), cell(1, 1).adjustBy(0, 1))
        assertEquals(cell(1, 0), cell(1, 1).adjustBy(0, -1))
        assertEquals(cell(2, 1), cell(1, 1).adjustBy(1, 0))
        assertEquals(cell(0, 1), cell(1, 1).adjustBy(-1, 0))
    }

    @Test
    fun `should return populated neighbours of given cell on the board`() {
        assertEquals(
            setOf(cell(1, 2), cell(2, 0)),
            board(cell(1, 1), cell(1, 2), cell(2, 0)).populatedNeighboursOf(cell(1, 1))
        )
        assertEquals(emptySet<Cell>(), board().populatedNeighboursOf(cell(1, 1)))
    }

    @Test
    fun `should return unpopulated neighbours of given cell on the board`() {
        assertEquals(
            setOf(cell(0, 0), cell(1, 0), cell(0, 1), cell(2, 1), cell(0, 2), cell(2, 2)),
            board(cell(1, 1), cell(1, 2), cell(2, 0)).unpopulatedNeighboursOf(cell(1, 1))
        )
    }

    @Test
    fun `should correctly check if cell is populated`() {
        val board = board(cell(1, 1), cell(1, 2), cell(2, 0))
        assertTrue(board.isPopulated(cell(1, 1)))
        assertFalse(board.isPopulated(cell(0, 1)))
    }

    @Test
    fun `empty board should evolve to empty board`() {
        assertEquals(board(), board().evolve())
    }

    @Test
    fun `cell should become unpopulated when not surrounded by any populated neighbours`() {
        assertEquals(board(), board(cell(1, 1)).evolve())
    }

    @Test
    fun `cells should become unpopulated when only one neighbour is populated`() {
        assertEquals(board(), board(cell(1, 1), cell(2, 2)).evolve())
    }

    @Test
    fun `cell should stay populated when two neighbours are populated`() {
        assertTrue(board(cell(1, 1), cell(1, 2), cell(2, 0)).evolve().isPopulated(cell(1, 1)))
    }

    @Test
    fun `cell should stay populated when three neighbours are populated`() {
        assertTrue(board(cell(0, 1), cell(1, 1), cell(2, 0), cell(2, 2)).evolve().isPopulated(cell(1, 1)))
    }

    @Test
    fun `unpopulated cell should become populated when surrounded by three populated neighbours`() {
        assertEquals(
            board(cell(1, 0), cell(1, 1), cell(1, 2), cell(2, 1)),
            board(cell(0, 1), cell(1, 1), cell(2, 0), cell(2, 2)).evolve()
        )
    }

}
