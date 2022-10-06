package hu.nye.progtech.foxandhounds.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class MapVO {

    private final int numberOfRows;
    private final int numberOfColumns;
    private final int[][] values;
    private final boolean[][] fixed;

    public MapVO(int numberOfRows, int numberOfColums, int[][] values, boolean[][] fixed) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColums;
        this.values = deepCopy(values);
        this.fixed = deepCopy(fixed);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int[][] getValues() {
        return deepCopy(values);
    }

    public boolean[][] getFixed() {
        return deepCopy(fixed);
    }

    private int[][] deepCopy(int[][]array){
        int[][]result = null;

        if(array!=null){
            result = new int[array.length][];
            for(int i=0;i<array.length;i++){
                result[i]=Arrays.copyOf(array[i],array[i].length);
            }
        }
        return result;
    }
    private boolean[][] deepCopy(boolean[][]array){
        boolean[][]result = null;

        if(array!=null){
            result = new boolean[array.length][];
            for(int i=0;i<array.length;i++){
                result[i]=Arrays.copyOf(array[i],array[i].length);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapVO mapVO = (MapVO) o;
        return numberOfRows == mapVO.numberOfRows && numberOfColumns == mapVO.numberOfColumns && Arrays.deepEquals(values, mapVO.values) && Arrays.deepEquals(fixed, mapVO.fixed);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRows, numberOfColumns);
        result = 31 * result + Arrays.deepHashCode(values);
        result = 31 * result + Arrays.deepHashCode(fixed);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MapVO.class.getSimpleName() + "[", "]")
                .add("numberOfRows=" + numberOfRows)
                .add("numberOfColums=" + numberOfColumns)
                .add("values=" + Arrays.deepToString(values))
                .add("fixed=" + Arrays.deepToString(fixed))
                .toString();
    }
}
