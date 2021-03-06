class ExpressionOperator extends ExpressionElement implements Comparable<ExpressionOperator> {
    public static final ExpressionOperator OP_PLUS = new ExpressionOperator(ExpressionElement.PLUS);
    public static final ExpressionOperator OP_MINUS = new ExpressionOperator(ExpressionElement.MINUS);
    public static final ExpressionOperator OP_MULTIPLE = new ExpressionOperator(ExpressionElement.MULTIPLE) ;
    public static final ExpressionOperator OP_DIVIDE = new ExpressionOperator(ExpressionElement.DIVIDE);
    public static final ExpressionOperator OP_MOD = new ExpressionOperator(ExpressionElement.MOD);
    public static final ExpressionOperator OP_OR = new ExpressionOperator(ExpressionElement.OR);
    public static final ExpressionOperator OP_XOR = new ExpressionOperator(ExpressionElement.XOR);
    public static final ExpressionOperator OP_AND = new ExpressionOperator(ExpressionElement.AND);
    public static final ExpressionOperator OP_LEFT_SHIFT = new ExpressionOperator(ExpressionElement.LEFT_SHIFT);
    public static final ExpressionOperator OP_RIGHT_SHIFT = new ExpressionOperator(ExpressionElement.RIGHT_SHIFT); 
    private final int priority;

    private ExpressionOperator(String content) {
        super(content);

        if(!isLegalOperator(content))
            throw new IllegalArgumentException("operator " + content + "is illegal");

        this.priority = operatorPriority.get(content) ;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(ExpressionOperator other) {
        return this.priority - other.priority;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj.getClass() != this.getClass())
            return false;

        ExpressionOperator other = (ExpressionOperator) obj;

        return content.equals(other.content);
    }
}
