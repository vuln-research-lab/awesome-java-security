CREATE ALIAS EXEC AS 'void shellexec(String cmd) throws java.io.IOException {Runtime.getRuntime().exec(cmd);}';
    CALL EXEC ('open -a Calculator.app')