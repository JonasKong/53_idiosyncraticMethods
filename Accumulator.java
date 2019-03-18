/**
  Represent accumulating data from the elements in a
  List_inArraySlots that are of a particular type.
 */

public class Accumulator {
	/**
      @return the concatenation of all the Strings
      in the \list that begin with \prefix,
      each followed by a space.
     */
    public static String catElementsStartingWith( List_inArraySlots list, String prefix) {
        String result = "";

        for( int el = 0; el < list.size(); el++){
            /* 3.  Stumbling block 0
               Java protects a programmer against applying a method to
               elements in list when some elements of the list might
               omit support for a particular operation.

               This protection is implemented by the compiler (compiler? JVM?)
               The following code violates the restriction:
              */
            // [code that violates the restriction]
			//if(list.get(el).startsWith(prefix)) result += list.get(el) + " ";
            /*
             predicted error message:
				error: cannot apply method to all elements of the array
             actual error message:
				error: cannot find symbol'/'
            */
			

            /* 4.  Workaround 0
               A programmer should expect there to be a way to
               work around the stumbling block, because
               the JVM (compiler? JVM?) knows the type of an element.

               Java's instanceof operator identifies the type
               of an element to the compiler (compiler? JVM?).
             */


            /* 5.  Stumbling block 1
               However, use of the operator alone is insufficient,
               because the compiler (compiler? JVM?)
               objects to the following code that adds use of
               the operator to the code from Stumbling block 0:
             */

            /* [code that illustrates the use of the operator]
			 if (list.get(el) instanceof String){
				 String s = list.get(el);
			*/

            /*
             predicted error message: incompatible type

             actual error message:
			 Accumulator.java:17: error: incompatible types: Object cannot be converted to String
                        String s =  list.get(el);
             */


            /* 6. Workaround 1
               Programmers use Java's casting operator
               to tell the compiler (compiler? JVM?)
               that code uses a subclass's method on an object,
               even though the reference to the object is stored
               in a super-class variable.
             */


            /* 7. Stumbling block 2
               However, use of this operator alone is insufficient,
               because the compiler(compiler? JVM?)
               objects to the following code that adds use of
               the operator to the code from Stumbling block 0:
             */

            // [code that illustrates the use of the operator]
			/*
			String s = (String) list.get(el);
			if(s.startsWith(prefix)) result +=  s + " ";
			*/
            /*
             predicted error message: incorrect data type

             actual error message:Exception in thread "main" java.lang.ClassCastException: java.base/java.lang.Double cannot be cast to java.base/java.lang.String
							     at Accumulator.catElementsStartingWith(Accumulator.java:16)
								 at UserOfList.main(UserOfList.java:32)

             */


            /* 8. Workaround 2
               A programmer can combine use of both operators
               to apply a method to exactly those
               elements in the list that support the method.
             */

			 // [working code here, finally]
			 if (list.get(el) instanceof String){
				 String s = (String) list.get(el);
				 if (s.startsWith(prefix)){
					 result += s+" ";
					 }
			 }
			 
			 }
        return result;
    }


    /**
      @return a list of each of the Double elements
      from the \list whose value is "finite".
     */
    // public static List_inArraySlots finites(
        // List_inArraySlots list
      // ) {
    // }
}
