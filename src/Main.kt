import java.awt.event.KeyEvent
import kotlin.random.Random

fun main(args: Array<String>){
    var puzzle = arrayOf<Array<Int>>()

    for( i in 0..3){
        var array = arrayOf<Int>()
        for( j in 0..3){
            array += 0
        }
        puzzle += array
    }

    puzzle[Random.nextInt(0, 4)][Random.nextInt(0, 4)] = Random.nextInt(1, 3) * 2

    var x : Int
    var y : Int
    do{
        x = Random.nextInt(0, 4)
        y = Random.nextInt(0, 4)
    } while (puzzle[x][y] != 0)
    puzzle[x][y] = Random.nextInt(1, 3) * 2

    

    printPuzzle(puzzle)
    for(i in 0..10){
        println("step: $i")
        printPuzzle(downPuzzle(puzzle))
    }



}

fun printPuzzle(puzzle: Array<Array<Int>>) {
    for (y in 0..3) {
        for (x in 0..3) {
            var value = puzzle[x][y]
            print("$value")
        }
        println()
    }
}

fun upPuzzle(puzzle: Array<Array<Int>>) : Array<Array<Int>>{
    var move = false
    for(x in 0..3){
        for(y in 0..3){
            if(y < 3 &&  puzzle[x][y] > 0){
                for(yy in (y+1)..3){
                    if(puzzle[x][y] == puzzle[x][yy]){
                        puzzle[x][y] += puzzle[x][yy]
                        puzzle[x][yy] = 0
                        move = true
                        break
                    } else if(puzzle[x][yy] != 0){
                        break
                    }
                }
            }
        }
    }
    for(x in 0..3){
        for(y in 0..3){
            if(y >= 0 &&  puzzle[x][y] > 0){
                for(yy in (y-1) downTo 0){
                    if(puzzle[x][yy] != 0 && yy + 1 != y){
                        puzzle[x][yy + 1] = puzzle[x][y]
                        puzzle[x][y] = 0
                        move = true
                        break
                    } else if(puzzle[x][yy] == 0 && yy == 0){
                        puzzle[x][yy] = puzzle[x][y]
                        puzzle[x][y] = 0
                        move = true
                    }
                }
            }
        }
    }
    if(move) {
        var x: Int
        var y: Int
        do {
            x = Random.nextInt(0, 4)
            y = Random.nextInt(0, 4)
        } while (puzzle[x][y] != 0)
        puzzle[x][y] = Random.nextInt(1, 3) * 2
    }
    return puzzle
}


fun downPuzzle(puzzle: Array<Array<Int>>) : Array<Array<Int>>{
    var move = false
    for(x in 0..3){
        for(y in 3 downTo 0){
            if(y > 0 &&  puzzle[x][y] > 0){
                for(yy in (y-1) downTo 0){
                    if(puzzle[x][y] == puzzle[x][yy]){
                        puzzle[x][y] += puzzle[x][yy]
                        puzzle[x][yy] = 0
                        move = true
                        break
                    } else if(puzzle[x][yy] != 0){
                        break
                    }
                }
            }
        }
    }
    for(x in 0..3){
        for(y in 3 downTo 0){
            if(y < 4 &&  puzzle[x][y] > 0){
                for(yy in (y+1)..3){
                    if(puzzle[x][yy] != 0 && yy - 1 != y){
                        puzzle[x][yy - 1] = puzzle[x][y]
                        puzzle[x][y] = 0
                        move = true
                        break
                    } else if(puzzle[x][yy] == 0 && yy == 3){
                        puzzle[x][yy] = puzzle[x][y]
                        puzzle[x][y] = 0
                        move = true
                    }
                }
            }
        }
    }
    if(move) {
        var x: Int
        var y: Int
        do {
            x = Random.nextInt(0, 4)
            y = Random.nextInt(0, 4)
        } while (puzzle[x][y] != 0)
        puzzle[x][y] = Random.nextInt(1, 3) * 2
    }
    return puzzle
}

