public class GenericMethods {

    public <T, X> X fun(T data1, X data2) {
        return data2;
    }

    // <T,X> at the start for compiler to know that T and X will come at run time and
    // it should not flag this as error at compile stage.

    // if we tell compiler at the start of class declaration, then it's not required.
    // So, if signature of class is
    // public class GenericClass <T,X> {
    // then not required.
    // Note - this does not work for static methods.

}

