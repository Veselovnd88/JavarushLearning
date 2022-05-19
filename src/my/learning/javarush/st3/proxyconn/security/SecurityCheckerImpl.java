package my.learning.javarush.st3.proxyconn.security;


public class SecurityCheckerImpl implements SecurityChecker {
    @Override
    public boolean performSecurityCheck() {
        System.out.println("SECURITY OK!");
        return true;
    }
}
