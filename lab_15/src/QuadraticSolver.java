public class QuadraticSolver {
    
    private int _a;
    private int _b;
    private int _c;

    public QuadraticSolver() {
        _a = 1;
        _b = 1;
        _c = 1;
    }

    public QuadraticSolver(int a, int b, int c) throws QuadraticException
    {
        if (a == 0)
            throw new QuadraticException("Not a real quadratic");

        _a = a;
        _b = b;
        _c = c;

    }

    public double discriminant() {
        return _b*_b - 4 * _a * _c;
    }

    public boolean realSolution() {
        return discriminant() >= 0 ;
    }

    public double firstRoot() throws NonRealException {
        if (!realSolution())
            throw new NonRealException("no real solution");
        return (-1 * _b + discriminant()) / (2 * _a);
    }

    public double secondRoot() throws NonRealException{
        if (!realSolution())
            throw new NonRealException("no real solution");
        else
            return (-1 * _b - discriminant()) / (2 * _a);
    }

    public String toString() {
        return "f(x) = " + _a + "x^2 + " + _b + "x + " + _c;
    }
}
