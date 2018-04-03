package ru.job4j.chess.models;

import ru.job4j.chess.exeptions.FigureNotFoundException;
import ru.job4j.chess.exeptions.ImposibleMoveException;
import ru.job4j.chess.exeptions.OccupiedWayException;
import ru.job4j.chess.interfaces.implemented.Figure;

/**
 * @author Vladimir Yamnikov (Androedge@gmail.com).
 * @version $2$.
 * @since 02.04.2018.
 */
public class Board {
    /**
     * Отображение оси символов, в этой задаче буквы заменены на числа.
     */
    private final String[] columns = {"0", "1", "2", "3", "4", "5", "6", "7"};
    /**
     * Число строк шахматной доски, в этой задаче начинаются с 0.
     */
    private final int lineNumbers = 8;
    /**
     * Массив ячеек шахматной доски. Используется для отрисовки символов и индикатора занятости клетки.
     */
    private final Cell[][] cells = new Cell[lineNumbers][columns.length];
    /**
     * Символ "чёрный квадрат" в unicode.
     */
    private String blackSquare = "\u25A0";
    /**
     * Символ "белый квадрат" в unicode.
     */
    private String whiteSquare = "\u25A1";
    /**
     * Массив для фигур.
     */
    private final Figure[] figures = new Figure[32];
    /**
     * Индекс для добавления в массив фигур.
     */
    private int index = 0;

    public Cell[][] getCells() {
        return cells;
    }

    /**
     * Первоначальное заполнение шахматной доски символами чёрный или белый квадрат.
     */
    public void init() {
        for (int i = 0; i < lineNumbers; i++) {
            for (int j = 0; j < columns.length; j++) {
                Cell tmp = new Cell(i, j);
                if (i % 2 == 0) {
                    if (j % 2 != 0) {
                        tmp.setSymbol(blackSquare);
                    } else {
                        tmp.setSymbol(whiteSquare);
                    }

                } else {
                    if (j % 2 != 0) {
                        tmp.setSymbol(whiteSquare);
                    } else {
                        tmp.setSymbol(blackSquare);
                    }
                }
                this.cells[i][j] = tmp;
            }
        }
    }

    /**
     * Вывод изображения шахматной доски на консоль. Считывает символ в клетке.
     */
    public void showBoard() {
        System.out.print("\n");
        for (int i = 0; i < lineNumbers; i++) {
            System.out.printf("%s  ", i);
            for (int j = 0; j < columns.length; j++) {
                System.out.printf("%s ", cells[i][j].getSymbol());
            }
            System.out.println();
        }
        System.out.print("  ");
        for (String column : columns) {
            System.out.printf(" %s", column);
        }
        System.out.print("\n");
    }

    /**
     * Добавление шахматной фигуры в массив. При добавлении новой фигуры отрисовывает все остальные снова.
     * Занятые клетки помечаются как setOccupied(true). Перезаписываются символы фигур в клетки.
     * @param figure Фигура.
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;

        for (Figure figureObj : figures) {
            if (figureObj != null) {
                this.cells[figureObj.getPosition().getCoordinateX()][figureObj.getPosition().getCoordinateY()].setOccupied(true);
                this.cells[figureObj.getPosition().getCoordinateX()][figureObj.getPosition().getCoordinateY()].setSymbol(figureObj.getSymbol());
            }
        }
    }

    /**
     * Отрисовывает ходы фигуры на доске, добавляет в массив cells. Нужен для визуального теста.
     * @param figure Сама фигура.
     * @param possibleMove Возможный ход.
     */
    public void setMovesOnBoard(Figure figure, Cell possibleMove) {
        Cell[] moves = figure.way(figure.getPosition(), possibleMove);
        for (Cell move : moves) {
            int coordX = move.getCoordinateX();
            int coordY = move.getCoordinateY();

            if (!this.cells[coordX][coordY].isOccupied()) {
                this.cells[coordX][coordY].setSymbol("\u001B[32m" + "x" + "\u001B[0m"); // Цвет отображения символов на зелёный и последующий сброс обратно на настройки по умолчанию.
            }
        }
    }

    /**
     * Возвращает true, если есть фигура на клетке доски и если можно пойти на указываемую клетку. Метод построен по такому принципу.
     * Если фигуры нет на клетке - вылетает исключение, если фигура не может совершить ход - вылетает исключение.
     * Если на пути хода фигуры находится другая фигура - вылетает исключение. Только пройдя весь код и при отсутствии исключений.
     * Возвращается true.
     * @param source Клетка для анализа.
     * @param dest Клетка назначения.
     * @return true, если пройден весб код последовательно и не выданно исключений.
     * @throws ImposibleMoveException Исключение невозможности совершить ход.
     * @throws OccupiedWayException Исключение наличие фигуры на пути.
     * @throws FigureNotFoundException Исключение отсутствия фигуры на клетке. Пустая клетка.
     */
    public boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure sourceFigure = null;
        Cell[] waysToMove = null;
        int sourceCoordX = source.getCoordinateX();
        int sourceCoordY = source.getCoordinateY();
        if (this.cells[sourceCoordX][sourceCoordY].isOccupied()) {
            for (Figure figure : this.figures) {
                if (figure != null && figure.getPosition().getCoordinateX() == sourceCoordX && figure.getPosition().getCoordinateY() == sourceCoordY) {
                    sourceFigure = figure;
                    break;
                }
            }
        } else {
            throw new FigureNotFoundException("This cell is Empty!");
        }

        waysToMove = sourceFigure.way(source, dest);

        Figure tmp;
        for (Figure figure : figures) {
            if (figure != null) {
                for (Cell cell : waysToMove) {
                    if (cell.getCoordinateX() == figure.getPosition().getCoordinateX() && cell.getCoordinateY() == figure.getPosition().getCoordinateY()) {
                        throw new OccupiedWayException("This cell is Occupied!");
                    }
                }
            }
        }
        tmp = sourceFigure.copy(dest);
        rebuildFigure(sourceFigure, tmp);
        return true;
    }

    /**
     * Пересоздание фигуры, старая(старое положение) затирается в массиве, новая добавляется.
     * И сразу перерисовываетсявсё поле.
     * @param old Старая фигура(старое положение).
     * @param newOne Новая фигура для добавления.
     */
    private void rebuildFigure(Figure old, Figure newOne) {
        int index = 0;

        for (Figure figure : figures) {
            if (figure != null && figure.getPosition().getCoordinateX() == old.getPosition().getCoordinateX()
                    &&
                    figure.getPosition().getCoordinateY() == old.getPosition().getCoordinateY()) {
                break;
            }
            index++;
        }
        this.figures[index] = null;
        this.init();
        this.add(newOne);
        this.showBoard();
    }

//    /**
//     * Устанавливает все фигуры в начальное положение в соответствии с правилами игры. Возможность использования для дальнейшей реализации.
//     */
//    public void figureInitialLocation() {
//        this.add(new Rook(this.cells[0][0], "black"));
//        this.add(new Rook(this.cells[0][7], "black"));
//        this.add(new Knight(this.cells[0][1], "black"));
//        this.add(new Knight(this.cells[0][6], "black"));
//        this.add(new Bishop(this.cells[0][2], "black"));
//        this.add(new Bishop(this.cells[0][5], "black"));
//        this.add(new Queen(this.cells[0][3], "black"));
//        this.add(new King(this.cells[0][4], "black"));
//        for (int i = 1; i < 2; i++) {
//            for (int j = 0; j < this.columns.length; j++) {
//                this.add(new Pawn(this.cells[i][j], "black"));
//            }
//
//        }

//        this.add(new Rook(this.cells[7][0], "white"));
//        this.add(new Rook(this.cells[7][7], "white"));
//        this.add(new Knight(this.cells[7][1], "white"));
//        this.add(new Knight(this.cells[7][6], "white"));
//        this.add(new Bishop(this.cells[7][2], "white"));
        //this.add(new Bishop(this.cells[7][5], "white"));
        //this.add(new Bishop(this.cells[5][3], "white"));
//        this.add(new Queen(this.cells[7][3], "white"));
//        this.add(new King(this.cells[7][4], "white"));
//        for (int i = 6; i < 7; i++) {
//            for (int j = 0; j < this.columns.length; j++) {
//                this.add(new Pawn(this.cells[i][j], "white"));
//            }
//        }

//        for (Figure figure : figures) {
//            if (figure != null) {
//                this.cells[figure.getPosition().getCoordinateX()][figure.getPosition().getCoordinateY()].setOccupied(true);
//                this.cells[figure.getPosition().getCoordinateX()][figure.getPosition().getCoordinateY()].setSymbol(figure.getSymbol());
//            }
//        }
//    }

}
