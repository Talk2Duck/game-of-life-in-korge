data class Cell(val x: Int, val y: Int) {
    fun adjustBy(deltaX: Int, deltaY: Int): Cell = Cell(x + deltaX, y + deltaY)
}

data class Board(val populatedCells: Set<Cell> = emptySet()) {

    fun evolve(): Board {
        val evolvedUnpopulatedCells = populatedCells
            .flatMap(::unpopulatedNeighboursOf)
            .mapNotNull { cell -> if (populatedNeighboursOf(cell).size == 3) cell else null }

        val evolvedPopulatedCells = populatedCells
            .mapNotNull { cell -> if (populatedNeighboursOf(cell).size in 2..3) cell else null }
            .toSet()

        return Board(evolvedPopulatedCells.union(evolvedUnpopulatedCells))
    }

    internal fun isPopulated(cell: Cell) = populatedCells.contains(cell)
    internal fun populatedNeighboursOf(cell: Cell) = populatedCells.intersect(neighboursOf(cell))
    internal fun unpopulatedNeighboursOf(cell: Cell) = (neighboursOf(cell) - populatedCells).toSet()

    private fun neighboursOf(cell: Cell) = listOf(
        -1 to -1, 0 to -1, 1 to -1,
        -1 to 0, /*cell*/ 1 to 0,
        -1 to 1, 0 to 1, 1 to 1
    ).map { cell.adjustBy(it.first, it.second) }

}
