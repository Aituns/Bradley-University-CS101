public class Magic {
    int _matrix[][] = { {1, 5, 9 }, 
                        {8, 3, 4 },
                        {6, 7, 2 }};;

    public Magic(int matrix[][]) {
        if(matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Not Square");
        } else {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    _matrix[i][j] = matrix[i][j];
                }
            }
        }
    }

    public boolean rowSemiMagic() {
        int rowSums[] = new int[_matrix.length];
        int sumRow;
        for (int i = 0; i < _matrix.length; i++) {
            sumRow = 0;
            for (int j = 0; j <_matrix[0].length; j++) {
                sumRow += _matrix[i][j];
                rowSums[i] = sumRow;
            }
        }
        for (int i = 0; i < rowSums.length; i++) {
            if (rowSums[0] != rowSums[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean columnSemiMagic() {
        int columnSums[] = new int[_matrix[0].length];
        int sumColumn;
        for (int i = 0; i < _matrix.length; i++) {
            sumColumn = 0;
            for (int j = 0; j <_matrix[0].length; j++) {
                sumColumn += _matrix[i][j];
                columnSums[i] = sumColumn;
            }
        }
        for (int i = 0; i < columnSums.length; i++) {
            if (columnSums[0] != columnSums[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean magic() {
        if (rowSemiMagic() && columnSemiMagic()) {
            return true;
        } else  {
            return false;
        }
    }
}
