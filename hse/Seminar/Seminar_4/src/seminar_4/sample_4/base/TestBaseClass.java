package seminar_4.sample_4.base;

/*
Java Language Spec. (e.g. 3d Edition and later):
        6.6.2 Details on protected Access

        A protected member or constructor of an object may be accessed from outside
        the package in which it is declared only by code that is responsible for the implementation
        of that object.

        6.6.2.1 Access to a protected Member

        Let C be the class in which a protected member m is declared. Access is permitted
        only within the body of a subclass S of C. In addition, if Id denotes an
        instance field or instance method, then:
        � If the access is by a qualified name Q.Id, where Q is an ExpressionName,
        then the access is permitted if and only if the type of the expression Q is S or a
        subclass of S.
        � If the access is by a field access expression E.Id, where E is a Primary
        expression, or by a method invocation expression E.Id(. . .), where E is a
        Primary expression, then the access is permitted if and only if the type of E is
        S or a subclass of S.
//*/


public class TestBaseClass {

    protected Object baseProtectedMethod(Object p){
        return p;
    }
    protected Object createObject(){
        return new Object();
    }
}
