package my.learning.javarush.st3.remot.sloc;


public class ServiceLocator {
    private static Cache cache;

    static {
        cache = new Cache();
    }

    /**
     * First, check for a service object in the cache
     * If a service object is not in the cache, perform a lookup using
     * the JNDI initial context and get the service object. Add it to
     * the cache for future use.
     *
     * @param jndiName The name of the service object in the context
     * @return Object mapped to the name in context
     */
    public static Service getService(String jndiName) {
        Service s;
        if((s=cache.getService(jndiName))!=null){
            return s;
        }
        else{
            InitialContext ic = new InitialContext();
            s = (Service) ic.lookup(jndiName);
            cache.addService(s);
            return s;
        }

    }
}
