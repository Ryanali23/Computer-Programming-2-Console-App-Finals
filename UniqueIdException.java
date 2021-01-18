public class UniqueIdException extends Exception{


    /**
     *
     */
    private static final long serialVersionUID = -6346733805998518368L;

    UniqueIdException() {
        super("ID SHOULD BE UNIQUE: Make sure to be consistent when storing in Database. \n Choose between AUTO INCREMENT STORE or DEFINE YOUR OWN ID");
    }
}
