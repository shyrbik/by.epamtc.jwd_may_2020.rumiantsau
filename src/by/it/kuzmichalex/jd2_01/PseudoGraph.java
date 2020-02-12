package by.it.kuzmichalex.jd2_01;

import java.util.ArrayList;
import java.util.List;

class PseudoGraph {
    private List<Integer> graphList = new ArrayList<>(120);
    private int maxValue = 0;

    /**
     * Запоминаем значения и запоминаем максимальные значения
     */
    void add(int value) {
        this.graphList.add(value);
        if (value > maxValue) maxValue = value;
    }


    public String toString() {
        StringBuilder retValue = new StringBuilder();
        int xSize = graphList.size();
        if (xSize < 1) return ("graph is null");
        int ySize = maxValue+1;

        char[][] graphBuffer = new char[ySize][xSize];
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                Integer value = graphList.get(x);
                graphBuffer[y][x]=' ';
                if(value>y)graphBuffer[y][x]='.';
                if(value==y)graphBuffer[y][x]='*';

            }
        }

        for (int y = ySize-1; y>=0 ; y--) {
            for (int x = 0; x <xSize ; x++) {
                retValue.append(graphBuffer[y][x]);
            }
            retValue.append("\n");
        }
        return retValue.toString();
    }
}
